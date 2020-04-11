package br.com.geradorASN.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.geradorASN.entity.Parametro;

@Repository("parametroRepository")
public interface ParametroDao extends CrudRepository<Parametro, Integer> {
	
	@Query("SELECT p FROM Parametro p WHERE p.chave = ?1")
	List<Parametro> getParametroByChave(String chave);
	
	@Query("UPDATE Parametro p SET p.valor = ?1 WHERE p.chave = ?1")
	void updateParametroDataCorte(String novaDataCorte, String chave);
	
}
