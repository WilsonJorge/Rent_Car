package Menu;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import Componentes.Botao;
import SubMenu.Tela_Aluguer;
import SubMenu.Tela_Cliente;
import SubMenu.Tela_Funcionario;
import SubMenu.Tela_Viatura;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
public class Tela_Menu extends JFrame {	
private JLabel label_titulo;
private JPanel pane_principal, pane_conteudo, pane_titulo, pane_menu_lateral,pane_imagem;
private JButton botao_sair;
private LayoutStyle layout;
private Font font, font_menu,font_lb_titulo;
private Botao btn_funcionario, btn_sair, btn_cliente, btn_viatura, btn_home,btn_aluguer;
private String opcao;
private int total;
private Color cor_font;
private ImageIcon  logotipo; 
private JLabel logo;
int x,y;
	   public Tela_Menu() {
        inicializacao();
        eventosButoes();
        layouts();
        
        adicionarPaneis("inicio");

    }

    
    private void inicializacao() {

        font = new Font("Century Gothic", Font.BOLD, 30);
        font_menu = new Font("Century", Font.BOLD, 20);
        Font font_desc = new Font("Times new Roman", Font.BOLD, 17);
        
        
        label_titulo = new JLabel("Sistema de Gestao Rent&Drive");
        label_titulo.setForeground(new Color(255, 255, 255));
        label_titulo.setOpaque(false);
        label_titulo.setSize(400, 40);
        label_titulo.setFont(font);
        label_titulo.setHorizontalAlignment(SwingConstants.CENTER);

        pane_titulo = new JPanel();
        pane_titulo.setLayout(null);
        pane_titulo.setBackground(new Color(51, 71, 72 ));
        pane_titulo.add(label_titulo);

        pane_menu_lateral = new JPanel();
        pane_menu_lateral.setLayout(null);
        pane_menu_lateral.setBackground(new Color(51, 71, 72    ));

        pane_conteudo = new JPanel();
        pane_conteudo.setLayout(null);
        pane_conteudo.setBackground(new Color(255, 255, 255));

        

        btn_home = new Botao("Home");
        btn_home.setBounds(10, 10, 280, 40);
        btn_home.setFont(font_menu);
        btn_home.setForeground(new Color(255, 255, 255));
        btn_home.setBackground(new Color(51, 71, 72));
        btn_home.setBackgroundMouseEntered(new Color(58, 103, 107));
        pane_menu_lateral.add(btn_home);

        btn_funcionario = new Botao("Funcionario");
        btn_funcionario.setBounds(10, 60, 280, 40);
        btn_funcionario.setFont(font_menu);
        btn_funcionario.setForeground(new Color(255, 255, 255));
        btn_funcionario.setBackground(new Color(51, 71, 72    ));
        btn_funcionario.setBackgroundMouseEntered(new Color(58, 103, 107));
        pane_menu_lateral.add(btn_funcionario);

        btn_cliente = new Botao("Cliente");
        btn_cliente.setBounds(10, 110, 280, 40);
        btn_cliente.setFont(font_menu);
        btn_cliente.setForeground(new Color(255, 255, 255));
        btn_cliente.setBackground(new Color(51, 71, 72  ));
        btn_cliente.setBackgroundMouseEntered(new Color(58, 103, 107));
        pane_menu_lateral.add(btn_cliente);

        btn_viatura = new Botao("Viatura");
        btn_viatura.setBounds(10, 160, 280, 40);
        btn_viatura.setFont(font_menu);
        btn_viatura.setForeground(new Color(255, 255, 255));
        btn_viatura.setBackground(new Color(51, 71, 72     ));
        btn_viatura.setBackgroundMouseEntered(new Color(58, 103, 107));
        pane_menu_lateral.add(btn_viatura);
        
        btn_aluguer = new Botao("Aluguer");
        btn_aluguer.setBounds(10, 210, 280, 40);
        btn_aluguer.setFont(font_menu);
        btn_aluguer.setForeground(new Color(255, 255, 255));
        btn_aluguer.setBackground(new Color(51, 71, 72  ));
        btn_aluguer.setBackgroundMouseEntered(new Color(58, 103, 107));
        pane_menu_lateral.add(btn_aluguer);
        
       
        pane_principal = new JPanel();
        pane_principal.setLayout(null);
        pane_principal.setBackground(new Color(255, 255, 255));
        pane_principal.add(pane_titulo);
        pane_principal.add(pane_menu_lateral);
        pane_principal.add(pane_conteudo);
        
        
        
        //Inicio da codificacao do dashboard
        
        pane_imagem= new JPanel(null);
        //pane_imagem.setBackground(new Color(220, 92, 0));
        pane_conteudo.add(pane_imagem);
        
        logotipo=new ImageIcon(getClass().getResource("logo.jpeg"));
		logotipo.setImage(logotipo.getImage().getScaledInstance(x+870, y+650, DO_NOTHING_ON_CLOSE));
		logo=new JLabel(logotipo);
        
        pane_imagem.add(logo);
                
                
        //Fim da codificacao do dashboard
        
        

        this.getContentPane().add(pane_principal);
        this.setSize(1200, 700);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eventosJanela();
        

    }
  
   
    private void layouts() {
        
        //defininicao da localizacao do panel de cabelhalho
        pane_titulo.setSize(this.pane_principal.getWidth() - 5, 50);
        pane_titulo.setLocation((this.getWidth() - pane_titulo.getWidth()) / 2 - 8, 5);

         //defininicao da localizacao da label de cabelhalho
        label_titulo.setSize(pane_titulo.getWidth()-10, 40);
        label_titulo.setLocation((pane_titulo.getWidth() - label_titulo.getWidth()) / 2, 5);

        //defininicao da localizacao do panel de menu
        pane_menu_lateral.setSize(300, pane_principal.getHeight() - 65);
        pane_menu_lateral.setLocation(2, pane_titulo.getHeight() + 10);

        //defininicao da localizacao do panel de conteudos
        int h = pane_menu_lateral.getHeight() - 5;
        int w = this.getWidth() - pane_menu_lateral.getWidth() - 15;
        pane_conteudo.setBounds(310, pane_titulo.getHeight() + 10, w, h);

         x= (pane_conteudo.getWidth() / 3) - 20;
         y = (pane_conteudo.getHeight() / 2) - 60;
        
		pane_imagem.setBounds(10, 20, x+570, y+500);
		logo.setBounds(0, 1, pane_imagem.getWidth()+30, 630);
        
    }

