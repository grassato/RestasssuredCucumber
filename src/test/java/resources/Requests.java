package resources;

import base.BaseBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Requests {

    static Response response;
    RequestSpecification reqspec;

    //This method receives a param value and uses it to call the API in request()
    public Response getRequest(final String apiName, final Method requestType, String paramValue) {

        APIResources resourceAPI = APIResources.valueOf(apiName);
        reqspec = new BaseBuilder().placeSpecBuilder();

        System.out.println("Sending " + requestType.toString() + " request to: " + resourceAPI.getResource() + " service");

        response = given()
                .spec(reqspec)
                .request(requestType.toString(), resourceAPI.getResource(), paramValue)
                .then()
//                .log().all()
                .extract()
                .response();

        return response;
    }

    public Response getRequestGivenApiName(final String apiName) {

        APIResources resourceAPI = APIResources.valueOf(apiName);
        reqspec = new BaseBuilder().placeSpecBuilder();

        System.out.println("Sending GET request to: " + resourceAPI.getResource() + " service");

        response = given()
                .spec(reqspec)
                .get(resourceAPI.getResource())
                .then()
                //.log().all()
                .extract()
                .response();

        return response;
    }
}


