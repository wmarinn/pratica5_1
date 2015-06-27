/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import inscricao.entity.Candidato;
import inscricao.entity.CandidatoList;
import java.util.ArrayList;

/**
 *
 * @author user
 */

@ManagedBean
@Named
@ApplicationScoped
public class RegistroBean implements CandidatoList{
    
    //private static final ArrayList <Candidato> candidatoList = new ArrayList<>();
    public RegistroBean(){
        
    }  
    
    @Override
    public void addCandidato(Candidato c){
        candidatoList.add(c);
    }
    
    @Override
    public ArrayList<Candidato> getCandidatoList(){
        return candidatoList;
    }
       
}

