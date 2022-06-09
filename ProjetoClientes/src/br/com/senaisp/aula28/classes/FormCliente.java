package br.com.senaisp.aula28.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormCliente extends JFrame {

	private JPanel contentPane;
	private JTable tblClientes;
	private DefaultTableModel tblMdCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCliente frame = new FormCliente();
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
	public FormCliente() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);

		JButton btnAdicionar = new JButton("Adicionar");
		panelBotoes.add(btnAdicionar);

		JButton btnConsultar = new JButton("Consultar");
		panelBotoes.add(btnConsultar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormManutencao fmtCli = new FormManutencao();
				fmtCli.setTblMdCli(tblMdCli);
				fmtCli.setLinhaSelecionada(tblClientes.getSelectedRow());
				fmtCli.setTipoOperacao(3);
				fmtCli.setVisible(true);
			}
		});
		panelBotoes.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		panelBotoes.add(btnExcluir);

		JScrollPane scrTabela = new JScrollPane();
		contentPane.add(scrTabela, BorderLayout.CENTER);

		String titulos[] = { "Código", "Nome", "Telefone", "Data de Nascimento" };
		tblMdCli = new DefaultTableModel(titulos, 0) {

			// Desabilitando o modo edição das células
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tblClientes = new JTable(tblMdCli) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component cmp = super.prepareRenderer(renderer, row, column);
				if (!isCellSelected(row, column)) {
					cmp.setBackground(row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
				}
				// Alinhando a coluna código
				if (column == 0) {
					((JLabel) cmp).setHorizontalAlignment(SwingConstants.RIGHT);
				}else {
					((JLabel) cmp).setHorizontalAlignment(SwingConstants.LEFT);
				}
				//Colocando o espaçamento entre a borda da célula e o conteúdo
				((JLabel) cmp).setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
				
				return cmp;
			}
		};
		scrTabela.setViewportView(tblClientes);

		// Obtendo objeto calendario para utilizar datas
		Calendar cal = Calendar.getInstance();
		// Obtendo objeto formatador de datas
		DateFormat fmtDt = new SimpleDateFormat("dd/MM/yyyy");

		for (int lin = 1; lin <= 5; lin++) {
			// Colocando a data para dia (variando de 1 a 5), mês 1 e ano 1980
			cal.set(1980, 0, lin);
			Date dtNasc = cal.getTime();
			Object item[] = { lin, "Cliente " + lin, "14 99999-9999 ", fmtDt.format(dtNasc) };
			// Adicionando os itens à linha conjunto de dados
			tblMdCli.addRow(item);
		}
	}

}
