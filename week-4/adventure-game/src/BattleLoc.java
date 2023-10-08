import java.util.Random;

public abstract class BattleLoc extends Location {
    Random r = new Random();
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNum = randomObsNum();
        System.out.println("Şu an buradasın: " + this.getName());
        System.out.println("Dikkatli ol.Burada " + obsNum + " tane " + this.getObstacle().getName() + " yaşıyor.");
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = input.next();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S") && combat(obsNum)) {
            System.out.println(this.getName() + "'daki tüm düşmanları yendiniz.");
            if (this.getObstacle().getId()!=4){
                this.getPlayer().getInventory().onAward(1);
                System.out.println(this.getName()+" mapi ödülü kazandınız: "+this.getAward());
            }
            if (this.getPlayer().getInventory().getAward()==3){
                System.out.println();
                System.out.println("Tüm ganimetleri topladınız.");
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz!!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNum) {
        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
        for (int i = 1; i <= obsNum; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("<V>ur veya <K>aç:");
                String selectCombat = input.next().toUpperCase();
                if (selectCombat.equals("V")) {
                    if (randomHitNum() > 50) {
                        System.out.println("Siz vurdunuz");
                        this.obstacle.setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar sana vurdu.");
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        System.out.println("Canavar sana vurdu.");
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                        if (getPlayer().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavara vurdunuz.");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }
                } else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı yendiniz.");
                if (!getObstacle().getName().equals("Yılan")) {
                    System.out.println(this.getObstacle().getAward() + " para ödülünü kazandınız!!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                    System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
                }
                else {
                    randomItemsCoal();
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println();
        System.out.println(i + "." + getObstacle().getName() + " Statları");
        System.out.println("----------------");
        System.out.println("Sağlık: " + getObstacle().getHealth());
        System.out.println("Hasar: " + getObstacle().getDamage());
        System.out.println("Ödül: " + getObstacle().getAward());
    }

    public void playerStats() {
        System.out.println();
        System.out.println("Karakter Statları");
        System.out.println("-----------------");
        System.out.println("Sağlık: " + getPlayer().getHealth());
        System.out.println("Silah: " + getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh: " + getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: " + getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Damage: " + getPlayer().getTotalDamage());
        System.out.println("Para: " + getPlayer().getMoney());
    }

    public int randomObsNum() {
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public int randomHitNum() {
        return r.nextInt(100);
    }

    public void randomItemsCoal() {
        Weapon awardWeapon = Weapon.getWeaponObjByID(randomItems());
        Armor awardArmor = Armor.getArmObjByID(randomItems());
        int randomNum = r.nextInt(100);
        if (randomNum >= 0 && randomNum <= 14) {
            this.getPlayer().getInventory().setWeapon(awardWeapon);
            System.out.println(awardWeapon.getName()+" silahını kazandınız !!");
        }
        else if (randomNum >= 15 && randomNum <= 29) {
            this.getPlayer().getInventory().setArmor(awardArmor);
            System.out.println(awardArmor.getName() + " zırh kazandınız !");
        }
        else if(randomNum >=30&&randomNum <=45) {
            this.getPlayer().setMoney(this.getPlayer().getMoney() + randomMoney());
            System.out.println(randomMoney() + " para kazandınız.");

        }
        else {
            System.out.println("Üzgünüm burada hiçbir şey yok !!!");
        }
    }
    public int snakeDamage(){
        if (this.getObstacle().getId()==4){
            int randomDamage=r.nextInt(4)+3;
            getObstacle().setDamage(randomDamage);
        }
        return getObstacle().getDamage();
    }
    public int randomItems(){
        int randomNum =r.nextInt(100);

        if (randomNum >= 0 && randomNum <= 19){
            return 3;
        }else if (randomNum >= 20 && randomNum <= 49){
            return 2;
        }else if (randomNum >= 50 && randomNum < 100){
            return 1;
        }
        return 0;
    }
    public int randomMoney(){
        int randomNum = r.nextInt(100);
        if (randomNum >= 0 && randomNum <= 19){
            return 10;
        }else if (randomNum >= 20 && randomNum <= 49){
            return 5;
        }else if (randomNum >= 50 && randomNum < 100){
            return 1;
        }
        return 0;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
