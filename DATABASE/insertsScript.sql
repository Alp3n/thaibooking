INSERT INTO thaibooking.user (uId, uFirstName, uLastName, uPassport, uEmail, uPhone, uPassword, uType) VALUES (14, 'Bangkok', 'Hotel', 'BK123456', 'bangkok@hotel.th', '0123456789', '123456', 'Partner');
INSERT INTO thaibooking.user (uId, uFirstName, uLastName, uPassport, uEmail, uPhone, uPassword, uType) VALUES (15, 'Hua Hin', 'Hotel', 'HH999999', 'huahin@hotel.th', '0987654321', '123456', 'Partner');
INSERT INTO thaibooking.user (uId, uFirstName, uLastName, uPassport, uEmail, uPhone, uPassword, uType) VALUES (16, 'regular', 'user', 'RU12365432', 'regular@user.th', '09871234765', '123456', 'Regular');

INSERT INTO thaibooking.property_facility (pfId, pfName) VALUES (1, 'Free Parking');
INSERT INTO thaibooking.property_facility (pfId, pfName) VALUES (2, 'Pet Friendly');
INSERT INTO thaibooking.property_facility (pfId, pfName) VALUES (3, 'Swimming pool');
INSERT INTO thaibooking.property_facility (pfId, pfName) VALUES (4, 'Restaurant');
INSERT INTO thaibooking.property_facility (pfId, pfName) VALUES (5, 'Airport Shuttle');

INSERT INTO thaibooking.property_type (ptId, ptName) VALUES (1, 'Hotel');

INSERT INTO thaibooking.room_facility (rfId, rfName) VALUES (1, 'Air-Condition');
INSERT INTO thaibooking.room_facility (rfId, rfName) VALUES (2, 'TV');
INSERT INTO thaibooking.room_facility (rfId, rfName) VALUES (3, 'Safe');
INSERT INTO thaibooking.room_facility (rfId, rfName) VALUES (4, 'Refrigirator');
INSERT INTO thaibooking.room_facility (rfId, rfName) VALUES (5, 'Hairdryer');
INSERT INTO thaibooking.room_facility (rfId, rfName) VALUES (6, 'Towels');
INSERT INTO thaibooking.room_facility (rfId, rfName) VALUES (7, 'WiFi');
INSERT INTO thaibooking.room_facility (rfId, rfName) VALUES (8, 'Balcony');
INSERT INTO thaibooking.room_facility (rfId, rfName) VALUES (9, 'Electric Kettle');
INSERT INTO thaibooking.room_facility (rfId, rfName) VALUES (10, 'Private bathroomm');

INSERT INTO thaibooking.property (pId, pStars, pName, pDescription, pRoad, pDistrict, pCity, pZipCode, pEmail, pPhone, pCheckInTime, pCheckOutTime, propertyType, userId) VALUES (6, '4', 'Bangkok Hotel', 'Test hotel in Bangkok. Best prices!', 'Srinagaridnra Road 15', 'Suan Luang', 'Bangkok', '10250', 'bangkok@hotel.th', '0123456789', '12:00', '11:00', 1, 14);
INSERT INTO thaibooking.property (pId, pStars, pName, pDescription, pRoad, pDistrict, pCity, pZipCode, pEmail, pPhone, pCheckInTime, pCheckOutTime, propertyType, userId) VALUES (7, '3', 'Hua Hin Hotel', 'Test hotel in Hua Hin. Lowest prices!', '10 Petchakasem Road', 'Hua Hin', 'Hua Hin', '77110', 'huhin@hotel.th', '07253123422', '11:00', '13:00', 1, 15);

INSERT INTO thaibooking.property_has_property_facility (propertyId, propertyFacilityId) VALUES (6, 1);
INSERT INTO thaibooking.property_has_property_facility (propertyId, propertyFacilityId) VALUES (7, 1);
INSERT INTO thaibooking.property_has_property_facility (propertyId, propertyFacilityId) VALUES (6, 3);
INSERT INTO thaibooking.property_has_property_facility (propertyId, propertyFacilityId) VALUES (7, 3);
INSERT INTO thaibooking.property_has_property_facility (propertyId, propertyFacilityId) VALUES (6, 4);
INSERT INTO thaibooking.property_has_property_facility (propertyId, propertyFacilityId) VALUES (7, 5);

INSERT INTO thaibooking.room (rId, rName, rNumber, rPrice, rSize, propertyId) VALUES (15, 'Single room', 101, 600, 10, 6);
INSERT INTO thaibooking.room (rId, rName, rNumber, rPrice, rSize, propertyId) VALUES (16, 'Double room', 102, 900, 20, 6);
INSERT INTO thaibooking.room (rId, rName, rNumber, rPrice, rSize, propertyId) VALUES (17, 'Double Delux room', 103, 1300, 25, 6);
INSERT INTO thaibooking.room (rId, rName, rNumber, rPrice, rSize, propertyId) VALUES (18, 'Triple Standard room', 1, 1000, 20, 7);

INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (15, 1);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (15, 2);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (15, 7);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (15, 10);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (16, 1);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (16, 2);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (16, 6);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (16, 7);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (16, 9);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (16, 10);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (17, 1);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (17, 2);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (17, 3);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (17, 4);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (17, 5);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (17, 6);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (17, 7);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (17, 8);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (17, 9);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (17, 10);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (18, 1);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (18, 2);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (18, 6);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (18, 7);
INSERT INTO thaibooking.room_has_room_facility (roomId, roomFacilityId) VALUES (18, 10);

INSERT INTO thaibooking.bed (bId, bName, bCapacity, roomId) VALUES (40, 'Single Standard', 1, 15);
INSERT INTO thaibooking.bed (bId, bName, bCapacity, roomId) VALUES (41, 'Double King Size', 2, 16);
INSERT INTO thaibooking.bed (bId, bName, bCapacity, roomId) VALUES (42, 'Double King Size', 2, 17);
INSERT INTO thaibooking.bed (bId, bName, bCapacity, roomId) VALUES (43, 'Single Standard bed', 1, 18);
INSERT INTO thaibooking.bed (bId, bName, bCapacity, roomId) VALUES (44, 'Double Bunkbed', 2, 18);

INSERT INTO thaibooking.payment (pId, pType, pStatus, pTotal) VALUES (11, 'Cash at property', 'Pending', 1200);
INSERT INTO thaibooking.booking (bId, bCheckIn, bCheckOut, bStatus, userId, roomId, roomPropertyId, paymentId) VALUES (19, '2020-06-23', '2020-06-25', 'Upcoming', 16, 15, 6, 11);

INSERT INTO thaibooking.payment (pId, pType, pStatus, pTotal) VALUES (12, 'Credit/Debit Card', 'Paid', 2000);
INSERT INTO thaibooking.booking (bId, bCheckIn, bCheckOut, bStatus, userId, roomId, roomPropertyId, paymentId) VALUES (20, '2020-06-23', '2020-06-25', 'Upcoming', 16, 18, 7, 12);