package DAO;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Viatura;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ViaturaDAO {
	private Connection conexao;
	
	public ViaturaDAO() {
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
	
	public List<Viatura> listar(){
		String sql= "SELECT * FROM Viatura";
		List<Viatura> lista= new ArrayList<>();
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ResultSet res= ps.executeQuery();
			while(res.next()) {
				Viatura viatura= new Viatura();
				viatura.setMarca(res.getString("marca"));
				viatura.setModelo(res.getString("modelo"));
				viatura.setMatricula(res.getString("matricula"));
				viatura.setSeguros(res.getString("Seguros"));
				viatura.setInspencao(res.getString("inspencao"));
				viatura.setManutencao(res.getString("manutenco"));
				viatura.setPreco(res.getInt("preco"));
				viatura.setFuncionario(res.getInt("funcionario"));
				viatura.setCliente(res.getInt("Cliente"));
				viatura.setAluguer(res.getInt("aluguer"));
				lista.add(viatura);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public boolean inserir(Viatura viatura) {
		String sql= "INSERT INTO VIATURA(matricula,marca,modelo,seguros,inspencao,manutencao,preco,num_bi_funcionario,num_bi_cliente,id_aluguer) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setString(1, viatura.getMatricula());
			ps.setString(2, viatura.getMarca());
			ps.setString(3, viatura.getModelo());
			ps.setString(4, viatura.getSeguros());
			ps.setString(5,viatura.getInspencao());
			ps.setString(6, viatura.getManutencao());
			ps.setLong(7, (long) viatura.getPreco());
			ps.setLong(8, viatura.getFuncionario());
			ps.setLong(9, viatura.getCliente());
			ps.setLong(10, viatura.getCliente());
			ps.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean alterar(Viatura viatura) {
		String sql= "UPDATE VIATURA SET marca=?,modelo=?,matricula=?,seguros=?,inspencao=?,manutencao=?,preco=?,num_bi_funcionario=?,num_bi_cliente=?,id_aluguer=? WHERE matricula=?";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setString(1, viatura.getMatricula());
			ps.setString(2, viatura.getMarca());
			ps.setString(3, viatura.getModelo());
			ps.setString(4, viatura.getSeguros());
			ps.setString(5,viatura.getInspencao());
			ps.setString(6, viatura.getManutencao());
			ps.setLong(7, (long) viatura.getPreco());
			ps.setLong(8, viatura.getFuncionario());
			ps.setLong(9, viatura.getCliente());
			ps.setLong(10, viatura.getCliente());
			ps.execute();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean remover(Integer matricula) {
		String sql= "DELETE FROM VIATURA WHERE matricula=?";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setInt(1, matricula);
			ps.execute();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}

