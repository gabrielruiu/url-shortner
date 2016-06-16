package gabrielruiu.urlshortner.controller;

import gabrielruiu.urlshortner.domain.Url;
import gabrielruiu.urlshortner.exception.UrlIsMarkedAsDeletedException;
import gabrielruiu.urlshortner.exception.UrlNotFoundException;
import gabrielruiu.urlshortner.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
@Controller
public class UrlShortnerController {

    @Autowired
    private UrlShortnerService urlShortnerService;

    @RequestMapping("/{url-identifier}")
    public ModelAndView decompressUrl(@PathVariable("url-identifier") String urlIdentifier) {
        try {
            Url url = urlShortnerService.findUrlByUrlIdentifier(urlIdentifier);
            return new ModelAndView("redirect:" + url.getTargetUrl());
        } catch (UrlNotFoundException | UrlIsMarkedAsDeletedException e) {
            return null;
        }
    }

    @RequestMapping(value = "compress/{target-url}", method = RequestMethod.GET)
    public ModelAndView compressUrl(@PathVariable("target-url") String targetUrl) {
        Url url = urlShortnerService.saveUrlWithTarget(targetUrl);
        return new ModelAndView("compress", "publicIdentifier", url.getPublicIdentifier());
    }
}
