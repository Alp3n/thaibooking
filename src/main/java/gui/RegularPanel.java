package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularPanel extends JPanel {

    public JPanel getRegularPanel() {
        return regularPanel;
    }

    public JPanel getMainRegularPanel() {
        return mainRegularPanel;
    }

    private JPanel regularPanel;
    private JPanel cArchivedBookingsPanel;
    private JScrollPane cArchivedBookingsScrollPane;
    private JTable cArchivedBookingsTable;
    private JLabel cArchivedBookingsLabel;
    private JPanel cUpcomingBookingsPanel;
    private JScrollPane cUpcomingBookingsScrollPane;
    private JTable cUpcomingBookingsTable;
    private JLabel cUpcomingBookingsLabel;
    private JPanel cNavBarPanel;
    private JButton cHomeButton;
    private JButton cMyBookingsButton;
    private JButton cLogoutButton;
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
    private JPanel mainRegularPanel;


    public RegularPanel(CardPanelManager cpm) {

        MainFrame mainFrame = null;

        cLogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                cpm.changePanel(mainFrame.getFirstPanel());
            }
        });
        cHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                cpm.changePanel(mainFrame.getFirstPanel());
            }
        });
    }
}
