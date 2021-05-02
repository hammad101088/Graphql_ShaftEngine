package graphqlApi;

import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.api.RestActions;
import com.shaft.tools.io.JSONFileManager;

import graphqlApi.objectModel.GraphqlApiAuthentication;
import graphqlApi.objectModel.GraphqlApi_base;
import graphqlApi.objectModel.Resolvers;
import io.restassured.response.Response;

public class AuthenticationObjectModelTest {

	// variables and instances
	RestActions apiObject;
	GraphqlApiAuthentication graphqlApiAuthentication;
	Date date = new Date();
	String current_time = date.getTime() + "";

	// get data from json file
	JSONFileManager jsonFile;

	// methods
	@BeforeClass
	public void beforeClass() {

		graphqlApiAuthentication = new GraphqlApiAuthentication(apiObject);
		jsonFile = new JSONFileManager(System.getProperty("testDataFolderPath") + "graph/jsonFile.json");

	}

	@Test
	public void logInUsingValidInputData_checkStatusCodeAndMessage_shouldBeSuccess() {
		
		String operationName = Resolvers.login_operationName;

		Response login_response = graphqlApiAuthentication.logIn(
				jsonFile.getTestData("login.phone"),
				jsonFile.getTestData("login.password"));

		GraphqlApi_base.verifyStatusCode(login_response, operationName);
		GraphqlApi_base.verifyResponseMessage(login_response, operationName);

	}

	@Test
	public void signUpUsingValidInputData_checkStatusCodeAndMessage_shouldBeSuccess() {

		String operationName = Resolvers.signUp_operationName;

		Response register_response = graphqlApiAuthentication.signup(
				jsonFile.getTestData("register.firstName"),
				jsonFile.getTestData("register.lastName"),
				jsonFile.getTestData("register.email") + current_time + "@test.test",
				jsonFile.getTestData("register.phone") + current_time.substring(0, 9),
				jsonFile.getTestData("register.password"));

		GraphqlApi_base.verifyStatusCode(register_response, operationName);
		GraphqlApi_base.verifyResponseMessage(register_response, operationName);
	}



}
