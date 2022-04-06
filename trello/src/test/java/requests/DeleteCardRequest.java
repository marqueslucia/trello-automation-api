package requests;

import base.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import tests.PostCreateCardTest;

import static io.restassured.RestAssured.given;

public class DeleteCardRequest {
    BaseTest baseTest = new BaseTest();

    @Step("Deletar Card")
    public Response deleteCard() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key", BaseTest.KEY)
                .queryParam("token",BaseTest.TOKEN)
                .when()
                .post(baseTest.BASEURI + BaseTest.PATH_CARD + PostCreateCardTest.idCard);
    }

    @Step("Deletar Card sem autorização")
    public Response deleteCardWithoutPermission() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key", "")
                .queryParam("token",BaseTest.TOKEN)
                .when()
                .post(baseTest.BASEURI + BaseTest.PATH_CARD + PostCreateCardTest.idCard);
    }

    @Step("Deletar Card sem id do card")
    public Response deleteCardWithoutIdCard() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key", BaseTest.KEY)
                .queryParam("token",BaseTest.TOKEN)
                .when()
                .post(baseTest.BASEURI + BaseTest.PATH_CARD);
    }
}
