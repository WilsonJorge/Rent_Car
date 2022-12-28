package SubMenu;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.MaskFormatter;
import Componentes.Botao;
import Componentes.CampoTexto;
import DAO.FuncionarioDAO;
import DAO.ViaturaDAO;
import Delete.Remover_Viatura;
import Entidades.Funcionario;
import Entidades.Viatura;
import Menu.Tela_Menu;
import Serch_Key.Actualizar_Funcionario;
import Serch_Key.Actualizar_Viatura;
import Tabelas.Tabela_Funcionario;
import Tabelas.Tabela_Viatura;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
public class Tela_Viatura extends JFrame {
	private JTable tabela_funcionario,tabela_viatura;
    private CampoTexto txt_pesquisa, txt_pesq_viatura,txt_viatura_sel;
    private JPanel pane_butoes, pane_conteudo, pane_conteiner, pane_menu_lateral, pane_titulo;
    private JLabel label_titulo;
    private Botao btn_novo, btn_editar, btn_remover, btn_info, btn_listar;
    private Font font_botao, font_titulo, font_menu;
    private Color cor_font_botao;
    private JComboBox<String> cb_opcoes_pesquisa;
    private JScrollPane pane_tabela_funcionario,pane_tabela_viatura;
    private Tabela_Viatura model;
    private Tela_Viatura pane;
    private List<Viatura> lista;
    private Viatura carro;
    private Botao btn_sair, btn_home;
    private int indice;
    JTable  tabela_aluguer;
    JScrollPane pane_tabela_aluguer;
    
