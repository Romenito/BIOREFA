package br.edu.ifba.mobile.biorefa.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.edu.ifba.mobile.biorefa.BD.FachadaBD;
import br.edu.ifba.mobile.biorefa.BD.Tarefa;


/**
 * Created by andre on 27/05/2016.
 */
public class ListagemTarefas extends AsyncTask<Void, Void, List<Tarefa>> {

    private Context contexto = null;
    private ListView listaTarefas = null;

    public ListagemTarefas(Context contexto, ListView listaDisciplinas){
        this.contexto = contexto;
        this.listaTarefas = listaDisciplinas;
    }

    @Override
    protected List<Tarefa> doInBackground(Void... params) {
        List<Tarefa> tarefas = FachadaBD.getInstancia().listarTarefas();

        return tarefas;
    }
    @Override
    protected void onPostExecute(List<Tarefa> tarefas){
        if(tarefas.isEmpty()) {
            Toast.makeText(contexto, "Lista vazia. Cadastre uma atividade.", Toast.LENGTH_LONG).show(); // Toast é aquela mensagem q aparece e some só
        }
        else{
            ArrayAdapter<Tarefa> adaptador = new ArrayAdapter<Tarefa>(contexto, android.R.layout.simple_list_item_single_choice, tarefas);
            listaTarefas.setAdapter(adaptador);
        }
    }
}
