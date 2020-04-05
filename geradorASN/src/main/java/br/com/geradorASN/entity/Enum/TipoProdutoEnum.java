package br.com.geradorASN.entity.Enum;

public enum TipoProdutoEnum {
	
	ANEL("Anel"),
	CAMARA("Camara"),
	MEMS("MEMS"),
	PASTA("Pasta de Montagem"),
	PNEU("Pneu"),
	PROTETOR("Protetor");
	
	private String descricao;

	private TipoProdutoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoProdutoEnum toTipoProdutoEnum(String tipoProduto) {
		
		switch (tipoProduto) {
		case "Anel":
			return ANEL;
		case "Camara":
			return CAMARA;	
		case "MEMS":
			return MEMS;
		case "Pasta de Montagem":
			return PASTA;
		case "Pneu":
			return PNEU;	
		case "Protetor":
			return PROTETOR;
		default:
			return null;
		}
		
	}

}
