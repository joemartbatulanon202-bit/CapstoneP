USE school_management_system;

SELECT 
    ss.student_id,
    s.first_name,
    s.last_name,
    sub.subject_code,
    sub.subject_name,
    ss.school_year
FROM student_subjects ss
JOIN students s ON ss.student_id = s.student_id
JOIN subjects sub ON ss.subject_id = sub.subject_id
WHERE ss.student_id = 1;