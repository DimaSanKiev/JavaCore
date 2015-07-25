UPDATE payment
SET chargePayed = sumPayed * 0.034
WHERE id = 1;

UPDATE payment
SET chargePayed =
(SELECT p.sumPayed * m.charge / 100.0
 FROM payment p, merchant m
 WHERE m.id = p.merchantId AND p.id = 2)
WHERE id = 2;

UPDATE payment p
SET chargePayed =
sumPayed * (SELECT charge
            FROM merchant m
            WHERE m.id = p.merchantId) / 100.0;

UPDATE merchant m
SET needToSend =
(SELECT sum(sumPayed - charge)
 FROM payment p
 WHERE p.merchantId = m.id);