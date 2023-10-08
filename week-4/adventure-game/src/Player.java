import java.util.Scanner;
public class Player {
    private String charName,name;
    private int damage,health,money,originalHealth;
    Scanner input=new Scanner(System.in);
    private Inventory inventory;

    public Player( String name) {
        this.name = name;
        this.inventory=new Inventory();
    }
    public void selectChar(){
        Samurai samurai=new Samurai();
        Archer archer=new Archer();
        Knight knight=new Knight();
        System.out.println("-------------------------------------------------------------");
        System.out.println("ID: "+samurai.getId()+"\t Karakter: "+samurai.getName()  +"\t Hasar: " +samurai.getDamage() + "\t Sağlık: "+samurai.getHealth() + "\t Para: "+ samurai.getMoney());
        System.out.println("ID: "+archer.getId()+"\t Karakter: "+archer.getName() + "\t Hasar: "+archer.getDamage()+"\t Sağlık: "+archer.getHealth() +"\t Para: "+archer.getMoney());
        System.out.println("ID: "+knight.getId()+"\t Karakter: "+knight.getName() + "\t Hasar: "+knight.getDamage()+"\t Sağlık: "+knight.getHealth() +"\t Para: "+knight.getMoney());
        System.out.println("-------------------------------------------------------------");
        System.out.print("Lütfen bir karakter seçiniz:");
        int selectChar=input.nextInt();
        switch (selectChar){
            case 1-> {
                initPlayer(new Samurai());
            }
            case 2->{
                initPlayer(new Archer());
            }
            case 3->{
                initPlayer(new Knight());
            }
            default -> {
                initPlayer(new Samurai());
            }
        }
        //System.out.println("Karakter "+this.getCharName()+ " Hasar "+ this.getDamage()+" can: "+this.getHealth()+" Money "+this.getMoney());
    }
    public void initPlayer(GameChar gamechar){
        this.setDamage(gamechar.getDamage());
        this.setHealth(gamechar.getHealth());
        this.setOriginalHealth(gamechar.getHealth());
        this.setMoney(gamechar.getMoney());
        this.setCharName(gamechar.getName());
    }
    public void printInfo(){
        System.out.println("Silahınız: "+this.getInventory().getWeapon().getName()
                +", Zırhın: "+this.getInventory().getArmor().getName()
                +", Block: "+this.getInventory().getArmor().getBlock()
                + ", Hasarınız: "+this.getTotalDamage()
                +", Canınız: "+this.getHealth()
                +", Para: "+this.getMoney());
    }
    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getTotalDamage(){return damage+ this.getInventory().getWeapon().getDamage();}
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
