package com.durgesh.ecommerce.service;

import com.durgesh.ecommerce.model.Product;
import com.durgesh.ecommerce.model.User;
import com.durgesh.ecommerce.model.UserDto;
import com.durgesh.ecommerce.repo.IProductRepo;
import com.durgesh.ecommerce.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepo iUserRepo;
    @Autowired
    private IProductRepo iProductRepo;

   public String  addUser( User user){
       iUserRepo.save(user);
       return "User added Succesfully";
   }

   public String linkProductWithUser( int userId, int productId){
       User user=this.iUserRepo.findById(userId).get();
       user.getProducts().add(iProductRepo.findById(productId).get());
       iUserRepo.save(user);

       return "product linked succesfully to user";}


    public List<User> getAll() {
       return iUserRepo.findAll();
    }

    public User getById(int id) {
       return this.iUserRepo.findById(id).get();
    }

    public String deleteProductFromUser(int id1,int id2) {
       User user=this.iUserRepo.findById(id1).get();
       Product res=new Product();

      for(Product p:user.getProducts()){
          if(p.getProductId()==id2){
              res=p;

          }

      }

      user.getProducts().remove(res);


        iUserRepo.save(user);
      return "removed succesfully";

    }

    public UserDto ValidateUser(User user){
       if(user.getEmail().equals("admin@ecommerce.com")&&user.getPassword().equals("1234")){
           return new UserDto("Admin");
       }

       return new UserDto("User");
    }
}
