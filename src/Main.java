public class Main {
    public static void main(String[] args) {

        System.out.println("Hello from the main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.start();//we can use only once
        Thread threadColor = new ThreadColor();
        threadColor.start();

        new Thread(){//anonymous class Thread
            public void run(){
                System.out.println("Hello from the anonymous class thread");
            }
        }.start();
        System.out.println("Hello Again from the main thread");

    }
}