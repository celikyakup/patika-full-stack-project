import java.util.Random;
public class Snake extends Obstacle{
    public Snake(){
        super(4,"Yılan",0,12,0);
        Random r = new Random();
        int randomDamages = r.nextInt(4) + 3;
        super.setDamage(randomDamages);
    }
}
