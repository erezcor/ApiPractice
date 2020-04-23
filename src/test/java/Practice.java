import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static Utils.StringUtils.getRandomString;

public class Practice extends BaseTest{

    @Test
    public void practice() {
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", getRandomString());
        requestParams.put("LastName", getRandomString() );
        requestParams.put("UserName",  getRandomString());
        requestParams.put("Password", getRandomString());
        requestParams.put("Email", getRandomString() + "@gmail.com");

        request.contentType(ContentType.JSON);
        request.body(requestParams.toJSONString());

        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
        String successCode = response.jsonPath().get("SuccessCode");

        Assert.assertEquals(201, statusCode);
        Assert.assertEquals("OPERATION_SUCCESS", successCode);
    }

}
