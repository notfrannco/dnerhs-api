package py.gov.mspbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.gov.mspbs.entity.Cargo;
import py.gov.mspbs.repository.CargoRepository;

@Service
@Transactional(readOnly = true)
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	
	public List<Cargo> findAll() {
		return cargoRepository.findAll();
	}

}
