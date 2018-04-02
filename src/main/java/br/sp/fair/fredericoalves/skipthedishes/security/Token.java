package br.sp.fair.fredericoalves.skipthedishes.security;

import java.io.Serializable;

/**
 * Token
 *
 * @author frederico.alves
 *
 */
public class Token implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 176195457510721692L;

	private String userHeader;
	private String pwdHeader;

	public Token(String userHeader, String pwdHeader) {
		this.userHeader = userHeader;
		this.pwdHeader  = pwdHeader;
	}

	public String getHeaderToken() {
		return this.userHeader + ":" + this.pwdHeader;
	}
}
