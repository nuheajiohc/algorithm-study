-- 2024-12-10
SELECT CONCAT(CEILING(MONTH(DIFFERENTIATION_DATE)/3),'Q') QUARTER, COUNT(*) ECOLI_COUNT 
    FROM ECOLI_DATA
    GROUP BY QUARTER
    ORDER BY QUARTER ASC;