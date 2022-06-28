package br.com.senaisp.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Produto {
	
	private int id;
	private String descricao;
	private int saldo;
	private double preco;
	private String local_estoque;
	
	private ConexaoBD conn;
	private boolean haErro;
	private String msgErro;
	
	public Produto () {
		conn = ConexaoBD.getInstance();
		novo();
	}
	
	public boolean create() {
		boolean ret = false;
		String sql = "insert into produtos (descricao, saldo, preco, local_estoque) values (?,?,?,?)";
		try {
			conn.conectarBD();
			PreparedStatement stmt = conn.getConector().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			//Setando os parametros
			stmt.setString(1, descricao);
			stmt.setInt(2, saldo);
			stmt.setDouble(3, preco);
			stmt.setString(4, local_estoque);
			//Executando o comando de inser��o
			int rowsAff = stmt.executeUpdate();
			//log
			System.out.println("Linhas inseridas: " + rowsAff);
			//Obtendo o valor do id gerado
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			id = rs.getInt(1); //S� h� uma coluna, por isso 1
			//Log
			System.out.println("ID -> " + id);
			//Se tudo ocorreu bem, chegou at� aqui e est� tudo certo
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
			//Preparando a instru��o
			PreparedStatement stmt = conn.getConector().prepareStatement(sql);
			//Setando os par�metros
			stmt.setInt(1, id);
			//Executando a instru��o
			ResultSet rs = stmt.executeQuery();
			//Verificando se encontrou o dado
			if (rs.next()) {
				//Log
				System.out.println("Encontrou o registro!");
				id = rs.getInt(1);
				descricao = rs.getString(2);
				saldo = rs.getInt(3);
				preco = rs.getDouble(4);
				local_estoque = rs.getString(5);
				ret = true;
				
			}else {
				//Log
				System.out.println("N�o encontrou o registro!");
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
			//setando os valores
			stmt.setString(1, descricao);
			stmt.setInt(2, saldo);
			stmt.setDouble(3, preco);
			stmt.setString(4, local_estoque);
			stmt.setInt(5, id);
			//Executando a altera��o
			int rowsAff = stmt.executeUpdate();
			//Log
			System.out.println("Linhas alteradas: " + rowsAff);
			//Desconectando do banco de dados
			ret = true;
			conn.desconectarBD();
			
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
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
