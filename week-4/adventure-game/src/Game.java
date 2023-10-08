import java.util.Scanner;
public class Game {
    Scanner input=new Scanner(System.in);
    public void start() {
        System.out.println("Oyun başladı.");
        System.out.print("Karakter adını giriniz:");
        String name = input.nextLine();
        Player player = new Player(name);
        System.out.println(player.getName() + " Hoşgeldin.Yeni bir maceraya atılmaya hazır nısın ?");
        System.out.println("Oyuna başlamak için karakter seçin:");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("\t\t\t\t\t\t\t Bolgeler");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1-Güvenli Ev --> Burası sizin için güvenli bir alan, tehlike yok!");
            System.out.println("2-Mağaza --> Silah veya zırh satın alabilirsin.");
            System.out.println("3-Mağara --> Zorlu düşmanlarla savaşıp ganimet <Yemek> ödülü toplayabilirsin!");
            System.out.println("4-Orman --> Zorlu düşmanlarla savaşıp ganimet <Odun> ödülü toplayabilirsin!");
            System.out.println("5-Nehir --> Zorlu düşmanlarla savaşıp ganimet <Su> ödülü toplayabilirsin!");
            System.out.println("6-Maden --> Zorlu düşmanlarla savaşıp ganimet <İtem veya para> ödüllerini toplayabilirsin!");
            System.out.println("0-Çıkış yap -->Oyunu sonladırmış olacaksın!!");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0 ->{
                    location=null;
                }
                case 1 -> {
                    location = new SafeHouse(player);
                }
                case 2 -> {
                    location = new ToolStore(player);
                }
                case  3 ->{
                    if (player.getInventory().getAward()==1){
                        System.out.println("Bu mapin ganimetini zaten aldınız. Tekrar giriş yapamassınız !!");
                        continue;
                    }
                    else {
                        location = new Cave(player);
                    }
                }
                case 4->{
                    if (player.getInventory().getAward()==2){
                        System.out.println("Bu mapin ganimetini zaten aldınız. Tekrar giriş yapamassınız !!");
                        continue;
                    }
                    else {
                        location = new Forest(player);
                    }
                }
                case 5 ->{
                    if (player.getInventory().getAward()==3) {
                        System.out.println("Bu mapin ganimetini zaten aldınız. Tekrar giriş yapamassınız !!");
                        continue;
                    }
                    location=new River(player);
                }
                case 6->{
                    location=new Coal(player);
                }
                default -> {
                    System.out.println("Lütfen geçerli bir bölge giriniz !!");
                    continue;
                }
            }
            if (location==null){
                System.out.println("Bu sisli ve karanlık dünyayı altemedin kaçtın!!");
                break;
            }
            if (!location.onLocation()){
                //System.out.println("GAME OVER");
                break;
            }

        }
    }
}
