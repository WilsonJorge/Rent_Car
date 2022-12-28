package Entidades;
public class Viatura {
	   private String marca;
	   private String modelo;
	   private String matricula;
	   private int ano_fabrico;
	   private String estado;
	   private String tipo_viatura;
	   private String seguros;
	   private String inspencao;
	   private String manutencao;
	   private float preco;
	   private int num_bi_funcionario;
	   private int num_bi_cliente;
	   private int id_aluguer;
	   //Metodo Construtor
	   public Viatura(String matricula,String marca,String modelo ,String seguros,String inspencao,String manutencao,int preco,int num_bi_funcionario,int num_bi_cliente,int id_aluguer)
	   {
		 this.marca=marca;
	     this.modelo=modelo;
	     this.matricula=matricula;
	     this.ano_fabrico=ano_fabrico;
	     this.estado=estado;
	     this.tipo_viatura=tipo_viatura;
	     this.seguros=seguros;
	     this.inspencao=inspencao;
	     this.manutencao=manutencao;
	     this.preco=preco;
	     this.num_bi_cliente=num_bi_cliente;
	     this.num_bi_funcionario=num_bi_funcionario;
	     this.id_aluguer=id_aluguer;
	   }
	   public Viatura()
	   {
		   this(" "," "," "," "," "," ",0,0,0,0);
	   }
	   //Metodo De Retorno
	   public String getMarca()
	   {
		   return marca;
	   }
	   
	   public String getModelo()
	   {
		   return modelo;
	   }
	   
	   public String getMatricula()
	   {
		   return matricula;
	   }
	   
	   public int getAno_Fabrico()
	   {
		   return ano_fabrico;
	   }
	   
	   public String getEstado()
	   {
		   return estado;
	   }
	   
	   public String getTipo_Viatura()
	   {
		   return tipo_viatura;
	   }
	   
	   public String getSeguros()
	   {
		   return seguros;
	   }
	   
	   public String getInspencao()
	   {
		   return inspencao;
	   }
	   
	   public String getManutencao()
	   {
		   return manutencao;
	   }
	   
	   public float getPreco()
	   {
		   return preco;
	   }
	   
	   public int getFuncionario()
	   {
		   return num_bi_funcionario;
	   }
	   
	   public int getCliente()
	   {
		   return num_bi_cliente;
	   }
	   
	   public int getAluguer()
	   {
		   return id_aluguer;
	   }
	   
	  
	   
	   //Metodo de actualizacao(Set)
	   
	   public void setMarca(String marca)
	   {
		   this.marca=marca;
	   }
	   
	   public void  setModelo(String modelo)
	   {
		   this.modelo=modelo;
	   }
	   
	   public void setMatricula(String matricula)
	   {
		   this.matricula=matricula;
	   }
	   
	   public void setAno_Fabrico(int ano_fabrico)
	   {
		   this.ano_fabrico =ano_fabrico;
	   }
	   
	   public void  setEstado(String estado)
	   {
		   this.estado=estado;
	   }
	   
	   public void setTipo_Viatura(String tipo_viatura)
	   {
		   this.tipo_viatura=tipo_viatura;
	   }
	   
	   public void setSeguros(String seguros)
	   {
		   this.seguros=seguros;
	   }
	   
	   public void setInspencao(String inspencao)
	   {
		   this.inspencao=inspencao;
	   }
	   
	   public void setManutencao(String manutencao)
	   {
		  this.manutencao=manutencao;
	   }
	   
	   public void setPreco(float preco)
	   {
		   this.preco=preco;
	   }
	   
	   public void setFuncionario(int num_bi_funcionario)
	   {
		   this.num_bi_funcionario=num_bi_funcionario;
	   }
	   
	   public void setCliente(int num_bi_cliente)
	   {
		   this.num_bi_cliente=num_bi_cliente;
	   }
	   public void setAluguer(int id_aluguer)
	   {
		   this.id_aluguer=id_aluguer;
	   }
	}

