package br.edu.ifba.mobile.biorefa.fragmentos;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifba.mobile.biorefa.BD.Tarefa;
import br.edu.ifba.mobile.biorefa.R;
import br.edu.ifba.mobile.biorefa.tarefas.GravacaoTarefas;


public class FragmentoCadastroTarefas extends Fragment {

    private static FragmentoCadastroTarefas instancia = null;

    public static FragmentoCadastroTarefas getInstancia(){
        if (instancia==null){
            instancia=new FragmentoCadastroTarefas();
        }
        return instancia;
    }

    private View tela=null;

    private EditText atividade = null;
    private EditText pesquisa = null;
    private EditText resposta = null;
    private Button botaoGravar = null;
    private Button botaoLimpar= null;

    private Tarefa tarefa = null;

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup vgrupo, Bundle bundle){
        tela=inflador.inflate(R.layout.fragmento_cadastro_biorefa, vgrupo, false);

        preparar();
        return tela;
    }

    private void preparar(){ // pega oq foi digitado nos campos da tela
        atividade = (EditText)tela.findViewById(R.id.nomeAtividade);
        pesquisa = (EditText)tela.findViewById(R.id.nomePesquisa);
        resposta = (EditText)tela.findViewById(R.id.nomeResposta);
        botaoGravar = (Button)tela.findViewById(R.id.botaoGravar);
        botaoLimpar=(Button)tela.findViewById(R.id.botaoLimpar);
        botaoGravar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                GravacaoTarefas gravacao = new GravacaoTarefas(getContexto(), getTarefas());
                    gravacao.execute();
            }
        });
        botaoLimpar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.M)
    private Context getContexto(){
        return this.getContext();
    }

    private Tarefa getTarefas(){ // pega oq foi pego no metodo preparar
        tarefa.setAtividade(atividade.getText().toString());
        tarefa.setPesquisa(pesquisa.getText().toString());
        tarefa.setResposta(resposta.getText().toString());


        return tarefa;
    }

    public void exibirTarefaSelecionada(){
        tarefa = FragmentoListaTarefas.getInstancia().getTarefaSelecionada();

        if(tarefa.getCodigo() == -1){
            limparCampos();
        } else
            carregarCampos();
    }

    private void limparCampos(){
        atividade.setText("");
        pesquisa.setText("");
        resposta.setText("");

    }

    private void carregarCampos(){
        atividade.setText(tarefa.getAtividade());
        pesquisa.setText(tarefa.getPesquisa());
        resposta.setText(tarefa.getResposta());

    }
}
