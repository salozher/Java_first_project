/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxproba2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Sergiy
 */
public class Fxproba2 extends Application {

    static double totalsum = 0;
    static double sum = 0;
    static double[][] food = {
        {0, 176, 0, 0.14},//1 apple is 176 grams, apple 14%
        {0, 130, 0, 0.15},//1 peer is 130 grams, peer 15%
        {0, 120, 0, 0.23},//1 banana - is 120 grams, banana 23%
        {0, 200, 0, 0.09},//1 glass 200 grams, orange juice 9%
        {0, 155, 0, 0.18},//1 sandwich 155 grams, sandwich 18%
        {1, 0, 0, 0.41},//fried potato 41%
        {1, 0, 0, 0.02},//vegetable salad  2%
        {1, 0, 0, 0.01}//majonaise 1%
    };

    static void compute() {
        int x;
        for (int i = 0; i < food.length; i++) {
            if (food[i][0] == 0) {
                x = 1;
            } else {
                x = 2;
            }
            {
                for (int j = x; j < food[j].length; j++) {
                    //System.out.println(x);
                }
                double j0 = food[i][0];
                double j1 = food[i][1];
                double j2 = food[i][2];
                double j3 = food[i][3];
//                double sum;
                if (x == 1) {
                    sum = ((j1 * j2) * j3);
                } else {
                    sum = (j2 * j3);
                }

                totalsum = totalsum + sum;

                //System.out.println(sum);
            }

        }
//        System.out.println(totalsum + " grams of glucose");
//        System.out.println(totalsum * 3.4 + " kilokalories");
    }

    private Label naklejka(String z, int x, int y) {
        Label temp = new Label();
        temp.setLayoutX(x + 60);
        temp.setLayoutY(y);
        temp.setText(z);
        return temp;
    }

    private TextField textfield(String z, int x, int y) {
        TextField temp1 = new TextField();
        temp1.setLayoutX(x);
        temp1.setLayoutY(y);
        temp1.setText(z);
        temp1.setPrefSize(60, 30);
        return temp1;
    }

    private Button knopka(String z, int x, int y) {
        Button temp = new Button();
        temp.setLayoutX(x);
        temp.setLayoutY(y);
        temp.setText(z);
        temp.setPrefSize(200,30);
        return temp;
    }

    @Override
    public void start(Stage primaryStage) {

        TextArea textArea = new TextArea();
        textArea.setLayoutX(300);
        textArea.setLayoutY(30);
        textArea.setPrefSize(200, 100);

        TextField textField1 = textfield("0", 0, 0);
        TextField textField2 = textfield("0", 0, 30);
        TextField textField3 = textfield("0", 0, 60);
        TextField textField4 = textfield("0", 0, 90);
        TextField textField5 = textfield("0", 0, 120);
        TextField textField6 = textfield("0", 0, 150);
        TextField textField7 = textfield("0", 0, 180);
        TextField textField8 = textfield("0", 0, 210);

        Label label1 = naklejka("Apple(s)", 0, 5);
        Label label2 = naklejka("Peer(s)", 0, 35);
        Label label3 = naklejka("Banana(s)", 0, 65);
        Label label4 = naklejka("Glass(es) Orange Juice", 0, 95);
        Label label5 = naklejka("Piece(s) of sandwich", 0, 125);
        Label label6 = naklejka("grams of Fried Potato", 0, 155);
        Label label7 = naklejka("grams of Vegetable Salad", 0, 185);
        Label label8 = naklejka("grams of Majonaise", 0, 215);

        Button exit = knopka("Exit", 300, 210);
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        Button btn = knopka("Calculate", 300, 0);
        btn.setOnAction((ActionEvent event) -> {
            food[0][2] = Double.valueOf(textField1.getText());
            food[1][2] = Double.valueOf(textField2.getText());
            food[2][2] = Double.valueOf(textField3.getText());
            food[3][2] = Double.valueOf(textField4.getText());
            food[4][2] = Double.valueOf(textField5.getText());
            food[5][2] = Double.valueOf(textField6.getText());
            food[6][2] = Double.valueOf(textField7.getText());
            food[7][2] = Double.valueOf(textField8.getText());

            compute();
            String message = "Your meal is consist of:" + "\n" + "\n"
                    + totalsum + " grams of glucose" + "\n"
                    + totalsum * 3.4 + " kilokalories";
            textArea.setText(message);
            sum = 0;
            totalsum = 0;
//                  System.out.println("message");
        }
        );

        Pane novajaPodkladka = new Pane();
//        StackPane novajaPodkladka = new StackPane();
//        Pane novajaPodkladka = new VBox(5);
//        novajaPodkladka.getChildren().add(btn);
//        novajaPodkladka.getChildren().add(textField);
        novajaPodkladka.getChildren().addAll(
                btn,
                textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8,
                textArea,
                label1, label2, label3, label4, label5, label6, label7, label8,
                exit
        );
//         novajaPodkladka.getChildren().addAll(a,b,c)

        Scene scene = new Scene(novajaPodkladka, 500, 250);

        primaryStage.setTitle("Sergiy's Glucose / kkal Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
