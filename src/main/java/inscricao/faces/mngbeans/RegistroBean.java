/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import utfpr.faces.support.PageBean;
import javax.faces.bean.ManagedBean;
import inscricao.entity.Candidato;
import java.util.ArrayList;

/**
 *
 * @author user
 */

@ManagedBean
@Named(value = "registroBean")
@ApplicationScoped
public class RegistroBean extends PageBean {
    
    private static final ArrayList <Candidato> candidatoList = new ArrayList<>();
    
    
    public void addCandidato(Candidato c){
        candidatoList.add(c);
    }
    
    public ArrayList<Candidato> getCandidatoList(){
        return candidatoList;
    }
    
}
