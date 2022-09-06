package net.northern.verasm.service;

import java.util.Optional;
import net.northern.verasm.service.dto.SkillsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link net.northern.verasm.domain.Skills}.
 */
public interface SkillsService {
    /**
     * Save a skills.
     *
     * @param skillsDTO the entity to save.
     * @return the persisted entity.
     */
    SkillsDTO save(SkillsDTO skillsDTO);

    /**
     * Updates a skills.
     *
     * @param skillsDTO the entity to update.
     * @return the persisted entity.
     */
    SkillsDTO update(SkillsDTO skillsDTO);

    /**
     * Partially updates a skills.
     *
     * @param skillsDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SkillsDTO> partialUpdate(SkillsDTO skillsDTO);

    /**
     * Get all the skills.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SkillsDTO> findAll(Pageable pageable);

    /**
     * Get all the skills with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SkillsDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" skills.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SkillsDTO> findOne(Long id);

    /**
     * Delete the "id" skills.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
