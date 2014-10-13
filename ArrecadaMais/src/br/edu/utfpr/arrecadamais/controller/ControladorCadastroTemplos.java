/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.arrecadamais.controller;

/**
 *
 * @author JoãoHenrique
 */
import br.edu.utfpr.arrecadamais.model.vo.Templo;

public class ControladorCadastroTemplos implements ControleControler<Templo>{

    @Override
    public Templo carregaDadosObjeto() {
        return new Templo();
    }

    @Override
    public void carregaDadosTela(Templo objeto) {

    }
    
}