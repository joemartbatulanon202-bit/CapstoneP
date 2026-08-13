USE school_management_system;

CREATE TABLE attendance (
    attendance_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    attendance_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    qr_code VARCHAR(255),
    
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);