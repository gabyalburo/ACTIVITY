package testapp;

public class Salaries {
    
    int id;
    String name;
    double rate;
    double hour;
    double deduction;
    
    public void storage(int Id, String Name, double Rate, double Hour, double Deduction){
        
        this.id = Id;
        this.name = Name;
        this.rate = Rate;
        this.hour = Hour;
        this.deduction = Deduction;
        
    }
    
    public void display(){
        
        double gross = this.rate * this.hour;
        double netpay = gross - this.deduction;
        
        System.out.printf(" %-10d %-20s %-10.2f %-10.0f %-10.2f %-10.2f %-10.2f\n",
                this.id, this.name, this.rate, this.hour, gross, this.deduction, netpay);
        
    }
    
    public void editGrades(int Id, double Rate, double Hour, double Deduction){
        if(this.id == Id){
            this.rate = Rate;
            this.hour = Hour;
            this.deduction = Deduction;
        }
    }
    
}
