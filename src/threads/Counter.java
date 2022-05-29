package threads;

public class Counter implements Runnable{
    private final  String ANSI_COLOR;
    public Counter(String ANSI_RED) {
        this.ANSI_COLOR = ANSI_RED;
    }

    @Override
    public void run() {
        for (int i = 10; i >=0; i --){
            try {
                Thread.sleep(1000);
                System.out.println(ANSI_COLOR + Thread.currentThread().getName() + ":" + i + " second");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
