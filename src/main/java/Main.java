public class Main {
    public static void main(String[] args) {

        long PAUSE_BEFORE_START = 1000L;

        CallCenter callCenter = new CallCenter();

        Thread callCenterThread = new Thread(null, callCenter, "Call center");

        Thread operator1Thread = new Thread(null, callCenter::answerCall, "Operator 1");
        Thread operator2Thread = new Thread(null, callCenter::answerCall, "Operator 2");
        Thread operator3Thread = new Thread(null, callCenter::answerCall, "Operator 3");

        try {
            callCenterThread.start();
            Thread.sleep(PAUSE_BEFORE_START);
            operator1Thread.start();
            Thread.sleep(PAUSE_BEFORE_START);
            operator2Thread.start();
            Thread.sleep(PAUSE_BEFORE_START);
            operator3Thread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            operator3Thread.join();
            operator2Thread.join();
            operator1Thread.join();
            callCenterThread.join();

            System.out.println("Все звонки в очереди успешно обработаны");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
