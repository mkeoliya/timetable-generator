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
public class Teacher extends TimeTable{
    public String teacherName;
    public String teachInit;
    public int teacherNo;
    public String[][] teacherSlots;
    public String[][] possibleSlots;
    public int[] noOfPossiblePeriods;
    public int[] periodsInDay;
    public int totalPeriods;
    public List<String>[] remainingSubjects;
    public List<String>[] remainingSections;
    public boolean[][] freePeriods;
    public List<Integer>[] availablePeriods;
    
    public Teacher(){
        teacherName="";
        teachInit="";
        teacherNo=0;
        teacherSlots=new String[5][8];
        possibleSlots=new String[5][8];
        freePeriods=new boolean[5][8];
        noOfPossiblePeriods=new int[5];
        for(int i=0;i<5;i++)
            for(int j=0;j<8;j++){
                teacherSlots[i][j]="";
                possibleSlots[i][j]="";
                freePeriods[i][j]=true;
            }
        periodsInDay=new int[5];
        totalPeriods=0;
        remainingSubjects = new List[5];
        remainingSections=new List[5];

       availablePeriods=new List[5];
        for(int i=0;i<5;i++){
            remainingSubjects[i]=new ArrayList<String>();
            remainingSections[i]=new ArrayList<String>();
            availablePeriods[i]=new ArrayList<Integer>();
        }

        
        
    }
    
    public Teacher(Teacher other){
        teacherName=other.teacherName;
        teachInit=other.teachInit;
        totalPeriods=other.totalPeriods;
        teacherNo=other.teacherNo;
        teacherSlots=new String[5][8];
        possibleSlots=new String[5][8];
        freePeriods=new boolean[5][8];
        for(int i=0;i<5;i++)
            for(int j=0;j<8;j++){
                teacherSlots[i][j]=other.teacherSlots[i][j];
                possibleSlots[i][j]=other.teacherSlots[i][j];
                freePeriods[i][j]=other.freePeriods[i][j];
            }
        
        noOfPossiblePeriods=new int[5];
        periodsInDay=new int[5];
        for(int i=0;i<5;i++){
            noOfPossiblePeriods[i]=other.noOfPossiblePeriods[i];
            periodsInDay[i]=other.periodsInDay[i];
        }
        
        remainingSubjects = new List[5];
        remainingSections=new List[5];
        availablePeriods=new List[5];
        for(int i=0;i<5;i++){
            remainingSubjects[i]=new ArrayList<String>();
            remainingSections[i]=new ArrayList<String>();
            //availablePeriods[i]=new ArrayList<Integer>();
            for(String subject : other.remainingSubjects[i])
                remainingSubjects[i].add(subject);
            for(String sectionName : other.remainingSections[i])
                remainingSections[i].add(sectionName); 
            //for(Integer k : other.availablePeriods[i])
                //this.availablePeriods[i].add(new Integer(k));
                
        }
        
       
        
    }
    
    public void print(){
        TimeTable obj=new TimeTable();
        obj.printTimeTable(teacherSlots);
        obj.printTimeTable(possibleSlots);
        System.out.println("The number of possible periods - " + noOfPossiblePeriods[0] + noOfPossiblePeriods[1] + noOfPossiblePeriods[2] +noOfPossiblePeriods[3] +noOfPossiblePeriods[4] );
        System.out.println("The number of periods in day - " + periodsInDay[0] + periodsInDay[1] + periodsInDay[2] +periodsInDay[3] +periodsInDay[4] ); 
        System.out.println(totalPeriods);
        System.out.println("The remaining subjects = " );
        for(int i=0;i<5;i++)
            System.out.println(remainingSubjects[i]);
        System.out.println("\n\nThe free periods = ");
        for(int i=0;i<5;i++)
            System.out.println(freePeriods[i]);
    }
    
}
    

