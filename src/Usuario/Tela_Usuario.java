package Usuario;
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
public class Tela_Usuario extends JFrame{
    
	private JPanel pane_principal, pane_titulo,pane_dados,pane_dados_usuarios;
    private JLabel label_titulo, label_id_usuario, label_senha;
   private CampoTexto txt_id_usuario, txt_senha;
   private Font font_lbs, font_lb_titulos;
   private Color cor_font_lbs;
   private Botao btn_cancelar, btn_cadastrar;
   private ButtonGroup btn_grupo;
   private String gerar;
   JComboBox text_raca_animal;
//private TelaEstudante pane;

   public Tela_Usuario()
  { 
	   inicializacao();
  }






public void inicializacao() {
    
    font_lbs = new Font("Century Gothic", Font.BOLD, 13);
    font_lb_titulos = new Font("Century Gothic", Font.BOLD, 18);
    cor_font_lbs = new Color(29, 36, 98);

    pane_titulo = new JPanel(null);
    pane_titulo.setBounds(5, 5, 420, 35);
    pane_titulo.setBackground(new Color(207, 229, 23));

    label_titulo = new JLabel("Cadastro de Usuario");
    label_titulo.setForeground(new Color(255, 255, 255));
    label_titulo.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
    label_titulo.setHorizontalAlignment(SwingConstants.CENTER);
    label_titulo.setBounds(5, 5, 415, 25);
    pane_titulo.add(label_titulo);
    this.add(pane_titulo);

    pane_dados = new JPanel(null);
    pane_dados.setBounds(10, 45, 415, 220);
    pane_dados.setBackground(new Color(255, 255, 255));
    pane_dados.setBorder(new LineBorder(new Color(29, 36, 98), 1));
    this.add(pane_dados);

    pane_dados_usuarios = new JPanel(null);
    pane_dados_usuarios.setBackground(new Color(255, 255, 255));
    pane_dados_usuarios.setBounds(10, 10, 390, 160);
    pane_dados_usuarios.setBorder(new LineBorder(cor_font_lbs, 1));
    pane_dados.add(pane_dados_usuarios);

    JLabel label_dados_usuarios = new JLabel("Dados do Usuario");
    label_dados_usuarios.setOpaque(true);
    label_dados_usuarios.setBounds(5, 5, pane_dados_usuarios.getWidth() - 10, 30);
    label_dados_usuarios.setBackground(new Color(240, 150, 9));
    label_dados_usuarios.setHorizontalAlignment(SwingConstants.CENTER);
    label_dados_usuarios.setForeground(new Color(255, 255, 255));
    label_dados_usuarios.setFont(font_lb_titulos);
    pane_dados_usuarios.add(label_dados_usuarios);

    label_id_usuario = new JLabel("ID do Usuario");
    label_id_usuario.setFont(font_lbs);
    label_id_usuario.setForeground(cor_font_lbs);
    label_id_usuario.setBounds(30, 40, 300, 25);
    pane_dados_usuarios.add(label_id_usuario);

    txt_id_usuario = new CampoTexto();
    txt_id_usuario.setTextoFundo("Digite o ID do Usuario");
    txt_id_usuario.setFont(font_lbs);
    txt_id_usuario.setForeground(cor_font_lbs);
    txt_id_usuario.setBounds(20, 65, 350, 25);
    pane_dados_usuarios.add(txt_id_usuario);

    label_senha = new JLabel("Senha");
    label_senha.setFont(font_lbs);
    label_senha.setForeground(cor_font_lbs);
    label_senha.setBounds(30, 90, 300, 25);
    pane_dados_usuarios.add(label_senha);
    
    txt_id_usuario = new CampoTexto();
    txt_id_usuario.setTextoFundo("Digite a senha do Usuario");
    txt_id_usuario.setFont(font_lbs);
    txt_id_usuario.setForeground(cor_font_lbs);
    txt_id_usuario.setBounds(20, 115, 350, 25);
    pane_dados_usuarios.add(txt_id_usuario);
   
   //Defenicao dos butoes
    btn_cadastrar = new Botao("Cadastrar");
    btn_cadastrar.setBackground(new Color(0, 128, 0));
    btn_cadastrar.setBackgroundMouseEntered(new Color(85, 170, 85));
    btn_cadastrar.setForeground(new Color(255, 255, 255));
    btn_cadastrar.setBounds(9, 180, 190, 30);
    pane_dados.add(btn_cadastrar);

    btn_cancelar = new Botao("Voltar");
    btn_cancelar.setBackground(new Color(255, 0, 0));
    btn_cancelar.setBackgroundMouseEntered(new Color(255, 24, 24));
    btn_cancelar.setForeground(new Color(255, 255, 255));
    btn_cancelar.setBounds(210, 180, 189, 30);
    pane_dados.add(btn_cancelar);
    
    this.getContentPane().add(pane_dados);
    this.setLayout(null);
    this.setSize(450, 295);
    this.setLocationRelativeTo(null);
    this.setMinimumSize(new Dimension(300, 325));
    
}
  public static void main(String[]args)
  {
	  Tela_Usuario tela=new Tela_Usuario();
	  tela.setVisible(true);
	  
  }


}

