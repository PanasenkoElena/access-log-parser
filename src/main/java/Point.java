class Point {
    int x,y;


public Point(int x, int y) {
    this.x = x;
    this.y = y;
}

public String toString(){
   String point="{"+"x:"+x+"y:"+y+"}";
    return point;
}
public void setCoordinates(int x,int y){
    this.x = x;
    this.y = y;
}

}