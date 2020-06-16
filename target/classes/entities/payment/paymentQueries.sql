####################################################
####               PAYMENT QUERIES              ####
####################################################
# Insert payment
INSERT INTO payment
(
    pId,
    pType,
    pStatus,
    pTotal
)
VALUES (?,?,?,?);

# Update payment status
UPDATE payment
SET pStatus = ?
WHERE pId = ?;

