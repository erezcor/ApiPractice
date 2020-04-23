import Contracts.SuccessMessage;
import Contracts.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static Contracts.User.generateUser;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SerializationTest extends BaseTest {

    @Test
    public void serializationTest() {
        User user = generateUser().build();

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("/register");

        SuccessMessage successMessage = response.as(SuccessMessage.class);

        response.then().assertThat()
                .statusCode(is(201));

        assertThat(successMessage.getSuccessCode(), is("OPERATION_SUCCESS"));
        assertThat(successMessage.getMessage(), is("Operation completed successfully"));
    }
}