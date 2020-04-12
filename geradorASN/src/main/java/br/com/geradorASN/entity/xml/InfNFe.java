package br.com.geradorASN.entity.xml;

public class InfNFe {
	Ide IdeObject;
	Emit EmitObject;
	Dest DestObject;
	Det DetObject;
	Total TotalObject;
	Transp TranspObject;
	Cobr CobrObject;
	Pag PagObject;
	InfAdic InfAdicObject;
	private String _versao;
	private String _Id;

	public Ide getIde() {
		return IdeObject;
	}

	public Emit getEmit() {
		return EmitObject;
	}

	public Dest getDest() {
		return DestObject;
	}

	public Det getDet() {
		return DetObject;
	}

	public Total getTotal() {
		return TotalObject;
	}

	public Transp getTransp() {
		return TranspObject;
	}

	public Cobr getCobr() {
		return CobrObject;
	}

	public Pag getPag() {
		return PagObject;
	}

	public InfAdic getInfAdic() {
		return InfAdicObject;
	}

	public String get_versao() {
		return _versao;
	}

	public String get_Id() {
		return _Id;
	}

	public void setIde(Ide ideObject) {
		this.IdeObject = ideObject;
	}

	public void setEmit(Emit emitObject) {
		this.EmitObject = emitObject;
	}

	public void setDest(Dest destObject) {
		this.DestObject = destObject;
	}

	public void setDet(Det detObject) {
		this.DetObject = detObject;
	}

	public void setTotal(Total totalObject) {
		this.TotalObject = totalObject;
	}

	public void setTransp(Transp transpObject) {
		this.TranspObject = transpObject;
	}

	public void setCobr(Cobr cobrObject) {
		this.CobrObject = cobrObject;
	}

	public void setPag(Pag pagObject) {
		this.PagObject = pagObject;
	}

	public void setInfAdic(InfAdic infAdicObject) {
		this.InfAdicObject = infAdicObject;
	}

	public void set_versao(String _versao) {
		this._versao = _versao;
	}

	public void set_Id(String _Id) {
		this._Id = _Id;
	}
}
