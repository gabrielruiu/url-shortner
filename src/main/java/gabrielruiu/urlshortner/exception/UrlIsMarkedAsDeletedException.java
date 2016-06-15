package gabrielruiu.urlshortner.exception;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
public class UrlIsMarkedAsDeletedException extends Exception {

    public UrlIsMarkedAsDeletedException(String urlIdentifier) {
        super(String.format("Url with identifier=[%s] is marked as deleted", urlIdentifier));
    }
}
