package dad.micv.modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
@XmlType
public class Web {
	private StringProperty url;
	public Web(){
		url = new SimpleStringProperty(this, "url");
	}
	
	
	public StringProperty urlProperty() {
		return this.url;
	}
	@XmlElement
	public String getUrl() {
		return this.urlProperty().get();
	}
	
	public void setUrl(final String url) {
		this.urlProperty().set(url);
	}
	
	
	
}
