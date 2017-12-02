import javax.swing.JOptionPane;
import java.util.*;
public class USIS {
    Scanner kb=new Scanner(System.in);
    
    public int size=0;
    public User userArray[]=new User[20];
    AdvisingPanel apObj=new AdvisingPanel();
    
    public void logIn(){
        String mail=JOptionPane.showInputDialog("Your E-mail");
        String pass=JOptionPane.showInputDialog("Your Password");
        if(size==0){
        JOptionPane.showMessageDialog(null, "Invalid Email & Password, Please Register First",
                "USIS Log In",JOptionPane.ERROR_MESSAGE);   
            register(); 
        }else{
            int match=0;
            int logSuccess=0;

            for(int c=0; c<size; c++){
                int mailCheck=0;
                int passCheck=0;
                
                if(mail.equalsIgnoreCase(userArray[c].getEmail())){
                    mailCheck++;
                    match++;
                }
                if(pass.equals(userArray[c].getPass())){
                    passCheck++;
                }
                if(mailCheck>0 && passCheck>0){
                    apObj.option(userArray[c].getName(), userArray[c].getId());
                    logSuccess++;
                    break;
                }
            }
            if(logSuccess>0){}
            else{
                if(match==0){
                    JOptionPane.showMessageDialog(null, "Invalid Email & Password,"
                            + " Please Register First",
                            "USIS Log In",JOptionPane.ERROR_MESSAGE);    
                    register();
                }else if(match>0){
                    JOptionPane.showMessageDialog(null, "Invalid Password, Try Again",
                            "USIS Log In",JOptionPane.ERROR_MESSAGE);    
                    logIn();
                }
            }
        }
    }
    public void register(){
        if(size==userArray.length){
           User reArray[]=new User[userArray.length+3];
           for(int i=0; i<size; i++){
               reArray[i]=userArray[i];
           }
           userArray=reArray;
        }
        String name=JOptionPane.showInputDialog("USIS Registration Form\n"
                + "---------------------------------\nGive Your Name");
        String id=JOptionPane.showInputDialog("USIS Registration Form\n"
                + "---------------------------------\nGive Your Student ID");
        String email=JOptionPane.showInputDialog("USIS Registration Form\n"
                + "---------------------------------\nGive Valid E-mail");
        String password=JOptionPane.showInputDialog("USIS Registration Form\n"
                + "---------------------------------\nEnter password");
            
            userArray[size]=new User(name, id, email, password);
            
            size++;
            JOptionPane.showMessageDialog(null, "Registration Successful!",
                    "USIS Registration",JOptionPane.PLAIN_MESSAGE);
    }
    
    public void admin(){
        String adminPass=JOptionPane.showInputDialog("Enter Administrative Password");
        if(adminPass.equalsIgnoreCase("Admin")){
            apObj.adminView();
            
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Password",
                    "Administrative Login",JOptionPane.ERROR_MESSAGE);
        }
    }
}
