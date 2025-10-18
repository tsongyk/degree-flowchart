package p466.degree_flowchart.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class DegreeProgress {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank(message = "Student name is required")
  private String studentName;

  @NotBlank(message = "Student ID is required")
  private String studentId;

  @NotBlank(message = "Major is required")
  private String major;

  @NotBlank(message = "Expected graduation date is required")
  private String expectedGraduation;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Semester> semesters = new ArrayList<>();

  public void addSemester(Semester semester) {
    semesters.add(semester);
  }

  public int getTotalCreditsCompleted() {
    return semesters.stream()
            .mapToInt(Semester::getTotalCredits)
            .sum();
  }

  public double getProgressPercentage() {
    int totalRequired = 120; // Typical bachelor's degree
    return (getTotalCreditsCompleted() / (double) totalRequired) * 100;
  }

  // Getters and setters
  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getExpectedGraduation() {
    return expectedGraduation;
  }

  public void setExpectedGraduation(String expectedGraduation) {
    this.expectedGraduation = expectedGraduation;
  }

  public List<Semester> getSemesters() {
    return semesters;
  }

  public void setSemesters(List<Semester> semesters) {
    this.semesters = semesters;
  }

  @Override
  public String toString() {
    return "DegreeProgress [studentName=" + studentName + ", studentId=" + studentId + 
            ", major=" + major + ", expectedGraduation=" + expectedGraduation + 
            ", semesters=" + semesters + "]";
  }
}