public class ThreadColor extends Thread{
    public static final String ANSI_RED = "\u001B[31m";
    public void run(){
        System.out.println(ANSI_RED + "Hello from thread Color");
    }
}
