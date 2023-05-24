package co.develhope.springrepositories2.controller;

import co.develhope.springrepositories2.entities.ProgrammingLanguage;
import co.develhope.springrepositories2.repositories.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/ProgrammingLanguage")
public class ProgrammingLanguageController {
    @Autowired
    private ProgrammingLanguageRepository programmingLanguageRepository;
    @PostMapping
    public ProgrammingLanguage create(@RequestBody ProgrammingLanguage pl) {
        return programmingLanguageRepository.saveAndFlush(pl);

    }
    @GetMapping
    public List<ProgrammingLanguage> findAllpl() {
        return programmingLanguageRepository.findAll();
    }
    @GetMapping("/pages")
    public Page<ProgrammingLanguage> getPlPages(@RequestParam(required = false) Optional<Integer> page,
                                                @RequestParam(required = false) Optional<Integer> size) {
        if (page.isPresent() && size.isPresent()) {
            Pageable pageable = PageRequest.of(page.get(), size.get());
            Page<ProgrammingLanguage> pl  = programmingLanguageRepository.findAll(pageable);
            return pl;
        } else {
            Page<ProgrammingLanguage> pl1 = Page.empty();
            return pl1;
        }
    }

}
