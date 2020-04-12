package br.com.geradorASN.entity.xml;

public class Det {

	Prod ProdObject;
	Imposto ImpostoObject;
	private String infAdProd;
	private String _nItem;

	public Prod getProd() {
		return ProdObject;
	}

	public Imposto getImposto() {
		return ImpostoObject;
	}

	public String getInfAdProd() {
		return infAdProd;
	}

	public String get_nItem() {
		return _nItem;
	}

	public void setProd(Prod prodObject) {
		this.ProdObject = prodObject;
	}

	public void setImposto(Imposto impostoObject) {
		this.ImpostoObject = impostoObject;
	}

	public void setInfAdProd(String infAdProd) {
		this.infAdProd = infAdProd;
	}

	public void set_nItem(String _nItem) {
		this._nItem = _nItem;
	}
}
