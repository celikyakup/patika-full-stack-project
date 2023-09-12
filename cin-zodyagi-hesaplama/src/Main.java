import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Doğum tarihini giriniz(Sadece yıl):");
        int year = input.nextInt();
        switch (year % 12) {
            case 0 -> {
                System.out.println("Çin zodyağı burcunuz: Maymun");
            }
            case 1 -> {
                System.out.println("Çin zodyağı burcunuz:Horoz");
            }
            case 2 -> {
                System.out.println("Çin zodyağı burcunuz: Köpek");
            }
            case 3 -> {
                System.out.println("Çin zodyağı burcunuz: Domuz");
            }
            case 4 -> {
                System.out.println("Çin zodyağı burcunuz: Fare");
            }
            case 5 -> {
                System.out.println("Çin zodyağı burcunuz: Öküz");
            }
            case 6 -> {
                System.out.println("Çin zodyağı burcunuz: Kaplan");
            }
            case 7 -> {
                System.out.println("Çin zodyağı burcunuz: Tavşan");
            }
            case 8 -> {
                System.out.println("Çin zodyağı burcunuz: Ejderha");
            }
            case 9 -> {
                System.out.println("Çin zodyağı burcunuz: Yılan");
            }
            case 10-> {
                System.out.println("Çin zodyağı burcunuz: At");
            }
            case 11 -> {
                System.out.println("Çin zodyağı burcunuz: Koyun");
            }

        }
    }
}