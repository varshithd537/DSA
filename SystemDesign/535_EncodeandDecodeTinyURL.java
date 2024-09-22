//LeetCode URL - https://leetcode.com/problems/encode-and-decode-tinyurl/description/

public class Codec {

    HashMap<String, String> decoded_map = new HashMap<>();
    HashMap<String, String> encoded_map = new HashMap<>();
    static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    //good way to get a random series of characters
    private String getCode() {
        char[] code = new char[6];
        for (int i = 0; i < 6; i++) 
            code[i] = chars.charAt((int)(Math.random() * 62));
        return "http://tinyurl.com/" + String.valueOf(code);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(encoded_map.containsKey(longUrl)){
            return encoded_map.get(longUrl);
        }

        String code = getCode();
        while(decoded_map.containsKey(code)){
            //if its already encoded a same tiny url, do this till you get unique one.
            code = getCode();
        }

        encoded_map.put(longUrl, code);
        decoded_map.put(code, longUrl);

        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decoded_map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
