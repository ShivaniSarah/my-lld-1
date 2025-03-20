package comPackage.lld4;

import comPackage.lld4.models.Base62;
import comPackage.lld4.models.Encoding;
import comPackage.lld4.services.RequestHandlerIntf;

import java.util.*;

public class TinyUrlApplication {

    public static void main(String args[]){

        String url="https://google.com"; // "google"

        String encoding= "base62";
        Integer url_length = 7;
        RequestHandlerIntf RequestHandler = new RequestHandler(encoding,url_length);
        String short_url = RequestHandler.getShortenedUrl(url);
        String long_url = RequestHandler.getLongUrl(short_url);

        System.out.println(short_url);
        System.out.println(long_url);



    }

}
