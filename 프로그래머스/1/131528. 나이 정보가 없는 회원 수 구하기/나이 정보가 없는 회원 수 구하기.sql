-- 코드를 입력하세요
# SELECT COUNT(*)-COUNT(AGE) FROM USER_INFO;
# SELECT COUNT(*) FROM USER_INFO WHERE AGE IS NULL;
SELECT SUM(AGE IS NULL)  FROM USER_INFO;