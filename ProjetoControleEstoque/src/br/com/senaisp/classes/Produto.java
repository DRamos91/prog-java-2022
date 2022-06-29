package br.com.senaisp.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Produto {

	private int id;
	private String descricao;
	private int saldo;
	private double preco;
	private String local_estoque;

	private ConexaoBD conn;
	private boolean haErro;
	private String msgErro;

	public Produto() {
		conn = ConexaoBD.getInstance();
		novo();
	}

	public boolean create() {
		boolean ret = false;
		String sql = "insert into produtos (descricao, saldo, preco, local_estoque) values (?,?,?,?)";
		try {
			conn.conectarBD();
			PreparedStatement stmt = conn.getConector().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			// Setando os parametros
			stmt.setString(1, descricao);
			stmt.setInt(2, saldo);
			stmt.setDouble(3, preco);
			stmt.setString(4, local_estoque);
			// Executando o comando de inserção
			int rowsAff = stmt.executeUpdate();
			// log
			System.out.println("Linhas inseridas: " + rowsAff);
			// Obtendo o valor do id gerado
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			id = rs.getInt(1); // Só há uma coluna, por isso 1
			// Log
			System.out.println("ID -> " + id);
			// Se tudo ocorreu bem, chegou até aqui e está tudo certo
			ret = true;
			conn.desconectarBD();

		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}
		return ret;
	}

	public boolean read() {
		boolean ret = false;
		String sql = "select id, descricao, saldo, preco, local_estoque from produtos where id=?";
		try {
			conn.conectarBD();
			// Preparando a instrução
			PreparedStatement stmt = conn.getConector().prepareStatement(sql);
			// Setando os parâmetros
			stmt.setInt(1, id);
			// Executando a instrução
			ResultSet rs = stmt.executeQuery();
			// Verificando se encontrou o dado
			if (rs.next()) {
				// Log
				System.out.println("Encontrou o registro!");
				id = rs.getInt(1);
				descricao = rs.getString(2);
				saldo = rs.getInt(3);
				preco = rs.getDouble(4);
				local_estoque = rs.getString(5);
				ret = true;

			} else {
				// Log
				System.out.println("Não encontrou o registro!");
			}
			conn.desconectarBD();

		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}

		return ret;
	}

	public boolean update() {
		boolean ret = false;
		String sql = "update produtos set descricao=?, saldo=?, preco=?, local_estoque=? where id=?";
		try {
			conn.conectarBD();
			PreparedStatement stmt = conn.getConector().prepareStatement(sql);
			// setando os valores
			stmt.setString(1, descricao);
			stmt.setInt(2, saldo);
			stmt.setDouble(3, preco);
			stmt.setString(4, local_estoque);
			stmt.setInt(5, id);
			// Executando a alteração
			int rowsAff = stmt.executeUpdate();
			// Log
			System.out.println("Linhas alteradas: " + rowsAff);
			// Desconectando do banco de dados
			ret = true;
			conn.desconectarBD();

		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}

		return ret;
	}

	public boolean delete() {
		boolean ret = false;
		String sql = "delete from produtos where id=?";
		try {
			conn.conectarBD();
			// Preparando a instrução para executar
			PreparedStatement stmt = conn.getConector().prepareStatement(sql);
			// Setando o parametro a ser executado
			stmt.setInt(1, id);
			// Executando a instrução
			int rowsAff = stmt.executeUpdate();
			ret = true;
			// Log
			System.out.println("Registros deletados: " + rowsAff);
			conn.desconectarBD();

		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}

		return ret;
	}

	public boolean findByDescricao(String value) {
		boolean ret = false;
		String sql = "select id, descricao, saldo, preco, local_estoque from produtos where descricao=?";
		try {
			conn.conectarBD();
			// Preparando a instrução
			PreparedStatement stmt = conn.getConector().prepareStatement(sql);
			// Setando o parametro
			stmt.setString(1, value);
			// Executando a Query
			ResultSet rs = stmt.executeQuery();
			// Se encontrou
			if (rs.next()) {
				id = rs.getInt(1);
				descricao = rs.getString(2);
				saldo = rs.getInt(3);
				preco = rs.getDouble(4);
				local_estoque = rs.getString(5);
				ret = true;
			}
			conn.desconectarBD();

		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}

		return ret;
	}

	public DefaultTableModel getListaProdutos() {
		DefaultTableModel ret = null;
		String sql = "select id, descricao, saldo, preco, local_estoque from produtos order by id";//Poderia limitar a quantidade de registros adicionando limit na frente do ID
		try {
			conn.conectarBD();
			//Preparando a instrução
			PreparedStatement stmt = conn.getConector().prepareStatement(sql);
			//Executando a instrução, pois não temos parametros
			ResultSet  rs = stmt.executeQuery();
			//Obtendo informações dos registros que retornaram
			ResultSetMetaData rsm = stmt.getMetaData();
			//Montando o cabeçalho dos dados
			String titulos [] = new String [rsm.getColumnCount()];
			//Obtendo o nome das colunas
			for (int i = 1; i <= rsm.getColumnCount(); i++ ) {
				titulos [i - 1] = rsm.getColumnName(i);
			}
			//Criando o tableModel
			ret = new DefaultTableModel(titulos, 0);
			//Adicionando os registros ao table model
			while(rs.next()) {
				Object obj[] = new Object[rsm.getColumnCount()];
				for (int i = 1; i <= rsm.getColumnCount(); i++ ) {
					obj [i - 1] = rs.getObject(i);
				}
				ret.addRow(obj);
			}
			
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
			System.out.println(e.getMessage());
		}
		
		return ret;
	}
	
	public void novo() {
		id = 0;
		descricao = null;
		saldo = 0;
		preco = 0;
		local_estoque = null;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getLocal_estoque() {
		return local_estoque;
	}

	public void setLocal_estoque(String local_estoque) {
		this.local_estoque = local_estoque;
	}

	public boolean isHaErro() {
		return haErro;
	}

	public void setHaErro(boolean haErro) {
		this.haErro = haErro;
	}

	public String getMsgErro() {
		return msgErro;
	}

	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}

}
