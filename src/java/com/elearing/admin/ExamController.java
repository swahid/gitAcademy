/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.admin;

import com.elearing.entity.Exam;
import com.elearing.entity.ExamQuesLink;
import com.elearing.entity.ExamResult;
import com.elearing.entity.McqQues;
import com.elearing.entity.SubChapter;
import com.elearing.entity.Subject;
import com.elearing.entity.User;
import com.elearing.impl.ExamDaoImpl;
import com.elearing.impl.ExamQuesLinkDaoImpl;
import com.elearing.impl.ExamResultDaoImpl;
import com.elearing.impl.McqQuesDaoImpl;
import com.elearing.impl.SubChapterDaoImpl;
import com.elearing.impl.SubjectDaoImpl;
import com.elearing.user.UserLogin;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Emrul
 */
@ManagedBean
@SessionScoped
public class ExamController {

    public McqQuesDaoImpl mcqQuesDaoImpl = new McqQuesDaoImpl();
    public Subject subject = new Subject();
    public SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
    public McqQues mcqQues = new McqQues();
    public SubChapter subChapter = new SubChapter();
    public SubChapterDaoImpl subChapterDaoImpl = new SubChapterDaoImpl();
    public ExamDaoImpl examDaoImpl = new ExamDaoImpl();
    public Exam exam = new Exam();
    public ExamQuesLinkDaoImpl examQuesLinkDaoImpl = new ExamQuesLinkDaoImpl();
    public ExamQuesLink examQuesLink = new ExamQuesLink();
    public ExamResult examResult=new ExamResult();
    public ExamResultDaoImpl examResultDaoImpl=new ExamResultDaoImpl();
    public UserLogin userLogin=new UserLogin();
    public List<McqQues> listq = new ArrayList<McqQues>();
    public List<McqQues> wrongCollection = new ArrayList<McqQues>();
    public String check2[] = new String[20];

    public List<McqQues> getWrongCollection() {
        return wrongCollection;
    }

    public void setWrongCollection(List<McqQues> wrongCollection) {
        this.wrongCollection = wrongCollection;
    }

   

    public String[] getCheck2() {
        return check2;
    }

    public void setCheck2(String[] check2) {
        this.check2 = check2;
    }

    public ExamResult getExamResult() {
        return examResult;
    }

    public void setExamResult(ExamResult examResult) {
        this.examResult = examResult;
    }

    public ExamResultDaoImpl getExamResultDaoImpl() {
        return examResultDaoImpl;
    }

    public void setExamResultDaoImpl(ExamResultDaoImpl examResultDaoImpl) {
        this.examResultDaoImpl = examResultDaoImpl;
    }


    public ExamDaoImpl getExamDaoImpl() {
        return examDaoImpl;
    }

    public ExamQuesLinkDaoImpl getExamQuesLinkDaoImpl() {
        return examQuesLinkDaoImpl;
    }

    public void setExamQuesLinkDaoImpl(ExamQuesLinkDaoImpl examQuesLinkDaoImpl) {
        this.examQuesLinkDaoImpl = examQuesLinkDaoImpl;
    }

    public ExamQuesLink getExamQuesLink() {
        return examQuesLink;
    }

    public void setExamQuesLink(ExamQuesLink examQuesLink) {
        this.examQuesLink = examQuesLink;
    }

