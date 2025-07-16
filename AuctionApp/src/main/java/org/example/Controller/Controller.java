package org.example.Controller;

import org.example.Entity.User;
import org.example.Repository.AuctionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hello")
public class Controller {

@Autowired
private AuctionRepo repo;


    @GetMapping("/all")
    public List<User> getAllUsers(User user)
    {
        return repo.findAll();
    }

    @PostMapping("/add")
    public  User createUser (@RequestBody User user )
    {
       return  repo.save(user);
    }

   @DeleteMapping("/remove/{id}")
    public void removeUser(@PathVariable Long id)
   {
        repo.deleteById(id);
   }

  @PutMapping("/update/{id}")
  public void updateser(@PathVariable Long id, @RequestBody User user)
  {

      Optional<User> existingUser = repo.findById(id);
      User currentUser = existingUser.get();
      currentUser.setName(user.getName());
      repo.save(currentUser);


  }

}
