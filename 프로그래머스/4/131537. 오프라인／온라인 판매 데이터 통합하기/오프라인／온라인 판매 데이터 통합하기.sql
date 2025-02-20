-- 2025.02.21
SELECT DATE_FORMAT(SALES_DATE,"%Y-%m-%d") SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE
WHERE SALES_DATE LIKE "2022-03%"
UNION ALL
SELECT DATE_FORMAT(SALES_DATE,"%Y-%m-%d") SALES_DATE, PRODUCT_ID, NULL USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE LIKE "2022-03%"
ORDER BY 1 ASC, 2 ASC, 3 ASC;