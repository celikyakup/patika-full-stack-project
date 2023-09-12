import java.util.Scanner;
import java.lang.*;
class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Kaç sayı gireceksiniz belirtiniz:");
        int adet= input.nextInt();
        int arr[]=new int[adet];
        int enkucuk=0;
        int enbuyuk=0;

        System.out.println(adet+" tane sayıyı giriniz:");
        for (int i=0;i<arr.length;i++){
            arr[i]=input.nextInt();
            if(arr[i] > enbuyuk || enbuyuk==0) {
                enbuyuk = arr[i];
            }
            if(arr[i]<enkucuk || enkucuk==0){
                enkucuk=arr[i];
            }
        }
        System.out.println("Maksimum değer: "+enbuyuk);
        System.out.println("Minimum değer: "+enkucuk);
    }
}