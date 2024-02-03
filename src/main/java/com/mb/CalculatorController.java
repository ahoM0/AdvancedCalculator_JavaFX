package com.mb;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.ResourceBundle;
import java.util.Stack;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohammed Benali
 */
public class CalculatorController implements Initializable {

    @FXML
    private Pane panel;
    @FXML
    private Button num_7_button;
    @FXML
    private Button symbol_clear_button;
    @FXML
    private Button symbol_Mplus_button;
    @FXML
    private Button ON_OFF_button;
    @FXML
    private Button num_1_button;
    @FXML
    private Button symbol_MR_button;
    @FXML
    private Button num_4_button;
    @FXML
    private Button symbol_MS_button;
    @FXML
    private Button num_3_button;
    @FXML
    private Button symbol_minus_button;
    @FXML
    private Button num_6_button;
    @FXML
    private Button symbol_multiplication_button;
    @FXML
    private Button num_9_button;
    @FXML
    private Button symbol_porcentaje_button;
    @FXML
    private Button symbol_remove_button;
    @FXML
    private Button num_00_button;
    @FXML
    private Button num_2_button;
    @FXML
    private Button num_0_button;
    @FXML
    private Button num_5_button;
    @FXML
    private Button num_8_button;
    @FXML
    private Button symbol_plus_button;
    @FXML
    private Button symbols_division_button;
    @FXML
    private Button symbols_equals_button;
    private Button formula_button;
    @FXML
    private Button symbol_sqr_button;
    @FXML
    private Button symbol_Mminus_button;
    @FXML
    private Button symbol_plusandminus_button;
    @FXML
    private Button symbol_1andX_button;
    @FXML
    private Button symbol_MC_button;
    @FXML
    private Button symbol_decimal_button;
    @FXML
    private Button FACTORIAL_button;
    @FXML
    private Button Primo_button;
    @FXML
    private Button boton_volver;

    private Boolean encendida = false;
    @FXML
    private ImageView imagen_on_off;
    @FXML
    private GridPane gridpane;

    @FXML
    private TextField display;
    // Variable representa el contenido
    private String content = "0";

    // Variable representa la memoria
    private double memory = 0.00;
    // Contenido memoria
    private String contenidoMemoria = " ";

    @FXML
    private TextField memory_field;

    @FXML
    private TextField campo_calculo;

    private Boolean opterminada = false;

