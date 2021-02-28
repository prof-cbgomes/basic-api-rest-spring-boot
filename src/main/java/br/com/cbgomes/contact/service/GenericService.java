/**
 * 
 */
package br.com.cbgomes.contact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cbgomes.util.Convertible;
import lombok.RequiredArgsConstructor;

/**
 * @author cbgomes
 *
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GenericService<T extends Convertible<DTO>, DTO, ID> {
	
	@Autowired
	private final JpaRepository<T, ID> repository;

	
	@Transactional
	public DTO save(T t) {
		return this.repository.save(t).converter();
	}
	
	@Transactional
	public void delete(ID id) {
		this.repository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<DTO> list() {
		return this.repository.findAll()
				.stream()
				.map(c -> c.converter()).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public DTO getById(ID id) {
		return this.repository.findById(id).get().converter();
	}
	
	@Transactional
	public DTO merge(T t) {
		 return this.repository.saveAndFlush(t).converter();
	}
	
}
