/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Model.DAO.UsuariosDAO;
import Model.DAO.Usuarios_CategoriaDAO;
import Entidades.Usuarios;
import Entidades.Usuarios_Categoria;
import Ultil.Hibernate;
import Ultil.Seguranca;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Izidio
 */
public class Teste_Usuarios_Insere {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Hibernate hibernate = new Hibernate();
        UsuariosDAO userDAO = new UsuariosDAO();
        Usuarios_CategoriaDAO catDao = new Usuarios_CategoriaDAO();
        Seguranca seguranca = new Seguranca();

        Usuarios usuario1 = new Usuarios();
        Usuarios usuario2 = new Usuarios();
        Usuarios usuario3 = new Usuarios();
        Usuarios usuario4 = new Usuarios();

        Usuarios_Categoria categoria1 = new Usuarios_Categoria();
        Usuarios_Categoria categoria2 = new Usuarios_Categoria();
        Usuarios_Categoria categoria3 = new Usuarios_Categoria();
        Usuarios_Categoria categoria4 = new Usuarios_Categoria();

        categoria1.setNome("Administrador");
        categoria2.setNome("Entrevistador");
        categoria3.setNome("Digitador");
        categoria4.setNome("Entrevistador");

        //setNome
        usuario1.setNome("Izidio Carvalho");
        usuario2.setNome("Izidio Carvalho");
        usuario3.setNome("Izidio Sousa");
        usuario4.setNome("Izidio Sousa de Carvalho");

        //setUsuario
        usuario1.setUsuario("izidio_carvalho");
        usuario2.setUsuario("izidio.carvalho");
        usuario3.setUsuario("izidio_sousa");
        usuario4.setUsuario("izidioSC");

        //setCategoria
        usuario1.setCategoria(categoria1);
        usuario2.setCategoria(categoria2);
        usuario3.setCategoria(categoria3);
        usuario4.setCategoria(categoria4);

        //setSenha
        String s1 = "123456";
        String s2 = "56a2ew";
        String s3 = "qaaf12";
        String s4 = "abcd20";

        usuario1.setSenha(seguranca.gerarHash(s1));
        usuario2.setSenha(seguranca.gerarHash(s2));
        usuario3.setSenha(seguranca.gerarHash(s3));
        usuario4.setSenha(seguranca.gerarHash(s4));

        //funcoes do banco
        hibernate.start_db();

        catDao.salvar(categoria1, hibernate.get_session());
        catDao.salvar(categoria2, hibernate.get_session());
        catDao.salvar(categoria3, hibernate.get_session());
        catDao.salvar(categoria4, hibernate.get_session());

        userDAO.salvar(usuario1, hibernate.get_session());
        userDAO.salvar(usuario2, hibernate.get_session());
        userDAO.salvar(usuario3, hibernate.get_session());
        userDAO.salvar(usuario4, hibernate.get_session());

        Hibernate.end_db();
    }
}
