package br.com.geradorASN.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geradorASN.entity.xml.Gerado;

@Transactional
@Service("zipService")
public class ZipService {

	private static final Logger log = LoggerFactory.getLogger(ZipService.class);

	private static String ZIP_DESTINATION_FOLDER = "src/main/resources/zip/";

	private static String XML_DESTINATION_FOLDER = "src/main/resources/xml/";

	@Autowired
	ResourceLoader resourceLoader;

	public void baixarArquivosZip(List<Gerado> listaGerado) throws IOException, ZipException {

		File xmlDestinationDirectory = createFileDirectory(XML_DESTINATION_FOLDER);
		File zipDestinationDirectory = createFileDirectory(ZIP_DESTINATION_FOLDER);

		listaGerado.forEach(gerado -> {
			try {
				baixarZip(gerado);
				extrairZip(gerado);
				deleteZip(gerado);
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		
		deleteFileDirectory(zipDestinationDirectory);

	}

	private File createFileDirectory(String directory) {

		File fileDirectory = new File(directory);

		if (!fileDirectory.exists()) {
			fileDirectory.mkdirs();
			log.debug("Diretório criado: {}", directory);
		}

		log.info("Definido diretório: {}", directory);
		return fileDirectory;
	}

	private void deleteFileDirectory(File fileDirectory) {
		fileDirectory.delete();
		log.info("Deletado diretório: {}", fileDirectory.getAbsoluteFile());
	}
	
	private void deleteZip(Gerado gerado) {
		(new File(ZIP_DESTINATION_FOLDER + gerado.getFileName())).delete();
		log.info("Deletado o arquivo: {}", gerado.getFileName());
	}

	private void baixarZip(Gerado gerado) throws IOException {

		URL url = new URL(gerado.getPath());
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();

		log.info("Conectando a url: {}", gerado.getPath());

		FileOutputStream out = new FileOutputStream(ZIP_DESTINATION_FOLDER + gerado.getFileName());
		byte[] b = new byte[2048];
		int count;

		while ((count = in.read(b)) >= 0) {
			out.write(b, 0, count);
		}

		out.flush();
		out.close();
		in.close();

	}

	private void extrairZip(Gerado gerado) throws IOException {

		FileInputStream fis;

		byte[] buffer = new byte[1024];

		fis = new FileInputStream(ZIP_DESTINATION_FOLDER + gerado.getFileName());
		ZipInputStream zis = new ZipInputStream(fis);
		ZipEntry ze = zis.getNextEntry();

		while (ze != null) {
			String fileName = ze.getName();
            File newFile = new File(XML_DESTINATION_FOLDER + fileName);
            log.info("Extraindo no caminho: "+ newFile.getAbsolutePath());

            new File(newFile.getParent()).mkdirs();         
			FileOutputStream fos = new FileOutputStream(newFile);
			
			int len;
			
			while ((len = zis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			
			fos.close();

			zis.closeEntry();
			ze = zis.getNextEntry();
		}

		zis.closeEntry();
		zis.close();
		fis.close();
		
	}

}
