package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sistema.Conexao;

public class ClienteDAO {

	Conexao mysql = new Conexao();

	/**
	 * Salva o cliente no banco de dados
	 * @param c - Entidade cliente
	 */
	public void criarCliente(Cliente c) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = conexao.prepareStatement("INSERT INTO prisma.cliente" 
					+ "(nome,empresa,telefone,endereco,email,"
					+ "data_nascimento,cnpj,cpf,observacoes) VALUES (?,?,?,?,?,?,?,?,?);");

			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEmpresa());
			stmt.setString(3, c.getTelefone());
			stmt.setString(4, c.getEndereco());
			stmt.setString(5, c.getEmail());
			stmt.setString(6, c.getDataNascimento());
			stmt.setString(7, c.getCnpj());
			stmt.setString(8, c.getCpf());
			stmt.setString(9, c.getObservacoes());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar!" + e);
		} 
		finally {
			Conexao.closeConnection(conexao, stmt);
		}
	}

	/**
	 * Retorna uma lista dos clientes cadastrados
	 * @return - a lista de clientes
	 */
	public List<Cliente> lerTabela(){
		Connection conexao = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			stmt = conexao.prepareStatement("SELECT * FROM cliente");
			rs = stmt.executeQuery();
		
			while(rs.next()) {
				Cliente cliente = new Cliente();
			
				cliente.setIdCliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmpresa(rs.getString("empresa"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setEmail(rs.getString("email"));
				cliente.setDataNascimento(rs.getString("data_nascimento"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setObservacoes(rs.getString("observacoes"));
			
				clientes.add(cliente);
			}
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar tabela 'Clientes' "+e);
		}
		finally {
			Conexao.closeConnection(conexao, stmt, rs);
		}
		
		return clientes;
	}

	/**
	 * Retorna uma lista dos clientes cadastrados de acordo com a busca
	 * @param nome - nome a ser buscado 
	 * @return - a lista de clientes filtrada
	 */
    public List<Cliente> lerParaNome(String nome) {
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ?;");
            stmt.setString(1, "%"+nome+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmpresa(rs.getString("empresa"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setEmail(rs.getString("email"));
				cliente.setDataNascimento(rs.getString("data_nascimento"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setObservacoes(rs.getString("observacoes"));
				clientes.add(cliente);
            }
        } catch (Exception e) {}
        
        finally { Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return clientes;
    }
       
    /**
     * Retorna o nome do cliente de acordo com a busca do id
     * @param idCliente - o id a ser buscado
     * @return - o nome do cliente
     */
    public String lerNomeCliente(int idCliente) {
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM cliente WHERE id_cliente LIKE ?;");
            stmt.setInt(1, idCliente);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmpresa(rs.getString("empresa"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setEmail(rs.getString("email"));
				cliente.setDataNascimento(rs.getString("data_nascimento"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setObservacoes(rs.getString("observacoes"));
            } 
            else {
            	JOptionPane.showMessageDialog(null, "N�o foi possivel encontrar o id do cliente selecionado na tabela!");
            }
        } 
        catch (Exception e) { 
        	JOptionPane.showMessageDialog(null, "Algo deu errado ao tentar encontrar o id do cliente selecionado na tabela!");
        } 
        finally { 
        	Conexao.closeConnection(conexao, stmt, rs);
        }
        
        return cliente.getNome();
    }
    
    /**
     * Retorna os dados do cliente de acordo com a busca do id
     * @param idCliente - o id a ser buscado
     * @return - os dados do cliente
     */
    public Cliente lerObjCliente(int idCliente) {
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM cliente WHERE id_cliente LIKE ?;");
            stmt.setInt(1, idCliente);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmpresa(rs.getString("empresa"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setEmail(rs.getString("email"));
				cliente.setDataNascimento(rs.getString("data_nascimento"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setObservacoes(rs.getString("observacoes"));
            } 
            else {
            	JOptionPane.showMessageDialog(null, "N�o foi possivel encontrar o id do cliente selecionado na tabela!");
            }
        } 
        catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Algo deu errado ao tentar encontrar o id do cliente selecionado na tabela!");
        } 
        finally {
        	Conexao.closeConnection(conexao, stmt, rs);
        }

        return cliente;
    }

    /**
     * Exclui o cliente selecionado do banco de dados
     * @param c - o cliente a ser deletado
     */
    public void delete(Cliente c) {
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?;");
            stmt.setInt(1, c.getIdCliente());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e);
        } 
        finally {
            Conexao.closeConnection(conexao, stmt);
        }
    }
    
    /**
     * Atualiza o cliente selecionado no banco de dados
     * @param c - o cliente a ser alterado
     */
    public void update(Cliente c) {
        Connection conexao = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE cliente SET nome = ? ,empresa = ?,"
            		+ "telefone = ?,endereco = ?,email = ?,data_nascimento = ?,cnpj = ?,cpf = ?,"
            		+ "observacoes = ? WHERE id_cliente = ?;");
      
            stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEmpresa());
			stmt.setString(3, c.getTelefone());
			stmt.setString(4, c.getEndereco());
			stmt.setString(5, c.getEmail());
			stmt.setString(6, c.getDataNascimento());
			stmt.setString(7, c.getCnpj());
			stmt.setString(8, c.getCpf());
			stmt.setString(9, c.getObservacoes());
            stmt.setInt(10, c.getIdCliente());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
        } 
        finally {
            Conexao.closeConnection(conexao, stmt);
        }
    }
}