import java.sql.Array;

public class PolyLine {
    Point[] t = new Point[0];
    int numberOfPoints;

    public PolyLine() {
    }
    public PolyLine(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
        this.t = new Point[numberOfPoints];
    }
    public void setPoint(Point p, int position) {
        if (position < t.length && position > -1) {
            this.t[position] = p;
        } else System.out.println("Недопустимый номер точки");
    }
    public Line[] getLines() {
        Line[] lines = new Line[numberOfPoints-1];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Line(t[i], t[i + 1]);
        }
        return lines;
    }

    public double getLength() {
        double lineLength = 0;
        Point[] t = this.t;
        for (int i = 0; i < numberOfPoints-1; i++)
        {
            lineLength = lineLength + Math.sqrt(Math.pow((t[i + 1].x - t[i].x), 2)
                    + Math.pow((t[i + 1].y - t[i].y), 2));
            System.out.println(lineLength);
        }
        return lineLength;
    }
    @Override
    public String toString() {
        String polyLine = "Линия [";
        for (int i = 0; i < numberOfPoints; i++) {
            polyLine = polyLine + " T" + i + t[i].toString() + ",";
        }
        polyLine = polyLine.substring(0, polyLine.length() - 1) + "]";
        return polyLine;
    }

    public String linesArraytoString(Line[] lines) {
        String linesArray = "Массив Линий [";
        for (int i = 0; i < lines.length; i++) {
            linesArray = linesArray +  i+"ая " + lines[i].toString() + ",";
        }
        linesArray = linesArray.substring(0, linesArray.length() - 1) + "]";
        return linesArray;
    }
}
