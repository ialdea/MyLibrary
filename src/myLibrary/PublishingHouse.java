package myLibrary;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PublishingHouse {

	@XmlElement
	private String name;
	
	public String getName() {return this.name;}
	
	// daca nu ai puse adnotarile pt xml tre sa scrii setarii, altfel in xml elementul apare ca fiind null;
//	public void setName(String n) {name = n;}
	
	public PublishingHouse() {}
	
	public PublishingHouse(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public static void pubHouseToXml(PublishingHouse ph) {
		try {
			JAXBContext context = JAXBContext.newInstance(PublishingHouse.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("publishingHouse.xml");
			marshaller.marshal(ph, file);
			marshaller.marshal(ph, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void xmlToPubHouse() {
		try {
			JAXBContext context = JAXBContext.newInstance(PublishingHouse.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("publishingHouse.xml");
			PublishingHouse ph = (PublishingHouse) unmarshaller.unmarshal(file);
			System.out.println(ph);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
}
