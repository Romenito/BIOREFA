package br.edu.ifba.mobile.biorefa.fragmentos;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import br.edu.ifba.mobile.biorefa.BD.Tarefa;
import br.edu.ifba.mobile.biorefa.tarefas.ListagemTarefas;
import br.edu.ifba.mobile.biorefa.R;
import br.edu.ifba.mobile.biorefa.tarefas.RemocaoTarefa;


public class FragmentoListaTarefas extends Fragment {

    private static FragmentoListaTarefas instancia = null;

    public static FragmentoListaTarefas getInstancia(){
        if (instancia == null){
            instancia = new FragmentoListaTarefas();
        }
        return instancia;
    }

    private View tela = null;
    private ListView lista = null;

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup vgrupo, Bundle bundle){
        tela = inflador.inflate(R.layout.fragmento_lista_respostas, vgrupo, false);

        preparar();

        return tela;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflador){
        super.onCreateOptionsMenu(menu, inflador);
        inflador.inflate(R.menu.menu_biorefa, menu);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        long id = item.getItemId();
        if (id != AdapterView.INVALID_ROW_ID){
            if (id == R.id.remover_tarefas){
                RemocaoTarefa remocao = new RemocaoTarefa(this.getContext(), this.getTarefaSelecionada());
                remocao.execute();
                atualizar();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void preparar(){
        lista = (ListView) tela.findViewById(R.id.listaTarefas);
        this.setHasOptionsMenu(true);
        lista.setClickable(true);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void atualizar(){
        ListagemTarefas listagem = new ListagemTarefas(this.getContext(), lista);
        listagem.execute();
    }

    public Tarefa getTarefaSelecionada(){
        Tarefa tarefa = new Tarefa();

        int posicao = lista.getCheckedItemPosition();
        if (posicao != ListView.INVALID_POSITION){
            tarefa = (Tarefa) lista.getItemAtPosition(posicao);
        }

        return tarefa;
    }
}
