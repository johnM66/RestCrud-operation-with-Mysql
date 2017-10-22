package com.mypack.Client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPostMethod {

	public static void main(String[] args) {

		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/MyrestOperation/rest/test");

			 String inputValue = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><user><id>1</id><name>amit</name><age>28</age></user>";

			ClientResponse response = webResource.type("application/xml")
					.post(ClientResponse.class, inputValue);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Response from Server .... \n");
			String responseXml = response.getEntity(String.class);
			System.out.println(responseXml);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
