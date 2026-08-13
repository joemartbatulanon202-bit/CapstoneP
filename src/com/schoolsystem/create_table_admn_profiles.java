USE school_management_system;

CREATE TABLE admin_profiles (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(user_id)
);