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
