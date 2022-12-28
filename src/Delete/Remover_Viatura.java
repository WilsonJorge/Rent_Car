package Delete;
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
import Menu.Tela_Menu;
import SubMenu.Cadastro_Funcionario;
import SubMenu.Tela_Aluguer;
import SubMenu.Tela_Cliente;
import SubMenu.Tela_Funcionario;
import SubMenu.Tela_Viatura;
import Update.Actualizar_Dados_Aluguer;
import Update.Actualizar_Dados_Clientes;
public class Remover_Viatura extends JFrame{
    
   private JPanel pane_principal, pane_titulo,pane_dados,pane_dados_aluguer; 
   private JLabel label_id_aluguer;
   private CampoTexto txt_id_aluguer;
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

   public Remover_Viatura()
  { 
	   inicializacao();
	   eventosButoes() ;
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

    pane_dados_aluguer = new JPanel(null);
    pane_dados_aluguer.setBackground(new Color(255, 255, 255));
    pane_dados_aluguer.setBounds(10, 10, 400, 100);
    pane_dados_aluguer.setBorder(new LineBorder(cor_font_lbs, 1));
    pane_dados.add(pane_dados_aluguer);

    JLabel label_dados_funcionarios = new JLabel("Pesquisa pela Matricula");
    label_dados_funcionarios.setOpaque(true);
    label_dados_funcionarios.setBounds(5, 5,pane_dados_aluguer.getWidth() - 10, 30);
    label_dados_funcionarios.setBackground(new Color(72, 73, 66));
    label_dados_funcionarios.setHorizontalAlignment(SwingConstants.CENTER);
    label_dados_funcionarios.setForeground(new Color(255, 255, 255));
    label_dados_funcionarios.setFont(font_lb_titulos);
    pane_dados_aluguer.add(label_dados_funcionarios);

    label_id_aluguer = new JLabel("Matricula da Viatura");
    label_id_aluguer.setFont(font_lbs);
    label_id_aluguer.setForeground(cor_font_lbs);
    label_id_aluguer.setBounds(30, 40, 300, 25);
    pane_dados_aluguer.add(label_id_aluguer);

    txt_id_aluguer = new CampoTexto();
    txt_id_aluguer.setTextoFundo("Digite a Matricula da Viatura");
    txt_id_aluguer.setFont(font_lbs);
    txt_id_aluguer.setForeground(cor_font_lbs);
    txt_id_aluguer.setBounds(20, 65, 350, 25);
    pane_dados_aluguer.add(txt_id_aluguer);

       //Defenicao dos butoes
    btn_cadastrar = new Botao("Apagar");
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
        	adicionarPaneis("apagar");
           }
  });
    
    btn_cancelar.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	adicionarPaneis("cancelar");
        }
  });
}

//Metodo para fazer Layout dos Paines
private void adicionarPaneis(String opcao) {

    switch (opcao) {

        case "apagar":
            
            
            break;
        
        case "cancelar":
        	Tela_Viatura tela = new Tela_Viatura();
            this.dispose();
            tela.show();
            break;

                       
 }
}     

  


}
