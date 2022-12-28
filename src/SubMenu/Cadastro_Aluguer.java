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
import Entidades.Aluguer;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Viatura;
public class Cadastro_Aluguer extends JFrame{
    
	private JPanel pane_principal, pane_titulo,pane_dados,pane_dados_aluguer; 
    private JLabel label_titulo,label_id_aluguer ,label_valor_apagar,label_destino,label_duracao,label_situacao_aluguer;
    private CampoTexto txt_id_aluguer,txt_valor_apagar,txt_destino,
     txt_duracao, txt_situacao_aluguer;
    String resultado;
    JRadioButton nao,sim;

   private Font font_lbs, font_lb_titulos;
   private Color cor_font_lbs;
   private Botao btn_cancelar, btn_cadastrar;
   private ButtonGroup btn_grupo;
   private Viatura carro;
   private Funcionario funcionario;
   private Cliente cliente;   
   private Aluguer aluguer;
   JComboBox text_raca_animal;
//private TelaEstudante pane;

   public Cadastro_Aluguer()
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

    label_titulo = new JLabel("Cadastro de Aluguer");
    label_titulo.setForeground(new Color(255, 255, 255));
    label_titulo.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
    label_titulo.setHorizontalAlignment(SwingConstants.CENTER);
    label_titulo.setBounds(10, 5, 415, 25);
    pane_titulo.add(label_titulo);
    this.add(pane_titulo);

    pane_dados = new JPanel(null);
    pane_dados.setBounds(10, 45, 420, 360);
    pane_dados.setBackground(new Color(255, 255, 255));
    pane_dados.setBorder(new LineBorder(new Color(29, 36, 98), 1));
    this.add(pane_dados);

    pane_dados_aluguer = new JPanel(null);
    pane_dados_aluguer.setBackground(new Color(255, 255, 255));
    pane_dados_aluguer.setBounds(10, 10, 400, 300);
    pane_dados_aluguer.setBorder(new LineBorder(cor_font_lbs, 1));
    pane_dados.add(pane_dados_aluguer);

    JLabel label_dados_funcionarios = new JLabel("Dados de Aluguer");
    label_dados_funcionarios.setOpaque(true);
    label_dados_funcionarios.setBounds(5, 5,pane_dados_aluguer.getWidth() - 10, 30);
    label_dados_funcionarios.setBackground(new Color(240, 150, 9));
    label_dados_funcionarios.setHorizontalAlignment(SwingConstants.CENTER);
    label_dados_funcionarios.setForeground(new Color(255, 255, 255));
    label_dados_funcionarios.setFont(font_lb_titulos);
    pane_dados_aluguer.add(label_dados_funcionarios);

    label_id_aluguer = new JLabel("ID");
    label_id_aluguer.setFont(font_lbs);
    label_id_aluguer.setForeground(cor_font_lbs);
    label_id_aluguer.setBounds(30, 40, 300, 25);
    pane_dados_aluguer.add(label_id_aluguer);

    txt_id_aluguer = new CampoTexto();
    txt_id_aluguer.setTextoFundo("Digite o ID do Aluguer");
    txt_id_aluguer.setFont(font_lbs);
    txt_id_aluguer.setForeground(cor_font_lbs);
    txt_id_aluguer.setBounds(20, 65, 350, 25);
    pane_dados_aluguer.add(txt_id_aluguer);

    label_valor_apagar = new JLabel("Valor");
    label_valor_apagar.setFont(font_lbs);
    label_valor_apagar.setForeground(cor_font_lbs);
    label_valor_apagar.setBounds(30, 90, 300, 25);
    pane_dados_aluguer.add(label_valor_apagar);
    
    txt_valor_apagar = new CampoTexto();
    txt_valor_apagar.setTextoFundo("Digite o valor apagar");
    txt_valor_apagar.setFont(font_lbs);
    txt_valor_apagar.setForeground(cor_font_lbs);
    txt_valor_apagar.setBounds(20, 115, 350, 25);
    pane_dados_aluguer.add(txt_valor_apagar);
    
    label_destino = new JLabel("Destino");
    label_destino.setFont(font_lbs);
    label_destino.setForeground(cor_font_lbs);
    label_destino.setBounds(30, 140, 300, 25);
    pane_dados_aluguer.add(label_destino);

    txt_destino = new CampoTexto();
    txt_destino.setTextoFundo("Digite o Destino da Viatura");
    txt_destino.setFont(font_lbs);
    txt_destino.setForeground(cor_font_lbs);
    txt_destino.setBounds(20, 165, 350, 25);
    pane_dados_aluguer.add(txt_destino);
    
    
    label_duracao = new JLabel("Duracao");
    label_duracao.setFont(font_lbs);
    label_duracao.setForeground(cor_font_lbs);
    label_duracao.setBounds(30, 190, 300, 25);
    pane_dados_aluguer.add(label_duracao);
    
