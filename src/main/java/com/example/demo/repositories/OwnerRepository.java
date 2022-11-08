package com.example.demo.repositories;

import com.example.demo.entities.Bien;
import com.example.demo.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository
extends JpaRepository<Owner, Long> {

    //@Query("SELECT s FROM Bien s WHERE s.name = ?1")
    //Optional<Owner> findBienByName(String name);

    @Query("SELECT s FROM Owner s WHERE s.telephone = ?1")
    Optional<Owner> findOwnerByTelephone(Integer telephone);
    @Query("SELECT s.biens FROM Owner s WHERE s.id = ?1")
    List<Bien> getBiensByOwner(Long id);
    @Query("SELECT s FROM Owner s WHERE s.id=?1")
    Optional<Owner> findOwnerById(Long id);
    @Query("SELECT s FROM Owner s WHERE s.username=?1")
    Optional<Owner> findOwnerByUsername(String username);
    @Query("SELECT s FROM Owner s WHERE s.fullName=?1")
    Optional<Owner> findOwnerByName(String fullName);

}
