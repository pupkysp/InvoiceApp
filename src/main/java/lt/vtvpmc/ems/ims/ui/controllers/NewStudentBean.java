package lt.vtvpmc.ems.ims.ui.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import lt.vtvpmc.ems.ims.entities.Student;
import lt.vtvpmc.ems.ims.repositories.Qqqqq;


public class NewStudentBean {
	
	@Autowired
    Qqqqq qq;
    @PersistenceContext
    private EntityManager entityManager;
    
    private String studentFirstName;
    private String studentLastName;

    @Transactional
    public String save() {
        Student student = new Student(studentFirstName, studentLastName);
        entityManager.persist(student);
        return "main";
    }
    
    public String getStudentFirstName() {
        return studentFirstName;
        
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }


}
