package py.gov.mspbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.gov.mspbs.entity.Semestre;
import py.gov.mspbs.repository.SemestreRepository;

@Service
@Transactional(readOnly = true)
public class SemestreService {

	@Autowired
	private SemestreRepository semestreRepository;
	
	public List<Semestre> findAll() {
		return semestreRepository.findAll();
	}

}
