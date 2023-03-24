package livelock;

public class PoliteWorker {
    public static void main(String[] args) {
    final Worker worker1 = new Worker("Worker1 Sally",true);
    final Worker worker2 = new Worker("Worker2 Hogwarth Humpfy Dumpfy", true);

    final SharedResource sharedResource = new SharedResource(worker1);

    new Thread(new Runnable() {
        @Override
        public void run() {
            worker1.work(sharedResource,worker2);
        }
    }).start();
    new Thread(new Runnable() {
        @Override
        public void run() {
            worker2.work(sharedResource,worker1);
        }
    }).start();
    }
}
