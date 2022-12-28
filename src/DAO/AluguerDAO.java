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
import java.util.logging.Level;
import java.util.logging.Logger;
public class AluguerDAO {
	private Connection conexao;
	
	public AluguerDAO() {
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
	
	public List<Aluguer> listar(){
		String sql= "SELECT * FROM Aluguer";
		List<Aluguer> lista= new ArrayList<>();
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ResultSet res= ps.executeQuery();
			while(res.next()) {
				Aluguer aluguer= new Aluguer();
     			aluguer.setIDAluguer(res.getInt("id_aluguer"));
				aluguer.setValorApagar(res.getInt("valor"));
				aluguer.setDestino(res.getString("destino"));
				aluguer.setDuracao(res.getString("duracao"));
				aluguer.setSitaucao(res.getString("situacao"));
				lista.add(aluguer);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public boolean inserir(Aluguer aluguer) {
		String sql= "INSERT INTO ANIMAL(id_aluguer,valor_apagar,destino,duracao,situacao_aluguer) VALUES(?,?,?,?,?)";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setLong(1, aluguer.getIDAluguer());
			ps.setLong(2, (long) aluguer.getValorApagar());
			ps.setString(3, aluguer.getDestino());
			ps.setString(4, aluguer.getDuracao());
			ps.setString(5, aluguer.getSituacao());
			
			ps.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean alterar(Aluguer aluguer) {
		String sql= "UPDATE ANIMAL SET id_aluguer=?,valor_apagar=?,destino=?,duracao=?,situacao_aluguer=? WHERE id_aluguer=?";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setLong(1, aluguer.getIDAluguer());
			ps.setLong(2, (long) aluguer.getValorApagar());
			ps.setString(3, aluguer.getDestino());
			ps.setString(4, aluguer.getDuracao());
			ps.setString(5, aluguer.getSituacao());
			ps.execute();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean remover(Integer id_aluguer) {
		String sql= "DELETE FROM ANIMAL WHERE id_aluguer=?";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setInt(1, id_aluguer);
			ps.execute();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}