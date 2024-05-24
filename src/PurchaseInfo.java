public class PurchaseInfo
{   
    private String customerName;
    private Double totalHours;
    private Double tax;
    private Double totalAmount;
    static int count = 0;

    MainScreenController mainScreen = new MainScreenController();

    PurchaseInfo(String customerName, Double totalHours, Double tax, Double totalAmount) 
    {
        this.customerName = customerName;
        this.totalHours = totalHours;
        this.tax = tax;
        this.totalAmount = totalAmount;
    }

    public String toStringRep()
    {
        count++;
        return(count+") Entry"+"\nName: " + customerName + "    Total Hours:" + totalHours + "\nTax: " + tax+"%" + "    Total Amount: " + "$"+MainScreenController.format.format(totalAmount));
    }
}