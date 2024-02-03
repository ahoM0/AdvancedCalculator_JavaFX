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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohammed Benali
 */
public class LoginMBController implements Initializable {

    @FXML
    private TextField username_field;
    @FXML
    private TextField password_field;
    @FXML
    private Button button_login;
    @FXML
    private Text registrate;
    @FXML
    private ImageView imageview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image(getClass().getResourceAsStream("/vr_MB/images_icons_app/restauranteFondo.jpg"));
        imageview.setImage(image);

    }

    @FXML
    private void loginOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("orderMB.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("Take Order Window");
            Image image = new Image(getClass().getResourceAsStream("/vr_MB/images_icons_app/icon_MB_32px.png"));
            stage.getIcons().add(image);
            stage.show();

            Stage windowPrincipal = (Stage) this.button_login.getScene().getWindow();
            windowPrincipal.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void field_registrate_Action(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registerMB.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Register Window");
            stage.setResizable(false);
            Image image = new Image(getClass().getResourceAsStream("/vr_MB/images_icons_app/icon_MB_32px.png"));
            stage.getIcons().add(image);
            stage.show();

            Stage windowPrincipal = (Stage) this.button_login.getScene().getWindow();
            windowPrincipal.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
