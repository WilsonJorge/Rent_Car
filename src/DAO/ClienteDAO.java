package DAO;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Cliente;
import Entidades.Funcionario;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClienteDAO {
	private Connection conexao;
	
	public ClienteDAO() {
		 try {
            Class.forName("org.postgresql.Driver");
            conexao= DriverManager.getConnection("jdbc:postgresql://"+"ec2-18-204-170-75.compute-1.amazonaws.com/d8bmth07norkbg","ceqtphmtruxmfu","250544c1a09f1b96f13fea3832405de91884860fe6244812affcd95ea240b9d7");
            System.out.println("conectado");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public List<Cliente> listar(){
		String sql= "SELECT * FROM Cliente";
		List<Cliente> lista= new ArrayList<>();
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ResultSet res= ps.executeQuery();
			while(res.next()) {
				Cliente cliente= new Cliente();
     			cliente.setNomeCliente(res.getString("nome"));
				cliente.setBIFuncionario(res.getInt("BI"));
				cliente.setBIFuncionario(res.getInt("BI_funcionario"));
				cliente.setTipoCliente(res.getString("tipo"));
			    lista.add(cliente);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public boolean inserir(Cliente cliente) {
		String sql= "INSERT INTO ANIMAL(nome_Cliente,num_bi_cliente,num_bi_funcionario,tipo_cliente,) VALUES(?,?,?,?)";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setLong(2, cliente.getBICliente());
			ps.setLong(3, cliente.getBIFuncionario());
			ps.setNString(4, cliente.getTipoCliente());
			ps.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean alterar( Cliente cliente) {
		String sql= "UPDATE ANIMAL SET nome_Cliente=?,num_bi_cliente=?,num_bi_funcionario=?,tipo_cliente=?, WHERE num_bi_cliente=?";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setLong(2, cliente.getBICliente());
			ps.setLong(3, cliente.getBIFuncionario());
			ps.setNString(4, cliente.getTipoCliente());
			ps.execute();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean remover(Integer num_bi_cliente) {
		String sql= "DELETE FROM Cliente WHERE num_bi_cliente=?";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setInt(1, num_bi_cliente);
			ps.execute();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}
