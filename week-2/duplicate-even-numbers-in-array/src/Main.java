import java.util.*;
public class Main {

    public static boolean isFind(int [] array,int num){
        for (int i: array){
            if (i==num){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Array kaç elemanlı olacak belirtiniz:");
        int n= input.nextInt();
        int [] arr=new int[n];
        for (int i=0;i<n;i++){
            System.out.print((i+1)+". sayıyı giriniz:");
            int num= input.nextInt();
            arr[i]=num;
        }
        System.out.println(Arrays.toString(arr));
        int[] duplicate= new int[arr.length];
        int startIndex=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i !=j && arr[i]==arr[j]){
                    if (arr[i]%2==0){
                        if (!isFind(duplicate,arr[i])){
                            duplicate[startIndex++]=arr[i];
                        }
                    }
                    break;
                }
            }
        }
        for (int value:duplicate){
            if(value!=0){
                System.out.print(value+" ");
            }
        }
    }
}