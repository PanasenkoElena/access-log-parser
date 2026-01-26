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
        int res=(int) (this.num/this.denum);
        return res;
    }

    public long longValue(){
        long res=(long) (this.num/this.denum);
        return res;
    }

    public float floatValue(){
        float res=(long) (this.num/this.denum);
        return res;
    }

    public double doubleValue(){
        double res=(long) (this.num/this.denum);
        return res;
    }
}
