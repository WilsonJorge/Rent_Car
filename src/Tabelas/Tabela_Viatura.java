package Tabelas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import Entidades.Viatura;

import javax.swing.*;
import java.awt.*;
public class Tabela_Viatura extends AbstractTableModel{
    private List<Viatura>lista;
    private String colunas[]=new String[] {"Marca","Modelo","Matricula","Ano_Fabrico","Estado","Tipo_Viatura","Seguros","inspencao","Manutencao","Preco","Num_BI_Funcionario","Num_BI_Cliente","ID_Aluguer"};;
    
    //Metodo Construtor
    public Tabela_Viatura()
    {
    	
    	
    }
    public Tabela_Viatura(List<Viatura> viatura) {
        lista=viatura;
    }
    public void actualizarLista(List<Viatura> viatura) {
        lista=viatura;
        this.fireTableDataChanged();
    }

   @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
public String getColumnName(int indice){
    return colunas[indice];
}
	public Object getValueAt(int linha, int coluna) {
		Viatura v=lista.get(linha);
		
		switch(coluna)
		{
		    case 0:
		    	 return v.getMarca();
		    	 
		    
		    case 1:
		    	return v.getModelo();
		    
		    	
		    case 2:
		    	  return v.getMatricula();
		    	 
		    case 3: return v.getAno_Fabrico();
		         
		         
		    case 4: 
		    	  return v.getEstado();
		    	  
		    case 5: 
		    	  return v.getTipo_Viatura();
		    
		    case 6: 
		    	  return v.getSeguros();
		    
		    case 7: 
		    	  return v.getInspencao();
		    
		    case 8: 
		    	  return v.getManutencao();
		     	  
		    case 9: 
		    	  return v.getEstado();
		    
		    case 10: 
		    	  return v.getPreco();
		    	  
		    case 11: 
		    	  return v.getFuncionario();
		    case 12: 
		    	  return v.getCliente();
		    	  
		    case 13: 
		    	  return v.getAluguer();
		    
		    
		    default:
		    	  return "";
		}
		
	}
	
	public void actualizar(Viatura viatura){
        lista.add(viatura);
        fireTableRowsInserted(lista.size()-1, lista.size()-1);
    }
    
    public Viatura retornarEstudante(int indice){
        return lista.get(indice);
    }
	
}
