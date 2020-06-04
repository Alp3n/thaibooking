package gui;

import entities.bed.BedDaoImpl;
import entities.booking.BookingDaoImpl;
import entities.payment.PaymentDaoImpl;
import entities.property.PropertyDaoImpl;
import entities.property.PropertyFacility;
import entities.property.PropertyType;
import entities.room.RoomDaoImpl;
import entities.room.RoomFacility;
import entities.user.UserDaoImpl;
import main.LoginAuthentication;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class MainFrame extends JFrame {

    private Integer userId = null;
    private Integer propertyId = null;

    private JPanel mainPanel;
    private JButton searchButton;
    private JTextField searchTextField;
    private JSpinner guestNumberSpinner;
    private JXDatePicker checkInDatePicker;
    private JXDatePicker checkOutDatePicker;
    private JTable propertyTable;
    private JTable roomTable;
    private JTable bedTable;
    private JList propertyFacilitiesList;
    private JList roomFacilitiesList;
    private JPanel firstPanel;
    private JPanel propertyPanel;
    private JScrollPane propertyScrollPane;
    private JScrollPane roomScrollPane;
    private JScrollPane bedScrollPane;
    private JLabel propertyTableLabel;
    private JLabel roomTableLabel;
    private JLabel bebTableLabel;
    private JButton bookRoomButton;
    private JLabel roomFacilities;
    private JLabel propertyFacilities;
    private JPanel searchPanel;
    private JLabel searchLabel;
    private JLabel checkInLabel;
    private JLabel checkOutLabel;
    private JLabel guestNumberLabel;
    private JPanel navBarPanel;
    private JButton registerButton;
    private JButton loginButton;
    private JPanel regularPanel;
    private JButton cHomeButton;
    private JButton cLogoutButton;
    private JButton lHomeButton;
    private JPanel loginPanel;
    private JButton lRegisterButton;
    private JPanel loginFormPanel;
    private JPanel lNavBarPanel;
    private JLabel lLoginLabel;
    private JTextField lEmailTextField;
    private JPasswordField lPasswordField;
    private JButton lLoginButton;
    private JButton rHomeButton;
    private JButton rLoginButton;
    private JPanel registerPanel;
    private JPanel rNavBarPanel;
    private JTextField rFNameTextField;
    private JTextField rLNameTextField;
    private JTextField rPassportTextField;
    private JTextField rPhoneTextField;
    private JLabel rRegisterAccountLabel;
    private JLabel rFNameLabel;
    private JLabel rLNameLabel;
    private JLabel rPassportLabel;
    private JLabel rPhoneLabel;
    private JTextField rEmailTextField;
    private JPasswordField rPasswordField;
    private JLabel rPasswordLabel;
    private JLabel rEmailLabel;
    private JPanel rRegisterForm;
    private JLabel rPartnerLabel;
    private JLabel rPartnerLabel2;
    private JRadioButton rPartnerRadioButton;
    private JButton rRegisterButton;
    private JButton button1;
    private JButton pLogoutButton;
    private JPanel partnerPropertyPanel;
    private JPanel pNavBarPanel;
    private JButton pMyPropertyButton;
    private JButton pMyRoomsButton;
    private JButton pMyBookingsButton;
    private JPanel pPropertyForm1;
    private JComboBox pTypeComboBox;
    private JComboBox pStarsComboBox;
    private JTextField pNameTextField;
    private JTextArea pDescriptionTextArea;
    private JTextField pRoadTextField;
    private JTextField pDistrictTextField;
    private JTextField pCityTextField;
    private JTextField pZipCodeTextField;
    private JTextField pEmailTextField;
    private JTextField pPhoneTextField;
    private JButton pSaveButton;
    private JPanel pPropertyForm2;
    private JComboBox pCheckInComboBox;
    private JComboBox pCheckOutComboBox;
    private JComboBox pFacilityComboBox;
    private JButton pAddButton;
    private JList pFacilitiesList;
    private JPanel cArchivedBookingsPanel;
    private JScrollPane cArchivedBookingsScrollPane;
    private JTable cArchivedBookingsTable;
    private JLabel cArchivedBookingsLabel;
    private JPanel cUpcomingBookingsPanel;
    private JScrollPane cUpcomingBookingsScrollPane;
    private JTable cUpcomingBookingsTable;
    private JLabel cUpcomingBookingsLabel;
    private JPanel cNavBarPanel;
    private JButton cMyBookingsButton;
    private JPanel cBookingDetailsPanel;
    private JLabel cBookingDetailsLabel;
    private JLabel cShowPropertyName;
    private JLabel cShowAddress;
    private JLabel cShowDate;
    private JLabel cEmailLabel;
    private JLabel cPhoneLabel;
    private JLabel cShowPhone;
    private JLabel cShowEmail;
    private JLabel cShowRoomType;
    private JLabel cShowMaxGuests;
    private JLabel cShowRoomSize;
    private JLabel cShowPaymentType;
    private JLabel cShowPaymentStatus;
    private JList cRoomFacilitiesList;
    private JList cPropertyFacilitiesList;
    private JList cBedsList;
    private JPanel partnerRoomPanel;
    private JPanel prNavBar;
    private JTextField prNameTextField;
    private JTextField prNumberTextField;
    private JTextField prPriceTextField;
    private JTextField prSizeTextField;
    private JComboBox prFacilityComboBox;
    private JButton prAddFacilityButton;
    private JButton prCreateRoomButton;
    private JPanel prRoomFormPanel;
    private JTable prRoomTable;
    private JList prRoomFacilitiesList;
    private JScrollPane prRoomScroll;
    private JButton prDeleteRoomButton;
    private JComboBox prBedCapacityComboBox;
    private JTextField prBedNameTextField;
    private JButton prAddBedButton;
    private JButton prDeleteBedButton;
    private JTable prBedTable;
    private JScrollPane prBedScroll;
    private JPanel prBedFormPanel;
    private JPanel partnerBookingPanel;
    private JTable bUpcomingTable;
    private JTable bCheckedInTable;
    private JPanel pbNavBarPanel;
    private JButton bCheckInButton;
    private JLabel bpTotalLabel;
    private JLabel bpStatusLabel;
    private JLabel bpTypeLabel;
    private JLabel bbStatusLabel;
    private JLabel brNumberLabel;
    private JLabel bnNumber;
    private JLabel bsDateLabel;
    private JLabel bbIdLabel;
    private JScrollPane bUpcomingScroll;
    private JScrollPane bCheckedInScroll;
    private JTable bArchiveTable;
    private JScrollPane bArchiveScroll;
    private JButton bCheckOutButton;
    private JLabel bnGuestLabel;
    private JPanel pbBookingFormPanel;
    private JButton prMyPropertyButton;
    private JButton prMyRoomsButton;
    private JButton prMyBookingsButton;
    private JButton prLogoutButton;
    private JButton pbMyPropertyButton;
    private JButton pbMyRoomsButton;
    private JButton pbLogoutButton;
    private JPanel CheckInPanel;
    private JFrame frame;

    public MainFrame() {

//        frame = new JFrame();

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1200,800);


        CardPanelManager cpm = new CardPanelManager();

        RegularPanel rp = new RegularPanel(cpm);
        PartnerPanel pp = new PartnerPanel(cpm);

        PropertyDaoImpl propertyDao = new PropertyDaoImpl();
        RoomDaoImpl roomDao = new RoomDaoImpl();
        BedDaoImpl bedDao = new BedDaoImpl();
        BookingDaoImpl bookingDao = new BookingDaoImpl();
        PaymentDaoImpl paymentDao = new PaymentDaoImpl();
        UserDaoImpl userDao = new UserDaoImpl();

        propertyDao.listAllProperties(propertyTable);

        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                searchForPropertyOrLocation();
            }
        });

        propertyTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer propertyId = getIdFromTable(propertyTable);
                propertyDao.listAllPropertyFacilities(propertyFacilitiesList, propertyId);
                roomDao.listAllRoomsInProperty(roomTable, propertyId);
            }
        });

        roomTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer roomId = getIdFromTable(roomTable);
                roomDao.listAllRoomFacilities(roomFacilitiesList, roomId);
                bedDao.listAllBedsInRoom(bedTable, roomId);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "loginPanel");
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "registerPanel");
            }
        });
        lHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "firstPanel");
            }
        });
        lRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel,"registerPanel");
            }
        });

        lLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginToTheSystem(cpm, propertyDao);

                createPartnerProfile(propertyDao, roomDao, bedDao, bookingDao);
            }
        });

        rHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel,"firstPanel");
            }
        });
        rLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel,"loginPanel");
            }
        });

        button1.addActionListener(new ActionListener() {
                @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel,"partnerPropertyPanel");
            }
        });
        cHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel,"firstPanel");
            }
        });
        cLogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //logout
                cpm.changePanel(mainPanel,"firstPanel");
                userId = null;
                JOptionPane.showMessageDialog(null, "Logged out successfully!");
            }
        });
        pLogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "firstPanel");
                userId = null;
                propertyId = null;
                JOptionPane.showMessageDialog(null, "Logged out successfully!");
            }
        });
        pSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProperty(propertyDao);
            }
        });
        pAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFacilityToProperty(propertyDao);
                propertyDao.listAllPropertyFacilities(pFacilitiesList, propertyId);
            }
        });
        pMyRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "partnerRoomPanel");
            }
        });

        prRoomTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer roomId = getIdFromTable(prRoomTable);
                roomDao.listAllRoomFacilities(prRoomFacilitiesList, roomId);
                bedDao.tableAllBeds(prBedTable, roomId);
            }
        });
        prDeleteRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer roomId= getIdFromTable(prRoomTable);
                deleteRoomInProperty(roomDao, roomId);
                roomDao.tableAllRooms(prRoomTable, propertyId);
            }
        });
        prDeleteBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer bedId = getIdFromTable(prBedTable);
                deleteBedInRoom(bedDao, bedId);
                Integer roomId = getIdFromTable(prRoomTable);
                bedDao.tableAllBeds(prBedTable, roomId);
            }
        });
        prCreateRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertRoomInProperty(roomDao);
                roomDao.tableAllRooms(prRoomTable, propertyId);
                prNameTextField.setText("");
                prNumberTextField.setText("");
                prPriceTextField.setText("");
                prSizeTextField.setText("");
            }
        });
        prAddFacilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer roomId = getIdFromTable(prRoomTable);
                addFacilityToRoom(roomDao, roomId);
                roomDao.listAllRoomFacilities(prRoomFacilitiesList, roomId);
            }
        });
        prAddBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer roomId = getIdFromTable(prRoomTable);
                insertBedInRoom(bedDao, roomId);
                bedDao.tableAllBeds(prBedTable, roomId);
                prBedNameTextField.setText("");
            }
        });
        bUpcomingTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer bookingId = getIdFromTable(bUpcomingTable);
                setBookingDetails(bookingDao, roomDao, bookingId);
            }
        });
        bCheckedInTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO get index show details where checked In
            }
        });
        bArchiveTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO get index show details where archived
            }
        });
        bCheckInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO update booking status, payment status
            }
        });
        bCheckOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO update booking status
            }
        });
        prMyPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "partnerPropertyPanel");
            }
        });
        prMyBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "partnerBookingPanel");
            }
        });
        pMyBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "partnerBookingPanel");
            }
        });
        pbLogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "firstPanel");
                userId = null;
                propertyId = null;
                JOptionPane.showMessageDialog(null, "Logged out successfully!");
            }
        });
        pbMyPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "partnerPropertyPanel");
            }
        });
        pbMyRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "partnerRoomPanel");
            }
        });
        prLogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainPanel, "firstPanel");
                userId = null;
                propertyId = null;
                JOptionPane.showMessageDialog(null, "Logged out successfully!");
            }
        });
        rRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createUser(userDao);
            }
        });
    }

    private void createUIComponents() {
    }


    //////////////////////////////////////
    // Methods for logic in main frame //
    ////////////////////////////////////
    private Integer getIdFromTable(JTable table) {
        int index = table.getSelectedRow();
        TableModel model = table.getModel();
        return (Integer) model.getValueAt(index, 0);
    }

    private void searchForPropertyOrLocation() {
        String locationProperty = searchTextField.getText();
        Integer guestNumber = (Integer) guestNumberSpinner.getValue();

        //Check In Date to LocalDate of Booking class attribute
        Date checkInDate = checkInDatePicker.getDate();
        LocalDate convertedCheckInDate = convertToLocalDate(checkInDate);

        //Check Out Date to LocalDate of Booking class attribute
        Date checkOutDate = checkOutDatePicker.getDate();
        LocalDate convertedCheckOutDate = convertToLocalDate(checkOutDate);

        long stayDuration = DAYS.between(convertedCheckInDate, convertedCheckOutDate);

        System.out.println("Location or Property: " + locationProperty);
        System.out.println("Check in: " + convertedCheckInDate);
        System.out.println("Check out: " + convertedCheckOutDate);
        System.out.println("Guest number: " + guestNumber);
        System.out.println("Stay duration:" + stayDuration);
    }

    private LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private void loginToTheSystem(CardPanelManager cpm, PropertyDaoImpl propertyDao) {
        LoginAuthentication la = new LoginAuthentication();
        String email = lEmailTextField.getText();
        String pass = String.valueOf(lPasswordField.getPassword());

        try {
            if (la.loginAuth(email, pass).getType().equalsIgnoreCase("Partner")) {
                cpm.changePanel(mainPanel,"partnerPropertyPanel");
                JOptionPane.showMessageDialog(null, "Welcome " + la.loginAuth(email, pass).getfName());
                userId = la.loginAuth(email, pass).getId();
                propertyId = propertyDao.getPartnerProperty(userId).getId();

                System.out.println(userId);
            } else if (la.loginAuth(email, pass).getType().equalsIgnoreCase("Regular")){
                cpm.changePanel(mainPanel,"regularPanel");
                JOptionPane.showMessageDialog(null, "Welcome " + la.loginAuth(email, pass).getfName());
                userId = la.loginAuth(email, pass).getId();
                System.out.println(userId);
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null,"No user account, try again.");
        }
    }

    private void createPartnerProfile(PropertyDaoImpl propertyDao, RoomDaoImpl roomDao, BedDaoImpl bedDao, BookingDaoImpl bookingDao) {

        try {
            // MY PROPERTY TAB //
            propertyDao.getPropertyTypes(pTypeComboBox);

            pTypeComboBox.setSelectedItem(propertyDao.getPartnerProperty(userId).getPropertyType());
            pStarsComboBox.setSelectedItem(propertyDao.getPartnerProperty(userId).getStars());
            pNameTextField.setText(propertyDao.getPartnerProperty(userId).getName());
            pDescriptionTextArea.setText(propertyDao.getPartnerProperty(userId).getDescription());
            pRoadTextField.setText(propertyDao.getPartnerProperty(userId).getRoad());
            pDistrictTextField.setText(propertyDao.getPartnerProperty(userId).getDistrict());
            pCityTextField.setText(propertyDao.getPartnerProperty(userId).getCity());
            pZipCodeTextField.setText(propertyDao.getPartnerProperty(userId).getZipCode());
            pEmailTextField.setText(propertyDao.getPartnerProperty(userId).getEmail());
            pPhoneTextField.setText(propertyDao.getPartnerProperty(userId).getPhone());
            pCheckInComboBox.setSelectedItem(propertyDao.getPartnerProperty(userId).getCheckInTime());
            pCheckOutComboBox.setSelectedItem(propertyDao.getPartnerProperty(userId).getCheckOutTime());

            propertyDao.listAllPropertyFacilities(pFacilitiesList, propertyId);
            propertyDao.getPropertyFacility(pFacilityComboBox);

            // MY ROOMS TAB //
            roomDao.getRoomFacility(prFacilityComboBox);
            roomDao.tableAllRooms(prRoomTable, propertyId);

            // MY BOOKINGS TAB //
            bookingDao.tableAllPartnerBookings(bUpcomingTable, propertyId, "Upcoming");
            bookingDao.tableAllPartnerBookings(bCheckedInTable, propertyId, "Checked In");
            bookingDao.tableAllPartnerBookings(bArchiveTable, propertyId, "Archived");


        } catch (Exception e) {
            System.out.println("Something is wrong");
            e.printStackTrace();
        }
    }

    private void setBookingDetails(BookingDaoImpl bookingDao, RoomDaoImpl roomDao, UserDaoImpl userDao, Integer bId) {
        bbIdLabel.setText(bookingDao.getBooking(bId).g);
        bnGuestLabel.setText(userDao.getUser(uId));
        LocalDate checkIn = bookingDao.getBooking(bId).getCheckIn();
        LocalDate checkOut = bookingDao.getBooking(bId).getCheckOut();
        String stayDate = "From " + checkIn + " till " + checkOut;
        bsDateLabel.setText(stayDate);
        long stayDuration = DAYS.between(checkIn, checkOut);
        bnNumber.setText(String.valueOf(stayDuration));
        Integer roomId = bookingDao.getBooking(bId).getRoomId();
        String roomNumber = String.valueOf(roomDao.getRoom(roomId).getRoomNumber());
        brNumberLabel.setText(roomNumber);
        System.out.println("test22");
        bbStatusLabel.setText(bookingDao.getBooking(bId).getStatus());
    }

    private void updateProperty(PropertyDaoImpl propertyDao) {
        PropertyType pType = (PropertyType) pTypeComboBox.getSelectedItem();
        Integer propertyType = pType.getId();
        String pStars = pStarsComboBox.getSelectedItem().toString();
        String pName = pNameTextField.getText();
        String pDescription = pDescriptionTextArea.getText();
        String pRoad = pRoadTextField.getText();
        String pDistrict = pDistrictTextField.getText();
        String pCity = pCityTextField.getText();
        String pZipCode = pZipCodeTextField.getText();
        String pEmail = pEmailTextField.getText();
        String pPhone = pPhoneTextField.getText();
        String pCheckIn = pCheckInComboBox.getSelectedItem().toString();
        String pCheckOut = pCheckOutComboBox.getSelectedItem().toString();

        try {
            if (propertyId == null) {
                propertyDao.insertProperty(pStars, pName, pDescription, pRoad, pDistrict, pCity, pZipCode, pEmail, pPhone, pCheckIn, pCheckOut, userId, propertyType);
                JOptionPane.showMessageDialog(null, "Inserted successfully!");
            } else {
                propertyDao.updateProperty(pStars, pName, pDescription, pRoad, pDistrict, pCity, pZipCode, pEmail, pPhone, pCheckIn, pCheckOut, userId, propertyType, propertyId);
                JOptionPane.showMessageDialog(null, "Updated successfully!");
            }

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "There was a problem with inserting");
        }
    }

    private void deleteRoomInProperty(RoomDaoImpl roomDao, Integer roomId) {
        try {
            roomDao.deleteRoom(roomId, propertyId);
            JOptionPane.showMessageDialog(null, "Deleted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was a problem with deleting");
        }
    }

    private void deleteBedInRoom(BedDaoImpl bedDao, Integer bedId) {
        try {
            bedDao.deleteBed(bedId);
            JOptionPane.showMessageDialog(null, "Deleted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was a problem with deleting");
        }
    }

    private void insertBedInRoom(BedDaoImpl bedDao, Integer roomId) {
        String bName = prBedNameTextField.getText();
        Integer bCapacity = Integer.parseInt(prBedCapacityComboBox.getSelectedItem().toString());


        try {
            bedDao.insertBed(bName, bCapacity, roomId);
            JOptionPane.showMessageDialog(null, "Inserted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was a problem with inserting");
        }

    }

    private void insertRoomInProperty(RoomDaoImpl roomDao) {
        String rName = prNameTextField.getText();
        Integer rNumber = Integer.parseInt(prNumberTextField.getText());
        Integer rPrice = Integer.parseInt(prPriceTextField.getText());
        Integer rSize = Integer.parseInt(prSizeTextField.getText());

        try {
            roomDao.insertRoom(rName, rNumber, rPrice, rSize, propertyId);
            JOptionPane.showMessageDialog(null, "Inserted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was a problem with inserting");
        }
    }

    private void addFacilityToProperty(PropertyDaoImpl propertyDao) {
        PropertyFacility propertyFacility = (PropertyFacility) pFacilityComboBox.getSelectedItem();
        Integer pfId = propertyFacility.getId();
        try {
            propertyDao.insertPropertyFacility(pfId, propertyId);
            JOptionPane.showMessageDialog(null, "Inserted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!");
        }

    }

    private void addFacilityToRoom(RoomDaoImpl roomDao, Integer roomId) {
        RoomFacility roomFacility = (RoomFacility) prFacilityComboBox.getSelectedItem();
        Integer rfId = roomFacility.getId();
        try {
            roomDao.insertRoomFacility(roomId, rfId);
            JOptionPane.showMessageDialog(null, "Inserted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!");
        }
    }

    private void createUser(UserDaoImpl userDao) {
        String fName = rFNameTextField.getText();
        String lName = rLNameTextField.getText();
        String passport = rPassportTextField.getText();
        String phone = rPhoneTextField.getText();
        String email = rEmailTextField.getText();
        String pass = String.valueOf(rPasswordField.getPassword());

        if (rPartnerRadioButton.isSelected()) {
            userDao.insertPartner(fName, lName, passport, email, phone, pass);
        } else {
            userDao.insertRegular(fName, lName, passport, email, phone, pass);
        }
    }
    ///////////////////////////////////////////////
    // Getters and setters for GLOBAL variables //
    /////////////////////////////////////////////
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }
}
