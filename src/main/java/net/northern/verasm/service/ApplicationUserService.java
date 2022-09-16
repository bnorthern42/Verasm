package net.northern.verasm.service;

import java.util.Optional;
import net.northern.verasm.service.dto.ApplicationUserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link net.northern.verasm.domain.ApplicationUser}.
 */
public interface ApplicationUserService {
    /**
     * Save a applicationUser.
     *
     * @param applicationUserDTO the entity to save.
     * @return the persisted entity.
     */
    ApplicationUserDTO save(ApplicationUserDTO applicationUserDTO);

    /**
     * Updates a applicationUser.
     *
     * @param applicationUserDTO the entity to update.
     * @return the persisted entity.
     */
    ApplicationUserDTO update(ApplicationUserDTO applicationUserDTO);

    /**
     * Partially updates a applicationUser.
     *
     * @param applicationUserDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ApplicationUserDTO> partialUpdate(ApplicationUserDTO applicationUserDTO);

    /**
     * Get all the applicationUsers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ApplicationUserDTO> findAll(Pageable pageable);

    /**
     * Get the "id" applicationUser.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ApplicationUserDTO> findOne(Long id);

    /**
     * Delete the "id" applicationUser.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    /**
     * Get the "MainUsername" applicationUser.
     *
     * @param MainUsername the MainUsername of the entity.
     * @return the entity.
     */
    Optional<ApplicationUserDTO> findByMainUsername(String MainUsername);
}
