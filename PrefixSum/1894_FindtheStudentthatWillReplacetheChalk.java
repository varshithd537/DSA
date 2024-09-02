//LeetCode URL - https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk


class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        //Approach - 2 : Binary Search
        //Can search through the array for the point where it overflows - instead of traversing the whole array from start
        //Optmises the search function
        //uses the remaining chalk and prefix-sum array to find the exact index
        private int binarySearch(long[] psum, long rem) {
            int low = 0, high = psum.length - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (psum[mid] <= rem) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return high;
        }

        //Approach - 1 : Prefix Sum
        int n = chalk.length;
        long total = (long)chalk[0];
        for(int i = 1; i < n; i++){
            total += chalk[i];
        }

        long rem = k%total;

        //try to do BinarySearch here.
        for(int i = 0; i < n; i++){
            rem -= chalk[i];
            if(rem < 0){
                return i;
            }
        }
        return -1;
    }
}
