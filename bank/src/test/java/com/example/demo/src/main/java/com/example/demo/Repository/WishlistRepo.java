package com.example.demo.Repository;

import com.example.demo.Model.User;
import com.example.demo.Model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist,String> {

    @Query("SELECT w FROM Wishlist w WHERE w.user.id = :userId")
    List<Wishlist> getAllItemsByUser(String userId);


}
