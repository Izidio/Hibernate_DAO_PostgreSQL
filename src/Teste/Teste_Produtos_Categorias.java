/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import DAO.Produto_CategoriaDAO;
import DAO.Usuarios_CategoriaDAO;
import Entidades.Produto_Categoria;
import Entidades.Produto;
import Ultil.Hibernate;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author Izidio
 */
public class Teste_Produtos_Categorias {

    public static void main(String[] args) throws IOException {
        //manipulação de dados
        Produto_CategoriaDAO dao_cat_prod = new Produto_CategoriaDAO();
        Usuarios_CategoriaDAO dao_cat_usu = new Usuarios_CategoriaDAO();
        Hibernate hibernate = new Hibernate();
        
        //dados para povoamento 
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Produto_Categoria categoria_produto = new Produto_Categoria();
        
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.set(Calendar.YEAR, 2016);
        c1.set(Calendar.MONTH, Calendar.MARCH);
        c1.set(Calendar.DAY_OF_MONTH, 1);

        c2.set(Calendar.YEAR, 2017);
        c2.set(Calendar.MONTH, Calendar.JULY);
        c2.set(Calendar.DAY_OF_MONTH, 1);

        categoria_produto.setNome("Categoria 1");
        categoria_produto.setDescricao("Descrição Categoria 1");

        produto1.setNome("produto 1");
        produto1.setDescricao("Descrição do produto 1");
        produto1.setFabricacao(c1);
        produto1.setValidade(c2);
        produto1.setCategoria(categoria_produto);

        produto2.setNome("produto 2");
        produto2.setDescricao("Descrição do produto 2");
        produto2.setFabricacao(c1);
        produto2.setValidade(c2);
        produto2.setCategoria(categoria_produto);

        //uso dos daos
        hibernate.start_db();

        dao_cat_prod.salvar(categoria_produto, hibernate.get_session());
        dao_cat_usu.salvar(produto1, hibernate.get_session());
        dao_cat_usu.salvar(produto2, hibernate.get_session());

        hibernate.end_db();
    }

}
