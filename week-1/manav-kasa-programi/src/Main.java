import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Armut kaç kilo ? ");
        float armut=input.nextFloat();
        System.out.print("Elma kaç kilo? ");
        float elma=input.nextFloat();
        System.out.print("Domates kaç kilo? ");
        float domates=input.nextFloat();
        System.out.print("Muz kaç kilo? ");
        float muz=input.nextFloat();
        System.out.print("Patlıcan kaç kilo? ");
        float patlican=input.nextFloat();

        double elmakg=3.67;
        double armutkg=2.14;
        double domateskg=1.11;
        double muzkg=0.95;
        double patlicankg=5;

        double totalPrice= (armutkg*armut)+(elmakg*elma)+(domateskg*domates)+(muzkg*muz)+(patlicankg*patlican);
        System.out.println("Toplam tutar: "+totalPrice);
    }
}