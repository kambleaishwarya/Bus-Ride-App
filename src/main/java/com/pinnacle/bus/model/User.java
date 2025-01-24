package com.pinnacle.bus.model;

import java.time.LocalDateTime;

public class User {

    private String id;
    private String name;
    private String email;
    private LocalDateTime emailVerified;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String role;

    public User() {
    }

    public User(String id, String name, String email, LocalDateTime emailVerified, String image, 
                LocalDateTime createdAt, LocalDateTime updatedAt, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.emailVerified = emailVerified;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getEmailVerified() {
        return emailVerified;
    }

    public String getImage() {
        return image;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmailVerified(LocalDateTime emailVerified) {
        this.emailVerified = emailVerified;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", emailVerified=" + emailVerified +
                ", image='" + image + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", role='" + role + '\'' +
                '}';
    }
}