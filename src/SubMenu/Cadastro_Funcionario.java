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
import DAO.FuncionarioDAO;
import Entidades.Aluguer;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Viatura;

public class Cadastro_Funcionario extends JFrame {

    private JPanel pane_principal, pane_titulo, pane_dados, pane_dados_funcionarios;
    private JLabel label_titulo, label_funcao, label_salario, label_nome_banco, label_numero_banco, label_nome_funcionario, label_bi_funcionario;
    private CampoTexto txt_mome_funcionario, txt_BI, txt_funcao,
            txt_salario, txt_nome_banco, txt_numero_banco;

    private Font font_lbs, font_lb_titulos;
    private Color cor_font_lbs;
    private Botao btn_cancelar, btn_cadastrar;
    private ButtonGroup btn_grupo;
    private Viatura carro;
    private Funcionario funcionario;
    private Cliente cliente;
    private Aluguer aluguer;
    private JComboBox text_funcao, text_nome_banco;
//private TelaEstudante pane;

    public Cadastro_Funcionario() {
        inicializacao();
        eventosButoes();
    }

    public void inicializacao() {

        font_lbs = new Font("Century Gothic", Font.BOLD, 13);
        font_lb_titulos = new Font("Century Gothic", Font.BOLD, 18);
        cor_font_lbs = new Color(29, 36, 98);

        pane_titulo = new JPanel(null);
        pane_titulo.setBounds(5, 5, 430, 35);
        pane_titulo.setBackground(new Color(51, 71, 72));

        label_titulo = new JLabel("Cadastro de Funcionarios");
        label_titulo.setForeground(new Color(255, 255, 255));
        label_titulo.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
        label_titulo.setHorizontalAlignment(SwingConstants.CENTER);
        label_titulo.setBounds(10, 5, 415, 25);
        pane_titulo.add(label_titulo);
        this.add(pane_titulo);

        pane_dados = new JPanel(null);
        pane_dados.setBounds(10, 45, 420, 420);
        pane_dados.setBackground(new Color(255, 255, 255));
        pane_dados.setBorder(new LineBorder(new Color(29, 36, 98), 1));
        this.add(pane_dados);

        pane_dados_funcionarios = new JPanel(null);
        pane_dados_funcionarios.setBackground(new Color(255, 255, 255));
        pane_dados_funcionarios.setBounds(10, 10, 400, 360);
        pane_dados_funcionarios.setBorder(new LineBorder(cor_font_lbs, 1));
        pane_dados.add(pane_dados_funcionarios);

        JLabel label_dados_funcionarios = new JLabel("Dados dos Funcionariso");
        label_dados_funcionarios.setOpaque(true);
        label_dados_funcionarios.setBounds(5, 5, pane_dados_funcionarios.getWidth() - 10, 30);
        label_dados_funcionarios.setBackground(new Color(240, 150, 9));
        label_dados_funcionarios.setHorizontalAlignment(SwingConstants.CENTER);
        label_dados_funcionarios.setForeground(new Color(255, 255, 255));
        label_dados_funcionarios.setFont(font_lb_titulos);
        pane_dados_funcionarios.add(label_dados_funcionarios);

        label_nome_funcionario = new JLabel("Nome");
        label_nome_funcionario.setFont(font_lbs);
        label_nome_funcionario.setForeground(cor_font_lbs);
        label_nome_funcionario.setBounds(30, 40, 300, 25);
        pane_dados_funcionarios.add(label_nome_funcionario);

        txt_mome_funcionario = new CampoTexto();
        txt_mome_funcionario.setTextoFundo("Digite o nome do Funcionario");
        txt_mome_funcionario.setFont(font_lbs);
        txt_mome_funcionario.setForeground(cor_font_lbs);
        txt_mome_funcionario.setBounds(20, 65, 350, 25);
        pane_dados_funcionarios.add(txt_mome_funcionario);

        label_bi_funcionario = new JLabel("BI");
        label_bi_funcionario.setFont(font_lbs);
        label_bi_funcionario.setForeground(cor_font_lbs);
        label_bi_funcionario.setBounds(30, 90, 300, 25);
        pane_dados_funcionarios.add(label_bi_funcionario);

        txt_BI = new CampoTexto();
        txt_BI.setTextoFundo("Digite o BI do funcionario");
        txt_BI.setFont(font_lbs);
        txt_BI.setForeground(cor_font_lbs);
        txt_BI.setBounds(20, 115, 350, 25);
        pane_dados_funcionarios.add(txt_BI);

        label_salario = new JLabel("Salario");
        label_salario.setFont(font_lbs);
        label_salario.setForeground(cor_font_lbs);
        label_salario.setBounds(30, 140, 300, 25);
        pane_dados_funcionarios.add(label_salario);

        txt_salario = new CampoTexto();
        txt_salario.setTextoFundo("Digite o Salario do Funcionario");
        txt_salario.setFont(font_lbs);
        txt_salario.setForeground(cor_font_lbs);
        txt_salario.setBounds(20, 165, 350, 25);
        pane_dados_funcionarios.add(txt_salario);

        label_funcao = new JLabel("Funcao");
        label_funcao.setFont(font_lbs);
        label_funcao.setForeground(cor_font_lbs);
        label_funcao.setBounds(30, 190, 300, 25);
        pane_dados_funcionarios.add(label_funcao);

        text_funcao = new JComboBox<>();
        text_funcao.setBackground(new Color(255, 255, 255));
        text_funcao.setFont(font_lbs);
        text_funcao.setForeground(cor_font_lbs);
        text_funcao.setCursor(new Cursor((Cursor.HAND_CURSOR)));
        text_funcao.setBounds(20, 215, 350, 25);
        text_funcao.setModel(new DefaultComboBoxModel<>(new String[]{"Selecione", "Secretaria(o)"}));
        pane_dados_funcionarios.add(text_funcao);

        label_nome_banco = new JLabel("Nome Banco");
        label_nome_banco.setFont(font_lbs);
        label_nome_banco.setForeground(cor_font_lbs);
        label_nome_banco.setBounds(30, 240, 300, 25);
        pane_dados_funcionarios.add(label_nome_banco);

        text_nome_banco = new JComboBox<>();
        text_nome_banco.setBackground(new Color(255, 255, 255));
        text_nome_banco.setFont(font_lbs);
        text_nome_banco.setForeground(cor_font_lbs);
        text_nome_banco.setCursor(new Cursor((Cursor.HAND_CURSOR)));
        text_nome_banco.setBounds(20, 265, 350, 25);
        text_nome_banco.setModel(new DefaultComboBoxModel<>(new String[]{"Selecione", "BCI", "ABSA"}));
        pane_dados_funcionarios.add(text_nome_banco);

        label_numero_banco = new JLabel("Numero Banco");
        label_numero_banco.setFont(font_lbs);
        label_numero_banco.setForeground(cor_font_lbs);
        label_numero_banco.setBounds(30, 290, 300, 25);
        pane_dados_funcionarios.add(label_numero_banco);

        txt_numero_banco = new CampoTexto();
        txt_numero_banco.setTextoFundo("Digite o numero de Banco");
        txt_numero_banco.setFont(font_lbs);
        txt_numero_banco.setForeground(cor_font_lbs);
        txt_numero_banco.setBounds(20, 315, 350, 25);
        pane_dados_funcionarios.add(txt_numero_banco);

        //Defenicao dos butoes
        btn_cadastrar = new Botao("Cadastrar");
        btn_cadastrar.setBackground(new Color(0, 128, 0));
        btn_cadastrar.setBackgroundMouseEntered(new Color(85, 170, 85));
        btn_cadastrar.setForeground(new Color(255, 255, 255));
        btn_cadastrar.setBounds(10, 380, 190, 30);
        pane_dados.add(btn_cadastrar);

        btn_cancelar = new Botao("Cancelar");
        btn_cancelar.setBackground(new Color(255, 0, 0));
        btn_cancelar.setBackgroundMouseEntered(new Color(255, 24, 24));
        btn_cancelar.setForeground(new Color(255, 255, 255));
        btn_cancelar.setBounds(210, 380, 198, 30);
        pane_dados.add(btn_cancelar);

        this.getContentPane().add(pane_dados);
        this.setLayout(null);
        this.setSize(454, 515);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(300, 325));
    }

//Metodo para dos enventos dos botoes
    private void eventosButoes() {

        btn_cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean passou = false;
                String tipo_cliente = "";

                if (passou == false) {

                    String nome = txt_mome_funcionario.getText();
                    String bi_funcionario = txt_BI.getText();
                    int salario = Integer.parseInt(txt_salario.getText());
                    String funcao = text_funcao.getSelectedItem().toString();
                    Funcionario funcionario = new Funcionario();
                    funcionario.setFuncao(funcao);
                    funcionario.setNomeFuncionario(nome);
                    funcionario.setSalario(salario);
                    funcionario.setNum_BI_Fun(bi_funcionario);
                    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                    funcionarioDAO.inserir(funcionario);
                    passou = true;
                    if (passou == true) {
                        txt_mome_funcionario.setText("");
                        txt_numero_banco.setText("");

                    }
                    JOptionPane.showMessageDialog(null, "Funcionario Registrado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionario nao registrado! Consulte o erro");
                    passou = false;
                }
            }
        }
        );

        btn_cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 dispose();

            }
        });
    }
}
