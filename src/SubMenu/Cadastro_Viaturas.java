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
import DAO.ClienteDAO;
import DAO.ViaturaDAO;
import Entidades.Aluguer;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Viatura;
public class Cadastro_Viaturas extends JFrame{
    
	private JPanel pane_principal, pane_titulo,pane_dados,pane_dados_viaturas;
    private JLabel label_titulo,label_matricula,label_marca,label_modelo,label_tipo_viatura;
    private JLabel label_seguros ,label_inspencao,label_manutencao,label_preco,label_bi_cliente,label_bi_funcionario,label_id_aluguer;
    private CampoTexto txt_matricula, txt_marca, txt_modelo,
     txt_seguros, txt_inspencao, txt_manutencao,txt_preco,txt_num_bi_fun,txt_num_bi_cli,txt_id_aluguer;

   private Font font_lbs, font_lb_titulos;
   private Color cor_font_lbs;
   private Botao btn_cancelar, btn_cadastrar;
   private ButtonGroup btn_grupo;
   private Viatura carro;
   private Funcionario funcionario;
   private Cliente cliente;   
   private Aluguer aluguer;
   private  JComboBox text_marca ;
   private JRadioButton resp1,resp2,sim,nao,resposta1,resposta2;
//private TelaEstudante pane;

   public Cadastro_Viaturas()
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
    pane_titulo.setBounds(5, 5, 803, 35);
    pane_titulo.setBackground(new Color(51, 71, 72));

    label_titulo = new JLabel("Cadastro de Viaturas");
    label_titulo.setForeground(new Color(255, 255, 255));
    label_titulo.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
    label_titulo.setHorizontalAlignment(SwingConstants.CENTER);
    label_titulo.setBounds(200, 5, 415, 25);
    pane_titulo.add(label_titulo);
    this.add(pane_titulo);

    pane_dados = new JPanel(null);
    pane_dados.setBounds(10, 45, 792, 370);
    pane_dados.setBackground(new Color(255, 255, 255));
    pane_dados.setBorder(new LineBorder(new Color(29, 36, 98), 1));
    this.add(pane_dados);

    pane_dados_viaturas = new JPanel(null);
    pane_dados_viaturas.setBackground(new Color(255, 255, 255));
    pane_dados_viaturas.setBounds(10, 10, 770, 310);
    pane_dados_viaturas.setBorder(new LineBorder(cor_font_lbs, 1));
    pane_dados.add(pane_dados_viaturas);

    JLabel label_dados_vituras = new JLabel("Dados das Viaturas");
    label_dados_vituras.setOpaque(true);
    label_dados_vituras.setBounds(5, 5, pane_dados_viaturas.getWidth() - 10, 30);
    label_dados_vituras.setBackground(new Color(240, 150, 9));
    label_dados_vituras.setHorizontalAlignment(SwingConstants.CENTER);
    label_dados_vituras.setForeground(new Color(255, 255, 255));
    label_dados_vituras.setFont(font_lb_titulos);
    pane_dados_viaturas.add(label_dados_vituras);

    label_matricula = new JLabel("Matricula");
    label_matricula.setFont(font_lbs);
    label_matricula.setForeground(cor_font_lbs);
    label_matricula.setBounds(30, 40, 300, 25);
    pane_dados_viaturas.add(label_matricula);

    txt_matricula = new CampoTexto();
    txt_matricula.setTextoFundo("Digite o numero da matricula");
    txt_matricula.setFont(font_lbs);
    
    txt_matricula.setForeground(cor_font_lbs);
    txt_matricula.setBounds(20, 65, 350, 25);
    pane_dados_viaturas.add(txt_matricula);

    label_marca = new JLabel("Marca");
    label_marca.setFont(font_lbs);
    label_marca.setForeground(cor_font_lbs);
    label_marca.setBounds(30, 90, 300, 25);
    pane_dados_viaturas.add(label_marca);
    
