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
