package com.example.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;


public class Injection {
    public static String injection(Path t){
        String inf = "";
        Process p;
        String s,l="SQL-injection\n";
        Integer line=0, i=0,z =0,x=0,c=0,v=0,b=0,n=0,a=0,d=0,f=0,g=0;

        try {
            p = Runtime.getRuntime().exec(
                    "sqlmap -u  192.168.0.14?email=DR@mail.ru --dbs -o -random-agent --ignore-stdin"
            );
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null){
                //System.out.println(s);

                if (s.contains("target URL content is stable") ){
                z++;
                if (z<=1)
                    s="Testing if the target URL content is stable";
                    l+= "::  " + s+"\n";
                }
                if (s.contains("GET parameter 'email' appears to be dynamic") ){
                x++;
                if (x<=1)
                    s="GET parameter 'email' appears to be dynamic";
                    l+= "::  " + s+"\n";
                }
                if (s.contains("testing for SQL injection on GET") ){
                c++;
                if (c<=1)
                    s="Testing for SQL injection on GET parameter 'email'";
                    l+= "::  " + s+"\n";
                }
                if (s.contains("GET parameter 'email' does not seem to be injectable") ){
                v++;
                if (v<=1)
                    s="GET parameter 'email' does not seem to be injectable";
                    l+= "::  " + s+"\n";
                }
                if (s.contains("All tested parameters do not appear") ){
                b++;
                if (b<=1)
                    s="All tested parameters do not appear to be injectable.";
                    l+= "::  " + s+"\n";
                }
                if (s.contains("ll tested parameters do not appear") ){
                    i++;
                    l += "SQL-injection: Unsuccessfully";
                }
            }
            p.waitFor();
            if (i==0)
                l+= "SQL-injection: Successfully";
            Files.write(t, l.getBytes());
            p.destroy();
        } catch (Exception e) {}

        return inf;
    }
}

//"sqlmap -u  " + address +"?email=DR@mail.ru --dbs -o -random-agent --ignore-stdin"