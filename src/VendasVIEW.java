/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
/**
 *
 * @SophiaLyandra
 */
public class VendasVIEW extends javax.swing.JFrame {
    public VendasVIEW() {
        initComponents();
        carregarListaVendas();
    }

    private void carregarListaVendas() {
        ProdutosDAO dao = new ProdutosDAO();
        ArrayList<ProdutosDTO> lista = dao.listarProdutosVendidos();
       
        DefaultTableModel modelo = (DefaultTableModel) tabelaVendas.getModel();
        modelo.setRowCount(0);

        for (ProdutosDTO produto : lista) {
            modelo.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getValor()});
        }
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
