package coronadoprefi;

import java.util.Scanner;

public class Account {
    
    Scanner sc = new Scanner(System.in);
    
    Accounts[] ac = new Accounts [100];
    
    int accountNum;
    int counter = 0;
    boolean status = false;
    String pass;
    
    public void menu(){
        
        boolean status = false;
        
        do{
            System.out.println();
            System.out.print("Main menu:\n1. Add Account\n2. View Account\nEnter Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    inputSalary();
                    status = tryAgain();
                    break;
                case 2:
                    if(counter == 0){
                        System.out.println("No Account yet!");
                        status = false;
                    }
                    else {
                        System.out.println();
                        System.out.println(" -------------------------------------------------------------------------------------");
                        System.out.printf(" %-10s %-10s %-10s %-10s %-10s %-10s\n",
                           "ID", "First Name", "Last Name", "Email", "User", "Password");
                        System.out.println(" -------------------------------------------------------------------------------------");
                        view();
                        System.out.println();
                        status = tryAgain();
                    }
                    break;
                default:
                    System.out.println("Error! Try again.");
                    status = false;
            }
        }while(!status);
        
        System.out.println("Thankyou for using!");
        
    }
    
    public void inputSalary(){
        
        System.out.println("-------------------------------------------------");
        System.out.print("\n(1)Enter no. of Account: ");
        accountNum = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < accountNum; i++){
                
                System.out.print("\n ID: ");
                String id = sc.nextLine();
                System.out.print(" First Name: ");
                String fname = sc.nextLine();
                System.out.print(" Last Name: ");
                String lname = sc.nextLine();;
                System.out.print(" Email: ");
                String email = sc.nextLine();
                System.out.print(" User: ");
                String user = sc.nextLine();
                
                while(!status){
                    System.out.print(" Password: ");
                    pass = sc.nextLine();
                    status = passCheck(pass);
                }
                
                System.out.println("\n-------------------------------------------------\n");

                ac[counter] = new Accounts();
                ac[counter].storage(id, fname, lname, email, user, pass);
                counter++;
                
         }
        
    }
    
    public void view(){
        
        for(int i = 0; i < counter; i++){
                    ac[i].display();
            }
        
    }
    
    public boolean tryAgain(){
        
        System.out.print("Enter again? (Y/N):");
        String choice = sc.next();
        
        //System.out.println(choice.equalsIgnoreCase("y"));
        
        return !choice.equalsIgnoreCase("y");
    }
    
    public boolean passCheck(String pass){
        boolean valid = true;
        
        if(pass == null || pass.isEmpty()){
            System.out.println("Is Empty!");
            valid = false;
        }
        if(pass.length() < 8){
            System.out.println("Password must be atleast 8 character long!");
        }
        if(!pass.matches(".*[a-z].*")){
            System.out.println("Contain atleast 1 small letter!");
            valid = false;
        }
        if(!pass.matches(".*[A-Z].*")){
            System.out.println("Contain atleast 1 capital letter!");
            valid = false;
        }
        if(!pass.matches(".*[0-9].*")){
            System.out.println("Password must have atleast 1 digit");
            valid = false;
        }
        if(!pass.matches(".*[!@#$%&+=].*")){
            System.out.println("Contain atleast 1 special character!");
            valid = false;
        }
        
        String[] commonPW = {"admin", "user", "password", "1234"};
        
        for(String commonpass : commonPW){
            
            if(pass.toLowerCase().contains(commonpass)){
                System.out.println("Must not have common names! ex. admin, 1234, password");
                valid = false;
                break;
            }
            
        }
        
        return valid;
    }
    
}
