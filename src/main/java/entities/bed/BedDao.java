package entities.bed;

import entities.room.RoomFacility;

import javax.swing.*;
import java.util.List;

public interface BedDao {

    void listAllBedsInRoom(JTable table, Integer roomId);
    boolean insertBed();
    boolean deleteBed();
}
