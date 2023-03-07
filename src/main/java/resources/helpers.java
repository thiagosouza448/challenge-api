package resources;

import io.restassured.response.Response;

public class helpers {
	private Response responseUsers;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setResponseUsers(Response responseUsers) {
		this.responseUsers = responseUsers;
	}

	public Response getResponseUsers() {
		return responseUsers;
	}

}
