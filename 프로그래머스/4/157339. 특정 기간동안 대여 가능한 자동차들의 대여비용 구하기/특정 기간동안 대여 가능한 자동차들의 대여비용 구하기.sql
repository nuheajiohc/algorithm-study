-- 코드를 입력하세요
# SELECT ccc.CAR_ID, ccc.CAR_TYPE, FLOOR(ccc.DAILY_FEE*30* ((100-crcrp.DISCOUNT_RATE)/100)) as FEE
#     FROM CAR_RENTAL_COMPANY_CAR as ccc 
#         JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS crcrp ON ccc.CAR_TYPE = crcrp.CAR_TYPE
#             and ccc.CAR_ID NOT IN (SELECT DISTINCT crcrh.CAR_ID  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS crcrh
#                                     WHERE crcrh.START_DATE <= "2022-11-30" AND crcrh.END_DATE >= "2022-11-01"
#                                   )
#             and ccc.CAR_TYPE IN ("SUV","세단")
#             and crcrp.DURATION_TYPE="30일 이상"
#             and ccc.DAILY_FEE*30* ((100-crcrp.DISCOUNT_RATE)/100) >= 500000 
#             and ccc.DAILY_FEE*30* ((100-crcrp.DISCOUNT_RATE)/100) < 2000000
#                 ORDER BY FEE DESC, ccc.CAR_TYPE ASC, ccc.CAR_ID desc;

SELECT ccc.CAR_ID, ccc.CAR_TYPE, FLOOR(ccc.DAILY_FEE*30* ((100-crcrp.DISCOUNT_RATE)/100)) as FEE
    FROM CAR_RENTAL_COMPANY_CAR as ccc 
        JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS crcrp ON ccc.CAR_TYPE = crcrp.CAR_TYPE
            and ccc.CAR_ID NOT IN (SELECT DISTINCT crcrh.CAR_ID  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS crcrh
                                    WHERE crcrh.START_DATE <= "2022-11-30" AND crcrh.END_DATE >= "2022-11-01"
                                  )
            and ccc.CAR_TYPE IN ("SUV","세단")
            and crcrp.DURATION_TYPE="30일 이상"
            GROUP BY ccc.CAR_ID
            HAVING FEE >= 500000 
                and FEE < 2000000
                    ORDER BY FEE DESC, ccc.CAR_TYPE ASC, ccc.CAR_ID desc;