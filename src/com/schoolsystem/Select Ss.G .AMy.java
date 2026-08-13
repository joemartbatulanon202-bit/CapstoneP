USE school_management_system;

SELECT 
    s.first_name,
    s.last_name,
    ROUND(AVG(g.grade), 2) AS average_grade
FROM grades g
JOIN students s ON g.student_id = s.student_id
WHERE g.student_id = 1
  AND g.quarter = '1'
GROUP BY s.student_id, s.first_name, s.last_name;