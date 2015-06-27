/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.convert;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author user
 */
@FacesConverter("cpfConverter")
public class CPFConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) throws ConverterException{
        long cpf;
        long max_limit = 99999999999L;
        String conv = "xxxxxxxxxxx";
        if(string.length() == 11){
            cpf = Long.valueOf(string);
            if(cpf < 0 && cpf > max_limit){
                FacesMessage msg = new FacesMessage("CPF " + string + " inválido");
                throw new ConverterException(msg);
            }
        }
        else if(string.length() == 12){
            String model = "xxxxxxxxx-xx";
            if(string.charAt(9) != '-' || string.contains(".")){
                FacesMessage msg = new FacesMessage("CPF " + string + " inválido");
                throw new ConverterException(msg);
            }
            else{
                for(int i = 0; i < string.length(); i++){
                    if(string.charAt(i) != '-'){
                        conv = conv.replaceFirst("x", String.valueOf(string.charAt(i)));
                    }
                }
                cpf = Long.valueOf(conv);
            }
        }
        else if(string.length() == 14){
            if(string.charAt(3) != '.' || string.charAt(7) != '.' || string.charAt(11) != '-'){
               FacesMessage msg = new FacesMessage("CPF " + string + " inválido");
                throw new ConverterException(msg); 
            }
            else{
                for(int i = 0; i < string.length(); i++){
                    if(string.charAt(i) != '.' && string.charAt(i) != '-'){
                        conv = conv.replaceFirst("x", String.valueOf(string.charAt(i)));
                    }
                }
                cpf = Long.valueOf(conv);
            }
        }
        else{
                FacesMessage msg = new FacesMessage("CPF " + string + " inválido");
                throw new ConverterException(msg);  
        }
            return cpf;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) throws ConverterException{
        char[] c;
        c = o.toString().toCharArray();
        String s = "xxx.xxx.xxx-xx";
        for(int i = 0; i < c.length; i++){
            s = s.replaceFirst("x", String.valueOf(c[i]));
        }
       return s; 
    }
    
}
