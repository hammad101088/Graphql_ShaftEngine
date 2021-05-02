package graphqlApi.objectModel;

import com.shaft.api.RestActions;

import io.restassured.response.Response;

public class GraphqlApiAuthentication {

	//**** variables
	RestActions apiObject;

	//**** constructor
	public GraphqlApiAuthentication(RestActions apiObject) {
		this.apiObject = apiObject;
	}

	//**** methods
	/**
	 * logIN using existing phone and password
	 * 
	 * @param phoneNumber
	 * @param password
	 * @return loginResponse
	 */
	@SuppressWarnings("unchecked")
	public Response logIn(String phoneNumber, String password) {

		String variables = "{\"phone\": \"" + phoneNumber + "\",\"password\":\"" + password + "\"}";
		return GraphqlApi_base.graphqlRequestBuilder(Resolvers.login_mutation, variables);

	}

	/**
	 * signUp using new credentials, only phone and email should be unique
	 * 
	 * @param firstName
	 * @param lastName
	 * @param emailAdress
	 * @param phoneNumber
	 * @param password
	 * @return registerResponse
	 */
	@SuppressWarnings("unchecked")
	public Response signup(String firstName, String lastName, String emailAdress, String phoneNumber,
			String password) {

		String variables = "{\"firstName\":\"" + firstName + "\",\"lastName\":\"" + lastName + "\",\"email\": \""
				+ emailAdress + "\" ,\"phone\": \"" + phoneNumber + "\",\"password\" :\"" + password
				+ "\"}";
		return GraphqlApi_base.graphqlRequestBuilder(Resolvers.signUp_mutation, variables);
	}

}
