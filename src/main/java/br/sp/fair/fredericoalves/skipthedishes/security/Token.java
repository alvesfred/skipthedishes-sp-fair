package br.sp.fair.fredericoalves.skipthedishes.security;

import java.io.Serializable;

import lombok.Getter;

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

	@Getter
	private String token;
}
