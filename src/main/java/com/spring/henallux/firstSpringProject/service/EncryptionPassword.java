package com.spring.henallux.firstSpringProject.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionPassword {

    private static MessageDigest md;

    public static String getEncryptionPassword(String pass){
        try{
            //Pas un chiffrage suffisant
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException ex) {
            throw new Error(ex.getMessage());
        }
    }

}
