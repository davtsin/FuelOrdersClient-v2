package com.fuelordersclient.gui;

import com.fuelordersclient.entity.Company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author denis
 */
public class CompanyCBModel extends AbstractListModel<String>
    implements ComboBoxModel<String> {

    private ArrayList<String> companyNames;
    private String selection = null;

    public CompanyCBModel(Set<Company> companies) {
        companyNames = new ArrayList<>();
        companies.forEach((c) -> companyNames.add(c.getName()));
        Collections.sort(companyNames);
    }

    @Override
    public int getSize() {
        return companyNames.size();
    }

    @Override
    public String getElementAt(int index) {
        return companyNames.get(index);
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
