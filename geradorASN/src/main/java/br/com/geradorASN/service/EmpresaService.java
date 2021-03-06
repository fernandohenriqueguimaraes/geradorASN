package br.com.geradorASN.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opencsv.CSVReader;

import br.com.geradorASN.dao.EmpresaDao;
import br.com.geradorASN.entity.Empresa;

@Transactional
@Service("empresaService")
public class EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaService.class);

	private static String EMPRESA_SOURCE_PATH;

	@Autowired
	private EmpresaDao empresaRepository;

	public EmpresaService(
			@Value("${br.com.geradorASN.service.EmpresaService.DiretorioCSVEmpresa}") String diretorioCSVEmpresa) {
		EMPRESA_SOURCE_PATH = diretorioCSVEmpresa;
	}
	
	@SuppressWarnings("deprecation")
	public List<Empresa> carregarDados() throws IOException {

		List<Empresa> empresas = new ArrayList<Empresa>();

		CSVReader reader = new CSVReader(new FileReader(EMPRESA_SOURCE_PATH),
				ScriptUtils.DEFAULT_STATEMENT_SEPARATOR.charAt(0), '"', 1);
		List<String[]> empresaStringList = reader.readAll();

		for (String[] empresa : empresaStringList) {

			log.info("Extraindo o PRODUTO: " + Arrays.toString(empresa));
			Empresa empresaExtraida = new Empresa();
			empresaExtraida.setCnpj(empresa[0]).setBairro(empresa[1]).setCep(empresa[2]).setCodigoEmpresa(empresa[3])
					.setCodigoPais(empresa[4]).setCodigoERP(empresa[5]).setComplemento(empresa[6])
					.geraASNtoBoolean(empresa[7]).setLogradouro(empresa[8]).setTipo(empresa[9])
					.setMunicipio(empresa[10]).setUf(empresa[11]).setIbgeCode(empresa[12]).setNumero(empresa[13])
					.setPais(empresa[14]).setRazaoSocial(empresa[15]);

			List<Empresa> empresaDb = getEmpresaByCnpj(empresaExtraida.getCnpj());
			if (!empresaDb.isEmpty()) {
				empresas.add(empresaDb.get(0));
				log.error("CNPJ já encontrado na tabela Empresa.");
				continue;
			}

			log.info("Persistindo todos o PRODUTO:" + empresaExtraida.toString());
			empresaRepository.save(empresaExtraida);

			empresas.add(empresaExtraida);

		}

		return empresas;
	}

	public List<Empresa> getEmpresaByCnpj(String cnpj) {
		return empresaRepository.getEmpresaByCnpj(cnpj);
	}

}
