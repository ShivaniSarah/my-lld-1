package comPackage.lld4;

import comPackage.lld4.models.Base62;
import comPackage.lld4.models.Encoding;
import comPackage.lld4.services.RequestHandlerIntf;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestHandler implements RequestHandlerIntf {
    Map<Integer,String> url_map;
    TinyUrl tinyUrl;
    ExpandUrl expandUrl;

    public RequestHandler(String s,Integer n){
        this.url_map= new HashMap<>();
        Encoding enc = new Base62(s);
        int len =n;
        BaseUrlShortener baseUrlShortener = new BaseUrlShortener(enc.getName(),len);
        tinyUrl = new TinyUrl(baseUrlShortener);
        BaseUrlRedirector urlRedirector = new BaseUrlRedirector(enc.getName());
        expandUrl = new ExpandUrl(urlRedirector);
    }

    public String getShortenedUrl(String long_url){
        if (! isValidUrl(long_url) ){
            // i can also throw error
            return "Not a valid url" ;
        }
        Integer n = url_map.size()+1;
        url_map.put(n,long_url);
        String short_url = tinyUrl.getShortenedUrl(n);
        return short_url;
    }


    public String getLongUrl(String short_url){
        int n = expandUrl.getOriginalUrl(short_url);
        String long_url = url_map.getOrDefault(n,"");
        return long_url;
    }

    public boolean isValidUrl(String url){

        String regex = "^(https?|ftp)://[^\s/$.?#].[^\s]*$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();

    }

}
