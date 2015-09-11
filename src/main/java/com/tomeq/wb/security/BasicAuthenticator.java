package com.tomeq.wb.security;

import javax.ws.rs.core.HttpHeaders;
import org.apache.commons.codec.binary.Base64;

import com.tomeq.wb.exception.NotAuthorizedException;

public class BasicAuthenticator {

	public static String authenticate(HttpHeaders headers) throws NotAuthorizedException{
		if(headers.getRequestHeader("Authorization").size() > 0 ) {
			String header = headers.getRequestHeader("Authorization").get(0);
			String[] splitHeader = header.split("\\s");
			String encodedCredentials = splitHeader[1];
			String decodedString = new String(Base64.decodeBase64(encodedCredentials));
			String[] decodedCredentials = decodedString.split(":");

			String username = decodedCredentials[0];
			String password = decodedCredentials[1];

			if(isAuthenticated()){
				return username;
			}
		}
		throw new NotAuthorizedException("Authentication failed!");
	}

	private static boolean isAuthenticated() {
		return true;
	}
}
