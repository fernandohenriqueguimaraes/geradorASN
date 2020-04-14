package br.com.geradorASN.entity.Enum;

public enum RelatorioStatusEnum {
	
	ASN_GERADO("ASN GERADO"),
	PRODUTO_MEMS("PRODUTO MEMS"),
	CNPJ_NAO_CADASTRA("CNPJ NÃO CADASTRA"),
	PRODUTO_MEMS_CNPJ_NAO_CADASTRA("PRODUTO MEMS E CNPJ NÃO CADASTRA");
	
	private String descricao;
	
	private RelatorioStatusEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
