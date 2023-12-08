/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Acesso;
import modelo.Contato;
import modelo.Login;

/**
 *
 * @author LAB_ETESC
 */
public class Banco {

    private Connection conexao;

    //Quando a classe for construída ele obterá a conexão
    public Banco() throws Exception {
        this.conexao = CriaConexao.getconexao();
    }

    //Método para adicionar um contato ao Banco
    public void adicionarContato(Contato ctt) throws SQLException {

        String sql = "insert into info (matricula,nome,email) values(?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, ctt.getMatricula());
        stmt.setString(2, ctt.getNome());
        stmt.setString(3, ctt.getEmail());
        stmt.execute();
        stmt.close();

    }
    public void adicionarContatoLogin(Contato ctt) throws SQLException {

        String sql = "insert into login (nome_usuario, senha) values(?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, ctt.getNomeLogin());
        stmt.setString(2, ctt.getSenhaLogin());
        stmt.execute();
        stmt.close();

    }

    public Contato consultarNome(String nome) throws Exception {
        Contato c = new Contato();
        String pesquisa = ("select * from info where nome=?");
        PreparedStatement stmt = this.conexao.prepareStatement(pesquisa);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            c.setMatricula(rs.getString("matricula"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
        }
        return c;
    }
    public Contato consultarNomeLogin(String nome) throws Exception {
        Contato c = new Contato();
        String pesquisa = ("select nome_usuario, senha from info where nome=?");
        PreparedStatement stmt = this.conexao.prepareStatement(pesquisa);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            c.setNome(rs.getString("nome"));
            //c.setEmail(rs.getString("email"));
        }
        return c;
    }

    public Contato consultarMatricula(String matricula) throws Exception {
        Contato c = new Contato();
        String pesquisa = ("select * from info where matricula=?");
        PreparedStatement stmt = this.conexao.prepareStatement(pesquisa);
        stmt.setString(1, matricula);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            c.setMatricula(rs.getString("matricula"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
        }
        return c;
    }
    public void excluirContato(String matricula) throws Exception {
        Contato c = new Contato();
        String sql = ("delete from info where matricula='"+matricula+"';");
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.execute();
        stmt.close();
    }
    public void excluirContatoLogin(String matricula) throws Exception {
        Contato c = new Contato();
        String sql = ("delete from login where matricula='"+matricula+"';");
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.execute();
        stmt.close();
    }
    public void alterarContato (Contato ctt) throws Exception{
        Contato c = new Contato();
        String sql = "update info set nome=?,email=? where matricula =?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(3, ctt.getMatricula());
        stmt.setString(1, ctt.getNome());
        stmt.setString(2, ctt.getEmail());
        
        stmt.execute();
        stmt.close();
    }
    
    public void EntradaAcesso(String nome_usuario) throws SQLException {
    
        String sql = "INSERT INTO acesso(nome_usuario, data_acesso, hora_acesso) VALUES (?,?,?)";
        
        Acesso acesso = new Acesso();
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        
        stmt.setString(1, nome_usuario);
        
        stmt.setString(2, acesso.getDataAcesso());
        
        stmt.setString(3, acesso.getHoraAcesso());
        
        stmt.execute();
        
        stmt.close();
    }
    
    public Boolean ValidarLogin(String nomeUsuario, String senha) throws SQLException{
        boolean autenticado = false;
        
        String sql = "SELECT nome_usuario, senha FROM login WHERE nome_usuario = ? AND senha = ?";
        PreparedStatement stmt;
        stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, nomeUsuario);
        stmt.setString(2, senha);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            Login login = new Login();
            
            login.setNomeUsuario(rs.getString("nome_usuario"));
            login.setSenha(rs.getString("senha"));
            autenticado = true;
            
            EntradaAcesso (nomeUsuario);
        }
        rs.close();
        stmt.close();
        return autenticado;
    }
    
    public List<Contato> getLista(String nome) throws SQLException{
    
        
        String sql = "SELECT * FROM info WHERE nome ILIKE ?";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, nome);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Contato> minhaLista = new ArrayList<Contato>();
        
        while (rs.next()){
            Contato c = new Contato();
            
            c.setMatricula(rs.getString("matricula"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            
            minhaLista.add(c);
        }
        
        rs.close();
        stmt.close();
        
        return minhaLista;
    }
}
