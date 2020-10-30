/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Aluno;
import model.ICRUD;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Curso;
import persistence.Conexao;

/**
 *
 * @author sala308b
 */
public class AlunoDAO extends Conexao implements ICRUD<Aluno> {
    
    private PreparedStatement pstm;
    
    @Override
    public boolean incluir(Aluno obj) {
        
        boolean incluiu = false;
        try {
            String sql = " insert into alunos ( aluno_nome,  curso_id ) ";
            sql += " values ( ?, ? ) ";
            
            pstm = this.conectar().prepareStatement(sql);
            pstm.setString( 1,obj.getNome() );
            pstm.setInt( 2,obj.getCurso().getId() );
            
            incluiu = pstm.executeUpdate() > 0;
            
            pstm.close();
                 
        } catch (SQLException ex) {        
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
    
        }
        return incluiu;
    }

    @Override
    public Aluno pesquisar(Aluno obj) {
        Aluno aluno = null;
        
        try {
           
            String sql = " select * from alunos where aluno_id = ? "; //or aluno_nome = ?  ";            
            pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1, obj.getAlunoId());
            //pstm.setString(2, obj.getNome());
            pstm.execute();
            
            ResultSet rs = pstm.getResultSet();
            
            while ( rs.next() ){
            
            aluno = new Aluno();
            aluno.setAlunoId(rs.getInt("aluno_id"));
            aluno.setNome(rs.getString("aluno_nome"));
                
            }
            
         
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return aluno;
    }

    @Override
    public boolean atualizar(Aluno obj) {
        
        boolean atualizou = false;
        
        try {
            String sql = "update alunos set aluno_nome = ?, curso_id = ? where aluno_id = ?  ";
            
            pstm = this.conectar().prepareStatement(sql);
            
            pstm.setString(1, obj.getNome());
            pstm.setInt(2,obj.getCurso().getId());
            pstm.setInt(3, obj.getAlunoId());
            
            atualizou = pstm.executeUpdate() > 0 ;
            pstm.close();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return atualizou;
    }

    @Override
    public boolean excluir(Aluno obj) {
        
        boolean excluiu = false;
        
        try {
            String sql = "delete from alunos where aluno_id = ? ";
            
            pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1,obj.getAlunoId());
            excluiu = pstm.executeUpdate() > 0 ;
            pstm.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return excluiu;
    }

    @Override
    public List<Aluno> listar() {   
        List<Aluno> lista =null;  
        try {        
            lista =  new ArrayList<Aluno>();                    
            String sql = "select * from alunos";
            pstm = this.conectar().prepareStatement(sql);
            //Quando não temos parametros para a consulta
            //podemos utilizar o comando abaixo.
            //ResultSet rs = pstm.executeQuery(sql);
            pstm.execute();
            // Percorrer o resultado da consulta...
            ResultSet rs = pstm.getResultSet();
            
            while ( rs.next() ){
                //pegar o valor dos campos do resultado da consulta
                Aluno aluno = new Aluno();
                aluno.setAlunoId( rs.getInt("aluno_id") );
                aluno.setNome(rs.getString("aluno_nome") );
                aluno.setDataNascimento(rs.getDate("data_nascimento"));
                Curso curso = new Curso();
                curso.setId(rs.getInt("curso_id"));
                aluno.setCurso(curso);

                lista.add(aluno);
            }
            
            rs.close();
            pstm.close();
                        
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public Aluno exibir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
