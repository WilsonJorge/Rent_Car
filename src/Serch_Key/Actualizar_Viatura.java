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
import SubMenu.Cadastro_Funcionario;
import SubMenu.Cadastro_Viaturas;
import SubMenu.Tela_Funcionario;
import SubMenu.Tela_Viatura;
import Update.Actualizar_Dados_Viatura;
public class Actualizar_Viatura extends JFrame{
    
	private JPanel pane_principal, pane_titulo,pane_dados,pane_dados_viatura; 
    private JLabel label_matricula;
    private CampoTexto txt_matricula;
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

   public Actualizar_Viatura()
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

    pane_dados_viatura = new JPanel(null);
    pane_dados_viatura.setBackground(new Color(255, 255, 255));
    pane_dados_viatura.setBounds(10, 10, 400, 100);
    pane_dados_viatura.setBorder(new LineBorder(cor_font_lbs, 1));
    pane_dados.add(pane_dados_viatura);

    JLabel label_dados_viatura = new JLabel("Pesquisa pela Matricula");
    label_dados_viatura.setOpaque(true);
    label_dados_viatura.setBounds(5, 5,pane_dados_viatura.getWidth() - 10, 30);
    label_dados_viatura.setBackground(new Color(72, 73, 66));
    label_dados_viatura.setHorizontalAlignment(SwingConstants.CENTER);
    label_dados_viatura.setForeground(new Color(255, 255, 255));
    label_dados_viatura.setFont(font_lb_titulos);
    pane_dados_viatura.add(label_dados_viatura);

    label_matricula = new JLabel("Matricula");
    label_matricula.setFont(font_lbs);
    label_matricula.setForeground(cor_font_lbs);
    label_matricula.setBounds(30, 40, 300, 25);
    pane_dados_viatura.add(label_matricula);

    txt_matricula = new CampoTexto();
    txt_matricula.setTextoFundo("Digite a Matricula do Carro");
    txt_matricula.setFont(font_lbs);
    txt_matricula.setForeground(cor_font_lbs);
    txt_matricula.setBounds(20, 65, 350, 25);
    pane_dados_viatura.add(txt_matricula);

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
        	adicionarPaneis("viatura");
        }
  });
}

//Metodo para fazer Layout dos Paines
 private void adicionarPaneis(String opcao) {

    switch (opcao) {

        case "cadastro":
            Actualizar_Dados_Viatura t = new Actualizar_Dados_Viatura();
            this.dispose();
            t.show();
            break;
        
        case "viatura":
        	Tela_Viatura tela = new Tela_Viatura();
            this.dispose();
            tela.show();
            break;

                       
 }
}     


}



