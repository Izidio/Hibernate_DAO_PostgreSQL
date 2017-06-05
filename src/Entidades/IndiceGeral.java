/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Izidio
 */
@Entity
@Table(name = "indice_geral")
public class IndiceGeral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private double peso;
    private double relativo;
    private double percent;
    //numero de salarios minimos pra pesquisa
    private int n_salarios;

    /**
     * @return the n_salarios
     */
    public int getN_salarios() {
        return n_salarios;
    }

    /**
     * @param n_salarios the n_salarios to set
     */
    public void setN_salarios(int n_salarios) {
        this.n_salarios = n_salarios;
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
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the relativo
     */
    public double getRelativo() {
        return relativo;
    }

    /**
     * @param relativo the relativo to set
     */
    public void setRelativo(double relativo) {
        this.relativo = relativo;
    }

    /**
     * @return the percent
     */
    public double getPercent() {
        return percent;
    }

    /**
     * @param percent the percent to set
     */
    public void setPercent(double percent) {
        this.percent = percent;
    }

}
