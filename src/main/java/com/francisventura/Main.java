package com.francisventura;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {

//        String message = "hello there";
//        byte[] encodedMessage = message.getBytes();
//
//        try{
//            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//            KeyPair keyPair = keyPairGenerator.generateKeyPair();
//            System.out.println(keyPair.getPublic());
//            PublicKey publicKey = keyPair.getPublic();
//            PrivateKey privateKey = keyPair.getPrivate();
//            String encryptedMessage = encryptMessage(encodedMessage, publicKey);
//            System.out.println(encryptedMessage);
//            System.out.println(decodeMessage(encryptedMessage, privateKey));
//
//        }catch (NoSuchAlgorithmException noSuchAlgorithmException) {
//            noSuchAlgorithmException.printStackTrace();
//            System.out.println("no such algorithm exception");
//        }catch (Exception exception){
//            exception.printStackTrace();
//            System.out.println("exception occurred on main");
//        }

        

    }

    public static String encryptMessage(byte[] encodedMessage, PublicKey publicKey){

        try{
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipher.update(encodedMessage);
//            Base64.getDecoder().decode(publicKeyPEM);
            return Base64.getEncoder().encodeToString(cipher.doFinal());
        }catch (NoSuchPaddingException noSuchPaddingExceptionException){
            noSuchPaddingExceptionException.printStackTrace();
            System.out.println("no such padding in encryptedMessage method");
        }catch (NoSuchAlgorithmException noSuchAlgorithmException){
            noSuchAlgorithmException.printStackTrace();
            System.out.println("no such algorithm exception in encryptMessage method");
        }catch (InvalidKeyException invalidKeyException){
            invalidKeyException.printStackTrace();
            System.out.println("invalid key in encryptMessage");
        }catch (IllegalBlockSizeException illegalBlockSizeException){
            illegalBlockSizeException.printStackTrace();
            System.out.println("illegal block size exception");
        }catch (BadPaddingException badPaddingException){
            badPaddingException.printStackTrace();
            System.out.println("bad padding");
        }
        return null;
    }

    public static String decodeMessage(String encryptedMessage, PrivateKey privateKey){
        try{
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            cipher.update(Base64.getDecoder().decode(encryptedMessage));
            return new String(cipher.doFinal());
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }
}
