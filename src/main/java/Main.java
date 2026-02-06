
import ru.сourses.math.AnyNumber;
import ru.сourses.math.Fraction;
import ru.сourses.students.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        {
            double sum; 
            AnyNumber n;
            Fraction f;
            String newName;
            int gradesNum = 0;
            Student newStudent = null;
            Scanner scanner = new Scanner(System.in);
            int[] initGrades = new int[gradesNum];
            System.out.println("Введите имя ");
            newName = scanner.nextLine();
            System.out.println("Сколько оценок будет укзано для студента? ");
            gradesNum = scanner.nextInt();
            int i = 0;
            System.out.println("Введите оценки от 2 до 5 ");
//заполнение массива оценок

            for (sum = 0; i < gradesNum; i++)
              
            //инициация Студента
            
                newStudent = new Student(newName, initGrades);
                System.out.println("Студент " + newStudent.toString());
            

            //добавление тому же студенту оценки
            newStudent.addGrade();
            System.out.println("Студент " + newStudent.toString());

            {
                int g = scanner.nextInt();
                if (g > 1 && g < 6) {
                    initGrades[i] = g;
                } else {
                    i -= 1;
                    System.out.println("введите оценку еще раз в диапазоне от 2 до 5");
                }
            }
            
             /*     
     int x = 1;
    int y = 2;
    int z = 3;
    ru.сourses.geometry.Point3D p0 = new ru.сourses.geometry.Point3D(x, y, z);
    System.out.println(p0);
    ru.сourses.math.NewString newString = new ru.сourses.math.NewString("newStringnewStringnewStringnewString");
    ru.сourses.geometry.Point p1 = new ru.сourses.geometry.Point(1, 0);
    ru.сourses.geometry.Point p2 = new ru.сourses.geometry.Point(4, 3);
    ru.сourses.geometry.Point p3 = new ru.сourses.geometry.Point(7, 6);
    ru.сourses.geometry.Point p4 = new ru.сourses.geometry.Point(10, 9);

    ru.сourses.geometry.Line l1 = new ru.сourses.geometry.Line(p1, p4);
    ru.сourses.geometry.PolyLine pl1 = new ru.сourses.geometry.PolyLine(p1, p2, p3, p4);
    ru.сourses.geometry.ClosedPolyLine cl1 = new ru.сourses.geometry.ClosedPolyLine(pl1);
      System.out.println("Длина ломаной = "+pl1.getLength());
       System.out.println("Длина замкнутой линии = "+cl1.getLength());
    calcLength(pl1, cl1, newString);*/
        /*ru.сourses.math.Fraction f=new ru.сourses.math.Fraction(1231,199);
        System.out.println("f.intValue()= "+f.intValue());
        System.out.println("f.longValue()= "+f.longValue());
        System.out.println("f.floatValue()= "+f.floatValue());
        System.out.println("f.doubleValue()= "+f.doubleValue());
    }
        public static void calcLength(ru.сourses.geometry.Measurable... measurables) {
        int size = measurables.length;
        double calculatedLength;
        for (int i = 0; i <= size - 1; i++) {
            calculatedLength = measurables[i].getLength();
            System.out.println("Длина " + measurables[i].getCustomName() + " =" + calculatedLength);
        }
    }*/
            
            
            n = new AnyNumber(2);
            sum = n.getSum(sum);
            System.out.println(sum);
            f = new  Fraction(3, 5);
            sum = f.getSum(sum);
            System.out.println(sum);
            n = new  AnyNumber(2.3);
            sum = n.getSum(sum);
            System.out.println("Сумма по первой строке = " + sum);

            sum = 0;
            n = new AnyNumber(3.6);
            sum = n.getSum(sum);
            System.out.println(sum);
            f = new Fraction(49, 12);
            sum = f.getSum(sum);
            System.out.println(sum);
            n = new AnyNumber(3);
            sum = n.getSum(sum);
            System.out.println(sum);
            f = new Fraction(3, 2);
            sum = f.getSum(sum);
            System.out.println("Сумма по второй строке = " + sum);
            
            sum = 0;
            f = new Fraction(1, 3);
            sum = f.getSum(sum);
            System.out.println(sum);
            n = new AnyNumber(1);
            sum = n.getSum(sum);
            System.out.println("Сумма по третьей строке = " + sum);
        }
    }

}

