package Usuario;

public class Entidade_Usuario {
	private String nome_usuario;
	private int senha;
	//Metodo construtor
	public Entidade_Usuario(String nome_usuario,int senha)
	{
		this.nome_usuario=nome_usuario;
		this.senha=senha;
	}
	public  Entidade_Usuario()
	{
		this("",0);
	}
	
	public String getNome()
	{
		return nome_usuario;
	}
	public int getSenha()
	{
		return senha;
	}
	
	public void setNome(String nome_usuario)
	{
		this.nome_usuario=nome_usuario;
	}
	
	public void setSenha(int senha)
	{
		this.senha=senha;
	}

}
