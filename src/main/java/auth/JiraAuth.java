//package auth;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import net.sf.json.JSONObject;
//
//public class JiraAuth {
//
//	public void createJessionID() {
//		
//		JSONObject json = new JSONObject();
//		json.put("username", "anujam.mondal@cerner.com");
//		json.put("password", "asdfvcxz!@#4");
//		
//		Response response = RestAssured.given().header("Content-Type", "application/json")
//				.body(json)
//				.post("http://jira.example.com:8080/jira/rest/auth/1/session");
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getBody().jsonPath().prettify());
//		System.out.println("Cookie: " + response.getCookies());
//		
//	}
//}
