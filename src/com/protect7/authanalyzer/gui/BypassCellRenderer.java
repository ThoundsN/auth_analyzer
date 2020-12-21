package com.protect7.authanalyzer.gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.protect7.authanalyzer.entities.OriginalRequestResponse;
import com.protect7.authanalyzer.util.BypassConstants;

public class BypassCellRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;
	

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if (value instanceof BypassConstants) {
			if (value.equals(BypassConstants.BYPASSED)) {
				if (!isSelected) {
					c.setBackground(new Color(255, 51, 51, 80));
				}
				c.setForeground(new Color(153, 0, 0));
			}
			if (value.equals(BypassConstants.POTENTIAL_BYPASSED)) {
				if (!isSelected) {
					c.setBackground(new Color(255, 153, 0, 80));
				}
				c.setForeground(new Color(200, 50, 0));
			}
			if (value.equals(BypassConstants.NOT_BYPASSED)) {
				if (!isSelected) {
					c.setBackground(new Color(0, 255, 51, 80));
				}
				c.setForeground(new Color(0, 102, 0));
			}
		}
		else {
			RequestTableModel tableModel = (RequestTableModel) table.getModel();
			final OriginalRequestResponse requestResponse = tableModel.getOriginalRequestResponse(table.convertRowIndexToModel(row));   	
			if(requestResponse.isMarked()) {
				if(!isSelected) {
					c.setBackground(new Color(255, 255, 0, 120));
				}
				else {
					c.setBackground(new Color(210, 210, 0, 120));
				}
			}
			else {
				if(!isSelected) {
					if(row % 2 == 0) {
						c.setBackground(table.getBackground());
					}
					else {
						c.setBackground(new Color(200, 200, 200, 80));
					}
				}
			}
		}
		return c;
	}

}
