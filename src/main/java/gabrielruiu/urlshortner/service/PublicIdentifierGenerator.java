package gabrielruiu.urlshortner.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
@Component
public class PublicIdentifierGenerator {

    @Value("${url.identifier.length}")
    private int urlIdentifierLength;

    public String generatePublicIdentifier() {
        return RandomStringUtils.randomAlphanumeric(urlIdentifierLength);
    }
}
