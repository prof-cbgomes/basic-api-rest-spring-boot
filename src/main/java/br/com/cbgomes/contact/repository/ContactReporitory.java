/**
 * 
 */
package br.com.cbgomes.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cbgomes.contact.model.Contact;

/**
 * @author cbgomes
 *
 */

@Repository
public interface ContactReporitory extends JpaRepository<Contact, Long> {

}
