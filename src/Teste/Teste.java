/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Entidades.Categoria;
import Entidades.Produto;
import Ultil.Hibernate;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Izidio
 */
public class Teste {

    public static void main(String[] args) throws IOException {
//        Produto produto1 = new Produto();
//        Produto produto2 = new Produto();
//        Categoria categoria = new Categoria();
//        Calendar c1 = Calendar.getInstance();
//        Calendar c2 = Calendar.getInstance();
//
//        c1.set(Calendar.YEAR, 2016);
//        c1.set(Calendar.MONTH, Calendar.MARCH);
//        c1.set(Calendar.DAY_OF_MONTH, 1);
//
//        c2.set(Calendar.YEAR, 2017);
//        c2.set(Calendar.MONTH, Calendar.JULY);
//        c2.set(Calendar.DAY_OF_MONTH, 1);
//
//        categoria.setNome("Categoria 1");
//
//        produto1.setNome("produto 1");
//        produto1.setDescricao("Descrição do produto 1");
//        produto1.setFabricacao(c1);
//        produto1.setValidade(c2);
//        produto1.setCategoria(categoria);
//
//        produto2.setNome("produto 2");
//        produto2.setDescricao("Descrição do produto 2");
//        produto2.setFabricacao(c1);
//        produto2.setValidade(c2);
//        produto2.setCategoria(categoria);

        //Util.Hibernate
//        Hibernate.start_db();
//        Hibernate.set_db(categoria);
//        Hibernate.set_db(produto1);
//        Hibernate.set_db(produto2);
//        Hibernate.end_db();
        Hibernate.start_db();
        List a = Hibernate.get_db("country", "United Kingdom");
        System.out.println("Foram achadas: " + a.size() + " referências");
        Hibernate.end_db();
    }

}
