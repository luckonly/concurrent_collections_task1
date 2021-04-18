public class Call {

    String callerName;

    public Call(String callerName) {
        this.callerName = callerName;
    }

    @Override
    public String toString() {
        return callerName;
    }
}
