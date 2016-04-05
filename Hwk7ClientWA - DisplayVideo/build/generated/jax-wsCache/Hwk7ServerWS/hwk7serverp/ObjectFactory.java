
package hwk7serverp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hwk7serverp package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Hwk7Op_QNAME = new QName("http://Hwk7ServerP/", "hwk7op");
    private final static QName _Hwk7OpResponse_QNAME = new QName("http://Hwk7ServerP/", "hwk7opResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hwk7serverp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hwk7OpResponse }
     * 
     */
    public Hwk7OpResponse createHwk7OpResponse() {
        return new Hwk7OpResponse();
    }

    /**
     * Create an instance of {@link Hwk7Op }
     * 
     */
    public Hwk7Op createHwk7Op() {
        return new Hwk7Op();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hwk7Op }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Hwk7ServerP/", name = "hwk7op")
    public JAXBElement<Hwk7Op> createHwk7Op(Hwk7Op value) {
        return new JAXBElement<Hwk7Op>(_Hwk7Op_QNAME, Hwk7Op.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hwk7OpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Hwk7ServerP/", name = "hwk7opResponse")
    public JAXBElement<Hwk7OpResponse> createHwk7OpResponse(Hwk7OpResponse value) {
        return new JAXBElement<Hwk7OpResponse>(_Hwk7OpResponse_QNAME, Hwk7OpResponse.class, null, value);
    }

}
