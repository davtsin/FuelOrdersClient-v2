package com.fuelordersclient.gui;

import com.fuelordersclient.entity.GasStation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author denis
 */
public class GasStationCBModel extends AbstractListModel<String>
    implements ComboBoxModel<String> {

    private List<String> gasStationNames;
    private String selection = null;

    public GasStationCBModel(Set<GasStation> gasStations) {
        gasStationNames = new ArrayList<>();
        gasStations.forEach(
            (g) -> gasStationNames.add(g.getCode() + "#" + g.getAddress()));
        Collections.sort(gasStationNames);
    }

    @Override
    public int getSize() {
        return gasStationNames.size();
    }

    @Override
    public String getElementAt(int index) {
        return gasStationNames.get(index);
    }

    // Methods implemented from the interface ComboBoxModel
    // to select and register an item from the pull-down list
    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    // to add the selection to the combo box
    @Override
    public Object getSelectedItem() {
        return selection;
    }
}
