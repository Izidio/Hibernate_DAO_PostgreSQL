/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Produto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Izidio
 */
public class FileDAO implements Interfaces.Dao {

    public void salvar(List lista, Session session) {
        System.out.println("Carregando...");
        int quantidade = 0;
        for (int i = 0; i < lista.size(); i++) {
            session.flush();
            session.save(lista.get(i));
            if (i == quantidade) {
                System.out.println("carregados -> " + quantidade);
                quantidade += 1000;
            }
        }
        System.out.println("Todos os " + lista.size() + " dados foram inseridos!");

    }

    @Override
    public List get_db(Session session) {
        List<Produto> listProdutos = new ArrayList();
        Criteria crit = session.createCriteria(Produto.class);
        List results = crit.list();

        return results;
    }

    @Override
    public void salvar(Object obj, Session session) {

    }

}
