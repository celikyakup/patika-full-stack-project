import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FixtureOperation {
    Scanner input=new Scanner(System.in);
    public void run(){
        boolean isTrue=true;
        while (isTrue){
            System.out.println("----- Takım fikstür oluşturucu -----");
            System.out.println("1 - Takım ekleme ");
            System.out.println("2 - Takım listeleme");
            System.out.println("3 - Fikstür oluşturma");
            System.out.println("0 - Çıkış yap");
            System.out.print("Yapmak istediğiniz işlemi seçiniz: ");
            int select=input.nextInt();
            switch (select){
                case 1->{
                    System.out.println("Takım ekleme");
                    inputTeam();
                }
                case 2->{
                    System.out.println("Takım listeleme");
                    printTeam();
                }
                case 3->{
                    System.out.println("Takım fikstür oluşturma");
                    createFixture();
                }
                case 0->{
                    System.out.println("Çıkış yapılıyor.");
                    isTrue=false;
                }
                default -> System.out.println("Yanlış tuşlama yaptınız. Tekrar giriş yapınız.");
            }
        }
    }
    public void inputTeam(){
        System.out.print("Kaç takım ekleyeceksiniz giriniz:");
        int num=input.nextInt();
        for (int i=0;i<num;i++){
            System.out.print("Takım isimlerini giriniz: ");
            String teamName=input.next();
            Team.teams.add(new Team(teamName));
        }
        System.out.println("Takımlar başarıyla eklendi.");
    }
    public void createFixture(){
        List<Team> fixture = new ArrayList<>();
        int teamNum=Team.teams.size();
        int totalRounds=teamNum-1;
        int matchesPerRound=teamNum/2;
        if (teamNum%2==0){
            for (int round = 0; round < totalRounds; round++) {
                System.out.println("Round " + (round + 1) + ":");
                for (int match = 0; match < matchesPerRound; match++) {
                    Team home = Team.teams.get((round + match) % (teamNum - 1));
                    Team away = Team.teams.get((teamNum - 1 - match + round) % (teamNum - 1));
                    if (match == 0) {
                        away = Team.teams.get(teamNum - 1);
                    }

                    System.out.println(home.getName() + " vs " + away.getName());

                    }
                }
            }
        else {
            for (int round = 0; round < totalRounds; round++) {
                System.out.println("Round " + (round + 1) + ":");
                for (int match = 0; match < matchesPerRound; match++) {
                    Team home = Team.teams.get((round + match) % teamNum);
                    Team away = Team.teams.get((teamNum - 1 - match + round) % teamNum);

                    System.out.println(home.getName() + " vs " + away.getName());

                }
                // Bay geçen takımı yazdır
                Team restingTeam = Team.teams.get(teamNum - 1);
                System.out.println(restingTeam.getName() + " vs bay" );;
            }
        }
    }
    public void printTeam(){
        for (Team t:Team.teams){
            System.out.println("- "+t.getName());
        }
    }
}
