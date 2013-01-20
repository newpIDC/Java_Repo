package br.com.wbotelhos.spring.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wbotelhos.spring.batch.dao.PagamentoDAO;
import br.com.wbotelhos.spring.batch.model.Person;


@Component("personWriter")
public class PersonWriter implements ItemWriter<Person> {
	
	@Autowired
	private PagamentoDAO pagamentoDAO;

	public void write(List<? extends Person> personList) throws Exception {
		for (Person person : personList) {
			pagamentoDAO.savePerson(person);
		}	
	}
}