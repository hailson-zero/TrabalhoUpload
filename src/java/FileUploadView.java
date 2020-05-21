
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author T-Gamer
 */
@Named
@RequestScoped
@ManagedBean(name="fileMB")
public class FileUploadView{ 
    private UploadedFile arquivo;
    private String conteudo;
    

    public UploadedFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(UploadedFile arquivo) {
        this.arquivo = arquivo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    public void upload(FileUploadEvent event) throws IOException { 
        FacesMessage msg = new FacesMessage("O Uploaded do arquivo", event.getFile().getFileName() + " foi concluido.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        //System.out.println(event);
        arquivo = event.getFile();
        //System.out.println(arquivo);
        conteudo = new Scanner(arquivo.getInputstream(),"UTF-8").useDelimiter("\\A").next();
        //System.out.println(conteudo);
        
    }
}
