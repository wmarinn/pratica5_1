package inscricao.faces.mngbeans;

import inscricao.entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import utfpr.faces.support.PageBean;


@ManagedBean
@RequestScoped
@Named
public class InscricaoBean extends PageBean {
    private static final Idioma[] idiomas = {
        new Idioma(1, "Inglês"),
        new Idioma(2, "Alemão"),
        new Idioma(3, "Francês")
    };
    private Candidato candidato = new Candidato(idiomas[0]); // inicialmente ingles
    private List<SelectItem> idiomaItemList;
    private static final ListDataModel <Candidato> ldm = new ListDataModel<>();
    @Inject
    private CandidatoList cl;

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public ListDataModel <Candidato> getLdm() {
        return ldm;
    }
    

    public List<SelectItem> getIdiomaItemList() {
        if (idiomaItemList != null) return idiomaItemList;
        idiomaItemList = new ArrayList<>();
        for (Idioma id: idiomas) {
            idiomaItemList.add(new SelectItem(id.getCodigo(), id.getDescricao()));
        }
        return idiomaItemList;
    }

    public String confirmaAction() {
        candidato.setDataHora(new Date());
        candidato.setIdioma(idiomas[candidato.getIdioma().getCodigo()-1]);
        //RegistroBean bean = (RegistroBean) getBean("registroBean");
        //bean.addCandidato(candidato);
        //createListDataModel(bean, candidato);
        cl.addCandidato(candidato);
        createListDataModel();    
        return "confirma";
    }
    
    public ListDataModel createListDataModel(RegistroBean rb, Candidato c){
        ldm.setWrappedData(rb.getCandidatoList());
        return ldm;
        
    }
    
    public ListDataModel createListDataModel(){
        ldm.setWrappedData(cl.getCandidatoList());
        return ldm;
    }
    
    public String candidatoAction(){
        candidato = ldm.getRowData();
        return "inscricao";
    }
    
    public String excluirAction(){
       RegistroBean bean = (RegistroBean) getBean("registroBean");      
       bean.getCandidatoList().remove(ldm.getRowData());
       return "candidatos";
    }
}
