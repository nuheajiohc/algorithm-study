-- 2025.02.19
SELECT e.EMP_NO,
       e.EMP_NAME, 
       CASE
        WHEN s.SCORE>=96 THEN "S"
        WHEN s.SCORE>=90 THEN "A"
        WHEN s.SCORE>=80 THEN "B"
        ELSE "C"
       END AS GRADE,
       CASE
        WHEN s.SCORE>=96 THEN e.SAL*0.2
        WHEN s.SCORE>=90 THEN e.SAL*0.15
        WHEN s.SCORE>=80 THEN e.SAL*0.1
        ELSE 0
       END AS BONUS
FROM HR_EMPLOYEES e
JOIN (
    SELECT EMP_NO, AVG(SCORE) SCORE FROM HR_GRADE GROUP BY EMP_NO
) AS s ON e.EMP_NO = s.EMP_NO
ORDER BY e.EMP_NO ASC;