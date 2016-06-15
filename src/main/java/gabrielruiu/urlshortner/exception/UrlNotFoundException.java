package gabrielruiu.urlshortner.exception;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
public class UrlNotFoundException extends Exception {

    public UrlNotFoundException(String urlIdentifier) {
        super(String.format("Couldn't find url with identifier = [%s]", urlIdentifier));
    }
}
