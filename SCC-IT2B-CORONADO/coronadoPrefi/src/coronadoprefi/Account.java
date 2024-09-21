package coronadoprefi;

import java.util.Scanner;

public class Account {
    
    Scanner sc = new Scanner(System.in);
    
    Accounts[] ac = new Accounts [100];
    
    int accountNum;
    int counter = 0;
    String pass;
    
    public void menu(){
        
        boolean status;
        
        do{
            System.out.println();
            System.out.println("Welcome to Account App");
            System.out.println("-------------------------------------");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. EXIT");
            System.out.println("-------------------------------------");
            System.out.print("  Enter Action: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    inputSalary();
                    status = tryAgain();
                    break;
                    
                case 2:
                    if(counter == 0){
                        System.out.println(" No Account yet!");
                        status = tryAgain();
                        break;
                    }
                    else {
                        view();
                        System.out.println();
                        status = tryAgain();
                    }
                    break;
                    
                case 3:
                    if(counter == 0){
                        System.out.println(" No Accounts Yet.");
                        status = tryAgain();
                        break;
                    }
                    else {
                        editAccount();
                        status = tryAgain();
                    }
                    break;
                    
                case 4:
                    status = true;
                    break;
                    
                default:
                    System.out.println(" Error! Try again.");
                    status = false;
            }
        }while(!status);
        
        exitSelection();
        
    }
    
    public void inputSalary(){
        
        boolean status = false;
        
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
                String lname = sc.nextLine();
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
        
        System.out.println();
        System.out.println(" -------------------------------------------------------------------------------------");
        System.out.printf(" %-10s %-10s %-15s %-30s %-10s %-10s\n",
                           "ID", "First Name", "Last Name", "Email", "User", "Password");
        System.out.println(" -------------------------------------------------------------------------------------");
        
        for(int i = 0; i < counter; i++){
                    ac[i].display();
            }
        
    }
    
     public boolean tryAgain(){
        
        boolean valid = false;
        boolean status = false;
        
            do{
                
                System.out.println();
                System.out.print("Enter again? (Y/N):");
                String choice = sc.next();
                sc.nextLine();
                //System.out.println(choice.equalsIgnoreCase("y"));
            switch (choice) {
                case "y", "Y" -> {
                    valid = false;
                    status = true;
                }
                case "n", "N" -> {
                    valid = true;
                    status = true;
                }
                default -> {
                    System.out.println("Invalid Choice!");
                    status = false;
                }
            }

            }while(!status);
        
        return valid;
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

     public void editAccount(){
         
         boolean status = false;
        
       System.out.println("");
       System.out.print("Enter ID of the Account: ");
       String idin = sc.next();
       sc.nextLine();

         for (int i = 0; i < counter; i++) {
            if (ac[i].id.equals(idin)) {
            System.out.print("New Email: ");
            String email = sc.nextLine();
            System.out.print("New Username: ");
            String user = sc.nextLine();
            while(!status){
                    System.out.print(" New Password: ");
                    pass = sc.nextLine();
                    status = passCheck(pass);
                }
            ac[i].editAccount(idin, email, user, pass);
            break;
            }
            else{
                System.out.println("No ID found.");
            }
         }
     }
     
     public void exitSelection(){
        
        boolean status = false;
        
            do{
                
                    System.out.println();
                    System.out.print("Exit to Main Menu? (Y/N):");
                    String choice = sc.next();
                    sc.nextLine();

                    if(choice.equals("y") || choice.equals("Y")){
                        CoronadoPrefi.main(null);
                    }
                    else if(choice.equals("n") || choice.equals("N"))
                    {   
                        System.out.println("Thankyou for using the App!");
                        System.exit(0);
                    }
                    else{
                        System.out.println("Invalid Choice!");
                        status = false;
                    }

            }while(!status);
    }
     
}
