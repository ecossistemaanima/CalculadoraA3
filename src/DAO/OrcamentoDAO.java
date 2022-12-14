package DAO;

import DTO.OrcamentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Viniccius
 */
public class OrcamentoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rst;

    public void cadastrarOrcamento(OrcamentoDTO objorcamentodto) throws ClassNotFoundException {

        String sql = "insert into orcamento (orcamentosTotal, totalHoras) values (?,?)";

        conn = new ConexaoDAO().conectaDB();

        try {
            pstm = conn.prepareStatement(sql);

            pstm.setDouble(1, objorcamentodto.getValorTotal());
            pstm.setDouble(2, objorcamentodto.getTotalHoras());

            pstm.execute();
            pstm.close();
            

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "OrcamentoDAO Cadastrar: " + erro);
        }
    }

}
