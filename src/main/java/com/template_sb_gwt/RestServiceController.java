package com.template_sb_gwt;

import com.template_sb_gwt.database.HumanRepository;
import com.template_sb_gwt.database.entities.Human;
import com.template_sb_gwt.database.entities.Records;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("application/rest")
public class RestServiceController {
    private final HumanRepository repository;

    public RestServiceController(HumanRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/peoples")
    public Records getAll() {
        Records records = new Records();
        records.setRecords(repository.findAll());
        return records;
    }

    @GetMapping("/human")
    public Human getHuman(@RequestParam(value = "id", required = true) Long id) {
        return repository.getOne(id);
    }
}
