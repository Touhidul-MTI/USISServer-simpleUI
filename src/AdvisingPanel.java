import javax.swing.JOptionPane;
import java.util.*;
public class AdvisingPanel {
    Scanner kb=new Scanner(System.in);
    
    private int seatTotal=5;
    private int sectionNumber=3;
    private int size=0;
    Course courseArray[]=new Course[seatTotal*sectionNumber];
    
    public int sec1=0;
    public int sec2=0;
    public int sec3=0;
    String courseName="CSE310";
    
    public void option(String name, String ID){
        JOptionPane.showMessageDialog(null,"Loged In Successfully",
                "Advising Panel",JOptionPane.PLAIN_MESSAGE);
        for(int i=0; i<1; i++){
            String key=JOptionPane.showInputDialog("A or a to Add Course\n"
                    + "D or d to Drop a Course\n"
                    + "P or p to Print Your Details\n"
                    + "Anything Else to Log Out");
            if(key.equalsIgnoreCase("A")){
                add(name, ID);
                i--;
            }else if(key.equalsIgnoreCase("D")){
                drop(name, ID);
                i--;
            }else if(key.equalsIgnoreCase("P")){
                show(name, ID);
                i--;
            }else{
                i++;
            }
        }
        JOptionPane.showMessageDialog(null,"You are Loged Out!"
                , "Logging Out",JOptionPane.PLAIN_MESSAGE);
    }
    
