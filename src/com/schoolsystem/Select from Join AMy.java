USE school_management_system;

SELECT
    s.student_id,
    s.first_name,
    s.last_name,
    sec.section_name,
    sub.subject_code,
    sub.subject_name,
    g.quarter,
    g.grade
FROM students s
JOIN enrollments e
    ON s.student_id = e.student_id
JOIN sections sec
    ON e.section_id = sec.section_id
JOIN student_subjects ss
    ON s.student_id = ss.student_id
JOIN subjects sub
    ON ss.subject_id = sub.subject_id
LEFT JOIN grades g
    ON s.student_id = g.student_id
    AND sub.subject_id = g.subject_id
WHERE s.student_id = 1;