/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introdbacesso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
//  Nome da dupla:  Fernando Avelino da Silva CB3008053
//                  Diego Negrete Alves       CB1740229
*/

public class Conexao {
    
    public Connection con;
    
    
public Conexao(){
    
     try{
           String url ="jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=ProjetoEscola;trustServerCertificate=true;integratedSecurity=true;useSSL=false;";
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection(url);
     }catch(Exception e){
         
         JOptionPane.showMessageDialog(null, e.getMessage());
         
     }
    
}

public void testeConexao(){
    
      PreparedStatement pstm = null;
      ResultSet rs=null;
     try{
           Connection con;
           String url ="jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=ProjetoEscola;trustServerCertificate=true;integratedSecurity=true;useSSL=false;";
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection(url);  
           JOptionPane.showMessageDialog(null,"Conexao OK");
               
     }catch(Exception e){
         
            JOptionPane.showMessageDialog(null,"Não foi possível estabelecer uma conexão!");
    
     }  
}
    
}
