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
    r.rName,
    r.rPrice,
    b.capacity
FROM
    room r,
    (SELECT roomId, SUM(bCapacity) as capacity FROM bed group by roomId) as b
WHERE r.rId = b.roomId AND r.rId = (
    SELECT roomId
    FROM booking
    WHERE (bCheckIn <= ? AND bCheckOut >= ?)
       OR (bCheckIn < ? AND bCheckOut >= ?)
       OR (? <= bCheckIn AND ? >= bCheckIn)
);

SELECT
    r.rId,
    r.rName,
    r.rPrice,
    b.capacity
FROM
    room r,
    (SELECT roomId, SUM(bCapacity) as capacity FROM bed group by roomId) as b
WHERE NOT EXISTS
    (
    SELECT 1
    FROM booking bo
    WHERE bo.roomId = r.rId AND
          bo.bCheckIn < ? AND
          bo.bCheckOut >= ?
#         OR (bo.bCheckOut >= ? AND bo.bCheckIn < ?)
    );

SELECT r.rid            AS 'ID',
       r.rname          AS 'Room Type',
       r.rprice         AS 'Price (THB)',
       Sum(b.bcapacity) AS 'MaxG'
FROM   room r
           LEFT JOIN bed b
                     ON r.rid = b.roomid
WHERE r.propertyId =? AND  NOT EXISTS (SELECT 1
                       FROM   booking bo
                       WHERE  bo.roomid = r.rid
                         AND bo.bcheckin < ?
                         AND bo.bcheckout >= ?)
GROUP  BY roomid;

#First ? is check-in second ? check-out
SELECT
    roomId,
    bCheckIn,
    bCheckOut
FROM booking
WHERE (bCheckOut > ? AND bCheckIn <= ?) AND bStatus = 'Upcoming' OR 'Archived';


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
    r.rId,
    r.rName,
    r.rPrice,
    b.capacity
FROM
    room r,
(SELECT roomId, SUM(bCapacity) as capacity FROM bed group by roomId) as b
WHERE r.rId = b.roomId;

# select a.roomid, a.rname,....,b.capacity from roomtable as a,
#     (select roomid, sum(bed_capacity) as capacity from bed group by roomid) as b
# where a.roomid = b.roomid;


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
