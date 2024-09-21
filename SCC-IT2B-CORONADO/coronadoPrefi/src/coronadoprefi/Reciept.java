package coronadoprefi;

import java.util.Scanner;

public class Reciept {
    
    Scanner sc = new Scanner(System.in);
    
    Reciepts[] rc = new Reciepts [100];
    
    int productNum;
    int counter = 0;
    
    public void menu(){
        
        boolean status = false;
        
        do{
            System.out.println();
            System.out.println("Welcome to Reciept App");
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
                case 1:
                    inputProduct();
                    status = tryAgain();
                    break;
                case 2:
                    if(counter == 0){
                        System.out.println("No Products yet!");
                        status = tryAgain();
                        break;
                    }
                    else {
                        System.out.println();
                        view();
                        System.out.println();
                        status = tryAgain();
                    }
                    break;
                case 3:
                    if(counter == 0){
                        System.out.println("No Employees yet!");
                        status = tryAgain();
                        break;
                    }
                    else {
                        editSalary();
                        status = tryAgain();
                    }  
                    break;
                case 4:
                    status = true;
                    break;
                default:
                    System.out.println("Invalid Choice! Try again.");
                    status = false;
            }
        }while(!status);
        
        exitSelection();
        
    }
    
    public void inputProduct(){
        
        System.out.println("-------------------------------------------------");
        System.out.print("\n(1)Enter no. of Products: ");
        productNum = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < productNum; i++){
                
                System.out.print("\n ID: ");
                String id = sc.nextLine();
                System.out.print(" Product Name: ");
                String name = sc.nextLine();
                System.out.print(" Stock: ");
                double stock = sc.nextDouble();
                System.out.print(" Price: ");
                double price = sc.nextDouble();
                System.out.print(" Sold: ");
                double sold = sc.nextDouble();
                sc.nextLine();
                System.out.println("\n-------------------------------------------------\n");

                rc[counter] = new Reciepts();
                rc[counter].storage(id, name, stock, price, sold);
                counter++;
                
         }
        
    }
    
    public void view(){
        
        double tolProfit = 0;
        double tolExpProfit = 0;
        
        System.out.printf(" %-10s %-20s %-10s %-10s %-10s %-10s\n",
                           "ID", "Name", "Stock", "Price", "Sold", "Status");
        
            for(int i = 0; i < counter; i++){
                rc[i].display();
            }
        
            for (int i = 0; i < counter; i++) {
                tolProfit += rc[i].tolProfit();
                tolExpProfit += rc[i].tolExpProfit(); 
            }
        
            System.out.println(" -------------------------------------------------------------------------------------");
            System.out.println(" Total Profit: "+tolProfit);
            System.out.println(" Total Expected profit: "+tolExpProfit);
            System.out.println(" No. of Product: "+counter);
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
    
    public void editSalary(){
        
       System.out.println("");
       System.out.print("Enter ID of the Product: ");
       String idin = sc.next();
       sc.nextLine();

         for (int i = 0; i < counter; i++) {
            if (rc[i].id.equals(idin)) {
            System.out.print("New Stock: ");
            double stock = sc.nextDouble();
            System.out.print("New Price: ");
            double price = sc.nextDouble();
            System.out.print("New Sold: ");
            double sold = sc.nextDouble();
            rc[i].editSalary(idin, stock, price, sold);
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
