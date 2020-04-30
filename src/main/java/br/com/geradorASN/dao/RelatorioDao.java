package br.com.geradorASN.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.geradorASN.entity.Relatorio;

@Repository("relatorioRepository")
public interface RelatorioDao extends CrudRepository<Relatorio, Integer> {
	
	@Query("SELECT r FROM Relatorio r WHERE r.reference = ?1")
	List<Relatorio> getRelatorioByReference(String reference);

}
