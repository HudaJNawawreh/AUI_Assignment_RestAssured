import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APIsTests extends APIsCalls{
    String url="https://reqres.in/api/users";
    JSONObject requestObject;
    Response response;
    String requiredUserID;

    /**
     * This test is creating a user and printing its id once it is created successfully
     */
    @Test
    void createUserTest()
    {
        requestObject = new JSONObject();
        requestObject.put("name","NAME");
        requestObject.put("job","JOB");

        response= post(url,requestObject);
        Assert.assertEquals(response.statusCode(),201,"Make sure the Post request succeed");

        System.out.println("The returned id is " + response.jsonPath().get("id"));

    }

    /**
     * This test is getting back the name of an existing user
     * used ID = 3
     */
    @Test
    void gettingNamesOfExistingUser()
    {
        requiredUserID ="3";
        response = get(url);
        Assert.assertEquals(response.getStatusCode(),200,"Make sure the Get request succeed");

        GeneralMethods.gettingUserNameFromId(requiredUserID,response.jsonPath().getList("data"));
    }

    /**
     * This will test that if the id you are requesting is not exist you will get a message
     * ID=800 is used
     */
    @Test
    void gettingNamesOfNotExistingUser()
    {
        requiredUserID ="800";
        response = get(url);
        Assert.assertEquals(response.getStatusCode(),200,"Make sure the Get request succeed");

        GeneralMethods.gettingUserNameFromId(requiredUserID,response.jsonPath().getList("data"));
    }
}
