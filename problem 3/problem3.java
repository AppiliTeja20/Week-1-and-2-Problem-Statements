import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip,long ttl){
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl;
    }
}

class DNSCache {

    HashMap<String,DNSEntry> cache = new HashMap<>();

    public String resolve(String domain){

        if(cache.containsKey(domain)){
            DNSEntry e=cache.get(domain);

            if(System.currentTimeMillis()<e.expiry){
                return "Cache HIT "+e.ip;
            }
        }

        String ip="172.217.14."+new Random().nextInt(200);
        cache.put(domain,new DNSEntry(ip,5000));

        return "Cache MISS "+ip;
    }

    public static void main(String[] args){

        DNSCache d=new DNSCache();

        System.out.println(d.resolve("google.com"));
        System.out.println(d.resolve("google.com"));
    }
}