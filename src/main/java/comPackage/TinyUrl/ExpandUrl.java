package comPackage.lld4;

import comPackage.lld4.services.UrlExpanderIntf;

public class ExpandUrl {
    private final UrlExpanderIntf urlExpanderService;

    public ExpandUrl(UrlExpanderIntf urlExpanderService) {
        this.urlExpanderService= urlExpanderService;
    }
    public int getOriginalUrl(String shortenedUrl) {
        Integer n = urlExpanderService.expander(shortenedUrl);
        return n;
    }

}
