package br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    TextField textFieldMultiplicando;
    TextField textFieldMenormultiolicador;
    TextField textFieldMaiormultiplicador;
    ListView listaTabuada;
    @Override
    public void start(Stage stage) throws IOException {
        //definir o tamanho do stege
        stage.setHeight(500);

        // controlando o fechamento ao cliacar no fechar da janela
        stage.setOnCloseRequest(e->{
            sairDaTabuada();
            e.consume();
        });

        //Bloquear o redmencionamento da janela
        stage.setResizable(false);

        //componente principal da tela
        VBox root = new VBox();
        Scene scene = new Scene(root);


        //cabeçalho da tela
        VBox header = new VBox();
        header.setStyle("-fx-padding: 10; -fx-background-color: rgba(40,142,215,0.82)");

        //Adicionar um label ao header
        Label labelTitle = new Label("Tabuada");
        labelTitle.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold;");
        Label labelSubtitulo = new Label("Construa tabudas sem limites!");
        labelSubtitulo.setStyle("-fx-text-fill: white;-fx-font-size: 14");

        header.getChildren().addAll(labelTitle );
        header.getChildren().addAll(labelSubtitulo);



        //Criar um multiplicando
        GridPane gridFormulario = new GridPane();
        gridFormulario.setPadding(new Insets(20));
        gridFormulario.setVgap(10);
        gridFormulario.setHgap(10);
        Label labelMultiplicando = new Label("Multiplicando");
        textFieldMultiplicando = new TextField();


        Label labelMenormultiolicador = new Label("menor multiolicador");
        textFieldMenormultiolicador = new TextField();

        Label labelMaiormultiplicador = new Label("Maior multiplicador");
        textFieldMaiormultiplicador = new TextField();

        gridFormulario.add(labelMultiplicando, 0, 0);
        gridFormulario.add(textFieldMultiplicando, 1, 0);
        gridFormulario.add(labelMenormultiolicador, 0, 1);
        gridFormulario.add(textFieldMenormultiolicador, 1, 1);
        gridFormulario.add(labelMaiormultiplicador, 0, 2);
        gridFormulario.add(textFieldMaiormultiplicador, 1, 2);

        // Criar o componente de botoôes
        
        
        HBox boxbotoes = new HBox();
        boxbotoes.setAlignment(Pos.CENTER_RIGHT);
        boxbotoes.setPadding( new Insets(0, 20, 20, 20) );
        boxbotoes.setSpacing(10);
        Button btnCaucular= new Button("Calcular");
        btnCaucular.prefWidth(100);
        btnCaucular.setOnAction(e -> {
            calcularTabuada();


        });
        Button btnLimpar= new Button("Limpar");
        btnLimpar.prefWidth(90);
        btnLimpar.setOnAction(e -> {
            limparFormulario();


        });

        Button btnSair= new Button("Sair");
        btnSair.prefWidth(90);
        btnSair.setOnAction(e -> {
           sairDaTabuada();



        });

        //Adicionas os botões no boxBotões
        boxbotoes.getChildren().addAll(btnCaucular, btnLimpar, btnSair);

        // Adicionar um componente ListView
        VBox boxResultado = new VBox();
        boxResultado.setPadding(new Insets(20));
        Label labelResultado = new Label("Resultado");
        labelResultado.setStyle("-fx-text-fill: blue;-fx-font-size: 14;-fx-font-weight: bold;");

        //Adicionar a listView
        listaTabuada = new ListView();


        //Adicionar a label ao resultado
        boxResultado.getChildren().addAll(labelResultado);
        boxResultado.getChildren().addAll(listaTabuada);

        //colocar hearder no root
        root.getChildren().addAll(header);
        //Adicionar componentes ao root
        root.getChildren().add(gridFormulario);
        root.getChildren().add(boxbotoes);
        root.getChildren().add(boxResultado);





        stage.setScene(scene);
        stage.setTitle("Tabuada");
        stage.show();
    }
    public void limparFormulario(){
        listaTabuada.getItems().clear();
        textFieldMultiplicando.clear();
        textFieldMenormultiolicador.clear();
        textFieldMaiormultiplicador.clear();
        textFieldMultiplicando.requestFocus();


    }
    public void calcularTabuada(){
        int multiplicando = Integer.parseInt(textFieldMultiplicando.getText());
        int menorMultiblicador = Integer.parseInt(textFieldMenormultiolicador.getText());
        int maiorMultiplicador = Integer.parseInt(textFieldMaiormultiplicador.getText());

        if (menorMultiblicador > maiorMultiplicador){
            int auxiliar = menorMultiblicador;
            menorMultiblicador = maiorMultiplicador;
            maiorMultiplicador = auxiliar;
        }
        int tamanho= maiorMultiplicador - menorMultiblicador + 1;
        String[] tabuada = new String[tamanho];

        int contador = 0;

        while (contador < tamanho){
            double produto = multiplicando * menorMultiblicador;
            tabuada[contador] = multiplicando + "X" + menorMultiblicador + " = " + produto;
            contador++;
            menorMultiblicador++;
        };
        listaTabuada.getItems().clear();
        listaTabuada.getItems().addAll(tabuada);

    }
    public void sairDaTabuada(){
        Alert alerta = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Confirma a saída? ",
                ButtonType.YES,
                ButtonType.NO);

        Optional<ButtonType> botaoPrecionado = alerta.showAndWait();
        if (botaoPrecionado.isPresent() && botaoPrecionado.get() == ButtonType.YES){
            System.exit(0);

        }
    }

}
