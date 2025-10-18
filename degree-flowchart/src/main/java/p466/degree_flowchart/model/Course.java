package p466.degree_flowchart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
  @Id
  private final String id;
  private final String name;
  private final Category category;
  private final int credits;
  private final String prerequisite;

  public Course(String id, String name, Category category, int credits, String prerequisite) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.credits = credits;
    this.prerequisite = prerequisite;
  }

  private Course() {
    this.id = "";
    this.name = "";
    this.category = null;
    this.credits = 0;
    this.prerequisite = "";
  }

  public enum Category {
    CORE, ELECTIVE, MATH, SCIENCE, HUMANITIES
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Category getCategory() {
    return category;
  }

  public int getCredits() {
    return credits;
  }

  public String getPrerequisite() {
    return prerequisite;
  }

  @Override
  public String toString() {
    return "Course [id=" + id + ", name=" + name + ", category=" + category + 
            ", credits=" + credits + ", prerequisite=" + prerequisite + "]";
  }
}
