import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class printBill 
{
    String userName;
    double userHours;
    boolean memberShip;
    String vehicleType;
    double tax;
    double total;
    static int count=0;

    public double getTax() 
    {
        return this.tax;
    }

    public void setTax(double tax) 
    {
        this.tax = tax;
    }

    public String getUserName() 
    {
        return this.userName;
    }

    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public double getUserHours() 
    {
        return this.userHours;
    }

    public void setUserHours(double userHours) 
    {
        this.userHours = userHours;
    }

    public boolean getMemberShip() 
    {
        return this.memberShip;
    }

    public void setMemberShip(boolean memberShip) 
    {
        this.memberShip = memberShip;
    }

    public String getVehicleType() 
    {
        return this.vehicleType;
    }

    public void setVehicleType(String vehicleType) 
    {
        this.vehicleType = vehicleType;
    }

    public double getTotal() 
    {
        return this.total;
    }

    public void setTotal(double total) 
    {
        this.total = total;
    }
    
    public void onPrintReceipt() throws IOException 
    {
        File file = new File("printBill.txt");
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
            printWriter.write("");
            count++;
            printWriter.println(count+")");
            printWriter.println("**********************************");
            printWriter.println("---------Welcome To VPCS----------");
            printWriter.println("**********************************");
            printWriter.println("Customer Name\t\t Customer Hours");
            printWriter.println("\t"+getUserName()+ "\t\t\t\t\t" +getUserHours());
            printWriter.println("**********************************");
            printWriter.println("User Membership: "+getMemberShip());
            printWriter.println("Tax: "+getTax());
            printWriter.println("Total Bill: $"+(MainScreenController.format.format(getTotal())));
            printWriter.println("------Thank You For Using VPCS------");
            printWriter.println("----------------------------------------------");
            printWriter.close();
   
        }
}