package trello.requests;

import trello.base.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteCardRequest {
    BaseTest baseTest = new BaseTest();
    public static String idCard;

    @Step("Criar Card para deleção")
    public String criarCard() {
        idCard = given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key", BaseTest.KEY)
                .queryParam("token",BaseTest.TOKEN)
                .queryParam("name","Automation Test2")
                .queryParam("desc","Card created by automation")
                .queryParam("idList",BaseTest.IDLIST)
                .when()
                .post(baseTest.BASEURI + BaseTest.PATH_CARD)
                .then()
                .extract()
                .path("id");

        return idCard;
    }

    @Step("Deletar Card")
    public Response deleteCard() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key", BaseTest.KEY)
                .queryParam("token",BaseTest.TOKEN)
                .when()
                .delete(baseTest.BASEURI + BaseTest.PATH_CARD + idCard);
    }

    @Step("Deletar Card sem autorização")
    public Response deleteCardWithoutPermission() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key", "")
                .queryParam("token",BaseTest.TOKEN)
                .when()
                .delete(baseTest.BASEURI + BaseTest.PATH_CARD + idCard);
    }

    @Step("Deletar Card sem id do card")
    public Response deleteCardWithoutIdCard() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key", BaseTest.KEY)
                .queryParam("token",BaseTest.TOKEN)
                .when()
                .delete(baseTest.BASEURI + BaseTest.PATH_CARD);
    }
}
