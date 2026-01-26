public class NewString implements Measurable {
    String newString;

    public NewString(String newString) {
        this.newString = newString;
    }

    @Override
    public double getLength() {
        return this.newString.length();
    }

    public String getCustomName() {
        return this.getClass().getName();
    }
}
