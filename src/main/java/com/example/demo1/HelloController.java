package com.example.demo1;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox all;

    @FXML
    private CheckBox brut;

    @FXML
    private Button buttom;

    @FXML
    private CheckBox ddos;

    @FXML
    private CheckBox info;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label logo;

    @FXML
    private CheckBox sql;

    @FXML
    private Label text;

    @FXML
    private CheckBox xss;
    @FXML
    private TextField IP;

    public boolean isFileEmpty(File file) {
        return file.length() == 0;
    }
    @FXML
    void initialize() {
        buttom.setOnAction(e -> text.setText("Label Text Change Demonstration"));
        StringBuilder words = new StringBuilder();

        //String words = " ";
        buttom.setOnAction(event -> {
            Path t1 = Paths.get("/home/kali/Documents/notepad1");
            Path t2 = Paths.get("/home/kali/Documents/notepad2");
            Path t3 = Paths.get("/home/kali/Documents/notepad3");
            Path t4 = Paths.get("/home/kali/Documents/notepad4");
            Path t5 = Paths.get("/home/kali/Documents/notepad5");

            String l1 = "", l2 = "",l3 = "", l4 = "", l5 = "";
            try {
                Files.write(t1, l1.getBytes());
                Files.write(t2, l2.getBytes());
                Files.write(t3, l3.getBytes());
                Files.write(t4, l4.getBytes());
                Files.write(t5, l5.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (info.isSelected()){
                //l1 += "Информация\n" ;
                Inform d = new Inform();
                d.info(t1);

            }
            if (brut.isSelected()){
                //l2+= "\nBrute-force \n";
                //text.setText(String.valueOf(words));
                Brut a = new Brut();
                a.brut(t2);

            }
            if (xss.isSelected()){
                //l3+= "XSS \n";
                XSS d = new XSS();
                d.xss(t3);

            }
            if (sql.isSelected()){
                //l4+= "SQL-injection \n";
                Injection b = new Injection();
                b.injection(t4);
            }
            if (ddos.isSelected()){
                //l5+= "Ddos \n \n";
                Ddos a = new Ddos();
                a.ddos(t5);

                //words.append("Ddos") ;
                //text.setText(String.valueOf(words));
            }
            if (all.isSelected()){
                if (info.isSelected());
                else{    //l1 += "Информация\n\n";
                    Inform a = new Inform();
                    a.info(t1);}

                if (brut.isSelected()) ;
                else{
                    //l2 += "Brute-force \n\n";
                    //text.setText(String.valueOf(words));
                    Brut b = new Brut();
                    b.brut(t2);
                }
                if (xss.isSelected()) ;
                else{
                    //l3 += "XSS \n\n";
                    XSS c = new XSS();
                    c.xss(t3);
                }
                if (sql.isSelected()) ;
                else{
                    //l4+= "SQL-injection \n\n";
                    Injection d = new Injection();
                    d.injection(t4);
                }
                if (ddos.isSelected()) ;
                else{
                    //l5+= "Ddos \n\n";
                    Ddos e = new Ddos();
                    e.ddos(t5);
                }
            }
            File file1 = new File("/home/kali/Documents/notepad1");
            File file2 = new File("/home/kali/Documents/notepad2");
            File file3 = new File("/home/kali/Documents/notepad3");
            File file4 = new File("/home/kali/Documents/notepad4");
            File file5 = new File("/home/kali/Documents/notepad5");

            if (isFileEmpty(file1) == false || isFileEmpty(file2) == false ||
                    isFileEmpty(file3) == false || isFileEmpty(file4) == false ||
                    isFileEmpty(file5) == false){
                List<String> read1 = null;
                List<String> read2 = null;
                List<String> read3 = null;
                List<String> read4 = null;
                List<String> read5 = null;
                try {
                    read1 = Files.readAllLines(t1);
                    read2 = Files.readAllLines(t2);
                    read3 = Files.readAllLines(t3);
                    read4 = Files.readAllLines(t4);
                    read5 = Files.readAllLines(t5);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (String s : read1) {
                    System.out.println(s);
                    l1+=s+"\n";
                }
                l1+="\n";
                for (String s : read2) {
                    System.out.println(s);
                    l2+=s+"\n";
                }
                l2+="\n";
                for (String s : read3) {
                    System.out.println(s);
                    l3+=s+"\n";
                }
                l3+="\n";
                for (String s : read4) {
                    System.out.println(s);
                    l4+=s+"\n";
                }
                l4+="\n";
                for (String s : read5) {
                    System.out.println(s);
                    l5+=s+"\n";
                }
                l5+="\n";
            }
           text.setText(l1+l2+l3+l4+l5);
            file1.delete();
            file2.delete();
            file3.delete();
            file4.delete();
            file5.delete();
        });

    }

}
