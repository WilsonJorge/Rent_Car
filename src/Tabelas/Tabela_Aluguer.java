package Tabelas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import Entidades.Aluguer;
import javax.swing.*;
import java.awt.*;
public class Tabela_Aluguer extends AbstractTableModel{
    private List<Aluguer>lista;
    private String colunas[];
    //Metodo Construtor
    public Tabela_Aluguer(List<Aluguer>lista)
    {
    	this.lista=lista;
    	colunas=new String[] {"ID_Aluguer","Valor_apagar","Destino","Duracao","Situacao_Aluguer"};
    }
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Aluguer a=lista.get(linha);
		
		switch(coluna)
		{
		    case 0:
		    	 return a.getIDAluguer();
		    	 
		    
		    case 1:
		    	return a.getValorApagar();
		    
		    	
		    case 2:
		    	  return a.getDestino();
		    	 
		    case 3: return a.getDuracao();
		         
		         
		    case 4: 
		    	  return a.getSituacao();
		    	  
		    default:
		    	  return "";
		}
		
	}
	
	 public Aluguer retornarAnimal(int linha) {
	        return lista.get(linha);
	    }

	    public void actualizar(List<Aluguer> lista) {
	        this.lista = lista;
	        fireTableDataChanged();
	    }

	    public void actualizarLinha(Aluguer a) {
	        lista.add(a);
	        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
	    }
	
}