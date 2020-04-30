package br.com.geradorASN.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorASN.dao.RelatorioDao;
import br.com.geradorASN.entity.Relatorio;

@Transactional
@Service("relatorioService")
public class RelatorioService {
	
	@Autowired
	private RelatorioDao relatorioRepository;
	
	private static final Logger log = LoggerFactory.getLogger(RelatorioService.class);
	
	public void salvarRelatorio(Relatorio relatorio) {
		
		if(!getRelatorioByReference(relatorio.getReference()).isEmpty()) {
			log.error("Registro já encontrado na tabela Relatório.");
			return;
		}
		
		relatorio = relatorioRepository.save(relatorio);
		log.info("Salvo o dado resultante na tabela Relatório: " + relatorio.toString());
	}
	
	public List<Relatorio> getRelatorioByReference(String reference) {
		return relatorioRepository.getRelatorioByReference(reference);
	}
	
	public List<Relatorio> listarResultados() {
		return ((List<Relatorio>) relatorioRepository.findAll()).stream().sorted(Comparator.comparingLong(Relatorio::getId)
		        .reversed())
	            .collect(Collectors.toList());
	}

}
