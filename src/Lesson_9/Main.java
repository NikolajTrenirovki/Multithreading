package Lesson_9;

public class Main {
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();
        threadB.start();
        synchronized (threadB){
            try {
                threadB.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadB.total);
    }
}

class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        for (int i = 0; i < 5; i ++){
            total+=i;
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (this){
            notify();
        }
    }
}