package coronadoprefi;

public class Salaries {
    
    int id;
    String name;
    double rate;
    double hour;
    double deduction;
    double gross;
    double netpay;
    
    public void storage(int Id, String Name, double Rate, double Hour, double Deduction){
        
        this.id = Id;
        this.name = Name;
        this.rate = Rate;
        this.hour = Hour;
        this.deduction = Deduction;
        this.gross = this.rate * this.hour;
        this.netpay = this.gross - this.deduction;
        
    }
    
    public void display(){
        
        System.out.printf(" %-10d %-20s %-10.2f %-10.0f %-10.2f %-10.2f %-10.2f\n",
                this.id, this.name, this.rate, this.hour, this.gross, this.deduction, this.netpay);
        
    }
    
    public void editSalary(int Id, double Rate, double Hour, double Deduction){
        if(this.id == Id){
            this.rate = Rate;
            this.hour = Hour;
            this.deduction = Deduction;
        }
    }
    
    public double rate() {
        return rate * hour; 
    }
     
    public double deduction() {
        return deduction; 
    }
}
