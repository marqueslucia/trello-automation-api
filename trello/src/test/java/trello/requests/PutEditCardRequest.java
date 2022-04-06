package trello.requests;

import trello.base.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import trello.tests.PostCreateCardTest;

import static io.restassured.RestAssured.given;

public class PutEditCardRequest {
    BaseTest baseTest = new BaseTest();

    @Step("Editar Card")
    public Response editCard() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key",BaseTest.KEY)
                .queryParam("token",BaseTest.TOKEN)
                .queryParam("name","Card created and edited by automation")
                .when()
                .post(baseTest.BASEURI + BaseTest.PATH_CARD + PostCreateCardTest.idCard);
    }

    @Step("Editar Card sem Autorização")
    public Response editCardWithoutPermission() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key","")
                .queryParam("token",BaseTest.TOKEN)
                .queryParam("name","Card created and edited by automation without permission")
                .when()
                .post(baseTest.BASEURI + BaseTest.PATH_CARD + PostCreateCardTest.idCard);
    }

    @Step("Editar Card sem ID do Card")
    public Response editCardWithoutIdCard() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key",BaseTest.KEY)
                .queryParam("token",BaseTest.TOKEN)
                .queryParam("name","Card created and edited by automation without idCard")
                .when()
                .post(baseTest.BASEURI + BaseTest.PATH_CARD);
    }
}
