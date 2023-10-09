import java.util.*;
public class Main {
    public static void printArrayIndex(String [] arr,int indexNum){
        System.out.println("Array'in "+indexNum+". index değeri "+arr[indexNum]);
    }
    public static void main(String[] args) {
        String [] arr= {"a","b","c","dd","eee","f","ggg","avc","asd","10"};
        Scanner input=new Scanner(System.in);
        System.out.println("Array: "+ Arrays.stream(arr).toList());
        System.out.print("Arrayın görmek istediğiniz index numarasını giriniz:");

        try {
            int indexNum=input.nextInt();
            printArrayIndex(arr,indexNum);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println("Farklı bir index numarası girişi yapınız!!");
        }
        catch (InputMismatchException e){
            System.out.println("Sayı girmen gereken yere farklı bir değer girdin!!");
        }
    }
}