 package com.sinotopia.niorest;

import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest(classes = SpringNioRestApplication.class, webEnvironment=WebEnvironment.DEFINED_PORT, properties="server.port=9090")
public class SpringNioRestApplicationRestTemplateTest extends AbstractTestNGSpringContextTests{

private static final String BASE_URL = "http://localhost:9090";
	
	RestTemplate rt = new RestTemplate();
	
	@Test
	public void syncRestTemplateTest() {
		doRequest(BASE_URL+"/sync/data");
	}
	
	@Test
	public void asyncRestTemplateTest() {
		doRequest(BASE_URL+"/deferred/data");
	}
	
	@SuppressWarnings("rawtypes")
	private void doRequest(String url){
		long t0 = System.currentTimeMillis();
		ResponseEntity<List> response = rt.getForEntity(url, List.class);
		if(response.getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR){
			Assert.fail();
		}else{
			long t1 = System.currentTimeMillis();
			System.out.printf("url %s - %s mseg%n",url, (t1-t0));
			Assert.assertEquals(response.getBody().size(), 20);
		}
	}}
