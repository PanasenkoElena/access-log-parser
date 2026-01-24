import java.sql.Array;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        {
            String newName;
            int gradesNum;
            Student newStudent;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя ");
            newName = scanner.nextLine();
            System.out.println("Сколько оценок будет укзано для студента? ");
            gradesNum = scanner.nextInt();
            int[] initGrades = new int[gradesNum];
            System.out.println("Введите оценки от 2 до 5 ");
//заполнение массива оценок
            for (int i = 0; i < gradesNum; i++) {
                int g = scanner.nextInt();
                if (g > 1 && g < 6) {
                    initGrades[i] = g;
                } else {
                    i -= 1;
                    System.out.println("введите оценку еще раз в диапазоне от 2 до 5");
                }
            }
            //инициация Студента
            newStudent = new Student(newName,initGrades);
            System.out.println("Студент "+newStudent.toString());

            //добавление тому же студенту оценки
            newStudent.addGrade();
            System.out.println("Студент "+newStudent.toString());
        }
    }
}


