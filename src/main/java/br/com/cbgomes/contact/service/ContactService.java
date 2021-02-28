/**
 * 
 */
package br.com.cbgomes.contact.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cbgomes.contact.model.Contact;
import br.com.cbgomes.contact.model.dto.ContactDTO;
import br.com.cbgomes.contact.repository.ContactReporitory;

/**
 * @author cbgomes
 *
 */
@Service
public class ContactService {
	
	private final ContactReporitory repository;

	@Autowired
	public ContactService(final ContactReporitory repository) {
		this.repository = repository;
	}
	

	@Transactional
	public Contact save(Contact contact) {
		return this.repository.save(contact);
	}
	
	@Transactional
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<ContactDTO> list() {
		return this.repository.findAll().stream().map(c -> new ContactDTO().convertToDTO(c)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Optional<Contact> getById(Long id) {
		return this.repository.findById(id);
	}
	@Transactional
	public Contact merge(Contact contact) {
		 return this.repository.saveAndFlush(contact);
	}
	
}
