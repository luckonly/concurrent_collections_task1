public class Operator implements Runnable {

    CallCenter callCenter;

    public Operator(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
       callCenter.answerCall();
    }
}
