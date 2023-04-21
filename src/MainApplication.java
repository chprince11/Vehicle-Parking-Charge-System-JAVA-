import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApplication extends Application 
{
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Image image = new Image("icon.png");

        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Vehicle Parking Charge System");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            handleExitButtonAction(primaryStage);
        });
    }

    @FXML
    void handleExitButtonAction(Stage primaryStage) 
    {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Exit");
        alert.setHeaderText("Want to exit the Car parking system!!");

        if (alert.showAndWait().get() == ButtonType.OK) 
        {
            primaryStage.close();
        }
    }

    public static void main(String[] args) 
    {
        Application.launch(args);

    }
}