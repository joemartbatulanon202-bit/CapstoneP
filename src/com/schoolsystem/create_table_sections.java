USE school_management_system;

CREATE TABLE sections (
    section_id INT AUTO_INCREMENT PRIMARY KEY,
    section_name VARCHAR(100) NOT NULL UNIQUE,
    strand VARCHAR(50),
    grade_level VARCHAR(20),
    school_year VARCHAR(20)
);