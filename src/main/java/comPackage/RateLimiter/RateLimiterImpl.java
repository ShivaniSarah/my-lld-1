package comPackage.lld5;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Queue;

public class RateLimiterImpl implements RateLimiter {

    private final int threshold;
    private final long timeWindowInMillis;
    private final AtomicLong windowStart;
    private final Queue<Long> requestTimestamps;

    public RateLimiterImpl(int maxRequests, int timeWindowSeconds) {
        this.threshold = maxRequests;
        this.timeWindowInMillis = timeWindowSeconds * 1000L;
        this.requestTimestamps = new LinkedBlockingQueue<>();
        this.windowStart = new AtomicLong(System.currentTimeMillis());
    }

    @Override
    public boolean isRateLimited(Request request) {
//        long currentTime = System.currentTimeMillis();
        long currentTime = request.getTime();
        long windowTime = windowStart.get();

        while (!requestTimestamps.isEmpty() && (currentTime - requestTimestamps.peek()) > timeWindowInMillis) {
            requestTimestamps.poll();
        }

        // If there is space for a new request in the current window
        if (requestTimestamps.size() < threshold) {
            requestTimestamps.add(currentTime);
            return true;
        }

        return false;
    }
}

