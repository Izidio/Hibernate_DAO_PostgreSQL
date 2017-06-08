/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuarios;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Izidio
 */
public class UsuariosDAO implements Interfaces.Dao {

    @Override
    public void salvar(Object obj, Session session) {
        System.out.println("Inserindo arquivos no Banco...");
        session.flush();
        session.save(obj);
        System.out.println("Arquivos Inseridos!");
    }

    @Override
    public List get_db(Session session) {
        List<Usuarios> listUsers = new ArrayList();
        Criteria crit = session.createCriteria(Usuarios.class);
        List results = crit.list();

        return results;
    }

    public boolean login(String hash, String nome, Session session) {
        String senha_hash = "";
        String nome_usuario = "";
        boolean login = false;
        List<Usuarios> listUsers = new ArrayList();
        Criteria crit = session.createCriteria(Usuarios.class);
        crit.add(Restrictions.eq("senha", hash));
        List results = crit.list();
        if (results.size() == 1) {
            for (Usuarios user : listUsers) {
                nome_usuario = user.getNome();
                senha_hash = user.getSenha();
            }
            if (hash == senha_hash & nome == nome_usuario) {
                login= true;
            } else {
                login= false;
            }
        } else {
            if (results.size() == 0) {
                System.out.println("Nenhuma correspondencia encontrada.");
            } else {
                System.out.println("Foram encontrados multiplos resultdos.");
            }

        }

        return login;
    }

}
