//Leetcode URL - https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description


class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        int[] maxCount = new int[1];
        backtrack(s, 0, set, maxCount);

        return maxCount[0];
    }

    //However, In optimization problems like this, the usual trick of pruning is not to do further work if you can't improve the current answer.
    //We check whether the current count of unique substrings, combined with the remaining characters in the string, can yield a higher count than what we have already found. If this total cannot exceed our maximum count, we return immediately, skipping unnecessary calculations. This step significantly reduces the number of recursive calls, especially for longer strings.

    void backtrack(String s, int index, HashSet<String> set, int[] maxCount){
        // Prune: If the current count plus remaining characters can't exceed maxCount, return
        if (set.size() + (s.length() - index) <= maxCount[0]) return;

        if(index == s.length()){
            maxCount[0] = Math.max(maxCount[0], set.size());
            return;
        }

        for(int i = index; i < s.length(); i++){
            String curr = s.substring(index, i + 1);

            if(set.contains(curr)){
                continue;
            }

            //include this and search for possible partitioning
            set.add(curr);
            // if(backtrack(s, i + 1, res, set)){
            //     return true;
            // }
            backtrack(s, i + 1, set, maxCount);

            //backtrack
            set.remove(curr);
        }

    }
}
