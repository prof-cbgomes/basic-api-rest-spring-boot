/**
 * 
 */
package br.com.cbgomes.contact.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cbgomes.contact.model.Contact;
import br.com.cbgomes.contact.model.dto.ContactDTO;
import br.com.cbgomes.contact.service.GenericService;
import lombok.RequiredArgsConstructor;

/**
 * @author cbgomes
 *
 */
@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContactResource {

	private final GenericService<Contact, ContactDTO, Long> service;
	

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<ContactDTO> save(@RequestBody final Contact contact) {
		return new ResponseEntity<ContactDTO>(this.service.save(contact), HttpStatus.CREATED);
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<ContactDTO>> list(){
		return ResponseEntity.ok(this.service.list());
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<ContactDTO> getById(@PathVariable("id") final Long id){
		return ResponseEntity.ok(this.service.getById(id));
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<ContactDTO> edit(@RequestBody Contact contact){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.merge(contact));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<ContactDTO> delete(@PathVariable("id") final Long id) {
		 return ResponseEntity.ok(service.getById(id));
	}
}
