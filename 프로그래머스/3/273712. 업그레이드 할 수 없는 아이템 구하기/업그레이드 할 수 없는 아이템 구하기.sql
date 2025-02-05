-- 2025.02.06
SELECT ITEM_ID, ITEM_NAME, RARITY
    FROM ITEM_INFO
    WHERE ITEM_ID IN (
        SELECT p.ITEM_ID
        FROM ITEM_TREE p LEFT JOIN ITEM_TREE c ON p.ITEM_ID = c.PARENT_ITEM_ID
        WHERE c.ITEM_ID IS NULL
    )
    ORDER BY ITEM_ID DESC;






