package coronadoact;

public class Salaries {
    
    String id;
    String name;
    int rate;
    int hours;
    int deduction;
    
    public void salaryStorage(String id, String name, int rate, int hours, int deduction){
        
        this.id = id;
        this. name = name;
        this.rate = rate;
        this.hours = hours;
        this.deduction = deduction;
        
    }
    
    public void viewSalary(){
        
        System.out.printf(" %-10s %-10s %-10d %-3d %-6d",
                 this.id, this.name, this.rate, this.hours, this.deduction);
        
    }
}
