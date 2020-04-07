package br.com.geradorASN.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.geradorASN.entity.Produto;

@Repository("produtoRepository")
public interface ProdutoDao extends CrudRepository<Produto, Integer> {
	
	@Query("SELECT p FROM Produto p WHERE p.partNumber = ?1")
	List<Produto> getProdutoByPartNumber(String partNumber);
	
}
