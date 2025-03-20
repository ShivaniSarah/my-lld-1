package comPackage.lld4;

import comPackage.lld4.models.Base62;
import comPackage.lld4.services.Md5ShortenerIntf;
import comPackage.lld4.services.UrlShortenerIntf;

import java.util.Objects;

public class Md5UrlShortener implements Md5ShortenerIntf {

    String enc;
    Integer len;

    public Md5UrlShortener (String s, Integer n) {
        super();
        this.enc = s;
        this.len= n;
    }

    @Override
    public String shortener(Integer n) {
        // TODO : implement md5 shortener

    }
}
