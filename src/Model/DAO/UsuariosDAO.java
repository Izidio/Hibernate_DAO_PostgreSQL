/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

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
    
    public boolean login(String hash, String username, Session session) {
        
        boolean login = false;
        
        Criteria crit = session.createCriteria(Usuarios.class);
        crit.add(Restrictions.eq("usuario", username));
        List<Usuarios> results = crit.list();
        
        System.out.println("tamanho: " + results.size());
        
        if (results.size() == 1) {
            
            Usuarios user = results.get(0);
            String senha_hash = user.getSenha();
            
            login = hash.equals(senha_hash);
            
        } else if (results.size() == 0) {
            System.out.println("Nenhuma correspondencia encontrada.");
        } else {
            System.out.println("Foram encontrados multiplos resultdos.");
        }
        
        return login;
    }

    public void updateUser(Session session, String username, String senhaHash) {
        Criteria crit = session.createCriteria(Usuarios.class);
        crit.add(Restrictions.eq("usuario", username));
        List<Usuarios> results = crit.list();
        
        Usuarios user = results.get(0);
        user.setNome("novo nome");
        user.setSenha(senhaHash);
        session.update(user);
        System.out.println("senha mudada com sucesso.");
    }
    
}
