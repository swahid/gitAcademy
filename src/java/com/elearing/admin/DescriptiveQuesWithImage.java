/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.admin;

import com.elearing.entity.ChapterImage;
import com.elearing.entity.DescQues;
import com.elearing.entity.SubChapter;
import com.elearing.entity.UserImage;
import com.elearing.imageSlide.ChapterImageSlide;
import com.elearing.impl.ChapterImageDaoImpl;
import com.elearing.impl.DescQuesDaoImpl;
import com.elearing.impl.SubChapterDaoImpl;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Emrul
 */
@ManagedBean
@RequestScoped
public class DescriptiveQuesWithImage implements Serializable{
    
    
        public SubChapter subChapter=new SubChapter();
    public  SubChapterDaoImpl subChapterDaoImpl=new SubChapterDaoImpl();
    public DescQues descQues=new DescQues();
    public DescQuesDaoImpl descQuesDaoImpl=new DescQuesDaoImpl(); 
    public String imageName=null, imagePath, saveImagePath;
    
    public ChapterImageSlide chapterImageSlide=new ChapterImageSlide();
    public Boolean save = false;
    
    public UploadedFile file;

    public  UserImage image= new UserImage();
    public  ChapterImage chapterImage=new ChapterImage();
    public ChapterImageDaoImpl chapterImageDaoImpl=new ChapterImageDaoImpl();

    public ChapterImageSlide getChapterImageSlide() {
        return chapterImageSlide;
    }

    public void setChapterImageSlide(ChapterImageSlide chapterImageSlide) {
        this.chapterImageSlide = chapterImageSlide;
    }

    public DescQues getDescQues() {
        return descQues;
    }

    public void setDescQues(DescQues descQues) {
        this.descQues = descQues;
    }

    public DescQuesDaoImpl getDescQuesDaoImpl() {
        return descQuesDaoImpl;
    }

    public void setDescQuesDaoImpl(DescQuesDaoImpl descQuesDaoImpl) {
        this.descQuesDaoImpl = descQuesDaoImpl;
    }




    public ChapterImageDaoImpl getChapterImageDaoImpl() {
        return chapterImageDaoImpl;
    }

    public void setChapterImageDaoImpl(ChapterImageDaoImpl chapterImageDaoImpl) {
        this.chapterImageDaoImpl = chapterImageDaoImpl;
    }




    public SubChapter getSubChapter() {
        return subChapter;
    }

    public void setSubChapter(SubChapter subChapter) {
        this.subChapter = subChapter;
    }

    public SubChapterDaoImpl getSubChapterDaoImpl() {
        return subChapterDaoImpl;
    }

    public void setSubChapterDaoImpl(SubChapterDaoImpl subChapterDaoImpl) {
        this.subChapterDaoImpl = subChapterDaoImpl;
    }

    
    
    
    public ChapterImage getChapterImage() {
        return chapterImage;
    }

    public void setChapterImage(ChapterImage chapterImage) {
        this.chapterImage = chapterImage;
    }
    
    public UserImage getImage() {
        return image;
    }

    public void setImage(UserImage image) {
        this.image = image;
    }
            
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
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
             imagePath=mainUrlPath+"\\web\\resources\\image\\userImage\\"+file.getFileName();
                //upload file copy to project folder
               File destFile = new File(imagePath);
               if(!destFile.exists()){
                FileUtils.copyInputStreamToFile(inputStr, destFile);
               }              
               imageName=file.getFileName();             
                System.out.println(imageName);               
            } catch (Exception ex) {
                Logger.getLogger(DescriptiveQuesWithImage.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
    }

  
   
    
    
    
    
    
    
     public String addDescrip(){
        upload();
        System.out.println(imageName);
        System.out.println(file.getFileName());
        // chapterImageSlide.upload();
        descQues.setImage(chapterImageSlide.getImageName());
        descQues.setSubChapter(subChapterDaoImpl.getObjectById(subChapter.getSchId()));
        descQuesDaoImpl.insert(descQues);
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public void saveChapImg(){
//        upload();
//        chapterImage.setSubChapter(subChapterDaoImpl.getObjectById(subChapter.getSchId()));
//        Session session=HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();    
//        chapterImage.setImageName(imageName);   
//        chapterImage.setImageSize(""+file.getSize());
//        chapterImage.setImageType(file.getContentType());
//        chapterImage.setImageUrl(imagePath); 
//       //chapterImageDaoImpl.insert(chapterImage);
//         session.save(chapterImage);
//         session.getTransaction().commit();
//         session.close();          
//        }
//    
//       public List<UserImage> getImageSwitch(){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Query qr= session.createQuery("from ChapterImage");       
//       List<UserImage> lr= qr.list();    
//        return lr;
//    }  
       
       
       
       
       
}
