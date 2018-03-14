package com.Team12.CS5800.VotingApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotingApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void loginLoads() {
		try {
			HttpResponse<String> response = Unirest.get("http://localhost:8080/login")
					  .header("Cache-Control", "no-cache")
					  .header("Postman-Token", "a20cdac7-5c33-43e0-9af0-a82d1eaa68ab")
					  .asString();
			org.junit.Assert.assertEquals(response.getStatus(), 200);
		} catch (UnirestException e) {
			org.junit.Assert.fail("Failed to execute the Unirest");
			e.printStackTrace();
		}
	}

}
