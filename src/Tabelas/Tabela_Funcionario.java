package Tabelas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import Entidades.Funcionario;

import javax.swing.*;
import java.awt.*;
public class Tabela_Funcionario extends AbstractTableModel{
    private List<Funcionario>lista;
    private String colunas[];
    //Metodo Construtor
    public Tabela_Funcionario(List<Funcionario>lista)
    {
    	this.lista=lista;
    	colunas=new String[] {"Nome_Funcionario"," Num_BI_Funcionario","Funcao","Salario"};
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
		Funcionario f=lista.get(linha);
		
		switch(coluna)
		{
		    case 0:
		    	 return f.getNomeFuncionario();
		    	 
		    
		    case 1:
		    	return f.getBI_Funcionario();
		    
		    	
		    case 2:
		    	  return f.getFuncao(); 
		    	 
		    case 3: return f.getSalario();
		         
		         
		    case 4: 
		    	  return f.getNomeFuncionario();
            
		    case 5: 
		    	  return f.getNumeroBanco();
		     	  
		    default:
		    	  return "";
		}
		
	}
	
	 public Funcionario retornarAnimal(int linha) {
	        return lista.get(linha);
	    }

	    public void actualizar(List<Funcionario> lista) {
	        this.lista = lista;
	        fireTableDataChanged();
	    }

	    public void actualizarLinha(Funcionario f) {
	        lista.add(f);
	        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
	    }
	
}
