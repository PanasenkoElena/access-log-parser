import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*  int x = 1;
        int y = 2;
        int z = 3;
        Point3D p0 = new Point3D(x, y, z);
        System.out.println(p0);*/

        Point p1 = new Point(1, 0);
        Point p2 = new Point(4, 3);
        Point p3 = new Point(7, 6);
        Point p4 = new Point(10, 9);
        PolyLine l1 = new PolyLine(p1, p2, p3, p4);
        ClosedPolyLine cl1 = new ClosedPolyLine(l1);

        System.out.println("Длина ломаной = "+l1.length());
        System.out.println("Длина замкнутой линии = "+cl1.length());

    }
}