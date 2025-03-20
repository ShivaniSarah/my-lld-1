package comPackage.lld4.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Base50 extends Encoding {
    private final String base_chars;
    private final int base_size;

    public Base50(String n){
        super(n);
        this.base_chars = ""; // TODO : enter 50 characters
        this. base_size = base_chars.length();
    }
}
