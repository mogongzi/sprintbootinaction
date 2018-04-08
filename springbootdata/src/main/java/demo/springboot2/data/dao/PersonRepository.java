package demo.springboot2.data.dao;

import demo.springboot2.data.domain.Person;
import demo.springboot2.data.support.CustomRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends CustomRepository<Person, Long> {

    List<Person> findByAddress(String address);
    Person findByNameAndAddress(String name, String address);
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name")String name, @Param("address")String address);
    Person withNameAndAddressNamedQuery(String name, String address);
}
