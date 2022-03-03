package steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.BooleanUtils.and;
import static org.hamcrest.Matcher.*;

public class add_user_APITest {

    @Test
    void register_user() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("email","eve.holt@reqres.in");
//        map.put("password","pistol");

        JSONObject request = new JSONObject(); // json-simple for the key value
        request.put("email", "eve.holt@reqres.in");
        request.put("password", "pistol");
        System.out.println(request.toJSONString());

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/register").
                then().
                statusCode(200);

    }

    @Test
    void regiser_user_unsuccessful() {
        JSONObject request = new JSONObject();
        request.put("email", "eve.holt@reqres.in");
        System.out.println(request.toJSONString());

        given().
                body(request.toJSONString()).
                when().
                response().
                when().
                post("https://reqres.in/api/register").
                then().
                statusCode(400);

    }

    @Test
    void login_user() {
        JSONObject request = new JSONObject();
        request.put("email", "eve.holt@reqres.in");
        request.put("password", "cityslicka");
        System.out.println(request.toJSONString());

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/login").
                then().
                statusCode(200);
        Assert.assertEquals("QpwL5tke4Pnpja7X4", request.toJSONString()); // Check the token
    }

    @Test
    void login_user_unsuccessful() {
        JSONObject request = new JSONObject();
        request.put("email", "eve.holt@reqres.in");
        System.out.println(request.toJSONString());

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/login").
                then().
                statusCode(400);

    }

    @Test
    void get_user() {
        given().get("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                //       body("data.id[0]", equalTo(2)).
                        log().all();
    }

    @Test
    void get_user_notfound() {
        given().get("https://reqres.in/api/users/23").
                then().
                statusCode(404).
                //       body("data.id[0]", equalTo(2)).
                        log().all();
    }

}
