public class Lesson_1_2 {
    public static void main(String[] args) {
        new MyThread_2().start();
        new MyThread_2().start();
        new MyThread_2().start();
    }
}

class MyThread_2 extends Thread {
    @Override
    public void run() {
       for (int i = 0; i< 100; i++){
           System.out.println(Thread.currentThread().getName() + " " + i);
       }
    }
}