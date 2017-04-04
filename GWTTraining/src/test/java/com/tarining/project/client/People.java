package com.tarining.project.client;

import java.util.List;

public class People implements PeopleInterface {

	List<PersonInterface> people;

	public List<PersonInterface> getPeople() {
		return people;
	}

	public void setPeople(List<PersonInterface> people) {
		this.people = people;
	}

	public People(List<PersonInterface> people) {
		super();
		this.people = people;
	}

}
