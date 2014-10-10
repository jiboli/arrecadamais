/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.controller;

/**
 *
 * @author torto
 */
interface ControleControler<T> {

    public T carregaDadosObjeto();

    public void carregaDadosTela(T objeto);
}
