//Leetcode URL  - https://leetcode.com/problems/sentence-similarity-iii/description


class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() > sentence2.length()){
            return areSentencesSimilar(sentence2, sentence1);
        }

        //Can also use two queues to remove from the start and end of both the strings
        //comparing the prefixes and suffixes and removing them
        //if one of the string is completely removed then it is similar given the constraints.

        String[] words1 = sentence1.split(" "), words2 = sentence2.split(" ");
        int i = 0, n1 = words1.length, n2 = words2.length;
        int j1 = n1 - 1;
        int j2 = n2 - 1;

        while(i <= j1 && words1[i].equals(words2[i])){
            i++;
        }

        while(j1 >= 0 && words1[j1].equals(words2[j2])){
            j1--;
            j2--;
        }

        // If i reaches the end of the array, then we return true.
        if(i > j1){
            return true;
        }

        return false;
    }
}
