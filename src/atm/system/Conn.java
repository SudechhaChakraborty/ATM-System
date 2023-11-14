package atm.system;

import java.sql.*;  

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){  
        try{  
             
            c =DriverManager.getConnection("jdbc:mysql:///atms","root","Rixcy@0208");    
            s =c.createStatement(); 
         
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }
}
