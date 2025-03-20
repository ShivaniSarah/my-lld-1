package comPackage.lld5;

import ch.qos.logback.core.joran.conditional.ThenAction;

import java.util.concurrent.*;

public class RatelimiterApplication {
    public static void main(String[] args) throws InterruptedException {

//        Executor executor = new ThreadPoolExecutor(8, 8, 8, TimeUnit.MINUTES,
//                new ArrayBlockingQueue<>(8) {});

        RateLimiter rateLimiter = new RateLimiterImpl(10,5);
        APIInterface apiInterface = new APIInterface(rateLimiter);

        Runnable requestTask = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println();
                Request request = Request.builder().clientID(1).time(System.currentTimeMillis()).build();
                Request request2 = new Request(1, System.currentTimeMillis());
                System.out.println(apiInterface.requestAccepted(request).getMessage());
            }
        };

//       Runnable requestTask2 =  () -> {
//            Request request = Request.builder().clientID(1).time(System.currentTimeMillis()).build();
////            Request request2 = new Request(1, System.currentTimeMillis());
//            System.out.println(apiInterface.requestAccepted(request).getMessage());
//        };
        for (int i = 0; i < 20; i++) {
            //executor.execute(requestTask);
            new Thread(requestTask, "i = " + i).start();
            Thread.sleep(100);
        }
    }
}
