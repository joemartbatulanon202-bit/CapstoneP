USE school_management_system;

SELECT 
    e.enrollment_id,
    s.first_name,
    s.last_name,
    sec.section_name,
    e.school_year
FROM enrollments e
JOIN students s ON e.student_id = s.student_id
JOIN sections sec ON e.section_id = sec.section_id;