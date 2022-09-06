package net.northern.verasm.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import net.northern.verasm.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SkillsDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SkillsDTO.class);
        SkillsDTO skillsDTO1 = new SkillsDTO();
        skillsDTO1.setId(1L);
        SkillsDTO skillsDTO2 = new SkillsDTO();
        assertThat(skillsDTO1).isNotEqualTo(skillsDTO2);
        skillsDTO2.setId(skillsDTO1.getId());
        assertThat(skillsDTO1).isEqualTo(skillsDTO2);
        skillsDTO2.setId(2L);
        assertThat(skillsDTO1).isNotEqualTo(skillsDTO2);
        skillsDTO1.setId(null);
        assertThat(skillsDTO1).isNotEqualTo(skillsDTO2);
    }
}
