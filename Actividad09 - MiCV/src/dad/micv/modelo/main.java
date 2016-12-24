package dad.micv.modelo;

import java.io.File;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class main {

	
	//JAXB = Java Architecture for XML. Binding
	public static void main(String[] args) throws Exception {
		
		//TipoTelefono tipo = TipoTelefono.MOVIL;
		
		Nacionalidad americano = new Nacionalidad();
		americano.setDenominacion("Estadounidense");
		Nacionalidad japonesa = new Nacionalidad();
		japonesa.setDenominacion("Japonesa");
		
		Telefono telefono1 = new Telefono();
		telefono1.setNumero("665606166");
		telefono1.setTipo(TipoTelefono.MOVIL);
		Telefono telefono2 = new Telefono();
		telefono2.setNumero("922983142");
		telefono2.setTipo(TipoTelefono.DOMICILIO);
		
		Email email1 = new Email();
		email1.setDireccion("killianpro@gmail.com");
		Email email2 = new Email();
		email2.setDireccion("killianpro@hotmail.com");
		
		Web web1 = new Web();
		web1.setUrl("www.Archert.com");
		
		Titulo titulo1 = new Titulo();
		titulo1.setDesde(LocalDate.of(2008, 05, 6));
		titulo1.setHasta(LocalDate.of(2010, 11, 16));
		titulo1.setDenominacion("Bachillerato");
		titulo1.setOrganizador("IES Poeta Viana");
		
		Titulo titulo2 = new Titulo();
		titulo2.setDesde(LocalDate.of(2011, 05, 6));
		titulo2.setHasta(LocalDate.of(2013, 11, 16));
		titulo2.setDenominacion("Desarrollo Aplicaciones Web");
		titulo2.setOrganizador("IES Cesar Marique");
		
		Experiencia exp1 = new Experiencia();
		exp1.setDesde(LocalDate.of(2013, 05, 6));
		exp1.setHasta(LocalDate.of(2013, 07, 6));
		exp1.setDenominacion("Programador Web");
		exp1.setEmpleador("Axedra");
		
		Experiencia exp2 = new Experiencia();
		exp2.setDesde(LocalDate.of(2013, 07, 26));
		exp2.setHasta(LocalDate.of(2013, 9, 6));
		exp2.setDenominacion("Programador Web");
		exp2.setEmpleador("Spalopia");
		
		Conocimiento cono1 = new Conocimiento();
		cono1.setDenominacion("javaScript");
		cono1.setNivel(Nivel.AVANZADO);
		
		Conocimiento cono2 = new Conocimiento();
		cono2.setDenominacion("PHP");
		cono2.setNivel(Nivel.MEDIO);
		
		Idioma idioma1 = new Idioma();
		idioma1.setCertificacion("Bachiller");
		idioma1.setDenominacion("Ingles");
		idioma1.setNivel(Nivel.BASICO);
		
		CV cv = new CV();
		
		cv.getPersonal().setIdentificacion("12345678Z");
		cv.getPersonal().setNombre("Chuck");
		cv.getPersonal().setApellidos("Norris");
		cv.getPersonal().setFechaNacimiento(LocalDate.of(1942, 10, 6));
		cv.getPersonal().getNacionalidades().add(americano);
		cv.getPersonal().getNacionalidades().add(japonesa);
		cv.getPersonal().setDireccion("Calle Molin");
		cv.getPersonal().setCodigoPostal("38010");
		cv.getPersonal().setPais("España");
		
		cv.getContacto().getTelefonos().add(telefono1);
		cv.getContacto().getTelefonos().add(telefono2);
		cv.getContacto().getEmails().add(email1);
		cv.getContacto().getEmails().add(email2);
		cv.getContacto().getWebs().add(web1);
		
		cv.getFormacion().add(titulo1);
		cv.getFormacion().add(titulo2);
		
		cv.getExperiencias().add(exp1);
		cv.getExperiencias().add(exp2);
		
		cv.getHabilidades().add(cono1);
		cv.getHabilidades().add(cono2);
		cv.getHabilidades().add(idioma1);
		
		cv.save(new File("micurriculum.xml"));
		
		CV cv2 = CV.read(new File("micurriculum.xml"));
		System.out.println(cv2.getContacto().getTelefonos());
	}

}
