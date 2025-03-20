package comPackage.lld5;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Queue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

public class RateLimiterImpl implements RateLimiter {
    private final int threshold;
    private final long timeWindowInMillis;
    private final ConcurrentLinkedQueue<Long> requestTimestamps;
    private final AtomicLong lastPruned;

    public RateLimiterImpl(int maxRequests, int timeWindowSeconds) {
        this.threshold = maxRequests;
        this.timeWindowInMillis = timeWindowSeconds * 1000L;
        this.requestTimestamps = new ConcurrentLinkedQueue<>();
        this.lastPruned = new AtomicLong(System.currentTimeMillis());
    }

    @Override
    public synchronized boolean isRateLimited(Request request) {
        long currentTime = request.getTime();
        long windowStartTime = currentTime - timeWindowInMillis;
        while (!requestTimestamps.isEmpty() && requestTimestamps.peek() < windowStartTime) {
            requestTimestamps.poll();
        }

        if (requestTimestamps.size() < threshold) {
            requestTimestamps.add(currentTime);
            return false; // Request is allowed
        }
        return true; // Request is rate-limited
    }

}


