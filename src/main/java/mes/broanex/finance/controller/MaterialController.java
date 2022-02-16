package mes.broanex.finance.controller;

import mes.broanex.finance.entity.Material;
import mes.broanex.finance.service.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class MaterialController {
	private final MaterialService materialService;

	public MaterialController(MaterialService materialService) {
		this.materialService = materialService;
	}

	@GetMapping(value = "material", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Material>> getMaterial(@RequestParam(required = false) Long indexNo,
	                                                  @RequestParam(required = false) String no,
	                                                  @RequestParam(required = false) String name,
	                                                  @RequestParam(required = false) String code,
	                                                  @RequestParam(required = false) Long quantity,
	                                                  @RequestParam(required = false) String type) {
		List<Material> materialList = materialService.findAllByParam(new HashMap<String, Object>() {{
			put("indexNo", indexNo);
			put("no", no);
			put("name", name);
			put("code", code);
			put("quantity", quantity);
			put("type", type);
		}});
		return ok(materialList);
	}

	@PostMapping(value = "material", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveMaterial(@RequestPart(value = "material") Material material) {
		materialService.saveNewMaterial(material);
		return ok(null);
	}

	@PutMapping(value = "material")
	public ResponseEntity<Void> updateMaterial(@RequestBody Material material) {
		materialService.updateMaterial(material);
		return ok(null);
	}

}
