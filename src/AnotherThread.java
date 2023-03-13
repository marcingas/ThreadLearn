public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello from AnotherThread which name is " +currentThread().getName() );
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println("Another Thread woke me up");
            return;
        }
        System.out.println("3 sec have passed and i'm awake");
    }
}
