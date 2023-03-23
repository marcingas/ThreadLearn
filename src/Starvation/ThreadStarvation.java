package Starvation;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadStarvation {
    private static ReentrantLock lock = new ReentrantLock(true);//true->first come, first serve
    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED),"priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE),"priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN),"priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN),"priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE),"priority 2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }
    private static class Worker implements Runnable{
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for(int i = 0;i < 100;i++){
//                synchronized (lock){
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    //execute crtitical section of code
//                }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
