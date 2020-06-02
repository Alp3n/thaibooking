###################################################
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