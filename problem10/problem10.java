import java.util.*;

class MultiCache{

    HashMap<String,String> L1 = new HashMap<>();
    HashMap<String,String> L2 = new HashMap<>();
    HashMap<String,String> DB = new HashMap<>();

    public String getVideo(String id){

        if(L1.containsKey(id)){
            return "L1 HIT "+L1.get(id);
        }

        if(L2.containsKey(id)){
            String v=L2.get(id);
            L1.put(id,v);
            return "L2 HIT "+v;
        }

        if(DB.containsKey(id)){
            String v=DB.get(id);
            L2.put(id,v);
            return "DB HIT "+v;
        }

        return "Not Found";
    }

    public static void main(String[] args){

        MultiCache c = new MultiCache();

        c.DB.put("video1","Movie Data");

        System.out.println(c.getVideo("video1"));
        System.out.println(c.getVideo("video1"));
    }
}