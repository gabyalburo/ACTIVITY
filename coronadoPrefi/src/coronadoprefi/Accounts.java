package coronadoprefi;

public class Accounts {
    String id;
    String fname;
    String lname;
    String email;
    String user;
    String pass;
    
    public void storage(String Id, String Fname, String Lname, String Email, String User, String Pass){
        
        this.id = Id;
        this.fname = Fname;
        this.lname = Lname;
        this.email = Email;
        this.user = User;
        this.pass = Pass;
        
    }
    
    public void display(){
        
        System.out.printf(" %-10s %-10s %-10s %-10s %-10s %-10s\n",
                this.id, this.fname, this.lname, this.email, this.user, this.pass);
        
    }
}
