package gabrielruiu.urlshortner.repository;

import gabrielruiu.urlshortner.domain.Url;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
public interface UrlRepository extends CrudRepository<Url, Long> {

    Url findByPublicIdentifier(String publicIdentifier);
}
