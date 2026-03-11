import java.util.*;

class AnalyticsDashboard {

    HashMap<String,Integer> pageViews = new HashMap<>();
    HashMap<String,Set<String>> uniqueVisitors = new HashMap<>();
    HashMap<String,Integer> sources = new HashMap<>();

    public void processEvent(String url,String userId,String source){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        uniqueVisitors.putIfAbsent(url,new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        sources.put(source,sources.getOrDefault(source,0)+1);
    }

    public void dashboard(){

        System.out.println("Top Pages");

        for(String url:pageViews.keySet()){
            System.out.println(url+" "+pageViews.get(url)+" views "+
                    uniqueVisitors.get(url).size()+" unique");
        }

        System.out.println("Traffic Sources");

        for(String s:sources.keySet()){
            System.out.println(s+" "+sources.get(s));
        }
    }

    public static void main(String[] args){

        AnalyticsDashboard a = new AnalyticsDashboard();

        a.processEvent("/news","user1","google");
        a.processEvent("/news","user2","facebook");
        a.processEvent("/sports","user3","direct");

        a.dashboard();
    }
}