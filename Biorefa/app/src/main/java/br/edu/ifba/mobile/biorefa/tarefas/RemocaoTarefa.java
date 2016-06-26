package br.edu.ifba.mobile.biorefa.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifba.mobile.biorefa.BD.FachadaBD;
import br.edu.ifba.mobile.biorefa.BD.Tarefa;



public class RemocaoTarefa extends AsyncTask<Void, Void, String> {//paradigma generics

    private Context contexto = null;
    private Tarefa tarefa = null;

    public RemocaoTarefa(Context contexto, Tarefa tarefa){
        this.tarefa = tarefa;
        this.contexto = contexto;
    }

    @Override
    protected String doInBackground(Void... params) {
        String mensagem = "";

        if(tarefa.getCodigo()!=-1){
            if(FachadaBD.getInstancia().remover(tarefa)==0){
                mensagem="Problemas de remoção!";
            }else
                mensagem="Tarefa removida!";
        }else{
            mensagem="Selecione uma Tarefa!";
        }
        return mensagem;
    }

    @Override
    protected void onPostExecute(String mensagem){
        Toast.makeText(contexto,mensagem,Toast.LENGTH_LONG).show();
    }
}
