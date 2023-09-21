import java.util.*;
public class Main {
    public static void main(String[] args) {
        double [] arr= new double[5];
        double sum=0;
        Scanner input=new Scanner(System.in);

        for (int i=0;i<arr.length;i++){
            System.out.print("Sayıyı giriniz:");
            arr[i]= input.nextInt();
            sum+=(1/(arr[i]));
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(sum);
    }
}