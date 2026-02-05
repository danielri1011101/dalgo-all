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

mlookup :: String -> MMap String a -> Maybe a
mlookup= Map.lookup

type KItem= (Int, Int, String)

type KMemo= (MMap String Bool, MMap String Int)
