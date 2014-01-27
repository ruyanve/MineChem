package pixlepix.minechem.common;

import org.jetbrains.annotations.NotNull;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

class GMailAuthenticator extends Authenticator {
	String user;
	String pw;

	public GMailAuthenticator(String username, String password) {
		super();
		this.user = username;
		this.pw = password;
	}

	@NotNull
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, pw);
	}
}