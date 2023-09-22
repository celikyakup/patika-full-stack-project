import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Array boyutunu giriniz:");
        int n= input.nextInt();
        int [] arr=new int[n];
        for (int i=0;i<n;i++){
            System.out.print((i+1)+". elemanı giriniz:");
            int num= input.nextInt();
            arr[i]=num;
        }
        System.out.println("Array:"+Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.print("Sort:"+Arrays.toString(arr));
    }
}