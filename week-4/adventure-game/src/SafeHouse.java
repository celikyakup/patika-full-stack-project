public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player){
        super(player,"Güvenli Ev");
    }
    @Override
    public boolean onLocation(){
        System.out.println("Güvenli evdesiniz.");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        System.out.println("Canınız fullendi.");
        if (this.getPlayer().getInventory().getAward()==3){
            System.out.println("Oyunu kazandınız.");
            return false;
        }
        return true;
    }
}

