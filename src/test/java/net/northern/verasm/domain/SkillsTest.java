package net.northern.verasm.domain;

import static org.assertj.core.api.Assertions.assertThat;

import net.northern.verasm.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SkillsTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Skills.class);
        Skills skills1 = new Skills();
        skills1.setId(1L);
        Skills skills2 = new Skills();
        skills2.setId(skills1.getId());
        assertThat(skills1).isEqualTo(skills2);
        skills2.setId(2L);
        assertThat(skills1).isNotEqualTo(skills2);
        skills1.setId(null);
        assertThat(skills1).isNotEqualTo(skills2);
    }
}
