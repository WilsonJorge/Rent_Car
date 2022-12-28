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
import DAO.FuncionarioDAO;
import Entidades.Aluguer;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Viatura;
import SubMenu.Cadastro_Funcionario;
import SubMenu.Tela_Funcionario;
import Update.Actualizar_Dados_Funcionario;
public class Actualizar_Funcionario extends JFrame{
    
	private JPanel pane_principal, pane_titulo,pane_dados,pane_dados_funcionario; 
    private JLabel label_bi_funcionario;
    private CampoTexto txt_bi_funcionario;
   private Font font_lbs, font_lb_titulos;
   private Color cor_font_lbs;
   private Botao btn_cancelar, btn_cadastrar;
   private ButtonGroup btn_grupo;
   private Viatura carro;
   private Funcionario funcionario;
   private Cliente cliente;   
   private Aluguer aluguer;
   JComboBox text_raca_animal;
   private List<Funcionario> lista;
//private TelaEstudante pane;

   public Actualizar_Funcionario()
  { 
	   inicializacao();
	   eventosButoes();
	   //adicionarPaneis("inicio");
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

    pane_dados_funcionario = new JPanel(null);
    pane_dados_funcionario.setBackground(new Color(255, 255, 255));
    pane_dados_funcionario.setBounds(10, 10, 400, 100);
    pane_dados_funcionario.setBorder(new LineBorder(cor_font_lbs, 1));
    pane_dados.add(pane_dados_funcionario);

    JLabel label_dados_funcionarios = new JLabel("Pesquisa pelo BI do Funcionario");
    label_dados_funcionarios.setOpaque(true);
    label_dados_funcionarios.setBounds(5, 5,pane_dados_funcionario.getWidth() - 10, 30);
    label_dados_funcionarios.setBackground(new Color(72, 73, 66));
    label_dados_funcionarios.setHorizontalAlignment(SwingConstants.CENTER);
    label_dados_funcionarios.setForeground(new Color(255, 255, 255));
    label_dados_funcionarios.setFont(font_lb_titulos);
    pane_dados_funcionario.add(label_dados_funcionarios);

    label_bi_funcionario = new JLabel("BI do Funcionario");
    label_bi_funcionario.setFont(font_lbs);
    label_bi_funcionario.setForeground(cor_font_lbs);
    label_bi_funcionario.setBounds(30, 40, 300, 25);
    pane_dados_funcionario.add(label_bi_funcionario);

    txt_bi_funcionario = new CampoTexto();
    txt_bi_funcionario.setTextoFundo("Digite o BI do funcionario");
    txt_bi_funcionario.setFont(font_lbs);
    txt_bi_funcionario.setForeground(cor_font_lbs);
    txt_bi_funcionario.setBounds(20, 65, 350, 25);
    pane_dados_funcionario.add(txt_bi_funcionario);

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
            boolean passou=false;
            FuncionarioDAO fun=new FuncionarioDAO();
            lista=fun.listar();
            for(int i=0;i<lista.size();i++)
            {
                if(lista.get(i).getBI_Funcionario().equalsIgnoreCase(txt_bi_funcionario.getText()))
                {
                   adicionarPaneis("cadastro",i); 
                   passou=true; 
                }
            }
            if(passou==false)
            {
                JOptionPane.showMessageDialog(null,"Pesquisa nao encontrado");
            }
           
        	
           }
  });
    
    btn_cancelar.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	adicionarPaneis("funcionario",0);
        }
  });
}

//Metodo para fazer Layout dos Paines
private void adicionarPaneis(String opcao,int ops) {

    switch (opcao) {

        case "cadastro":
            Actualizar_Dados_Funcionario t = new Actualizar_Dados_Funcionario();
            t.dadosSet(lista, ops);
            this.dispose();
          
            break;
        
        case "funcionario":
        	Tela_Funcionario tela = new Tela_Funcionario();
            this.dispose();
            tela.show();
            break;

                       
 }
}     
 


}
