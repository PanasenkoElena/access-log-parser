public class PolyLine {
    Point[] points;

    public PolyLine(Point... points) {
        this.points = points;
    }

    public double length() {
        double sum = 0, len1, len2;
        for (int i = 0; i < points.length - 1; i++) {
            len1 = points[i].x - points[i + 1].x;
            len2 = points[i].y - points[i + 1].y;
            sum += Math.sqrt(len1 * len1 + len2 * len2);
        }
        return sum;
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
    public double length() {
        double sum=0, len1, len2;
        len1 = points[0].x - points[points.length - 1].x;
        len2 = points[0].y - points[points.length - 1].y;
        sum = super.length() + Math.sqrt(len1 * len1 + len2 * len2);
        return sum;
    }
}