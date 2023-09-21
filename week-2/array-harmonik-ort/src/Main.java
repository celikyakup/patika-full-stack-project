import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Array uzunluğu kaç olacak:");
        int n=input.nextInt();
        double [] arr= new double[n];
        double sum=0;

        for (int i=0;i<n;i++){
            System.out.print("Sayıyı giriniz:");
            arr[i]= input.nextInt();
            for (double j=1;j<=arr[i];j++){
                sum+=(1.0/j);
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Harmonik ortalama:"+n/sum);
    }
}