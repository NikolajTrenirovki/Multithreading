package Lesson_wait_and_notify;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int k = 0;
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();

        Scanner scanner = new Scanner(System.in);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Runnable task = blockingQueue.get();
                    task.run();
                }
            }
        });
        thread.start();
        while (true){
            if(k == 0)
            System.out.println("Введите код команды:");
            Main.k = scanner.nextInt();
            if (k == 5){
                for (int i = 0; i < 10; i++){
                    blockingQueue.put(getTask());
                }
                //k = 0;
            }
        }
    }

    public static Runnable getTask(){
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("начало работы " + this);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("конец работы " + this);
            }
        };
    }

    static class BlockingQueue {
        ArrayList<Runnable> arrayList = new ArrayList<>();

        public synchronized Runnable get(){
            while (arrayList.isEmpty()){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Runnable runnable = arrayList.get(0);
            arrayList.remove(runnable);
            return runnable;
        }

        public synchronized void put (Runnable runnable){
            arrayList.add(runnable);
            notify();
        }
    }
}