    text_marca = new JComboBox<>();
    text_marca.setBackground(new Color(255, 255, 255));
    text_marca.setFont(font_lbs);
    text_marca.setForeground(cor_font_lbs);
    text_marca.setCursor(new Cursor((Cursor.HAND_CURSOR)));
    text_marca.setBounds(20, 115, 350, 25);
    text_marca.setModel(new DefaultComboBoxModel<>(new String[]{"Selecione", "Toyota"}));
    pane_dados_viaturas.add(text_marca);
    
    label_modelo = new JLabel("Modelo");
    label_modelo.setFont(font_lbs);
    label_modelo.setForeground(cor_font_lbs);
    label_modelo.setBounds(30, 140, 300, 25);
    pane_dados_viaturas.add(label_modelo);

    txt_modelo = new CampoTexto();
    txt_modelo.setTextoFundo("Digite o modelo da viatura");
    txt_modelo.setFont(font_lbs);
    txt_modelo.setForeground(cor_font_lbs);
    txt_modelo.setBounds(20, 165, 350, 25);
    pane_dados_viaturas.add(txt_modelo);

    label_seguros = new JLabel("A viatura  contem seguros?");
    label_seguros.setFont(font_lbs);
    label_seguros.setForeground(cor_font_lbs);
    label_seguros.setBounds(30, 190, 300, 25);
    pane_dados_viaturas.add(label_seguros);
    
    JPanel seguros  = new JPanel(null);
    seguros.setBackground(new Color(255, 255, 255));
    seguros.setBounds(20, 215, 350, 25);
    seguros.setBorder(new LineBorder(new Color(37, 248, 234), 1));
    pane_dados_viaturas.add(seguros);

    nao = new JRadioButton("Nao");
    nao.setBackground(new Color(255, 255, 255));
    nao.setActionCommand("N");
    nao.setForeground(cor_font_lbs);
    nao.setFont(font_lbs);
    nao.setBounds(10, (seguros.getHeight() - 20) / 2, 150, 20);
    nao.setFocusPainted(false);
    nao.setCursor(new Cursor(Cursor.HAND_CURSOR));
    seguros.add(nao);

    sim = new JRadioButton("Sim");
    sim.setBackground(new Color(255, 255, 255));
    sim.setActionCommand("S");
    sim.setForeground(cor_font_lbs);
    sim.setFont(font_lbs);
    sim.setBounds(160, (seguros.getHeight() - 20) / 2, 150, 20);
    sim.setFocusPainted(false);
    sim.setCursor(new Cursor(Cursor.HAND_CURSOR));
    seguros.add(sim); 
    
    label_inspencao = new JLabel("A viatura  contem inspensao?");
    label_inspencao.setFont(font_lbs);
    label_inspencao.setForeground(cor_font_lbs);
    label_inspencao.setBounds(30, 240, 300, 25);
    pane_dados_viaturas.add(label_inspencao);
    
    JPanel inspensao  = new JPanel(null);
    inspensao.setBackground(new Color(255, 255, 255));
    inspensao.setBounds(20, 265, 350, 25);
    inspensao.setBorder(new LineBorder(new Color(37, 248, 234), 1));
    pane_dados_viaturas.add(inspensao);

    resp1 = new JRadioButton("Nao");
    resp1.setBackground(new Color(255, 255, 255));
    resp1.setActionCommand("N");
    resp1.setForeground(cor_font_lbs);
    resp1.setFont(font_lbs);
    resp1.setBounds(10, (inspensao.getHeight() - 20) / 2, 150, 20);
    resp1.setFocusPainted(false);
    resp1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    inspensao.add(resp1);

    resp2 = new JRadioButton("Sim");
    resp2.setBackground(new Color(255, 255, 255));
    resp2.setActionCommand("S");
    resp2.setForeground(cor_font_lbs);
    resp2.setFont(font_lbs);
    resp2.setBounds(160, (inspensao.getHeight() - 20) / 2, 150, 20);
    resp2.setFocusPainted(false);
    resp2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    inspensao.add(resp2); 
   
