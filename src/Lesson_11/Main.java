package Lesson_11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.setI(7);
        resource.setA(7);
        MyThread thread = new MyThread();
        MyThread thread2 = new MyThread();
        thread.setResource(resource);
        thread2.setResource(resource);
        thread.setName("one");
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(resource.getI());
        System.out.println(resource.getA());
    }
}

class MyThread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
        resource.changeA();
    }
}

class Resource {
    private int i;
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    Lock lock = new ReentrantLock();

     void changeI(){
         lock.lock();
        int i = this.i;
        if(Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }
        i++;
        this.i = i;
    }

    void changeA(){
            int a = this.a;
          //  if (Thread.currentThread().getName().equals("one"))
                a++;
            this.a = a;
            lock.unlock();
    }
}
