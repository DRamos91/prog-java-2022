package br.com.senaisp.aula24.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class FormListarProduto extends JFrame {

	private JPanel contentPane;
	private JTable tblProdutos;
	private DefaultTableModel tblModel;
	private Produto produto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormListarProduto frame = new FormListarProduto();
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
	public FormListarProduto() {
		setTitle("Listagem Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 654, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		String titulos[] = {"Código", "Descrição", "Preço"};
		tblModel = new DefaultTableModel(titulos,0);
		tblProdutos = new JTable(tblModel);
		scrollPane.setViewportView(tblProdutos);
		
		Object dados[]= {10, "Teste", 15.00};
	//	tblModel.addRow(dados);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnClose = new JButton("Fechar");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnClose);
	}
	
	public void setProduto(Produto value) {
		produto = value;
		for (int i=0; i<produto.getListaProdutos().size(); i++){
			Produto it = produto.getListaProdutos().get(i);
			Object item [] = {
					it.getCodigo(),
					it.getDescricao(),
					it.getPreco()};
			tblModel.addRow(item);
		}
	}
}
