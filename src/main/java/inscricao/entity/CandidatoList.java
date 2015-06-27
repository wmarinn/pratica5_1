/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.entity;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface CandidatoList {
    
    public ArrayList <Candidato> candidatoList = new ArrayList<>();
    
    
    public void addCandidato(Candidato c);
    
    public ArrayList<Candidato> getCandidatoList();
    
    
}
