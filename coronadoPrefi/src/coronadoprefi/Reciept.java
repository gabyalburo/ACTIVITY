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
            System.out.print("Main menu:\n1. Add Product\n2. View Product\nEnter Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    inputSalary();
                    status = tryAgain();
                    break;
                case 2:
                    if(counter == 0){
                        System.out.println("No Products yet!");
                        status = false;
                    }
                    else {
                        System.out.println();
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
        
        for(int i = 0; i < counter; i++){
                    rc[i].display();
            }
        
    }
    
    public boolean tryAgain(){
        
        System.out.print("Enter again? (Y/N):");
        String choice = sc.next();
        
        //System.out.println(choice.equalsIgnoreCase("y"));
        
        return !choice.equalsIgnoreCase("y");
    }
    
}
