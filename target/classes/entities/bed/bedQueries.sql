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
