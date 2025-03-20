package comPackage.lld5;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Request {

    int clientID;
    long time;
}
