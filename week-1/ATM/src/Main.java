import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        double balance=0;
        int bloke=3;
        int select;
        while (bloke>0) {
            System.out.print("Kullanıcı adınızı giriniz:");
            String userName= input.nextLine();
            System.out.print("Şifrenizi giriniz:");
            String password=input.nextLine();
            if (userName.equals("ycelik")  && password.equals("yakup")) {
                System.out.println("Giriş yapılıyor.");
                do {
                    System.out.println("1-Para yatırma\n" +
                            "2-Para Çekme\n" +
                            "3-Bakiye Sorgula\n" +
                            "4-Çıkış Yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                    select = input.nextInt();
                    switch (select) {
                        case 1 -> {
                            System.out.print("Yatırılacak para miktarını giriniz:");
                            int price = input.nextInt();
                            balance += price;
                            System.out.println("Hesabınızdaki para mikari "+balance+ " Tl'dir.");
                        }
                        case 2 -> {
                            System.out.print("Çekilecek para miktarını giriniz:");
                            int price = input.nextInt();
                            if (price > balance) {
                                System.out.println("Hesaptaki para miktarınız yetersiz.");
                            } else {
                                balance -= price;
                                System.out.println("Hesaptaki para miktarınız "+balance+" TL'dir.");
                            }
                        }
                        case 3 ->{
                            System.out.println("Bakiyeniz " + balance);
                        }
                    }
                } while (select!=4);
                System.out.println("Sistemden çıkış yapılıyor...");
                break;
            }
            else {
                bloke--;
                System.out.println("Yanlış giriş yaptınız.");
                if (bloke==0){
                    System.out.println("Kartınız bloke olmuştur. Bankanız ile iletişime geçiniz.");
                }
                else {
                    System.out.println(bloke+" Hakkınız kaldı.");
                }
            }
        }
    }
}