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
//import com.packt.webstore.exception.UserNotFoundException;
import com.packt.webstore.service.*;

@Controller
@RequestMapping(value="rest/user")
public class UsersRestController {
@Autowired
private UserService usersService;

@RequestMapping(method = RequestMethod.POST, produces = "application/json")
public @ResponseBody Users create(@RequestBody Users user) {
return usersService.create(user);
}

@RequestMapping(value = "/{UserId}", method = RequestMethod.GET , produces = "application/json")
public @ResponseBody Users read(@PathVariable(value = "UserId") int id) {
	Users  uu = usersService.read(id);
			
	System.out.println(uu.getlName());
	return uu;
}

@RequestMapping(value = "/{UserId}", method = RequestMethod.PUT)
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public void update(@PathVariable(value = "id") int id,
@RequestBody Users user) {
usersService.update(id, user);
}

@RequestMapping(value = "/{UserId}", method = RequestMethod.DELETE)
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public void delete(@PathVariable(value = "id") int id) {
	usersService.delete(id);
}

@ExceptionHandler(IllegalArgumentException.class)
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Illegalrequest, please verify your payload")
public void handleClientErrors(Exception ex) { }
@ExceptionHandler(Exception.class)
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason="Internal server error")
public void handleServerErrors(Exception ex) { }
}

