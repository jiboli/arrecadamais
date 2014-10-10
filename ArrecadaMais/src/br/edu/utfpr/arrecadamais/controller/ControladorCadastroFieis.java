/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.controller;

import br.edu.utfpr.arrecadamais.model.vo.Fieis;


/**
 *
 * @author JoãoHenrique
 */
public class ControladorCadastroFieis implements ControleControler<Fieis>{

    @Override
    public Fieis carregaDadosObjeto() {
        return new Fieis();
    }

    @Override
    public void carregaDadosTela(Fieis objeto) {

    }
    
}