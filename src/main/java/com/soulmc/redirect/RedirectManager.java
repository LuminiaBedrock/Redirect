package com.soulmc.redirect;

import com.soulmc.redirect.utils.config.Config;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RedirectManager {

    @Getter
    private static String defaultRedirect;

    @Getter
    private static final List<Redirect> redirects = new ArrayList<>();

    public static String getRedirectUrl(String name) {
        return redirects.stream()
                .filter(redirect -> redirect.name().equals(name))
                .map(Redirect::url)
                .findFirst()
                .orElse(null);
    }

    public static void loadAll() {
        Config config = Application.getConfig();
        RedirectManager.defaultRedirect = config.node("default-redirect").getString();
        RedirectManager.loadRedirects(config.node("redirects").getMap());
    }

    private static void loadRedirects(Map<String, String> redirectMap) {
        redirectMap.forEach((name, url) -> redirects.add(new Redirect(name, url)));
    }
}

