package com.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long courseId;
    private String name;
    private String author;

    @Enumerated(EnumType.STRING)
    //EnumType.ORDINAL -> saves values BEGINNER = 0, INTERMEDIATE = 1
    private SkillLevel level;
    private String description;
    private String prereqs;
    private BigDecimal fee;
    private String endGoal;
    private String type;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "course_user", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"),
                        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"))
    private List<User> registeredUsers = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @OrderColumn
    private List<Topic> topics = new ArrayList<>();

    private LocalDateTime createdDateTime;

    @Version
    private LocalDateTime updatedDateTime;

    @Transient //== Ignore it will not save it in database
    //persistance properties will have in database
    private String authorFullName;

    public Course() {
    }

    public Course(String name, String author, SkillLevel level, String description, String prereqs, BigDecimal fee, String endGoal, String type) {
        super();
        this.name = name;
        this.author = author;
        this.level = level;
        this.description = description;
        this.prereqs = prereqs;
        this.fee = fee;
        this.endGoal = endGoal;
        this.type = type;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(String prereqs) {
        this.prereqs = prereqs;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getEndGoal() {
        return endGoal;
    }

    public void setEndGoal(String endGoal) {
        this.endGoal = endGoal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }
}
