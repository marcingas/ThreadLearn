public class Main {
    public static void main(String[] args) {

        System.out.println("Hello from the main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==anotherThread==");
//        common mistake:
//        anotherThread.run();
       anotherThread.start();//we can use only once


        new Thread(){//anonymous class Thread
            public void run(){
                System.out.println("Hello from the anonymous class thread");
                try{
                    anotherThread.join();
                    System.out.println("Another thread terminated or timed out, so I'm running again");
                }catch(InterruptedException e){
                    System.out.println("I couldn't wait after all. I was interrupted");
                }
            }
        }.start();

//        Thread myRunnableThread = new Thread(new MyRunnable());
        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println("Hello from the anonymous class's implementation of run");
            }
        });
        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println("Hello Again from the main thread");

    }
}