import java.util.Scanner;
import java.lang.Math;
class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        float height;
        float weight;

        System.out.print("Kilonuz(kg) :");
        weight=input.nextFloat();
        System.out.print("Boyunuz(m) :");
        height=input.nextFloat();
        double bodyMassIndex=weight/(Math.pow(height,2));

        if(bodyMassIndex<18.5){
            System.out.println(bodyMassIndex+ " İdeal kilonun altında");
        }
        else if(bodyMassIndex<=24.9){
            System.out.println(bodyMassIndex+" İdeal kilodasın");
        }
        else if(bodyMassIndex<=29.9){
            System.out.println(bodyMassIndex+" İdeal kilonun üstündesin.");
        }
        else if(bodyMassIndex<=39.9){
            System.out.println(bodyMassIndex+" Ideal kilonun çok üstünde");
        }
        else{
            System.out.println(bodyMassIndex+" Ideal kilonun çok üstünde (morbid obez)");
        }
    }
}