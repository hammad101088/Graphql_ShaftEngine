package graphqlApi.objectModel;

public class Resolvers {


	//login
	public static final String login_mutation = "mutation login($phone: String!, $password: String!) {\n"
			+ "  phoneAndPasswordLogin(input:{phone:$phone password:$password device:DESKTOP\n"
			+ "  }){code message success}}";
	public static final String login_operationName = "phoneAndPasswordLogin";
	
	//signUp
	public static final String signUp_mutation = "mutation ($firstName:String!,$lastName:String!,$email: String, $password: String!, $phone:String!, $role: UserRoleEnum!) {\r\n"
			+ "  register(input: { firstName:$firstName lastName: $lastName country: \"EG\" email: $email role:DOCTOR birthDate: 887459107 phone: $phone password: $password device: ANDROID}) {success message code success data{role}}}";
	public static final String signUp_operationName = "register";

	
	
}
