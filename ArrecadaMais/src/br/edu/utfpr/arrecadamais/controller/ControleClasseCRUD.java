/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.arrecadamais.controller;

import java.util.List;

/**
 *
 * @author JoãoHenrique
 */
public interface ControleClasseCRUD<T> {
    public T inserir(T objeto);
    public void excluir(T objeto);
    public T alterar(T objeto);
    public List<T> buscarTotal();
    public T buscarByID(int ID);
//    public T carregaDadosObjeto();
//    public void carregaDadosTela(T objeto);
    
}
