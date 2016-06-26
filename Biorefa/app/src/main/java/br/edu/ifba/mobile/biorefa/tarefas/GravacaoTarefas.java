package br.edu.ifba.mobile.biorefa.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifba.mobile.biorefa.BD.FachadaBD;
import br.edu.ifba.mobile.biorefa.BD.Tarefa;


public class GravacaoTarefas extends AsyncTask<Void, Void, String> {

    private Context contexto = null;
    private Tarefa tarefa = null;

    public GravacaoTarefas(Context contexto, Tarefa tarefa){
        this.tarefa = tarefa;
        this.contexto = contexto;
    }

    @Override
    protected String doInBackground(Void... params) {
        String mensagem = "";
        long codigo = -1;
        if(tarefa.getCodigo() == -1){
            codigo = FachadaBD.getInstancia().inserir(tarefa);
        }
        else{
            codigo = FachadaBD.getInstancia().atualizar(tarefa);
        }
        if(codigo > 0){
            mensagem = "Tarefa gravada com sucesso!";
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
