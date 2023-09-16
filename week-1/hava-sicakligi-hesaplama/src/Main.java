import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Hava sıcaklığını giriniz:");
        float heat=input.nextFloat();

        if (heat<5){
            System.out.println("Kayak yapabilirsin.");
        }
        else if (heat>=5 && heat<=15){
            System.out.println("Film izleyebilirsin.");
        }
        else if (heat>15 && heat<=25){
            System.out.println("Piknik yapabilirsin");
        }
        else {
            System.out.println("Yüzmeye gidebilirsin.");
        }
    }
}