import java.util.*;
public class Main {
    public static boolean isFind(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Array uzunluğu:");
        int n = input.nextInt();
        int[] arr = new int[n];
        int[] duplicate = new int[n];
        int startIndex = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + ". sayıyı giriniz:");
            int num = input.nextInt();
            arr[i] = num;
        }
        for(int i=0; i<arr.length; i++){
            int counter = 1;
            while(i+1<arr.length && arr[i]==arr[i+1]){
                i++;
                counter++;
            }
            System.out.println(arr[i] + " sayısı " + counter + " kere tekrar edildi.");
        }
    }
}






