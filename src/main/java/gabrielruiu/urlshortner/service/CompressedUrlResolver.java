package gabrielruiu.urlshortner.service;

import gabrielruiu.urlshortner.domain.Url;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
@Component
public class CompressedUrlResolver {

    @Value("${url.base}")
    private String baseUrl;

    public String determineCompressedUrl(Url url) {
        return baseUrl + "/" + url.getPublicIdentifier();
    }

}
