//LeetCode URL - https://leetcode.com/problems/hand-of-straights/

Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //Did not understand @lee215's solution!!!
        //https://leetcode.com/problems/hand-of-straights/solutions/135598/C++JavaPython-O(MlogM)-Complexity
        //https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/solutions/470238/java-c-python-exactly-same-as-846-hand-of-straights/comments/518325

        
        boolean res = true;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int h : hand){
            if(hmap.containsKey(h)){
                hmap.put(h, hmap.get(h) + 1);
            }
            else{
                hmap.put(h,1);
                pq.add(h);
            }
        }

        while(!pq.isEmpty()){
            int start = pq.peek(); // --starting with the minimum number

            for(int i = start; i < start + groupSize; i++){
                if(!hmap.containsKey(i)){
                    return false;
                }
                int temp = hmap.get(i);
                temp--;
                if(temp == 0){
                    if(i != pq.peek()){ //----if removing element that is not smallest at that state ---means not all can be grouped
                        return false;
                    }
                    hmap.remove(i);
                    pq.poll();
                }
                else{
                    hmap.put(i, temp);
                }
            }
        }

        return true;
    }
}
