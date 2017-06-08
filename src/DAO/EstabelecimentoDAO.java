/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Estabelecimento;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Izidio
 */
public class EstabelecimentoDAO implements Interfaces.Dao {

    @Override
    public void salvar(Object obj, Session session) {
        System.out.println("Inserindo arquivos no Banco...");
        session.flush();
        session.save(obj);
        System.out.println("Arquivos Inseridos!");
    }

    @Override
    public List get_db(Session session) {
        List<Estabelecimento> listEstabelecimentos = new ArrayList();
        Criteria crit = session.createCriteria(Estabelecimento.class);
        List results = crit.list();

        return results;
    }

}
