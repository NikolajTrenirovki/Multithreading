package experiment;

class Solution {

    public static Object syncRoot = new Object();

    public static void main(String[] args) {

        ThreadB threadB = new ThreadB();
        threadB.start();
        synchronized (syncRoot) {
            try {
                syncRoot.wait();
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
        for (int i = 0; i < 5; i++) {
            total += i;
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (Solution.syncRoot) {
           // Solution.syncRoot.notify();
        }
    }
}