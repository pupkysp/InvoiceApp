package lt.vtvpmc.ems.ims.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lt.vtvpmc.ems.ims.entities.Student;

public interface Qqqqq extends CrudRepository<Student, Long> {
	
	
	List<Student> findAllByFirstNameStartingWith(String fn);

}
