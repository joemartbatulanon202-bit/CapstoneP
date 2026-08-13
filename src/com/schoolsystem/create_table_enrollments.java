USE school_management_system;

CREATE TABLE enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    section_id INT NOT NULL,
    school_year VARCHAR(20) NOT NULL,
    
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (section_id) REFERENCES sections(section_id)
);