    private Boolean divEntreCero = false;
    private Boolean puntoPosible = true;
    @FXML
    private Button elevado_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!encendida) {
            this.gridpane.setDisable(true);
            this.FACTORIAL_button.setDisable(true);
            this.Primo_button.setDisable(true);
            this.display.setText("");
        }

        this.campo_calculo.setText("");

    }

    @FXML
    private void handle_OnAction(ActionEvent event) {
        // Montamos el String aqui no se hacen operaciones.
        String conSinEspacios = content.replaceAll("\\s", "");
        String lastCharacter = conSinEspacios.substring(conSinEspacios.length() - 1, conSinEspacios.length());
        // Booleano es true si los signos de operacion son el ultimo caracter
        boolean esSigno = "-".equals(lastCharacter) || "*".equals(lastCharacter) || "+".equals(lastCharacter) || "/".equals(lastCharacter) || "%".equals(lastCharacter);
        // Booleano es true si el ultimo caracter es un punto
        boolean esPunto = ".".equals(lastCharacter);
        Button bt = (Button) event.getTarget();
        if ("0".equals(content)) {
            content = "";
        }

        if (opterminada) {
            content = "";
            opterminada = false;
        }

        if (this.num_0_button.getId().equals(bt.getId())) {
            this.display.setText(content += "0");
        } else if (this.num_1_button.getId().equals(bt.getId())) {
            this.display.setText(content += "1");
        } else if (this.num_2_button.getId().equals(bt.getId())) {
            this.display.setText(content += "2");
        } else if (this.num_3_button.getId().equals(bt.getId())) {
            this.display.setText(content += "3");
        } else if (this.num_4_button.getId().equals(bt.getId())) {
            this.display.setText(content += "4");
        } else if (this.num_5_button.getId().equals(bt.getId())) {
            this.display.setText(content += "5");
        } else if (this.num_6_button.getId().equals(bt.getId())) {
            this.display.setText(content += "6");
        } else if (this.num_7_button.getId().equals(bt.getId())) {
            this.display.setText(content += "7");
        } else if (this.num_8_button.getId().equals(bt.getId())) {
            this.display.setText(content += "8");
        } else if (this.num_9_button.getId().equals(bt.getId())) {
            this.display.setText(content += "9");
        } else if (this.num_00_button.getId().equals(bt.getId())) {
            this.display.setText(content += "00");
        } else if (this.symbol_clear_button.getId().equals(bt.getId())) {
            this.display.setText(content = "0");
            this.campo_calculo.setText(" ");
        } else if (this.symbol_decimal_button.getId().equals(bt.getId())) {
            // No introducimos un punto si hay un signo de operacion o si hay un punto
            System.out.println("Ultimo carac"+ lastCharacter);
            if (content.contains(".")) {
                if (puntoPosible) {
                    content += ".";
                    puntoPosible = false;
                    this.display.setText(content);
                } else {
                    this.display.setText(content);
                }
            } else if (esSigno) {
                content = content.substring(0, content.length() - 3);
                content += ".";
                puntoPosible = false;
                this.display.setText(content);
            } else if (esPunto) {
                this.display.setText(content);
            } else {
                this.display.setText(content += ".");
                puntoPosible = false;
            }

        } else if (this.symbol_remove_button.getId().equals(bt.getId())) {
            // No borramos si solo queda un caracter.
            System.out.println("longitud = " + content.length());
            if (content.length() == 1) {
                content = "0";
                this.display.setText(content);
            } else if (content.length() > 1) {
                if (esSigno) {
                    content = content.substring(0, content.length() - 3);
                    this.display.setText(content);
                } else {
                    content = content.substring(0, content.length() - 1);
                    this.display.setText(content);
                }
            }
        }

    }

    @FXML
    private void operation_OnAction(ActionEvent event) {

        opterminada = false;
        String conSinEspacios = content.replaceAll("\\s", "");
        String lastCharacter = conSinEspacios.substring(conSinEspacios.length() - 1, conSinEspacios.length());

        // Botones de operaciones menos el igual.
        Button bt = (Button) event.getTarget();

        boolean esSigno = "-".equals(lastCharacter) || "*".equals(lastCharacter) || "+".equals(lastCharacter) || "/".equals(lastCharacter) || "%".equals(lastCharacter);

        // Booleano es true si el ultimo caracter es un punto
        boolean esPunto = ".".equals(lastCharacter);

        if (this.symbol_minus_button.getId().equals(bt.getId())) {
            if (esSigno) {
                content = content.substring(0, content.length() - 3);
            }
            if (!esPunto) {
                content += " - ";
            }
            this.display.setText(content);
        } else if (this.symbol_multiplication_button.getId().equals(bt.getId())) {
            if (esSigno) {
                content = content.substring(0, content.length() - 3);
            }
            if (!esPunto) {
                content += " * ";
            }
            this.display.setText(content);
        } else if (this.symbol_plus_button.getId().equals(bt.getId())) {
            if (esSigno) {
                content = content.substring(0, content.length() - 3);
            }
            if (!esPunto) {
                content += " + ";
            }
            this.display.setText(content);
        } else if (this.symbols_division_button.getId().equals(bt.getId())) {
            if (esSigno) {
                content = content.substring(0, content.length() - 3);
            }
            if (!esPunto) {
                content += " / ";
            }
            this.display.setText(content);
        } else if (this.symbol_porcentaje_button.getId().equals(bt.getId())) {
            if (esSigno) {
                content = content.substring(0, content.length() - 3);
            }
            if (!esPunto) {
                content += " % ";
            }
            this.display.setText(content);
        } else if (this.symbol_plusandminus_button.getId().equals(bt.getId())) {
            // Simbolo +/- 
            content = intercambiarSignos(content);
            this.display.setText(content);
        } else if (this.FACTORIAL_button.getId().equals(bt.getId())) {
            // Calculo Factorial
            if (content.matches("\\d+")) {
                int numero = Integer.parseInt(content);
                long resultado = calcularFactorial(numero);
                this.content = String.valueOf(resultado);
                this.display.setText(content);
            } else {
                this.content = "Error: Calculate factorial only for numbers, no operators.";
                this.display.setText(content);
                this.content = "0";
            }

        } else if (this.Primo_button.getId().equals(bt.getId())) {
            // Calculo Primo
            if (content.matches("\\d+")) {
                int numero = Integer.parseInt(content);
                if (esPrimo(numero)) {
                    this.content = "Is Prime";
                } else {
                    this.content = "Is Not Prime";
                }
                this.display.setText(content);
                this.content = "0";
            } else {
                this.content = "Error: Calculate PR only for numbers, no operators.";
                this.display.setText(content);
                this.content = "0";
            }

        } else if (this.symbol_1andX_button.getId().equals(bt.getId())) {
            // Calcular 1/el numero. 1/(x)
            if (content == "") {
                content = "0";
            }
            content = "1" + " / " + content;
            this.campo_calculo.setText(content);
            this.display.setText(content);
        } else if (this.elevado_button.getId().equals(bt.getId())) {
            // Calcular elevado
            if (esSigno) {
                content = content.substring(0, content.length() - 3);
            }
            if (!esPunto) {
                content += " ^ ";
            }
            this.display.setText(content);
        } else if (this.symbol_sqr_button.getId().equals(bt.getId())) {
            // Calcular sqr()
            if (content == "") {
                content = "0";
            }
            this.campo_calculo.setText("sqrt(" + content + ")");

            if (content.matches("\\d+")) {
                Double numero = Double.valueOf(content);
                Double resultado = Math.sqrt(numero);
                content = String.valueOf(resultado);
            } else {
                String sol = calcularExtra(content);
                if (sol != "Error") {
                    Double numero = Double.valueOf(sol);
                    Double resultado = Math.sqrt(numero);
                    content = String.valueOf(resultado);
                } else {
                    content = "Error";
                }

            }
            this.display.setText(content);
        }
        
        puntoPosible = true;

    }

    // Funcion booleana devuelve true si el numero es Primo
    private static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Funcion para los botones de memoria.
    @FXML
    private void memory_OnAction(ActionEvent event) {
        Button bt = (Button) event.getTarget();

        // Clear Memory / Borrar Memoria
        if (this.symbol_MC_button.getId().equals(bt.getId())) {
            memory = 0;

            // Memory Recovery / Recuperar Memoria
        } else if (this.symbol_MR_button.getId().equals(bt.getId())) {
            this.contenidoMemoria = String.valueOf(memory);
            this.content = this.contenidoMemoria;
            this.display.setText(content);

            // Memory Store
        } else if (this.symbol_MS_button.getId().equals(bt.getId())) {
            if (content.matches("\\d+")) {
                this.memory = Double.valueOf(content);
            }

            // Substract number from memory
        } else if (this.symbol_Mminus_button.getId().equals(bt.getId())) {
            if (content.matches("\\d+")) {
                this.memory -= Double.valueOf(content);
            }
            // Add number to memory
        } else if (this.symbol_Mplus_button.getId().equals(bt.getId())) {
            if (content.matches("\\d+")) {
                this.memory += Double.valueOf(content);
            }
        }
        this.campo_calculo.setText("");
        this.contenidoMemoria = String.valueOf(memory);
        this.memory_field.setText(this.contenidoMemoria);
    }

    // Funcion del igual para calcular la operacion.
    @FXML
    private void calculation_OnAction(ActionEvent event) {
        this.campo_calculo.setText(display.getText());
        this.content = display.getText();
        String result = "";
        try {
            String[] parts = content.split(" ");
            Stack<String> operators = new Stack<>();
            Stack<Double> values = new Stack<>();

            for (String part : parts) {
                if ("+-*/%^".contains(part)) {
                    while (!operators.isEmpty() && orderOperadores(operators.peek(), part)) {
                        String operator = operators.pop();
                        double b = values.pop();
                        double a = values.pop();
                        double res = calcular(a, b, operator);
                        System.out.println("Resultado: " + res);
                        values.push(res);
                    }
                    operators.push(part);
                } else {
                    values.push(Double.valueOf(part));
                }
            }

            while (!operators.isEmpty() && values.size() >= 2) {
                String operator = operators.pop();
                double b = values.pop();
                double a = values.pop();
                double res = calcular(a, b, operator);
                System.out.println("Resultado: " + res);
                values.push(res);
            }

            DecimalFormat df = new DecimalFormat("#.##########");
            result = df.format(values.pop());
        } catch (NumberFormatException | EmptyStackException e) {
            result = "Error";
        }

        if (divEntreCero) {
            this.display.setText("Error: Division by zero is not allowed.");
            System.out.println("Error: Division by zero is not allowed.");
            divEntreCero = false;
            this.content = "0";
            opterminada = true;
        } else {
            this.display.setText(result);
            this.content = String.valueOf(result);
            opterminada = true;
            this.memory += Double.parseDouble(result);
            this.memory_field.setText(String.valueOf(memory));
        }

    }

    // Funcion para saber el orden de los operadores
    private static boolean orderOperadores(String op1, String op2) {
        if ((op1.equals("+") || op1.equals("-")) && (op2.equals("*") || op2.equals("/") || op2.equals("%"))) {
            return false;
        }
        return true;
    }

    // Funcion que calcula dos numeros dependiendo del operador.
    private double calcular(double num1, double num2, String operador) {

        switch (operador) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    divEntreCero = true;
                    return 0.00;
                }
                return num1 / num2;
            case "%":
                return (num1 * num2) / 100;

            case "^":
                return Math.pow(num1, num2);
            case "sqrt":
                if (num1 < 0) {
                    return 0;
                } else {
                    return Math.sqrt(num1);
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operador);
        }
    }

    //Funcion extra para calcular el resultado de la expresion
    private String calcularExtra(String expresion) {
        String result = "";
        try {
            String[] parts = expresion.split(" ");
            Stack<String> operators = new Stack<>();
            Stack<Double> values = new Stack<>();

            for (String part : parts) {
                if ("+-*/%^".contains(part)) {
                    while (!operators.isEmpty() && orderOperadores(operators.peek(), part)) {
                        String operator = operators.pop();
                        double b = values.pop();
                        double a = values.pop();
                        double res = calcular(a, b, operator);
                        System.out.println("Resultado: " + res);
                        values.push(res);
                    }
                    operators.push(part);
                } else {
                    values.push(Double.valueOf(part));
                }
            }

            while (!operators.isEmpty() && values.size() >= 2) {
                String operator = operators.pop();
                double b = values.pop();
                double a = values.pop();
                double res = calcular(a, b, operator);
                System.out.println("Resultado: " + res);
                values.push(res);
            }

            DecimalFormat df = new DecimalFormat("#.##########");
            result = df.format(values.pop());
        } catch (NumberFormatException | EmptyStackException e) {
            result = "Error";
        }

        if (divEntreCero) {
            this.display.setText("Error: Division by zero is not allowed.");
            System.out.println("Error: Division by zero is not allowed.");
            divEntreCero = false;
            this.content = "0";
            opterminada = true;
        } else {
            opterminada = true;
            this.memory += Double.parseDouble(result);
            this.memory_field.setText(String.valueOf(memory));

        }

        return result;
    }

    // Funcion recursiva calcularFactorial
    public static long calcularFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calcularFactorial(n - 1);
        }
    }

    // Funcion que intercambia los signos
    private String intercambiarSignos(String input) {
        if (input.isEmpty()) {
            return input;
        }
        StringBuilder result = new StringBuilder();
        char mas = '+';
        char menos = '-';

        // Comprobamos si el primer numero es positivo le cambiamos el signo
        char primerCaracter = input.charAt(0);
        if (Character.isDigit(primerCaracter)) {
            input = "+" + input;
        }

        for (char c : input.toCharArray()) {
            if (c == '+') {
                result.append(menos);
            } else if (c == '-') {
                result.append(mas);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    // Funcion para apagar y encender la calculadora
    @FXML
    private void start_end_OnAction(ActionEvent event) {
        // Turn on and off the calculator
        if (!encendida) {
            // Encendemos la calculadora
            this.gridpane.setDisable(false);
            this.imagen_on_off.setImage(new Image(getClass().getResourceAsStream("/vr_MB/calculator_icons/on-button.png")));
            this.encendida = true;
            this.FACTORIAL_button.setDisable(false);
            this.Primo_button.setDisable(false);
            this.display.setText("0");

            // Reseteamos parametros
            opterminada = false;
            divEntreCero = false;
            puntoPosible = true;
            this.content = "0";
            this.campo_calculo.setText("");
        } else {
            // Apagamos la calculadora
            this.gridpane.setDisable(true);
            this.imagen_on_off.setImage(new Image(getClass().getResourceAsStream("/vr_MB/calculator_icons/off-button.png")));
            this.encendida = false;
            this.FACTORIAL_button.setDisable(true);
            this.Primo_button.setDisable(true);
            this.display.setText("");
        }
    }

    // Funcion para volver a la anterior ventana
    @FXML
    private void volver_bottonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("orderMB.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Take Order Window");
        Image image = new Image(getClass().getResourceAsStream("/vr_MB/images_icons_app/icon_MB_32px.png"));
        stage.getIcons().add(image);
        stage.show();

        Stage windowPrincipal = (Stage) this.boton_volver.getScene().getWindow();
        windowPrincipal.close();
    }

}
