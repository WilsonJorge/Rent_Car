package SubMenu;
import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import Componentes.Botao;
import Componentes.CampoTexto;
import DAO.AluguerDAO;
import DAO.ClienteDAO;
import Entidades.Aluguer;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Viatura;
public class Cadastro_Cliente extends JFrame{
    
	private JPanel pane_principal, pane_titulo,pane_dados,pane_dados_clientes; 
    private JLabel label_titulo,label_nome_cliente ,label_num_bi_cliente,label_tipo_cliente,label_num_bi_funcionario;
    private CampoTexto txt_mome_cliente , txt_BI,txt_tipo_cliente, txt_BI_funcionario;
   private Font font_lbs, font_lb_titulos;
   private Color cor_font_lbs;
   private Botao btn_cancelar, btn_cadastrar;
   private ButtonGroup btn_grupo;
   private Viatura carro;
   private Funcionario funcionario;
   private Cliente cliente;   
   private Aluguer aluguer;
   private JComboBox text_tipo_cliente;
//private TelaEstudante pane;

   public Cadastro_Cliente()
  { 
	   inicializacao();
	   eventosButoes();
	   adicionarPaneis("inicio");
  }






public void inicializacao() {
    
    font_lbs = new Font("Century Gothic", Font.BOLD, 13);
    font_lb_titulos = new Font("Century Gothic", Font.BOLD, 18);
    cor_font_lbs = new Color(29, 36, 98);

    pane_titulo = new JPanel(null);
    pane_titulo.setBounds(5, 5, 430, 35);
    pane_titulo.setBackground(new Color(51, 71, 72));

    label_titulo = new JLabel("Cadastro de Clientes");
    label_titulo.setForeground(new Color(255, 255, 255));
    label_titulo.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
    label_titulo.setHorizontalAlignment(SwingConstants.CENTER);
    label_titulo.setBounds(10, 5, 415, 25);
    pane_titulo.add(label_titulo);
    this.add(pane_titulo);

    pane_dados = new JPanel(null);
    pane_dados.setBounds(10, 45, 420, 320);
    pane_dados.setBackground(new Color(255, 255, 255));
    pane_dados.setBorder(new LineBorder(new Color(29, 36, 98), 1));
    this.add(pane_dados);

    pane_dados_clientes = new JPanel(null);
    pane_dados_clientes.setBackground(new Color(255, 255, 255));
    pane_dados_clientes.setBounds(10, 10, 400, 260);
    pane_dados_clientes.setBorder(new LineBorder(cor_font_lbs, 1));
    pane_dados.add(pane_dados_clientes);

    JLabel label_dados_funcionarios = new JLabel("Dados dos Clientes");
    label_dados_funcionarios.setOpaque(true);
    label_dados_funcionarios.setBounds(5, 5, pane_dados_clientes.getWidth() - 10, 30);
    label_dados_funcionarios.setBackground(new Color(240, 150, 9));
    label_dados_funcionarios.setHorizontalAlignment(SwingConstants.CENTER);
    label_dados_funcionarios.setForeground(new Color(255, 255, 255));
    label_dados_funcionarios.setFont(font_lb_titulos);
    pane_dados_clientes.add(label_dados_funcionarios);

    label_nome_cliente = new JLabel("Nome");
    label_nome_cliente.setFont(font_lbs);
    label_nome_cliente.setForeground(cor_font_lbs);
    label_nome_cliente.setBounds(30, 40, 300, 25);
    pane_dados_clientes.add(label_nome_cliente);

    txt_mome_cliente = new CampoTexto();
    txt_mome_cliente.setTextoFundo("Digite o nome do Cliente");
    txt_mome_cliente.setFont(font_lbs);
    txt_mome_cliente.setForeground(cor_font_lbs);
    txt_mome_cliente.setBounds(20, 65, 350, 25);
    pane_dados_clientes.add(txt_mome_cliente);

    label_num_bi_cliente = new JLabel("BI");
    label_num_bi_cliente.setFont(font_lbs);
    label_num_bi_cliente.setForeground(cor_font_lbs);
    label_num_bi_cliente.setBounds(30, 90, 300, 25);
    pane_dados_clientes.add(label_num_bi_cliente);
    
    txt_BI = new CampoTexto();
    txt_BI.setTextoFundo("Digite o BI do cliente");
    txt_BI.setFont(font_lbs);
    txt_BI.setForeground(cor_font_lbs);
    txt_BI.setBounds(20, 115, 350, 25);
    pane_dados_clientes.add(txt_BI);
    
    label_num_bi_funcionario= new JLabel("BI");
    label_num_bi_funcionario.setFont(font_lbs);
    label_num_bi_funcionario.setForeground(cor_font_lbs);
    label_num_bi_funcionario.setBounds(30, 140, 300, 25);
    pane_dados_clientes.add(label_num_bi_funcionario);

    txt_BI_funcionario = new CampoTexto();
    txt_BI_funcionario.setTextoFundo("Digite o BI do Funcionario");
    txt_BI_funcionario.setFont(font_lbs);
    txt_BI_funcionario.setForeground(cor_font_lbs);
    txt_BI_funcionario.setBounds(20, 165, 350, 25);
    pane_dados_clientes.add(txt_BI_funcionario);
    
    
    label_tipo_cliente = new JLabel("Tipo Cliente");
    label_tipo_cliente.setFont(font_lbs);
    label_tipo_cliente.setForeground(cor_font_lbs);
    label_tipo_cliente.setBounds(30, 190, 300, 25);
    pane_dados_clientes.add(label_tipo_cliente);
    
    text_tipo_cliente = new JComboBox<>();
    text_tipo_cliente.setBackground(new Color(255, 255, 255));
    text_tipo_cliente.setFont(font_lbs);
    text_tipo_cliente.setForeground(cor_font_lbs);
    text_tipo_cliente.setCursor(new Cursor((Cursor.HAND_CURSOR)));
    text_tipo_cliente.setBounds(20, 215, 350, 25);
    text_tipo_cliente.setModel(new DefaultComboBoxModel<>(new String[]{"Executivo","Normal"}));
    pane_dados_clientes.add(text_tipo_cliente);
    
           
   //Defenicao dos butoes
    btn_cadastrar = new Botao("Cadastrar");
    btn_cadastrar.setBackground(new Color(0, 128, 0));
    btn_cadastrar.setBackgroundMouseEntered(new Color(85, 170, 85));
    btn_cadastrar.setForeground(new Color(255, 255, 255));
    btn_cadastrar.setBounds(10, 280, 190, 30);
    pane_dados.add(btn_cadastrar);

    btn_cancelar = new Botao("Cancelar");
    btn_cancelar.setBackground(new Color(255, 0, 0));
    btn_cancelar.setBackgroundMouseEntered(new Color(255, 24, 24));
    btn_cancelar.setForeground(new Color(255, 255, 255));
    btn_cancelar.setBounds(210, 280, 198, 30);
    pane_dados.add(btn_cancelar);
    
    this.getContentPane().add(pane_dados);
    this.setLayout(null);
    this.setSize(454, 415);
    this.setLocationRelativeTo(null);
    this.setMinimumSize(new Dimension(300, 325));
   
}
//Metodo para dos enventos dos botoes
private void eventosButoes() {
  
	btn_cadastrar.addActionListener(
    		new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				boolean passou= false;
    				String tipo_cliente="";
    				
    				if(passou==false) {
    					
    					String nome= txt_mome_cliente.getText();
    					int bi_cliente= Integer.parseInt(txt_BI.getText());
    					int bi_funcionario= Integer.parseInt(txt_BI_funcionario.getText());
    					String  resposta=text_tipo_cliente.getSelectedItem().toString();
	    				Cliente cliente= new Cliente(nome,bi_cliente, bi_funcionario, resposta);
	    				ClienteDAO clienteDAO= new ClienteDAO();
	    				clienteDAO.inserir(cliente);
	    				passou= true;
	    				if(passou==true) {
	    					txt_mome_cliente.setText("");
	    					txt_BI.setText("");
	    					txt_BI_funcionario.setText("");
		    	        }
	    				JOptionPane.showMessageDialog(null, "Cliente Registrado!");
    				}else {
    					JOptionPane.showMessageDialog(null, "Cliente nao registrado! Consulte o erro");
    					passou= false;
    				}
    			}
    		}
    		); 
	
	
	
	
	
	
	
	
	
	btn_cancelar.addActionListener(new ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      	adicionarPaneis("cliente");
      	
      	
          
      }
  });
} 
  
//Metodo para fazer Layout dos Paines
  private void adicionarPaneis(String opcao) {

      switch (opcao) {

          case "cliente":
              Tela_Cliente t = new Tela_Cliente();
              this.dispose();
              t.show();
              break;
          
   }
  }     


}



