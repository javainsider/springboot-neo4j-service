package com.javainsider.springbootneo4j.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/welcome")
@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request data"),
		@ApiResponse(code = 500, message = "Internal Server error") })
@Api(value = "Welcome Controller", tags = "Welcome API", description = "Sample REST API to test neo4j")
public class WelcomeController {

	@ApiOperation(value = "Just say hello", notes = "Just say hello", tags = "Welcome API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Hello success"),
			@ApiResponse(code = 204, message = "Hello not found"), })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public ResponseEntity<?> sayHello(@RequestParam("name") String name) {
		return new ResponseEntity<>("Hello : " + name, HttpStatus.OK);
	}

}
