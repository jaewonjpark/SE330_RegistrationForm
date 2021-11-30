/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

//Using javafx
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;
import javafx.stage.Stage;

public class RegistrationForm extends Application 
{
    private GridPane formPane() 
    {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        
        //gap between
        gridPane.setVgap(20);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        return gridPane;
    }

    private void UIButton(GridPane gridPane) 
    {
        //Header
        Label header = new Label("Registration Form");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        gridPane.add(header, 0,0,2,1);
        GridPane.setHalignment(header, HPos.CENTER);

        //Add Name 
        Label name = new Label("Full Name : ");
        gridPane.add(name, 0,1);
        //Add Name Text Field
        TextField nameField = new TextField();
        gridPane.add(nameField, 1,1);

        //Add Email 
        Label email = new Label("Email Address: ");
        gridPane.add(email, 0, 2);
        //Add Email Text Field
        TextField emailField = new TextField();
        gridPane.add(emailField, 1, 2);

        //Add Password 
        Label password = new Label("Password : ");
        gridPane.add(password, 0, 3);
        //Add Password Field
        //Password is hidden 
        PasswordField passwordField = new PasswordField(); 
        gridPane.add(passwordField, 1, 3);
        
        //Add PhoneNumber
        Label phoneNum = new Label("Phone Number : ");
        gridPane.add(phoneNum, 0, 4);
        //Add Number Field
        TextField phoneNumField = new TextField();
        gridPane.add(phoneNumField, 1, 4);

        //Add Submit Button
        Button submit = new Button("Submit");
        submit.setDefaultButton(true);
        gridPane.add(submit, 0, 5, 2, 1);
        GridPane.setHalignment(submit, HPos.CENTER);

        submit.setOnAction(new EventHandler<ActionEvent>() //https://stackoverflow.com/questions/57074185/how-to-use-setonaction-event-on-javafx
        {
            @Override
            public void handle(ActionEvent event) 
            { //if the text field is empty, then error
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Please enter your name");
                    return;
                }
                if(emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Please enter your email address");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Please enter a password");
                    return;
                }
                if(phoneNumField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Please enter a phone number");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText());
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) 
    {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
//    //Confirming if pw matches pw
//    private boolean validatePassword()
//    {
    
//    }
    
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        primaryStage.setTitle("Registration Form"); //Title
        GridPane gridPane = formPane();
        UIButton(gridPane); //UI control
        Scene scene = new Scene(gridPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
        
