import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScreenController implements Initializable
{
    Stage primaryStage;

    // Here used boolean isGuest, so that when user logged in user as a guest so that to hide the membership function there
    @FXML
    public static boolean isGuest = true;

    @FXML
    private ListView<String> recentList;

    @FXML
    private CheckBox cbmemShip;

    @FXML
    private Label customerNamelbl;

    @FXML
    private Label hoursDisplaylbl;

    @FXML
    private Label nameDisplaylbl;

    @FXML
    private Button resetButton;

    @FXML
    private Button submit;

    @FXML
    private Label taxDisplaylbl;

    @FXML
    private Label taxlbl;

    @FXML
    private Label tcDisplaylbl;

    @FXML
    private RadioButton idCar;

    @FXML
    private RadioButton idBike;

    @FXML
    private RadioButton idBicycle;

    @FXML
    private TextField tfUserHours;

    @FXML
    private TextField tfUserName;

    @FXML
    private Label totalChargelbl;

    @FXML
    private Label totalHourslbl;

    @FXML
    private VBox vboxRadiobtn;

    @FXML
    private Label vehicleType;

    @FXML
    private AnchorPane myAnchorPane;

    public static final DecimalFormat format = new DecimalFormat("0.00");
    public double price = 0.0;
    public double taxPrice = 0.13;
    int count = 0;

    @FXML
    private void handleReset(ActionEvent event) 
    {
        tfUserName.setText("");
        tfUserHours.setText("");
        hoursDisplaylbl.setText("");
        nameDisplaylbl.setText("");
        taxDisplaylbl.setText("");
        tcDisplaylbl.setText("");
        cbmemShip.setSelected(false);
        idBike.setSelected(false);
        idBicycle.setSelected(false);
        idCar.setSelected(false);
    }

    @FXML
    private void handleSubmit(ActionEvent event) throws Exception 
    {
        if(tfUserName.getText().isEmpty()|| tfUserName.getText().matches("\\d+\\.\\d+") || tfUserName.getText().matches("\\d+")){
            alertHandling("Invalid Input!!", "Please enter your name in the given field.", false, false);
        }
        else if(tfUserHours.getText().isEmpty() || tfUserHours.getText().matches("\\D*")){
            alertHandling("Invalid Input!!", "Please enter your hours in the given field.", false, false);
        }
        else if(!idBicycle.isSelected() && !idBike.isSelected() && !idCar.isSelected()){
            alertHandling("Invalid Input!!", "Please select vehicle type.", false, false);
        }
        else
        {
            double total;
            if(cbmemShip.isSelected())
            {
                total = ((memshipSelectedPrice())*(Double.parseDouble(tfUserHours.getText()))*taxPrice);
                nameDisplaylbl.setText(tfUserName.getText());
                hoursDisplaylbl.setText(tfUserHours.getText());
                taxDisplaylbl.setText("0.13%");
                tcDisplaylbl.setText("$"+format.format(total));
                
                printBill print = new printBill();
                print.setTax(0.13);
                print.setMemberShip(true);
                print.setTotal(total);
                print.setUserName(tfUserName.getText());
                print.setUserHours(Double.parseDouble(tfUserHours.getText()));
                print.onPrintReceipt();
            }
            else
            {
                total = ((vehicleSelectedPrice())*(Double.parseDouble(tfUserHours.getText()))*taxPrice);
                nameDisplaylbl.setText(tfUserName.getText());
                hoursDisplaylbl.setText(tfUserHours.getText());
                taxDisplaylbl.setText("0.13%");
                tcDisplaylbl.setText("$"+format.format(total));

                printBill print = new printBill();
                print.setTax(0.13);
                print.setMemberShip(false);
                print.setTotal(total);
                print.setUserName(tfUserName.getText());
                print.setUserHours(Double.parseDouble(tfUserHours.getText()));
                print.onPrintReceipt();
            }

            // Implementing the ArrayList
            // Created the object of the class purchaseInfo
            PurchaseInfo individualPurchase = new PurchaseInfo(tfUserName.getText(),
            Double.parseDouble(tfUserHours.getText()), taxPrice, total);
            //Passed that java class object into Array List
            ArrayList<PurchaseInfo> resentList = new ArrayList<>();
            ArrayList<String> stringRepresentation = new ArrayList<>();
            //adding all values of the user entered
            resentList.add(individualPurchase);
            stringRepresentation.add(individualPurchase.toStringRep());
            recentList.getItems().addAll(stringRepresentation);
        }
    }

    @FXML
    private void handleExitButton(ActionEvent event) 
    {
        alertHandling("EXIT","Thank you for parking your vehicle.",true,true);
    }

    public void alertHandling(String title, String message, boolean close, boolean Confirmation)
    {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        if(Confirmation) {
            alert = new Alert(Alert.AlertType.WARNING);
        }
        alert.setTitle(title);
        alert.setHeaderText(message);

        if(alert.showAndWait().get()==ButtonType.OK) 
        {
            primaryStage = (Stage) myAnchorPane.getScene().getWindow();
            if(close)
            {
                primaryStage.close();
            }
        }
    }

    private double vehicleSelectedPrice()
    {
        if(idCar.isSelected())
        {
            price=20.0;
        }
        else if(idBike.isSelected())
        {
            price=17.0;
        }
        else if(idBicycle.isSelected())
        {
            price=14.0;
        }
        return price;
    }

    private double memshipSelectedPrice()
    {
        if(cbmemShip.isSelected())
        {
            if(idCar.isSelected())
            {
                price=15.0;
            }
            else if(idBike.isSelected())
            {
                price=12.0;
            }
            else if(idBicycle.isSelected())
            {
                price=10.0;
            }
        }
        return price;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        System.out.println(isGuest);
        if (isGuest) 
        {
            //for the membership option it is set as false, so that it hidden when user logged in as guest
            cbmemShip.setVisible(false);
        }
    }
}