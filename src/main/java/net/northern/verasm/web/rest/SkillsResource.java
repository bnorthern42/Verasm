package net.northern.verasm.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import net.northern.verasm.repository.SkillsRepository;
import net.northern.verasm.service.SkillsService;
import net.northern.verasm.service.dto.SkillsDTO;
import net.northern.verasm.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link net.northern.verasm.domain.Skills}.
 */
@RestController
@RequestMapping("/api")
public class SkillsResource {

    private final Logger log = LoggerFactory.getLogger(SkillsResource.class);

    private static final String ENTITY_NAME = "skills";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SkillsService skillsService;

    private final SkillsRepository skillsRepository;

    public SkillsResource(SkillsService skillsService, SkillsRepository skillsRepository) {
        this.skillsService = skillsService;
        this.skillsRepository = skillsRepository;
    }

    /**
     * {@code POST  /skills} : Create a new skills.
     *
     * @param skillsDTO the skillsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new skillsDTO, or with status {@code 400 (Bad Request)} if the skills has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/skills")
    public ResponseEntity<SkillsDTO> createSkills(@Valid @RequestBody SkillsDTO skillsDTO) throws URISyntaxException {
        log.debug("REST request to save Skills : {}", skillsDTO);
        if (skillsDTO.getId() != null) {
            throw new BadRequestAlertException("A new skills cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SkillsDTO result = skillsService.save(skillsDTO);
        return ResponseEntity
            .created(new URI("/api/skills/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /skills/:id} : Updates an existing skills.
     *
     * @param id the id of the skillsDTO to save.
     * @param skillsDTO the skillsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated skillsDTO,
     * or with status {@code 400 (Bad Request)} if the skillsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the skillsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/skills/{id}")
    public ResponseEntity<SkillsDTO> updateSkills(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody SkillsDTO skillsDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Skills : {}, {}", id, skillsDTO);
        if (skillsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, skillsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!skillsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        SkillsDTO result = skillsService.update(skillsDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, skillsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /skills/:id} : Partial updates given fields of an existing skills, field will ignore if it is null
     *
     * @param id the id of the skillsDTO to save.
     * @param skillsDTO the skillsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated skillsDTO,
     * or with status {@code 400 (Bad Request)} if the skillsDTO is not valid,
     * or with status {@code 404 (Not Found)} if the skillsDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the skillsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/skills/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<SkillsDTO> partialUpdateSkills(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody SkillsDTO skillsDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Skills partially : {}, {}", id, skillsDTO);
        if (skillsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, skillsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!skillsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<SkillsDTO> result = skillsService.partialUpdate(skillsDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, skillsDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /skills} : get all the skills.
     *
     * @param pageable the pagination information.
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of skills in body.
     */
    @GetMapping("/skills")
    public ResponseEntity<List<SkillsDTO>> getAllSkills(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable,
        @RequestParam(required = false, defaultValue = "false") boolean eagerload
    ) {
        log.debug("REST request to get a page of Skills");
        Page<SkillsDTO> page;
        if (eagerload) {
            page = skillsService.findAllWithEagerRelationships(pageable);
        } else {
            page = skillsService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /skills/:id} : get the "id" skills.
     *
     * @param id the id of the skillsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the skillsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/skills/{id}")
    public ResponseEntity<SkillsDTO> getSkills(@PathVariable Long id) {
        log.debug("REST request to get Skills : {}", id);
        Optional<SkillsDTO> skillsDTO = skillsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(skillsDTO);
    }

    /**
     * {@code DELETE  /skills/:id} : delete the "id" skills.
     *
     * @param id the id of the skillsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/skills/{id}")
    public ResponseEntity<Void> deleteSkills(@PathVariable Long id) {
        log.debug("REST request to delete Skills : {}", id);
        skillsService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
