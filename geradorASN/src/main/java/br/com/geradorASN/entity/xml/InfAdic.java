package br.com.geradorASN.entity.xml;

import java.util.ArrayList;

public class InfAdic {
	 private String infCpl;
	 ArrayList <ObsCont> obsCont = new ArrayList <ObsCont> ();

	 public String getInfCpl() {
	  return infCpl;
	 }

	 public void setInfCpl(String infCpl) {
	  this.infCpl = infCpl;
	 }
	}