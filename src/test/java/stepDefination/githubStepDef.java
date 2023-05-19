package stepDefination;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.payLoadConverter;

public class githubStepDef {
	public static String createRepoDetails;
	public static String baseurl="https://api.github.com";
	public static String token ="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";
	RequestSpecification requestSpecification;
	Response response;
	public static String ownerName;
	public static String RepoName;
	
	@Given("Get Payload from {string} for repo")
	public void get_payload_from_for_repo(String jsonfilename) throws IOException {
		createRepoDetails = payLoadConverter.generatePayloadString(jsonfilename) ;
//		System.out.println(createRepoDetails);
	}
	@When("Create Repo {string} and provide token")
	public void create_repo_and_provide_token(String resource) {
		requestSpecification = RestAssured.given().body(createRepoDetails) ;
		   requestSpecification.contentType(ContentType.JSON) ;
		   requestSpecification.header("Authorization", "Bearer " + token);
		   response = requestSpecification.post(baseurl + resource ) ;
	}
	@Then("Successfully Create with status code {int}")
	public void successfully_create_with_status_code(int statusCode) {
		Assert.assertEquals(statusCode, response.getStatusCode());
//		System.out.println(statusCode);
	}
	@Then("Verify owner Name")
	public void verify_owner_name() {
		String result = response.asPrettyString() ;
//		System.out.println(result);
		
//		Getting Owner Name
		JsonPath Ownerjs = new JsonPath(result);
		String fullName = Ownerjs.get("full_name") ;
		String[] arrOfStr = fullName.split("/");
		ownerName = arrOfStr[0] ;
//		System.out.println(ownerName);
		
		 RepoName = Ownerjs.get("name") ;
//		 System.out.println(RepoName);
	}

	
	

	@Given("Should have repository and owner")
	public void should_have_repository_and_owner() {
//	Assert.assertTrue(ownerName);
//	Assert.assertTrue(RepoName);
	Assert.assertNotNull(RepoName);
	Assert.assertNotNull(ownerName);
	}
	@When("get repository  {string} owner \\/repo")
	public void get_repository_owner_repo(String resource) {
		requestSpecification = RestAssured.given();
		   requestSpecification.contentType(ContentType.JSON) ;
		   requestSpecification.header("Authorization", "Bearer " + token);
		   response = requestSpecification.get(baseurl + resource + ownerName + "/" + RepoName) ;
	}
	@Then("Successfully got repository with status code {int}")
	public void successfully_got_repository_with_status_code(int statusCode) {
	   Assert.assertEquals(statusCode, response.getStatusCode());
	}
	@Then("Verify repository")
	public void verify_repository() {
	    Assert.assertNotNull(RepoName);
	    response.prettyPrint();
	}
//
//
//	
	@Given("Should have token")
	public void should_have_token() {
	    Assert.assertNotNull(token);
	}
	@When("list the public repository {string}")
	public void list_the_public_repository(String resource) {
		requestSpecification = RestAssured.given();
		   requestSpecification.contentType(ContentType.JSON) ;
		   requestSpecification.header("Authorization", "Bearer " + token);
		   response = requestSpecification.get(baseurl + resource) ;
//		   System.out.println(response.jsonPath().get(RepoName));
		  
	}
	@Then("Successfully listed public repository with status code {int}")
	public void successfully_listed_public_repository_with_status_code(int statusCode) {
		Assert.assertEquals(statusCode, response.getStatusCode());
	}
	@Then("Verify list public repository")
	public void verify_list_public_repository() {
	    System.out.println("passed test");
	    response.prettyPrint();
	}
//
//
//
//	
	@Given("Should have repository and owner and token")
	public void should_have_repository_and_owner_and_token() {
		Assert.assertNotNull(RepoName);
		Assert.assertNotNull(ownerName);
	}
	@When("list repository tags {string} owner \\/repo {string}")
	public void list_repository_tags_owner_repo(String resource1, String resource2) {
		requestSpecification = RestAssured.given();
		   requestSpecification.contentType(ContentType.JSON) ;
		   requestSpecification.header("Authorization", "Bearer " + token);
		   response = requestSpecification.get(baseurl + resource1 +ownerName +"/" + RepoName + resource2) ;
//		   System.out.println(response.asPrettyString());
//		   response.prettyPrint();
	}
	@Then("Successfully listed repository tags with status code {int}")
	public void successfully_listed_repository_tags_with_status_code(int statusCode) {
		Assert.assertEquals(statusCode, response.getStatusCode());
	}
	@Then("Verify list repository tags")
	public void verify_list_repository_tags() {
//	    System.out.println("verified list of repos tags");
		response.prettyPrint();
	}

//
//	
//
	@Given("Should have repository")
	public void should_have_repository() {
		Assert.assertNotNull(RepoName);
	}
	@When("get all repository topics {string} owner \\/repo {string}")
	public void get_all_repository_topics_owner_repo(String resource1, String resource2) {
		requestSpecification = RestAssured.given();
		   requestSpecification.contentType(ContentType.JSON) ;
		   requestSpecification.header("Authorization", "Bearer " + token);
		   response = requestSpecification.get(baseurl + resource1 +ownerName +"/" + RepoName + resource2) ;
//		   System.out.println(response.asPrettyString());
//		   response.prettyPrint();
	}
	
	@Then("Successfully got all repository with status code {int}")
	public void successfully_got_all_repository_with_status_code(int statusCode) {
		Assert.assertEquals(statusCode, response.getStatusCode());
	}
	@Then("Verify all repository topics")
	public void verify_all_repository_topics() {
		response.prettyPrint();
	}
//
//
//	
	@Given("Get Payload from {string}")
	public void get_payload_from(String data) throws IOException{
		createRepoDetails = payLoadConverter.generatePayloadString(data) ;
	}
	@When("replace all repository topics {string} owner \\/repo {string}")
	public void replace_all_repository_topics_owner_repo(String resource1, String resource2) {
		requestSpecification = RestAssured.given().body(createRepoDetails) ;
		   requestSpecification.contentType(ContentType.JSON) ;
		   requestSpecification.header("Authorization", "Bearer " + token);
		   response = requestSpecification.get(baseurl + resource1 +ownerName +"/" + RepoName + resource2) ;
	}
	@Then("Successfully replaced all repository topics with status code {int}")
	public void successfully_replaced_all_repository_topics_with_status_code(int statusCode) {
		Assert.assertEquals(statusCode, response.getStatusCode());
	}
	@Then("Verify replaced repository tpoics")
	public void verify_replaced_repository_tpoics() {
	    System.out.println("verified");
	    response.prettyPrint();
	}
//



}
