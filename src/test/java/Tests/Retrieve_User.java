package Tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Config.Configuration_Manager;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Retrieve_User {
    @Test
    public void testGetUser() {
        RestAssured.baseURI = Configuration_Manager.getProperty("base.url");

        int userId = 10;

        Response response = given()
                .when()
                .get("/api/users/" + userId)
                .then()
                .statusCode(200)
                .body("data.id", equalTo(userId))
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}

