package br.com.cbgomes.contact.model.dto;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.cbgomes.contact.model.Contact;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author cbgomes
 *
 */
@Getter
@Setter
public class ContactDTO {

	private String name;

	private String email;

	private String phone;

	@Getter
	private static ModelMapper modelMapper;
	
	
	@JsonCreator
	public ContactDTO() {
		ContactDTO.modelMapper = new ModelMapper();
	}
	
	public Contact convertToContact(ContactDTO dto) {
		return modelMapper.map(dto, Contact.class);
	}

	public ContactDTO convertToDTO(Contact contact) {
		return modelMapper.map(contact, ContactDTO.class);
	}
}
