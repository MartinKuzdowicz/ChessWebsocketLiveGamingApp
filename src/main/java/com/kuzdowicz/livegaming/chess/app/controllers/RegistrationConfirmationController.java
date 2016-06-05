package com.kuzdowicz.livegaming.chess.app.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kuzdowicz.livegaming.chess.app.domain.UserAccount;
import com.kuzdowicz.livegaming.chess.app.repositories.UsersRepository;

@Controller
@PropertySource("classpath:messages.properties")
public class RegistrationConfirmationController {

	private final static Logger logger = Logger.getLogger(RegistrationConfirmationController.class);

	private final UsersRepository usersRepository;
	private final Environment env;

	@Autowired
	public RegistrationConfirmationController(UsersRepository usersRepository, Environment env) {
		this.usersRepository = usersRepository;
		this.env = env;
	}

	@RequestMapping(value = "registration/confirm/{hash}", method = RequestMethod.GET)
	public ModelAndView confirmEmailAccount(@PathVariable("hash") String hash) {
		logger.debug("confirmEmailAccount()");

		UserAccount user = usersRepository.findOneByRegistrationHashString(hash);

		if (user != null) {
			user.setIsRegistrationConfirmed(true);
			user.setRegistrationHashString("");
			usersRepository.save(user);
		} else {
			ModelAndView error = new ModelAndView("error");
			error.addObject("errorMessage", env.getProperty("error.registration.confirm.failed"));
			return error;
		}

		ModelAndView confirmRegistrationMsg = new ModelAndView("confirmRegistrationMessage");
		confirmRegistrationMsg.addObject("username", user.getUsername());
		return confirmRegistrationMsg;
	}

}
