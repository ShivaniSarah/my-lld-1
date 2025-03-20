package comPackage.lld7_new;

import java.util.HashMap;
import java.util.Map;

public class UserController {

  Map<String,User> userMap;

    public UserController() {
        this.userMap = new HashMap<>();
    }

    public void addUser(User user){
        userMap.put(user.getUserId(),user);
    }

    public User getUser(String userId){
        if(userMap.containsKey(userId)) return userMap.get(userId);
        throw new IllegalArgumentException("No such user id stored!");
    }
}
