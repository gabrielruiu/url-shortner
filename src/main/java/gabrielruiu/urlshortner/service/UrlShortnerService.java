package gabrielruiu.urlshortner.service;

import gabrielruiu.urlshortner.domain.Url;
import gabrielruiu.urlshortner.exception.UrlIsMarkedAsDeletedException;
import gabrielruiu.urlshortner.exception.UrlNotFoundException;
import gabrielruiu.urlshortner.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
@Service
public class UrlShortnerService {

    @Value("${url.identifier.length}")
    private int urlIdentifierLength;

    @Autowired
    private UrlRepository urlRepository;

    public Url findUrlByUrlIdentifier(String urlIdentifier) throws UrlNotFoundException, UrlIsMarkedAsDeletedException {
        Url url = urlRepository.findByPublicIdentifier(urlIdentifier);
        if (url == null) {
            throw new UrlNotFoundException(urlIdentifier);
        }
        if (url.getDeletedDate() != null) {
            throw new UrlIsMarkedAsDeletedException(urlIdentifier);
        }
        return url;
    }
}
