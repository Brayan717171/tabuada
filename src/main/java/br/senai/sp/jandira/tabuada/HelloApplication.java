package br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //definir o tamanho do stege
        stage.setWidth(600);
        stage.setHeight(600);

        //componente principal da tela
        VBox root = new VBox();
        Scene scene = new Scene(root);


        //cabeçalho da tela
        VBox header = new VBox();
        header.setStyle("-fx-padding: 10; -fx-background-color: #7505aa");

        //Adicionar um label ao header
        Label labelTitle = new Label("Tabuada");
        labelTitle.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold;");
        Label labelSubtitulo = new Label("Construa tabudas sem limites!");
        labelSubtitulo.setStyle("-fx-text-fill: white;-fx-font-size: 14");

        header.getChildren().addAll(labelTitle );
        header.getChildren().addAll(labelSubtitulo);

        //colocar hearder no root
        root.getChildren().addAll(header);

        //Criar um multiplicando
        HBox multiplicandoBox = new HBox();
        multiplicandoBox.setStyle("-fx-padding: 10;");
        Label labelMultiplicando = new Label("Multiplicando");
        TextField textFieldMultiplicando = new TextField();

        multiplicandoBox.getChildren().add(labelMultiplicando);
        multiplicandoBox.getChildren().add(textFieldMultiplicando);


        // colocamos o multiplicando box no root
        root.getChildren().addAll(multiplicandoBox);




        stage.setScene(scene);
        stage.setTitle("Tabuada");


        stage.show();
    }
}
