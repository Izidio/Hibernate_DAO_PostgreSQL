/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import DAO.FileDAO;
import Ultil.*;

import java.io.IOException;

/**
 *
 * @author Izidio Carvalho
 */
public class Teste_Salvar_CSV {

    public static void main(String[] args) throws IOException {
        Hibernate hibernate = new Hibernate();
        FileDAO fileDao = new FileDAO();

        //modifica o arquivo
        Salvar.escrever(Salvar.create_CSV());

        hibernate.start_db();

        fileDao.salvar(CSV.file_CSV(Salvar.get_status()), hibernate.get_session());

        hibernate.end_db();
    }
}
