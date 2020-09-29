package myLibrary;

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
	
}
