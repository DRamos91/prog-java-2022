package br.com.senaisp.aula24.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextPane;

public class FormProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textDescricao;
	private JTextField textPreco;
	private JTextField textCodigo;
	private Produto produto;
	private int operacao; //1-Cadastrar, 2-Alterar, 3-Consultar, 4-Excluir

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProduto frame = new FormProduto();
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
	public FormProduto() {
		setTitle("Manuten\u00E7\u00E3o de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(operacao) {
				case 1: 
					produto.setCodigo(Integer.parseInt(textCodigo.getText()));
					produto.setDescricao(textDescricao.getText());
					produto.setPreco(Double.parseDouble(textPreco.getText()));
					
					
					produto.adicionar();
					break;
				case 2: produto.alterar();break;
				case 3: produto.consultar();break;
				case 4: produto.excluir();break;
				}
				dispose();
			}
		});
		panel.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel pnlCodigo = new JPanel();
		pnlCodigo.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_1.add(pnlCodigo);
		
		JPanel pnlDescricao = new JPanel();
		pnlDescricao.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_1.add(pnlDescricao);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o do Produto");
		pnlDescricao.add(lblDescricao);
		
		textDescricao = new JTextField();
		pnlDescricao.add(textDescricao);
		textDescricao.setColumns(30);
		
		JPanel pnlPreco = new JPanel();
		pnlPreco.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_1.add(pnlPreco);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o do Produto");
		pnlPreco.add(lblPreco);
		
		textPreco = new JTextField();
		pnlPreco.add(textPreco);
		textPreco.setColumns(10);
		
		JLabel lblCodigo = new JLabel ("Código do produto");
		pnlCodigo.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		pnlCodigo.add(textCodigo);
		
	}
	
	public void setProduto(Produto value) {
		produto = value;
		textCodigo.setText(Integer.toString(produto.getCodigo()));
		textDescricao.setText(produto.getDescricao());
		textPreco.setText(Double.toString(produto.getPreco()));
	}
	
	public void setOperacao(int value) {
		if (value < 1 || value >4) {
			JOptionPane.showMessageDialog(null, "Valor inválido ");
		}else {
			operacao = value;
		}
	}
}
