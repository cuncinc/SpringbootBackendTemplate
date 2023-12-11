package com.guet.pipenet.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class CryptoUtil
{
    public static String hashPassword(String plain_password)
    {
        return BCrypt.hashpw(plain_password, BCrypt.gensalt(12));
    }

    public static boolean checkPassword(String password, String storedHash)
    {
        return BCrypt.checkpw(password, storedHash);
    }
}
