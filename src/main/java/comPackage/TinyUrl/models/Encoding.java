package comPackage.lld4.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Encoding {
    public String name;
    public Encoding(String name){
        this.name = name;
    }
}
