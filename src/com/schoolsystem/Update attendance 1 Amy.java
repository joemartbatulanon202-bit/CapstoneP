USE school_management_system;

UPDATE attendance
SET qr_code = 'STUDENT-1'
WHERE student_id = 1
  AND attendance_date = '2026-08-13';