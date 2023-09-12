import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double kdvTutar,kdv,toplamTutar;
        Scanner input=new Scanner(System.in);
        System.out.print("KDV'siz tutarı giriniz: ");
        double tutar=input.nextDouble();
        if (tutar>0){
            if(tutar<1000){
                kdvTutar=0.18;
                kdv= tutar*kdvTutar;
                toplamTutar= tutar+kdv;
                System.out.println("KDV'li tutar:"+toplamTutar);
            }
            else{
                kdvTutar=0.08;
                kdv=tutar*kdvTutar;
                toplamTutar=tutar+kdv;
                System.out.println(("KDV'li tutar:"+toplamTutar));
            }
        }
        else {
            System.out.println("0 dan küçük değer giremessiniz...");
        }
        }
    }
