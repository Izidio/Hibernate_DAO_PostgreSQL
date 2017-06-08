/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Entidades.Produto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Izidio
 */
public class ProdutoDAO implements Interfaces.Dao {

    @Override
    public void salvar(Object obj, Session session) {
        System.out.println("Inserindo arquivos no Banco...");
        session.flush();
        session.save(obj);
        System.out.println("Arquivos Inseridos!");
    }

    @Override
    public List get_db(Session session) {
        List<Produto> listProdutos = new ArrayList();
        Criteria crit = session.createCriteria(Produto.class);
        List results = crit.list();

        return results;
    }

}
