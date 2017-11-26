package com.fuelordersclient.gui;

import com.fuelordersclient.entity.FuelType;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author denis
 */
public class FuelTypeCBModel extends AbstractListModel<String>
    implements ComboBoxModel<String> {

    private final List<String> fuelTypes;
    private String selection = null;

    public FuelTypeCBModel() {
        fuelTypes = new ArrayList<>();
        for (FuelType t : FuelType.values()) {
            fuelTypes.add(t.getName());
        }
        setSelectedItem(FuelType.AI95.getName());
    }

    @Override
    public int getSize() {
        return fuelTypes.size();
    }

    @Override
    public String getElementAt(int index) {
        return fuelTypes.get(index);
    }

    // Methods implemented from the interface ComboBoxModel
    // to select and register an item from the pull-down list
    @Override
    public final void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    // to add the selection to the combo box
    @Override
    public Object getSelectedItem() {
        return selection;
    }
}
