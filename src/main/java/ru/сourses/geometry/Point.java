package ru.сourses.geometry;

import java.util.Objects;

public class Point implements Cloneable{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        String str = "Точка:{" + x + ";" + y + "}";
        return str;
    }
  public void setCoordinates(int x,int y){
    this.x = x;
    this.y = y;
}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
private void copy(Point p){
        p.x=this.x;
        p.y=this.y;
}
    @Override
    protected Point clone() throws CloneNotSupportedException {
      Point newPoint= (Point)super.clone();
      this.copy(newPoint);
      return newPoint;
    }
}

class Point3D extends Point {
    int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    @Override
    public String toString() {
        String str = "Точка:{" + super.x + ";" + super.y + ";" + this.z + "}";
        return str;
    }
}