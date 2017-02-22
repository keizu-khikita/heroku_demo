package com.example;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
	
	//@Query("select *.c from Customers c where u.lastname like %:lastname% order by c.id asc")
    List<Customers> findByLastName(String lastname);
}
