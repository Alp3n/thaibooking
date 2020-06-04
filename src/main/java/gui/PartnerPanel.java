package gui;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartnerPanel extends JPanel {

    public JPanel getPartnerPanel() {
        return partnerPanel;
    }

    public JPanel getMainPartnerPanel() {
        return mainPartnerPanel;
    }

    private JPanel partnerPanel;
    private JPanel pNavBarPanel;
    private JButton pMyPropertyButton;
    private JButton pMyRoomsButton;
    private JButton pMyBookingsButton;
    private JButton pLogoutButton;
    private JPanel pPropertyForm1;
    private JComboBox pTypeComboBox;
    private JComboBox pStarsComboBox;
    private JTextField pNameTextField;
    private JTextArea pDescritpionTextArea;
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
    private JPanel mainPartnerPanel;

    public PartnerPanel(CardPanelManager cpm){

        MainFrame mainFrame = null;

        pLogoutButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
//                cpm.changePanel(mainFrame.getFirstPanel());
            }
        });
    }
}
