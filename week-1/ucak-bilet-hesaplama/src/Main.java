import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Mesafeyi km cinsinden giriniz: ");
        float km= input.nextFloat();
        System.out.print("Yaşınızı giriniz: ");
        int yas=input.nextInt();
        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş): ");
        int tip=input.nextInt();

        double normalTutar=km*0.1;
        double yasIndirim,indirimTutar,toplamTutar;
        if (km>0&&yas>0){
            switch(tip){
                case 1->{
                    if (yas<12){
                        yasIndirim=normalTutar*0.5;
                        indirimTutar=normalTutar-yasIndirim;
                        System.out.println("Toplam Tutar: "+indirimTutar);
                    }
                    else if (yas<24){
                        yasIndirim=normalTutar*0.1;
                        indirimTutar=normalTutar-yasIndirim;
                        System.out.println("Toplam Tutar: "+indirimTutar);
                    }
                    else if (yas>65){
                        yasIndirim=normalTutar*0.3;
                        indirimTutar=normalTutar-yasIndirim;
                        System.out.println("Toplam Tutar:"+indirimTutar);
                    }
                    else{
                        System.out.println("Toplam Tutar:"+normalTutar);
                    }
                }
                case 2 ->{
                    if (yas<=12){
                        yasIndirim=normalTutar*0.5;
                        indirimTutar=normalTutar-yasIndirim;
                        toplamTutar=(indirimTutar*0.8)*2;
                        System.out.println("Toplam Tutar:"+toplamTutar);
                    }
                    else if(yas<24){
                        yasIndirim=normalTutar*0.1;
                        indirimTutar=normalTutar-yasIndirim;
                        toplamTutar=(indirimTutar*0.8)*2;
                        System.out.println("Toplam Tutar:"+toplamTutar);
                    }
                    else if(yas>65){
                        yasIndirim=normalTutar*0.3;
                        indirimTutar=normalTutar-yasIndirim;
                        toplamTutar=(indirimTutar*0.8)*2;
                        System.out.println("Toplam Tutar:"+toplamTutar);
                    }
                    else{
                        toplamTutar=(normalTutar*0.8)*2;
                        System.out.println("Toplam Tutar:"+toplamTutar);
                    }
                }
                default -> System.out.println("Hatalı giriş yaptınız.");
            }
        }
        else{
            System.out.println("Hatalı Giriş Yaptınız.");
        }
    }

}