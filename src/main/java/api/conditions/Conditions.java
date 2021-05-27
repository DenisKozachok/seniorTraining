package api.conditions;

import org.hamcrest.Matcher;

public class Conditions {

    public static StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static Condition bodyField(String jsonPath, Matcher matcher) {
        return new BodyFieldCondition(jsonPath, matcher);
    }

    public static ContentTypeCondition contentType(String contentType) {
        return new ContentTypeCondition(contentType);
    }


}

