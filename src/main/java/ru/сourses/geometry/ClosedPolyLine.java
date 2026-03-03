package ru.сourses.geometry;

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
    }}