-- next two sqls are equivalent
SELECT
  p.dt,
  m.name AS merchant,
  c.name AS customer,
  p.goods,
  p.sumPayed
FROM payment p
  LEFT OUTER JOIN merchant m ON m.id = p.merchantId
  LEFT OUTER JOIN customer c ON c.id = p.customerId;

SELECT
  p.dt,
  m.name AS merchant,
  c.name AS customer,
  p.goods,
  p.sumPayed
FROM payment p, merchant m, customer c
WHERE m.id = p.merchantId AND c.id = p.customerId;
