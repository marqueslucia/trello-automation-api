package tests;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import requests.PutEditCardRequest;

import static org.hamcrest.CoreMatchers.containsString;

public class PutEditCardTest {
    PutEditCardRequest consultingRequest = new PutEditCardRequest();

    @Test
    @DisplayName("CT06 - Editar um card existente")
    public void shouldEditCard() {
        consultingRequest.editCard()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(containsString("Card created and edited by automation"));
    }

    @Test
    @DisplayName("CT07 - Editar um card sem autorização")
    public void shouldEditCardWithoutPermission() {
        consultingRequest.editCardWithoutPermission()
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .assertThat()
                .body(containsString("invalid key"));
    }

    @Test
    @DisplayName("CT08 - Editar um card sem o id do card")
    public void shouldEditCardWithoutIdCard() {
        consultingRequest.editCardWithoutIdCard()
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .assertThat()
                .body(containsString("Cannot PUT"));
    }
}
