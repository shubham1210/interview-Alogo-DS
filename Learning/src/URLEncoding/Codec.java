package URLEncoding;

import java.util.HashMap;

public class Codec {
    java.util.HashMap<Integer,String> urlHolderMap = new HashMap<>();
    String host = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        int hashcode = longUrl.hashCode();
        urlHolderMap.put(hashcode,longUrl);
        return host+hashcode;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String code = shortUrl.replace(host,"");

        int codeInt  = Integer.parseInt(code);

        return urlHolderMap.get(codeInt);


    }

    public static void main(String[] a)
    {
     Codec codec = new Codec();
     System.out.println(codec.encode("https://leetcode.com/problems/design-tinyurl"));

        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}

