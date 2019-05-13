package user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import user.model.User;
import user.service.UserService;

@CrossOrigin("*")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		User user = userService.getUserById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/registerUser/")
	@ResponseBody
	public String registerUser(@RequestBody User user) {
		try {
			userService.registerUser(user);
			return "User created successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/loginUser/")
	@ResponseBody
	public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) {
		try {
			User currentUser = null;
			if(user.getUserID() != null) {
				currentUser = userService.getUserByUserID(user.getUserID().toString());
				System.out.println(currentUser);
			}
			Map<String, String> response = new HashMap();
			if(currentUser != null) {
				if(currentUser.getPassword().equals(user.getPassword())) {			
					response.put("userID", currentUser.getUserID());
					response.put("firstName", currentUser.getFirstName());
					response.put("lastName", currentUser.getLastName());
					return ResponseEntity.ok(response);
				} else {
					response.put("error", "403");
					response.put("errorMessage", "Invalid User Details");
					return ResponseEntity.ok(response);
				}
			} else {
				response.put("error", "403");
				response.put("errorMessage", "No User Details");
				return ResponseEntity.ok(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
