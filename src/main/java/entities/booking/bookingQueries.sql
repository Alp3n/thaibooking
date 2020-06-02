####################################################
####               BOOKING QUERIES              ####
####################################################
# Insert booking
INSERT INTO booking
(
    bGuests,
    bCheckIn,
    bCheckOut,
    bStatus,
    paymentId,
    userId,
    roomId,
    roomPropertyId
)
VALUES (?,?,?,?,?,?,?,?);

# Select all pending/archived/cancelled customer bookings
SELECT *
FROM booking
WHERE userId = ? AND bStatus = ?;

# Select all pending/checked in/out/archived/cancelled partner bookings
SELECT *
FROM booking
WHERE roomPropertyId = ?;

# Select booking for specified row in pending booking table partner
SELECT *
FROM booking
WHERE bId = ? AND roomPropertyId = ?;

# Select details for booking from table row
SELECT
    bId,
    bGuests,
    bCheckIn,
    bCheckOut,
    uFirstName,
    uLastName,
    uPassport,
    rNumber,
    bStatus,
    pType,
    pStatus,
    rPrice
FROM
    booking
        LEFT JOIN guest g on booking.bId = g.booking
        LEFT JOIN payment p on booking.paymentId = p.pId
        LEFT JOIN user u on booking.userId = u.uId
        LEFT JOIN room r on booking.roomId = r.rId and booking.roomPropertyId = r.propertyId
WHERE bId = ?;

# Update booking status
UPDATE booking
SET bStatus = ?
WHERE bId = ?;