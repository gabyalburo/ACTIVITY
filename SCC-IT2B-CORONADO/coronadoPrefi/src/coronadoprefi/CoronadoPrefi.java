package coronadoprefi;
//Main

import java.util.Scanner;

public class CoronadoPrefi {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Salary salary = new Salary();
        Reciept reciept = new Reciept();
        Account account = new Account();
        
        boolean status = false;
        
        do{
            
            System.out.println("----------------------------");
            System.out.println("    Choose App to Use:");
            System.out.println("----------------------------");
            System.out.println("1. SALARY");
            System.out.println("2. RECIEPT");
            System.out.println("3. ACCOUNT");
            System.out.println("4. EXIT");
            System.out.println("----------------------------");
            System.out.print(" Enter Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1 -> salary.menu();

                case 2 -> reciept.menu();

                case 3 -> account.menu();  
                    
                case 4 -> status = true;
                default -> {
                    System.out.println(" Invalid choice. Try again.");
                    System.out.println();
                    status = false;
                }
            } 
            
        }while(!status);
        System.out.println(" Thankyou for using!!!");
        sc.close();
    }
    
}
