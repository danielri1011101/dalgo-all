import qualified Data.Map as Map

-- Returns the maximum value that can be carried with items from
-- @1 with limiting weight @2.
badKnapsack :: [(Int, Int)] -> Int -> Int
badKnapsack _ n
  | n <= 0= 0
badKnapsack [] _= 0
badKnapsack ((wx, vx):wvs) maxW
  | maxW - wx < 0= badKnapsack wvs maxW
  | otherwise=
      let (v1, v2)= (vx + badKnapsack wvs (maxW - wx), badKnapsack wvs maxW)
      in if v1 > v2 then v1 else v2

-- Helper types and functions for a better version of Knapsack

type MMap= Map.Map
type KItem= (Int, Int)

mlookup :: Int -> MMap Int a -> Maybe a
mlookup= Map.lookup

knapsack :: Int -> [KItem] -> MMap Int Int
knapsack _ []= Map.fromList []
knapsack maxW (y:ys)
  | maxW <= 0= Map.fromList []
  | otherwise=
      let base= knapsackBase maxW y
      in snd (foldl go (maxW, base) ys)
      where
    go (weight, prev_row) item=
      (weight, knapsackRow weight item prev_row)

knapsackRow :: Int -> KItem -> MMap Int Int -> MMap Int Int
knapsackRow maxW (cw, cv) prev_row= Map.fromList (krw maxW (cw, cv) prev_row)
  where
krw wt _ _
  | wt <= 0= []
krw wt (cw, cv) prev_row
  | wt < cw=
      let prev_sol1= extract 0 (mlookup wt prev_row)
      in (wt, prev_sol1) : krw (wt-1) (cw, cv) prev_row
  | otherwise=
      let prev_sol1= extract 0 (mlookup wt prev_row)
          prev_sol2= extract 0 (mlookup (wt-cw) prev_row)
      in (wt, max prev_sol1 (prev_sol2 + cv)) : krw (wt-1) (cw, cv) prev_row

knapsackBase :: Int -> KItem -> MMap Int Int
knapsackBase maxW (w, v)= Map.fromList (kbs maxW (w, v))
  where
kbs maxW (w, v)
  | maxW <= 0= [(0,0)]
  | w > maxW= (maxW, 0) : kbs (maxW-1) (w,v)
  | otherwise= (maxW, v) : kbs (maxW-1) (w,v)

extract :: a -> Maybe a -> a
extract a0 Nothing= a0
extract _ (Just a)= a

-- Example from the book
exl_items= [(1,1), (2,6), (3,7), (5,18), (6,22), (7,28)]

exl_sol_map= knapsack 11 exl_items

exl_sol_value= extract 0 (mlookup 11 exl_sol_map)
