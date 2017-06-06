/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultil;

import Entidades.Retail;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
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

    public static void set_db(Object obj) {
        System.out.println("Inserindo arquivos no Banco...");
        session.flush();
        session.save(obj);
        System.out.println("Arquivos Inseridos!");

    }

    public static List get_db(String campo, String referencia, Object obj) {
        Criteria crit = session.createCriteria(obj.getClass());
//        crit.add(Restrictions.gt(campo, referencia));
//        crit.addOrder(Order.desc(campo));
        List results = crit.list();
        return results;

    }

}
