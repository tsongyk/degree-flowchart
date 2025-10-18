package p466.degree_flowchart.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import p466.degree_flowchart.model.Student;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    
    Optional<Student> findByStudentIdAndPassword(String studentId, String password);
    
    Optional<Student> findByEmail(String email);
}