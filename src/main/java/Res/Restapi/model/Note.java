package Res.Restapi.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Note {
    @Id
    private Long id;
    private String title;
    private String content;

    // Cột thời gian khi thiết bị được tạo theo múi giờ người dùng
    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    // Cột thời gian khi thiết bị được cập nhật theo múi giờ người dùng
    @Column(nullable = false)
    private ZonedDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "email") // Khóa ngoại tham chiếu đến email của User
    private User user; // Tham chiếu đối tượng User

    // contructor

    Note(String titile, String content) {
        this.content = content;
        this.title = titile;
        prePersist();
    }

    // Getter và Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PrePersist
    public void prePersist() {
        // Giả sử múi giờ người dùng là múi giờ mặc định của hệ thống, hoặc bạn có thể
        // lấy từ API của người dùng.
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")); // Thay đổi múi giờ cho người dùng
        this.createdAt = now;
        this.updatedAt = now;
    }

    // Hàm được gọi trước khi thiết bị được cập nhật (update)
    @PreUpdate
    public void preUpdate() {
        // Cập nhật thời gian khi thiết bị thay đổi, theo múi giờ người dùng.
        this.updatedAt = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")); // Thay đổi múi giờ cho người dùng
    }
}
