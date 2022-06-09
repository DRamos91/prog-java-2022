package br.com.senaisp.aula28.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.NumberFormatter;

public class FormManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textTelefone;
	private JFormattedTextField fmtCodigo;
	private JFormattedTextField fmtDtNasc;
	private DefaultTableModel tblMdCli;
	private int linhaSelecionada;
	private int tipoOperacao; //1 - Criar, 2 - Consultar, 3 - Alterar, 4 - Excluir
	private DateFormat fmtDt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormManutencao frame = new FormManutencao();
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
	public FormManutencao() {
		setTitle("Manuten\u00E7\u00E3o de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setMnemonic('C');
		pnlBotoes.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setMnemonic('r');
		pnlBotoes.add(btnCancelar);

		JPanel pnlCorpo = new JPanel();
		contentPane.add(pnlCorpo, BorderLayout.NORTH);
		pnlCorpo.setLayout(new GridLayout(4, 0, 0, 0));

		JPanel panelCodigo = new JPanel();
		FlowLayout fl_panelCodigo = (FlowLayout) panelCodigo.getLayout();
		fl_panelCodigo.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(panelCodigo);

		JLabel lblCodigo = new JLabel("C\u00F3digo");
		panelCodigo.add(lblCodigo);

		NumberFormat fmtNm = NumberFormat.getInstance();
		NumberFormatter fmtNmt = new NumberFormatter(fmtNm);

		fmtNmt.setValueClass(Integer.class);
		fmtNmt.setMinimum(0);
		fmtNmt.setMaximum(Integer.MAX_VALUE);
		fmtNmt.setAllowsInvalid(false);

		fmtCodigo = new JFormattedTextField(fmtNmt);
		fmtCodigo.setColumns(10);
		panelCodigo.add(fmtCodigo);
		fmtCodigo.setValue(0);

		JPanel panelNome = new JPanel();
		FlowLayout fl_panelNome = (FlowLayout) panelNome.getLayout();
		fl_panelNome.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(panelNome);

		JLabel lblNome = new JLabel("Nome");
		panelNome.add(lblNome);

		textNome = new JTextField();
		panelNome.add(textNome);
		textNome.setColumns(30);

		JPanel panelTelefone = new JPanel();
		FlowLayout fl_panelTelefone = (FlowLayout) panelTelefone.getLayout();
		fl_panelTelefone.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(panelTelefone);

		JLabel lblTelefone = new JLabel("Telefone");
		panelTelefone.add(lblTelefone);

		textTelefone = new JTextField();
		panelTelefone.add(textTelefone);
		textTelefone.setColumns(10);

		JPanel panelDataNasc = new JPanel();
		FlowLayout fl_panelDataNasc = (FlowLayout) panelDataNasc.getLayout();
		fl_panelDataNasc.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(panelDataNasc);

		JLabel lblDataNasc = new JLabel("Data Nascimento");
		panelDataNasc.add(lblDataNasc);

		fmtDt = new SimpleDateFormat("dd/MM/yyyy");
		DateFormatter fmtDtt = new DateFormatter(fmtDt);

		fmtDtt.setAllowsInvalid(false);
		fmtDtt.setOverwriteMode(true);

		fmtDtNasc = new JFormattedTextField(fmtDtt);
		fmtDtNasc.setColumns(10);
		panelDataNasc.add(fmtDtNasc);
		fmtDtNasc.setValue(new Date());
	}

	public void setTblMdCli(DefaultTableModel tblMdCli) {
		this.tblMdCli = tblMdCli;
	}

	public void setLinhaSelecionada(int linhaSelecionada) {
		this.linhaSelecionada = linhaSelecionada;
	}

	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
		switch (tipoOperacao) {
		case 2: 
		case 3:
		case 4:
			fmtCodigo.setValue(tblMdCli.getValueAt(linhaSelecionada, 0));
			textNome.setText((String)tblMdCli.getValueAt(linhaSelecionada, 1));
			textTelefone.setText((String)tblMdCli.getValueAt(linhaSelecionada, 2));
			try {
				Date dtNasc=fmtDt.parse((String) tblMdCli.getValueAt(linhaSelecionada, 3));
				fmtDtNasc.setValue(dtNasc);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	
		}
	}

}
