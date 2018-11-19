//package br.com.clinica.controller; 
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.clinica.exception.ResourceNotFoundException;
//import br.com.clinica.model.User;
//import br.com.clinica.repository.UserRepository;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//	
//	@Autowired
//	UserRepository userRepository;
//	
//	// Get All Users
//	@GetMapping("/users")
//	public List<User> getAllUsers() {
//	    return userRepository.findAll();
//	}
//	
//	// Create a new User
//	@PostMapping("/users")
//	public User createUser(@Valid @RequestBody User User) {
//	    return userRepository.save(User);
//	}
//	
//	// Get a Single User
//	@GetMapping("/users/{id}")
//	public User getUserById(@PathVariable(value = "id") Integer userId) {
//	    return userRepository.findById(userId)
//	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//	}
//	
//	// Update a User
//	@PutMapping("/users/{id}")
//	public User updateUser(@PathVariable(value = "id") Integer userId,
//	                                        @Valid @RequestBody User userDetails) {
//
//	    User user = userRepository.findById(userId)
//	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//
//	    user.setName(userDetails.getName());
//	    user.setLogin(userDetails.getLogin());
//	    user.setNumberChildren(userDetails.getNumberChildren());
//	    user.setPassword(userDetails.getPassword());
//	    user.setDateBirth(userDetails.getDateBirth());
//
//	    User updatedUser = userRepository.save(user);
//	    return updatedUser;
//	}
//	
//	// Delete a User
//	@DeleteMapping("/users/{id}")
//	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer userId) {
//	    User user = userRepository.findById(userId)
//	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//
//	    userRepository.delete(user);
//
//	    return ResponseEntity.ok().build();
//	}
//
//}
