package Contracts;

import lombok.Builder;

import java.io.Serializable;

import static Utils.StringUtils.getRandomString;
import static lombok.Builder.Default;

@Builder (builderMethodName = "generateUser")
public class User implements Serializable {
    private static final long serialVersionUID = -5581416953039810205L;

    @Default
    public String FirstName = getRandomString();

    @Default
    public String LastName = getRandomString();

    @Default
    public String UserName = getRandomString();

    @Default
    public String Password = getRandomString();

    @Default
    public String Email = getRandomString() + "@gmail.com";
}
