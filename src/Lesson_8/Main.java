package Lesson_8;

public class Main {
    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;
        Thread_1 thread_1 = new Thread_1();
        Thread_2 thread_2 = new Thread_2();
        thread_1.resourceA = resourceA;
        thread_2.resourceB = resourceB;
        thread_1.start();
        thread_2.start();
    }
}

class ResourceA {
    ResourceB resourceB;

    public synchronized int getI(){
        resourceB.returnI();
        Thread.yield();
        return  resourceB.getI();
    }

    public synchronized int returnI(){
        return 1;
    }
}

class ResourceB {
    ResourceA resourceA;

    protected synchronized int getI(){
        return  resourceA.returnI();
    }

    public synchronized int returnI(){
        return 2;
    }
}

class Thread_1 extends Thread {
    ResourceA resourceA;
    @Override
    public void run() {
        System.out.println(resourceA.getI());
    }
}

class Thread_2 extends Thread {
    ResourceB resourceB;
    @Override
    public void run() {
        System.out.println(resourceB.getI());
    }
}
