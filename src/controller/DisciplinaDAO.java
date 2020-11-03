/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Disciplina;
import model.ICRUD;
import persistence.Conexao;

/**
 *
 * @author sala308b
 */
public class DisciplinaDAO extends Conexao implements ICRUD<Disciplina> {

    private PreparedStatement pstm; 
    
    @Override
    public boolean incluir(Disciplina obj) {
        boolean incluiu = false;
        try {
            String sql = " insert into disciplinas ( nome ) ";
            sql += " values ( ? ) ";
            pstm = this.conectar().prepareStatement(sql);
            pstm.setString( 1,obj.getNome() );
            
            incluiu = pstm.execute();
            
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return incluiu;
    }

    @Override
    public Disciplina pesquisar(Disciplina obj) {
        
        Disciplina disciplina = null;
        
        try {
            
            String sql = "select * from disciplinas where disciplina_id = ? ";
            pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1, obj.getId());
            
            ResultSet rs = pstm.getResultSet();
            
            while ( rs.next() ){
                disciplina = new Disciplina();
                disciplina.setId(rs.getInt("disciplina_id"));
                disciplina.setNome(rs.getString("disciplina_nome"));
            }
            
            rs.close();
            pstm.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return disciplina;
    }

    @Override
    public boolean atualizar(Disciplina obj) {
        
        boolean atualizou = false;
        
        try {
            
            String sql = "update disciplinas set disciplina_nome = ? where disciplina_id = ?";
           
            pstm = this.conectar().prepareStatement(sql);
            pstm.setString(1,obj.getNome());
            pstm.setInt(2, obj.getId());
            
            atualizou = pstm.executeUpdate() > 0;
            
            pstm.close();

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return atualizou;
    }

    @Override
    public boolean excluir(Disciplina obj) {
            
        boolean excluiu = false;
      
        try {
            
            String sql = "delete from disciplinas where disciplina_id = ? ";
            
            pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1, obj.getId());
            
            excluiu = pstm.executeUpdate() > 0;
            
            pstm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return excluiu;
    }

    @Override
    public List<Disciplina> listar() {
        List<Disciplina> lista = new ArrayList<Disciplina>();
        
        try {
            
            String sql = "select * from disciplinas ";
            pstm = this.conectar().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while( rs.next() ){
                Disciplina disciplina = new Disciplina();
                disciplina.setId(rs.getInt("disciplina_id"));
                disciplina.setNome(rs.getString("disciplina_nome"));
                lista.add(disciplina);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    @Override
    public Disciplina exibir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
