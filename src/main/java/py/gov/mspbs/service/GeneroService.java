package py.gov.mspbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.gov.mspbs.entity.Genero;
import py.gov.mspbs.repository.GeneroRepository;

@Service
@Transactional(readOnly = true)
public class GeneroService {

	@Autowired
	private GeneroRepository generoRepository;
	
	public List<Genero> findAll() {
		return generoRepository.findAll();
	}

	public Optional<Genero> findById(Long id) {
		return generoRepository.findById(id);
	}

}
