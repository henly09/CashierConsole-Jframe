// Final Project CC103
// Authors:
// Cyrex Joshua Cuizon
// John Henly Montera
// Leah Mae Mamaril
package cashiersystem;
import static cashiersystem.CashierSystem.sc;
import static cashiersystem.CashierSystem.passcode;
public class CashierApp {
    public static void main(String[] args) {       
        System.out.println("Grocery Cashier System Inc.");
        password ();
    }  
    public static void password(){   
            String input; 
            System.out.println("Enter the Passcode: ");
            input = sc.nextLine();           
            if (input.equals(passcode)){
            while (true){
                CashierSystem.Intro();
            }
        }
        else {
            System.out.println("Invalid Password");
        }  
    }   
}
