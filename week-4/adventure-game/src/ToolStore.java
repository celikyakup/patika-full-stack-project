public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz.");
        System.out.println("--------------------------------");
        System.out.println("1-Silahlar");
        System.out.println("2-Zırhlar");
        System.out.println("3-Çıkış");
        System.out.println("--------------------------------");
        System.out.print("Yapmak istediğiniz işlemi seçiniz:");
        int selectCase = Location.input.nextInt();
        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Yanlış değer girdiniz. Lütfen tekrar giriş yapınız:");
            selectCase = Location.input.nextInt();
        }
        switch (selectCase) {
            case 1 -> {
                printWeapon();
                buyWeapon();
            }
            case 2 -> {
                printArmor();
                buyArmor();
            }
            case 3 -> {
                System.out.println("Bir daha bekleriz.");
                return true;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("-------- Silahlar --------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " < Para : " + w.getCost() + " , Hasar : " + w.getDamage() + " >");
        }
        System.out.println("0 - Çıkış Yap");
    }
    public void buyWeapon() {
        System.out.println("--------------------------------");
        System.out.print("Bir silah seçiniz:");
        int selectWp = input.nextInt();
        while (selectWp < 0 || selectWp > Weapon.weapons().length) {
            System.out.println("Yanlış değer girdiniz tekrar giriniz:");
            selectWp = input.nextInt();
        }
        if (selectWp!=0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWp);
            if (selectedWeapon != null) {
                if (selectedWeapon.getCost() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {
                    System.out.println(selectedWeapon.getName() + "silahını satın aldınız.");
                    int newBalance = this.getPlayer().getMoney() - selectedWeapon.getCost();
                    this.getPlayer().setMoney(newBalance);
                    System.out.println("Kalan bakiyeniz: " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }
    public void printArmor () {
        System.out.println("-------- Zırhlar --------");
        for (Armor a: Armor.armors()){
            System.out.println(a.getId() + " - "
                    + a.getName() + " < Para : " + a.getCost()
                    + " , Zırh : "
                    + a.getBlock() + " >");
        }
        System.out.println("0 - Çıkış Yap");
    }
    public void buyArmor() {
        System.out.println("--------------------------------");
        System.out.print("Bir zırh seçiniz: ");
        int selectArmor = input.nextInt();
        while (selectArmor < 0 || selectArmor > Armor.armors().length) {
            System.out.println("Yanlış değer girdiniz tekrar giriniz:");
            selectArmor = input.nextInt();
        }
        if (selectArmor != 0) {
            Armor selectedArmors = Armor.getArmObjByID(selectArmor);
            if (selectedArmors != null) {
                if (selectedArmors.getCost() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {
                    System.out.println(selectedArmors.getName() + "zırhını satın aldınız.");
                    int newBalance = this.getPlayer().getMoney() - selectedArmors.getCost();
                    this.getPlayer().setMoney(newBalance);
                    System.out.println("Kalan bakiyeniz: " + this.getPlayer().getMoney());
                    System.out.println("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmors);
                    System.out.println("Yeni zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }
}


