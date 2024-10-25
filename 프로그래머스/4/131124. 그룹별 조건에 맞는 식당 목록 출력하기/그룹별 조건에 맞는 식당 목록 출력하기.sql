# -- 코드를 입력하세요
SELECT mr.MEMBER_NAME, rr.REVIEW_TEXT, DATE_FORMAT(rr.REVIEW_DATE,"%Y-%m-%d") FROM MEMBER_PROFILE mr
    JOIN REST_REVIEW rr ON mr.MEMBER_ID = rr.MEMBER_ID
    WHERE mr.MEMBER_ID IN (
        SELECT MEMBER_ID FROM REST_REVIEW GROUP BY MEMBER_ID HAVING COUNT(MEMBER_ID) = (
        SELECT COUNT(MEMBER_ID) AS REVIEW_COUNT FROM REST_REVIEW GROUP BY MEMBER_ID ORDER BY REVIEW_COUNT DESC LIMIT 1)
    )
    ORDER BY rr.REVIEW_DATE ASC, rr.REVIEW_TEXT ASC;