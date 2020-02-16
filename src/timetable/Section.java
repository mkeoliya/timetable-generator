/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

/**
 *
 * @author user
 */
import java.util.*;
public class Section {
public String sectionName;
public int sectionNo;
public int noOfSubjects;
public String[][] sectionSlots;
public String[][] possibleSlots;
public String[] subjects;
public String[] subjectTeacher1;
public String[] subjectTeacher2;
public String[] subjectTeacher3;
public int[] periodsPerWeek;
public int[] remainingPeriods;
public int[] noOfPossiblePeriods;
public boolean[][] freePeriods;
//public List<String>[] remainingSubjects;

    


public Section(int noOfSubjects,int sectionNo){
    this.sectionNo=sectionNo;
    this.noOfSubjects=noOfSubjects;
    
    sectionSlots=new String[5][8];
    possibleSlots=new String[5][8];
    freePeriods=new boolean[5][8];
    noOfPossiblePeriods = new int[5];
    for(int i=0;i<5;i++)
        for(int j=0;j<8;j++){
            sectionSlots[i][j]="";
            possibleSlots[i][j]="";
            freePeriods[i][j]=true;
        }
    if(sectionNo>25){
        freePeriods[4][5]=false;
        freePeriods[4][6]=false;
        freePeriods[4][7]=false;
    }
    
    subjects=new String[noOfSubjects];
    subjectTeacher1=new String[noOfSubjects];
    subjectTeacher2=new String[noOfSubjects];
    subjectTeacher3=new String[noOfSubjects];
    periodsPerWeek=new int[noOfSubjects];
    remainingPeriods=new int[noOfSubjects];
    
    /*remainingSubjects=new List[5];
    for(int i=0;i<5;i++){
            remainingSubjects[i]=new ArrayList<String>();
            
    }
    */
}
    
    public Section(Section other){
        this.sectionName=other.sectionName;
        this.sectionNo=other.sectionNo;
        this.noOfSubjects=other.noOfSubjects;
        
        this.sectionSlots=new String[5][8];
        this.possibleSlots=new String[5][8];
        this.freePeriods=new boolean[5][8];
        for(int i=0;i<5;i++){
            for(int j=0;j<8;j++){
                this.sectionSlots[i][j]=other.sectionSlots[i][j];
                this.possibleSlots[i][j]=other.possibleSlots[i][j];
                this.freePeriods[i][j]=other.freePeriods[i][j];
            }
        }
       
        
        this.subjects=new String[this.noOfSubjects];
        this.subjectTeacher1=new String[this.noOfSubjects];
        this.subjectTeacher2=new String[this.noOfSubjects];
        this.subjectTeacher3=new String[this.noOfSubjects];
        this.periodsPerWeek=new int[this.noOfSubjects];
        this.remainingPeriods=new int[this.noOfSubjects];
        this.noOfPossiblePeriods=new int[this.noOfSubjects];
        for(int i=0;i<this.noOfSubjects;i++){
            this.subjects[i]=other.subjects[i];
            this.subjectTeacher1[i]=other.subjectTeacher1[i];
            this.subjectTeacher2[i]=other.subjectTeacher2[i];
            this.subjectTeacher3[i]=other.subjectTeacher3[i];
            this.periodsPerWeek[i]=other.periodsPerWeek[i];
            this.remainingPeriods[i]=other.remainingPeriods[i];
        }
        
        for(int i=0;i<5;i++)
            this.noOfPossiblePeriods[i]=other.noOfPossiblePeriods[i];
        
        /*this.remainingSubjects=new List[5];
        for(int i=0;i<5;i++){
                this.remainingSubjects[i]=new ArrayList<String>();
                for(String subject : other.remainingSubjects[i])
                    this.remainingSubjects[i].add(subject);     
        }  
        */
    } 
    
    
    
    public void print(){
        TimeTable obj=new TimeTable();
        obj.printTimeTable(sectionSlots);
        obj.printTimeTable(possibleSlots);
        System.out.println("The number of periods in week - " + periodsPerWeek[0] + periodsPerWeek[1] + periodsPerWeek[2] +periodsPerWeek[3] +periodsPerWeek[4] );
        System.out.println("The remaining periods in week - " + remainingPeriods[0] + remainingPeriods[1] + remainingPeriods[2] +remainingPeriods[3] +remainingPeriods[4] );
        System.out.println("The remaining periods in week - " + noOfPossiblePeriods[0] + noOfPossiblePeriods[1] + noOfPossiblePeriods[2] +noOfPossiblePeriods[3] +noOfPossiblePeriods[4] );
        System.out.println("The remaining subjects = " );
        //for(int i=0;i<5;i++)
            //System.out.println(remainingSubjects[i]);
        System.out.println("\n\nThe free periods = ");
        for(int i=0;i<5;i++)
            System.out.println(freePeriods[i]);
    }
 }
    

