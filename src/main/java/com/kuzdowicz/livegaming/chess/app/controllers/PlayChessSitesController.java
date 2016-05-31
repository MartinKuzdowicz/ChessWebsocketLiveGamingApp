package com.kuzdowicz.livegaming.chess.app.controllers;

import java.security.Principal;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayChessSitesController {

	private static final Logger logger = Logger.getLogger(PlayChessSitesController.class);

	@RequestMapping(value = "/play-chess-with-computer", method = RequestMethod.GET)
	public ModelAndView playChessWithComputer(Principal principal) {
		logger.info("playChessWithComputer()");

		ModelAndView playChessWithCompPageModel = new ModelAndView("playChessWithComputer");
		addBasicObjectsToModelAndView(playChessWithCompPageModel, principal);

		return playChessWithCompPageModel;
	}

	@RequestMapping(value = "/play-chess-with-user", method = RequestMethod.GET)
	public ModelAndView playChessWithUser(Principal principal) {
		logger.info("playChessWithUser()");

		ModelAndView playChessWithUserPageModel = new ModelAndView("playChessWithUser");
		addBasicObjectsToModelAndView(playChessWithUserPageModel, principal);

		return playChessWithUserPageModel;
	}

	private void addBasicObjectsToModelAndView(ModelAndView mav, Principal principal) {
		mav.addObject("currentUserName",
				Optional.ofNullable(principal).filter(p -> p != null).map(p -> p.getName()).orElse(""));

	}

}
