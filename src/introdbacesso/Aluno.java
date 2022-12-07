/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introdbacesso;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.sql.*;
import Json.JSONObject;
import javax.swing.table.DefaultTableModel;

/**
//  Nome da dupla:  Fernando Avelino da Silva CB3008053
//                  Diego Negrete Alves       CB1740229
*/

public class Aluno {
    
    public String nomeAluno;
    public int idadeAluno;
    public float pesoAluno; 
    public float alturaAluno; 
    public String objetivoAluno;

    
     public Aluno(){
         
     }
     
  public Aluno(String nome, int idade, float peso, float altura, String obj){

      nomeAluno = nome;
      idadeAluno = idade;
      pesoAluno = peso; 
      alturaAluno = altura; 
      objetivoAluno = obj;     
  
}
  
  
 public String addAluno(Aluno aluno){
      PreparedStatement pstm = null;
      ResultSet rs=null;
     try{
           Connection con;
           String url ="jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=ProjetoEscola;trustServerCertificate=true;integratedSecurity=true;useSSL=false;";
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection(url);   

           pstm = con.prepareStatement("INSERT INTO tb_alunos (nm_aluno,qt_idade,qt_peso,qt_altura,ds_objetivo) values(?,?,?,?,?)");
           
           pstm.setString(1,aluno.nomeAluno);
           pstm.setInt(2,aluno.idadeAluno);
           pstm.setFloat(3, aluno.pesoAluno);
           pstm.setFloat(4, aluno.alturaAluno);
           pstm.setString(5,aluno.objetivoAluno);  
           pstm.executeUpdate();
           pstm.close();
           JOptionPane.showMessageDialog(null,"Incluído com Sucesso!");
           con.close();
               
     }
     
     
      catch (SQLException | ClassNotFoundException e1){
             JOptionPane.showMessageDialog(null,"Não foi possível Incluir aluno:  " + e1.getMessage());       
     }
     return "ok";
 }
 
 public void retornaAlunos(){


      PreparedStatement pstm = null;
      ResultSet rs=null;
      
     try{
           Connection con;
           String url ="jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=ProjetoEscola;trustServerCertificate=true;integratedSecurity=true;useSSL=false;";
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection(url);   

           pstm = con.prepareStatement("Select * from tb_alunos");
           rs = pstm.executeQuery();
           
           JSONObject my_obj = new JSONObject();

            //percorre o resultado da Query (* from tabela tb_alunos) jogando dados no JSON
            
            while(rs.next()) {
            my_obj.put("cod",rs.getString(1));
            my_obj.put("nome",rs.getString(2));	
            my_obj.put("idade",rs.getInt(3));
            my_obj.put("peso",rs.getFloat(4));
            my_obj.put("aultura",rs.getFloat(5));
            my_obj.put("objetivo",rs.getString(6));

           // String json_string = my_obj.toString();
           
          
            
            JOptionPane.showMessageDialog(null,my_obj);
            
                            }  
           pstm.close();
           con.close();
           JOptionPane.showMessageDialog(null,"JSON SUCESSO!");
               
     }
     
     
      catch (SQLException | ClassNotFoundException e1){
             JOptionPane.showMessageDialog(null,"Não foi possível Incluir aluno:  " + e1.getMessage());       
     }
 }
}
 