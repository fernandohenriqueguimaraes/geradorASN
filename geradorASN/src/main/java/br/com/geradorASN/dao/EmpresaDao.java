package br.com.geradorASN.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.geradorASN.entity.Empresa;

@Repository("empresaRepository")
public interface EmpresaDao extends CrudRepository<Empresa, String> {

	@Query("SELECT e FROM Empresa e WHERE e.cnpj = ?1")
	List<Empresa> getEmpresaByCnpj(String cnpj);

}
