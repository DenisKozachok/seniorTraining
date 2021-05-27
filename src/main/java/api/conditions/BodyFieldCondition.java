package api.conditions;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import org.hamcrest.Matcher;

@AllArgsConstructor
public class BodyFieldCondition implements Condition {

    private String jsonPath;
    private Matcher matcher;


    @Override
    public void check(Response response) {
        response.then().assertThat()
                .body(jsonPath, matcher);
    }

    @Override
    public String toString() {
        return "bodyField [" + jsonPath + "]" + matcher;
    }
}

