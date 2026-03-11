import java.util.*;

class TwoSum{

    public static int[] find(int[] arr,int target){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){

            int comp = target-arr[i];

            if(map.containsKey(comp)){
                return new int[]{map.get(comp),i};
            }

            map.put(arr[i],i);
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args){

        int[] arr = {500,300,200};

        int[] res = find(arr,500);

        System.out.println(res[0]+" "+res[1]);
    }
}