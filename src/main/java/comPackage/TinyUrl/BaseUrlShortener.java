package comPackage.lld4;
import comPackage.lld4.models.Base62;
import comPackage.lld4.services.UrlShortenerIntf;

import java.util.Objects;

public class BaseUrlShortener implements UrlShortenerIntf {
    String enc;
    Integer len;

    public BaseUrlShortener(String s, Integer n) {
        super();
        this.enc = s;
        this.len= n;
    }

    @Override
    public String shortener(Integer n) {
        StringBuilder shortURL = new StringBuilder();

        if (Objects.equals(enc, "base62")) {
            Base62 encoding = new Base62(enc);
            while (n > 0) {
                shortURL.append(encoding.getBase_chars().charAt((int) (n % encoding.getBase_size())));
                n = n / encoding.getBase_size();
            }

            // Reverse the string to complete base conversion
            shortURL.reverse();

            while (shortURL.length() < len) {
                shortURL.insert(0,encoding.getBase_chars().charAt(0)); // Insert 'a' (base62 value 0)
            }

        }
        return shortURL.substring(0, len);

    }
}