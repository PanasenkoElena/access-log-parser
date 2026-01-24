import java.util.Arrays;
import java.util.Scanner;

public class Student {
   private final String name;
   private int[] grades;

    public Student(String name) {
       this.name =  name;
       this.grades = new int[0];
    }

    public Student(String name, int[] newGrades) {
        this.name = name;
        this.grades = newGrades;
    }

    public int[] getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        String string = this.name + ':' + ", grades=" + Arrays.toString(this.grades) + '}';
        return string;
    }

    public void addGrade() {
        Scanner scanner = new Scanner(System.in);
        int size = this.getGrades().length;
        int[] newGrades = new int[size + 1];
        for (int i = 0; i < size; i++) {
            newGrades[i] = this.grades[i];
        }
        System.out.println("введите Новую оценку в диапазоне от 2 до 5");
        for (int i = 0; i < 1; i++) {
            int g = scanner.nextInt();
            if (g > 1 && g < 6) {
                newGrades[size] = g;}
            else {
                System.out.println("введите Новую оценку в диапазоне от 2 до 5");
                i--;
            }
        }
        this.grades =newGrades;
    }

}
