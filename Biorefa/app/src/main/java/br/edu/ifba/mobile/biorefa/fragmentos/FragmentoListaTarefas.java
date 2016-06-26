package br.edu.ifba.mobile.biorefa.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.edu.ifba.mobile.biorefa.BD.Tarefa;
import br.edu.ifba.mobile.biorefa.tarefas.ListagemTarefas;
import br.edu.ifba.mobile.biorefa.R;



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

    private void preparar(){
        lista = (ListView) tela.findViewById(R.id.listaTarefas);
        this.setHasOptionsMenu(true);
        lista.setClickable(true);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

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
