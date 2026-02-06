import java.sql.Array;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        {
            int q1, q2, q3, q4;
            double sumLengthOfLines;
            Point[] t;
            Line[] lines;

            Point d1 = new Point(1, 5);
            Point d2 = new Point(2, 8);
            Point d3 = new Point(5, 3);
            Point d4 = new Point(8, 9);

            Line l0 = new Line(d1, d2);
            Line l1 = new Line(d2, d3);
            Line l2 = new Line(d3, d4);

            System.out.println("Исходная l0=" + l0.toString());
            System.out.println("Исходная l1=" + l1.toString());
            System.out.println("Исходная l2=" + l2.toString());

            PolyLine polyLine = new PolyLine(4);
            polyLine.setPoint(d1,0);
            polyLine.setPoint(d2,1);
            polyLine.setPoint(d3,2);
            polyLine.setPoint(d4,3);
            System.out.println("Ломаная линия=" + polyLine.toString());

            q1 = 12;
            q2 = 8;
            d2.setCoordinates(q1, q2);
            polyLine.setPoint(d2,1);
            // q3 = new Scanner(System.in).nextInt();
            // q4 = new Scanner(System.in).nextInt();
            // str =new Scanner(System.in).nextLine();
            // d3.setCoordinates(q3,q4);
            l0.setEnd(d2);
            l1.setStart(d2);

            System.out.println("Измененная l0=" + l0.toString());
            System.out.println("Измененная l1=" + l1.toString());
            System.out.println("Измененная l2=" + l2.toString());
            System.out.println("Измененная Ломаная линия=" + polyLine.toString());

            sumLengthOfLines = l0.getLength() + l1.getLength() + l2.getLength();
            System.out.println("Суммарная длина 3 линий= "+l0.getLength()+"+"+l1.getLength()+"+"+l2.getLength()+"="+sumLengthOfLines);

            lines = polyLine.getLines();
            System.out.println("Длина массива линий в ломаной= "+lines.length);

            System.out.println(polyLine.linesArraytoString(lines));

            System.out.println("Длина ломаной линии= " + polyLine.getLength());
            System.out.println("Результат сравнения= " + (polyLine.getLength() == sumLengthOfLines));
        }
    }
}
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


        /*  int x = 1;
        int y = 2;
        int z = 3;
        Point3D p0 = new Point3D(x, y, z);
        System.out.println(p0);
        NewString newString = new NewString("newStringnewStringnewStringnewString");
        Point p1 = new Point(1, 0);
        Point p2 = new Point(4, 3);
        Point p3 = new Point(7, 6);
        Point p4 = new Point(10, 9);

        Line l1 = new Line(p1, p4);
        PolyLine pl1 = new PolyLine(p1, p2, p3, p4);
        ClosedPolyLine cl1 = new ClosedPolyLine(pl1);
          System.out.println("Длина ломаной = "+pl1.getLength());
           System.out.println("Длина замкнутой линии = "+cl1.getLength());
        calcLength(pl1, cl1, newString);*/
        /*Fraction f=new Fraction(1231,199);
        System.out.println("f.intValue()= "+f.intValue());
        System.out.println("f.longValue()= "+f.longValue());
        System.out.println("f.floatValue()= "+f.floatValue());
        System.out.println("f.doubleValue()= "+f.doubleValue());
    }*/
        /*public static void calcLength(Measurable... measurables) {
        int size = measurables.length;
        double calculatedLength;
        for (int i = 0; i <= size - 1; i++) {
            calculatedLength = measurables[i].getLength();
            System.out.println("Длина " + measurables[i].getCustomName() + " =" + calculatedLength);
        }
    }
    */
        double sum = 0;
        AnyNumber n;
        Fraction f;
        n = new AnyNumber(2);
        sum = n.getSum(sum);
        System.out.println(sum);
        f = new Fraction(3, 5);
        sum = f.getSum(sum);
        System.out.println(sum);
        n = new AnyNumber(2.3);
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
