import java.util.Scanner;
public class Main {
    static int toplama(int num1,int num2){
        return num1+num2;
    }
    static int cikarma(int num1,int num2){
        return num1-num2;
    }
    static int carpma(int num1,int num2){
        return num1*num2;
    }
    static int bolme(int num1,int num2){
        return num1/num2;
    }
    static int Alma(int num1,int num2){
        int sum=1;
        for (int i=1;i<=num2;i++){
            sum*=num1;
        }
        return sum;
    }
    static int factoriel(int num1){
        int sum=1,sum2=1;
        for (int i=1;i<=num1;i++){
            sum*=i;
        }
        return sum;
    }
    static int modAlma(int num1,int num2){
        return num1%num2;
    }
    static void AlanandCevre(int num1,int num2){
        System.out.println("Çevresi "+2*(num1+num2));
        System.out.println("Alanı "+num1*num2);
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int select;
        String menu = "1- Toplama İşlemi\n"
                + "2- Çıkarma İşlemi\n"
                + "3- Çarpma İşlemi\n"
                + "4- Bölme işlemi\n"
                + "5- Üslü Sayı Hesaplama\n"
                + "6- Faktoriyel Hesaplama\n"
                + "7- Mod Alma\n"
                + "8- Dikdörtgen Alan ve Çevre Hesabı\n"
                + "0- Çıkış Yap";
        System.out.println(menu);
        while (true){
            System.out.print("Yapmak istediğiniz işlemi tuşlayınız:");
            select=input.nextInt();
            if (select==0){
                break;
            }
            switch (select){
                case 1->{
                    System.out.print("1.Sayıyı giriniz:");
                    int num1= input.nextInt();
                    System.out.print("2. sayıyı giriniz:");
                    int num2=input.nextInt();
                    System.out.println(toplama(num1,num2));
                }
                case 2->{
                    System.out.print("1.Sayıyı giriniz:");
                    int num1= input.nextInt();
                    System.out.print("2. sayıyı giriniz:");
                    int num2=input.nextInt();
                    System.out.println(cikarma(num1,num2));
                }
                case 3 ->{
                    System.out.print("1.Sayıyı giriniz:");
                    int num1= input.nextInt();
                    System.out.print("2. sayıyı giriniz:");
                    int num2=input.nextInt();
                    System.out.println(carpma(num1,num2));
                }
                case 4 ->{
                    System.out.print("1.Sayıyı giriniz:");
                    int num1= input.nextInt();
                    System.out.print("2. sayıyı giriniz:");
                    int num2=input.nextInt();
                    System.out.println(bolme(num1,num2));
                }
                case 5 ->{
                    System.out.print("1.Sayıyı giriniz:");
                    int num1= input.nextInt();
                    System.out.print("2. sayıyı giriniz:");
                    int num2=input.nextInt();
                    System.out.println(Alma(num1,num2));
                }
                case 6->{
                    System.out.print("Sayıyı giriniz:");
                    int num1= input.nextInt();
                    System.out.println(factoriel(num1));
                }
                case 7->{
                    System.out.print("1.Sayıyı giriniz:");
                    int num1= input.nextInt();
                    System.out.print("2. sayıyı giriniz:");
                    int num2=input.nextInt();
                    System.out.println(modAlma(num1,num2));
                }
                case 8->{
                    System.out.print("1.Sayıyı giriniz:");
                    int num1= input.nextInt();
                    System.out.print("2. sayıyı giriniz:");
                    int num2=input.nextInt();
                    AlanandCevre(num1,num2);
                }
                default -> {
                    System.out.println("Yanlış tuşlama yaptınız.");
                }
            }
        }


    }
}