package com.soulmc.redirect.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.soulmc.redirect.utils.Utils;

@RestController
public class NotFoundController {

	@GetMapping("/not-found")
	public String index() {
		return Utils.getResourceFileContent("not-found.html");
	}
}
