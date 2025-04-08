package Res.Restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.Instant; // Sử dụng Instant để lưu thời gian UTC
import java.util.List;

@Entity
public class User {

    @Id
    private String email;
    private String name;
    private String password;
    private String role;

    // Mối quan hệ One-to-Many
    @OneToMany(mappedBy = "user") // "user" là tên thuộc tính trong lớp Note
    private List<Note> notes;

    // Cột thời gian khi tạo (UTC)
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    // Cột thời gian khi cập nhật (UTC)
    @Column(nullable = false)
    private Instant updatedAt;

    public User() {
        this.role = "ROLE_USER";
    }

    public User(String email, String password, String name) {
        this.role = "ROLE_USER";
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    // Hàm được gọi trước khi đối tượng được lưu vào cơ sở dữ liệu (insert)
    @PrePersist
    public void prePersist() {
        Instant now = Instant.now(); // Lấy thời gian hiện tại theo UTC
        this.createdAt = now;
        this.updatedAt = now;
    }

    // Hàm được gọi trước khi đối tượng được cập nhật (update)
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now(); // Lấy thời gian hiện tại theo UTC
    }
}
