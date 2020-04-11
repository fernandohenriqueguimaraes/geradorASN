package br.com.geradorASN.service;

import java.io.IOException;
import java.util.List;

public interface GeradorTabelasService<T> {

		public List<T> carregarDados() throws IOException;

}
