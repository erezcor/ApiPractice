package Contracts;

import lombok.Getter;
import java.io.Serializable;

@Getter
public class SuccessMessage implements Serializable {
    private static final long serialVersionUID = -3731977147363548380L;

    public String SuccessCode;
    public String Message;
}
