package mes.broanex.finance.service;

import mes.broanex.finance.entity.Administration;
import mes.broanex.finance.repository.AdministrationRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdministrationService {
	private final AdministrationRepository administrationRepository;

	public AdministrationService(AdministrationRepository administrationRepository) {
		this.administrationRepository = administrationRepository;
	}

	public List<Administration> findAllByParam(HashMap<String, Object> hashMap) {
		return administrationRepository.findByParam(hashMap);
	}

	public void saveNewAdministration(Administration administration) {
		Administration parentAdministration = administration.getParent();
		if (parentAdministration != null && isExistByAdministrationCode(parentAdministration)) {
			parentAdministration = administrationRepository.findByAdministrationCode(parentAdministration.getAdministrationCode());
			administration.setParent(parentAdministration);
		} else {
			administration.setParent(null);
			administration.setAdministrationCode("");
		}
		administrationRepository.save(administration);
	}

	public void updateAdministration(Administration administration) {
		if (administrationRepository.existsById(administration.getIndexNo())) {
			administrationRepository.save(administration);
		}
	}

	private boolean isExistByAdministrationCode(Administration administration) {
		if (administration.getAdministrationCode() != null && administrationRepository.existsByAdministrationCode(administration.getAdministrationCode())) {
			return true;
		}
		return false;
	}

}
