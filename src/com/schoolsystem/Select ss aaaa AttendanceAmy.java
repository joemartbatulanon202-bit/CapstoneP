USE school_management_system;

SELECT
    a.attendance_id,
    s.first_name,
    s.last_name,
    a.attendance_date,
    a.status,
    a.qr_code
FROM attendance a
JOIN students s
    ON a.student_id = s.student_id
WHERE a.student_id = 1;