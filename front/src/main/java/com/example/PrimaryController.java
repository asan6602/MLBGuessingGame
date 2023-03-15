package com.example;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.All;
import model.AwardWinners;
import model.Game;
import model.Hof;
import model._1920s;
import model._1930s;
import model._1940s;
import model._1950s;
import model._1960s;
import model._1970s;
import model._1980s;
import model._1990s;
import model._2000s;
import model._2010s;

public class PrimaryController {

    private String name = "";
    private String hint = "";
    private String guess = "";
    private Game g = new Game();


    @FXML
    private Button Play;

    @FXML
    private TableView<battingEntry> bview;

    @FXML
    private TableColumn<battingEntry, String> b2b;

    @FXML
    private TableColumn<battingEntry, String> b3b;

    @FXML
    private TableColumn<battingEntry, String> bab;

    @FXML
    private TableColumn<battingEntry, String> bbb;

    @FXML
    private TableColumn<battingEntry, String> bg;

    @FXML
    private TableColumn<battingEntry, String> bh;

    @FXML
    private TableColumn<battingEntry, String> bhr;

    @FXML
    private TableColumn<battingEntry, String> br;

    @FXML
    private TableColumn<battingEntry, String> brbi;

    @FXML
    private TableColumn<battingEntry, String> bsb;

    @FXML
    private TableColumn<battingEntry, String> bteam;

    @FXML
    private TableColumn<battingEntry, String> byear;




    @FXML
    private TableView<pitchingEntry> pview;

    @FXML
    private TableColumn<pitchingEntry, String> pera;

    @FXML
    private TableColumn<pitchingEntry, String> pg;

    @FXML
    private TableColumn<pitchingEntry, String> pip;

    @FXML
    private TableColumn<pitchingEntry, String> pl;

    @FXML
    private TableColumn<pitchingEntry, String> pso;

    @FXML
    private TableColumn<pitchingEntry, String> psv;

    @FXML
    private TableColumn<pitchingEntry, String> pteam;

    @FXML
    private TableColumn<pitchingEntry, String> pw;

    @FXML
    private TableColumn<pitchingEntry, String> pyear;

    ObservableList<battingEntry> battingEntries = FXCollections.observableArrayList();
    ObservableList<pitchingEntry> pitchingEntries = FXCollections.observableArrayList();

    
    @FXML
    private Label hintLabel;

    @FXML
    private Button hintButton;



    @FXML
    private Button enterButton;

    @FXML
    private TextField enterText;

    @FXML
    private Label resultLabel;

    @FXML
    private RadioButton all, hof, awards, _1920s, _1930s, _1940s, _1950s, _1960s, _1970s, _1980s, _1990s, _2000s, _2010s;

    @FXML
    void play(ActionEvent event) {
        ArrayList<ArrayList<ArrayList<String>>> data = g.rawData();

        System.out.println(data);
        System.out.println(data.get(2));

        //setname
        this.name = data.get(0).get(0).get(0).toLowerCase() + " " + data.get(0).get(0).get(1).toLowerCase();
        hint = g.nameAsSpace(name);
        hintLabel.setText(hint);

        resultLabel.setText("");
        

        bview.getItems().clear();
        //put data into batting list
        byear.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("year"));
        bteam.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("team"));
        bg.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("g"));
        bab.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("ab"));
        br.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("r"));
        bh.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("h"));
        b2b.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("_2b"));
        b3b.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("_3b"));
        bhr.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("hr"));
        brbi.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("rbi"));
        bbb.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("bb"));
        bsb.setCellValueFactory(new PropertyValueFactory<battingEntry, String>("sb"));

        for(ArrayList<String> year: data.get(1)) {
            battingEntry bE = new battingEntry(year.get(0),year.get(1), year.get(2), year.get(3), year.get(4), year.get(5), year.get(6), year.get(7),
            year.get(8),year.get(9),year.get(10),year.get(11));
            battingEntries.add(bE);
        }

        bview.setItems(battingEntries);


        pview.getItems().clear();
        //put data into pitching list
        if(data.get(0).isEmpty()) {

        }
        else {
            pyear.setCellValueFactory(new PropertyValueFactory<pitchingEntry, String>("year"));
            pteam.setCellValueFactory(new PropertyValueFactory<pitchingEntry, String>("team"));
            pg.setCellValueFactory(new PropertyValueFactory<pitchingEntry, String>("g"));
            pw.setCellValueFactory(new PropertyValueFactory<pitchingEntry, String>("w"));
            pl.setCellValueFactory(new PropertyValueFactory<pitchingEntry, String>("l"));
            psv.setCellValueFactory(new PropertyValueFactory<pitchingEntry, String>("sv"));
            pso.setCellValueFactory(new PropertyValueFactory<pitchingEntry, String>("so"));
            pera.setCellValueFactory(new PropertyValueFactory<pitchingEntry, String>("era"));
            pip.setCellValueFactory(new PropertyValueFactory<pitchingEntry, String>("ip"));
    
            for(ArrayList<String> year: data.get(2)) {
                pitchingEntry pE = new pitchingEntry(year.get(0),year.get(1), year.get(2), year.get(3), year.get(4), year.get(5), year.get(6), year.get(7),
                year.get(8));
                pitchingEntries.add(pE);
            }
            pview.setItems(pitchingEntries);
        }

    }

    @FXML
    void enter(ActionEvent event) {
        guess = enterText.getText().toLowerCase();

        if(guess.equals(name)) {
            resultLabel.setText("You Got it");
        }
        else {
            resultLabel.setText("Wrong!");
        }
        
        
    }

    @FXML
    void hint1(ActionEvent event) {
        String newHint = g.hint(name, hint);
        this.hint = newHint;
        hintLabel.setText(hint);
    }

    @FXML
    void changeSetting(ActionEvent event) {
        if(all.isSelected()) {
            g.changeSetting(new All());
        }
        if(hof.isSelected()) {
            g.changeSetting(new Hof());
        }
        if(awards.isSelected()) {
            g.changeSetting(new AwardWinners());
        }
        if(_1920s.isSelected()) {
            g.changeSetting(new _1920s());
        }
        if(_1930s.isSelected()) {
            g.changeSetting(new _1930s());
        }
        if(_1940s.isSelected()) {
            g.changeSetting(new _1940s());
        }
        if(_1950s.isSelected()) {
            g.changeSetting(new _1950s());
        }
        if(_1960s.isSelected()) {
            g.changeSetting(new _1960s());
        }
        if(_1970s.isSelected()) {
            g.changeSetting(new _1970s());
        }
        if(_1980s.isSelected()) {
            g.changeSetting(new _1980s());
        }
        if(_1990s.isSelected()) {
            g.changeSetting(new _1990s());
        }
        if(_2000s.isSelected()) {
            g.changeSetting(new _2000s());
        }
        if(_2010s.isSelected()) {
            g.changeSetting(new _2010s());
        }
    }
}
