public class Lesson_2 {
    public static void main(String[] args) throws InterruptedException {
        Thread.yield();
        System.out.println(Thread.currentThread().getName());
        MyThread_2_2 myThread_2_2 = new MyThread_2_2();
        myThread_2_2.start();
        myThread_2_2.join();
        MyThread_2_2 thread_2_2 = new MyThread_2_2();
        thread_2_2.start();
        Thread.yield();
        MyThread_2_2 thread_2_21 = new MyThread_2_2();
        thread_2_21.start();
    }
}

class MyThread_2_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i< 50; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
