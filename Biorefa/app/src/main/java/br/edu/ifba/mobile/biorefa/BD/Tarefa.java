package br.edu.ifba.mobile.biorefa.BD;

import java.text.DecimalFormat;

public class Tarefa {
	private long codigo = -1;
	private String atividade;
	private String pesquisa;
	private String resposta;


	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String nomeAtividade) {
		this.atividade = nomeAtividade;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}


	@Override
	public String toString() {
		return atividade + "," +pesquisa+","+resposta;

	}

}
