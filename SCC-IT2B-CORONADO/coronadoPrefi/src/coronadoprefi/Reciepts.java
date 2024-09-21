package coronadoprefi;

public class Reciepts {
    
    String id;
    String name;
    double stock;
    double price;
    double sold;
    
    public void storage(String Id, String Name, double Stock, double Price, double Sold){
        
        this.id = Id;
        this.name = Name;
        this.stock = Stock;
        this.price = Price;
        this.sold = Sold;
        
    }
    
    public void display(){
        
        if(sold >= stock){
            System.out.printf(" %-10s %-20s %-10.0f %-10.2f %-10.2f %-10s\n",
                this.id, this.name, this.stock, this.price, this.sold, "Sold Out");
        }
        else
        {
            System.out.printf(" %-10s %-20s %-10.0f %-10.2f %-10.2f %-10s\n",
                this.id, this.name, this.stock, this.price, this.sold, "Available");
        }
            
        
        
    }
    
    public void editSalary(String Id, double Stock, double Price, double Sold){
        if(this.id.equals(Id))
        {
            this.stock = Stock;
            this.price = Price;
            this.sold = Sold;
        }
    }
    
    public double tolProfit() {
        return (price * sold); 
    }
     
    public double tolExpProfit() {
        return price * stock; 
    }
    
}
