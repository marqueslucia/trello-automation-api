package trello.tests;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import trello.requests.DeleteCardRequest;

import static org.hamcrest.CoreMatchers.containsString;

public class DeleteCardTest {
    DeleteCardRequest consultingRequest = new DeleteCardRequest();

    @Test
    @DisplayName("CT09 - Deletar um card existente")
    public void shouldDeleteCard() {
        consultingRequest.deleteCard()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("CT10 - Deletar um card sem autorização")
    public void shouldDeleteCardWithoutPermission() {
        consultingRequest.deleteCard()
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .assertThat()
                .body(containsString("invalid key"));
    }

    @Test
    @DisplayName("CT11 - Deletar um card sem id do card")
    public void shouldDeleteCardWithoutIdCard() {
        consultingRequest.deleteCard()
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .assertThat()
                .body(containsString("Cannot DELETE"));
    }
}
