/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Izidio
 */
public interface Dao {
    public void salvar(Object obj, Session session);
    public List get_db(Session session);
}
