package br.com.geradorASN.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLUtil {
	
	private static String XML_PACKAGE = "br.com.geradorASN.entity.xml.";

	public static XStream createXtream(String className) throws ClassNotFoundException {

		XStream xstream = new XStream(new DomDriver());
		xstream.alias(className, Class.forName(XML_PACKAGE + className));
		Class<?>[] classes = new Class[] { Class.forName(XML_PACKAGE + className) };
		XStream.setupDefaultSecurity(xstream);
		xstream.allowTypes(classes);

		return xstream;
	}

}
