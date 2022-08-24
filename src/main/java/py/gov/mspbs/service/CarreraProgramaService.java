package py.gov.mspbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.CarreraPrograma;
import py.gov.mspbs.repository.CarreraProgramaRepository;


@Service
@Transactional(readOnly = true)
public class CarreraProgramaService {

	@Autowired
	private CarreraProgramaRepository carreraProgramaRepository;

	public Optional<CarreraPrograma> findById(@PathVariable("id") Long id) {
		return carreraProgramaRepository.findById(id);
	}
	
	@Transactional
	public CarreraPrograma save(CarreraPrograma carrera) {
		return carreraProgramaRepository.save(carrera);
	}
	
	@Transactional
	public CarreraPrograma update(CarreraPrograma carrera) {
		return carreraProgramaRepository.save(carrera);
		
	}

	@Transactional
	public void delete(Long id) {
		carreraProgramaRepository.deleteById(id);
	}

	public Page<CarreraPrograma> getPage(Pageable pageable) {
		return carreraProgramaRepository.findAll(pageable);
	}

	public List<CarreraPrograma> findAll() {
		return carreraProgramaRepository.findAll();
	}

}
