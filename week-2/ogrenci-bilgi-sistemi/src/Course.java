public class Course {
    Teacher courseTeacher;
    String name;
    String prefix;
    String code;
    double note;
    double sozlu;
    String teacher;
    public Course(String name,String code, String prefix){
        this.name=name;
        this.code=code;
        this.prefix=prefix;
        this.note=0;
        this.sozlu=0;
    }
    public void addTeacher(Teacher t) {
        if (this.prefix.equals(t.branch)) {
            this.courseTeacher = t;
            System.out.println("İşlem başarılı");
        } else {
            System.out.println(t.name + " bu dersi veremez.");
        }
    }
    public void printTeacher(){
        if (courseTeacher!=null){
            System.out.println(this.name+" dersinin akademisyeni "+courseTeacher.name);
            }
        else {
            System.out.println(this.name+" dersine akademisyen atanmamıştırç");
        }
    }
}