    private void eventosJanela() {

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                layouts();
            }

        });

    }

    //Metodo para dos enventos dos botoes
    private void eventosButoes() {
        btn_funcionario.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarPaneis("funcionario");
            }
        });
        btn_home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                adicionarPaneis("inicio");
            }

        });
        btn_cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                adicionarPaneis("cliente");
            }

        });
        btn_viatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                adicionarPaneis("viatura");
            }

        });
        btn_aluguer.addActionListener(new ActionListener()
        		{
        	       public void actionPerformed(ActionEvent ae)
        	       {
        	    	   adicionarPaneis("aluguer");
        	       }
        		});
        
    }
  //Metodo para fazer Layout dos Paines
    private void adicionarPaneis(String opcao) {

        switch (opcao) {

            case "funcionario":
                Tela_Funcionario t = new Tela_Funcionario();
                this.dispose();
                t.show();
                break;
            case "cliente":
            	Tela_Cliente tela= new Tela_Cliente();
               this.dispose();
               tela.show();
                break;
            case "viatura":
            	Tela_Viatura vista=new Tela_Viatura();
            	this.dispose();
                vista.show();
                break;
                
            case "aluguer":
            	Tela_Aluguer aluguer=new Tela_Aluguer();
            	this.dispose();
            	aluguer.show();
            	
            
                 
        }

    }

    public static void main(String[] args) {
    	try {
			for ( LookAndFeelInfo info : UIManager.getInstalledLookAndFeels() ) {
				if ("Nimbus".equals( info.getName() ) ) {
					UIManager.setLookAndFeel( info.getClassName() );
					break;
				}
			}
		}catch(UnsupportedLookAndFeelException exc){
			exc.printStackTrace();
			
		}catch(ClassNotFoundException exc){
			exc.printStackTrace();
		}catch(InstantiationException exc){
			exc.printStackTrace();
		}catch(IllegalAccessException exc){
			exc.printStackTrace();
		}

		UIManager.put("nimbusBase", new Color(0, 250, 154));
		UIManager.put("nimbusSelection", new Color(133,244,190));
		UIManager.put("control", new Color(253, 253, 253));
		UIManager.put("Menu", new Color(230, 224, 208));
		UIManager.put("nimbusBlueGrey", new Color(153, 240, 249) );
		UIManager.put("Table.font", new Font("Segoe UI", Font.PLAIN, 12));
		UIManager.put("Table.background", new Color(249, 47, 34 ));
		UIManager.put("Menu.background", new Color(64, 224, 208));
		UIManager.put("FileChooser.background", new Color(255, 254, 254 ));
		UIManager.put("Table.background", new Color(115,250,147));
		UIManager.put("Menu.font", new Font("Segoe UI", Font.PLAIN, 12));
		UIManager.put("nimbusFont", new Font("Segoe UI", Font.PLAIN, 50));
		UIManager.put("Button.font", new Font("Segoe UI", Font.PLAIN, 15));
		UIManager.put("TabbedPane.font", new Font("Segoe UI", Font.PLAIN, 15));
    	
    	
    	
    	
    	
    	Tela_Menu tela = new Tela_Menu();
        tela.setVisible(true);
    }

    
}
