package Lesson_13;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int account = 0;

    public static void main(String[] args) {
        new ThreadMinus().start();
        new ThreadPlus().start();
    }

    static class ThreadPlus extends Thread {
        @Override
        public void run() {
            lock.lock();
            account += 10;
            condition.signal(); // https://metanit.com/java/tutorial/8.10.php
            lock.unlock();
        }
    }

    static class ThreadMinus extends Thread {
        @Override
        public void run() {

            if(account < 10) {
                lock.lock();
                try {
                    System.out.println(account);
                    condition.await(); // https://metanit.com/java/tutorial/8.10.php
                    System.out.println(account);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            account -= 10;
        }
    }
}
