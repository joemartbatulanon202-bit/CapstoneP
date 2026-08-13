USE school_management_system;

SELECT 
    g.grade_id,
    s.first_name,
    s.last_name,
    sub.subject_code,
    sub.subject_name,
    g.quarter,
    g.grade
FROM grades g
JOIN students s ON g.student_id = s.student_id
JOIN subjects sub ON g.subject_id = sub.subject_id
WHERE g.student_id = 1;