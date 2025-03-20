package comPackage.lld4;

import comPackage.lld4.models.Base62;
import comPackage.lld4.services.UrlExpanderIntf;


import java.util.Objects;

public class BaseUrlRedirector implements UrlExpanderIntf {
    String enc;

    public BaseUrlRedirector(String s) {
        super();
        this.enc = s;
    }

    @Override
    public int expander(String shortURL) {
        if (Objects.equals(enc, "base62")) {
            Base62 encoding = new Base62(enc);
            int id=0;

            for (int i = 0; i < shortURL.length(); i++) {
                char c = shortURL.charAt(i);
                id = id *  encoding.getBase_size() + encoding.getBase_chars().indexOf(c);
            }

            return id;
        }


        // TODO:  write factory pattern for different encodings
        //        else if(Objects.equals(enc,"base50"))


        return 0;
    }

}
