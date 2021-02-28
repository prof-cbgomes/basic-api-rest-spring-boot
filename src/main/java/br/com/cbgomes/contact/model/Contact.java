/**
 * 
 */
package br.com.cbgomes.contact.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cbgomes.contact.model.dto.ContactDTO;
import br.com.cbgomes.util.Convertible;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author cbgomes
 *
 */
@Table(name = "tb_contacts")
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Contact implements Serializable, Convertible<ContactDTO> {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private Long id;
	
	private String name;
	
	private String email;
	
	private String phone;

	@Override
	public ContactDTO converter() {
		return new ContactDTO().convertToDTO(this);
	}
	
}
