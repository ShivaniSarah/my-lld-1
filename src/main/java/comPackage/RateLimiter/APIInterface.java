package comPackage.lld5;

public class APIInterface {
    private final RateLimiter rateLimiter;
    public APIInterface(RateLimiter rateLimiter){
        this.rateLimiter = rateLimiter;
    }
    public Response requestAccepted(Request request){
        if(rateLimiter.isRateLimited((request))){
            return Response.builder().message("Too many requests").build();
        }
        return Response.builder().message("Success").build();
    }

}
