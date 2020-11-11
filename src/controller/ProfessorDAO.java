/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    private int idGerado;

    @Override
    public boolean incluir(Professor obj) {

        boolean incluiuProfessor = false;

        try {

            String sql = "insert into professores (  professor_nome, professor_disponibilidade  ) ";
            sql += " values( ?, ? )";

            pstm = this.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, obj.getNome());
            pstm.setString(2, obj.getDisponibilidade());

            incluiuProfessor = pstm.executeUpdate() > 0;

            ResultSet rs = pstm.getGeneratedKeys();

            if (rs.next()) {
                idGerado = rs.getInt(1);
            }
            //JOptionPane.showMessageDialog(null, "ID do professor gerado: " + idGerado );

            incluirDisciplina(idGerado, obj.getDisciplinas());

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

            String sql = " select * from professores p ";
            sql += " inner join professores_disciplinas pd ";
            sql += " on p.professor_id = pd.professor_id ";
            sql += " inner join disciplinas d ";
            sql += " on d.disciplina_id = pd.disciplina_id";
            sql += " and p.professor_id = ? ";

            pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1, obj.getId());
            pstm.execute();

            ResultSet rs = pstm.getResultSet();
            List<Disciplina> disciplinas = new ArrayList<Disciplina>();

            while (rs.next()) {

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

            String sql = " update professores set professor_nome = ?,"
                    + " professor_disponibilidade = ? "
                    + " where professor_id = ? ";
            pstm = this.conectar().prepareStatement(sql);
            pstm.setString(1, obj.getNome());
            pstm.setString(2, obj.getDisponibilidade());
            pstm.setInt(3, obj.getId());

            this.incluirDisciplina(obj.getId(), obj.getDisciplinas());

            atualizou = pstm.executeUpdate() > 0;

        } catch (SQLException ex) {
            //Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return atualizou;
    }

    public boolean excluir(int id) {
        boolean excluiu = false;
        try {
            String sql = " delete from professores where professor_id = ?";
            pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1, id);

            excluiu = pstm.executeUpdate() > 0;

            if (excluiu) {
                JOptionPane.showMessageDialog(null, "Disciplinas do professor excluídas com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar excluir dados do professor.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return excluiu;
    }

    @Override
    public boolean excluir(Professor obj) {
        return false;
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

            while (rs.next()) {
                professor = new Professor();
                professor.setId(rs.getInt("professor_id"));
                professor.setNome(rs.getString("professor_nome"));
                professor.setDisponibilidade(rs.getString("professor_disponibilidade"));
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
        return null;
    }

    public List<Disciplina> obterDisciplinas(int professorId) {
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        try {
            String sql = "select * from professores_disciplinas pd ";
            sql += " inner join disciplinas d ";
            sql += " on pd.disciplina_id = d.disciplina_id ";
            sql += " and  professor_id = ? ";

            PreparedStatement pstm = this.conectar().prepareStatement(sql);
            pstm.setInt(1, professorId);
            pstm.execute();

            ResultSet rs = pstm.getResultSet();

            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(rs.getInt("disciplina_id"));
                disciplina.setNome(rs.getString("disciplina_nome"));
                disciplinas.add(disciplina);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return disciplinas;
    }

    public void incluirDisciplina(int professorId, List<Disciplina> disciplinas) {

        try {
            String sql = "delete from professores_disciplinas where professor_id = ? ";
            PreparedStatement pstm = this.conectar().prepareStatement(sql);

            pstm.setInt(1, professorId);
            pstm.execute();

            sql = " insert into professores_disciplinas(professor_id, disciplina_id)"
                    + " values ( ?, ? )";
            PreparedStatement pstm2 = this.conectar().prepareStatement(sql);

            disciplinas.forEach((d) -> {
                try {
                    pstm2.setInt(1, professorId);
                    pstm2.setInt(2, d.getId());
                    pstm2.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean excluirDisciplinas(int professorId) {

        boolean excluiu = false;

        try {
            String sql = " delete from professores_disciplinas where professor_id = ? ";

            PreparedStatement pstm = this.conectar().prepareStatement(sql);

            pstm.setInt(1, professorId);

            excluiu = pstm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return excluiu;
    }

}
