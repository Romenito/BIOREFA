package br.edu.ifba.mobile.biorefa.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifba.mobile.biorefa.BD.Aluno;
import br.edu.ifba.mobile.biorefa.BD.FachadaBD;
import br.edu.ifba.mobile.biorefa.BD.Tarefa;


public class GravacaoAlunos extends AsyncTask<Void, Void, String> {

    private Context contexto = null;
    private Aluno aluno = null;

    public GravacaoAlunos(Context contexto, Aluno aluno){
        this.aluno = aluno;
        this.contexto = contexto;
    }

    @Override
    protected String doInBackground(Void... params) {
        String mensagem = "";
        long codigo ;
        if(aluno.getCodigoAluno() == -1){
            codigo = FachadaBD.getInstancia().inserirAluno(aluno);
        }
        else{
            codigo = FachadaBD.getInstancia().atualizarAluno(aluno);
        }
        if(codigo > 0){
            mensagem = "Dados gravados com sucesso!";
        }
        else{
            mensagem = "Erro de gravação!";
        }
        return mensagem;
    }
    @Override
    protected void onPostExecute(String mensagem){
        Toast.makeText(contexto, mensagem, Toast.LENGTH_LONG).show(); // Toast é aquela mensagem q aparece e some só
    }
}