    label_manutencao = new JLabel("A viatura  contem manutencao?");
    label_manutencao.setFont(font_lbs);
    label_manutencao.setForeground(cor_font_lbs);
    label_manutencao.setBounds(410, 40, 300, 25);
    pane_dados_viaturas.add(label_manutencao);
    
    JPanel manutencao  = new JPanel(null);
    manutencao.setBackground(new Color(255, 255, 255));
    manutencao.setBounds(400, 65, 350, 25);
    manutencao.setBorder(new LineBorder(new Color(37, 248, 234), 1));
    pane_dados_viaturas.add(manutencao);

    resposta1 = new JRadioButton("Nao");
    resposta1.setBackground(new Color(255, 255, 255));
    resposta1.setActionCommand("N");
    resposta1.setForeground(cor_font_lbs);
    resposta1.setFont(font_lbs);
    resposta1.setBounds(10, (manutencao.getHeight() - 20) / 2, 150, 20);
    resposta1.setFocusPainted(false);
    resposta1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    manutencao.add(resposta1);
    
    resposta2 = new JRadioButton("Sim");
    resposta2.setBackground(new Color(255, 255, 255));
    resposta2.setActionCommand("S");
    resposta2.setForeground(cor_font_lbs);
    resposta2.setFont(font_lbs);
    resposta2.setBounds(160, (manutencao.getHeight() - 20) / 2, 150, 20);
    resposta2.setFocusPainted(false);
    resposta2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    manutencao.add(resposta2); 
    
    label_preco = new JLabel("Preco");
    label_preco.setFont(font_lbs);
    label_preco.setForeground(cor_font_lbs);
    label_preco.setBounds(410, 90, 300, 25);
    pane_dados_viaturas.add(label_preco);
    
    txt_preco = new CampoTexto();
    txt_preco.setTextoFundo("Digite o preco da viatura");
    txt_preco.setFont(font_lbs);
    txt_preco.setForeground(cor_font_lbs);
    txt_preco.setBounds(400, 115, 350, 25);
    pane_dados_viaturas.add(txt_preco);
    
    
    label_bi_funcionario = new JLabel("BI");
    label_bi_funcionario.setFont(font_lbs);
    label_bi_funcionario.setForeground(cor_font_lbs);
    label_bi_funcionario.setBounds(410, 140, 300, 25);
    pane_dados_viaturas.add(label_bi_funcionario);
    
    txt_num_bi_fun = new CampoTexto();
    txt_num_bi_fun.setTextoFundo("Digite o BI do funcionario");
    txt_num_bi_fun.setFont(font_lbs);
    txt_num_bi_fun.setForeground(cor_font_lbs);
    txt_num_bi_fun.setBounds(400, 165, 350, 25);
    pane_dados_viaturas.add(txt_num_bi_fun);
    
    label_bi_cliente = new JLabel("BI");
    label_bi_cliente.setFont(font_lbs);
    label_bi_cliente.setForeground(cor_font_lbs);
    label_bi_cliente.setBounds(410, 190, 300, 25);
    pane_dados_viaturas.add(label_bi_cliente);
    
    txt_num_bi_cli = new CampoTexto();
    txt_num_bi_cli.setTextoFundo("Digite o BI do Cliente");
    txt_num_bi_cli.setFont(font_lbs);
    txt_num_bi_cli.setForeground(cor_font_lbs);
    txt_num_bi_cli.setBounds(400, 215, 350, 25);
    pane_dados_viaturas.add(txt_num_bi_cli);
    
    label_id_aluguer = new JLabel("ID");
    label_id_aluguer.setFont(font_lbs);
    label_id_aluguer.setForeground(cor_font_lbs);
    label_id_aluguer.setBounds(410, 240, 300, 25);
    pane_dados_viaturas.add(label_id_aluguer);
    
