//package comPackage.lld4;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import comPackage.lld4.models.Base62;
//import comPackage.lld4.services.UrlExpanderIntf;
//import java.util.Base64;
//import java.util.Objects;
//import java.util.*;
//
//public class Md5Redirector implements UrlExpanderIntf{
//        String enc;
//    private Map<String, String> urlMap = new HashMap<>();
//        public Md5Redirector(String s) {
//            super();
//            this.enc = s;
//        }
//    private String encodeMD5ToShortURL(String md5Hash) {
//        // Use Base64 encoding to shorten the MD5 hash
//        // Note: The length of the encoded string will be longer than the original MD5 hash
//        return Base64.getUrlEncoder().withoutPadding().encodeToString(md5Hash.getBytes());
//    }
//        @Override
//        public String expander(String originalURL) {
//            if (Objects.equals(enc, "base62")) {
//                try {
//                    // Generate MD5 hash of the URL
//                  // TODO: write md5 expander
//
//                } catch (NoSuchAlgorithmException e) {
//                    throw new RuntimeException("MD5 algorithm not found", e);
//                }
//
//            }
//
//
//            // TODO:  write factory pattern for different encodings
//            //        else if(Objects.equals(enc,"base50"))
//
//
//            return 0;
//        }
//
//
//}
