package lesson_24;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {

    static long numOfOperation = 10_000_000_000L;

    static int numOfThread = Runtime.getRuntime().availableProcessors(); // колличество ядер на компьютере

    public static void main(String[] args) throws Exception {
        System.out.println(numOfThread);
        System.out.println(new Date());
        ForkJoinPool pool = new ForkJoinPool(numOfThread);
        System.out.println(pool.invoke(new MyFork(0, numOfOperation)));
/*        long j = 0;
        for (long i = 0; i < numOfOperation; i++){
            j += i;
        }
        System.out.println(j);*/
        System.out.println(new Date());
    }

    static class MyFork extends RecursiveTask<Long> {

        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if((to - from) <= numOfOperation/numOfThread) {
                long j = 0;
                for(long i = from; i < to; i++){
                    j += i;
                }
                return j;
            } else {
                long middle = (to + from)/2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                MyFork secondHalf = new MyFork(middle + 1, to);
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}
