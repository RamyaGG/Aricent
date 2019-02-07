package com.restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostCall {

	@Test
	public void createCustomerTest() {
		
	/*	{

			"lotto":{

			"lottoId":5,

			"winning-numbers":[2,45,34,23,7,5,3],

			"winners":[{

			   "winnerId":23,

			   "numbers":[2,45,34,23,3,5]

			},{

			   "winnerId":54,

			   "numbers":[52,3,12,11,18,22]

			}]

			}

			} */		
		RestAssured.baseURI = "http://localhost:8080";

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestJson = new JSONObject();
		requestJson.put("lottoId", "5"); 

		httpRequest.header("Authorization", "Bearer ABCDE12345ABCDE", "Content-Type", "application/json");
		httpRequest.cookie("value","true","encode","false");

		httpRequest.body(requestJson.toJSONString());

		Response response = httpRequest.post("/lotto");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is " + responseBody);	

		JsonPath jsonPath = response.jsonPath().setRoot("lotto");
		int lottoId = jsonPath.getInt("lottoId");
		List<Integer> winnerIds = jsonPath.get("winners.winnderId");

		Assert.assertEquals(lottoId, 25,"LottoId Mismatch");
		Assert.assertEquals(winnerIds, hasItem(23));



}
	
}
