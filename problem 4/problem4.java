import java.util.*;

class PlagiarismDetector {

    HashMap<String, Set<String>> map = new HashMap<>();

    public List<String> getNgrams(String text,int n){

        String[] words=text.split(" ");
        List<String> grams=new ArrayList<>();

        for(int i=0;i<=words.length-n;i++){

            StringBuilder sb=new StringBuilder();

            for(int j=0;j<n;j++){
                sb.append(words[i+j]).append(" ");
            }

            grams.add(sb.toString().trim());
        }

        return grams;
    }

    public void addDocument(String id,String text){

        List<String> grams=getNgrams(text,5);

        for(String g:grams){

            map.putIfAbsent(g,new HashSet<>());
            map.get(g).add(id);
        }
    }

    public int similarity(String text){

        List<String> grams=getNgrams(text,5);
        int count=0;

        for(String g:grams){
            if(map.containsKey(g)){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args){

        PlagiarismDetector p=new PlagiarismDetector();

        p.addDocument("essay1","this is a sample essay for plagiarism detection system");

        int result=p.similarity("this is a sample essay for testing");

        System.out.println("Matching grams "+result);
    }
}