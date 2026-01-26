public class Line implements Measurable{
    Point points[];

    public Line(Point... points) {
        this.points = points;
    }
    public double getLength() {
        double sum=0, len1, len2;
        len1 = points[0].x - points[points.length - 1].x;
        len2 = points[0].y - points[points.length - 1].y;
        sum = Math.sqrt(len1 * len1 + len2 * len2);
        return sum;
    }
    public String getCustomName(){
            return this.getClass().getName();
    }
}
