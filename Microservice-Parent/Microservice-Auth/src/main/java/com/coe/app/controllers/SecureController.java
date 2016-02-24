package com.coe.app.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

@RestController
public class SecureController {

	@RequestMapping("/secure")
	public String secure() {
		return "Secure Controller !!";
	}

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	@RequestMapping("/callTaskService")
	public String callingTaskServiceCtrlMtd(Principal user){
		System.out.println("\n\n== Calling Task Controller ..");
		//ResponseEntity<String> response = restTemplate.getForEntity("http://task-service/task", String.class);
		
		
		System.out.println("\n\n === Principal User Object Data = "+user);
		
		try {
			JSONObject jsonObject = new JSONObject();
			System.out.println(" ========>> "+jsonObject.getString("data"));
			System.out.println("=====>> "+new JSONObject(jsonObject.getString("data")).getString("tokenType"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*-- way to set header -- */
		HttpHeaders headers = new HttpHeaders();
        String personalToken = "";//restTemplate.getRequestFactory().;
        headers.add("Authorization", "token " + personalToken);
        // ignore result because just testing connectivity
        HttpEntity<String> request = new HttpEntity<String>(headers);

		
		
		ResponseEntity<String> response = restTemplate.exchange("http://task-service/task", HttpMethod.GET, request,String.class);

		System.out.println("statusCode == " + response.getStatusCode());
		System.out.println(response);
		return response.getBody();
	}
	
	@RequestMapping("/callUserService")
	public String callingUserServiceCtrlMtd() {
		
		System.out.println("\n\n== Calling User Controller ..");
		
		ResponseEntity<String> response = restTemplate.getForEntity("http://user-service/user", String.class);

		System.out.println("statusCode == " + response.getStatusCode());
		System.out.println(response);
		return response.getBody();
	}
	
	

}
