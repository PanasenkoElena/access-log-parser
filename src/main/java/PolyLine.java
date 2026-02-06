public class PolyLine extends Line{
    Point[] points;

    public PolyLine(Point... points) {
        this.points = points;
    }

    public double getLength() {
        double sum = 0, len1, len2;
        for (int i = 0; i < points.length - 1; i++) {
            len1 = points[i].x - points[i + 1].x;
            len2 = points[i].y - points[i + 1].y;
            sum += Math.sqrt(len1 * len1 + len2 * len2);
        }
        return sum;
    }
   public String linesArraytoString(Line[] lines) {
        String linesArray = "Массив Линий [";
        for (int i = 0; i < lines.length; i++) {
            linesArray = linesArray +  i+"ая " + lines[i].toString() + ",";
        }
        linesArray = linesArray.substring(0, linesArray.length() - 1) + "]";
        return linesArray;
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
}

class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(Point... points) {
        super(points);
    }
    public ClosedPolyLine(PolyLine polyLine) {
        super(polyLine.points);
    }
    @Override
    public double getLength() {
        double sum=0, len1, len2;
        len1 = points[0].x - points[points.length - 1].x;
        len2 = points[0].y - points[points.length - 1].y;
        sum = super.getLength() + Math.sqrt(len1 * len1 + len2 * len2);
        return sum;
    }
}
