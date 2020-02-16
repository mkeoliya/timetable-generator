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
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
import java.io.*;

public class TimeTable{

   public static String days[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
   public   Subject[] subjects;
   public   Teacher[] teachers;
   public   Section[] sections;
   public   String[][] library;
   int sum;
   public static Workbook workbook;
   private static final String FILE_NAME = "C:/Users/user/Desktop/TimeTable/TestingFile.xlsm";
   private static final String OUT_FILE = "C:/Users/user/Desktop/TimeTable/OutFile.xlsx";
   
   public TimeTable(){
       subjects=new Subject[26];
       teachers=new Teacher[55];
       sections=new Section[34];
       library=new String[5][8];
       sum=0;
   }

    public static void main(String[] args) {

        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            workbook = new XSSFWorkbook(excelFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        TimeTable original=new TimeTable();
        original.buildTeacherArray(); //includes TeacherTimeTable 
        original.buildSubjectArray();
        original.buildSectionArray(); //includes individual class worksheets 
        
        original.transferFinalToPossible();
        original.buildPossibleSlots();
        
        /*for(int i=1;i<original.teachers.length;i++){
            System.out.println("\n\n" + original.teachers[i].teacherName);
            original.printTimeTable(original.teachers[i].possibleSlots);
        }
        */
        
        
        TimeTable fin=new TimeTable();
        fin.swap(original);
        /*for(int day=2;day<3;day++){
            System.out.println("the day is = " + day);
            TimeTable dayObj=original.buildTimeTable(1000000,day);
            for(int i=0;i<8;i++){
                for(int t=1;t<original.teachers.length;t++){
                    //System.out.println("\n\n" + fin.teachers[t].teacherName);
                    //System.out.println(dayObj.teachers[t].remainingSubjects[day]);
                    //System.out.println(dayObj.teachers[t].remainingSections[day]);
                    fin.teachers[t].teacherSlots[day][i]=dayObj.teachers[t].teacherSlots[day][i];
                }
                for(int t=1;t<original.sections.length;t++)
                    fin.sections[t].sectionSlots[day][i]=dayObj.sections[t].sectionSlots[day][i];
            }
            
        }
        */
        fin.buildTimeTable(50000);

        /*for(int i=1;i<original.teachers.length;i++){
            System.out.println("\n\n" + fin.teachers[i].teacherName);
            fin.printTimeTable(fin.teachers[i].teacherSlots);
        }
        for(int i=1;i<original.sections.length;i++){
            System.out.println("\n\n" + fin.sections[i].sectionName);
            fin.printTimeTable(fin.sections[i].sectionSlots);
        }
        */
        fin.writeToFile();
         
    }
   
    
    public void writeToFile(){
        try{
            FileInputStream excelFile = new FileInputStream(OUT_FILE);
            workbook = new XSSFWorkbook(excelFile);
            Sheet teacherMaster=workbook.getSheetAt(0);
            int colNo,rowNo;
            for(int i=1;i<teachers.length-5;i++){
                colNo=((i-1)%5)*11;
                rowNo=(i/5)*8;
                //System.out.println(rowNo + ":" +colNo);
                Cell cell=teacherMaster.getRow(rowNo).getCell(colNo);
                //System.out.println(i + ":" + teachers[i].teacherName);
                for(int day=0;day<5;day++){
                    for(int period=0;period<=4;period++){
                        cell=teacherMaster.getRow(rowNo+2+day).getCell(colNo+1+period);
                        cell.setCellValue(teachers[i].teacherSlots[day][period]);
                        //System.out.println(days[day] + ":" + period + ":" + cell.getStringCellValue());
                    }
                    for(int period=5;period<=7;period++){
                        cell=teacherMaster.getRow(rowNo+2+day).getCell(colNo+2+period);
                        cell.setCellValue(teachers[i].teacherSlots[day][period]);
                       // System.out.println(days[day] + ":" + period + ":" + cell.getStringCellValue());
                    }
                        
                }
                
            }
            Sheet classMaster = workbook.getSheetAt(1);
            int divideBy=5;
            for(int i=1;i<sections.length;i++){
                if(sections[i].sectionNo>26)
                    divideBy=4;
                colNo=((i-1)%divideBy)*11;
                rowNo=(i/divideBy)*8;
                System.out.println(rowNo + ":" +colNo);
                Cell cell=classMaster.getRow(rowNo).getCell(colNo);
                //System.out.println(i + ":" + cell.getStringCellValue());
                for(int day=0;day<5;day++){
                    for(int period=0;period<=4;period++){
                        cell=classMaster.getRow(rowNo+2+day).getCell(colNo+1+period);
                        cell.setCellValue(sections[i].sectionSlots[day][period]);
                        //System.out.println(days[day] + ":" + period + ":" + cell.getStringCellValue());
                    }
                    for(int period=5;period<=7;period++){
                        cell=classMaster.getRow(rowNo+2+day).getCell(colNo+2+period);
                        cell.setCellValue(sections[i].sectionSlots[day][period]);
                        //System.out.println(days[day] + ":" + period + ":" + cell.getStringCellValue());
                    }
                        
                }
            }
            FileOutputStream outputStream = new FileOutputStream(OUT_FILE);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    public TimeTable buildTimeTable(int size, int day){
        TimeTable minimum=new TimeTable();
        int arr[]=new int[size];
        int min=999;
        ArrayList teacherList=new ArrayList<Integer>();
        Random random=new Random();
        double total=0;
        for(int mega=0;mega<size;mega++){
            TimeTable tt=new TimeTable();
            tt.swap(this);
            tt.sum=0;
            int count=0;
             
            for(int i=1;i<this.teachers.length-2;i++)
                teacherList.add(i);
                       
            tt.doIniDay(tt.teachers[52],day);
                //tt.doLastDay(tt.teachers[54],day);
                //tt.doLastDay(tt.teachers[53],day);
            tt.doIniDay(tt.teachers[23],day);
            tt.doIniDay(tt.teachers[25],day);
            tt.doIniDay(tt.teachers[32],day);
            tt.doIniDay(tt.teachers[34],day);
            tt.doIniDay(tt.teachers[45],day);
            tt.doIniDay(tt.teachers[46],day);
            tt.doIniDay(tt.teachers[50],day);
                
  
            for(int i=1;i<this.teachers.length-2;i++){
                int teacherNum= random.nextInt(53-i) + 1;
                if(teacherNum>=teacherList.size())
                    teacherNum=teacherList.size()-1;
                teacherNum=(int)teacherList.get(teacherNum);
                teacherList.remove(new Integer(teacherNum));
                if(i%2==0){
                    tt.doIniDay(tt.teachers[teacherNum], day);
                    count++;
                }
                else
                    tt.doLastDay(tt.teachers[teacherNum],day);
            }
             
            for(int i=1;i<tt.teachers.length-2;i++)
                tt.sum  = tt.sum + tt.teachers[i].remainingSubjects[day].size();
                
            if(tt.sum<min){
               min=tt.sum;
               System.out.println(mega + ":" + min);
               minimum=tt;
            } 
             if(tt.sum==0){
                 return tt;
            }
        }
       if(min>0)
           System.out.println("Imperfect Generation");
       
       return minimum;
    }
    
    public void buildTimeTable(int size){
        int minimum[]=new int[5];
        for(int i=0;i<5;i++)
            minimum[i]=99;
        
        ArrayList teacherList=new ArrayList<Integer>();
        Random random=new Random();
        double total=0;
        for(int mega=0;mega<size;mega++){
            //System.out.println("Entered at " + mega);
            if(minimum[0]==0 && minimum[1]==0 && minimum[2]==0 && minimum[3]==0 && minimum[4]==0)
                return;
            for(int day=0;day<5;day++){
            TimeTable tt=new TimeTable();
            tt.swap(this);
            tt.sum=0;
            int count=0;
             
            for(int i=1;i<this.teachers.length-2;i++)
                teacherList.add(i);
                       
            tt.doIniDay(tt.teachers[52],day);
                //tt.doLastDay(tt.teachers[54],day);
                //tt.doLastDay(tt.teachers[53],day);
            tt.doIniDay(tt.teachers[23],day);
            tt.doIniDay(tt.teachers[25],day);
            tt.doIniDay(tt.teachers[32],day);
            tt.doIniDay(tt.teachers[34],day);
            tt.doIniDay(tt.teachers[45],day);
            tt.doIniDay(tt.teachers[46],day);
            tt.doIniDay(tt.teachers[50],day);
                
  
            for(int i=1;i<this.teachers.length-2;i++){
                int teacherNum= random.nextInt(53-i) + 1;
                if(teacherNum>=teacherList.size())
                    teacherNum=teacherList.size()-1;
                teacherNum=(int)teacherList.get(teacherNum);
                teacherList.remove(new Integer(teacherNum));
                if(i%2==0){
                    tt.doIniDay(tt.teachers[teacherNum], day);
                    count++;
                }
                else
                    tt.doLastDay(tt.teachers[teacherNum],day);
            }
             
            for(int i=1;i<tt.teachers.length-2;i++)
                tt.sum  = tt.sum + tt.teachers[i].remainingSubjects[day].size();
                
            if(tt.sum<minimum[day]){
               minimum[day]=tt.sum;
               System.out.println(days[day] + ":" + mega + ":" + minimum[day]);
            } 
             if(tt.sum==0){
                 minimum[day]=0;
                 for(int i=0;i<8;i++){
                     for(int t=1;t<this.teachers.length;t++)
                       this.teachers[t].teacherSlots[day][i]=tt.teachers[t].teacherSlots[day][i];
                     for(int t=1;t<this.sections.length;t++)
                         this.sections[t].sectionSlots[day][i]=tt.sections[t].sectionSlots[day][i];
                }
            }
          }
        } 
    }
    
    
    public void swap(TimeTable original){
        for(int i=1;i<original.sections.length;i++)
            this.sections[i]=new Section(original.sections[i]);
        for(int i=1;i<original.teachers.length;i++)
            this.teachers[i]=new Teacher(original.teachers[i]);
        this.subjects=original.subjects;
        
    }
    
    /*public void scrubConsec(){
        for(int i=1;i<teachers.length;i++){
            //System.out.println("\n\n" + teachers[i].teacherName);
            for(int day=0;day<5;day++){
                //System.out.println(days[j] + " : " + teachers[i].freePeriods[j]);
               for(Integer k : teachers[i].freePeriods[day]){
                   teachers[i].availablePeriods[day].add(k);
                    if(k<5){
                        if(!teachers[i].freePeriods[day].contains(k+1) && !teachers[i].freePeriods[day].contains(k+2) && !teachers[i].freePeriods[day].contains(k+3) && k<2 )
                           teachers[i].availablePeriods[day].remove(k);
                        if(!teachers[i].freePeriods[day].contains(k-1) && !teachers[i].freePeriods[day].contains(k+1) && !teachers[i].freePeriods[day].contains(k+2)&& k<3)
                           teachers[i].availablePeriods[day].remove(k);
                        if(!teachers[i].freePeriods[day].contains(k-2) && !teachers[i].freePeriods[day].contains(k-1) && !teachers[i].freePeriods[day].contains(k+1) && k>2 )
                           teachers[i].availablePeriods[day].remove(k);
                        if(!teachers[i].freePeriods[day].contains(k-3) && !teachers[i].freePeriods[day].contains(k-2) && !teachers[i].freePeriods[day].contains(k-3) && k>3 )
                           teachers[i].availablePeriods[day].remove(k);
                    }
                }
            }  
            System.out.println("\n" + teachers[i].teacherName + "\n" + teachers[i].freePeriods[2] + ":" + teachers[i].availablePeriods[2]);
        }        
    }
    */
    
    public boolean threeConsec(Teacher teacher, int periodNo, int day){
        boolean flag=false; //checks whether allotting this period would result in 3+ consecutive periods
        int consec=0;
        for(int i=0;i<5;i++){
            if(!teacher.freePeriods[day][i] || i==periodNo)
                consec++;
            else
                consec=0;
            if(consec==4){
                return true;
            }
            
        }
        return false;
    }
    
    public void doIniDay(Teacher teacher, int day){
       // System.out.println("\n\n" + teacher.teacherName);
        int t=teacher.teacherNo;
        //System.out.println(teachers[t].freePeriods[day]);
        int consec=0,pos=0;
        for(int i=0;i<8;i++){
            if(teachers[t].remainingSubjects[day].size()==0){
               return;
            }
            boolean flag=threeConsec(teachers[t],i,day);
            if(flag && !teacher.teacherName.equals("Library") && !teacher.teacherName.equals("Art") && !teacher.teacherName.equals("GK") )
               continue;
            
            pos = getPosBestSectionAndSubject(teachers[t],i,day);
            if(pos==-1)
                continue;
                
                
                //System.out.println("The pos is = " + pos);
                Section section = getSection(teachers[t].remainingSections[day].get(pos));
                int p=section.sectionNo;
                
                String subjectName = teachers[t].remainingSubjects[day].get(pos);
                //System.out.println(sections[p].sectionName + "," + subjectName);
                teachers[t].teacherSlots[day][i]=sections[p].sectionName + "," + subjectName;
                
                sections[p].sectionSlots[day][i]=subjectName;
                Integer periodNo=new Integer(i);
                //System.out.println("Period removed :" + periodNo);
                sections[p].freePeriods[day][periodNo]=false;
                //System.out.println(sections[p].freePeriods[day]);
               // printTimeTable(sections[p].sectionSlots);
               
                teachers[t].remainingSections[day].remove(pos);
                teachers[t].remainingSubjects[day].remove(pos);
                teachers[t].freePeriods[day][periodNo]=false;
                
            
        }
        if(teachers[t].remainingSubjects[day].size()!=0){
            //System.out.println("ERROR BITCH");
        }
            
    }
    
    public Section getSection(String sectionName){
        int num,add;
        if(sectionName.length()==2){
            num= sectionName.charAt(0)-48;
            add= sectionName.charAt(1)-65;
        }
        else{
            
            num= (sectionName.charAt(0)-48)*10 + sectionName.charAt(1)-48;
            if(num==12)
              add= sectionName.charAt(2)-66;
            else
                add= sectionName.charAt(2)-65;
        }
        num = 1 + add + (num-6)*5;
        return sections[num];
    }
    
    public void doLastDay(Teacher teacher, int day){
       // System.out.println("\n\n" + teacher.teacherName);
        int t=teacher.teacherNo;
        //System.out.println(teachers[t].freePeriods[day]);
        int consec=0,pos=0;
        for(int i=7;i>=0;i--){
            if(teachers[t].remainingSubjects[day].size()==0){
               return;
            }
            boolean flag=threeConsec(teachers[t],i,day);
            if(flag && !teacher.teacherName.equals("Library") && !teacher.teacherName.equals("Art") && !teacher.teacherName.equals("GK") )
               continue;
            
            pos = getPosBestSectionAndSubject(teachers[t],i,day);
            if(pos==-1)
                continue;
                
                
                //System.out.println("The pos is = " + pos);
                Section section = getSection(teachers[t].remainingSections[day].get(pos));
                int p=section.sectionNo;
                
                String subjectName = teachers[t].remainingSubjects[day].get(pos);
                //System.out.println(sections[p].sectionName + "," + subjectName);
                teachers[t].teacherSlots[day][i]=sections[p].sectionName + "," + subjectName;
                
                sections[p].sectionSlots[day][i]=subjectName;
                Integer periodNo=new Integer(i);
                //System.out.println("Period removed :" + periodNo);
                sections[p].freePeriods[day][periodNo]=false;
                //System.out.println(sections[p].freePeriods[day]);
               // printTimeTable(sections[p].sectionSlots);
               
                teachers[t].remainingSections[day].remove(pos);
                teachers[t].remainingSubjects[day].remove(pos);
                teachers[t].freePeriods[day][periodNo]=false;
                
            
        }
        if(teachers[t].remainingSubjects[day].size()!=0){
            //System.out.println("ERROR BITCH");
        }
            
    }
    
    
    public int getPosBestSectionAndSubject(Teacher teacher, int periodNo, int day){
        int size=0;
        int t=teacher.teacherNo;
        //System.out.println("Called function with periodNo" + periodNo);
        for(String sectionName : teachers[t].remainingSections[day]){
            Section section=getSection(sectionName);
            int p=section.sectionNo;
            //System.out.println(sections[p].sectionName + " : " + sections[p].freePeriods[day]);
            if(sections[p].freePeriods[day][periodNo])
                size++;
        }
        int sectionsSort[]=new int[size];
        int i=0;
        for(String sectionName : teachers[t].remainingSections[day]){
            Section section=getSection(sectionName);
            int p=section.sectionNo;
            if(sections[p].freePeriods[day][periodNo])
              sectionsSort[i++]= (8- getSize(sections[p].freePeriods[day]));
        }
        int finalPos=-1,pos;
        Arrays.sort(sectionsSort);
        
        //System.out.println("The sorted array :");
       //for(int j=0;j<sectionsSort.length;j++)
           //System.out.println(sectionsSort[j]);
        int num;
        for(int count=0;count<sectionsSort.length;count++){
            pos=0;
            for(String sectionName : teachers[t].remainingSections[day]){
                Section section=getSection(sectionName);
                int p=section.sectionNo;
                num=(8-getSize(sections[p].freePeriods[day]));
                if(num==sectionsSort[count] && sections[p].freePeriods[day][periodNo]){
                    finalPos=pos;
                        break;
                }
                    
                pos++;
            }
        }
        return finalPos;        
    }
    
    public int getSize(boolean arr[]){
        int count=0;
        for(int i=0;i<arr.length;i++)
            if(arr[i])
                count++;
        return count;
            
        
    }
    
    
    public void transferFinalToPossible(){
        for(int i=1;i<sections.length;i++){
            int k=0;
            for(int day=0;day<5;day++){
                k=0;
                for(int period=0;period<8;period++){
                    if(!sections[i].sectionSlots[day][period].equals("")){
                      sections[i].possibleSlots[day][k++]=sections[i].sectionSlots[day][period];
                      Integer periodNo = new Integer(period);
                      sections[i].freePeriods[day][periodNo]=false;
                      
                    }
                }
                sections[i].noOfPossiblePeriods[day]=k;
            }
            //System.out.println(sections[i].sectionName);
            //printTimeTable(sections[i].possibleSlots);
        }
        
        for(int i=1;i<teachers.length;i++){
            int k=0;
            for(int day=0;day<5;day++){
                k=0;
                for(int period=0;period<8;period++){
                    if(!teachers[i].teacherSlots[day][period].equals("")){
                      teachers[i].possibleSlots[day][k++]=teachers[i].teacherSlots[day][period];
                      Integer periodNo=new Integer(period);
                      teachers[i].freePeriods[day][periodNo]=false;
                    }
                }
                teachers[i].noOfPossiblePeriods[day]=k;
            }
            //System.out.println(teachers[i].teacherName);
            //printTimeTable(teachers[i].possibleSlots);
        }
    }
    
    public void buildPossibleSlots(){
        for(int i=33;i>=1;i--){
            for(int j=0;j<sections[i].subjectTeacher1.length;j++){
                //System.out.println(sections[i].subjectTeacher1[j] + ":" + sections[i].sectionName);
                Teacher teacher = getTeacherObject(sections[i].subjectTeacher1[j]);
                int periodsToAllot = sections[i].remainingPeriods[j];
                //if(!sections[i].subjects[j].equals("Library") )//&& !sections[i].subjects[j].equals("Art") && !sections[i].subjects[j].equals("GK"))
                doThePossibleSlotCalculation(i,sections[i],teacher,periodsToAllot,sections[i].subjects[j]);
            }
        }
    }
    
    public boolean alreadyDone(String subName,Section section,int day){
        boolean flag=false;
        for(int i=0;i<8;i++){
            if(section.possibleSlots[day][i].equals(subName))
                flag=true;
        }
        return flag;
    }
    
    public void doThePossibleSlotCalculation(int sectionNo,Section section, Teacher teacher, int periodsToAllot,String subjectName){
        //System.out.println(section.sectionName + ":" + teacher.teacherName + " : " +subjectName + " : " + periodsToAllot + "\n");
        String daysSort[]=new String[5],combo;
        int maxPeriods=6;
        int avail=5;
        if(teacher.teacherName.equals("Art") || teacher.teacherName.equals("GK") )
            maxPeriods=3;
        if(teacher.teacherName.equals("Library"))
            maxPeriods=8;
        for(int i=0;i<5;i++){ 
            if(alreadyDone(subjectName,section,i)){
                avail--;
                daysSort[i]="Error : Already allotted today";
                continue;
            }
          daysSort[i]=section.noOfPossiblePeriods[i]+ "" +  teacher.noOfPossiblePeriods[i] + i;
          //System.out.println(daysSort[i]);
          if(teacher.noOfPossiblePeriods[i]==maxPeriods){
              daysSort[i]="Error : 6 periods for teacher exceeded";
              avail--;
          }
          else{
          if(i!=4){
              if(section.noOfPossiblePeriods[i]==8){
                  daysSort[i]="Error : 8 periods for class exceeded";
                  avail--;
              }
          }
          else{
              if(sectionNo<26){
                  if(section.noOfPossiblePeriods[i]==8){
                      daysSort[i]="Error : 8 periods for class exceeded";
                      avail--;
                  }
              }
              else{
                  if(section.noOfPossiblePeriods[i]==5){
                      daysSort[i]="Error : 5 periods for class exceeded";
                      avail--;
                  }
              }
          }
          }
        }
        
        if(avail<periodsToAllot){
            System.out.println("You");
            System.out.println(section.sectionName + ":" + teacher.teacherName + ":" + subjectName);
        }
            
        Arrays.sort(daysSort);
        //System.out.println("The sorted array is = ");
        //for(int i=0;i<5;i++)
            //System.out.println(daysSort[i]);
        
        for(int i=0;i<periodsToAllot;i++){
            if(daysSort[i].length()<4){
                int day=daysSort[i].charAt(2)-48;
               // System.out.println("The day and the periods already alotted");
                //System.out.println(days[day] + ":" + section.noOfPossiblePeriods[day]);
                
                int sectionIndex=section.noOfPossiblePeriods[day];//section index is the current slot where possible period is to be inserted
                section.noOfPossiblePeriods[day]++; //one more period added
                section.possibleSlots[day][sectionIndex++]=subjectName;
                
                int teacherIndex=teacher.noOfPossiblePeriods[day];
                teacher.noOfPossiblePeriods[day]++;//one more period added
                teacher.possibleSlots[day][teacherIndex]=section.sectionName + "," + subjectName;
                teacher.remainingSubjects[day].add(subjectName);
                teacher.remainingSections[day].add(section.sectionName);
            }
            else{
                //System.out.println("Error :" + daysSort[i]);
                //System.exit(0);
            }
        }
        //printTimeTable(section.possibleSlots);
        //printTimeTable(teacher.possibleSlots);        
        //System.out.println("\n\n");
    }
    
    
    
    
    
    public  void buildTeacherArray(){
        Sheet TeacherList=workbook.getSheetAt(4);
        Row row;
        Cell cell,nextCell;
        for(int i=1;i<55;i++){
            teachers[i]=new Teacher();
                row=TeacherList.getRow(i);  
                cell=row.getCell(24);
                nextCell=row.getCell(25);
                teachers[i].teacherName=cell.getStringCellValue();
                teachers[i].teachInit=nextCell.getStringCellValue();
                teachers[i].teacherNo=i;
            }
        
        Sheet TeacherTimeTable=workbook.getSheetAt(1);
        for(int i=1;i<55;i++){
            row=TeacherTimeTable.getRow(i+1);
            for(int j=1;j<=40;j++){
                int dayNo=(j-1)/8;//0 based
                int periodNo=(j-1)%8;    //0 based
                Cell c=row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if(c!=null)
                 teachers[i].teacherSlots[dayNo][periodNo]=row.getCell(j).getStringCellValue();
            }
        }
        
        
                
      }
        
            
         
    
    
    public void buildSubjectArray(){
        Sheet TeacherList=workbook.getSheetAt(4);
        Row row;
        Cell cell,nextCell;
        for(int i=1;i<26;i++){
            subjects[i]=new Subject();
            row=TeacherList.getRow(i);
            cell=row.getCell(26);
            nextCell=row.getCell(27);
            subjects[i].subjectName=cell.getStringCellValue();
            subjects[i].subjectInit=nextCell.getStringCellValue();  
        }
        
    }
    
    public void buildSectionArray(){
        Sheet classSheet;
        Sheet TeacherList=workbook.getSheetAt(4);
        int noOfSubjects=0,noOfPeriods=0,colNo=0,dayNo=0;
        String subjectName;
        Row row;
        Cell subjectCell=null,cell=null,nextCell,nextNextCell,teacherCell,remainingPeriodsCell;
        for(int i=1;i<=33;i++){
            row=TeacherList.getRow(i);
            cell=row.getCell(28);
            nextCell=row.getCell(29);
            noOfSubjects=(int)nextCell.getNumericCellValue();
            sections[i]=new Section(noOfSubjects,i);
            sections[i].sectionName=cell.getStringCellValue();
            //System.out.println(sections[i].sectionName + ":" + i);
        }
        
        for(int i=1;i<sections.length;i++)
        {
            String teacherName;
            classSheet=workbook.getSheetAt(i+4);
            noOfSubjects=sections[i].subjects.length;
            for(int j=25;j<25+noOfSubjects;j++){
                row=classSheet.getRow(j);
                subjectCell=row.getCell(0);
                teacherCell=row.getCell(1, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                nextNextCell=row.getCell(2);
                remainingPeriodsCell=row.getCell(3);
                
                subjectName=subjectCell.getStringCellValue();
                sections[i].subjects[j-25]=subjectName;
                
                        
                noOfPeriods=(int)nextNextCell.getNumericCellValue();
                sections[i].periodsPerWeek[j-25]=noOfPeriods;
                
                sections[i].remainingPeriods[j-25]=(int)remainingPeriodsCell.getNumericCellValue();
                
                
                if(teacherCell==null)
                    continue;
                
                teacherName=teacherCell.getStringCellValue();
                fillSubTeachers(subjectName,i,j-25,teacherCell.getStringCellValue());
            }
            
                
        }
        for(int i=1;i<sections.length;i++){
            classSheet=workbook.getSheetAt(i+4);
            for(int rowNo=3;rowNo<20;rowNo+=4){
                row=classSheet.getRow(rowNo);
                
                for(colNo=1;colNo<=5;colNo++){
                    cell=row.getCell(colNo,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    if(cell==null || cell.getStringCellValue().equals("Select"))
                        continue;
                    dayNo=getDayNo(row.getCell(0).getStringCellValue());
                    sections[i].sectionSlots[dayNo][colNo-1]=cell.getStringCellValue();
                    if(cell.getStringCellValue().equals("Library"))
                        library[dayNo][colNo-1]=sections[i].sectionName;
                }
                for(colNo=7;colNo<10;colNo++){
                    cell=row.getCell(colNo,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    if(cell==null || cell.getStringCellValue().equals("Select"))
                        continue;
                    dayNo=getDayNo(row.getCell(0).getStringCellValue());
                    sections[i].sectionSlots[dayNo][colNo-2]=cell.getStringCellValue();
                    if(cell.getStringCellValue().equals("Library"))
                        library[dayNo][colNo-2]=sections[i].sectionName;
                }
            }
        }
            
    }
    
    public void fillSubTeachers(String subjectName,int i,int subjectNo,String teacherName){
        String DoubleTeachers[]={"SecondLanguage","ThirdLanguage","SixthSubject_ICSE","SixthSubjectISCScience",
                                 "SixthSubjectISCommerce"};
        String teacher1,teacher2,teacher3;
        int pos,pos2;
        for(int ele=0;ele<DoubleTeachers.length;ele++){
            if(subjectName.equals(DoubleTeachers[ele])){
                if(i!=20){
                    pos=teacherName.indexOf("/");
                    teacher1=teacherName.substring(0,pos);
                    sections[i].subjectTeacher1[subjectNo]=teacher1;
                    teacher2=teacherName.substring(pos+1);
                    sections[i].subjectTeacher2[subjectNo]=teacher2;
                    return; 
                }
                else{
                    sections[i].subjectTeacher1[subjectNo]=teacherName;
                    return;
                }
                }      
            }
        
        if(!subjectName.equals("FifthSubject"))
            sections[i].subjectTeacher1[subjectNo]=teacherName;
        else{
            if(i==28 || i==32){
                sections[i].subjectTeacher1[subjectNo]=teacherName;
                return;
            }
            pos=teacherName.indexOf("/");
            pos2=teacherName.lastIndexOf("/");
            teacher1=teacherName.substring(0,pos);
            teacher2=teacherName.substring(pos+1,pos2);
            teacher3=teacherName.substring(pos2+1);
            sections[i].subjectTeacher1[subjectNo]=teacher1;
            sections[i].subjectTeacher2[subjectNo]=teacher2;
            sections[i].subjectTeacher3[subjectNo]=teacher3;
          
            }
        }
    
    public Teacher getTeacherObject(String teacherName){
        Teacher obj=null;
        for(int i=1;i<teachers.length;i++)
            if(teachers[i].teacherName.equals(teacherName))
                obj=teachers[i];
       return obj;
    }
    
    public int getSubjectForSection(String subjectName,int sectionNo){
        int no=-1;
        for(int i=0;i<sections[sectionNo].subjects.length;i++){
            if(sections[sectionNo].subjects[i].equals(subjectName))
                no=i;
        }
        return no;
    }
    
    public int getDayNo(String dayName){
        int dayNo=-1;
        dayName=dayName.trim();
        String days[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
        for(int i=0;i<days.length;i++)
            if(days[i].equals(dayName))
                dayNo=i;
        return dayNo;
    }
    
    
    public void printTimeTable(String timetable[][]){
        String format = "|%1$-15s|%2$-15s|%3$-15s|%4$-15s|%5$-15s|%6$-15s|%7$-15s|%8$-15s|%9$-15s|\n";
        System.out.format(format,"","1st","2nd","3rd","4th","5th","6th","7th","8th");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        String days[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
        String print;
            for(int k=0;k<5;k++){
                System.out.format(format,days[k],timetable[k][0],timetable[k][1],timetable[k][2],timetable[k][3],timetable[k][4],timetable[k][5],timetable[k][6],timetable[k][7]);
                System.out.println();
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");           
                }
    System.out.println("\n\n");
    }
       
}
    





    


