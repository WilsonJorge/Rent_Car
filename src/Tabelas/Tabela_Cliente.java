package Tabelas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import Entidades.Cliente;

import javax.swing.*;
import java.awt.*;
public class Tabela_Cliente extends AbstractTableModel{
    private List<Cliente>lista;
    private String colunas[];
    //Metodo Construtor
    public Tabela_Cliente(List<Cliente>lista)
    {
    	this.lista=lista;
    	colunas=new String[] {"Nome_Cliente","Num_BI_Cliente","Tipo_Cliente","Num_BI_Funcionario"};
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
		Cliente c=lista.get(linha);
		
		switch(coluna)
		{
		    case 0:
		    	 return c.getNomeCliente();
		    	 
		    
		    case 1:
		    	return c.getBICliente();
		    
		    	
		    case 2:
		    	  return c.getTipoCliente();
		    	 
		    case 3: return c.getBIFuncionario();
		         
		        	  
		    default:
		    	  return "";
		}
		
	}
	
	 public Cliente retornarAnimal(int linha) {
	        return lista.get(linha);
	    }

	    public void actualizar(List<Cliente> lista) {
	        this.lista = lista;
	        fireTableDataChanged();
	    }

	    public void actualizarLinha(Cliente c) {
	        lista.add(c);
	        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
	    }
	
}
