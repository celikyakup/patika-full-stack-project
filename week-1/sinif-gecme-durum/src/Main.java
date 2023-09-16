import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Matematik notunuz:");
        int mat= input.nextInt();
        System.out.print("Türkçe notunuz:");
        int turk=input.nextInt();
        System.out.print("fizik notunuz:");
        int fiz=input.nextInt();
        System.out.print("Kimya notunuz:");
        int kim=input.nextInt();
        System.out.print("Müzik notunuz:");
        int muz=input.nextInt();

        if(mat>=0 && mat<=100 && turk>=0 && turk<=100 && fiz>=0 && fiz<=100 && kim>=0 && kim<=100&& muz>=0 && muz<=100){
            int ort= (mat+turk+fiz+kim+muz)/5;
            String result= (ort>=55)?" Sınıfı geçtin":" Sınıfta kaldın";
            System.out.println("Ortalaman:"+ort+ result);
        }
        else {
            System.out.println("Yanlış değer veya değerler girdiniz...");
        }
    }
}