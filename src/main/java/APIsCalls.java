import io.restassured.RestAssured;
import io.restassured.path.json.mapper.factory.JsonbObjectMapperFactory;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class APIsCalls {

    /**
     * returning a response of post request
     * @param url the url you want the request on
     * @param requestBody the request body as a json opject
     * @return
     */
    public Response post(String url, JSONObject requestBody )
    {
        return given().body(requestBody.toString()).when().post(url);
    }

    /**
     * returning a response of a get request
     * @param url the url you want to do the get on
     * @return
     */
    public Response get(String url)
    {
        return RestAssured.get(url);
    }
}
