package testapp;

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
            System.out.println("Welcome to Salary App");
            System.out.println("-------------------------------------");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            System.out.println("-------------------------------------");
            System.out.print("Enter Action: ");
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
                    
                case 3:
                    if(counter == 0){
                        System.out.println("No employee yet!!!");
                        status = false;
                    }
                    else {
                        editSalary();
                        status = tryAgain();
                        break;
                    }
                 
                case 4:
                        //delete
                    break;    
                    
                case 5:
                    status = true;
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
                int id = sc.nextInt();
                sc.nextLine();
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
    
    public void editSalary(){
        
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
            sr[i].editGrades(idin, rate, hour, deduction);
            break;
            }
         }
        
    }
    
}
