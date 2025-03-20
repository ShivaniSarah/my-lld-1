package comPackage.lld4.services;

public interface RequestHandlerIntf {

    public String getShortenedUrl(String long_url);
    public String getLongUrl(String short_url);

}
