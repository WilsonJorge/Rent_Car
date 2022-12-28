package Serch_Key;
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
import Entidades.Aluguer;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Viatura;
import SubMenu.Cadastro_Cliente;
import SubMenu.Cadastro_Funcionario;
import SubMenu.Tela_Cliente;
import SubMenu.Tela_Funcionario;
import Update.Actualizar_Dados_Clientes;
public class Actualizar_Cliente extends JFrame{
    
	private JPanel pane_principal, pane_titulo,pane_dados,pane_dados_cliente; 
    private JLabel label_bi_cliente;
    private CampoTexto txt_bi_cliente;
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

   public Actualizar_Cliente()
  { 
	   inicializacao();
	   eventosButoes();
	   adicionarPaneis("inicio");
  }






public void inicializacao() {
    
    font_lbs = new Font("Century Gothic", Font.BOLD, 13);
    font_lb_titulos = new Font("Century Gothic", Font.BOLD, 18);
    cor_font_lbs = new Color(29, 36, 98);

    
    pane_dados = new JPanel(null);
    pane_dados.setBounds(10, 10, 420, 260);
    pane_dados.setBackground(new Color(255, 255, 255));
    pane_dados.setBorder(new LineBorder(new Color(29, 36, 98), 1));
    this.add(pane_dados);

    pane_dados_cliente = new JPanel(null);
    pane_dados_cliente.setBackground(new Color(255, 255, 255));
    pane_dados_cliente.setBounds(10, 10, 400, 100);
    pane_dados_cliente.setBorder(new LineBorder(cor_font_lbs, 1));
    pane_dados.add(pane_dados_cliente);

    JLabel label_dados_clientes = new JLabel("Pesquisa pelo BI do Cliente");
    label_dados_clientes.setOpaque(true);
    label_dados_clientes.setBounds(5, 5,pane_dados_cliente.getWidth() - 10, 30);
    label_dados_clientes.setBackground(new Color(72, 73, 66));
    label_dados_clientes.setHorizontalAlignment(SwingConstants.CENTER);
    label_dados_clientes.setForeground(new Color(255, 255, 255));
    label_dados_clientes.setFont(font_lb_titulos);
    pane_dados_cliente.add(label_dados_clientes);

    label_bi_cliente = new JLabel("BI do Cliente");
    label_bi_cliente.setFont(font_lbs);
    label_bi_cliente.setForeground(cor_font_lbs);
    label_bi_cliente.setBounds(30, 40, 300, 25);
    pane_dados_cliente.add(label_bi_cliente);

    txt_bi_cliente = new CampoTexto();
    txt_bi_cliente.setTextoFundo("Digite o BI do Cliente");
    txt_bi_cliente.setFont(font_lbs);
    txt_bi_cliente.setForeground(cor_font_lbs);
    txt_bi_cliente.setBounds(20, 65, 350, 25);
    pane_dados_cliente.add(txt_bi_cliente);

       //Defenicao dos butoes
    btn_cadastrar = new Botao("Pesquisar");
    btn_cadastrar.setBackground(new Color(0, 128, 0));
    btn_cadastrar.setBackgroundMouseEntered(new Color(85, 170, 85));
    btn_cadastrar.setForeground(new Color(255, 255, 255));
    btn_cadastrar.setBounds(10, 220, 190, 30);
    pane_dados.add(btn_cadastrar);

    btn_cancelar = new Botao("Cancelar");
    btn_cancelar.setBackground(new Color(255, 0, 0));
    btn_cancelar.setBackgroundMouseEntered(new Color(255, 24, 24));
    btn_cancelar.setForeground(new Color(255, 255, 255));
    btn_cancelar.setBounds(210, 220, 198, 30);
    pane_dados.add(btn_cancelar);
    
    this.getContentPane().add(pane_dados);
    this.setLayout(null);
    this.setSize(454, 50);
    this.setLocationRelativeTo(null);
    this.setMinimumSize(new Dimension(300, 325));
   
}
private void eventosButoes() {
    btn_cadastrar.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	adicionarPaneis("cadastro");
           }
  });
    
    btn_cancelar.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	adicionarPaneis("cliente");
        }
  });
}

//Metodo para fazer Layout dos Paines
private void adicionarPaneis(String opcao) {

    switch (opcao) {

        case "cadastro":
            Actualizar_Dados_Clientes t = new Actualizar_Dados_Clientes();
            this.dispose();
            t.show();
            break;
        
        case "cliente":
        	Tela_Cliente tela = new Tela_Cliente();
            this.dispose();
            tela.show();
            break;

                       
 }
}     


}
