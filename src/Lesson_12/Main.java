package Lesson_12;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread_1().start();
        new Thread_2().start();
    }

    static class Thread_1 extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println(getName() + " start working");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " stop working");
            lock.unlock();
            System.out.println(getName() + " locking released");
        }
    }

    static class Thread_2 extends Thread {
        @Override
        public void run() {
            while (true){
                if (lock.tryLock()){
                    System.out.println(getName() + " working");
                    break;
                } else {
                    System.out.println(getName() + " working_2");
                }
            }
        }
    }
}
