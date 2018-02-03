package com.packt.webstore.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.packt.webstore.domain.*;
import com.packt.webstore.service.*;

@Controller
@RequestMapping(value="rest/profile")
public class ProfileRestControler {
@Autowired
private ProfileService profileService;

@RequestMapping(method = RequestMethod.POST)
public @ResponseBody Profiles create(@RequestBody Profiles profile) {
return profileService.create(profile);
}

@RequestMapping(value = "/{UserId}", method = RequestMethod.GET , produces = "application/json")
public @ResponseBody Profiles read(@PathVariable(value = "ProfileId") int id) {
	return profileService.read(id);
}


@RequestMapping(value = "/{ProfileId}", method = RequestMethod.PUT)
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public void update(@PathVariable(value = "id") int id,
@RequestBody Profiles profile) {
	profileService.update(id, profile);
}

@RequestMapping(value = "/{ProfileId}", method = RequestMethod.DELETE)
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public void delete(@PathVariable(value = "id") int id) {
	profileService.delete(id);
}

@ExceptionHandler(IllegalArgumentException.class)
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Illegalrequest, please verify your payload")
public void handleClientErrors(Exception ex) { }
@ExceptionHandler(Exception.class)
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason="Internal server error")
public void handleServerErrors(Exception ex) { }
}


