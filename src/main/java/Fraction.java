public class Fraction extends Number{
    int num,denum;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    public String toString() {
        return num + "/" + denum;
    }

    @Override
    public  int intValue(){
        return (int) (this.num/this.denum);
    }

    public long longValue(){
        return (long) (this.num/ this.denum);
    }

    public float floatValue(){
        return ((float)this.num/(float)this.denum);
    }

    public double doubleValue(){

        return  ((double)this.num/(double)this.denum);
    }
}
