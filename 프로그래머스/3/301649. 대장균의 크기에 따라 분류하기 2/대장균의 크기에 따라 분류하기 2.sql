-- 2025.02.08
With RankedEcoil AS (
    SELECT ID, SIZE_OF_COLONY,
        PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS percent
    FROM ECOLI_DATA
)
SELECT ID, CASE
                WHEN percent <=0.25 THEN "CRITICAL"
                WHEN percent <=0.5 THEN "HIGH"
                WHEN percent <=0.75 THEN "MEDIUM"
                ELSE "LOW"
           END AS COLONY_NAME
FROM RankedEcoil
ORDER BY ID ASC;