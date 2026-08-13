USE school_management_system;

CREATE TABLE student_profiles (
    student_profile_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    student_id INT NOT NULL UNIQUE,

    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);