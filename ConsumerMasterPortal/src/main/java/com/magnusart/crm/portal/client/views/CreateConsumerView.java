package com.magnusart.crm.portal.client.views;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.magnusart.crm.portal.client.events.ChangeConsumerEventHandler;
import com.magnusart.crm.portal.client.events.CreateConsumerEvent;
import com.magnusart.crm.portal.client.presenters.ChangeConsumerPresenter.Display;

/**
 * 
 * @author Magnus Andersson
 * @since 17 okt 2010
 */
public class CreateConsumerView extends Composite implements Display {

	/**
	 * Type of consumer
	 * 
	 * @author Magnus Andersson
	 * @since 17 okt 2010
	 */
	public enum ConsumerType {
		PERSON, COMPANY
	}

	@UiField
	RadioButton personBtn;

	@UiField
	RadioButton companyBtn;

	@UiField
	DeckPanel consumerInformationDeck;

	@UiField
	FlexTable personDetails;

	@UiField
	FlexTable companyDetails;

	@UiField
	Button createButton;

	ConsumerType type = ConsumerType.PERSON;

	// Person Details
	TextBox firstName;
	TextBox lastName;
	TextBox middleName;
	TextBox age;

	// Company Details
	TextBox companyName;
	TextBox noOfEmployees;
	TextBox mainContactPersonId;

	interface ConsumerViewUiBinder extends UiBinder<Widget, CreateConsumerView> {
	}

	private static ConsumerViewUiBinder uiBinder = GWT
			.create(ConsumerViewUiBinder.class);

	public CreateConsumerView() {
		initWidget(uiBinder.createAndBindUi(this));

		personBtn.setValue(true);
		consumerInformationDeck.showWidget(0);

		setupPersonDetails();

		setupCompanyDetails();
	}

	private void setupCompanyDetails() {

		// Company Details
		companyName = new TextBox();
		noOfEmployees = new TextBox();
		mainContactPersonId = new TextBox();

		companyDetails.setWidget(0, 0, new Label("Company Name"));
		companyDetails.setWidget(0, 1, companyName);
		companyDetails.setWidget(1, 0, new Label("Number of Employees"));
		companyDetails.setWidget(1, 1, noOfEmployees);
		companyDetails.setWidget(2, 0, new Label("Main Contact Person"));
		companyDetails.setWidget(2, 1, mainContactPersonId);
	}

	private void setupPersonDetails() {

		// Person Details
		firstName = new TextBox();
		lastName = new TextBox();
		middleName = new TextBox();
		age = new TextBox();

		personDetails.setWidget(0, 0, new Label("First name"));
		personDetails.setWidget(0, 1, firstName);
		personDetails.setWidget(1, 0, new Label("Middle name"));
		personDetails.setWidget(1, 1, middleName);
		personDetails.setWidget(2, 0, new Label("Last name"));
		personDetails.setWidget(2, 1, lastName);
		personDetails.setWidget(3, 0, new Label("Age"));
		personDetails.setWidget(3, 1, age);

		firstName.setFocus(true);

	}

	@Override
	public HandlerRegistration addSaveContactEventHandler(
			final ChangeConsumerEventHandler handler) {
		return addHandler(handler, CreateConsumerEvent.TYPE);
	}

	@Override
	public void setData(final List<String> data) {

	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@UiHandler({ "personBtn", "companyBtn" })
	void changeConsumerType(final ClickEvent e) {
		if (e.getSource().equals(personBtn)) {
			type = ConsumerType.PERSON;
			consumerInformationDeck.showWidget(0);
		} else if (e.getSource().equals(companyBtn)) {
			type = ConsumerType.COMPANY;
			consumerInformationDeck.showWidget(1);
		}
	}

	@UiHandler("createButton")
	void createConsumer(final ClickEvent e) {
		fireEvent(new CreateConsumerEvent());
	}

	@Override
	public ArrayList<String> getData() {
		final ArrayList<String> list = new ArrayList<String>();

		switch (type) {
		case PERSON:
			list.add(firstName.getValue());
			list.add(lastName.getValue());
			list.add(middleName.getValue());
			list.add(age.getValue());
			break;
		case COMPANY:
			// Company Details
			list.add(companyName.getValue());
			list.add(noOfEmployees.getValue());
			list.add(mainContactPersonId.getValue());
			break;
		}

		return list;
	}

	@Override
	public ConsumerType getType() {
		return type;
	}
}