    txt_id_aluguer = new CampoTexto();
    txt_id_aluguer.setTextoFundo("Digite o ID do Aluguer");
    txt_id_aluguer.setFont(font_lbs);
    txt_id_aluguer.setForeground(cor_font_lbs);
    txt_id_aluguer.setBounds(400, 265, 350, 25);
    pane_dados_viaturas.add(txt_id_aluguer);
    
    
   //Defenicao dos butoes
    btn_cadastrar = new Botao("Cadastrar");
    btn_cadastrar.setBackground(new Color(0, 128, 0));
    btn_cadastrar.setBackgroundMouseEntered(new Color(85, 170, 85));
    btn_cadastrar.setForeground(new Color(255, 255, 255));
    btn_cadastrar.setBounds(10, 330, 190, 30);
    pane_dados.add(btn_cadastrar);

    btn_cancelar = new Botao("Cancelar");
    btn_cancelar.setBackground(new Color(255, 0, 0));
    btn_cancelar.setBackgroundMouseEntered(new Color(255, 24, 24));
    btn_cancelar.setForeground(new Color(255, 255, 255));
    btn_cancelar.setBounds(230, 330, 190, 30);
    pane_dados.add(btn_cancelar);
  
    this.getContentPane().add(pane_dados);
    this.setLayout(null);
    this.setSize(828, 462);
    this.setLocationRelativeTo(null);
    this.setMinimumSize(new Dimension(300, 325));
   
}
//Metodo para dos enventos dos botoes
private void eventosButoes() {
   
	btn_cadastrar.addActionListener(
    		new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				boolean passou= false;
    				String inspencao="";
    				String manutencao="";
    				String seguros="";
    						
    				
    				if(passou==false) {
    					
    					String matricula= txt_matricula.getText();
    					String  marca=text_marca.getSelectedItem().toString();
    					String modelo= txt_modelo.getText();
    					int bi_funcionario=Integer.parseInt(txt_num_bi_fun.getText());
    					int  bi_cliente=Integer.parseInt(txt_num_bi_cli.getText());
    					int id_aluguer=Integer.parseInt(txt_id_aluguer.getText());
    					int  preco= Integer.parseInt(txt_preco.getText());
    					
                        if(nao.isSelected())
                        {
                        	seguros="nao";
                        }
                        if(sim.isSelected())
                        {
                        	seguros="sim";
                        }
                        
                        if(resp1.isSelected())
                        {
                        	inspencao="nao";
                        }
                        if(resp2.isSelected())
                        {
                        	inspencao="sim";
                        }
                        if(resposta1.isSelected())
                        {
                        	manutencao="nao";
                        }
                        if(resposta2.isSelected())
                        {
                        	manutencao="sim";
                        }
    					
	    			  Viatura viatura= new Viatura(matricula,marca,modelo,seguros,inspencao,manutencao,preco,bi_funcionario,bi_cliente,id_aluguer);
	    				
	    				ViaturaDAO viaturaDAO= new ViaturaDAO();
	    				viaturaDAO.inserir(viatura);
	    				passou= true;
	    				if(passou==true) {
	    					txt_matricula.setText("");
	    					txt_modelo.setText("");
	    					txt_marca.setText("");
		    	        }
	    				JOptionPane.showMessageDialog(null, "Viatura  Registrado!");
    				}else {
    					JOptionPane.showMessageDialog(null, "Viatura nao registrado! Consulte o erro");
    					passou= false;
    				}
    			}
    		}
    		); 
	
	
	
	
	
	btn_cancelar.addActionListener(new ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      	adicionarPaneis("viatura");
      	
      	
          
      }
  });
} 
  
//Metodo para fazer Layout dos Paines
  private void adicionarPaneis(String opcao) {

      switch (opcao) {

          case "viatura":
              Tela_Viatura t = new Tela_Viatura();
              this.dispose();
              t.show();
              break;
          
   }
  }     


}

