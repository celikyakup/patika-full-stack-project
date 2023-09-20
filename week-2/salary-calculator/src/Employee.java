public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYears;

    public Employee(String name,double salary,int workHours,int hireYears){
        this.name=name;
        this.salary=salary;
        this.workHours=workHours;
        this.hireYears=hireYears;
    }
    public double tax(){
        if (this.salary<1000){
            return 0;
        }
        else {
            return this.salary*0.03;
        }
    }
    public double bonus(){
        int ekstraSaat=this.workHours-40;
        if (this.workHours>40){
            return ekstraSaat*30;
        }
        else {
            return 0;
        }
    }
    public double raiseSalary(){
        if (2021-this.hireYears<10){
            return this.salary*0.05;
        } else if (2021-this.hireYears>9 && 2021-this.hireYears<20) {
            return this.salary*0.1;
        }else {
            return this.salary*0.15;
        }
    }
    @Override
    public String toString() {
        return "Adı:" + name + "\nMaaşı:" + salary + "\nÇalışma saati:"+ workHours+"\nBaşlangıç Yılı:"+hireYears+"\nVergi:"+tax()+"\nBonus:"+bonus()+"\nMaaş artışı:"+raiseSalary()
                +"\nVergi ve bonuslar ile birlikte maaş:"+(salary+bonus()-tax())+"\nToplam Maaş:"+(salary+raiseSalary());
    }
}

