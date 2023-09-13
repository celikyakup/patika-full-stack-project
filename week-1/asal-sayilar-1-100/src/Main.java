class Main {
    public static void main(String[] args) {
// 1-100 arası sayıları yazdırmak için for loopuna aldık.
        for(int i=2;i<=100;i++){
// Sayıların asal sayı olup olmadığını belirlemek için durum değişkeni oluşturduk.
            int durum=1;
//for loopunda oluşturduğumuz sayıları kendinden önceki sayılara bölünüp bölünemeyeceğini test etmek için 2 den i sayıysına kadar çıktı veren for loopu oluşturduk.
            for (int l=2;l<i;l++){
// İ de oluşan değerlerinden asal sayıları bulabilmek için if koşulu oluşturduk.
                if (i%l==0){
                    durum=0;
                    break;
                }
            }
//Durumun 1 olduğu durumlarda sayılar asal olacağı için durum 1 olduğu i değerlerini yazdırdık.
            if(durum==1){
                System.out.println(i+" Asal sayıdır.");
            }
        }
    }
}

