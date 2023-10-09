import java.util.*;
public class Main {
    public static void main(String[] args) {
        String [] arr= {"a","b","c","dd","eee","f","ggg","avc","asd","10"};
        Scanner input=new Scanner(System.in);
        System.out.print("Arrayın görmek istediğiniz index numarasını giriniz:");

        try {
            int num=input.nextInt();
            System.out.println(arr[num]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Sayı germen gereken yere farklı bir değer girdin!!");
        }
    }
}