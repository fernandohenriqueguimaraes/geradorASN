package br.com.geradorASN.entity.xml;

public class Cobr {
	
	Fat FatObject;
	Dup DupObject;

	public Fat getFat() {
		return FatObject;
	}

	public Dup getDup() {
		return DupObject;
	}

	public void setFat(Fat fatObject) {
		this.FatObject = fatObject;
	}

	public void setDup(Dup dupObject) {
		this.DupObject = dupObject;
	}
}