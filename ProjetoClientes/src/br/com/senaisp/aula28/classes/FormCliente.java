package br.com.senaisp.aula28.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

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

public class FormCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		EventoClick evt = new EventoClick();

		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);

		JButton btnAdicionar = new JButton("Adicionar");
		panelBotoes.add(btnAdicionar);
		btnAdicionar.addActionListener(evt);

		JButton btnConsultar = new JButton("Consultar");
		panelBotoes.add(btnConsultar);
		btnConsultar.addActionListener(evt);

		JButton btnAlterar = new JButton("Alterar");
		panelBotoes.add(btnAlterar);
		btnAlterar.addActionListener(evt);

		JButton btnExcluir = new JButton("Excluir");
		panelBotoes.add(btnExcluir);
		btnExcluir.addActionListener(evt);

		JScrollPane scrTabela = new JScrollPane();
		contentPane.add(scrTabela, BorderLayout.CENTER);

		String titulos[] = { "Código", "Nome", "Telefone", "Data de Nascimento", "Estado Civil", "CPF" };
		tblMdCli = new DefaultTableModel(titulos, 0) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			// Desabilitando o modo edição das células
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tblClientes = new JTable(tblMdCli) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component cmp = super.prepareRenderer(renderer, row, column);
				if (!isCellSelected(row, column)) {
					cmp.setBackground(row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
				}
				// Alinhando a coluna código
				if (column == 0) {
					((JLabel) cmp).setHorizontalAlignment(SwingConstants.RIGHT);
				} else {
					((JLabel) cmp).setHorizontalAlignment(SwingConstants.LEFT);
				}
				// Colocando o espaçamento entre a borda da célula e o conteúdo
				((JLabel) cmp).setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

				return cmp;
			}
		};
		tblClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblClientes.getColumnModel().getColumn(0).setPreferredWidth(70);
		tblClientes.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblClientes.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblClientes.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblClientes.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		scrTabela.setViewportView(tblClientes);

		// Obtendo objeto calendario para utilizar datas
		Calendar cal = Calendar.getInstance();
		// Obtendo objeto formatador de datas
		DateFormat fmtDt = new SimpleDateFormat("dd/MM/yyyy");
		cal.set(1980, 0, 18);
		Random rdm = new Random();
		for (int lin = 1; lin <= 100; lin++) {
			cal.add(Calendar.DATE, 1);
			// Colocando a data para dia (variando de 1 a 5), mês 1 e ano 1980
			Date dtNasc = cal.getTime();
			Object item[] = { lin, "Cliente " + lin, "14 99999-9999 ", fmtDt.format(dtNasc),
					EstadoCivil.values()[rdm.nextInt(5)], "000.000.000-00" };
			// Adicionando os itens à linha conjunto de dados
			tblMdCli.addRow(item);
		}
	}

	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object cmp = e.getSource();
			FormManutencao fmtCli = new FormManutencao();
			fmtCli.setTblMdCli(tblMdCli);
			switch (((JButton) cmp).getText()) {
			case "Adicionar":
				fmtCli.setTipoOperacao(1);
				break;
			case "Consultar":
				fmtCli.setLinhaSelecionada(tblClientes.getSelectedRow());
				fmtCli.setTipoOperacao(2);
				break;
			case "Alterar":
				fmtCli.setLinhaSelecionada(tblClientes.getSelectedRow());
				fmtCli.setTipoOperacao(3);
				break;
			case "Excluir":
				fmtCli.setLinhaSelecionada(tblClientes.getSelectedRow());
				fmtCli.setTipoOperacao(4);
				break;
			}

			fmtCli.setVisible(true);
		}

	}

	public enum EstadoCivil {
		Solteiro, Casado, Separado, Divorciado, Viuvo
	}
}
