package coronadoact;
import java.util.Scanner;

public class Salary {
    
    public void getSalary() {
    
        Scanner sc = new Scanner(System.in);
        
        Salaries[] gr = new Salaries[10];
        
        System.out.printf("Enter no. of Employee: ");
        int emploNum = sc.nextInt();
        
        for (int i = 1; i <= emploNum; i++){
            
            gr[i] = new Salaries();
            
            System.out.println("Enter details of employee: "+i);
            System.out.printf(" ID: ");
            String id = sc.next();
            System.out.print(" Name: ");
            String name = sc.next();
            System.out.printf(" Rate: ");
            int rate = sc.nextInt();
            System.out.printf(" Hours Worked: ");
            int hours = sc.nextInt();
            System.out.printf(" Deduction: ");
            int deduction = sc.nextInt();
            
            gr[i].salaryStorage(id, name, rate, hours, deduction);
        }
      
        
        
    }
    
}
