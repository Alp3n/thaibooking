package gui;

import entities.bed.BedDaoImpl;
import entities.property.PropertyDaoImpl;
import entities.room.RoomDaoImpl;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.joda.time.LocalDate;
import org.joda.time.Period;

import java.util.Date;

public class MainFrame extends JFrame{
    private JPanel mainJPanel;
    private JButton searchButton;
    private JTextField searchTextField;
    private JLabel checkInLabel;
    private JLabel searchLabel;
    private JLabel checkOutLabel;
    private JLabel guestNumberLabel;
    private JSpinner guestNumberSpinner;
    private JPanel searchPanel;
    private JXDatePicker checkInDatePicker;
    private JXDatePicker checkOutDatePicker;
    private JTable propertyTable;
    private JScrollPane propertyScrollPane;
    private JPanel propertyPanel;
    private JTable roomTable;
    private JTable bedTable;
    private JLabel propertyTableLabel;
    private JLabel roomTableLabel;
    private JLabel bebTableLabel;
    private JScrollPane roomScrollPane;
    private JScrollPane bedScrollPane;
    private JButton bookRoomButton;
    private JList propertyFacilitiesList;
    private JList roomFacilitiesList;
    private JLabel roomFacilities;
    private JLabel propertyFacilities;
    private JPanel navBarPanel;
    private JButton registerButton;
    private JButton loginButton;
    private JPanel firstJPanel;
    private JPanel CheckInPanel;

    public MainFrame() {
        PropertyDaoImpl propertyDao = new PropertyDaoImpl();
        RoomDaoImpl roomDao = new RoomDaoImpl();
        BedDaoImpl bedDao = new BedDaoImpl();

        setContentPane(mainJPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(900,500);


        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                searchForPropertyOrLocation();
            }
        });

        propertyDao.listAllProperties(propertyTable);

        propertyTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = propertyTable.getSelectedRow();
                TableModel model = propertyTable.getModel();
                Integer propertyId = (Integer) model.getValueAt(index, 0);
                propertyDao.listAllPropertyFacilities(propertyFacilitiesList, propertyId);
                roomDao.listAllRoomsInProperty(roomTable, propertyId);
            }
        });

        roomTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = roomTable.getSelectedRow();
                TableModel model = roomTable.getModel();
                Integer roomId = (Integer) model.getValueAt(index, 0);
                roomDao.listAllRoomFacilities(roomFacilitiesList, roomId);
                bedDao.listAllBedsInRoom(bedTable, roomId);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
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

        int stayDuration = new Period(convertedCheckInDate, convertedCheckOutDate).getDays();

        System.out.println("Location or Property: " + locationProperty);
        System.out.println("Check in: " + convertedCheckInDate);
        System.out.println("Check out: " + convertedCheckOutDate);
        System.out.println("Guest number: " + guestNumber);
        System.out.println("Stay duration:" + stayDuration);
    }

    private LocalDate convertToLocalDate(Date dateToConvert) {
        return LocalDate.fromDateFields(dateToConvert);
    }
}
