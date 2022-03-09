package tests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class APITests {

    @Test
    public void CompareStatus(Integer expectedStatus, Response responseBody)
    {
        Integer status = responseBody.getStatusCode();
        Assert.assertEquals(expectedStatus, status);
        System.out.println(responseBody.statusCode());
        System.out.println(responseBody.asPrettyString());
    }
}
