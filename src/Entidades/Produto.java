/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Izidio
 */
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    @Column(name = "dt_validade")
    @Temporal(TemporalType.DATE)
    private Calendar validade;

    @Column(name = "dt_fabricacao")
    @Temporal(TemporalType.DATE)
    private Calendar fabricacao;

    private String descricao;

    @JoinColumn(name = "categoria_id")
    @ManyToOne
    private Produto_Categoria categoria;

    /**
     * @return the validade
     */
    public Calendar getValidade() {
        return validade;
    }

    /**
     * @param validade the validade to set
     */
    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    /**
     * @return the fabricacao
     */
    public Calendar getFabricacao() {
        return fabricacao;
    }

    /**
     * @param fabricacao the fabricacao to set
     */
    public void setFabricacao(Calendar fabricacao) {
        this.fabricacao = fabricacao;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the categoria
     */
    public Produto_Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Produto_Categoria categoria) {
        this.categoria = categoria;
    }

}
