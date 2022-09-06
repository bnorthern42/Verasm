package net.northern.verasm.service.impl;

import java.util.Optional;
import net.northern.verasm.domain.Skills;
import net.northern.verasm.repository.SkillsRepository;
import net.northern.verasm.service.SkillsService;
import net.northern.verasm.service.dto.SkillsDTO;
import net.northern.verasm.service.mapper.SkillsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Skills}.
 */
@Service
@Transactional
public class SkillsServiceImpl implements SkillsService {

    private final Logger log = LoggerFactory.getLogger(SkillsServiceImpl.class);

    private final SkillsRepository skillsRepository;

    private final SkillsMapper skillsMapper;

    public SkillsServiceImpl(SkillsRepository skillsRepository, SkillsMapper skillsMapper) {
        this.skillsRepository = skillsRepository;
        this.skillsMapper = skillsMapper;
    }

    @Override
    public SkillsDTO save(SkillsDTO skillsDTO) {
        log.debug("Request to save Skills : {}", skillsDTO);
        Skills skills = skillsMapper.toEntity(skillsDTO);
        skills = skillsRepository.save(skills);
        return skillsMapper.toDto(skills);
    }

    @Override
    public SkillsDTO update(SkillsDTO skillsDTO) {
        log.debug("Request to update Skills : {}", skillsDTO);
        Skills skills = skillsMapper.toEntity(skillsDTO);
        skills = skillsRepository.save(skills);
        return skillsMapper.toDto(skills);
    }

    @Override
    public Optional<SkillsDTO> partialUpdate(SkillsDTO skillsDTO) {
        log.debug("Request to partially update Skills : {}", skillsDTO);

        return skillsRepository
            .findById(skillsDTO.getId())
            .map(existingSkills -> {
                skillsMapper.partialUpdate(existingSkills, skillsDTO);

                return existingSkills;
            })
            .map(skillsRepository::save)
            .map(skillsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SkillsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Skills");
        return skillsRepository.findAll(pageable).map(skillsMapper::toDto);
    }

    public Page<SkillsDTO> findAllWithEagerRelationships(Pageable pageable) {
        return skillsRepository.findAllWithEagerRelationships(pageable).map(skillsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SkillsDTO> findOne(Long id) {
        log.debug("Request to get Skills : {}", id);
        return skillsRepository.findOneWithEagerRelationships(id).map(skillsMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Skills : {}", id);
        skillsRepository.deleteById(id);
    }
}
