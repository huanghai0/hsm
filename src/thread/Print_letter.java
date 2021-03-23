package thread;


public class Print_letter implements Runnable {
    char ch = 97;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                notify();
                try {
                    Thread.currentThread().sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (ch < 123) {
                    System.out.println(Thread.currentThread().getName() + " " + ch);
                    ch++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Print_letter t = new Print_letter();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
    }
}

