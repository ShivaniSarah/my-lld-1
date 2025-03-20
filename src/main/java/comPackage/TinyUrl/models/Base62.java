package comPackage.lld4.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Base62 extends Encoding{
    private final String base_chars;
    private final int base_size;

    public Base62(String n){
        super(n);
        this.base_chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        this. base_size = base_chars.length();
    }
}
