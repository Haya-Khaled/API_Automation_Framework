package Tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import Config.Configuration_Manager;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Update_User {
    @Test
    public void testUpdateUser() {
        RestAssured.baseURI = Configuration_Manager.getProperty("base.url");

        int userId = 2;
        String updatedRequestBody = "{ \"name\": \"Haya Khaled\", \"job\": \"Senior QC Engineer\" }";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(updatedRequestBody)
                .when()
                .put("/api/users/" + userId)
                .then()
                .statusCode(200)
                .body("job", equalTo("Senior QC Engineer"))
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}
