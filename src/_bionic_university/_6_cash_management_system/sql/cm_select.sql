SELECT
  dt,
  merchantId,
  customerId,
  goods,
  sumpayed
FROM payment
WHERE merchantId = 3;

SELECT
  id,
  name,
  charge,
  period,
  minsum
FROM merchant
WHERE name LIKE '%Ltd%';

SELECT
  dt,
  merchantId,
  customerId,
  goods,
  sumpayed
FROM payment
ORDER BY merchantId;

SELECT sum(sumPayed)
FROM payment
WHERE
  customerId = 2;

SELECT
  merchantId,
  count(*)      AS n,
  sum(sumPayed) AS total
FROM payment
GROUP BY merchantId;

SELECT
  customerId,
  sum(sumPayed)
FROM payment
GROUP BY customerId
HAVING count(*) > 2;
