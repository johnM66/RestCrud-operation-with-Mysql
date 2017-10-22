package com.mypack.Client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientGetMethod {

	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/MyrestOperation/rest/test");

			ClientResponse response = webResource.accept("application/xml")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String responseXml = response.getEntity(String.class);

			System.out.println("Response from Server .... \n");
			System.out.println(responseXml);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}