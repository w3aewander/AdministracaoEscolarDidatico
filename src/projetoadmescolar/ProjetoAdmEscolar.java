/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoadmescolar;

import java.util.ArrayList;
import java.util.List;
import model.Aluno;

/**
 *
 * @author sala308b
 */
public class ProjetoAdmEscolar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
 //       model.Aluno aluno = new model.Aluno();
        
//        aluno.setNome("ALUNO DAS GALÁXIAS");
//        model.Curso curso = new model.Curso();
//        
//        curso.setId(21);
//        curso.setNome("WEBDESIGNER");
//        
//        aluno.setCurso(curso);
//        
//        controller.AlunoDAO alunoDAO = new controller.AlunoDAO();
//        alunoDAO.incluir(aluno);
        
       controller.AlunoDAO alunoDAO = new controller.AlunoDAO();
       
//       List<Aluno> lista = alunoDAO.listar();
       
//       lista.forEach((aluno) -> {
//           System.out.println(aluno.getAlunoId() + " "
//                   + aluno.getNome() + " "
//                   + aluno.getCurso().getId()+ " "
//                   + aluno.getDataNascimento());
//        });

  
     Aluno pesq = new Aluno( );
     pesq.setAlunoId(27);
     Aluno aluno = alunoDAO.pesquisar(pesq);
     System.out.println(aluno.getAlunoId() + " - " 
                       + aluno.getNome() + " " 
                       //+ String.valueOf(aluno.getCurso().getId() ) );
     );
    }
}
