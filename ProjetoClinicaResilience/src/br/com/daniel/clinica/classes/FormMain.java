package br.com.daniel.clinica.classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class FormMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);

		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain window = new FormMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMenuPaciente = new JMenu("Pacientes");
		menuBar.add(mnMenuPaciente);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnMenuPaciente.add(mntmCadastrar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mnMenuPaciente.add(mntmAlterar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnMenuPaciente.add(mntmListar);
		
		JSeparator separator = new JSeparator();
		mnMenuPaciente.add(separator);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mnMenuPaciente.add(mntmExcluir);
	}

}
