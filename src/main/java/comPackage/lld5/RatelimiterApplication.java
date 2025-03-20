package comPackage.lld5;

import ch.qos.logback.core.joran.conditional.ThenAction;

import java.util.concurrent.*;

public class RatelimiterApplication {
    public static void main(String[] args) throws InterruptedException {

//        Executor executor = new ThreadPoolExecutor(8, 8, 8, TimeUnit.MINUTES,
//                new ArrayBlockingQueue<>(8) {});
        RateLimiter rateLimiter = new RateLimiterImpl(2,5);
        APIInterface apiInterface = new APIInterface(rateLimiter);

        for (int i = 0; i < 20; i++) {
            final int clientId = i; // Must be final or effectively final

            Runnable requestTask = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    Request request = Request.builder().clientID(clientId).time(System.currentTimeMillis()).build();
                    System.out.println(apiInterface.requestAccepted(request).getMessage());
                }
            };
            new Thread(requestTask, "Client-" + i).start();
            Thread.sleep(500L);
        }
    }
}


//       Runnable requestTask2 =  () -> {
//            Request request = Request.builder().clientID(clientId).time(System.currentTimeMillis()).build(); // new Request(1, System.currentTimeMillis());
//            System.out.println(apiInterface.requestAccepted(request).getMessage());
//        };