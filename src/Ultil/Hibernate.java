/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultil;

import Entidades.Usuarios;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Izidio
 */
public class Hibernate {

    static SessionFactory factory = new Configuration().configure().buildSessionFactory();
    static Session session;

    public static void start_db() {
        session = factory.openSession();
        session.beginTransaction();
        System.out.println("Sessão Iniciada!");
    }

    public static void end_db() {
        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
        System.out.println("Sessão Finalizada!");
    }

    public static Session get_session(){
        return Hibernate.session;
    }
    public static void set_db(Object obj) {
        System.out.println("Inserindo arquivos no Banco...");
        session.flush();
        session.save(obj);
        System.out.println("Arquivos Inseridos!");

    }

    public static boolean get_db(String hash, String nome) {
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
                return true;
            } else {
                return false;
            }
        } else {
            if (results.size() == 0) {
                System.out.println("Nenhuma correspondencia encontrada.");
            } else {
                System.out.println("Foram encontrados multiplos resultdos.");
            }

        }

        return false;
    }
    
        public static void CSV_set_db(List lista) {
        System.out.println("Carregando...");
        int quantidade = 0;
        for (int i = 0; i < lista.size(); i++) {
            session.flush();
            session.save(lista.get(i));
            if (i == quantidade) {
                System.out.println("carregados -> "+quantidade);
                quantidade += 1000;
            }
        }
        System.out.println("Todos os " + lista.size() + " dados foram inseridos!");

    }

}
