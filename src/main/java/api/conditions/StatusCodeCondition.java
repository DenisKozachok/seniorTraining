package api.conditions;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class StatusCodeCondition implements Condition {

    private int statusCode;

    @Override
    public void check(Response response) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Override
    public String toString() {
        return "status code is " + statusCode;
    }
}


