/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;



public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        conn = new conectaDAO().connectDB();
        
        String sql = "INSERT INTO produtos (nome, descricao) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValor());
            stmt.setString(3, produto.getStatus());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
                ArrayList<ProdutosDTO> listarProdutos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.getValor(rs.getDouble("valor"));
                produto.setStatus(rs.getString("status"));
                listarProdutos.add(produto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
        return listagem;
    }
        
    }
    

    
    
