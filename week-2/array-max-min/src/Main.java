import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Array kaç indexli olacak belirtiniz:");
        int n= input.nextInt();

        int [] arr= new int[n];
        for (int i=0;i<n;i++){
            System.out.print("Array değerini giriniz:");
            int num= input.nextInt();
            arr[i]=num;
        }
        System.out.println("Array:"+Arrays.toString(arr));
        System.out.print("EN yakın değerleri bulunacak sayıyı girniz:");
        int a= input.nextInt();
        Arrays.sort(arr);
        int b=Arrays.binarySearch(arr,a);
        if (b==arr.length-1){
            System.out.println("Arrayda "+a+" sayısından daha büyük değer yok.");
            System.out.println(a+" sayısına küçük en yakın sayı "+arr[b-1]);
        }
        else if (b==0){
            System.out.println(a+" sayısına büyük en yakın sayı "+arr[b+1]);
            System.out.println("Arrayda "+a+" sayısından daha küçük değer yok.");
        }
        else {
            System.out.println(a + " sayısına büyük en yakın sayı " + arr[b + 1]);
            System.out.println(a + " sayısına küçük en yakın sayı " + arr[b - 1]);
        }
    }
}
