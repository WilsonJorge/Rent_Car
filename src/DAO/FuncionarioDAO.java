package DAO;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Funcionario;
import java.util.logging.Level;
import java.util.logging.Logger;
public class FuncionarioDAO {
	private Connection conexao;
	
	public FuncionarioDAO() {
		 try {
            Class.forName("org.postgresql.Driver");
            conexao= DriverManager.getConnection("jdbc:postgresql://"+"ec2-18-204-170-75.compute-1.amazonaws.com/d8bmth07norkbg","ceqtphmtruxmfu","250544c1a09f1b96f13fea3832405de91884860fe6244812affcd95ea240b9d7");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	//terminado
	public List<Funcionario> listar(){
		String sql= "SELECT * FROM  funcionario";
		List<Funcionario> lista= new ArrayList<>();
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ResultSet res= ps.executeQuery();
			while(res.next()) {
                            Funcionario funcionario= new Funcionario();
                            funcionario.setNomeFuncionario(res.getString("nome_funcionario"));
                            funcionario.setNum_BI_Fun(res.getString("num_bi_funcionario"));
                            funcionario.setFuncao(res.getString("funcao"));
                            funcionario.setSalario(res.getInt("salario"));
                            lista.add(funcionario);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	//terminao
	public void inserir(Funcionario funcionario) {
		String sql= "INSERT INTO FUNCIONARIO(nome_funcionario,num_bi_funcionario,funcao,salario) VALUES(?,?,?,?)";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setString(1, funcionario.getNomeFuncionario());
			ps.setString(2, funcionario.getBI_Funcionario());
			ps.setString(3, funcionario.getFuncao());
			ps.setInt(4, funcionario.getSalario());
			ps.execute();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void alterar(Funcionario funcionario) {
		String sql= "UPDATE funcionario SET nome_funcionario=?,funcao=?,salario=?  WHERE num_bi_funcionario=?";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setString(1, funcionario.getNomeFuncionario());
			ps.setString(2, funcionario.getFuncao());
			ps.setLong(3, funcionario.getSalario());
                        ps.setString(4, funcionario.getBI_Funcionario());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void remover(String num_bi_funcionario) {
		String sql= "DELETE FROM funcionario WHERE num_bi_funcionario=?";
		
		try {
			PreparedStatement ps= conexao.prepareStatement(sql);
			ps.setString(1, num_bi_funcionario);
			ps.execute();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}
	}
	
}
