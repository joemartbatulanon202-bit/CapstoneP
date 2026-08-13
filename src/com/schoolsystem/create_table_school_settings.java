USE school_management_system;

CREATE TABLE school_settings (
    setting_id INT AUTO_INCREMENT PRIMARY KEY,
    school_name VARCHAR(150) NOT NULL,
    school_address VARCHAR(255),
    school_year VARCHAR(20),
    principal_name VARCHAR(100)
);