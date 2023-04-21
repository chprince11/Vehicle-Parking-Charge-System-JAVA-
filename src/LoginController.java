import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginController implements Initializable 
{
    @FXML
    private Button guestLoginBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField pswdField;

    @FXML
    private TextField userNameField;

    @FXML
    void handleLoginBtn(ActionEvent event) throws IOException 
    {
        MainScreenController mainScreen = new MainScreenController();

        try 
        {
            if (userNameField.getText().matches("User") && pswdField.getText().matches("123")) 
            {
                MainScreenController.isGuest = false;
                System.out.println("Successfully logged in!");
                Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                Image image = new Image("icon.png");
                stage.getIcons().add(image);
                stage.setTitle(userNameField.getText() + " Account");
                stage.setScene(scene);
                stage.show();
            } else 
            {
                mainScreen.alertHandling("Login Error", "Please Enter Valid Login Details", false, false);
            }

        } catch (Exception e) 
        {
            System.out.println("There might be some error!! Try again.");
        }

    }

    @FXML
    void handleGuestLoginBtn(ActionEvent event) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Guest Account");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        // Let it be empty
    }
}
