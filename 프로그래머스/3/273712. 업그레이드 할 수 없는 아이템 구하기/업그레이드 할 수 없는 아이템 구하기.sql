-- 2025.02.06
SELECT ii.ITEM_ID, ii.ITEM_NAME, ii.RARITY
FROM ITEM_INFO ii LEFT JOIN ITEM_TREE it ON ii.ITEM_ID = it.PARENT_ITEM_ID
WHERE it.PARENT_ITEM_ID IS NULL
ORDER BY ITEM_ID DESC;
    
    