    public void add(String name, String ID){
        
        if(!repeatCheck(ID)){
            JOptionPane.showMessageDialog(null,"You Have Already Taken This Course"
                , "Course Adding",JOptionPane.WARNING_MESSAGE);
        }else{
            String secKey=JOptionPane.showInputDialog("Course Title: "+courseName+".  (Enter Left Serial Key to Choose Section)\n"
                    + "-----------------------------------------------------------------------------------------\n"
                    + "1.  Section 1     Sunday: 10:00 AM - 11:30 AM     "+(seatTotal-sec1)+" Seats Remaining"
                    + "\n2.  Section 2     Sunday: 12:00 PM - 01:30 PM     "+(seatTotal-sec2)+" Seats Remaining"
                    + "\n3.  Section 3     Sunday: 02:00 PM - 03:30 PM     "+(seatTotal-sec3)+" Seats Remaining");
            int sec=Integer.parseInt(secKey);
        if(sec==1){
            if(sec1<seatTotal){
                JOptionPane.showMessageDialog(null,"Section 1 Has Been Added Successfully"
                , "Course Adding",JOptionPane.PLAIN_MESSAGE);
                courseArray[size]=new Course(name, ID, courseName, 1, "Sunday 10:00 AM - 11:30 AM");
                size++;
                sec1++;
            }else{
                JOptionPane.showMessageDialog(null,"Sorry! No Seat Available in Section 1, Choose Another Section"
                , "Course Adding",JOptionPane.WARNING_MESSAGE);
            }
        }else if(sec==2){
            if(sec2<seatTotal){
                JOptionPane.showMessageDialog(null,"Section 2 Has Been Added Successfully"
                , "Course Adding",JOptionPane.PLAIN_MESSAGE);
                courseArray[size]=new Course(name, ID, courseName, 2, "Sunday 12:00 PM - 01:30 PM");
                size++;
                sec2++;
            }else{
                JOptionPane.showMessageDialog(null,"Sorry! No Seat Available in Section 2, Choose Another Section"
                , "Course Adding",JOptionPane.WARNING_MESSAGE);
            }
        }else if(sec==3){
            if(sec3<seatTotal){
                JOptionPane.showMessageDialog(null,"Section 3 Has Been Added Successfully"
                , "Course Adding",JOptionPane.PLAIN_MESSAGE);
                courseArray[size]=new Course(name, ID, courseName, 3, "Sunday 02:00 PM - 03:30 PM");
                size++;
                sec3++;
            }else{
                JOptionPane.showMessageDialog(null,"Sorry! No Seat Available in Section 3, Choose Another Section"
                , "Course Adding",JOptionPane.WARNING_MESSAGE);
            }
        }
        }
        
    }
    public boolean repeatCheck(String ID){
      for(int i=0; i<size; i++){
        if(courseArray[i].getId().equals(ID)){
          if(courseArray[i].getCourseName().equals(courseName)){
            return false;
          }
        }
      }return true;
    }
    public void drop(String name, String ID){
        int idCheck=0;
        for(int i=0; i<size; i++){
            if(ID.equals(courseArray[i].getId())){
                
                int secDrop=courseArray[i].getSection();
                if(secDrop==1){sec1--;}
                else if(secDrop==2){sec2--;}
                else if(secDrop==3){sec3--;}
                
                for(int j=i; j<size-1; j++){
                    courseArray[j]=courseArray[j+1];
                }
                courseArray[size-1]=null;
                size--;
                idCheck++;
                break;
            }
        }
        if(idCheck==0){
            JOptionPane.showMessageDialog(null, "Name: "+name+"\nID: "+ID+
                    "\nNo Courses in the List to Drop",
                    "Course Dropping",JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Course was Successfully Droped",
                    "Course Dropping",JOptionPane.PLAIN_MESSAGE);
        }
    }
    public void show(String name, String ID){
        
        int idCheck=0;
        String takenCourse="";
        int takenSec=0;
        String classTime="";
        for(int i=0; i<size; i++){
            if(ID.equals(courseArray[i].getId())){
                idCheck++;
                takenCourse=courseArray[i].getCourseName();
                takenSec=courseArray[i].getSection();
                classTime=courseArray[i].getTime();
                break;
            }
        }
        if(idCheck==0){
            JOptionPane.showMessageDialog(null, "Name: "+name+"\nID: "+ID+
                    "\nNo Courses in the List",
                    "Advised Course Details",JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Name: "+name+"\nID: "+ID+
                    "\nCourse Name: "+takenCourse+
                    "\nSection: "+takenSec+
                    "\nClass Time: "+classTime,
                    "Advised Course Details",JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void adminView(){
          String viewKey=JOptionPane.showInputDialog("Enter Left Key to See Registered Students"
                + "\n---------------------------------------------------------"
                + "\n1.  Students in Section 1"
                + "\n2.  Students in Section 2"
                + "\n3.  Students in Section 3");
          
          String name="";
          String ID="";
          Object r[]=new Object[seatTotal*2];
          
            int secView=Integer.parseInt(viewKey);
            int secCheck=0;
            
            //System.out.println("[NAME]   [ID]");
            
            if(secView==1){
                
                for(int i=0; i<size; i++){
                    if(1==courseArray[i].getSection()){
                        
                       // System.out.print("  "+courseArray[i].getName()+"    ");
                       // System.out.println(courseArray[i].getId()+"    ");
                        
                        name=courseArray[i].getName();
                        ID=courseArray[i].getId();
                        r[secCheck]=name;
                        r[secCheck+1]=ID;
                        secCheck++;
                    }
                }
            }
            else if(secView==2){
                
                for(int i=0; i<size; i++){
                    if(2==courseArray[i].getSection()){
                        
                       // System.out.print("  "+courseArray[i].getName()+"    ");
                        //System.out.println(courseArray[i].getId()+"    ");
                        
                        name=courseArray[i].getName();
                        ID=courseArray[i].getId();
                        r[secCheck]=name;
                        r[secCheck+1]=ID;
                        secCheck++;
                    }
                }
            }
             else if(secView==3){
                
                for(int i=0; i<size; i++){
                    if(3==courseArray[i].getSection()){
                        
                        //System.out.print("  "+courseArray[i].getName()+"    ");
                       // System.out.println(courseArray[i].getId()+"    ");
                        
                        name=courseArray[i].getName();
                        ID=courseArray[i].getId();
                        r[secCheck]=name;
                        r[secCheck+1]=ID;
                        secCheck++;
                    }
                }
            }
            
            if(secCheck==0){
                {
                  JOptionPane.showMessageDialog(null, "No Student Registered Yet in Section "+secView,
                    "Registered Students",JOptionPane.PLAIN_MESSAGE);
              }
            }else{
                view(r, secCheck, secView);
            }
            
            String key=JOptionPane.showInputDialog("A or a to See Again Registered Students"
                    + "\nAnything Else to Log Out");
            if(key.equalsIgnoreCase("A")){
                adminView();
            }else{
                JOptionPane.showMessageDialog(null, "You are Loged Out",
                    "Admin",JOptionPane.PLAIN_MESSAGE);
            }
    }
    public void view(Object[]r, int secCheck, int secView){
            if(secCheck==1){
                  JOptionPane.showMessageDialog(null, "NAME     ID\n"+r[0]+"    "+r[1],
                          "Advised Students", JOptionPane.PLAIN_MESSAGE); 
              }else if(secCheck==2){
                  JOptionPane.showMessageDialog(null, "NAME     ID\n"+r[0]+"    "+r[1]+
                          "\n"+r[2]+"    "+r[3], "Advised Students", JOptionPane.PLAIN_MESSAGE); 
              }else if(secCheck==3){
                  JOptionPane.showMessageDialog(null, "NAME     ID\n"+r[0]+"    "+r[1]+
                          "\n"+r[2]+"    "+r[3]+"\n"+r[4]+"    "+r[5], "Advised Students",
                          JOptionPane.PLAIN_MESSAGE); 
              }else if(secCheck==4){
                  JOptionPane.showMessageDialog(null, "NAME     ID\n"+r[0]+"    "+r[1]+
                          "\n"+r[2]+"    "+r[3]+"\n"+r[4]+"    "+r[5]+"\n"+r[6]+"    "+r[7],
                          "Advised Students", JOptionPane.PLAIN_MESSAGE); 
              }else if(secCheck==5){
                 JOptionPane.showMessageDialog(null, "NAME     ID\n"+r[0]+"    "+r[1]+
                         "\n"+r[2]+"    "+r[3]+"\n"+r[4]+"    "+r[5]+"\n"+r[6]+"    "+r[7]+
                         "\n"+r[8]+"    "+r[9], "Advised Students", JOptionPane.PLAIN_MESSAGE); 
              }
    }
}
