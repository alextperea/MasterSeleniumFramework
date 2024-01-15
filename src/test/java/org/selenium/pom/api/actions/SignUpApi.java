package org.selenium.pom.api.actions;


import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SignUpApi {

    private Cookies cookies;

    public Cookies getCookies(){
        return cookies;
    }

    private void getAccount(){
        RestAssured.baseURI = "https://askomdch.com";

        int a = 0;
        int b = 0;
        int c = 0;

    }
}
