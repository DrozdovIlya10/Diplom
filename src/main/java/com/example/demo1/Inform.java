package com.example.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Inform{
    public static String info(Path t){
        String inf = "";
        Process p;
        String s,not, l ="";
        Integer i=0, y= 0;
        StringBuilder line;
        try {
            //Path t = Paths.get("/home/kali/Documents/notepad1");
            p = Runtime.getRuntime().exec(
                    "nikto -h 192.168.0.14 -Tuning b "
            );
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            l+="Information about the application \n";
            while ((s = br.readLine()) != null){
                if (s.contains("Target IP:") ){
                    //System.out.println(s);
                    line = new StringBuilder(s);
                    line.replace(0,1,"");
                    l += ":: " + line + "\n";
                    i++;
                }
                if (s.contains("Target Port:") ) {

                    line = new StringBuilder(s);
                    line.replace(0, 1, "");
                    l += ":: " + line + "\n";
                }
                //System.out.println(s);
                if (s.contains("Server:") ){

                    line = new StringBuilder(s);
                    line.replace(0, 1, "");
                    l += ":: " + line + "\n";
                }

                //System.out.println(s);
                if (s.contains("Retrieved x-powered-by header") ){

                    line = new StringBuilder(s);
                    line.replace(0, 1, "");
                    l += ":: " + line + "\n";
                }

                //System.out.println(s);
            }
            Files.write(t, l.getBytes());
            p.waitFor();
            if (i==0){
                not = "Открытых портов не найдено";
                System.out.println(not);
                Files.write(t, not.getBytes());
            }
            p.destroy();
        } catch (Exception e) {}
        return inf;
    }
}
