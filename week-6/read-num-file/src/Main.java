import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader file=new FileReader("src/number.txt");
            BufferedReader buffread=new BufferedReader(file);
            String line;
            int sum=0;
            while ((line=buffread.readLine())!=null){
                System.out.println(line);
                sum+=Integer.parseInt(line);
            }
            buffread.close();
            file.close();
            System.out.println("Toplam: "+sum);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}