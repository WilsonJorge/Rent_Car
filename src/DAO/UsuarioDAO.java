package DAO;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Aluguer;
import Entidades.Cliente;
import Entidades.Funcionario;
import Usuario.Entidade_Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UsuarioDAO {
	private Connection conexao;
	
	public UsuarioDAO() {
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
	
	public List<Entidade_Usuario> listar(){
		String sql= "SELECT * FROM Login";
		List<Entidade_Usuario> lista= new ArrayList<>();
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ResultSet res= ps.executeQuery();
			while(res.next()) {
				Entidade_Usuario usuario= new Entidade_Usuario();
     			 usuario.setNome(res.getString("nome_usuario"));
     			 usuario.setSenha(res.getInt("senha"));
				
				lista.add(usuario);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public boolean inserir(Entidade_Usuario usuario) {
		String sql= "INSERT INTO Login(nome_usuario,senha) VALUES(?,?)";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setLong(2, usuario.getSenha());
			
			ps.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean alterar(Entidade_Usuario usuario) {
		String sql= "UPDATE Login SET nome_usuario=?,senha=? WHERE senha=?";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setLong(2, usuario.getSenha());
			
			ps.execute();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean remover(Integer senha) {
		String sql= "DELETE FROM Login WHERE senha=?";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setInt(1,senha);
			ps.execute();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}