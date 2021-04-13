package Lesson_5;

public class Main {
    volatile static int i = 0;

    public static void main(String[] args) {
        new MyThreadRead().start();
        new MyThreadWrite().start();
    }

    static class MyThreadWrite extends Thread {

        @Override
        public void run() {
            while (i<5){
                System.out.println("Increment i to " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadRead extends Thread {

        @Override
        public void run() {
            int localVar = i;
            while (i < 5){
                if(localVar != i){
                    System.out.println("new value i of " + i);
                    localVar = i;
                }
            }
        }
    }
}
