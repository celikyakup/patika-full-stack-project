import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Kullanıcı adı:");
        String id= input.nextLine();
        System.out.print("Şifre:");
        String password=input.nextLine();
        String userPassword="Yakup1.a";
        if (id.equals("ycelik")&&password.equals(userPassword)){
            System.out.println("Giriş yapılıyor...");
        }
        else {
            System.out.println("Kullanıcı adı veya şifre hatalı.");
            System.out.print("Şifre sıfırlamak ister misiniz(e/h):");
            String sifirlama=input.next();

            switch (sifirlama){
                case "e" -> {
                    System.out.print("Yeni şifreyi giriniz:");
                    String newUserPassword = input.next();
                    System.out.print("Yeni şifreyi tekrar giriniz:");
                    String repeatNewUserPassword = input.next();
                    if (newUserPassword.equals(repeatNewUserPassword)) {
                        if (newUserPassword.equals(userPassword)) {
                            System.out.println("Şifreniz eski şifrenizle aynı olamaz.");
                        } else {
                            System.out.println(("Şifreniz oluşturuldu"));
                        }
                    }
                    else {
                        System.out.println("Şifreler uyuşmuyor.");
                    }
                }
                case "h" ->{
                    System.out.println("Şifre sıfırlamanmıyor.");
                }
                default -> {
                    System.out.println("Yanlış tuşlama yaptınız.");
                }
            }
        }
        }
    }
