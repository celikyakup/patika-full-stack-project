public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int cost;
    public Weapon(int id,String name,int damage,int cost){
        this.id=id;
        this.name=name;
        this.damage=damage;
        this.cost=cost;
    }
    public static Weapon[] weapons(){
        Weapon[] weaponList=new Weapon[3];
        weaponList[0]=new Weapon(1,"Tabanca",2,5);
        weaponList[1]=new Weapon(2,"Kılıç",3,35);
        weaponList[2]=new Weapon(3,"Tüfek",7,45);
        return weaponList;
    }
    public static Weapon getWeaponObjByID(int id){
        for (Weapon w :Weapon.weapons()){
            if (w.getId()== id){
                return w;
            }
        }
        return null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
