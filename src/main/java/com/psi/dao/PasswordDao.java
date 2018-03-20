package com.psi.dao;


import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordDao extends Object implements PasswordEncoder{
	private Pattern BCRYPT_PATTERN = Pattern
			.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");
	
	@Override
	public String encode(CharSequence arg0) {
		String salt;
		salt = BCrypt.gensalt();
		return BCrypt.hashpw(arg0.toString(), salt);
	}

	@Override
	public boolean matches(CharSequence arg0, String arg1) {
		if (arg1 == null || arg1.length() == 0) {
			return false;
		}

		if (!BCRYPT_PATTERN.matcher(arg1).matches()) {
			return false;
		}

		return BCrypt.checkpw(arg0.toString(), arg1);
	}

}
