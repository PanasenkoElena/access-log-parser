class Line {
    Point t1, t2;
    private int x1, y1, x2, y2;

    public Line(Point t1, Point t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.t1 = new Point(x1, y1);
        this.t2 = new Point(x2, y2);
        System.out.println("t1=" + t1.toString());
        System.out.println("t2=" + t2.toString());
    }

    public void setStart(Point t1) {
        this.t1 = t1;
    }

    public void setEnd(Point t2) {
        this.t2 = t2;
    }

    public String toString() {
        String line = "Линия от" + t1.toString() + "до" + t2.toString() + ")";
        return line;
    }

    public double getLength() {
        double lineLength = Math.sqrt(Math.pow((t2.x - t1.x), 2)
                + Math.pow((t2.y - t1.y), 2));
        return lineLength;
    }
}

