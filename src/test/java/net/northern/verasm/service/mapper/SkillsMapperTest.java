package net.northern.verasm.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkillsMapperTest {

    private SkillsMapper skillsMapper;

    @BeforeEach
    public void setUp() {
        skillsMapper = new SkillsMapperImpl();
    }
}
