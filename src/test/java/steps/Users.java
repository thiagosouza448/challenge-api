package steps;

import com.github.javafaker.Faker;

import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import  resources.helpers;
import  resources.readJson;
import resources.validators;


import cucumber.api.java.pt.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Users  {

    helpers Helpers = new helpers();
    validators Validators = new validators();
    Faker faker = new Faker();
    String name;

    private RequestSpecification request;
    private Response response;



    @Dado("que eu acesso tenha usuarios cadastrados")
    public void use_user_posts() {
        RestAssured.baseURI = "https://reqres.in/api/";
        RestAssured.basePath = "users";


    }

    @Quando("eu faco uma requisicao GET para usuarios")
    public void ready_all_users_item() {
        request = given().contentType(ContentType.JSON);
        response = request.when().get();
        Helpers.setResponseUsers(response);
        System.out.println("response:" + Helpers.getResponseUsers().body().toString());
        assertEquals(200, response.statusCode());

        

    }

    @E("o corpo da resposta deve ser uma lista de usuários validos")
    public void i_view_all_users_items() {
        ResponseBody body = response.getBody();
        String res = body.asString();
        assertTrue(Validators.jsonIsValid(res));
        System.out.println("Response Body to all users: " + body.asString());
    }

    @Quando("eu faco uma requisicao POST para usuarios")
    public void add_new_Post_item() throws IOException {
        name = faker.name().fullName();
        Helpers.setName(name);

        JSONObject jsonBody = readJson.readJson("user", "user.json");
        String payload = jsonBody.toString().replace("{{name}}", name);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("body", payload);

        request = given().contentType(ContentType.JSON).body(params);
        response = request.when().post();



    }




    @Quando("^Faco uma requisicao GET na api para o usuario \"([^\"]*)\"$")
    public void request_get_user_api(String usuario) throws Throwable {
        request = given().contentType(ContentType.JSON);
        response = request.when().get(String.valueOf(usuario));
        Helpers.setResponseUsers(response);
        System.out.println("response:" + Helpers.getResponseUsers().body().toString());
    }

    @Entao("^o codigo de status da resposta deve ser \"([^\"]*)\"$")
    public void code_should_be(String status) throws Throwable {
        response.then().statusCode(Integer.parseInt(status));

    }


    @Quando("^eu faco uma requisicao PUT para usuario \"([^\"]*)\"$")
    public void request_put_user(String user) throws Throwable {
        name = faker.name().fullName();
        Helpers.setName(name);

        JSONObject jsonBody = readJson.readJson("user", "user.json");
        String payload = jsonBody.toString().replace("{{name}}", name);
        String teste = Helpers.getName();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("body", payload);

        request = given().contentType(ContentType.JSON).body(params);
        response = request.when().put(user);

        ResponseBody body = response.getBody();
        String res = body.asString();

    }

    @E("^valido a resposta do usuario criado$")
    public void validoSeOUsuarioFoiCriado() {
        ResponseBody body = response.getBody();
        String res = body.asString();
        assertTrue(name, res.contains(name));
        System.out.println("Response Body for user created: " + body.asString());
    }
}