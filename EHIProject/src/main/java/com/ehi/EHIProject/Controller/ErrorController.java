package com.ehi.EHIProject.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/error")
public class ErrorController {

	public RedirectView redirectToErrorPage()
	{
		return new RedirectView("error", true);
	}
}
