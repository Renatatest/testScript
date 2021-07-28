package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * @author Renata L. on 26/07/2021
 * @project testeScript
 */
public class ApiTest {
    /* Desabilitado para não gerar token
    @Test
    public void testApiSemCampoObrigatorio(){
        given()
                //precondicao
                .contentType("application/json")
                //Campo obrigatorio: \"appDescription\": \"testeteste\"
                .body("{\"email\": \"14bisestudos@gmail.com\", \"opted_into_mailing_list\": false}")
                .when() .post("https://api.thecatapi.com/v1/user/passwordlesssignup")
                .then()
                .log().all()
                .body("message", containsString("mensagem de erro"))
                .statusCode(400);
    }
*/

    /*
    @Test
    public void testApiSemCampoObrigatorio() {
        given()
                //precondicao
                .contentType("application/json")
                //Campo obrigatorio: \"appDescription\": \"testeteste\"
                .body("{\"email\": \"14bisestudos@gmail.com\", \"opted_into_mailing_list\": false}")
                .when().post("https://api.thecatapi.com/v1/user/passwordlesssignup")
                .then()
                .log().all()
                .body("message", contains("mensagem de erro"))
                .statusCode(400);
    }

    @Test
    public void efetuarVotacao() {
        //699b451e-405a-4aec-aed0-08987be0b21d
        given()
                .contentType("application/json")
                .body("{\"image_id\": \"MTkxNDM3Mg\", \"value\": true, \"sub_id\": \"demo-59e743\"}")
                .header("x-api-key", "699b451e-405a-4aec-aed0-08987be0b21d")
                .when()
                .post("https://api.thecatapi.com/v1/votes")
                .then()
                .statusCode(200)
                .body("message",is("SUCCESS"))
                .log().all();

    }
*/
@Test
    public void pegarVotacaoSemAuth() {
               //699b451e-405a-4aec-aed0-08987be0b21d
        given()
                .header("x-api-key", "699b451e-405a-4aec-aed0-08987be0b21xx")
                .when()
                .get("https://api.thecatapi.com/v1/votes")
                .then()
               .statusCode(401)
                .log().all();

    }

    //SICONFI
    @Test
    public void extratoEntregas() {
        baseURI = "http://apidatalake.tesouro.gov.br/ords/siconfi/tt";
        
/*
    @Test
    public void deletarVotacao() {

        given()
                //precondicao
                .contentType("application/json")
                .body("")
                .when().post("")
                .then()
                .log().all()
                .body("message", containsString("mensagem "))
                .statusCode();
    }
*/
}
}


