package gui;

import javax.swing.*;
import java.awt.*;

public class CardPanelManager {

    public void changePanel(JPanel parent, String child) {

        CardLayout cardLayout = (CardLayout) parent.getLayout();

        cardLayout.show(parent, child);

        /*Container container = panelName.getParent();

        container.removeAll();
        container.add(panelName);
        container.repaint();
        container.revalidate();*/
    }
}
