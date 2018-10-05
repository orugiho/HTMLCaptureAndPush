/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.agiles2018.htmlcapturepush;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Date;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author orugiho
 */
@ManagedBean
@RequestScoped
public class MyBean {

    private static final Logger LOG
            = Logger.getLogger("MyBean");
    private String html;
    private String nombre;

    /**
     * Creates a new instance of MyBean
     */
    public MyBean() {
    }

    public String getDate() {
        return new Date().toString();
    }

    public void registraArchivo() {
        LOG.info("Registro==>" + html);
        nombre = nombre + new Date().getTime() + ".html";
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Tu archivo se registro con el nombre "
                        + nombre));
        File file = new File("/home/ec2-user/workspace/agiles2018MVN/src/main/webapp/html/"+nombre);
        try(FileWriter fos = new FileWriter(file)){
            fos.write(html);
        }catch(Exception ex){
              LOG.throwing("MyBean", "registrarArchivo", ex);
        }
        nombre = "";
        html = "";

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getHtml() {
        return html;
    }

}
