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
 * @author Izidio
 */
public class Teste_Usuarios_Update {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Hibernate hibernate = new Hibernate();
        Seguranca seguranca = new Seguranca();
        UsuariosDAO user = new UsuariosDAO();

        hibernate.start_db();
        user.updateUser(hibernate.get_session(), "izidioSC", seguranca.gerarHash("izidiocarvalho10"));
        hibernate.end_db();
    }
}