    public void setExamDaoImpl(ExamDaoImpl examDaoImpl) {
        this.examDaoImpl = examDaoImpl;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public McqQuesDaoImpl getMcqQuesDaoImpl() {
        return mcqQuesDaoImpl;
    }

    public void setMcqQuesDaoImpl(McqQuesDaoImpl mcqQuesDaoImpl) {
        this.mcqQuesDaoImpl = mcqQuesDaoImpl;
    }

    public SubChapter getSubChapter() {
        return subChapter;
    }

    public void setSubChapter(SubChapter subChapter) {
        this.subChapter = subChapter;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SubjectDaoImpl getSubjectDaoImpl() {
        return subjectDaoImpl;
    }

    public void setSubjectDaoImpl(SubjectDaoImpl subjectDaoImpl) {
        this.subjectDaoImpl = subjectDaoImpl;
    }

    public McqQues getMcqQues() {
        return mcqQues;
    }

    public void setMcqQues(McqQues mcqQues) {
        this.mcqQues = mcqQues;
    }

    public SubChapterDaoImpl getSubChapterDaoImpl() {
        return subChapterDaoImpl;
    }

    public void setSubChapterDaoImpl(SubChapterDaoImpl subChapterDaoImpl) {
        this.subChapterDaoImpl = subChapterDaoImpl;
    }

    
    
       public List<McqQues> getAllMcqListOnChapterExam() {
        exam = examDaoImpl.getObjectById(1);
        subChapter = subChapterDaoImpl.getObjectById(subChapter.getSchId());
        mcqQues.setSubChapter(subChapter);
        listq=mcqQuesDaoImpl.getAllMcqForExam(subChapter);
        return mcqQuesDaoImpl.getAllMcqForExam(subChapter);

    }
    
    
    
    
    public List<SelectItem> getChaptertData() {

        List<SelectItem> itemlist = new ArrayList<>();

        if (subject.getSubId() != null) {
            subject = subjectDaoImpl.getObjectById(subject.getSubId());

            subChapter.setSubject(subject);

            for (SubChapter chapter : subChapterDaoImpl.chapter(subChapter.getSubject())) {

                itemlist.add(new SelectItem(chapter.getSchId(), chapter.getSchName()));
            }

            return itemlist;
        } else {
            return null;
        }
    }

    public String addMultipule() {
        mcqQues.setSubChapter(subChapterDaoImpl.getObjectById(subChapter.getSchId()));
        mcqQuesDaoImpl.insert(mcqQues);
        return null;
    }

    public List<McqQues> getAllMcqList() {
        subChapter = subChapterDaoImpl.getObjectById(subChapter.getSchId());
        mcqQues.setSubChapter(subChapter);
        listq=mcqQuesDaoImpl.getAllMcq(mcqQues.getSubChapter());
        return mcqQuesDaoImpl.getAllMcq(mcqQues.getSubChapter());

    }

    int a[] = new int[10];

//    public List<McqQues> getMCQListSubject() {
//        subChapter=subChapterDaoImpl.getObjectById(subChapter.getSchId());
//        mcqQues.setSubChapter(subChapter);
//        exam = examDaoImpl.getObjectById(2);
//        List<ExamQuesLink> linkList = examQuesLinkDaoImpl.getQueLinkByExamId(exam);
//        List<McqQues> list = null;
//        if (linkList.size() > 0) {
//            int len = linkList.size();
//            for (int l = 0; l < len; l++) {
//                ExamQuesLink link1 = linkList.get(l);
//                a[l] = link1.getExamLinkId();
//                examQuesLink = examQuesLinkDaoImpl.getObjectById(a[l]);
//                if (l == 0) {                   
//                    list = mcqQuesDaoImpl.getMCQList(mcqQues.getSubChapter(),examQuesLink.getChapterType(), examQuesLink.getQuesLevel(), examQuesLink.getTotalQuesNo());
//                   
//                } else {             
//                    list.addAll(mcqQuesDaoImpl.getMCQList(mcqQues.getSubChapter(),examQuesLink.getChapterType(), examQuesLink.getQuesLevel(), examQuesLink.getTotalQuesNo()));
//                }   
//            }
//        }
//        return list;
//    }
    /// Coading for retriving data on a subject accroding to exam formate 
    

    public  List<McqQues> getListq() {
        return listq;
    }

//    public  void setListq(List<McqQues> listq) {
//        ExamController.listq = listq;
//    }


    
    public List<McqQues> getMCQListOnSubject(){
        listq.clear();
        subject = subjectDaoImpl.getObjectById(subject.getSubId());
        exam = examDaoImpl.getObjectById(2);
        List<ExamQuesLink> linkList = examQuesLinkDaoImpl.getQueLinkByExamId(exam);
        //List<McqQues> list = null;
        if (linkList.size() > 0) {
            int len = linkList.size();
            for (int l = 0; l < len; l++) {
                ExamQuesLink link1 = linkList.get(l);
                a[l] = link1.getExamLinkId();
                examQuesLink = examQuesLinkDaoImpl.getObjectById(a[l]);
                if (l == 0) {
                    listq = mcqQuesDaoImpl.getMCQListOnSub(subject, examQuesLink.getChapterType(), examQuesLink.getQuesLevel(), examQuesLink.getTotalQuesNo());
                } else {
                    listq.addAll(mcqQuesDaoImpl.getMCQListOnSub(subject, examQuesLink.getChapterType(), examQuesLink.getQuesLevel(), examQuesLink.getTotalQuesNo()));
                }
            }
        }
        return listq;
    }

   //chapter Exam 
//     public List<McqQues> getMCQListOnChapter() {   
//           System.out.println("Chapter data comes properly");
//         
//          List<McqQues>  chaList= new ArrayList<McqQues>();
//        exam = examDaoImpl.getObjectById(1);
//        List<ExamQuesLink> linkList = examQuesLinkDaoImpl.getQueLinkByExamId(exam);
//        
//        if (linkList.size() > 0) {
//            int len = linkList.size();
//            for (int l = 0; l < len; l++) {
//                ExamQuesLink link1 = linkList.get(l);
//                a[l] = link1.getExamLinkId();
//                examQuesLink = examQuesLinkDaoImpl.getObjectById(a[l]);
//                if (l == 0) {
//                    listq = mcqQuesDaoImpl.getMCQListOnChapter(examQuesLink.getChapterType(), examQuesLink.getQuesLevel(), examQuesLink.getTotalQuesNo());
//                } else {
//                    listq.addAll(mcqQuesDaoImpl.getMCQListOnChapter(examQuesLink.getChapterType(), examQuesLink.getQuesLevel(), examQuesLink.getTotalQuesNo()));
//                }
//            }
//        }
//         System.out.println("Chapter data comes properly");
//        return listq;
//
//    }
//    
//    
int correct =0;
int wrong=0;

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }


    public String examResult() {
        wrongCollection.clear();
        System.out.println("Question List size "+listq.size());
        wrong=0;
       correct=0;
      String b=null;        
        for (int i = 0; i <listq.size(); i++) {
         b=check2[i];
         int cl=Integer.parseInt(b);
         String click=null;
         if(cl==1){
             click=listq.get(i).getOp1();
         }else if(cl==2) {
             click=listq.get(i).getOp2();
         }else if(cl==3) {
             click=listq.get(i).getOp3();
         }else if(cl==4) {
             click=listq.get(i).getOp4();
         }
         
        String c=listq.get(i).getAnsOp();
           // System.out.println("List Position " +i +" Click is " +b +" Ansoption is  "+ listq.get(i).getAnsOp() + "Answer is " + click);
                       
         if(click.equalsIgnoreCase(listq.get(i).getAnsOp())){
             correct++;
             
         }else{
             wrong++;
             wrongCollection.add(listq.get(i));
         }
         
        //    System.out.println("Value is now printing............" + b );        
        }
      //  System.out.println("Correct Answer is "+correct);
      //  System.out.println("Wrong answer is "+wrong);
      // int i=userLogin.userid;
       // System.out.println("User id is now printing ....."+i);
       //examResult.setUser(userLogin.user);
        examResult.setExam(exam);
        examResult.setExamDate(new Date());
        examResult.setMarksObtained(correct);
        examResult.setTotalQues(correct+wrong);
        examResultDaoImpl.insert(examResult);
        return "exResult";
    }
}
