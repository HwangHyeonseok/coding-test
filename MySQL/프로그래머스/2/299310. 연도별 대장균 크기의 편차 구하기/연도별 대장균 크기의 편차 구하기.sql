# 방법 1 : 단순 서브쿼리 이용

# -- select : 연도, 크기 편차(가장 큰 대장균의 크기 - 각 대장균의 크기), 대장균 개체 ID

# -- 연도별 가장 큰 대장균의 크기 구하기 
# with large_size_colony as
# (
#     SELECT YEAR(DIFFERENTIATION_DATE) as 'year', max(SIZE_OF_COLONY) as 'max_size' 
#     FROM ecoli_data
#     GROUP BY YEAR(DIFFERENTIATION_DATE)
# ),
# -- ecoli_data 테이블에서 원하는 것만 수정
# abstract_ecoli_data as
# (
#     SELECT ID, YEAR(DIFFERENTIATION_DATE) as 'year',SIZE_OF_COLONY
#     FROM ecoli_data
# )

# SELECT e.YEAR, max_size - size_of_colony as YEAR_DEV,ID
# FROM abstract_ecoli_data e LEFT JOIN large_size_colony l ON e.year=l.year
# ORDER BY 1 asc, 2 asc

# 방법 2 : 윈도우 함수 이용 (집계도 필요하고, 테이블의 값도 이용해야 하고 그룹화도 필요하므로.)
# -> 방법 1은 스캔을 2번 해야 하는데, 여기에서는 한 번에 해서 성능이 더 좋을 것 같음

SELECT
    YEAR(differentiation_date) as 'YEAR',
    MAX(SIZE_OF_COLONY) OVER (PARTITION BY year(differentiation_date)) - size_of_colony as 'YEAR_DEV',
    ID
FROM ECOLI_DATA
ORDER BY 1 asc, 2 asc