/* 
 * Image credit all thanks too https://www.flaticon.com/
 */


import java.io.FileInputStream;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App  extends Application{
        private final class EventHandlerImplementation3 implements EventHandler<ActionEvent> {
        private final Label menu1;
        private final TableView<Menu> table;
        private final Label total;
        private final Label price1;
        private final TextField qty1;

        private EventHandlerImplementation3(Label menu1, TableView<Menu> table, Label total, Label price1,
                TextField qty1) {
            this.menu1 = menu1;
            this.table = table;
            this.total = total;
            this.price1 = price1;
            this.qty1 = qty1;
        }

        @Override
        public void handle(ActionEvent e) {
            int sum = (Integer.parseInt(price1.getText()) * Integer.parseInt(qty1.getText()));
            table.getItems().add(new Menu(Integer.parseInt(qty1.getText()), menu1.getText(), sum));

            if (total.getText().equals("")) {
                total.setText("0");
            }
            int totalPrice = Integer.parseInt(total.getText()) + sum;
            total.setText(Integer.toString(totalPrice));
        }
    }

        private final class EventHandlerImplementation2 implements EventHandler<ActionEvent> {
        private final TextField qty1;

        private EventHandlerImplementation2(TextField qty1) {
            this.qty1 = qty1;
        }

        @Override
        public void handle(ActionEvent e) {
            String t = qty1.getText();
            int clicks = Integer.parseInt(t);
            clicks--;
            qty1.setText(Integer.toString(clicks));
     
            if (Integer.parseInt(qty1.getText()) <= 0) {
              qty1.setText("0");
            }

        }
    }

        private final class EventHandlerImplementation implements EventHandler<ActionEvent> {
        private final TextField qty1;

        private EventHandlerImplementation(TextField qty1) {
            this.qty1 = qty1;
        }

        @Override
        public void handle(ActionEvent e) {
            if (qty1.getText().equals("")) {
                qty1.setText("0");
            }
            String t = qty1.getText();
            int clicks = Integer.parseInt(t);
            clicks++;
            qty1.setText(Integer.toString(clicks));
        }
    }

        public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bPane = new BorderPane();
        Scene scene = new Scene(bPane, 729, 600);
        stage.setTitle("Ordering System");
        stage.setScene(scene);
        stage.show();

        //center includes all menu ------------------------------------------------------------------------//
        GridPane center = new GridPane();
        //center.setGridLinesVisible(true);
        center.setBackground(Background.fill(Color.WHITESMOKE));
        center.setPadding(new Insets(10));
        center.setVgap(20);
        center.setHgap(20);

        ScrollPane sPane = new ScrollPane();
        sPane.setContent(center);

        bPane.setCenter(sPane);
        
        //MENU 1
        Image menuImg1 = new Image(new FileInputStream("D:/JFX Alt/SsOR/image/bakery.png"));
        ImageView iView1 = new ImageView(menuImg1);
        Label menu1 = new Label("Pie");
        menu1.setFont(Font.font("calibri", 15));
        Label price1 = new Label("25000");
        price1.setFont(Font.font("calibri", 15));
        TextField qty1 = new TextField("");
        qty1.setMaxWidth(50);
        Button min1 = new Button("-");
        min1.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        Button plus1 = new Button("+");
        plus1.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        HBox spinnerHBox1 = new HBox();
        spinnerHBox1.getChildren().addAll(qty1, min1, plus1);
        spinnerHBox1.setAlignment(Pos.CENTER);
        spinnerHBox1.setSpacing(5);
        Button addOrder1 = new Button("Add Order");
        addOrder1.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        VBox menuItem1 = new VBox();
        menuItem1.setSpacing(10);
        menuItem1.setAlignment(Pos.CENTER);
        menuItem1.getChildren().addAll(iView1, menu1, price1, spinnerHBox1, addOrder1);
        GridPane.setConstraints(menuItem1, 0, 0);

        //MENU 2
        Image menuImg2 = new Image(new FileInputStream("D:/JFX Alt/SsOR/image/fish.png"));
        ImageView iView2 = new ImageView(menuImg2);
        Label menu2 = new Label("Fried Fish");
        menu2.setFont(Font.font("calibri", 15));
        Label price2 = new Label("15000");
        price2.setFont(Font.font("calibri", 15));
        TextField qty2 = new TextField("");
        qty2.setMaxWidth(50);
        Button min2 = new Button("-");
        min2.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        Button plus2 = new Button("+");
        plus2.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        HBox spinnerHBox2 = new HBox();
        spinnerHBox2.getChildren().addAll(qty2, min2, plus2);
        spinnerHBox2.setAlignment(Pos.CENTER);
        spinnerHBox2.setSpacing(5);
        Button addOrder2 = new Button("Add Order");
        addOrder2.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        VBox menuItem2 = new VBox();
        menuItem2.setSpacing(10);
        menuItem2.setAlignment(Pos.CENTER);
        menuItem2.getChildren().addAll(iView2, menu2, price2, spinnerHBox2, addOrder2);
        GridPane.setConstraints(menuItem2, 1, 0);

        //MENU 3
        Image menuImg3 = new Image(new FileInputStream("D:/JFX Alt/SsOR/image/hot.png"));
        ImageView iView3 = new ImageView(menuImg3);
        Label menu3 = new Label("Breakfast Bowl");
        menu3.setFont(Font.font("calibri", 15));
        Label price3 = new Label("25000");
        price3.setFont(Font.font("calibri", 15));
        TextField qty3 = new TextField("");
        qty3.setMaxWidth(50);
        Button min3 = new Button("-");
        min3.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        Button plus3 = new Button("+");
        plus3.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        HBox spinnerHBox3 = new HBox();
        spinnerHBox3.getChildren().addAll(qty3, min3, plus3);
        spinnerHBox3.setAlignment(Pos.CENTER);
        spinnerHBox3.setSpacing(5);
        Button addOrder3 = new Button("Add Order");
        addOrder3.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        VBox menuItem3 = new VBox();
        menuItem3.setSpacing(10);
        menuItem3.setAlignment(Pos.CENTER);
        menuItem3.getChildren().addAll(iView3, menu3, price3, spinnerHBox3, addOrder3);
        GridPane.setConstraints(menuItem3, 2, 0);

        //MENU 4
        Image menuImg4 = new Image(new FileInputStream("D:/JFX Alt/SsOR/image/pancake.png"));
        ImageView iView4 = new ImageView(menuImg4);
        Label menu4 = new Label("Pancake");
        menu4.setFont(Font.font("calibri", 15));
        Label price4 = new Label("20000");
        price4.setFont(Font.font("calibri", 15));
        TextField qty4 = new TextField("");
        qty4.setMaxWidth(50);
        Button min4 = new Button("-");
        min4.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        Button plus4 = new Button("+");
        plus4.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        HBox spinnerHBox4 = new HBox();
        spinnerHBox4.getChildren().addAll(qty4, min4, plus4);
        spinnerHBox4.setAlignment(Pos.CENTER);
        spinnerHBox4.setSpacing(5);
        Button addOrder4 = new Button("Add Order");
        addOrder4.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        VBox menuItem4 = new VBox();
        menuItem4.setSpacing(10);
        menuItem4.setAlignment(Pos.CENTER);
        menuItem4.getChildren().addAll(iView4, menu4, price4, spinnerHBox4, addOrder4);
        GridPane.setConstraints(menuItem4, 0, 1);

        //MENU 5
        Image menuImg5 = new Image(new FileInputStream("D:/JFX Alt/SsOR/image/salad.png"));
        ImageView iView5 = new ImageView(menuImg5);
        Label menu5 = new Label("Salad");
        menu5.setFont(Font.font("calibri", 15));
        Label price5 = new Label("10000");
        price5.setFont(Font.font("calibri", 15));
        TextField qty5 = new TextField("");
        qty5.setMaxWidth(50);
        Button min5 = new Button("-");
        min5.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        Button plus5 = new Button("+");
        plus5.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        HBox spinnerHBox5 = new HBox();
        spinnerHBox5.getChildren().addAll(qty5, min5, plus5);
        spinnerHBox5.setAlignment(Pos.CENTER);
        spinnerHBox5.setSpacing(5);
        Button addOrder5 = new Button("Add Order");
        addOrder5.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        VBox menuItem5 = new VBox();
        menuItem5.setSpacing(10);
        menuItem5.setAlignment(Pos.CENTER);
        menuItem5.getChildren().addAll(iView5, menu5, price5, spinnerHBox5, addOrder5);
        GridPane.setConstraints(menuItem5, 1, 1);

        //MENU 6
        Image menuImg6 = new Image(new FileInputStream("D:/JFX Alt/SsOR/image/pizza.png"));
        ImageView iView6 = new ImageView(menuImg6);
        Label menu6 = new Label("Pizza");
        menu6.setFont(Font.font("calibri", 15));
        Label price6 = new Label("25000");
        price6.setFont(Font.font("calibri", 15));
        TextField qty6 = new TextField("");
        qty6.setMaxWidth(50);
        Button min6 = new Button("-");
        min6.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        Button plus6 = new Button("+");
        plus6.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        HBox spinnerHBox6 = new HBox();
        spinnerHBox6.getChildren().addAll(qty6, min6, plus6);
        spinnerHBox6.setAlignment(Pos.CENTER);
        spinnerHBox6.setSpacing(5);
        Button addOrder6 = new Button("Add Order");
        addOrder6.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        VBox menuItem6 = new VBox();
        menuItem6.setSpacing(10);
        menuItem6.setAlignment(Pos.CENTER);
        menuItem6.getChildren().addAll(iView6, menu6, price6, spinnerHBox6, addOrder6);
        GridPane.setConstraints(menuItem6, 2, 1);

        //MENU 7
        Image menuImg7 = new Image(new FileInputStream("D:/JFX Alt/SsOR/image/boba.png"));
        ImageView iView7 = new ImageView(menuImg7);
        Label menu7 = new Label("Boba");
        menu7.setFont(Font.font("calibri", 15));
        Label price7 = new Label("15000");
        price7.setFont(Font.font("calibri", 15));
        TextField qty7 = new TextField("");
        qty7.setMaxWidth(50);
        Button min7 = new Button("-");
        min7.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        Button plus7 = new Button("+");
        plus7.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        HBox spinnerHBox7 = new HBox();
        spinnerHBox7.getChildren().addAll(qty7, min7, plus7);
        spinnerHBox7.setAlignment(Pos.CENTER);
        spinnerHBox7.setSpacing(5);
        Button addOrder7 = new Button("Add Order");
        addOrder7.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        VBox menuItem7 = new VBox();
        menuItem7.setSpacing(10);
        menuItem7.setAlignment(Pos.CENTER);
        menuItem7.getChildren().addAll(iView7, menu7, price7, spinnerHBox7, addOrder7);
        GridPane.setConstraints(menuItem7, 0, 2);

        //MENU 8
        Image menuImg8 = new Image(new FileInputStream("D:/JFX Alt/SsOR/image/buns.png"));
        ImageView iView8 = new ImageView(menuImg8);
        Label menu8 = new Label("Buns");
        menu8.setFont(Font.font("calibri", 15));
        Label price8 = new Label("10000");
        price8.setFont(Font.font("calibri", 15));
        TextField qty8 = new TextField("");
        qty8.setMaxWidth(50);
        Button min8 = new Button("-");
        min8.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        Button plus8 = new Button("+");
        plus8.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        HBox spinnerHBox8 = new HBox();
        spinnerHBox8.getChildren().addAll(qty8, min8, plus8);
        spinnerHBox8.setAlignment(Pos.CENTER);
        spinnerHBox8.setSpacing(5);
        Button addOrder8 = new Button("Add Order");
        addOrder8.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        VBox menuItem8 = new VBox();
        menuItem8.setSpacing(10);
        menuItem8.setAlignment(Pos.CENTER);
        menuItem8.getChildren().addAll(iView8, menu8, price8, spinnerHBox8, addOrder8);
        GridPane.setConstraints(menuItem8, 1, 2);

        //MENU 9
        Image menuImg9 = new Image(new FileInputStream("D:/JFX Alt/SsOR/image/cold-drink.png"));
        ImageView iView9 = new ImageView(menuImg9);
        Label menu9 = new Label("Cola");
        menu9.setFont(Font.font("calibri", 15));
        Label price9 = new Label("5000");
        price9.setFont(Font.font("calibri", 15));
        TextField qty9 = new TextField("");
        qty9.setMaxWidth(50);
        Button min9 = new Button("-");
        min9.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        Button plus9 = new Button("+");
        plus9.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        HBox spinnerHBox9 = new HBox();
        spinnerHBox9.getChildren().addAll(qty9, min9, plus9);
        spinnerHBox9.setAlignment(Pos.CENTER);
        spinnerHBox9.setSpacing(5);
        Button addOrder9 = new Button("Add Order");
        addOrder9.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        VBox menuItem9 = new VBox();
        menuItem9.setSpacing(10);
        menuItem9.setAlignment(Pos.CENTER);
        menuItem9.getChildren().addAll(iView9, menu9, price9, spinnerHBox9, addOrder9);
        GridPane.setConstraints(menuItem9, 2, 2);

        //MENU 10
        Image menuImg10 = new Image(new FileInputStream("D:/JFX Alt/SsOR/image/nasi-goreng.png"));
        ImageView iView10 = new ImageView(menuImg10);
        Label menu10 = new Label("Fried Rice");
        menu10.setFont(Font.font("calibri", 15));
        Label price10 = new Label("20000");
        price10.setFont(Font.font("calibri", 15));
        TextField qty10 = new TextField("");
        qty10.setMaxWidth(50);
        Button min10 = new Button("-");
        min10.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        Button plus10 = new Button("+");
        plus10.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        HBox spinnerHBox10 = new HBox();
        spinnerHBox10.getChildren().addAll(qty10, min10, plus10);
        spinnerHBox10.setAlignment(Pos.CENTER);
        spinnerHBox10.setSpacing(5);
        Button addOrder10 = new Button("Add Order");
        addOrder10.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        VBox menuItem10 = new VBox();
        menuItem10.setSpacing(10);
        menuItem10.setAlignment(Pos.CENTER);
        menuItem10.getChildren().addAll(iView10, menu10, price10, spinnerHBox10, addOrder10);
        GridPane.setConstraints(menuItem10, 0, 3);

        //MENU 11
        Image menuImg11 = new Image(new FileInputStream("D:/JFX Alt/SsOR/image/burger.png"));
        ImageView iView11 = new ImageView(menuImg11);
        Label menu11 = new Label("Burger");
        menu11.setFont(Font.font("calibri", 15));
        Label price11 = new Label("10000");
        price11.setFont(Font.font("calibri", 15));
        TextField qty11 = new TextField("");
        qty11.setMaxWidth(50);
        Button min11 = new Button("-");
        min11.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        Button plus11 = new Button("+");
        plus11.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        HBox spinnerHBox11 = new HBox();
        spinnerHBox11.getChildren().addAll(qty11, min11, plus11);
        spinnerHBox11.setAlignment(Pos.CENTER);
        spinnerHBox11.setSpacing(5);
        Button addOrder11 = new Button("Add Order");
        addOrder11.setStyle("-fx-background-color: darkseagreen; -fx-text-fill: white;");
        VBox menuItem11 = new VBox();
        menuItem11.setSpacing(10);
        menuItem11.setAlignment(Pos.CENTER);
        menuItem11.getChildren().addAll(iView11, menu11, price11, spinnerHBox11, addOrder11);
        GridPane.setConstraints(menuItem11, 1, 3);

        center.getChildren().addAll(menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6, menuItem7, menuItem8, menuItem9, menuItem10, menuItem11);

        //rightside includes receipt and total -------------------------------------------------------------//
        VBox right = new VBox();
        right.setSpacing(10);
        right.setPadding(new Insets(10));
        right.setBackground(Background.fill(Color.DARKSEAGREEN));
        bPane.setRight(right);

        Label orderNumLabel = new Label("Your Order Number : ");
        orderNumLabel.setFont(Font.font("calibri", 15));
        Label orderNumber = new Label("1");
        orderNumber.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        HBox orderNumberHBox = new HBox();
        orderNumberHBox.setSpacing(10);
        orderNumberHBox.getChildren().addAll(orderNumLabel, orderNumber);

        TableView<Menu> table = new TableView<>();
        TableColumn<Menu, Integer> qtyColumn = new TableColumn<>("Qty");
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("qty"));
        TableColumn<Menu, String> menuColumn = new TableColumn<>("Menu");
        menuColumn.setCellValueFactory(new PropertyValueFactory<>("menu"));
        TableColumn<Menu, Integer> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().add(qtyColumn);
        table.getColumns().add(menuColumn);
        table.getColumns().add(priceColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Tooltip tip1 = new Tooltip("re-order");
        Button deleteRow = new Button("X");
        deleteRow.setTooltip(tip1);
        deleteRow.setStyle("-fx-background-color: whitesmoke; -fx-text-fill: black;");
        Tooltip tip2 = new Tooltip("get your total price ^^");
        Button refreshbButton = new Button("Get Total");
        refreshbButton.setTooltip(tip2);
        refreshbButton.setStyle("-fx-background-color: whitesmoke; -fx-text-fill: black;");
        HBox deleteHBox = new HBox();
        deleteHBox.setSpacing(5);
        deleteHBox.getChildren().addAll(table, refreshbButton, deleteRow);
        deleteHBox.setAlignment(Pos.CENTER_RIGHT);

        Separator section1 = new Separator();

        Label totalLabel = new Label("Your Total : ");
        totalLabel.setFont(Font.font("calibri", 15));
        Label total = new Label("");
        total.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        HBox totalHBox = new HBox();
        totalHBox.setSpacing(10);
        totalHBox.getChildren().addAll(totalLabel, total);

        Label noteLabel = new Label("Any notes for your orders?");
        noteLabel.setFont(Font.font("calibri", 15));
        TextField note = new TextField();

        Button orderButton = new Button("Order");
        orderButton.setStyle("-fx-background-color: whitesmoke; -fx-text-fill: black;");
        orderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Order Info");
                alert.setHeaderText(null);
                alert.setContentText("Thank you for Purchasing! your reciept is printing^^");

                Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        String t = orderNumber.getText();
                        int clicks = Integer.parseInt(t);
                        clicks++;
                        orderNumber.setText(Integer.toString(clicks));
                    }
                clearAll();
            }

            void clearAll() {
                qty1.setText("");
                qty2.setText("");
                qty3.setText("");
                qty4.setText("");
                qty5.setText("");
                qty6.setText("");
                qty7.setText("");
                qty8.setText("");
                qty9.setText("");
                qty10.setText("");
                qty11.setText("");
                table.getItems().clear();
                note.setText("");
                total.setText("");
            }
        });

        right.getChildren().addAll(orderNumberHBox, table, deleteHBox, totalHBox, section1, noteLabel, note, orderButton);

        //eventhandling----------------------------------------------------------------------------------------------------------//
        refreshbButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                if (qty1.getText().equals("")) {
                    qty1.setText("0");
                } if (qty2.getText().equals("")) {
                    qty2.setText("0");
                } if (qty3.getText().equals("")) {
                    qty3.setText("0");
                } if (qty4.getText().equals("")) {
                    qty4.setText("0");
                } if (qty5.getText().equals("")) {
                    qty5.setText("0");
                } if (qty6.getText().equals("")) {
                    qty6.setText("0");
                } if (qty7.getText().equals("")) {
                    qty7.setText("0");
                } if (qty8.getText().equals("")) {
                    qty8.setText("0");
                } if (qty9.getText().equals("")) {
                    qty9.setText("0");
                } if (qty10.getText().equals("")) {
                    qty10.setText("0");
                } if (qty11.getText().equals("")) {
                    qty11.setText("0");
                }
                
                int a = Integer.parseInt(qty1.getText())*Integer.parseInt(price1.getText());
                int b = Integer.parseInt(qty2.getText())*Integer.parseInt(price2.getText());
                int c = Integer.parseInt(qty3.getText())*Integer.parseInt(price3.getText());
                int d = Integer.parseInt(qty4.getText())*Integer.parseInt(price4.getText());
                int e = Integer.parseInt(qty5.getText())*Integer.parseInt(price5.getText());
                int f = Integer.parseInt(qty6.getText())*Integer.parseInt(price6.getText());
                int g = Integer.parseInt(qty7.getText())*Integer.parseInt(price7.getText());
                int h = Integer.parseInt(qty8.getText())*Integer.parseInt(price8.getText());
                int i = Integer.parseInt(qty9.getText())*Integer.parseInt(price9.getText());
                int j = Integer.parseInt(qty10.getText())*Integer.parseInt(price10.getText());
                int k = Integer.parseInt(qty11.getText())*Integer.parseInt(price11.getText());

                int sum = a + b + c + d + e + f + g + h + i + j + k;
                total.setText(Integer.toString(sum));
            }
            
        });

        deleteRow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                clearAll();

                // int row = table.getSelectionModel().getSelectedIndex();
                // delete(row);

                // try {
                //     Menu selectedMenu = table.getSelectionModel().getSelectedItem();
                //     int sum = Integer.parseInt(total.getText()) - selectedMenu.getPrice();
                //     // String a = table.getColumns().get(2).getCellObservableValue(row).getValue().toString();
                //     // int sum = Integer.parseInt(total.getText()) - Integer.parseInt(a);
                //     total.setText(Integer.toString(sum));
                // } catch (Exception eventHandling) {
                //     table.setPlaceholder(new Label("No Orders Yet!"));
                //     total.setText("");
                // }
            }

            private void clearAll() {
                qty1.setText("");
                qty2.setText("");
                qty3.setText("");
                qty4.setText("");
                qty5.setText("");
                qty6.setText("");
                qty7.setText("");
                qty8.setText("");
                qty9.setText("");
                qty10.setText("");
                qty11.setText("");
                table.getItems().clear();
                note.setText("");
                total.setText("");
            }

            // void delete(int row) {
            //     if (row >= 0){
            //         table.getItems().remove(row);
            //     }
            // }
        });

        plus1.setOnAction(new EventHandlerImplementation(qty1));
        plus2.setOnAction(new EventHandlerImplementation(qty2));
        plus3.setOnAction(new EventHandlerImplementation(qty3));
        plus4.setOnAction(new EventHandlerImplementation(qty4));
        plus5.setOnAction(new EventHandlerImplementation(qty5));
        plus6.setOnAction(new EventHandlerImplementation(qty6));
        plus7.setOnAction(new EventHandlerImplementation(qty7));
        plus8.setOnAction(new EventHandlerImplementation(qty8));
        plus9.setOnAction(new EventHandlerImplementation(qty9));
        plus10.setOnAction(new EventHandlerImplementation(qty10));
        plus11.setOnAction(new EventHandlerImplementation(qty11));

        min1.setOnAction(new EventHandlerImplementation2(qty1));
        min2.setOnAction(new EventHandlerImplementation2(qty2));
        min3.setOnAction(new EventHandlerImplementation2(qty3));
        min4.setOnAction(new EventHandlerImplementation2(qty4));
        min5.setOnAction(new EventHandlerImplementation2(qty5));
        min6.setOnAction(new EventHandlerImplementation2(qty6));
        min7.setOnAction(new EventHandlerImplementation2(qty7));
        min8.setOnAction(new EventHandlerImplementation2(qty8));
        min9.setOnAction(new EventHandlerImplementation2(qty9));
        min10.setOnAction(new EventHandlerImplementation2(qty10));
        min11.setOnAction(new EventHandlerImplementation2(qty11));

        addOrder1.setOnAction(new EventHandlerImplementation3(menu1, table, total, price1, qty1));
        addOrder2.setOnAction(new EventHandlerImplementation3(menu2, table, total, price2, qty2));
        addOrder3.setOnAction(new EventHandlerImplementation3(menu3, table, total, price3, qty3));
        addOrder4.setOnAction(new EventHandlerImplementation3(menu4, table, total, price4, qty4));
        addOrder5.setOnAction(new EventHandlerImplementation3(menu5, table, total, price5, qty5));
        addOrder6.setOnAction(new EventHandlerImplementation3(menu6, table, total, price6, qty6));
        addOrder7.setOnAction(new EventHandlerImplementation3(menu7, table, total, price7, qty7));
        addOrder8.setOnAction(new EventHandlerImplementation3(menu8, table, total, price8, qty8));
        addOrder9.setOnAction(new EventHandlerImplementation3(menu9, table, total, price9, qty9));
        addOrder10.setOnAction(new EventHandlerImplementation3(menu10, table, total, price10, qty10));
        addOrder11.setOnAction(new EventHandlerImplementation3(menu11, table, total, price11, qty11));
    }
}
