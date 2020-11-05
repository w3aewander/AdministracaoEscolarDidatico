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
import model.Professor;
import persistence.Conexao;

/**
 *
 * @author sala308b
 */
public class ProfessorDAO extends Conexao implements ICRUD<Professor> {

    private PreparedStatement pstm;
    
    @Override
    public boolean incluir(Professor obj) {
            
        boolean incluiuProfessor = false;
        
        try {
            
            String sql = "insert into professores (  professor_nome, professor_disponibilidade  ) ";
            sql += " values( ?, ? )";
            
            pstm = this.conectar().prepareStatement(sql);
            pstm.setString(1, obj.getNome());
            pstm.setString(2, obj.getDisponibilidade());
           
            incluiuProfessor = pstm.executeUpdate() > 0 ;
            
            if ( incluiuProfessor && ! obj.getDisciplinas().isEmpty()  ) {
                String sql2 = "insert into professores_disciplinas ( professor_id, disciplina_id)" ;
                sql2 += " values( ?, ? )";
                
                pstm = this.conectar().prepareStatement(sql2);
                
                for( Disciplina disciplina:obj.getDisciplinas() ){
                    pstm.setInt(1,obj.getId());
                    pstm.setInt(2, disciplina.getId());
                    pstm.execute();
                }
            }
            
            pstm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return incluiuProfessor;
    }

    @Override
    public Professor pesquisar(Professor obj) {
        
        Professor professor = new Professor();
        try {
            
         String sql =  " select * from professores p ";
                sql += " inner join professores_disciplinas pd ";
                sql += " on p.professor_id = pd.professor_id ";
                sql += " inner join disciplinas d ";
                sql += " on d.disciplina_id = pd.disciplina_id";
                sql += " and p.professor_id = ? " ;

            pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1, obj.getId());
            pstm.execute();
            
            ResultSet rs = pstm.getResultSet();
            List<Disciplina> disciplinas = new ArrayList<Disciplina>();
            
            while ( rs.next()){
                
                professor.setId(rs.getInt("p.professor_id"));
                professor.setNome(rs.getString("p.professor_nome"));
              
                Disciplina disciplina = new Disciplina();
                disciplina.setId(rs.getInt("d.disciplina_id"));
                disciplina.setNome(rs.getString("d.disciplina_nome"));
                disciplinas.add(disciplina);
                
            }
            professor.setDisciplinas(disciplinas);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return professor;
    }

    @Override
    public boolean atualizar(Professor obj) {
        
        boolean atualizou = false;
        
        try {
            
            String sql = "update professores set professor_nome = ?, professor_disponibilidade, where professor_id = ?";
            pstm = this.conectar().prepareStatement(sql);
            pstm.setString(1, obj.getNome());
            pstm.setString(2, obj.getDisponibilidade());
            pstm.setInt(3, obj.getId());
            
            atualizou = pstm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atualizou;
    }

    @Override
    public boolean excluir(Professor obj) {
        boolean excluiu = false;
        try {
            String sql = "delete from professores where professor_id = ?";
            pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1, obj.getId());
            excluiu = pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return excluiu;
    }

    @Override
    public List<Professor> listar() {
        
    List<Professor> professores = new ArrayList<Professor>();
    Professor professor = new Professor();
    
        try {

            String sql = "select * from professores ";
            
            pstm = this.conectar().prepareStatement(sql);
            pstm.execute();
            
            ResultSet rs = pstm.getResultSet();
            
            while ( rs.next() ){
                professor = new Professor();
                professor.setId( rs.getInt("professor_id") );
                professor.setNome( rs.getString("professor_nome")  );
                professor.setDisponibilidade(rs.getString("professor_disponibilidade")  );
                professores.add(professor);
            }
            pstm.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professores;      
    }

    @Override
    public Professor exibir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void incluirDisciplina(int professorId, List<Disciplina> disciplinas){
        
        try {
            String sql = "delete from professores_disciplinas where professor_id = ? ";
            pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1, professorId);
            pstm.execute();
            
            sql = "insert into professores_disciplinas(professor_id, disciplina_id) values ( ?, ? )";
            PreparedStatement pstm2 = this.conectar().prepareStatement(sql);
            
            disciplinas.forEach( (d)-> {
                try {
                    pstm2.setInt(1, professorId );
                    pstm2.setInt(2, d.getId() );
                    pstm2.execute();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
