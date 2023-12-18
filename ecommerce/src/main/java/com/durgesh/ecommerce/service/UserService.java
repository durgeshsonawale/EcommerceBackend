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
    @Autowired
    private GenerateToken generateToken;

   public String  addUser( User user){
       if(iUserRepo.findFirstByEmail(user.getEmail())!=null){
           return "already exist";
       }
       iUserRepo.save(user);
       return "User added Succesfully";
   }

   public String linkProductWithUser( int userId, int productId,int quant){
       User user=this.iUserRepo.findById(userId).get();
       Product product=iProductRepo.findById(productId).get();
       if(iProductRepo.findByProductIdAndUsers(productId,user)!=null){
           product.setQuantity(product.getQuantity()+quant);
           iUserRepo.save(user);
           return "Added";
       }

       product.setQuantity(quant);
       user.getProducts().add(product);
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
              p.setQuantity(1);
              iProductRepo.save(p);
              res=p;


          }

      }

      user.getProducts().remove(res);


        iUserRepo.save(user);
      return "removed succesfully";

    }

    public UserDto ValidateUser(User user){


       User user1=iUserRepo.findFirstByEmailAndPassword(user.getEmail(),user.getPassword());
       if(user1!=null )
       return new UserDto(user1.getUserId(),generateToken.generateToken(user1));
        else return new UserDto(-1,null);
    }


}
