package p466.degree_flowchart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import p466.degree_flowchart.data.StudentRepository;
import p466.degree_flowchart.model.Student;

@SpringBootApplication
public class DegreeFlowchartApplication {

    public static void main(String[] args) {
      SpringApplication.run(DegreeFlowchartApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(StudentRepository studentRepo) {
			return new CommandLineRunner() {
				@Override
				public void run(String... args) throws Exception {
					studentRepo.save(new Student(
						"1001",
						"password123",
						"John",
						"Doe",
						"jdoe@iu.edu",
						"Computer Science",
						"May 2026"
					));

					studentRepo.save(new Student(
						"1002",
						"password456",
						"Jane",
						"Smith",
						"jsmith@iu.edu",
						"Intelligent Systems Engineering",
						"December 2026"
					));

					studentRepo.save(new Student(
						"1003",
						"password789",
						"Michael",
						"Johnson",
						"mjohnson@iu.edu",
						"Data Science",
						"May 2026"
					));

					studentRepo.save(new Student(
						"1004",
						"secure2024",
						"Emily",
						"Brown",
						"ebrown@iu.edu",
						"Computer Science",
						"December 2025"
					));

					studentRepo.save(new Student(
						"1005",
						"student123",
						"David",
						"Wilson",
						"dwilson@iu.edu",
						"Informatics",
						"May 2026"
				));
			}
		};
	}
}