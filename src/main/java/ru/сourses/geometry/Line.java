package ru.сourses.geometry;

import java.util.Objects;

public class Line implements Measurable, Cloneable {
    /*  Point points[];

      public Line(Point... points) {
          this.points = points;
      }*/
    Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line() {

    }

    public void copy(Line l) {
        l.start = this.start;
        l.end = this.end;
    }

    public double getLength() {
        double sum = 0, len1, len2;
        len1 = start.x - end.x;
        len2 = start.y - end.y;
        sum = Math.sqrt(len1 * len1 + len2 * len2);
        return sum;
    }

    public String getCustomName() {
        return this.getClass().getName();
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) && Objects.equals(end, line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line newLine = (Line) super.clone();
        this.copy(newLine);
        return newLine;
    }

    @Override
    public String toString() {
        String line = "Линия "+" [";
        line = line + "[" + this.start.toString()+";"+this.end.toString()+"]";
        return line;
    }
}
