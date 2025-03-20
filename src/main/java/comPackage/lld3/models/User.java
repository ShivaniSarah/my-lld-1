package comPackage.lld3.models;

import lombok.Getter;

@Getter
public class User {
    private final Integer userId;
    private final String userName;

    User(Integer id,String name){
        this.userId=id;
        this.userName=name;
    }
}
