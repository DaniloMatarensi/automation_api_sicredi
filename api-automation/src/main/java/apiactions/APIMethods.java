package apiactions;

import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;


public class APIMethods
{
    static String rootURL = "http://localhost:8080/api/v1/";

    public static Response postMethod(String path, JSONObject bodyParams)
    {
        Response response = null;
        try {
            response = given()
                    .header("Content-Type", "application/json")
                    .body(bodyParams.toString())
                    .post(rootURL + path)
                    .then()
                    .extract()
                    .response();
        }
        catch (Exception e)
        {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    public static Response getMethod(String path)
    {
        Response response = null;
        try {
            response = given()
                    .get(rootURL + path)
                    .then()
                    .extract()
                    .response();
        } catch (Exception e)
        {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    public static Response putMethod(String path, JSONObject bodyParams)
    {
        Response response = null;
        try {
            response = given()
                    .header("Content-Type", "application/json")
                    .body(bodyParams.toString())
                    .put(rootURL + path)
                    .then()
                    .extract()
                    .response();
        }
        catch (Exception e)
        {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    public static Response deleteMethod(String path)
    {
        Response response = null;
        try {
            response = given()
                    .delete(rootURL + path)
                    .then()
                    .extract()
                    .response();
        }
        catch (Exception e)
        {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}