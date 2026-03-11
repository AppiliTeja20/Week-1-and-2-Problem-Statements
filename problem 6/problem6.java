import java.util.*;

class TokenBucket{

    int tokens;
    long lastRefill;

    TokenBucket(int max){
        tokens=max;
        lastRefill=System.currentTimeMillis();
    }
}

class RateLimiter{

    HashMap<String,TokenBucket> map = new HashMap<>();
    int limit = 5;

    public boolean check(String client){

        map.putIfAbsent(client,new TokenBucket(limit));

        TokenBucket t = map.get(client);

        if(t.tokens>0){
            t.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args){

        RateLimiter r = new RateLimiter();

        for(int i=0;i<7;i++){
            System.out.println(r.check("client1"));
        }
    }
}