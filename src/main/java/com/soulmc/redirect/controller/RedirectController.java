package com.soulmc.redirect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import com.soulmc.redirect.RedirectManager;

@Controller
public class RedirectController {

    @GetMapping("/{page}")
    public RedirectView redirectToExternalUrl(@PathVariable String page) {
        String redirectUrl = RedirectManager.getRedirectUrl(page);

        if (redirectUrl != null) {
            return new RedirectView(redirectUrl);
        } else {
            return new RedirectView("/not-found");
        }
    }

    @GetMapping("/")
    public RedirectView redirectToDefault() {
        return new RedirectView(RedirectManager.getDefaultRedirect());
    }
}
