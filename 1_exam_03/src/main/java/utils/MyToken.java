package utils;

import org.apache.shiro.authc.UsernamePasswordToken;

public class MyToken extends UsernamePasswordToken {
	private String type;

	public MyToken(final String username, final String password, String type) {
		this(username, password != null ? password.toCharArray() : null, false, null, type);
	}

	public MyToken(final String username, final char[] password, final boolean rememberMe, final String host,
			String type) {

		super.setUsername(username);
		super.setPassword(password);
		super.setRememberMe(rememberMe);
		super.setHost(host);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
