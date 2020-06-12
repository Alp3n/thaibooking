package gui;

import entities.bed.BedDaoImpl;
import entities.booking.BookingDaoImpl;
import entities.payment.PaymentDaoImpl;
import entities.property.Property;
import entities.property.PropertyDaoImpl;
import entities.property.PropertyFacility;
import entities.property.PropertyType;
import entities.room.RoomDaoImpl;
import entities.room.RoomFacility;
import entities.user.UserDaoImpl;
import main.LoginAuthentication;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class MainFrame extends JFrame {

    private Integer userId = null;
    private Integer propertyId = null;

    private Integer selectedPropertyId = null;
    private Integer selectedRoomId = null;
    private Integer selectedPaymentId = null;
    private Integer selectedTotalPrice = null;
    private LocalDate selectedCheckIn = null;
    private LocalDate selectedCheckOut = null;
    private boolean searchWasClicked = false;

    private JPanel mainPanel;
    private JButton searchButton;
    private JTextField searchTextField;
    private JXDatePicker checkInDatePicker;
    private JXDatePicker checkOutDatePicker;
    private JTable propertyTable;
    private JTable roomTable;
    private JTable bedTable;
    private JList propertyFacilitiesList;
    private JList roomFacilitiesList;
    private JButton bookRoomButton;
    private JButton registerButton;
    private JButton loginButton;
    private JButton homeButton;
    private JTextField lEmailTextField;
    private JPasswordField lPasswordField;
    private JButton lLoginButton;
    private JTextField rFNameTextField;
    private JTextField rLNameTextField;
    private JTextField rPassportTextField;
    private JTextField rPhoneTextField;
    private JTextField rEmailTextField;
    private JPasswordField rPasswordField;
    private JRadioButton rPartnerRadioButton;
    private JButton rRegisterButton;
    private JButton cleanSearchButton;
    private JButton logoutButton;
    private JButton myRoomsButton;
    private JButton myBookingsButton;
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
    private JComboBox pCheckInComboBox;
    private JComboBox pCheckOutComboBox;
    private JComboBox pFacilityComboBox;
    private JButton pAddButton;
    private JList pFacilitiesList;
    private JScrollPane rArchivedBookingsScrollPane;
    private JTable rArchivedBookingsTable;
    private JTable rUpcomingBookingsTable;
    private JLabel rShowPropertyName;
    private JLabel rShowAddress;
    private JLabel rShowDate;
    private JLabel rShowEmail;
    private JLabel rShowRoomType;
    private JLabel rShowRoomSize;
    private JLabel rShowPaymentType;
    private JLabel rShowPaymentStatus;
    private JList rRoomFacilitiesList;
    private JList rPropertyFacilitiesList;
    private JTextField prNameTextField;
    private JTextField prNumberTextField;
    private JTextField prPriceTextField;
    private JTextField prSizeTextField;
    private JComboBox prFacilityComboBox;
    private JButton prAddFacilityButton;
    private JButton prCreateRoomButton;
    private JTable prRoomTable;
    private JList prRoomFacilitiesList;
    private JButton prDeleteRoomButton;
    private JComboBox prBedCapacityComboBox;
    private JTextField prBedNameTextField;
    private JButton prAddBedButton;
    private JButton prDeleteBedButton;
    private JTable prBedTable;
    private JTable bUpcomingTable;
    private JTable bCheckedInTable;
    private JButton bCheckInButton;
    private JLabel bpTotalLabel;
    private JLabel bpStatusLabel;
    private JLabel bpTypeLabel;
    private JLabel bbStatusLabel;
    private JLabel brNumberLabel;
    private JLabel bnNumber;
    private JLabel bsDateLabel;
    private JLabel bbIdLabel;
    private JTable bArchiveTable;
    private JButton bCheckOutButton;
    private JLabel bnGuestLabel;
    private JLabel rShowPaymentTotal;
    private JTable rBedTable;
    private JPanel mainCardPanel;
    private JPanel firstPanel;
    private JPanel loginPanel;
    private JPanel registerPanel;
    private JPanel partnerPropertyPanel;
    private JPanel regularPanel;
    private JPanel partnerRoomPanel;
    private JPanel partnerBookingPanel;
    private JPanel propertyPanel;
    private JPanel searchPanel;
    private JLabel searchLabel;
    private JPanel navBarPanel;
    private JButton myPropertyButton;
    private JScrollPane propertyScrollPane;
    private JScrollPane roomScrollPane;
    private JScrollPane bedScrollPane;
    private JLabel propertyTableLabel;
    private JLabel roomTableLabel;
    private JLabel bedTableLabel;
    private JLabel roomFacilities;
    private JLabel propertyFacilities;
    private JLabel checkInLabel;
    private JLabel checkOutLabel;
    private JPanel loginFormPanel;
    private JLabel lLoginLabel;
    private JPanel rRegisterForm;
    private JLabel rFNameLabel;
    private JLabel rRegisterAccountLabel;
    private JLabel rLNameLabel;
    private JLabel rPassportLabel;
    private JLabel regPhoneLabel;
    private JLabel regEmailLabel;
    private JLabel rPasswordLabel;
    private JLabel rPartnerLabel;
    private JLabel rPartnerLabel2;
    private JPanel pPropertyForm1;
    private JPanel pPropertyForm2;
    private JPanel rUpcomingBookingsPanel;
    private JPanel rArchivedBookingsPanel;
    private JPanel rBookingDetailsPanel;
    private JLabel rArchivedBookingsLabel;
    private JScrollPane rUpcomingBookingsScrollPane;
    private JLabel rUpcomingBookingsLabel;
    private JLabel rShowDescription;
    private JLabel rShowPhone;
    private JPanel prRoomFormPanel;
    private JPanel prBedFormPanel;
    private JScrollPane prRoomScroll;
    private JScrollPane prBedScroll;
    private JScrollPane bUpcomingScroll;
    private JScrollPane bCheckedInScroll;
    private JPanel pbBookingFormPanel;
    private JScrollPane bArchiveScroll;
    private JScrollPane rBedScroll;
    private JPanel paymentDetailsPanel;
    private JComboBox paymentMethodComboBox;
    private JPanel cardInfoPanel;
    private JTextField cardNumberField;
    private JTextField expirationDateField;
    private JPasswordField cvvPasswordField;
    private JLabel showTotalPriceLabel;
    private JLabel showCardProviderLabel;
    private JLabel rBookingDetailsLabel;
    private JLabel showTotalPriceHeading;
    private JPanel howToPanel;
    private JTextArea itIsSimple1TextArea;
    private JPanel CheckInPanel;
    private JFrame frame;

    public MainFrame() {

        // Setting up MainFrame to run
        setTitle("ThaiBooking");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1200,800);

        // Creating objects of used utility classes like Card Manager and DAO
        // Card Manager object to navigate between cards
        CardPanelManager cpm = new CardPanelManager();

        // Entities DAO objects to operate between UI and MySQL database
        PropertyDaoImpl propertyDao = new PropertyDaoImpl();
        RoomDaoImpl roomDao = new RoomDaoImpl();
        BedDaoImpl bedDao = new BedDaoImpl();
        BookingDaoImpl bookingDao = new BookingDaoImpl();
        PaymentDaoImpl paymentDao = new PaymentDaoImpl();
        UserDaoImpl userDao = new UserDaoImpl();

        // Hiding and showing navButtons for first panel
        showNavButtonsFirstPanel();

        //////////////////////////// -------------------NAVIGATION PANEL------------------- ////////////////////////////

        myBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (propertyId != null) {
                    cpm.changePanel(mainCardPanel, "partnerBookingPanel");
                } else {
                    cpm.changePanel(mainCardPanel, "regularPanel");
                }
            }
        });

        myRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainCardPanel, "partnerRoomPanel");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainCardPanel, "loginPanel");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainCardPanel, "registerPanel");
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainCardPanel, "firstPanel");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logoutUser(cpm, propertyDao);
            }
        });

        myPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cpm.changePanel(mainCardPanel, "partnerPropertyPanel");
            }
        });


        ////////////////////////////// -------------------FIRST PANEL------------------- ///////////////////////////////

        // UI adjustments on first run
        // Showing all properties in the table on first run
        propertyDao.listAllProperties(propertyTable);
        // Hiding book room button. It will be visible after pressing search button
        bookRoomButton.setVisible(false);

        // Showing first panel navigation buttons


        // Disabling dates that are before current day in JXDatePicker
        checkInDatePicker.getMonthView().setLowerBound(new Date());
        checkOutDatePicker.getMonthView().setLowerBound(new Date());

        // Listener for propertyTable
        propertyTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // propertyId is taken from chosen row in the propertyTable
                Integer propertyId = getIdFromTable(propertyTable);
                // Listing all property facilities depending on chosen property in the propertyTable
                propertyDao.listAllPropertyFacilities(propertyFacilitiesList, propertyId);
                // If search button was clicked roomTable will show results with available rooms in selected dates
                // otherwise, it will show all rooms that selected property from propertyTable has
                if (searchWasClicked == true) {
                    roomDao.listAvailablePropertyRoomsSearch(roomTable, propertyId, getSelectedCheckIn(), getSelectedCheckOut());
                } else {
                    roomDao.listAllRoomsInProperty(roomTable, propertyId);
                }
                // Setting global variable for creating a booking
                setSelectedPropertyId(propertyId);
            }
        });

        // Listener for propertyTable
        roomTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // roomId is taken from chosen row in the propertyTable
                Integer roomId = getIdFromTable(roomTable);
                // Listing all room facilities depending on chosen room in the roomTable
                roomDao.listAllRoomFacilities(roomFacilitiesList, roomId);
                // Listing all beds depending on chosen room in the roomTable
                bedDao.listAllBedsInRoom(bedTable, roomId);
                // Setting global variable for creating a booking
                setSelectedRoomId(roomId);
                try {
                    calculateTotal(roomDao);
                } catch (Exception e1) {
                    System.out.println("Use search option to see total price");
                }

            }
        });

        // Listener for search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Method from MainFrame class where given search phrase in searchTextField is set
                searchForPropertyOrLocation(propertyDao);
                // Changing status of global variable that tells roomTable that it will use search method to display rows
                setSearchWasClicked(true);
                // bookRoomButton is shown after pressing search button
                bookRoomButton.setVisible(true);
            }
        });

        // Listener for clean search button
        cleanSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Method that will clean tables to default state, searchTextField, and date pickers
                cleanSearch(propertyDao);
                bookRoomButton.setVisible(false);
            }
        });

        bookRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userId == null) {
                    JOptionPane.showMessageDialog(null, "Login first to book a room.");
                } else {
                    try {
                        bookARoomAndPay(roomDao, bookingDao, paymentDao);
                        JOptionPane.showMessageDialog(null, "You booked a room :) Check details in \"My bookings\"");
                    } catch (Exception ex) {
                        System.out.println(ex.getStackTrace());
                        JOptionPane.showMessageDialog(null, "Sorry, something went wrong :( Try again");
                    }
                }
            }
        });

        paymentMethodComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentMethod();
            }
        });

        ////////////////////////////// -------------------LOGIN PANEL------------------- ///////////////////////////////

        // Login button listener
        lLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Method to login and verify user type
                loginToTheSystem(cpm, propertyDao, roomDao, bedDao, bookingDao, userDao);
            }
        });

        ///////////////////////////// -------------------REGISTER PANEL------------------- /////////////////////////////

        // Register button listener
        rRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    // Method to get values from input fields and add user to database
                    createUser(userDao);
                    JOptionPane.showMessageDialog(null, "Registered successfully!");
                } catch (Exception e2) {
                    System.out.println(e2);
                    JOptionPane.showMessageDialog(null, "Ups something went wrong. Try different email.");
                }
            }
        });

        /////////////////////////// -------------------REGULAR USER PANEL------------------- ///////////////////////////

        // Upcoming bookings table listener
        rUpcomingBookingsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Getting bookingId from selected row in the rUpcomingBookingsTable
                Integer bookingId = getIdFromTable(rUpcomingBookingsTable);
                // Setting booking details into the form depending on selected bookingId
                setBookingDetailsRegular(bookingDao, propertyDao, roomDao, userDao, paymentDao, bookingId);
                // Getting propertyId and roomId from selected booking in the table
                Integer propertyId = bookingDao.getBooking(bookingId).getPropertyId();
                Integer roomId = bookingDao.getBooking(bookingId).getRoomId();
                // Showing stuff depending on selected before bookingId
                propertyDao.listAllPropertyFacilities(rPropertyFacilitiesList,propertyId);
                roomDao.listAllRoomFacilities(rRoomFacilitiesList, roomId);
                bedDao.listAllBedsInRoom(rBedTable, roomId);
            }
        });

        rArchivedBookingsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Getting bookingId from selected row in the rUpcomingBookingsTable
                Integer bookingId = getIdFromTable(rArchivedBookingsTable);
                // Setting booking details into the form depending on selected bookingId
                setBookingDetailsRegular(bookingDao, propertyDao, roomDao, userDao, paymentDao, bookingId);
                // Getting propertyId and roomId from selected booking in the table
                Integer propertyId = bookingDao.getBooking(bookingId).getPropertyId();
                Integer roomId = bookingDao.getBooking(bookingId).getRoomId();
                // Showing stuff depending on selected before bookingId
                propertyDao.listAllPropertyFacilities(rPropertyFacilitiesList,propertyId);
                roomDao.listAllRoomFacilities(rRoomFacilitiesList, roomId);
                bedDao.listAllBedsInRoom(rBedTable, roomId);
            }
        });

        /////////////////////////// -------------------PARTNER USER PANEL------------------- ///////////////////////////

        //// -PROPERTY PANEL- ////

        // Listener for save button
        pSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Inserting or updating property depending if user already have one or not
                updateProperty(propertyDao, cpm);
            }
        });

        // Listener for add facility to property button
        pAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Method that adds facilities to the property
                    addFacilityToProperty(propertyDao);
                    JOptionPane.showMessageDialog(null, "Added successfully!");
                } catch (SQLException ex) {
                    System.out.println(ex.getErrorCode());
                    if (ex.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null, "Duplicated facility!");
                    }
                }
                // Updating list every time facility is added
                propertyDao.listAllPropertyFacilities(pFacilitiesList, propertyId);
            }
        });

        //// -ROOM PANEL- ////

        // Listener for room table
        prRoomTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Getting roomId from selected row in the prRoomTable
                Integer roomId = getIdFromTable(prRoomTable);
                // Showing facilities and beds in the prBedTable for the selected room in prRoomTable
                roomDao.listAllRoomFacilities(prRoomFacilitiesList, roomId);
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

        prDeleteRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer roomId= getIdFromTable(prRoomTable);
                deleteRoomInProperty(roomDao, roomId);
                roomDao.tableAllRooms(prRoomTable, propertyId);
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

        prDeleteBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer bedId = getIdFromTable(prBedTable);
                deleteBedInRoom(bedDao, bedId);
                Integer roomId = getIdFromTable(prRoomTable);
                bedDao.tableAllBeds(prBedTable, roomId);
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

        //// -BOOKING PANEL- ////
        bUpcomingTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer bookingId = getIdFromTable(bUpcomingTable);
                setBookingDetails(bookingDao, roomDao, userDao, paymentDao, bookingId);
            }
        });
        bCheckedInTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer bookingId = getIdFromTable(bCheckedInTable);
                setBookingDetails(bookingDao, roomDao, userDao, paymentDao, bookingId);
            }
        });
        bArchiveTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer bookingId = getIdFromTable(bArchiveTable);
                setBookingDetails(bookingDao, roomDao, userDao, paymentDao, bookingId);
            }
        });
        bCheckInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer bookingId = getIdFromTable(bUpcomingTable);
                Integer paymentId = bookingDao.getBooking(bookingId).getPaymentId();

                try {
                    bookingDao.checkInBooking(bookingId);
                    JOptionPane.showMessageDialog(null, "Checked in successfully!");
                    bookingDao.tableAllPartnerBookings(bCheckedInTable, propertyId, "Checked In");
                    bookingDao.tableAllPartnerBookings(bUpcomingTable, propertyId, "Upcoming");
                    paymentDao.updatePaymentInBooking(paymentId);

                }catch (Exception e2) {
                    System.out.println(e2);
                    JOptionPane.showMessageDialog(null, "Could not check in!");
                }
            }
        });

        bCheckOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer bookingId = getIdFromTable(bCheckedInTable);

                try {
                    bookingDao.checkOutBooking(bookingId);
                    JOptionPane.showMessageDialog(null, "Checked out successfully!");
                    bookingDao.tableAllPartnerBookings(bArchiveTable, propertyId, "Archived");
                    bookingDao.tableAllPartnerBookings(bCheckedInTable, propertyId, "Checked In");
                }catch (Exception e2) {
                    System.out.println(e2);
                    JOptionPane.showMessageDialog(null, "Could not check out!");
                }
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }

    private void calculateTotal(RoomDaoImpl roomDao) {
        Integer stayDuration = (int) DAYS.between(getSelectedCheckIn(), getSelectedCheckOut());
        int roomPrice = roomDao.getRoom(getSelectedRoomId()).getPriceNight();
        Integer totalPrice = stayDuration * roomPrice;
        showTotalPriceHeading.setText("Total price for " + String.valueOf(stayDuration) + " nights");
        showTotalPriceLabel.setText(String.valueOf(totalPrice) + " THB");
    }

    private void showNavButtonsPartner() {
        myBookingsButton.setVisible(true);
        myPropertyButton.setVisible(true);
        myRoomsButton.setVisible(true);
        logoutButton.setVisible(true);
        homeButton.setVisible(false);
        registerButton.setVisible(false);
        loginButton.setVisible(false);
    }

    private void showNavButtonsRegular() {
        myBookingsButton.setVisible(true);
        logoutButton.setVisible(true);
        registerButton.setVisible(false);
        loginButton.setVisible(false);
    }

    private void showNavButtonsFirstPanel() {
        myBookingsButton.setVisible(false);
        myPropertyButton.setVisible(false);
        myRoomsButton.setVisible(false);
        logoutButton.setVisible(false);
        homeButton.setVisible(true);
        registerButton.setVisible(true);
        loginButton.setVisible(true);
    }

    //////////////////////////////////////
    // Methods for logic in main frame //
    ////////////////////////////////////

    private void paymentMethod() {
        if (paymentMethodComboBox.getSelectedItem().toString().equalsIgnoreCase("Credit/Debit Card")) {
            cardInfoPanel.setVisible(true);
        } else {
            cardInfoPanel.setVisible(false);
        }
    }

    private Integer getIdFromTable(JTable table) {
        int index = table.getSelectedRow();
        TableModel model = table.getModel();
        return (Integer) model.getValueAt(index, 0);
    }

    private void cleanSearch(PropertyDaoImpl propertyDao) {
        setSearchWasClicked(false);
        setSelectedPropertyId(null);
        setSelectedRoomId(null);
        setSelectedCheckIn(null);
        setSelectedCheckOut(null);
        setSelectedPaymentId(null);
        searchTextField.setText("");
        showTotalPriceHeading.setText("Total price");
        showTotalPriceLabel.setText("");
        checkInDatePicker.setDate(null);
        checkOutDatePicker.setDate(null);
        propertyDao.listAllProperties(propertyTable);
        roomTable.setModel(new DefaultTableModel());
        bedTable.setModel(new DefaultTableModel());
    }

    private void bookARoomAndPay(RoomDaoImpl roomDao, BookingDaoImpl bookingDao, PaymentDaoImpl paymentDao) {
        // Setting some local variables from global ones
        LocalDate checkIn = getSelectedCheckIn();
        LocalDate checkOut = getSelectedCheckOut();
        Integer propertyId = getSelectedPropertyId();
        Integer roomId = getSelectedRoomId();
        Integer userId = getUserId();
        // bStatus is booking status for new booking which is always upcoming
        String bStatus = "Upcoming";


        // First we create payment to insert its ID to new booking
        // pStatus is a status of the payment and it depends on selection in combobox
        String pStatus;
        // paymentType depends on selection in combobox
        String paymentType = paymentMethodComboBox.getSelectedItem().toString();

        Integer stayDuration = (int) DAYS.between(checkIn, checkOut);
        int roomPrice = roomDao.getRoom(roomId).getPriceNight();
        Integer totalPrice = stayDuration * roomPrice;
        showTotalPriceLabel.setText(String.valueOf(totalPrice));

        if (paymentType.equalsIgnoreCase("Credit/Debit Card")) {
            pStatus = "Paid";
        } else {
            pStatus = "Pending";
        }

        // Insert method of payment returns its auto-generated ID so it can be used for inserting it in booking
        setSelectedPaymentId(paymentDao.insertPaymentToBooking(paymentType, pStatus, totalPrice));
        Integer paymentId = getSelectedPaymentId();

        // Inserting booking to the database with selected previously global variables
        bookingDao.createBooking(userId, roomId, propertyId, paymentId, checkIn, checkOut, bStatus);
        bookingDao.tableAllRegularBookings(rUpcomingBookingsTable, userId, "Upcoming");
    }

    private void searchForPropertyOrLocation(PropertyDaoImpl propertyDao) {

        String searchPhrase = searchTextField.getText();
        Date checkInDate = checkInDatePicker.getDate();
        Date checkOutDate = checkOutDatePicker.getDate();
        setSelectedCheckIn(convertToLocalDate(checkInDate));
        setSelectedCheckOut(convertToLocalDate(checkOutDate));

        // Listing all properties with  containing search phrase
        propertyDao.listAllPropertiesSearch(propertyTable, searchPhrase);

        //Clearing room table after pressing search
        roomTable.setModel(new DefaultTableModel());
    }

    private LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /// LOGIN ///
    private void loginToTheSystem(CardPanelManager cpm, PropertyDaoImpl propertyDao, RoomDaoImpl roomDao, BedDaoImpl bedDao, BookingDaoImpl bookingDao, UserDaoImpl userDao) {
        LoginAuthentication la = new LoginAuthentication();

        String email = lEmailTextField.getText();
        String pass = String.valueOf(lPasswordField.getPassword());
        String userType = null;
        Integer userId = null;
        try {
            userType = la.loginAuth(email, pass).getType();
            userId = la.loginAuth(email, pass).getId();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No user in the system! Try again.");
        }

        Property property = propertyDao.getPropertyByUserId(userId);

        String userFirstName = la.loginAuth(email, pass).getfName();

        try {
            if (userType.equalsIgnoreCase("Partner") && property == null) {
                cpm.changePanel(mainCardPanel, "partnerPropertyPanel");
                setUserId(userId);
                createFirstTimePartnerProfile(propertyDao, roomDao, bookingDao);
                JOptionPane.showMessageDialog(null, "Welcome " + userFirstName);
            } else if (userType.equalsIgnoreCase("Regular")){
                cpm.changePanel(mainCardPanel,"regularPanel");
                setUserId(userId);
                createRegularProfile(propertyDao, roomDao, bedDao, bookingDao, userDao, userId);
                JOptionPane.showMessageDialog(null, "Welcome " + userFirstName);
            } else if (userType.equalsIgnoreCase("Partner")) {
                cpm.changePanel(mainCardPanel,"partnerPropertyPanel");
                Integer propertyId = propertyDao.getPropertyByUserId(userId).getId();
                setUserId(userId);
                setPropertyId(propertyId);
                createPartnerProfile(propertyDao, roomDao, bookingDao, userId, propertyId);
                JOptionPane.showMessageDialog(null, "Welcome " + userFirstName);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    /// LOGOUT ///
    private void logoutUser(CardPanelManager cpm, PropertyDaoImpl propertyDao) {
        // Changing panel to first panel
        cpm.changePanel(mainCardPanel,"firstPanel");

        // Setting global variables to null, so there is no "active" user
        setUserId(null);
        setPropertyId(null);

        // Showing all properties in the propertyTable on the first panel
        propertyDao.listAllProperties(propertyTable);

        // Clearing profiles from data that was left after login
        clearRegularProfile();
        clearPartnerProfile();

        // Changing navigation bar buttons
        showNavButtonsFirstPanel();

        // Showing message
        JOptionPane.showMessageDialog(null, "Logged out successfully!");
    }


    private void createFirstTimePartnerProfile(PropertyDaoImpl propertyDao, RoomDaoImpl roomDao, BookingDaoImpl bookingDao) {
        showNavButtonsPartner();

        propertyDao.getPropertyTypes(pTypeComboBox);
        propertyDao.getPropertyFacility(pFacilityComboBox);
    }
    /// CREATING PARTNER PROFILE ///

    // TODO change getpartnerproperty and getpropertybyuserid
    private void createPartnerProfile(PropertyDaoImpl propertyDao, RoomDaoImpl roomDao, BookingDaoImpl bookingDao, Integer userId, Integer propertyId) {

        showNavButtonsPartner();

        try {
            // MY PROPERTY TAB //
            propertyDao.getPropertyTypes(pTypeComboBox);
            propertyDao.getPropertyFacility(pFacilityComboBox);
            propertyDao.listAllPropertyFacilities(pFacilitiesList, propertyId);

            pTypeComboBox.setSelectedItem(propertyDao.getPropertyByUserId(userId).getPropertyType());
            pStarsComboBox.setSelectedItem(propertyDao.getPropertyByUserId(userId).getStars());
            pNameTextField.setText(propertyDao.getPropertyByUserId(userId).getName());
            pDescriptionTextArea.setText(propertyDao.getPropertyByUserId(userId).getDescription());
            pRoadTextField.setText(propertyDao.getPropertyByUserId(userId).getRoad());
            pDistrictTextField.setText(propertyDao.getPropertyByUserId(userId).getDistrict());
            pCityTextField.setText(propertyDao.getPropertyByUserId(userId).getCity());
            pZipCodeTextField.setText(propertyDao.getPropertyByUserId(userId).getZipCode());
            pEmailTextField.setText(propertyDao.getPropertyByUserId(userId).getEmail());
            pPhoneTextField.setText(propertyDao.getPropertyByUserId(userId).getPhone());
            pCheckInComboBox.setSelectedItem(propertyDao.getPropertyByUserId(userId).getCheckInTime());
            pCheckOutComboBox.setSelectedItem(propertyDao.getPropertyByUserId(userId).getCheckOutTime());

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

    private void setBookingDetails(BookingDaoImpl bookingDao, RoomDaoImpl roomDao, UserDaoImpl userDao, PaymentDaoImpl paymentDao, Integer bId) {

        bbIdLabel.setText(String.valueOf(bookingDao.getBooking(bId).getId()));
        Integer uId = bookingDao.getBooking(bId).getUserId();
        String fullName = userDao.getUser(uId).getfName() + " " + userDao.getUser(uId).getlName();
        bnGuestLabel.setText(fullName);

        LocalDate checkIn = bookingDao.getBooking(bId).getCheckIn();
        LocalDate checkOut = bookingDao.getBooking(bId).getCheckOut();
        String stayDate = "From " + checkIn + " till " + checkOut;
        bsDateLabel.setText(stayDate);

        Integer stayDuration = (int) DAYS.between(checkIn, checkOut);
        bnNumber.setText(String.valueOf(stayDuration));

        Integer roomId = bookingDao.getBooking(bId).getRoomId();
        String roomNumber = String.valueOf(roomDao.getRoom(roomId).getRoomNumber());

        brNumberLabel.setText(roomNumber);
        bbStatusLabel.setText(bookingDao.getBooking(bId).getStatus());
        Integer pId = bookingDao.getBooking(bId).getPaymentId();
        bpTypeLabel.setText(paymentDao.getPayment(pId).getType());
        bpStatusLabel.setText(paymentDao.getPayment(pId).getStatus());

        //Total price
        int roomPrice = roomDao.getRoom(roomId).getPriceNight();
        Integer totalPrice = stayDuration * roomPrice;
        bpTotalLabel.setText(String.valueOf(totalPrice));
    }

    private void clearPartnerProfile() {
        bbIdLabel.setText("");
        bnGuestLabel.setText("");
        bsDateLabel.setText("");
        bnNumber.setText("");
        brNumberLabel.setText("");
        bbStatusLabel.setText("");
        bpTypeLabel.setText("");
        bpStatusLabel.setText("");
        bpTotalLabel.setText("");

        pTypeComboBox.removeAllItems();
        pFacilityComboBox.removeAllItems();
    }

    private void updateProperty(PropertyDaoImpl propertyDao, CardPanelManager cpm) {
        PropertyType pType = (PropertyType) pTypeComboBox.getSelectedItem();
        Integer propertyType = pType.getId();
        Integer userId = getUserId();
        Integer propertyId = getPropertyId();
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
                setPropertyId(propertyDao.getPropertyByUserId(userId).getId());
                logoutUser(cpm,propertyDao);
                JOptionPane.showMessageDialog(null, "We had to register your property in our system and log you out. Please log in again.");
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
            roomDao.deleteRoom(roomId, getPropertyId());
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
            roomDao.insertRoom(rName, rNumber, rPrice, rSize, getPropertyId());
            JOptionPane.showMessageDialog(null, "Inserted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"There was a problem with inserting");
        }
    }

    private void addFacilityToProperty(PropertyDaoImpl propertyDao) throws SQLException {
        PropertyFacility propertyFacility = (PropertyFacility) pFacilityComboBox.getSelectedItem();
        Integer pfId = propertyFacility.getId();
        propertyDao.insertPropertyFacility(pfId, getPropertyId());
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

    /// CREATING REGULAR PROFILE ///
    private void createRegularProfile(PropertyDaoImpl propertyDao, RoomDaoImpl roomDao, BedDaoImpl bedDao, BookingDaoImpl bookingDao, UserDaoImpl userDao, Integer userId) {

        showNavButtonsRegular();

        bookingDao.tableAllRegularBookings(rUpcomingBookingsTable, userId, "Upcoming");
        bookingDao.tableAllRegularBookings(rArchivedBookingsTable, userId, "Archived");
    }
    // This method is used in table listener to show information in text labels depending on selected booking
    private void setBookingDetailsRegular(BookingDaoImpl bookingDao,PropertyDaoImpl propertyDao, RoomDaoImpl roomDao, UserDaoImpl userDao, PaymentDaoImpl paymentDao, Integer bId) {
        Integer propertyId = bookingDao.getBooking(bId).getPropertyId();
        Integer roomId = bookingDao.getBooking(bId).getRoomId();
        Integer paymentId = bookingDao.getBooking(bId).getPaymentId();

        LocalDate checkIn = bookingDao.getBooking(bId).getCheckIn();
        LocalDate checkOut = bookingDao.getBooking(bId).getCheckOut();
        String stayDate = "From " + checkIn + " till " + checkOut;
        rShowDate.setText(stayDate);

        String propertyName = propertyDao.getPropertyByPropertyId(propertyId).getName();
        rShowPropertyName.setText(propertyName);

        String road = propertyDao.getPropertyByPropertyId(propertyId).getRoad();
        String district =propertyDao.getPropertyByPropertyId(propertyId).getDistrict();
        String city = propertyDao.getPropertyByPropertyId(propertyId).getCity();
        String zipcode = propertyDao.getPropertyByPropertyId(propertyId).getZipCode();
        String address = road + ", "+ district + ", " + city + ", " + zipcode;
        rShowAddress.setText(address);

        String description = propertyDao.getPropertyByPropertyId(propertyId).getDescription();
        rShowDescription.setText(description);

        String email = propertyDao.getPropertyByPropertyId(propertyId).getEmail();
        rShowEmail.setText(email);

        String phone = propertyDao.getPropertyByPropertyId(propertyId).getPhone();
        rShowPhone.setText(phone);

        String roomType = roomDao.getRoom(roomId).getName();
        rShowRoomType.setText(roomType);

        String roomSize = String.valueOf(roomDao.getRoom(roomId).getSize());
        rShowRoomSize.setText(roomSize);

        String pType = paymentDao.getPayment(paymentId).getType();
        rShowPaymentType.setText(pType);

        String pStatus = paymentDao.getPayment(paymentId).getStatus();
        rShowPaymentStatus.setText(pStatus);

        //Total price

        Integer stayDuration = (int) DAYS.between(checkIn, checkOut);
        int roomPrice = roomDao.getRoom(roomId).getPriceNight();
        Integer totalPrice = stayDuration * roomPrice;
        rShowPaymentTotal.setText(String.valueOf(totalPrice));
    }

    // Function to clear profile after login out
    private void clearRegularProfile() {

        // Cleaning text labels
        rShowDate.setText("");
        rShowPropertyName.setText("");
        rShowAddress.setText("");
        rShowDescription.setText("");
        rShowEmail.setText("");
        rShowPhone.setText("");
        rShowRoomType.setText("");
        rShowRoomSize.setText("");
        rShowPaymentType.setText("");
        rShowPaymentStatus.setText("");
        rShowPaymentTotal.setText("");

        // Cleaning tables and lists
        rPropertyFacilitiesList.setModel(new DefaultListModel());
        rBedTable.setModel(new DefaultTableModel());
        rRoomFacilitiesList.setModel(new DefaultListModel());
    }

    /// REGISTER ///
    private void createUser(UserDaoImpl userDao) {

        // Getting values from field texts
        String fName = rFNameTextField.getText();
        String lName = rLNameTextField.getText();
        String passport = rPassportTextField.getText();
        String phone = rPhoneTextField.getText();
        String email = rEmailTextField.getText();
        String pass = String.valueOf(rPasswordField.getPassword());

        // Calling method to insert a specific user, depending on selection of radio button
        if (rPartnerRadioButton.isSelected()) {
            userDao.insertPartner(fName, lName, passport, email, phone, pass);
        } else {
            userDao.insertRegular(fName, lName, passport, email, phone, pass);
        }

        // Cleaning fields after creating a user
        rFNameTextField.setText("");
        rLNameTextField.setText("");
        rPassportTextField.setText("");
        rPhoneTextField.setText("");
        rEmailTextField.setText("");
        rPasswordField.setText("");
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

    public Integer getSelectedPropertyId() {
        return selectedPropertyId;
    }

    public void setSelectedPropertyId(Integer selectedPropertyId) {
        this.selectedPropertyId = selectedPropertyId;
    }

    public Integer getSelectedRoomId() {
        return selectedRoomId;
    }

    public void setSelectedRoomId(Integer selectedRoomId) {
        this.selectedRoomId = selectedRoomId;
    }

    public Integer getSelectedPaymentId() {
        return selectedPaymentId;
    }

    public void setSelectedPaymentId(Integer selectedPaymentId) {
        this.selectedPaymentId = selectedPaymentId;
    }

    public LocalDate getSelectedCheckIn() {
        return selectedCheckIn;
    }

    public void setSelectedCheckIn(LocalDate selectedCheckIn) {
        this.selectedCheckIn = selectedCheckIn;
    }

    public LocalDate getSelectedCheckOut() {
        return selectedCheckOut;
    }

    public void setSelectedCheckOut(LocalDate selectedCheckOut) {
        this.selectedCheckOut = selectedCheckOut;
    }

    public boolean isSearchWasClicked() {
        return searchWasClicked;
    }

    public void setSearchWasClicked(boolean searchWasClicked) {
        this.searchWasClicked = searchWasClicked;
    }
}
