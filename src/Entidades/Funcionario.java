package Entidades;
public class Funcionario {
 private String nome_funcionario;
 private String  num_bi_funcionario;
 private String funcao;
 private int salario;
 private String nome_banco;
 private int numero_banco;
 
 public Funcionario(String nome_funcionario,String  num_bi_funcionario,int salario,String funcao)
 {
	this.nome_funcionario=nome_funcionario;
	this.funcao=funcao;
	this.salario=salario;
	this.num_bi_funcionario=num_bi_funcionario;
 }
 
 public Funcionario()
 {
	 this(" ","",0," ");
 }
 
 public String getNomeFuncionario()
 {
	 return nome_funcionario;
 }
 
 public String  getBI_Funcionario()
 {
	 return num_bi_funcionario;
 }
 
 
 public String getNomeBanco()
 {
	 return nome_banco;
 }
 
 public int getNumeroBanco()
 {
	 return numero_banco;
 }
 
 public int getSalario()
 {
	 return salario;
 }
 
 public String getFuncao()
 {
	 return funcao;
 }
 
 public void setNomeFuncionario(String nome_funcionario)
 {
	 this.nome_funcionario=nome_funcionario;
 }

 public void setNum_BI_Fun(String num_bi_funcionario)
 {
	 this.num_bi_funcionario=num_bi_funcionario;
 }



 
 public void setFuncao(String funcao)
 {
	 this.funcao=funcao;
 }
 
 public void setSalario(int i)
 {
	 this.salario=i;
 }
}
