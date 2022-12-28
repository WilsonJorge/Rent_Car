package Conexao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
     String URL;
     Connection con;
	public Conexao()
        {

        try {
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://"+"ec2-18-204-170-75.compute-1.amazonaws.com/d8bmth07norkbg","ceqtphmtruxmfu","250544c1a09f1b96f13fea3832405de91884860fe6244812affcd95ea240b9d7");
            System.out.println("conectado");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

        
    public void conexao()
           {
            try {
                    PreparedStatement cox=con.prepareStatement("Select * From Raca");	
                    ResultSet rs= cox.executeQuery();
                    while(rs.next()) {
                            System.out.println(rs.getString(1)+" "+rs.getInt(2));

                    }
           }  catch (SQLException ex)
             {
                 Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    public static  void  main(String [] args)
    {
        new Conexao();
        
    }
}





