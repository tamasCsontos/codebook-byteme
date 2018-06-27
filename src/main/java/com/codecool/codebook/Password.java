package com.codecool.codebook;


import org.mindrot.jbcrypt.BCrypt;

public class Password {

    private static int workload = 12;
    BCrypt bCrypt;

    public Password(BCrypt bCrypt) {
        this.bCrypt = bCrypt;
    }

    public String hashPassword(String password_plaintext) {
        String salt = bCrypt.gensalt(workload);
        String hashed_password = bCrypt.hashpw(password_plaintext, salt);

        return (hashed_password);
    }


    public boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified;

        if (null == stored_hash || !stored_hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = bCrypt.checkpw(password_plaintext, stored_hash);

        return (password_verified);
    }
}