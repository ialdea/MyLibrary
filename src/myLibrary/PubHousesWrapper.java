package myLibrary;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "publishing_houses")
public class PubHousesWrapper {

	@XmlElement(name = "publishing_house")
	public List<PublishingHouse> list;
	
	public PubHousesWrapper() {}
	
	public PubHousesWrapper(List<PublishingHouse> ls) {
		list = ls;
	}
}
