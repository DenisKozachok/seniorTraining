package api.conditions;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ContentTypeCondition implements Condition {
    private String contentType;

    @Override
    public void check(Response response) {
        response.then().assertThat().contentType(contentType);
    }

}
