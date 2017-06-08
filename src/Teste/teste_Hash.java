/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Ultil.Seguranca;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Izidio Carvalho
 */
public class teste_Hash {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String t=Seguranca.gerarHash("izidio");
        System.out.println("gerando: \n"+t);
    }
}
