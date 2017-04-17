package de.axnx;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ecbexchange.Cube;

public class Main {

	public static void main(String[] args) {
		String url = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
		
		try {

			try {

				File xmlFile = new File("eurofxref-daily.xml");
				
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(xmlFile);
				NodeList nodeList =doc.getElementsByTagName("Cube");
				
				for (int i = 0; i < nodeList.getLength(); i++){
					if(i<2) continue;
					Node node = nodeList.item(i);
					System.out.println();
					Element fstElmnt = (Element) node;
					NodeList pharmacyList = fstElmnt.getElementsByTagName("cube");
					//Element pharmacyElement = (Element) pharmacyList.item(0);
					//System.out.println(pharmacyElement.getAttribute(name));
					//HashMap<String,String>map=new HashMap<String,String>();
					//map.put("name", pharmacyElement.getAttribute("name"));
					//map.put("distance", pharmacyElement.getAttribute("phone"));
					//list.add(map);
				}
				
				
//				JAXBContext jaxbContext = JAXBContext.newInstance(Cube.class);
//
//				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//				Cube cube = (Cube) jaxbUnmarshaller.unmarshal(file);
//				System.out.println(cube);

			  } catch (Exception e) {
				e.printStackTrace();
			  }
		} catch (Exception e){
			System.out.println("Exception" + e.getMessage());
		}

	}

}
