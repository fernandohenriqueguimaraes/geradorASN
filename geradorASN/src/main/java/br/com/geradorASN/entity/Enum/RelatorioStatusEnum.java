package br.com.geradorASN.entity.Enum;

public enum RelatorioStatusEnum {
	
	ASN_GERADO("ASN GERADO"),
	NAO_SE_APLICA("NÃO SE APLICA");
	
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
