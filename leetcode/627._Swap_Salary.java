
# Write your MySQL query statement below
update salary SET sex =  IF(sex = 'm', 'f', 'm')

Above solution is 50% faster

=================================
# Write your MySQL query statement below
update salary SET sex =  CHAR(ASCII(sex) ^ 11)

Above solution is 5% faster

============================
# Write your MySQL query statement below
update salary 
SET sex = CASE sex WHEN 'f' THEN 'm' ELSE 'f' END;

Above solution is 100% faster
