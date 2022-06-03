package br.com.daniel.clinica.classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class FormCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblEndereco;
	private JLabel lblEmail;
	private JLabel lblTelefone;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
					FormCadastro frame = new FormCadastro();
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
	public FormCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 28, 89, 25);
		contentPane.add(lblCodigo);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 75, 89, 25);
		contentPane.add(lblNome);

		textField = new JTextField();
		textField.setBounds(83, 28, 265, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(83, 75, 265, 30);
		contentPane.add(textField_1);

		lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(10, 124, 89, 25);
		contentPane.add(lblEndereco);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 165, 89, 25);
		contentPane.add(lblEmail);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 203, 89, 25);
		contentPane.add(lblTelefone);

		textField_2 = new JTextField();
		textField_2.setBounds(83, 122, 265, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(83, 163, 265, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(83, 201, 265, 30);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
