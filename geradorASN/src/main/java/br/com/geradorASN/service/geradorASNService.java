package br.com.geradorASN.service;

import java.io.IOException;
import java.util.List;

public interface geradorASNService<T> {

		public List<T> carregarDados() throws IOException;

}
