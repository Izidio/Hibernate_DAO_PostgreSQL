/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultil;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Izidio Carvalho
 */
public class Seguranca {
  public static String gerarHash(String texto) throws NoSuchAlgorithmException{
      String hash;
      MessageDigest m = MessageDigest.getInstance("MD5");
      m.update(texto.getBytes(), 0, texto.length());
      hash=new BigInteger(1,m.digest()).toString(16);
      System.out.println("texto: "+texto+"\nMD5: "+hash);
  return hash;
  }  
}
