####################################################
####              PROPERTY QUERIES              ####
####################################################
# Insert property
INSERT INTO property
(
    pStars,
    pName,
    pDescription,
    pRoad,
    pDistrict,
    pCity,
    pZipCode,
    pEmail,
    pPhone,
    pCheckInTime,
    pCheckOutTime,
    propertyType,
    userId
)
VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);

# Insert facility into property
INSERT INTO property_has_property_facility
(
    propertyId,
    propertyFacilityId
 )
VALUES (?,?);

# Select properties for booking table
SELECT
    pName AS "Hotel Name",
    pCity AS "City",
    pDistrict AS "District"
FROM
    property;

# Select property for booking details
SELECT *
FROM property
WHERE pId = ?;

# Select property facilities for booking list
SELECT
    pfName AS "Facility"
FROM
    property_has_property_facility
LEFT JOIN property_facility ON
    property_facility.pfId = property_has_property_facility.propertyFacilityId
WHERE propertyId = ?;

####################################################
####               ROOM QUERIES                 ####
####################################################
# Insert room into property
INSERT INTO room
(
    rName,
    rNumber,
    rPrice,
    rSize,
    propertyId
)
VALUES (?,?,?,?,?);

# Insert facility to the room
INSERT INTO room_has_room_facility
(
    roomId,
    roomFacilityId
)
VALUES (?,?);

# Select room for booking details
SELECT *
FROM room
WHERE rId = ?;

# Select available rooms
SELECT
    rName,
    rPrice,
    bCapacity
FROM
    room
        LEFT JOIN bed ON
            bed.roomId =
            (SELECT COUNT(bCapacity))
WHERE roomId NOT IN (
    SELECT roomId
    FROM booking
    WHERE (bCheckIn <= ? AND bCheckOut >= ?)
       OR (bCheckIn < ? AND bCheckOut >= ?)
       OR (? <= bCheckIn AND ? >= bCheckIn)
);

# Select rooms type, price, capacity for booking table
SELECT
    rName,
    rPrice,
    bCapacity
FROM
    room
        LEFT JOIN bed ON
            bed.roomId = room.rId
WHERE propertyId = ?;

# Select room facilities for booking list
SELECT
    rfName AS "Facility"
FROM
    room_has_room_facility
LEFT JOIN room_facility ON
    room_facility.rfId = room_has_room_facility.roomFacilityId
WHERE roomId = ?;

# Select room with max bed capacity
SELECT
    rName,
    rPrice,
    bCapacity
FROM
    room
LEFT JOIN bed ON
    bed.roomId =
    (SELECT COUNT(bCapacity) WHERE room.rId = ?)
WHERE propertyId = ?
LIMIT 1;

# Select all rooms with max bed capacity
SELECT
    rName,
    rPrice,
    bCapacity
FROM
    room
LEFT JOIN bed ON
    bed.roomId =
    (SELECT COUNT(bCapacity))
WHERE propertyId = ?;

####################################################
####                BED QUERIES                 ####
####################################################
# Add bed to the room
INSERT INTO bed
(
    bName,
    bCapacity,
    roomId
)
VALUES (?,?,?);

# Select bed and capacity for booking table
SELECT
    bName,
    bCapacity
FROM
    bed
WHERE roomId = ?;

# Select all beds and details for partner bed table
SELECT *
FROM
   bed
WHERE roomId = ?;

####################################################
####               USER QUERIES                 ####
####################################################
# Insert person
INSERT INTO user (uFirstName, uLastName, uPassport, uEmail, uPhone, uPassword, uUserType)
VALUES (?,?,?,?,?,?,?);

# Query person for login and password authentication
SELECT *
FROM user
WHERE uEmail = ? AND uPassword = ?;

# logic for login
# if (email.equals(uEmail) && password.equals(uPassword)) {
#   Get USER_ID and USER_TYPE
#   Go to partner or customer panel
# } else {
#   popup wrong password try again
# }

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

