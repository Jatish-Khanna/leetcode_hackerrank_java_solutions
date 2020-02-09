

public class Solution {


    HashMap<String, String> mapping = new HashMap<>();
    //private static final String DNS = "http://tinyurl.com"
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String codec = Integer.toHexString(longUrl.hashCode());
        mapping.put(codec, longUrl);
        // append the DNS
        return codec;  
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mapping.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
