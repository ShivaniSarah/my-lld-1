package comPackage.lld5;

public interface RateLimiter {
    boolean isRateLimited(Request request);
}
