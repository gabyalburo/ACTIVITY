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
        
        double tolProfit = this.sold * this.price;
        double exProfit = this.stock * this.price;
        
        System.out.println("Product ID: "+this.id);
        System.out.println("------------------------------------------");
        System.out.println("Product Name: "+this.name);
        System.out.println("Stock: "+this.stock);
        System.out.println("Price: "+this.price);
        System.out.println("Sold: "+this.sold);
        System.out.println("------------------------------------------");
        System.out.println("Total Profit: "+tolProfit);
        if(this.stock > this.sold){
            System.out.println("Status: Available");
        }
        else{
            System.out.println("Status: Unavailable");
        }
        System.out.println("Total Expected Profit: "+exProfit);
    }
    
}
