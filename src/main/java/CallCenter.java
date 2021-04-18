import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter implements Runnable {

    private ConcurrentLinkedQueue<Call> callsQueue;
    private static long TIME_TO_ANSWER = 1000L;
    private static long TIME_BETWEEN_CALLS = 1000L;
    private static int callQuantity = 60;
    private static int callCenterWorkingHours = 5;

    public CallCenter() {
        this.callsQueue = new ConcurrentLinkedQueue<>();
    }

    public void addCall() {

        for (int j = 0; j < callCenterWorkingHours; j++) {

            try {

                for (int i = 0; i < callQuantity; i++) {
                    callsQueue.add(new Call("Звонок №" + i));
                }

                System.out.println("Колл-центр обработал 60 новых звонков. На текущий момент в очереди "
                                        + callsQueue.size() + " звонков.");

                Thread.sleep(TIME_BETWEEN_CALLS);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Колл-центр завершил работу на сегодня");
    }

    public void answerCall() {

        try {

            Thread.sleep(TIME_TO_ANSWER);

            while (!callsQueue.isEmpty()) {

                Thread.sleep(TIME_TO_ANSWER);

                System.out.println(Thread.currentThread().getName()
                        + " обрабатывает вызов " + callsQueue.poll());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        addCall();
    }
}
