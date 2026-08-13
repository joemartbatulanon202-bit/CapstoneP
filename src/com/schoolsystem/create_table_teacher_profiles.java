USE school_management_system;

CREATE TABLE teacher_profiles (
    teacher_profile_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    teacher_id INT NOT NULL UNIQUE,

    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id)
);