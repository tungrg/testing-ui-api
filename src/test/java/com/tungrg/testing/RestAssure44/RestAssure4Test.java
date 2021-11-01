package com.tungrg.testing.RestAssure44;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.asynchttpclient.Request;
import org.testng.annotations.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.hamcrest.Matchers.*;


public class RestAssure4Test extends  RestAssureBaseTest{
    @Test
    public void testingRestAssuredSimpleEnpointVerification(){
        String baseURL = "https://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseURL)
                .addParam("key","7eb763e2aa804cef9f931743212210")
                .addParam("q","Lviv")
                .addParam("days","1");
        Response rp = RestAssured.given(spec.build())
                .get("/current.json");
        log.info("");
        rp.then().assertThat().log().all().body("location.name", equalTo("Lviv"));
    }
    @Test
    public void testLocation() throws FileNotFoundException {
        String baseURL = "https://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseURL)
                .addParam("key","7eb763e2aa804cef9f931743212210")
                .addParam("q","Ho_Chi_Minh")
                .addParam("aqi","yes")
                .addParam("days","1");

        Response rp = RestAssured.given(spec.build())
                .get("/forecast.json");
        rp.prettyPrint();
        rp.then().assertThat().log().all().body("location.name", equalTo("Ho Chi Minh City"));


        FileWriter fileWrite = null;
        BufferedWriter bufferWrite = null;
        PrintWriter outWrite = null;
        try {
            fileWrite = new FileWriter("result.json");
            bufferWrite = new BufferedWriter(fileWrite);
            outWrite = new PrintWriter(bufferWrite);
            outWrite.write(rp.asString());
            outWrite.close();

        } catch (IOException e) {
            System.err.println(e); //if err happen, print it
        } finally { //print the result of write file process
            if (outWrite != null) {
                System.out.println("Write to file successfully");
            }
            else System.out.println("Failed to Write File");
        }
    }
    @Test
    public void testCountry(){
        String baseURL = "https://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseURL)
                .addParam("key","7eb763e2aa804cef9f931743212210")
                .addParam("q","Ho_Chi_Minh")
                .addParam("aqi","yes")
                .addParam("days","1");

        Response rp = RestAssured.given(spec.build())
                .get("/forecast.json");
        rp.then().assertThat().log().all().body("location.country", equalTo("Vietnam"));
    }
    @Test
    public void testForecastDay(){
        String baseURL = "https://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseURL)
                .addParam("key","7eb763e2aa804cef9f931743212210")
                .addParam("q","Ho_Chi_Minh")
                .addParam("aqi","yes")
                .addParam("days","1");

        Response rp = RestAssured.given(spec.build())
                .get("/forecast.json");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String nowStr = dtf.format(now);
        //rp.then().assertThat().log().all().body("forecast.forecastday.date",(new ArrayList<String>().add(dtf.format(now))));
        rp.then().assertThat().log().all().body(containsString(nowStr));
    }
    @Test
    public void testIsDay(){
        String baseURL = "https://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseURL)
                .addParam("key","7eb763e2aa804cef9f931743212210")
                .addParam("q","Ho_Chi_Minh")
                .addParam("aqi","yes")
                .addParam("days","1");

        Response rp = RestAssured.given(spec.build())
                .get("/forecast.json");

        rp.then().assertThat().log().all().body("current.is_date",equalTo((new Integer(1))));
    }
    @Test
    public void testRegion(){
        String baseURL = "https://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseURL)
                .addParam("key","7eb763e2aa804cef9f931743212210")
                .addParam("q","Ho_Chi_Minh")
                .addParam("aqi","yes")
                .addParam("days","1");

        Response rp = RestAssured.given(spec.build())
                .get("/forecast.json");

        rp.then().assertThat().log().all().body("location.tz_id",equalTo("Asia/Ho_Chi_Minh"));
    }
    @Test
    public void testLat(){
        String baseURL = "https://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseURL)
                .addParam("key","7eb763e2aa804cef9f931743212210")
                .addParam("q","Ho_Chi_Minh")
                .addParam("aqi","yes")
                .addParam("days","1");

        Response rp = RestAssured.given(spec.build())
                .get("/forecast.json");

        rp.then().assertThat().log().all().body("location.lat",equalTo(new Float(10.75)));
    }
    @Test
    public void testLong(){
        String baseURL = "https://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseURL)
                .addParam("key","7eb763e2aa804cef9f931743212210")
                .addParam("q","Ho_Chi_Minh")
                .addParam("aqi","yes")
                .addParam("days","1");

        Response rp = RestAssured.given(spec.build())
                .get("/forecast.json");

        rp.then().assertThat().log().all().body("location.lon",equalTo(new Float(106.67)));
    }
    @Test
    public void testCurrentTempC(){
        String baseURL = "https://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseURL)
                .addParam("key","7eb763e2aa804cef9f931743212210")
                .addParam("q","Ho_Chi_Minh")
                .addParam("aqi","yes")
                .addParam("days","1");

        Response rp = RestAssured.given(spec.build())
                .get("/forecast.json");

        rp.then().assertThat().log().all().body("current.temp_c",equalTo(new Float(34)));
    }
    @Test
    public void testCurrentTempF(){
        String baseURL = "https://api.weatherapi.com/v1";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseURL)
                .addParam("key","7eb763e2aa804cef9f931743212210")
                .addParam("q","Ho_Chi_Minh")
                .addParam("aqi","yes")
                .addParam("days","1");

        Response rp = RestAssured.given(spec.build())
                .get("/forecast.json");

        rp.then().assertThat().log().all().body("current.temp_f",equalTo(new Float(93.2)));
    }
}
