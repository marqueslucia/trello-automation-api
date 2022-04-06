package trello.requests;

import trello.base.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutEditCardRequest {
    BaseTest baseTest = new BaseTest();
    public static String idCard;

    @Step("Criar Card para edição")
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

    @Step("Editar Card")
    public Response editCard() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key",BaseTest.KEY)
                .queryParam("token",BaseTest.TOKEN)
                .queryParam("name","Card created and edited by automation")
                .when()
                .put(baseTest.BASEURI + BaseTest.PATH_CARD + idCard);
    }

    @Step("Editar Card sem Autorização")
    public Response editCardWithoutPermission() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key","")
                .queryParam("token",BaseTest.TOKEN)
                .queryParam("name","Card created and edited by automation without permission")
                .when()
                .put(baseTest.BASEURI + BaseTest.PATH_CARD + idCard);
    }

    @Step("Editar Card sem ID do Card")
    public Response editCardWithoutIdCard() {
        return given()
                .header(BaseTest.CONTENT_TYPE,BaseTest.APPLICATION_JSON)
                .queryParam("key",BaseTest.KEY)
                .queryParam("token",BaseTest.TOKEN)
                .queryParam("name","Card created and edited by automation without idCard")
                .when()
                .put(baseTest.BASEURI + BaseTest.PATH_CARD);
    }
}
