package ru.сourses.geometry;

class Point {
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