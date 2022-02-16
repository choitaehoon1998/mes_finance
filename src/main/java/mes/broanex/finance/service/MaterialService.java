package mes.broanex.finance.service;

import mes.broanex.finance.entity.Material;
import mes.broanex.finance.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class MaterialService {
	private final MaterialRepository materialRepository;

	public MaterialService(MaterialRepository materialRepository) {
		this.materialRepository = materialRepository;
	}

	public List<Material> findAllByParam(HashMap<String, Object> hashMap) {
		List<Material> materialList = materialRepository.findByParam(hashMap);
		return materialList;
	}

	public void saveNewMaterial(Material material) {
		material.setModdate(Timestamp.valueOf(LocalDateTime.now()));
		material.setRegidate(Timestamp.valueOf(LocalDateTime.now()));
		materialRepository.save(material);
	}

	public void updateMaterial(Material material) {
		if (materialRepository.existsById(material.getIndexNo())) {
			material.setRegidate(Timestamp.valueOf(LocalDateTime.now()));
			materialRepository.save(material);
		}
	}

}
