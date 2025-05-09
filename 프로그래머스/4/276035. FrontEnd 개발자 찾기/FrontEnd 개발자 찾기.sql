-- 2025.02.26
SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS d
LEFT JOIN SKILLCODES s ON d.SKILL_CODE | s.CODE = d.SKILL_CODE
WHERE CATEGORY = "Front End"
ORDER BY ID ASC;
