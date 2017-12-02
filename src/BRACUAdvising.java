import javax.swing.JOptionPane;
import java.util.*;
public class BRACUAdvising {
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        
        USIS obj=new USIS();
        
        for ( ; ; ){
        String key=JOptionPane.showInputDialog("L or l to Log in"
                + "\nR or r to Register"
                + "\nAnything Else to Close Program"
                + "\nA or a for Advisor/Admin");    
        if(key.equalsIgnoreCase("L")){
            obj.logIn();
            continue;
        }
        else if(key.equalsIgnoreCase("R")){
            obj.register();
            continue;
        }
        else if(key.equalsIgnoreCase("A")){
            obj.admin();
            continue;
        }
        else{
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "Program has been CLOSED!",
                "Shutting Down",JOptionPane.PLAIN_MESSAGE);
    }
    
}