    txt_duracao = new CampoTexto();
    txt_duracao.setTextoFundo("Digite  a duracao que o carro sera alugado");
    txt_duracao.setFont(font_lbs);
    txt_duracao.setForeground(cor_font_lbs);
    txt_duracao.setBounds(20, 215, 350, 25);
    pane_dados_aluguer.add(txt_duracao);
    
    label_situacao_aluguer = new JLabel("Aluguer da Viatura com Motorista?");
    label_situacao_aluguer.setFont(font_lbs);
    label_situacao_aluguer.setForeground(cor_font_lbs);
    label_situacao_aluguer.setBounds(30, 240, 300, 25);
    pane_dados_aluguer.add(label_situacao_aluguer);
    
    JPanel aluguerar  = new JPanel(null);
    aluguerar.setBackground(new Color(255, 255, 255));
    aluguerar.setBounds(20, 265, 350, 25);
    aluguerar.setBorder(new LineBorder(new Color(37, 248, 234), 1));
    pane_dados_aluguer.add(aluguerar);

    nao = new JRadioButton("Nao");
    nao.setBackground(new Color(255, 255, 255));
    nao.setActionCommand("N");
    nao.setForeground(cor_font_lbs);
    nao.setFont(font_lbs);
    nao.setBounds(10, (aluguerar.getHeight() - 20) / 2, 150, 20);
    nao.setFocusPainted(false);
    nao.setCursor(new Cursor(Cursor.HAND_CURSOR));
    aluguerar.add(nao);

    sim = new JRadioButton("Sim");
    sim.setBackground(new Color(255, 255, 255));
    sim.setActionCommand("S");
    sim.setForeground(cor_font_lbs);
    sim.setFont(font_lbs);
    sim.setBounds(160, (aluguerar.getHeight() - 20) / 2, 150, 20);
    sim.setFocusPainted(false);
    sim.setCursor(new Cursor(Cursor.HAND_CURSOR));
    aluguerar.add(sim); 
       
    btn_grupo=new ButtonGroup();
    btn_grupo.add(nao);
    btn_grupo.add(sim);
   //Defenicao dos butoes
    btn_cadastrar = new Botao("Cadastrar");
    btn_cadastrar.setBackground(new Color(0, 128, 0));
    btn_cadastrar.setBackgroundMouseEntered(new Color(85, 170, 85));
    btn_cadastrar.setForeground(new Color(255, 255, 255));
    btn_cadastrar.setBounds(10, 320, 190, 30);
    pane_dados.add(btn_cadastrar);

    btn_cancelar = new Botao("Cancelar");
    btn_cancelar.setBackground(new Color(255, 0, 0));
    btn_cancelar.setBackgroundMouseEntered(new Color(255, 24, 24));
    btn_cancelar.setForeground(new Color(255, 255, 255));
    btn_cancelar.setBounds(210, 320, 198, 30);
    pane_dados.add(btn_cancelar);
    
    this.getContentPane().add(pane_dados);
    this.setLayout(null);
    this.setSize(454, 455);
    this.setLocationRelativeTo(null);
    this.setMinimumSize(new Dimension(300, 325));
   
}
private void eventosButoes() {
    btn_cadastrar.addActionListener(
    		new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				boolean passou= false;
    				String resultado="";
    				
    				if(passou==false) {
    					int id_aluguer= Integer.parseInt(txt_id_aluguer.getText());
    					float valor_apagar= Float.parseFloat(txt_valor_apagar.getText());
    					String destino= txt_destino.getText();
    					String duracao= (txt_duracao.getText());
    					if(nao.isSelected())
        				{
        					resultado="sim";
        				}
        				if(sim.isSelected())
        				{
        					resultado="nao";
        				}
	    				Aluguer aluguer= new Aluguer(id_aluguer,valor_apagar, destino, duracao, resultado);
	    				AluguerDAO aluguerDAO= new AluguerDAO();
	    				aluguerDAO.inserir(aluguer);
	    				passou= true;
	    				if(passou==true) {
	    					txt_id_aluguer.setText("");
		    				AbstractButton text_valor_apagar = null;
							text_valor_apagar.setText("");
		    				txt_destino.setText("");
		    				txt_duracao.setText("");
	    				}
	    				JOptionPane.showMessageDialog(null, "Aluguer Registrado!");
    				}else {
    					JOptionPane.showMessageDialog(null, "Aluguer nao registrado! Consulte o erro");
    					passou= false;
    				}
    			}
    		}
    		); 
	
	
	
	
	btn_cancelar.addActionListener(new ActionListener() {
	      public void actionPerformed(java.awt.event.ActionEvent evt) {
	      	adicionarPaneis("aluguer");
	      	
	      	
	          
	      }
	  });
	} 
	  
	//Metodo para fazer Layout dos Paines
	  private void adicionarPaneis(String opcao) {

	      switch (opcao) {

	          case "aluguer":
	              Tela_Aluguer t = new Tela_Aluguer();
	              this.dispose();
	              t.show();
	              break;
	          
	   }
	  }     

}