    public Tela_Viatura()
    {
    	inicializacao();
    	eventosButoes();
    	//preencherTabela();
    }
    //Metodo para inicializacao do container
    private void inicializacao() {
        font_botao = new Font("Century", Font.BOLD, 16);
        cor_font_botao = new Color(255, 255, 255);

        font_titulo = new Font("Century Gothic", Font.BOLD, 20);
        font_menu = new Font("Century", Font.BOLD, 20);

        label_titulo = new JLabel("Sistema de Registo Rent&Drive");
        label_titulo.setForeground(new Color(255, 255, 255));
        label_titulo.setOpaque(false);
        label_titulo.setSize(400, 40);
        label_titulo.setFont(font_titulo);
        label_titulo.setHorizontalAlignment(SwingConstants.CENTER);

        pane_titulo = new JPanel();
        pane_titulo.setLayout(null);
        pane_titulo.setBackground(new Color(51, 71, 72));
        pane_titulo.add(label_titulo);

        pane_menu_lateral = new JPanel();
        pane_menu_lateral.setLayout(null);
        pane_menu_lateral.setBackground(new Color(51, 71, 72  ));

        btn_home = new Botao("Home");
        btn_home.setBounds(10, 10, 280, 40);
        btn_home.setFont(font_menu);
        btn_home.setForeground(new Color(255, 255, 255));
        btn_home.setBackground(new Color(51, 71, 72  ));
        btn_home.setBackgroundMouseEntered(new Color(51, 71, 72));
        pane_menu_lateral.add(btn_home);
        
      //inicializacao do campo pesquisa de um  funcionario
        txt_pesq_viatura = new CampoTexto();
        txt_pesq_viatura.setTextoFundo("Digite a Matricula da Viatura");
        txt_pesq_viatura.setFont(new Font("Century Gothic", Font.BOLD, 12));
        txt_pesq_viatura.setForeground(new Color(29, 36, 98));
        pane_menu_lateral.add(txt_pesq_viatura);

        //inicializacao do scrolpane para tabela Viatura
        pane_tabela_aluguer = new JScrollPane();
        pane_tabela_aluguer.setBackground(Color.WHITE);
        pane_menu_lateral.add(pane_tabela_aluguer);

        //inicializacao da tabela Viatura
        tabela_aluguer= new JTable();
        tabela_aluguer.setBackground(new Color(255, 255, 255));
        tabela_aluguer.setFont(new Font("Centuary Gothic", Font.BOLD, 13));
        tabela_aluguer.setGridColor(new Color(75, 130, 181));
        tabela_aluguer.getTableHeader().setFont(new Font("Centuary Gothic", Font.BOLD, 15));
        tabela_aluguer.getTableHeader().setBackground(new Color(160, 196, 229));
        tabela_aluguer.getTableHeader().setForeground(new Color(29, 36, 98));
        tabela_aluguer.setRowHeight(25);
        pane_tabela_aluguer.setViewportView(tabela_aluguer);

        //inicializacao da caixa do texto para mostara a viatura  selecionada
        txt_viatura_sel= new CampoTexto();
        txt_viatura_sel.setEditable(false);
        txt_viatura_sel.setBackground(new Color(240, 240, 240));
        txt_viatura_sel.setForeground(new Color(80, 80, 80));
        txt_viatura_sel.setFont(new Font("Centuary Gothic", Font.BOLD, 13));
        pane_menu_lateral.add(txt_viatura_sel);
        
        //inicializacao do botao para listar o carro  selecionado
        btn_listar = new Botao("Viatura Selecionada");
        btn_listar.setFont(new Font("Centuary Gothic", Font.BOLD, 13));
        btn_listar.setFocusPainted(false);
        btn_listar.setBackground(new Color(51, 71, 72  ));
        btn_listar.setBackgroundMouseEntered(new Color(7, 151, 41));
        btn_listar.setForeground(cor_font_botao);
        pane_menu_lateral.add(btn_listar);
        
        //inicializacao do painel de conteudo (painel que carrgea a tabela da listagem da viatura )
        pane_conteudo = new JPanel();
        pane_conteudo.setBackground(new Color(255, 255, 255));
        pane_conteudo.setSize(800, 500);
        pane_conteudo.setBorder(new LineBorder(new Color(0, 0, 0), 2));

      //inicializacao do painel de botoes(botoes que fazem CRUD da Viatura)
        pane_butoes = new JPanel();
        pane_butoes.setLayout(null);
        pane_butoes.setBackground(cor_font_botao);
        pane_butoes.setBorder(new LineBorder(new Color(29, 36, 98), 1, true));

        btn_novo = new Botao("CREATE");
        btn_novo.setFont(font_botao);
        btn_novo.setFocusPainted(false);
        btn_novo.setBackground(new Color(240, 150, 9  ));
        btn_novo.setBackgroundMouseEntered(new Color(38, 180, 45));
        btn_novo.setForeground(cor_font_botao);
        pane_butoes.add(btn_novo);

        btn_editar = new Botao("UPDATE");
        btn_editar.setFont(font_botao);
        btn_editar.setFocusPainted(false);
        btn_editar.setBackground(new Color(240, 150, 9  ));
        btn_editar.setBackgroundMouseEntered(new Color(253, 172, 85));
        btn_editar.setForeground(cor_font_botao);
        pane_butoes.add(btn_editar);

        btn_info = new Botao("READ");
        btn_info.setFont(font_botao);
        btn_info.setFocusPainted(false);
        btn_info.setBackground(new Color(240, 150, 9 ));
        btn_info.setBackgroundMouseEntered(new Color(96, 176, 255));
        btn_info.setForeground(cor_font_botao);
        pane_butoes.add(btn_info);

        btn_remover = new Botao("DELETE");
        btn_remover.setFont(font_botao);
        btn_remover.setFocusPainted(false);
        btn_remover.setBackground(new Color(240, 150, 9 ));
        btn_remover.setBackgroundMouseEntered(new Color(255, 56, 56));
        btn_remover.setForeground(cor_font_botao);
        pane_butoes.add(btn_remover);
        
        txt_pesquisa = new CampoTexto();
        txt_pesquisa.setTextoFundo("Digite aqui para pesquisar uma Viatura");
        txt_pesquisa.setFont(new Font("Century Gothic", Font.BOLD, 13));
        txt_pesquisa.setForeground(new Color(29, 36, 98));

        String opcoes[] = new String[]{"Pesquisa pela Matricula",
             "Pesquisa pelo ID do Cliente","Pesquisa pelo ID do Funcionario"};
        cb_opcoes_pesquisa = new JComboBox<>();
        cb_opcoes_pesquisa.setModel(new DefaultComboBoxModel<>(opcoes));
        cb_opcoes_pesquisa.setFont(new Font("Times new Roman", Font.BOLD, 14));
        cb_opcoes_pesquisa.setBackground(new Color(255, 255, 255));
        cb_opcoes_pesquisa.setForeground(new Color(29, 36, 98));
        cb_opcoes_pesquisa.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pane_tabela_viatura = new JScrollPane();
        pane_tabela_viatura.setBackground(cor_font_botao);

        tabela_viatura = new JTable();
        tabela_viatura.setBackground(new Color(255, 255, 255));
        tabela_viatura.setFont(new Font("Centuary Gothic", Font.BOLD, 13));
        tabela_viatura.setGridColor(new Color(75, 130, 181));
        tabela_viatura.getTableHeader().setFont(new Font("Centuary Gothic", Font.BOLD, 15));
        tabela_viatura.getTableHeader().setBackground(new Color(160, 196, 229));
        tabela_viatura.getTableHeader().setForeground(new Color(29, 36, 98));
        tabela_viatura.setRowHeight(25);
        pane_tabela_viatura.setViewportView(tabela_viatura);
        pane_conteudo.add(pane_tabela_viatura);

        pane_conteudo.add(txt_pesquisa);
        pane_conteudo.add(cb_opcoes_pesquisa);
        pane_conteudo.add(pane_butoes);
        
        pane_conteiner = new JPanel();
        pane_conteiner.setBackground(new Color(255, 255, 255));
        pane_conteiner.add(pane_titulo);
        pane_conteiner.add(pane_menu_lateral);
        pane_conteiner.add(pane_conteudo);
        
        this.setSize(1200, 700);
        this.getContentPane().add(pane_conteiner);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(700, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eventos();
    }
    //Metodo para Layouts
    public void layouts() {
        int x, y, w, h;
        x = (pane_conteiner.getWidth() - pane_titulo.getWidth()) / 2;
        w = pane_conteiner.getWidth() - 8;

        pane_titulo.setBounds(5, 5, w, 50);

        w = pane_titulo.getWidth() - 10;

        label_titulo.setBounds(5, 5, w, 40);

        y = pane_titulo.getHeight() + 10;
        h = pane_conteiner.getHeight() - 65;
        pane_menu_lateral.setBounds(2, y, 300, h);
        
        
        
     // localizacao do campo pesquisa de uma determinada viatura pela(matricula)
        txt_pesq_viatura.setBounds(10, 80, 280, 25);
        
     // definicao da localizacao da tabela aluguer
        h = pane_menu_lateral.getHeight() - 200;
        y = txt_pesq_viatura.getHeight() + txt_pesq_viatura.getY() + 10;
        pane_tabela_aluguer.setBounds(10, y, 280, h);
        tabela_aluguer.setSize(pane_tabela_aluguer.getSize());
     

       //definicao da localizacao campo viatura selecionadas
       int y1=h+y+10;
        txt_viatura_sel.setBounds(10, y1, 280, 27);
        
        //definicao da localizacao do botao da listagem da viatura selecionada
        btn_listar.setBounds(15, y1+35, 270, 25); 
        
        h = pane_menu_lateral.getHeight() - 5;
        w = pane_conteiner.getWidth() - pane_menu_lateral.getWidth() - 15;

        pane_conteudo.setBounds(310, pane_titulo.getHeight() + 10, w, h);

        w = pane_conteudo.getWidth() - 10;
        pane_butoes.setBounds(5, 5, w, 50);

        w = pane_conteudo.getWidth() / 2;
        y = pane_butoes.getHeight() + pane_butoes.getY() + 15;
        txt_pesquisa.setBounds(15, y, w + 120, 30);

        x = txt_pesquisa.getX() + txt_pesquisa.getWidth() + 20;
        cb_opcoes_pesquisa.setBounds(x, txt_pesquisa.getY(), w - 160, 30);

        w = pane_conteudo.getWidth() - 15;
        h = pane_conteudo.getHeight() - pane_butoes.getHeight() - txt_pesquisa.getHeight() - 50;
        y = txt_pesquisa.getY() + txt_pesquisa.getHeight() + 20;

        pane_tabela_viatura.setBounds(10, y, w, h);
        tabela_viatura.setBounds(0, 0, w, h);

        x = (pane_butoes.getWidth() / 4) - 13;

        btn_novo.setSize(x, 30);
        btn_novo.setLocation(12, (pane_butoes.getHeight() - btn_novo.getHeight()) / 2);

        y = (pane_butoes.getHeight() - btn_novo.getHeight()) / 2;
        btn_editar.setSize(x, 30);
        btn_editar.setLocation(btn_novo.getX() + btn_novo.getWidth() + 10, y);

        btn_info.setSize(x, 30);
        btn_info.setLocation(btn_editar.getX() + btn_editar.getWidth() + 10, y);

        btn_remover.setSize(x, 30);
        btn_remover.setLocation(btn_info.getX() + btn_info.getWidth() + 10, y);

           
    }
    
  //Metodo para fazer Tabela 
    public void preencherTabela() {

    	ViaturaDAO viaturaDAO= new ViaturaDAO();
    	List<Viatura> lista= viaturaDAO.listar();
        model = new Tabela_Viatura(lista);
        tabela_viatura.setModel(model);

        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < model.getColumnCount(); i++) {
        	tabela_viatura.getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }
    
    //Metodo para fazer os enventos das do layout
    public void eventos() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                layouts();
            }

        });
        
       
    }
    private void eventosButoes() {
        btn_home.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               Tela_Menu tela=new Tela_Menu(); 
               tela.dispose();
               tela.show();
               }
      });
        
        btn_novo.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               Cadastro_Viaturas cada=new Cadastro_Viaturas(); 
               cada.dispose();
               cada.show();
               }
      });
       
        btn_editar.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               Actualizar_Viatura actualizar=new Actualizar_Viatura(); 
               actualizar.dispose();
               actualizar.show();
               }
      });
        btn_info.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               preencherTabela();
               }
        }
        );
        
        btn_remover.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               Remover_Viatura remover=new Remover_Viatura(); 
               remover.dispose();
               remover.show();
               }
      });

     
    }
    
    


    
    
    
}  