package awt;

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