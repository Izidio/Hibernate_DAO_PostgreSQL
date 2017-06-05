/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Entidades.Categoria;
import Entidades.Produto;
import java.io.IOException;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Izidio
 */
public class Teste {

    static SessionFactory factory = new Configuration().configure().buildSessionFactory();
    static Session session;

    public static void main(String[] args) throws IOException {
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Categoria categoria = new Categoria();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.set(Calendar.YEAR, 2016);
        c1.set(Calendar.MONTH, Calendar.MARCH);
        c1.set(Calendar.DAY_OF_MONTH, 1);

        c2.set(Calendar.YEAR, 2017);
        c2.set(Calendar.MONTH, Calendar.JULY);
        c2.set(Calendar.DAY_OF_MONTH, 1);

        categoria.setNome("Categoria 1");

        produto1.setNome("produto 1");
        produto1.setDescricao("Descrição do produto 1");
        produto1.setFabricacao(c1);
        produto1.setValidade(c2);
        produto1.setCategoria(categoria);

        produto2.setNome("produto 2");
        produto2.setDescricao("Descrição do produto 2");
        produto2.setFabricacao(c1);
        produto2.setValidade(c2);
        produto2.setCategoria(categoria);

        start_db();
        set_db(categoria);
        set_db(produto1);
        set_db(produto2);

        end_db();
    }

    static void start_db() {
        session = factory.openSession();
        session.beginTransaction();
        System.out.println("Sessão Iniciada!");
    }

    static void end_db() {
        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
        System.out.println("Sessão Finalizada!");
    }

    static void set_db(Object obj) {
        System.out.println("Inserindo arquivos no Banco...");
        session.flush();
        session.save(obj);
        System.out.println("Arquivos Inseridos!");

    }

}
