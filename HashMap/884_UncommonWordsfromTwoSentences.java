//LeetCode URL - https://leetcode.com/problems/uncommon-words-from-two-sentences/description/

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> res = new LinkedList<>();
        HashMap<String,Integer> hmap = new HashMap<>();
        String[] s1_arr = s1.split(" ");
        String[] s2_arr = s2.split(" ");

        for(String s : s1_arr){
            hmap.computeIfAbsent(s, k -> 0);
            hmap.put(s, hmap.get(s) + 1);
        }

        for(String s : s2_arr){
            hmap.computeIfAbsent(s, k -> 0);
            hmap.put(s, hmap.get(s) + 1);
        }

        // Method 1: Using a for-each loop
        for (String key : hmap.keySet()) {
            if(hmap.get(key) == 1){
                res.add(key);
            }
        }

        // Method 2: Using an Iterator
        // System.out.println("\nUsing Iterator:");
        // Set<String> keys = map.keySet();
        // java.util.Iterator<String> iterator = keys.iterator();
        // while (iterator.hasNext()) {
        //     String key = iterator.next();
        //     System.out.println(key + ": " + map.get(key));
        // }
    // }
        return res.toArray(new String[res.size()]);
    }
}
