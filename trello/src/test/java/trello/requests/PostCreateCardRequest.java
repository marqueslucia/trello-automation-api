package trello.requests;

import trello.base.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostCreateCardRequest {
    BaseTest baseTest = new BaseTest();

    @Step("Criar Card")
    public Response createCard() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key", BaseTest.KEY)
                .queryParam("token",BaseTest.TOKEN)
                .queryParam("name","Automation Test2")
                .queryParam("desc","Card created by automation")
                .queryParam("idList",BaseTest.IDLIST)
                .when()
                .post(baseTest.BASEURI + BaseTest.PATH_CARD);
    }

    @Step("Criar Card sem autorização")
    public Response createCardWithoutPermission() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key", "")
                .queryParam("token",BaseTest.TOKEN)
                .queryParam("name","Automation Test")
                .queryParam("desc","Card created by automation without permission")
                .queryParam("idList",BaseTest.IDLIST)
                .when()
                .post(baseTest.BASEURI + BaseTest.PATH_CARD);
    }

    @Step("Criar Card sem idList")
    public Response createCardWithoutIdList() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key", BaseTest.KEY)
                .queryParam("token",BaseTest.TOKEN)
                .queryParam("name","Automation Test")
                .queryParam("desc","Card created by automation without idList")
                .queryParam("idList","")
                .when()
                .post(baseTest.BASEURI + BaseTest.PATH_CARD);
    }
}
