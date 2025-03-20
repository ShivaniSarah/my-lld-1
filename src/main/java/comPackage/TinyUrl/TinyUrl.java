package comPackage.lld4;

import comPackage.lld4.services.UrlShortenerIntf;

public class TinyUrl {

    private final UrlShortenerIntf urlShortenerService;

    public TinyUrl(UrlShortenerIntf urlShortenerService) {

       this.urlShortenerService=urlShortenerService;

    }

    public String getShortenedUrl(Integer n) {

        String tinyurl = urlShortenerService.shortener(n);
        return tinyurl;

    }


}



