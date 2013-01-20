package br.com.wbotelhos.spring.batch.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;

import br.com.wbotelhos.spring.batch.model.Person;


@Component("personMapper")
public class PersonMapper implements FieldSetMapper<Person> {
	
	private final static String DATE_PATTERN = "dd/MM/yy";

	@Override
	public Person mapFieldSet(FieldSet fieldSet) {
		
		Person person = new Person();
		int cursor = 0;
		
		person.setPersonid(fieldSet.readInt(cursor++));
		person.setfName(fieldSet.readString(cursor++));
		person.setlName(fieldSet.readString(cursor++));
		person.setCreatedDate(fieldSet.readDate(cursor++, DATE_PATTERN));
		
		return person;	
		
	}

}
