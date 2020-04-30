package br.com.geradorASN.entity.Enum;

public enum RelatorioStatusEnum {
	
	ASN_GERADO("ASN GERADO"),
	ASN_NAO_GERADO("ASN NÃO GERADO"),
	PRODUTO_MEMS_E_CNPJ_NAO_GERA_ASN("PRODUTO MEMS E CNPJ NÃO GERA ASN"), 
	PRODUTO_MEMS("PRODUTO MEMS"),
	CNPJ_NAO_GERA_ASN("CNPJ NÃO GERA ASN");
	
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
