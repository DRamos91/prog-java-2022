package br.com.senaisp.aula28.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class FormMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain frame = new FormMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormMain() {
		EventoClick evt = new EventoClick();

		setTitle("Formul\u00E1rio Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("Cadastros");
		mnCadastro.setMnemonic('C');
		menuBar.add(mnCadastro);

		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mnCadastro.add(mntmClientes);
		mntmClientes.addActionListener(evt);

		JSeparator separator = new JSeparator();
		mnCadastro.add(separator);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mnCadastro.add(mntmSair);
		mntmSair.addActionListener(evt);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object cmp = e.getSource();
			switch (((JMenuItem) cmp).getText()) {
			case "Clientes":
				FormCliente fmtCli = new FormCliente();
				fmtCli.setVisible(true);
				break;
			case "Sair":
				dispose();
			}

		}

	}
}
