package Tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Config.Configuration_Manager;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Create_User {
    @Test
    public void testCreateUser() {
        RestAssured.baseURI = Configuration_Manager.getProperty("base.url");

        String requestBody = "{ \"name\": \"Haya Khaled\", \"job\": \"QC Engineer\" }";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("Haya Khaled"))
                .body("job", equalTo("QC Engineer"))
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}
