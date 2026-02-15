package ru.сourses.main;

import ru.сourses.math.AnyNumber;
import ru.сourses.math.Sumable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        {
            /*  double sum;
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
            }*/
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
            /* n = new AnyNumber(2);
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
            System.out.println("Сумма по третьей строке = " + sum);*/
            /*  Scanner scanner = new Scanner(System.in);
            System.out.println("Введите Х ");
            String x= scanner.nextLine();
            System.out.println("Введите Y ");
            String y= scanner.nextLine();

            double power = pow(x,y);
            System.out.println("X в степени Y ="+power);

            int c1=Integer.parseInt(x);
            int c2=Integer.parseInt(y);
            Point p1= new Point(c1,c2);
            System.out.println("awt.Point = "+p1);
            ru.сourses.geometry.Point p2= new ru.сourses.geometry.Point(c1+1,c2+1);
            System.out.println("ru.сourses.geometry.Point = "+p2);
*/
            /*   Fraction f1 = new Fraction(1, 2);
            Fraction f2 = f1.clone();
            System.out.println(f2.equals(f1));
            System.out.println(f2 == f1);*/
            /*Point p1 = new Point(1, 2);
            Point p2 = new Point(10, 20);
            Point p3 = new Point(100, 200);
            PolyLine l1 = new PolyLine (p1,p2,p3);
            PolyLine l2 = l1.clone();
            System.out.println(l2.equals(l1));
            System.out.println("l1 "+l1.toString());
            System.out.println("l2 "+l2.toString());
            System.out.println(l2 == l1);
       */
            Double sum = 0.0;
            List<Double> summand = new ArrayList<Double>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите команду");
            String str = scanner.nextLine();
            if (str.contains("java Sum ")) {
                summand = toNumbers(str);
                sum = getSum(summand);
            } else {
                System.out.println("Программа завершена");
            }
            System.out.println(sum);
        }

    }

    public static double getSum(List<Double> summand) {
        double sum = 0;
        for (int i = 0; i < summand.size(); i++) {
            double a = summand.get(i);
            sum += a;
        }
        return sum;
    }

    public static List<Double> toNumbers(String string) throws NumberFormatException {
        String str = string.substring(9);
        int spaceCount = 0;
        int i=0;
        List<String> textNumbers = new ArrayList();
        do {
            if (i == str.length() - 1 & str.charAt(i) == ' ') {i++;continue;}
            if (i <= str.length() - 1 & str.charAt(i) != ' ' & textNumbers.size() == spaceCount) {
                textNumbers.add(String.valueOf(str.charAt(i)));i++;
                continue;
            } else if(i <= str.length() - 1 & str.charAt(i) != ' ' & textNumbers.size() > spaceCount) {
                String a = textNumbers.get(spaceCount);
                a += (String.valueOf(str.charAt(i)));
                textNumbers.set(spaceCount, a); i++; continue;
            } else if (i <= str.length() - 1 & str.charAt(i) == ' ' & str.charAt(i + 1) != ' ') {
                spaceCount++; i++; continue;
            } i++;
        }
         while (i < str.length() );

        List<Double> summand = new ArrayList<>();
        boolean isDouble = true;
        String checkTextNumber;
        for (i = 0; i < textNumbers.size(); i++) {
            checkTextNumber = String.valueOf(textNumbers.get(i));
            if (isDouble == checkTextNumber.matches("-?\\d+(\\.\\d+)?")) {
                summand.add(Double.parseDouble(String.valueOf(textNumbers.get(i))));
                System.out.println(summand.get(summand.size() - 1));
            } else {
                summand.add(Double.valueOf(0));
                System.out.println("В позиции " + i + " было не число");
            }
        }
        return summand;
    }

}



