import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Metni giriniz: ");
        String str=input.nextLine();
        HashMap<Integer,String>worldsRepeat=new HashMap<>();
        String [] arr=str.split(" ");
        for (int i=0;i< arr.length;i++){
            int count=1;
            for (int j=i+1;j< arr.length;j++){
                if (arr[i].equals(arr[j])){
                    count++;
                }
            }
            worldsRepeat.put(count,arr[i]);
        }
        int maxKeyMap=Collections.max(worldsRepeat.keySet());
        for (Map.Entry<Integer,String> entry : worldsRepeat.entrySet()) {
            if (entry.getKey()==maxKeyMap) {
                System.out.println("En çok tekrar eden kelime : " + entry.getValue()+", tekrar edilme sayısı : "+ entry.getKey() );
            }
        }
    }
}