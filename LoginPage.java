package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Devil Dialect");

        // Title Text
        Text title = new Text("Devil Dialect");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        title.setFill(Color.RED);

        // Subtitle Text
        Text subtitle = new Text("DEVIL DIALECT");
        subtitle.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        subtitle.setFill(Color.LIGHTGRAY);

        // Username Input
        TextField asuIdInput = new TextField();
        asuIdInput.setPromptText("ASU ID");
        asuIdInput.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: black;");

        // Password Input
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Password");
        passwordInput.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: black;");

        // Login Button
        Button loginButton = new Button("Log in");
        loginButton.setPrefWidth(200);
        loginButton.setStyle("-fx-background-color: #C0C0C0; -fx-text-fill: black;");
        loginButton.setOnAction(e -> handleLogin(asuIdInput.getText(), passwordInput.getText()));

        // Layout setup
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #1E0033;");  // Dark background

        layout.getChildren().addAll(subtitle, title, asuIdInput, passwordInput, loginButton);

        // Scene setup
        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleLogin(String asuId, String password) {
        // Simulate a simple login check
        if (asuId.equals("testID") && password.equals("testPassword")) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + asuId + "!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid ASU ID or Password.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
