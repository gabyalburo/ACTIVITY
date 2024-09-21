package coronadoprefi;

import java.util.Scanner;

public class Salary {
    
   Scanner sc = new Scanner(System.in);
    
     Salaries[] sr = new Salaries [100];
    
     int employeeNum;
     int counter = 0;
    
    public void menu(){
        
        boolean status;
        
        do{
            System.out.println();
            System.out.println("Welcome to Salary App");
            System.out.println("-------------------------------------");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. EXIT");
            System.out.println("-------------------------------------");
            System.out.print("  Enter Action: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 -> {
                    inputSalary();
                    status = tryAgain();
                }
                case 2 -> {
                    if(counter == 0){
                        System.out.println("  No Employees yet!");
                        status = tryAgain();
                        break;
                    }
                    else {
                        view();
                        System.out.println();
                        status = tryAgain();
                    }
                }
                    
                case 3 -> {
                    if(counter == 0){
                        System.out.println("No Employees yet!");
                        status = tryAgain();
                        break;
                    }
                    else {
                        editSalary();
                        status = tryAgain();
                    }
                }
                case 4 -> status = true;
                    
                default -> {
                    System.out.println("Error! Try again.");
                    status = false;
                }
            }
            
        }while(!status);
        
        exitSelection();
        
    }
    
    public void inputSalary(){
        
        System.out.println("-------------------------------------------------");
        System.out.print("\n(1)Enter no. of Employee: ");
        employeeNum = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < employeeNum; i++){
                
                System.out.print("\n ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print(" Name: ");
                String name = sc.nextLine();
                System.out.print(" Rate: ");
                double rate = sc.nextDouble();
                sc.nextLine();
                System.out.print(" Hours Worked: ");
                double hour = sc.nextDouble();
                sc.nextLine();
                System.out.print(" Deduction: ");
                double deduction = sc.nextDouble();
                sc.nextLine();
                System.out.println("\n-------------------------------------------------\n");

                sr[counter] = new Salaries();
                sr[counter].storage(id, name, rate, hour, deduction);
                counter++;
                
         }
        
    }
    
    public void view(){
        
        double tolSalary = 0;
        double tolDeduction = 0;
        
        System.out.println();
        System.out.println(" -------------------------------------------------------------------------------------");
        System.out.printf(" %-10s %-20s %-10s %-10s %-10s %-10s %-10s\n",
                           "ID", "Name", "Rate", "Hours", "Gross", "Deduction", "NetPay");
        System.out.println(" -------------------------------------------------------------------------------------");
        
            for(int i = 0; i < counter; i++){
                sr[i].display();
            }
        
            for (int i = 0; i < counter; i++) {
                tolSalary += sr[i].rate();
                tolDeduction += sr[i].deduction(); 
            }
            
        double tolNet = tolSalary - tolDeduction;
        
            System.out.println(" -------------------------------------------------------------------------------------");
            System.out.println(" Total Salary request: "+tolSalary);
            System.out.println(" Total Employee Deduction: "+tolDeduction);
            System.out.println(" Total Net Pay: "+tolNet);
            System.out.println(" No. of Employees: "+counter);
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

                if(choice.equals("y") || choice.equals("Y")){
                    valid = false;
                    status = true;
                }
                else if(choice.equals("n") || choice.equals("N"))
                {
                    valid = true;
                    status = true;
                }
                else{
                    System.out.println("Invalid Choice!");
                    status = false;
                }

            }while(!status);
        
        return valid;
    }
    
    public void editSalary(){
        
       System.out.println("");
       System.out.print("Enter ID of the Employee: ");
       int idin = sc.nextInt();
       sc.nextLine();

         for (int i = 0; i < counter; i++) {
            if (sr[i].id == idin) {
            System.out.print("New Rate: ");
            double rate = sc.nextDouble();
            System.out.print("New Hour: ");
            double hour = sc.nextDouble();
            System.out.print("New Deduction: ");
            double deduction = sc.nextDouble();
            sr[i].editSalary(idin, rate, hour, deduction);
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

            switch (choice) {
                case "y":
                case "Y":
                    CoronadoPrefi.main(null);
                    break;
                case "n":
                case "N":
                    System.out.println("Thankyou for using the App!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
                    status = false;
                    break;
            }

            }while(!status);
    }
 
}
           
