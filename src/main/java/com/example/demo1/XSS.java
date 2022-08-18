package com.example.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class XSS {
    public static String xss(Path t){
        String inf = "";
        Process p;
        String s, l = "Cross-site scripting\n";
        Integer i=0;
        StringBuilder line;
        try {
            p = Runtime.getRuntime().exec(
                    new String[]{
                            "xsser", "-u", "https://xss-game.appspot.com", "-g", "/level1/frame?query=XSS"
                            //"xsser", "-u", "http://192.168.0.14", "-g", "/error?email=DR@mail.ru&password=XSS"
                    }
            );
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            while ((s = br.readLine()) != null){
                //System.out.println(s);
                if (s.contains("Status") ){
                    line = new StringBuilder(s);
                    line.replace(0,4,"");
                    l += ":: " + line + "\n";
                }
                if (s.contains(" XSS FOUND!") ){
                    i++;
                    l += "XSS: Successfully \n";
                }
                if (s.contains("Target:") ){
                    line = new StringBuilder(s);
                    line.replace(0,4,"");
                    l += ":: " + line + "\n";
                }
                if (s.contains("Vector") ){
                    line = new StringBuilder(s);
                    line.replace(0,4,"");
                    l += ":: " + line + "\n";
                }
                if (s.contains("Method") ){
                    line = new StringBuilder(s);
                    line.replace(0,4,"");
                    l += ":: " + line + "\n";
                }
                if (s.contains("Hash") ){
                    line = new StringBuilder(s);
                    line.replace(0,4,"");
                    l += ":: " + line + "\n";
                }
                if (s.contains("Payload") ){
                    line = new StringBuilder(s);
                    line.replace(0,4,"");
                    l += ":: " + line + "\n";
                }
                if (s.contains("Vulnerable") ){
                    line = new StringBuilder(s);
                    line.replace(0,4,"");
                    l += ":: " + line + "\n";
                }

            }
            p.waitFor();
            if (i==0)
                l+= "XSS: Unsuccessfully";
            Files.write(t, l.getBytes());
            p.destroy();
        } catch (Exception e) {}

        return inf;
    }
}

//"xsser", "-u", "https://xss-game.appspot.com", "-g", "/level1/frame?query=XSS"
//"xsser -u 'http://192.168.0.14' -g '/error?email=DR@mail.ru&password=XSS'"
//"xsser -u 'https://xss-game.appspot.com' -g '/level1/frame?query=XSS'"