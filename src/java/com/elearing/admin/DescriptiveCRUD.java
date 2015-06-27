/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.admin;

import com.elearing.entity.DescQues;
import com.elearing.entity.SubChapter;
import com.elearing.imageSlide.ChapterImageSlide;
import com.elearing.impl.DescQuesDaoImpl;
import com.elearing.impl.SubChapterDaoImpl;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Emrul
 */
@ManagedBean
@SessionScoped
public class DescriptiveCRUD {
    
    public SubChapter subChapter=new SubChapter();
    public  SubChapterDaoImpl subChapterDaoImpl=new SubChapterDaoImpl();
    public DescQues descQues=new DescQues();
    public DescQuesDaoImpl descQuesDaoImpl=new DescQuesDaoImpl();
    
   private String imageName=null, imagePath, saveImagePath;
    
    private Boolean save = false;
    
    public UploadedFile file;
    
    public ChapterImageSlide chapterImageSlide=new ChapterImageSlide();

    public ChapterImageSlide getChapterImageSlide() {
        return chapterImageSlide;
    }

    public void setChapterImageSlide(ChapterImageSlide chapterImageSlide) {
        this.chapterImageSlide = chapterImageSlide;
    }
    
    

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSaveImagePath() {
        return saveImagePath;
    }

    public void setSaveImagePath(String saveImagePath) {
        this.saveImagePath = saveImagePath;
    }

    public Boolean getSave() {
        return save;
    }

    public void setSave(Boolean save) {
        this.save = save;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    
    
    
    
    
    
    
    
    
    
    public SubChapter getSubChapter() {
        return subChapter;
    }

    public void setSubChapter(SubChapter subChapter) {
        this.subChapter = subChapter;
    }

    public DescQuesDaoImpl getDescQuesDaoImpl() {
        return descQuesDaoImpl;
    }

    public void setDescQuesDaoImpl(DescQuesDaoImpl descQuesDaoImpl) {
        this.descQuesDaoImpl = descQuesDaoImpl;
    }

    public SubChapterDaoImpl getSubChapterDaoImpl() {
        return subChapterDaoImpl;
    }

    public void setSubChapterDaoImpl(SubChapterDaoImpl subChapterDaoImpl) {
        this.subChapterDaoImpl = subChapterDaoImpl;
    }

    public DescQues getDescQues() {
        return descQues;
    }

    public void setDescQues(DescQues descQues) {
        this.descQues = descQues;
    }
    
    public void upload() {
        
        if(file != null) {
            try {
               
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext servletContext = (ServletContext)context.getExternalContext().getContext();
                String bdpath=servletContext.getRealPath("/");
                String webcut = bdpath.substring(0, bdpath.lastIndexOf("\\"));
                String buildcut=webcut.substring(0, webcut.lastIndexOf("\\"));
                String mainUrlPath= buildcut.substring(0, buildcut.lastIndexOf("\\"));
                
                //this code for web main logic cut            
                //HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
                //String requestURL = request.getRequestURL().toString();
                //String url = requestURL.substring(0, requestURL.lastIndexOf("/"));      
                //get content
             InputStream inputStr = file.getInputstream();                
             imagePath=mainUrlPath+"\\web\\resources\\image\\descriptiveImage\\"+file.getFileName();
                //upload file copy to project folder
               File destFile = new File(imagePath);
               if(!destFile.exists()){
                FileUtils.copyInputStreamToFile(inputStr, destFile);
               }              
               imageName=file.getFileName();             
                System.out.println(imageName);               
            } catch (Exception ex) {
                Logger.getLogger(DescriptiveCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
    } 
    
    
    public String addDescrip(){
        descQues.setSubChapter(subChapterDaoImpl.getObjectById(subChapter.getSchId()));
        descQuesDaoImpl.insert(descQues);
        return null;
    }
  
       public void chap() {
        if (subChapter.getSchId() != null) {
            subChapter = subChapterDaoImpl.getObjectById(subChapter.getSchId());
        }
    }
    
    
    
    public  List<DescQues> getDescriptive(){
        subChapter=subChapterDaoImpl.getObjectById(subChapter.getSchId());
        
        descQues.setSubChapter(subChapter);
        
      return descQuesDaoImpl.getAllDesc(descQues.getSubChapter());
        
    }
    
   public String escapeHTML(String s){
   StringBuffer sb = new StringBuffer();
   int n = s.length();
   for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      switch (c) {
         case '<': sb.append("&lt;"); break;
         case '>': sb.append("&gt;"); break;
         case '&': sb.append("&amp;"); break;
         case '"': sb.append("&quot;"); break;
         case 'à': sb.append("&agrave;");break;
         case 'À': sb.append("&Agrave;");break;
         case 'â': sb.append("&acirc;");break;
         case 'Â': sb.append("&Acirc;");break;
         case 'ä': sb.append("&auml;");break;
         case 'Ä': sb.append("&Auml;");break;
         case 'å': sb.append("&aring;");break;
         case 'Å': sb.append("&Aring;");break;
         case 'æ': sb.append("&aelig;");break;
         case 'Æ': sb.append("&AElig;");break;
         case 'ç': sb.append("&ccedil;");break;
         case 'Ç': sb.append("&Ccedil;");break;
         case 'é': sb.append("&eacute;");break;
         case 'É': sb.append("&Eacute;");break;
         case 'è': sb.append("&egrave;");break;
         case 'È': sb.append("&Egrave;");break;
         case 'ê': sb.append("&ecirc;");break;
         case 'Ê': sb.append("&Ecirc;");break;
         case 'ë': sb.append("&euml;");break;
         case 'Ë': sb.append("&Euml;");break;
         case 'ï': sb.append("&iuml;");break;
         case 'Ï': sb.append("&Iuml;");break;
         case 'ô': sb.append("&ocirc;");break;
         case 'Ô': sb.append("&Ocirc;");break;
         case 'ö': sb.append("&ouml;");break;
         case 'Ö': sb.append("&Ouml;");break;
         case 'ø': sb.append("&oslash;");break;
         case 'Ø': sb.append("&Oslash;");break;
         case 'ß': sb.append("&szlig;");break;
         case 'ù': sb.append("&ugrave;");break;
         case 'Ù': sb.append("&Ugrave;");break;         
         case 'û': sb.append("&ucirc;");break;         
         case 'Û': sb.append("&Ucirc;");break;
         case 'ü': sb.append("&uuml;");break;
         case 'Ü': sb.append("&Uuml;");break;
         case '®': sb.append("&reg;");break;         
         case '©': sb.append("&copy;");break;   
         case '€': sb.append("&euro;"); break;
         // be carefull with this one (non-breaking whitee space)
         case ' ': sb.append("&nbsp;");break;         
         
         default:  sb.append(c); break;
      }
   }
   return sb.toString();
}
    
}
