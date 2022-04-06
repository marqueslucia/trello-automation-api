package trello.base;

import org.junit.After;
import org.junit.BeforeClass;
import static io.restassured.RestAssured.*;

public class BaseTest {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_JSON = "application/json";
    public static final String PATH_CARD = "1/cards/";
    public static final String BASEURI = "https://api.trello.com/";
    public static final String KEY = "8f3398a206a7eb84caea7b1c8a52283e";
    public static final String TOKEN = "d45c419375c2e685305a9e5b974c314e0e628d1af01a8ef5515869d8d1039ced";
    public static final String IDLIST = "624c971cd34b44187745a7a8";

}
