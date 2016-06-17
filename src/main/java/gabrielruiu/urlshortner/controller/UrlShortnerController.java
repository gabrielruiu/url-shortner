package gabrielruiu.urlshortner.controller;

import gabrielruiu.urlshortner.domain.Url;
import gabrielruiu.urlshortner.exception.UrlIsMarkedAsDeletedException;
import gabrielruiu.urlshortner.exception.UrlNotFoundException;
import gabrielruiu.urlshortner.service.CompressedUrlResolver;
import gabrielruiu.urlshortner.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @Autowired
    private CompressedUrlResolver compressedUrlResolver;

    @RequestMapping("/d/{url-identifier}")
    public ModelAndView decompressUrl(@PathVariable("url-identifier") String urlIdentifier) {
        try {
            Url url = urlShortnerService.findUrlByUrlIdentifier(urlIdentifier);
            return new ModelAndView("redirect:" + url.getTargetUrl());
        } catch (UrlNotFoundException | UrlIsMarkedAsDeletedException e) {
            return null;
        }
    }

    @RequestMapping(value = "compress", method = RequestMethod.GET)
    public String compressUrlForm(Model model) {
        model.addAttribute("url", new Url());
        return "compress";
    }

    @RequestMapping(value = "compress", method = RequestMethod.POST)
    public ModelAndView compressUrl(@ModelAttribute Url url) {
        Url savedUrl = urlShortnerService.saveUrlWithTarget(url.getTargetUrl());
        return new ModelAndView("result", "compressedUrl", compressedUrlResolver.determineCompressedUrl(savedUrl));
    }
}
