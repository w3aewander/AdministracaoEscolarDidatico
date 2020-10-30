/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.lang.reflect.Parameter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Curso;
import model.ICRUD;
import persistence.Conexao;

/**
 *
 * @author sala308b
 */
public class CursoDAO extends Conexao implements ICRUD<Curso> {

    private PreparedStatement pstm;
    

    @Override
    public boolean incluir(Curso obj) {
        
        boolean incluiu = false;
        try {
            String sql = "insert into cursos(curso_nome,carga_horaria) ";
            sql += " values ( ?, ? )";
            pstm = this.conectar().prepareStatement(sql);            
            pstm.setString(1, obj.getNome());
            pstm.setInt(2, obj.getCargaHoraria());
            
            incluiu =  pstm.executeUpdate() > 0;  

            pstm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return incluiu;
    }

    @Override
    public Curso pesquisar(Curso obj) {
        
         Curso curso = new Curso();
         try {
            String sql = "select * from cursos where curso_id = ?";
            pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1, obj.getId());
            
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            
            while ( rs.next() ){
                curso.setId(rs.getInt("curso_id"));
                curso.setNome(rs.getString("curso_nome"));
                curso.setCargaHoraria(rs.getInt("carga_horaria"));
            }
            rs.close();
            pstm.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curso;
    }

    @Override
    public boolean atualizar(Curso obj) {
        
        boolean atualizou = false;
        
         try {
            
            String sql = "update cursos set curso_nome = ?,  carga_horaria = ? ";
            sql += " where curso_id = ? ";
            
            pstm = this.conectar().prepareStatement(sql);
            pstm.setString(1,obj.getNome());
            pstm.setInt(2,obj.getCargaHoraria());
            pstm.setInt(3,obj.getId());
            
            atualizou = pstm.executeUpdate() > 0;
            pstm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return atualizou ;
    }

    @Override
    public boolean excluir(Curso obj) {
        
        boolean excluiu = false;
         
        try {
            String sql = "delete from cursos where curso_id = ? ";
            
            pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1, obj.getId());
            
            excluiu = pstm.executeUpdate() > 0;
            
            pstm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return excluiu;
    }

    @Override
    public List<Curso> listar() {
       
        List<Curso> lista = new ArrayList<Curso>();
        try {
            
            String sql = "select * from cursos ";
            
            pstm = this.conectar().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while( rs.next() ){
                Curso curso = new Curso();
                curso.setId( rs.getInt("curso_id"));
                curso.setNome( rs.getString("curso_nome"));
                curso.setCargaHoraria(rs.getInt("carga_horaria"));
                
                lista.add(curso);
            }
           
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        return lista;
    }

    @Override
    public Curso exibir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
