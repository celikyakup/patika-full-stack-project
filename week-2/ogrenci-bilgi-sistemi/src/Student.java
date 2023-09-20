public class Student {
    String name, classes, stuNO;
    Course course1, course2, course3;
    double average;
    boolean isPass;

    public Student(String name, String classes, Course course1, Course course2, Course course3, String stuNO) {
        this.name = name;
        this.classes = classes;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.stuNO = stuNO;
        this.average = 0;
        this.isPass = false;
    }

    public void addBulkExamNote(int note1, int note2, int note3,int sozlu1,int sozlu2,int sozlu3) {
        if (note1 >= 0 && note1 <= 100) {
            this.course1.note = note1;
        }
        if (sozlu1>=0 && sozlu1<=100){
            this.course1.sozlu=sozlu1;
        }
        if (note2 >= 0 && note2 <= 100) {
            this.course2.note = note2;
        }
        if (sozlu2>=0 && sozlu2<=100){
            this.course2.sozlu=sozlu2;
        }
        if (note3 >= 0 && note3 <= 100) {
            this.course3.note = note3;
        }
        if (sozlu3>=0 && sozlu3<=100){
            this.course3.sozlu=sozlu3;
        }
    }

    public void printNote() {
        System.out.println(course1.name + " dersi notunuz:" + course1.note);
        System.out.println(course2.name + " dersi notunuz:" + course2.note);
        System.out.println(course3.name + " dersi notunuz:" + course3.note);
        System.out.println("Ortalamanız:" + this.average);
    }

    public void isPass() {
        this.average = (((this.course1.note*0.8)+(this.course1.sozlu*0.2)) + ((this.course2.note*0.8)+(this.course2.sozlu*0.2)) + ((this.course3.note*0.8)+(this.course3.sozlu*0.2)))/3.0;
        if (this.average >= 55) {
            System.out.println("Sınıfı geçtiniz.");
        } else {
            System.out.println("Sınıfta kaldınız.");
        }
    }
}

