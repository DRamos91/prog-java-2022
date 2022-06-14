package br.com.senaisp.aula28.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import br.com.senaisp.aula28.classes.FormCliente.EstadoCivil;

public class FormManutencao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JFormattedTextField fmtTelefone;
	private JFormattedTextField fmtCodigo;
	private JFormattedTextField fmtDtNasc;
	private DefaultTableModel tblMdCli;
	private int linhaSelecionada;
	private int tipoOperacao; // 1 - Criar, 2 - Consultar, 3 - Alterar, 4 - Excluir
	private DateFormat fmtDt;
	private JButton btnConfirmar;
	private JComboBox<EstadoCivil> cmbEstadoCivil;
	private DefaultComboBoxModel<EstadoCivil> modCombo;
	private JFormattedTextField fmtCpf;

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
		EventoClick evt = new EventoClick();

		setTitle("Manuten\u00E7\u00E3o de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setMnemonic('C');
		pnlBotoes.add(btnConfirmar);
		btnConfirmar.addActionListener(evt);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setMnemonic('r');
		pnlBotoes.add(btnCancelar);
		btnCancelar.addActionListener(evt);

		JPanel pnlCorpo = new JPanel();
		contentPane.add(pnlCorpo, BorderLayout.NORTH);
		pnlCorpo.setLayout(new GridLayout(6, 0, 0, 0));

		JPanel pnlCodigo = new JPanel();
		FlowLayout fl_pnlCodigo = (FlowLayout) pnlCodigo.getLayout();
		fl_pnlCodigo.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlCodigo);

		JLabel lblCodigo = new JLabel("C\u00F3digo");
		pnlCodigo.add(lblCodigo);

		NumberFormat fmtNm = NumberFormat.getInstance();
		NumberFormatter fmtNmt = new NumberFormatter(fmtNm);

		fmtNmt.setValueClass(Integer.class);
		fmtNmt.setMinimum(0);
		fmtNmt.setMaximum(Integer.MAX_VALUE);
		fmtNmt.setAllowsInvalid(false);

		fmtCodigo = new JFormattedTextField(fmtNmt);
		fmtCodigo.setColumns(10);
		pnlCodigo.add(fmtCodigo);
		fmtCodigo.setValue(0);

		JPanel pnlNome = new JPanel();
		FlowLayout fl_pnlNome = (FlowLayout) pnlNome.getLayout();
		fl_pnlNome.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlNome);

		JLabel lblNome = new JLabel("Nome");
		pnlNome.add(lblNome);

		textNome = new JTextField();
		pnlNome.add(textNome);
		textNome.setColumns(30);

		JPanel pnlTelefone = new JPanel();
		FlowLayout fl_pnlTelefone = (FlowLayout) pnlTelefone.getLayout();
		fl_pnlTelefone.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlTelefone);

		JLabel lblTelefone = new JLabel("Telefone");
		pnlTelefone.add(lblTelefone);

		try {
			MaskFormatter fmtFone = new MaskFormatter ("(##) #*#### - ####");
			fmtTelefone = new JFormattedTextField(fmtFone);
			pnlTelefone.add(fmtTelefone);
			fmtTelefone.setColumns(10);
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JPanel pnlDataNasc = new JPanel();
		FlowLayout fl_pnlDataNasc = (FlowLayout) pnlDataNasc.getLayout();
		fl_pnlDataNasc.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlDataNasc);

		JLabel lblDataNasc = new JLabel("Data Nascimento");
		pnlDataNasc.add(lblDataNasc);

		fmtDt = new SimpleDateFormat("dd/MM/yyyy");
		DateFormatter fmtDtt = new DateFormatter(fmtDt);

		fmtDtt.setAllowsInvalid(false);
		fmtDtt.setOverwriteMode(true);

		fmtDtNasc = new JFormattedTextField(fmtDtt);
		fmtDtNasc.setColumns(10);
		pnlDataNasc.add(fmtDtNasc);
		fmtDtNasc.setValue(new Date());

		JPanel pnlEstadoCivil = new JPanel();
		FlowLayout fl_pnlEstadoCivil = (FlowLayout) pnlEstadoCivil.getLayout();
		fl_pnlEstadoCivil.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlEstadoCivil);

		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		pnlEstadoCivil.add(lblEstadoCivil);

		modCombo = new DefaultComboBoxModel<EstadoCivil>(EstadoCivil.values());

		cmbEstadoCivil = new JComboBox<EstadoCivil>(modCombo);
		pnlEstadoCivil.add(cmbEstadoCivil);

		JPanel pnlCpf = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlCpf.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlCpf);

		JLabel lblCpf = new JLabel("CPF");
		pnlCpf.add(lblCpf);

		try {
			MaskFormatter fmtDoc = new MaskFormatter("###.###.###-##");
			fmtCpf = new JFormattedTextField(fmtDoc);
			fmtCpf.setColumns(15);
			pnlCpf.add(fmtCpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}

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
			fmtCodigo.setEnabled(false);
			textNome.setEnabled(tipoOperacao == 3);
			fmtTelefone.setEnabled(tipoOperacao == 3);
			fmtDtNasc.setEnabled(tipoOperacao == 3);
			btnConfirmar.setEnabled(tipoOperacao != 2);

			fmtCodigo.setValue(tblMdCli.getValueAt(linhaSelecionada, 0));
			textNome.setText((String) tblMdCli.getValueAt(linhaSelecionada, 1));
			fmtTelefone.setText((String) tblMdCli.getValueAt(linhaSelecionada, 2));
			try {
				Date dtNasc = fmtDt.parse((String) tblMdCli.getValueAt(linhaSelecionada, 3));
				fmtDtNasc.setValue(dtNasc);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			modCombo.setSelectedItem(tblMdCli.getValueAt(linhaSelecionada, 4));
			fmtCpf.setValue(tblMdCli.getValueAt(linhaSelecionada, 5));
		}
	}

	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object cmp = e.getSource();
			switch (((JButton) cmp).getText()) {
			case "Confirmar":
				Date dtNasc = (Date) fmtDtNasc.getValue();
				switch (tipoOperacao) {
				case 1:
					Object it[] = { fmtCodigo.getValue(), textNome.getText(), fmtTelefone.getText(),
							fmtDt.format(dtNasc), modCombo.getSelectedItem(), fmtCpf.getValue() };
					tblMdCli.addRow(it);
					break;
				case 3:
					tblMdCli.setValueAt(textNome.getText(), linhaSelecionada, 1);
					tblMdCli.setValueAt(fmtTelefone.getText(), linhaSelecionada, 2);
					tblMdCli.setValueAt(fmtDt.format(dtNasc), linhaSelecionada, 3);
					tblMdCli.setValueAt(modCombo.getSelectedItem(), linhaSelecionada, 4);
					tblMdCli.setValueAt(fmtCpf.getValue(), linhaSelecionada, 5);
					break;
				case 4:
					tblMdCli.removeRow(linhaSelecionada);
					break;
				}

			case "Cancelar":
				dispose();
			}

		}

	}
}
