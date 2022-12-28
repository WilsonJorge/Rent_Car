package Entidades;

public class Cliente{
	private String nome_Cliente;
	private int num_bi_cliente;
	private String tipo_cliente;
	private int num_bi_funcionario;
	
	//Metodo Construtor
	public Cliente(String nome_Cliente,int num_bi_cliente,int num_bi_funcionario,String tipo_cliente)
	{
		this.nome_Cliente=nome_Cliente;
		this.num_bi_cliente=num_bi_cliente;
		this.num_bi_funcionario=num_bi_funcionario;
		this.tipo_cliente=tipo_cliente;
	}
	public Cliente()
	{
		this("",0,0,"");
	}
	//Metodo Que retornam
	public String getNomeCliente()
	{
		return nome_Cliente;
	}
	
	public int getBICliente()
	{
		return num_bi_cliente;
	}
	
	public int getBIFuncionario()
	{
		return num_bi_funcionario;
	}
	
	public String getTipoCliente()
	{
		return tipo_cliente;
	}
	
	
	//Metodo Set para actualizar Dados
	
	public void setNomeCliente(String nome_Cliente)
	{
		this.nome_Cliente=nome_Cliente;
	}
	
	public void setBICliente(int num_bi_cliente)
	{
		this.num_bi_cliente=num_bi_cliente;
	}
	
	public void setBIFuncionario(int num_bi_funcionario)
	{
		this.num_bi_funcionario=num_bi_funcionario;
	}
	
	public void setTipoCliente(String tipo_cliente)
	{
		this.tipo_cliente=tipo_cliente;
	}
	
	
}