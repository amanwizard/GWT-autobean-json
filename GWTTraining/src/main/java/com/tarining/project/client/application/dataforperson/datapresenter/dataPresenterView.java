package com.tarining.project.client.application.dataforperson.datapresenter;

import java.util.List;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class dataPresenterView extends ViewWithUiHandlers<dataPresenterUiHandlers>
		implements dataPresenterPresenter.MyView {
	interface Binder extends UiBinder<Widget, dataPresenterView> {
	}

	/*
	 * @UiField SimplePanel main;
	 */

	@UiField
	TextBox name, mobnumber, email;

	@UiField
	IntegerBox age;

	@UiField
	Button submit;
	@UiField
	HTMLPanel tablePanel;

	@Inject
	dataPresenterView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));

		// submit.addClickHandler(handler)
	}

	@Override
	public String getname() {
		return name.getValue();
	}

	@Override
	public Integer getAge() {
		return age.getValue();
	}

	@Override
	public String getMoblileNumber() {
		return mobnumber.getText();
	}

	@Override
	public String getEmail() {
		return email.getText();
	}

	@UiHandler("submit")
	void onclick(ClickEvent e) {
		getUiHandlers().fetchDetails();
	}

	@Override
	public void settable(List<PersonDAO> personList) {
		tablePanel.clear();
		
		
		CellTable<PersonDAO> table = new CellTable<PersonDAO>();

		// column 1
		TextColumn<PersonDAO> name = new TextColumn<PersonDAO>() {

			@Override
			public String getValue(PersonDAO object) {

				return object.getFullName();
			}
		};
		table.addColumn(name, "Name");

		// column 2
		TextColumn<PersonDAO> age = new TextColumn<PersonDAO>() {

			@Override
			public String getValue(PersonDAO object) {
				return object.getAge().toString();
			}
		};
		table.addColumn(age, "Age");

		// column 3
		TextColumn<PersonDAO> mobnumber = new TextColumn<PersonDAO>() {

			@Override
			public String getValue(PersonDAO object) {
				// TODO Auto-generated method stub
				return object.getMobileNumber();
			}
		};
		table.addColumn(mobnumber, "Mobile Number");

		// column 4
		TextColumn<PersonDAO> email = new TextColumn<PersonDAO>() {

			@Override
			public String getValue(PersonDAO object) {
				// TODO Auto-generated method stub
				return object.getEmailID();
			}
		};
		table.addColumn(email, "Email ID's");
		table.setRowCount(personList.size(), true);

		// Push the data into the widget.
		table.setRowData(0, personList);
		tablePanel.add(table);

	}

	/*
	 * @Override public void setInSlot(Object slot, IsWidget content) { if (slot
	 * == dataPresenterPresenter.SLOT_dataPresenter) { main.setWidget(content);
	 * } else { super.setInSlot(slot, content); } }
	 */
}
