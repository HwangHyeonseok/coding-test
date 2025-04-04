# 비트 연산(&) + join
# 오답노트 : python과 C# 모두 가지고 있는 개발자의 정보가 2번 출력되지 않도록 해야 한다.
    
# SELECT * FROM SKILLCODES -- 개발자가 사용하는 프로그래밍 언어 정보
# SELECT * FROM DEVELOPERS -- 개발자들의 프로그래밍 스킬 정보

-- 400 이 256(Python) 이나 1024(C#) 스킬을 가지고 있는지 확인하려면, 
-- 400(110010000) & 256(100000000) == 256(100000000)
-- 400(110010000) & 1024(0011001000) != 1024

-- 파이썬 CODE 번호 가져오기
with python_code_info as
(
    SELECT *
    FROM SKILLCODES
    WHERE NAME = 'Python'
),
-- C# CODE 번호 가져오기
csharp_code_info as
(
    SELECT *
    FROM SKILLCODES
    WHERE NAME = 'C#'
)

SELECT distinct d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
FROM DEVELOPERS d left join SKILLCODES s ON d.SKILL_CODE & s.CODE = (SELECT CODE FROM python_code_info) or d.SKILL_CODE & s.CODE = (SELECT CODE FROM csharp_code_info)
WHERE s.NAME is not null
ORDER BY 1 asc
