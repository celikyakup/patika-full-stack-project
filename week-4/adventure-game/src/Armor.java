public class Armor {
    private int id;
    private String name;
    private int block;
    private int cost;

    public Armor(int id, String name, int block, int cost) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.cost = cost;
    }
    public static Armor[] armors(){
        Armor[] armorsList=new Armor[3];
        armorsList[0]=new Armor(1,"Hafif",1,15);
        armorsList[1]=new Armor(2,"Orta",3,25);
        armorsList[2]=new Armor(3,"Ağır",5,40);
        return armorsList;
    }
    public static Armor getArmObjByID(int id){
        for (Armor a :Armor.armors()){
            if (a.getId()== id){
                return a;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
