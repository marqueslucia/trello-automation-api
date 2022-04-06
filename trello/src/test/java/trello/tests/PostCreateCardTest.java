package trello.tests;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import trello.requests.PostCreateCardRequest;

import static org.hamcrest.CoreMatchers.containsString;

public class PostCreateCardTest {
    PostCreateCardRequest consultingRequest = new PostCreateCardRequest();

    @Test
    @DisplayName("CT03 - Criar um Card")
    public void shouldCreateCard() {
        consultingRequest.createCard()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .assertThat()
                .body(containsString("Automation Test"));

    }

    @Test
    @DisplayName("CT04 - Criar um Card sem autorização")
    public void shouldCreateCardWithoutPermission() {
        consultingRequest.createCardWithoutPermission()
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .assertThat()
                .body(containsString("invalid key"));
    }

    @Test
    @DisplayName("CT05 - Criar um Card sem id da lista")
    public void shouldCreateCardWithoutIdList() {
        consultingRequest.createCardWithoutIdList()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .assertThat()
                .body(containsString("invalid value for idList"));
    }
}
