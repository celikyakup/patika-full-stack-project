import java.io.*;
import java.util.Scanner;
public class Main {
    public static void WriteFile(String str){
        try {
            FileWriter writeFile= new FileWriter("src/notlar.txt");
            PrintWriter writePrint=new PrintWriter(writeFile);
            writePrint.print(str);
            writePrint.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public static void ReadFile(){
        try {
            FileReader filereader = new FileReader("src/notlar.txt");
            BufferedReader buffRead = new BufferedReader(filereader);
            String line;
            while ((line = buffRead.readLine()) != null) {
                System.out.println(line);
            }
            buffRead.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ReadFile();
        Scanner input=new Scanner(System.in);
        System.out.print("Bir metin giriniz: ");
        String str=input.nextLine();
        WriteFile(str);

    }
}