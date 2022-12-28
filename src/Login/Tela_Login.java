package Login;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import DAO.AluguerDAO;
import DAO.UsuarioDAO;
import Entidades.Aluguer;
import Menu.Tela_Menu;
import Tabelas.Tabela_Aluguer;
import Usuario.Entidade_Usuario;
import Usuario.Tela_Usuario;
public class Tela_Login extends JFrame
{
	private JComboBox utilizadorBox;
	private Entidade_Usuario use[];
	private JLabel utilizador, senha, logo;
	private JPasswordField psSenha;
	private JPanel panel,panelLabel, panelbutton;
	private JButton btuRegistar, btuAcessar;
	private int contar=0;
	private ImageIcon  logotipo;
	private Container cont;
	Entidade_Usuario u;
	

	public Tela_Login()  
	{
		super("login");
		cont= getContentPane();
		cont.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel=new JPanel();
		panelLabel=new JPanel();
		panelbutton=new JPanel();
		panel.setLayout(new  BorderLayout(40,40));
		panelLabel.setLayout(new GridLayout(2,2,10,10));
		panelbutton.setLayout(new GridLayout(1,2,10,10));
		cont.add(panel);
		criarJanela();
		
	}
	
	public void criarJanela()
	{
		logotipo=new ImageIcon(getClass().getResource("logo.jpeg"));
		logotipo.setImage(logotipo.getImage().getScaledInstance(160, 160, DO_NOTHING_ON_CLOSE));
		logo=new JLabel(logotipo);
		panel.add(logo,BorderLayout.NORTH);
		utilizador=new JLabel("utilizador");
		panelLabel.add(utilizador);
		
		
	    

	    	UsuarioDAO usuarioDAO= new UsuarioDAO();
	    	List<Entidade_Usuario> lista= usuarioDAO.listar();		
		
		for(int i=0;i<lista.size();i++)
		{
			u=(Entidade_Usuario)lista.get(i);
			if( u instanceof Entidade_Usuario)
			{
				utilizadorBox=new JComboBox((ComboBoxModel) lista);
			}
		}
		
		
		panelLabel.add(utilizadorBox);
		utilizadorBox.setMaximumRowCount(3);
		
		senha=new JLabel("senha");
		panelLabel.add(senha);
		
		psSenha=new JPasswordField(10);
		panelLabel.add(psSenha);
		

		btuRegistar= new JButton("Registar");
		panelbutton.add(btuRegistar);
		
		btuAcessar=  new JButton("Acessar");
		panelbutton.add(btuAcessar);
		
		panel.add(panelLabel,BorderLayout.CENTER);
		panel.add(panelbutton,BorderLayout.SOUTH);
		
		
		//eventos
		
		//evento para validar as credencias e permintir o acesso
		btuAcessar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent x)
					{
						
						for(int i=0;i<lista.size();i++)
						{
							u=(Entidade_Usuario)lista.get(i);
							if( u instanceof Entidade_Usuario)
							{
							
								if(utilizadorBox.getSelectedItem().toString().equalsIgnoreCase(u.getNome()))
								{
									if(psSenha.getText().isEmpty()==false)
									{
										try//Caso tenha Excepções
										{
											if(u.getSenha()==Integer.parseInt(psSenha.getText()))// Verifica se a senha esta correta
											{
												new Tela_Menu();
											}
											else
											{
												psSenha.setBackground(new Color(241, 99, 99));
												JOptionPane.showMessageDialog(null,"A senha do Utilizador está incorreta");
											}
										}catch(NumberFormatException ex) 
										{
											
											psSenha.setBackground(new Color(241, 99, 99));
											JOptionPane.showMessageDialog(null,"A senha deve ter apenas numeros");
												
										}
										
									}
									else
									{
										JOptionPane.showMessageDialog(null,"Introduza a senha");// Caso o campo da senha estiver vazio
										
									}
									
								}
							}
						}
						
					}
				});
		
		//evento para chamar a janela de registar novo Usuario
		btuRegistar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent x)
			{
				dispose();
				new Tela_Usuario();
			}
		});
		
		
		//Cores dos botoes
		btuRegistar.setBackground(new Color(7, 151, 41));
		btuAcessar.setBackground(new Color(23, 120, 152));
		
		btuRegistar.setForeground(Color.white);
		btuAcessar.setForeground(Color.white);
		
		
		panelLabel.setBackground(Color.white);
		panelbutton.setBackground(Color.white);
		cont.setBackground(Color.white);
		
     	setSize(280,400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main (String[]args)
	{
		new Tela_Login();
		
	}

	
	}
	

