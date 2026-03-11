import java.util.*;

class InventoryManager {

    HashMap<String,Integer> stock = new HashMap<>();
    HashMap<String,Queue<Integer>> waiting = new HashMap<>();

    public void addProduct(String id,int count){
        stock.put(id,count);
        waiting.put(id,new LinkedList<>());
    }

    public String checkStock(String id){
        return stock.getOrDefault(id,0)+" units available";
    }

    public String purchase(String id,int user){
        int s=stock.getOrDefault(id,0);

        if(s>0){
            stock.put(id,s-1);
            return "Success "+(s-1)+" units remaining";
        }else{
            waiting.get(id).add(user);
            return "Added to waiting list position "+waiting.get(id).size();
        }
    }

    public static void main(String[] args) {

        InventoryManager m = new InventoryManager();

        m.addProduct("IPHONE15",100);

        System.out.println(m.checkStock("IPHONE15"));
        System.out.println(m.purchase("IPHONE15",123));
        System.out.println(m.purchase("IPHONE15",456));
    }
}