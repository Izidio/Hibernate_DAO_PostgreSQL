/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Model.DAO.UsuariosDAO;
import Ultil.Hibernate;
import Ultil.Seguranca;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Izidio Carvalho
 */
public class Teste_Usuarios_Consulta {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Hibernate hibernate = new Hibernate();
        Seguranca seguranca = new Seguranca();
        UsuariosDAO user = new UsuariosDAO();

        String s1 = "123456";
        String s2 = "56a2ew";
        String s3 = "qaaf12";
        String s4 = "abcd20";

        String nome1 = "Izidio Carvalho";
        String nome2 = "Izidio Carvalho";
        String nome3 = "Izidio Sousa";
        String nome4 = "Izidio Sousa de Carvalho";

        String usuario_nome = "izidio_carvalho";
        hibernate.start_db();
//        System.out.println(user.get_db(hibernate.get_session()));
        boolean resultado = user.login(seguranca.gerarHash(s1), usuario_nome, hibernate.get_session());
        
        if (resultado) {
            System.out.println("Seja Bem-Vindo " + usuario_nome);
        } else {
            System.out.println("usuario e/ou senha invalido(s)");
        }
        hibernate.end_db();
    }
}
