
public class Main {
    public static void main(String[] args) {
        Teacher t1=new Teacher("Mahmut Hoca","555","TRH");
        Teacher t2=new Teacher("Graham Bell","000","FZK");
        Teacher t3=new Teacher("Külyutmaz","533","MAT");
        Course tarih=new Course("Tarih","101","TRH");
        tarih.addTeacher(t1);
        Course fizik=new Course("Fizik","101","FZK");
        fizik.addTeacher(t2);
        Course mat=new Course("Matematik","101","MAT");
        mat.addTeacher(t3);

        Student s1=new Student("Yakup","4",tarih,fizik,mat,"123");
        s1.addBulkExamNote(80,50,15,70,85,60);
        s1.isPass();
        s1.printNote();
    }
}