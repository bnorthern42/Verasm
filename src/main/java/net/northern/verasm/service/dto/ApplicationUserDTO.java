package net.northern.verasm.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link net.northern.verasm.domain.ApplicationUser} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ApplicationUserDTO implements Serializable {

    private Long id;

    private String mainUsername;

    private Boolean isSkillsPrivate;

    private UserDTO internalUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainUsername() {
        return mainUsername;
    }

    public void setMainUsername(String mainUsername) {
        this.mainUsername = mainUsername;
    }

    public Boolean getIsSkillsPrivate() {
        return isSkillsPrivate;
    }

    public void setIsSkillsPrivate(Boolean isSkillsPrivate) {
        this.isSkillsPrivate = isSkillsPrivate;
    }

    public UserDTO getInternalUser() {
        return internalUser;
    }

    public void setInternalUser(UserDTO internalUser) {
        this.internalUser = internalUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationUserDTO)) {
            return false;
        }

        ApplicationUserDTO applicationUserDTO = (ApplicationUserDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, applicationUserDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApplicationUserDTO{" +
            "id=" + getId() +
            ", mainUsername='" + getMainUsername() + "'" +
            ", isSkillsPrivate='" + getIsSkillsPrivate() + "'" +
            ", internalUser=" + getInternalUser() +
            "}";
    }
}
