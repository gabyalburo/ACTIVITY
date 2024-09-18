package coronadoprefi;

import java.util.Scanner;

public class Salary {
    
    Scanner sc = new Scanner(System.in);
    
    Salaries[] sr = new Salaries [100];
    
    int employeeNum;
    int counter = 0;
    
    public void menu(){
        
        boolean status = false;
        
        do{
            System.out.println();
            System.out.print("Main menu:\n1. Add Employee\n2. View Payroll\nEnter Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    inputSalary();
                    status = tryAgain();
                    break;
                case 2:
                    if(counter == 0){
                        System.out.println("No Employees yet!");
                        status = false;
                    }
                    else {
                        System.out.println();
                        System.out.println(" -------------------------------------------------------------------------------------");
                        System.out.printf(" %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                           "ID", "Name", "Rate", "Hours", "Gross", "Deduction", "NetPay");
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
        System.out.print("\n(1)Enter no. of Employee: ");
        employeeNum = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < employeeNum; i++){
                
                System.out.print("\n ID: ");
                String id = sc.nextLine();
                System.out.print(" Name: ");
                String name = sc.nextLine();
                System.out.print(" Rate: ");
                double rate = sc.nextDouble();
                System.out.print(" Hours Worked: ");
                double hour = sc.nextDouble();
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
        
        for(int i = 0; i < counter; i++){
                    sr[i].display();
            }
        
    }
    
    public boolean tryAgain(){
        
        System.out.print("Enter again? (Y/N):");
        String choice = sc.next();
        
        //System.out.println(choice.equalsIgnoreCase("y"));
        
        return !choice.equalsIgnoreCase("y");
    }
}
           
