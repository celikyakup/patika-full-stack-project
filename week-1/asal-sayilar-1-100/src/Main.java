class Main {
    public static void main(String[] args) {
        for(int i=1;i<=100;i++){
            int durum=1;

            for (int l=2;l<i;l++){
                if (i%l==0){
                    durum=0;
                    break;
                }
            }
            if(durum==1){
                System.out.println(i+" Asal sayıdır.");
            }
        }
    }
}

