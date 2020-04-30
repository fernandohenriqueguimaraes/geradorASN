package br.com.geradorASN.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorASN.entity.Parametro;

@Repository("parametroRepository")
public interface ParametroDao extends CrudRepository<Parametro, Integer> {

	@Query("SELECT p FROM Parametro p WHERE p.chave = ?1")
	List<Parametro> getParametroByChave(String chave);

	@Modifying
	@Query("UPDATE Parametro p SET p.valor = :valor WHERE p.chave = :chave")
	void updateParametro(@Param("valor") String valor, @Param("chave") String chave);

}
