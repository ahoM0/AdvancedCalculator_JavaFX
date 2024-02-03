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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohammed Benali
 */
public class OrderMBController implements Initializable {

    @FXML
    private Pane panel;
    @FXML
    private TextField name_field;
    @FXML
    private TextField email_field;
    @FXML
    private TextField table_number_field;
    @FXML
    private Button button_checkEmail;
    @FXML
    private TextArea comments_field;
    @FXML
    private ToggleGroup taken;
    @FXML
    private ToggleGroup paymenth;
    @FXML
    private ToggleGroup tipping;
    @FXML
    private TextField grandTotal_field;
    @FXML
    private Button save_button;
    @FXML
    private Button discard_button;
    @FXML
    private Button calculator_button;
    @FXML
    private MenuItem item_iew_full_order;
    @FXML
    private MenuItem item_calculator;
    @FXML
    private MenuItem item_exit;
    @FXML
    private MenuItem item_information;
    @FXML
    private MenuItem item_about;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void save_OnAction(ActionEvent event) {
    }

    @FXML
    private void discard_OnAction(ActionEvent event) {
    }

    @FXML
    private void calculator_OnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Calculator.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Calculator Window");
        Image image = new Image(getClass().getResourceAsStream("/vr_MB/images_icons_app/icon_MB_32px.png"));
        stage.getIcons().add(image);
        stage.show();

        Stage windowPrincipal = (Stage) this.button_checkEmail.getScene().getWindow();
        windowPrincipal.close();
    }

    @FXML
    private void menu_ITEMS_OnAction(ActionEvent event) throws IOException {
        MenuItem bt = (MenuItem) event.getTarget();
        if (this.item_calculator.getId().equals(bt.getId())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Calculator.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("Calculator Window");
            Image image = new Image(getClass().getResourceAsStream("/vr_MB/images_icons_app/icon_MB_32px.png"));
            stage.getIcons().add(image);
            stage.show();

            Stage windowPrincipal = (Stage) this.button_checkEmail.getScene().getWindow();
            windowPrincipal.close();
        }
    }

}
