//Leetcode URL - https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

//Note: This question is the same as 846: https://leetcode.com/problems/hand-of-straights/


class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        //Optimal solution - modified in Q - 846. Hand of Straights
        boolean res = true;
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        for(int num : nums){
            if(tmap.containsKey(num)){
                int temp = tmap.get(num);
                tmap.put(num, temp + 1);
            }
            else{
                tmap.put(num, 1);
            }
        }

        while(tmap.size() > 0){
            int curr = tmap.firstKey();
            int curr_val = tmap.get(curr);
            int count = 0;
            while(count < k){
                if(tmap.containsKey(curr)){
                    tmap.compute(curr, (key, value) -> value = value - 1);
                    if(tmap.get(curr) == 0){
                        tmap.remove(curr);
                    }
                    curr++;
                    count++;
                }
                else{
                    return false;
                }
            }
        }
        return res;
    }
}
