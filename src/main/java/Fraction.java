public class Fraction extends Number{
    int num,denum;

    public Fraction(int num, int denum) {
        this.num = num;
        if (denum<1) {
            throw new IllegalArgumentException("знаменатель должен быть больше 0!");
        }
        this.denum = denum;//Для целого числа знаменатель будет Null
    }
    public Fraction (int num){
        this.num = num;
        this.denum=1;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getDenum() {
        return denum;
    }
    public void setDenum(int denum) {
        this.denum = denum;
    }

    public String toString() {
        return num + "/" + denum;
    }

    @Override
    public int intValue(){
        return (int) (this.num/this.denum);
    }

    @Override
    public long longValue(){
        return (long) (this.num/ this.denum);
    }
    @Override
    public float floatValue(){
        return ((float)this.num/(float)this.denum);
    }
    @Override
    public double doubleValue(){
        return  ((double)this.num/(double)this.denum);
    }
    double getSum(double sum){
     sum=sum+this.doubleValue();
        return sum;
    };
}
