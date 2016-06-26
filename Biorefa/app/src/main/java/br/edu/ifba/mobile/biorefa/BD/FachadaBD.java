package br.edu.ifba.mobile.biorefa.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FachadaBD extends SQLiteOpenHelper {

	private static FachadaBD instancia = null;

	public static FachadaBD criarInstancia(Context context){ // construtor de 'instancia'
		if (instancia == null){
			instancia = new FachadaBD(context);
		}
		return instancia;
	}

	public static FachadaBD getInstancia(){
		return instancia;
	}

	private static String NOME_BANCO = "Biorefa";
	private static int VERSAO_BANCO = 1;

	public FachadaBD(Context context) {
		super(context, NOME_BANCO, null, VERSAO_BANCO);
	}

	private static String COMANDO_CRIACAO_TABELA_TAREFA =
			"CREATE TABLE TAREFA(" + "CODIGO INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ "ATIVIDADE TEXT, PESQUISA TEXT, RESPOSTA TEXT)"
	        +"CREATE TABLE ALUNO(" +
			"CODIGOALUNO INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ "NOMEALUNO TEXT, PROFESSOR TEXT, ESCOLA TEXT, MATERIA TEXT,SERIE TEXT,TURNO TEXT)";

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(COMANDO_CRIACAO_TABELA_TAREFA);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int versaoNova) {
		// TODO Auto-generated method stub
	}

	// metodos de criacao de um CRUD utilizando o SQLite
	
	public long inserir(Tarefa tarefa) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues valores = new ContentValues();

		valores.put("ATIVIDADE", tarefa.getAtividade());
		valores.put("PESQUISA", tarefa.getPesquisa());
		valores.put("RESPOSTA", tarefa.getResposta());

		long codigo = db.insert("TAREFA", null, valores);
		return codigo;
	}

	public long atualizar(Tarefa tarefa) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues valores = new ContentValues();

		valores.put("ATIVIDADE", tarefa.getAtividade());
		valores.put("PESQUISA", tarefa.getPesquisa());
		valores.put("RESPOSTA", tarefa.getResposta());

		long codigo = db.update("TAREFA", valores, "CODIGO = " + tarefa.getCodigo(), null);
		return codigo;
	}

	public int remover(Tarefa tarefa) {
		SQLiteDatabase db = this.getWritableDatabase();

		return db.delete("TAREFA", "CODIGO = " + tarefa.getCodigo(), null);
	}

	public List<Tarefa> listarTarefas() { // ler tarefas
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		SQLiteDatabase db = this.getReadableDatabase();

		String selecao = "SELECT CODIGO, ATIVIDADE, PESQUISA, RESPOSTA FROM TAREFA";

		Cursor cursor = db.rawQuery(selecao, null);
		if(cursor != null){
			boolean temProximo = cursor.moveToFirst();
			while (temProximo){
				Tarefa tarefa = new Tarefa();
				tarefa.setCodigo(cursor.getLong(cursor.getColumnIndex("CODIGO")));
				tarefa.setAtividade(cursor.getString(cursor.getColumnIndex("ATIVIDADE")));
				tarefa.setPesquisa(cursor.getString(cursor.getColumnIndex("PESQUISA")));
				tarefa.setResposta(cursor.getString(cursor.getColumnIndex("RESPOSTA")));

				tarefas.add(tarefa);

				temProximo = cursor.moveToNext();
			}
		}
		return tarefas;
	}

	public long inserirAluno(Aluno aluno) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues valores = new ContentValues();

		valores.put("NOMEALUNO", aluno.getNomeAluno());
		valores.put("PROFESSOR", aluno.getProfessor());
		valores.put("ESCOLA", aluno.getEscola());
		valores.put("MATERIA", aluno.getMateria());
		valores.put("SERIE", aluno.getSerieTurma());
		valores.put("TURNO", aluno.getTurno());

		long codigo = db.insert("ALUNO", null, valores);
		return codigo;
	}

	public long atualizarAluno(Aluno aluno) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues valores = new ContentValues();

		valores.put("NOMEALUNO", aluno.getNomeAluno());
		valores.put("PROFESSOR", aluno.getProfessor());
		valores.put("ESCOLA", aluno.getEscola());
		valores.put("MATERIA", aluno.getMateria());
		valores.put("SERIE", aluno.getSerieTurma());
		valores.put("TURNO", aluno.getTurno());

		long codigo = db.update("ALUNO", valores, "CODIGOALUNO = " + aluno.getCodigoAluno(), null);
		return codigo;
	}
	
}