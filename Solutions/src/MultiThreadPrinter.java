public class MultiThreadPrinter {
    static int i =0;
    public static void main(String[] args) {

        String lock = "lock";
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                synchronized (lock) {
                    while (i % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("t1--" + i);
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                } }}
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
            synchronized (lock){
            while (i%2==1){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2--"+i);
            i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();
            }}}
        });
        t1.start();
        t2.start();
    }
}
