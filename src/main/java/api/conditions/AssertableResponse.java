package api.conditions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class AssertableResponse {


    private Response response;

    @Step("api response shouldHave {condition}")
    public AssertableResponse shouldHave(Condition condition) {
        log.info("About to check condition {}", condition);
        condition.check(response);
        return this;
    }

    @Step
    public AssertableResponse shouldHave(Condition... condition) {
        for (Condition cond : condition) {
            cond.check(response);
        }
        return this;
    }

    public String getBodyByPath(String path) {
        return response.then().extract().path(path).toString();
    }

    public String getResponseJsonBody() {
        return response.body().print();
    }

     public String getResponseJsonBody(String path) {

        int index1=response.body().print().indexOf(path)+path.length()+2;
        int index2=response.body().print().lastIndexOf("}");
        return response.body().print().substring(index1,index2);
    }

    public <T> T responseAs(Class<T> tClass) {
        return response.as(tClass);
    }

    public <T> T responseAs(String path, Class<T> tClass) {
        return response.jsonPath().getObject(path, tClass);
    }

    public <T> List<T> responseAsList(String path, Class<T> tClass) {
        return response.jsonPath().getList(path, tClass);
    }

    public String getHeader(String headerName) {
        return response.header(headerName);
    }
}