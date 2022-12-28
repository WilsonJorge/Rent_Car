package Entidades;

public class Aluguer {
		 private int id_aluguer;
		 private float valor_apagar;
		 private String destino;
		 private String duracao;
		 private String situacao_aluguer;
		 
		 public Aluguer(int id_aluguer,float valor_apagar,String destino,String duracao,String situacao_aluguer)
		 {
			this.destino=destino;
			this.duracao=duracao;
			this.id_aluguer=id_aluguer;
			this.situacao_aluguer=situacao_aluguer;
			this.valor_apagar=valor_apagar;
			
		 }
		 public Aluguer()
		 {
			 this(0,0,"","","");
		 }
		 public String getDestino()
		 {
			 return destino;
		 }
		 
		 public String getDuracao()
		 {
			 return duracao;
		 }
		 
		 public String getSituacao()
		 {
			 return situacao_aluguer;
		 }
		 
		 public int getIDAluguer()
		 {
			 return id_aluguer;
		 }
		 
		 public float getValorApagar()
		 {
			 return valor_apagar;
		 }
		 
		 public void setIDAluguer(int id_aluguer)
		 {
			 this.id_aluguer=id_aluguer;
		 }
		 
		 public void setValorApagar(float valor_apagar)
		 {
			 this.valor_apagar=valor_apagar;
		 }
		 
		 public void setDestino(String destino)
		 {
			 this.destino=destino;
		 }
		 
		 public void setDuracao(String duracao)
		 {
			 this.duracao=duracao;
		 }
		 
		 public void setSitaucao(String situacao)
		 {
			 this.situacao_aluguer=situacao_aluguer;
		 }
		}

