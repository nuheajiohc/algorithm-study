-- 2025.01.10
SELECT ao.ANIMAL_ID, ao.NAME 
    FROM ANIMAL_OUTS ao LEFT JOIN ANIMAL_INS ai ON ao.ANIMAL_ID=ai.ANIMAL_ID
    WHERE ai.ANIMAL_ID IS NULL
    ORDER BY 1