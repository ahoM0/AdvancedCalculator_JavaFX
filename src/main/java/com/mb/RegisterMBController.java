/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mb;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adm-MB
 */
public class RegisterMBController implements Initializable {

    @FXML
    private TextField username_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private PasswordField password_confirm_field;
    @FXML
    private Button button_register;
    @FXML
    private Text login;
    @FXML
    private ImageView imageview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image imagen = new Image(getClass().getResourceAsStream("/Images/restauranteFondo.jpg"));
        imageview.setImage(imagen);
    }

    @FXML
    private void registerOnAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginMB.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("Login Window");
            stage.show();

            Stage windowPrincipal = (Stage) this.button_register.getScene().getWindow();
            windowPrincipal.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void field_login_Action(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginMB.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Window");
            stage.setResizable(false);
            stage.show();

            Stage windowPrincipal = (Stage) this.button_register.getScene().getWindow();
            windowPrincipal.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
