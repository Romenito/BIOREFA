package br.edu.ifba.mobile.biorefa.fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifba.mobile.biorefa.BD.Aluno;
import br.edu.ifba.mobile.biorefa.BD.Tarefa;
import br.edu.ifba.mobile.biorefa.R;
import br.edu.ifba.mobile.biorefa.tarefas.GravacaoAlunos;
import br.edu.ifba.mobile.biorefa.tarefas.GravacaoTarefas;


public class FragmentoCadastroAluno extends Fragment {

    private static FragmentoCadastroAluno instancia = null;

    public static FragmentoCadastroAluno getInstancia(){
        if (instancia==null){
            instancia=new FragmentoCadastroAluno();
        }
        return instancia;
    }

    private View tela=null;

    private EditText nomeAluno = null;
    private EditText professor = null;
    private EditText escola = null;
    private EditText materia = null;
    private EditText serieTurma = null;
    private EditText turno = null;
    private Button botaoSalvar = null;


    private Aluno aluno = null;

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup vgrupo, Bundle bundle){
        tela=inflador.inflate(R.layout.fragmento_cadastro_escolar, vgrupo, false);

        preparar();
        return tela;
    }

    private void preparar() { // pega oq foi digitado nos campos da tela
        nomeAluno = (EditText) tela.findViewById(R.id.nomeAluno);
        professor = (EditText) tela.findViewById(R.id.nomeProfessor);
        escola = (EditText) tela.findViewById(R.id.nomeEscola);
        materia = (EditText) tela.findViewById(R.id.nomeMateria);
        serieTurma = (EditText) tela.findViewById(R.id.nomeSerieTurma);
        turno = (EditText) tela.findViewById(R.id.nomeTurno);
        botaoSalvar = (Button) tela.findViewById(R.id.botaoSalvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GravacaoAlunos gravacao = new GravacaoAlunos(getContexto(), getAlunos());
                gravacao.execute();
            }
        });
    }
    private Context getContexto(){
        return this.getContext();
    }

    private Aluno getAlunos(){ // pega oq foi pego no metodo preparar
        aluno.setNomeAluno(nomeAluno.getText().toString());
        aluno.setProfessor(professor.getText().toString());
        aluno.setEscola(escola.getText().toString());
        aluno.setMateria(materia.getText().toString());
        aluno.setSerieTurma(serieTurma.getText().toString());
        aluno.setTurno(turno.getText().toString());


        return aluno;
    }


}
