package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by menglihuan on 2017/4/9.
 */
public class EncodeandDecodeTinyURL {
    public static void main(String[] args) {
        String url="http://terrymenglhuan.com/";
        EncodeandDecodeTinyURL encodeandDecodeTinyURL=new EncodeandDecodeTinyURL();
       String encode= encodeandDecodeTinyURL.encode(url);
        System.out.println(encode);
        System.out.println(encodeandDecodeTinyURL.decode(encode));
    }
    Map<String,String> index= new HashMap<String,String>();
    Map<String,String> reIndex=new HashMap<String,String>();
    public  String encode(String url){
        if (reIndex.containsKey(url)) return url + reIndex.get(url);
        String set="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key=null;
        do{
            StringBuffer sb=new StringBuffer();
            for (int i=0;i<6;i++){
                int random=(int)(Math.random()*set.length());
                char randomchar=set.charAt(random);
                sb.append(randomchar);
            }
            key=sb.toString();
        }while (index.containsKey(key));
        index.put(key,url);
        reIndex.put(url,key);
        return  url+key;
    }
    public String decode(String url){
       int beforekey=url.lastIndexOf("/");
        System.out.println(beforekey);
        return index.get(url.substring(beforekey+1,url.length()));
    }
//    public class Codec {
//        List<String> urls = new ArrayList<String>();
//        // Encodes a URL to a shortened URL.
//        public String encode(String longUrl) {
//            urls.add(longUrl);
//            return String.valueOf(urls.size()-1);
//        }
//
//        // Decodes a shortened URL to its original URL.
//        public String decode(String shortUrl) {
//            int index = Integer.valueOf(shortUrl);
//            return (index<urls.size())?urls.get(index):"";
//        }
//    }

   /* public class Codec {
        Map<Integer, String> map = new HashMap<>();
        public String encode(String longUrl) {
            map.put(longUrl.hashCode(),longUrl);
            return "http://tinyurl.com/"+longUrl.hashCode();
        }
        public String decode(String shortUrl) {
            return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
        }
    }*/

}
