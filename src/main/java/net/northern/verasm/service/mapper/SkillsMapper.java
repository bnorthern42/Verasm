package net.northern.verasm.service.mapper;

import net.northern.verasm.domain.Skills;
import net.northern.verasm.domain.User;
import net.northern.verasm.service.dto.SkillsDTO;
import net.northern.verasm.service.dto.UserDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Skills} and its DTO {@link SkillsDTO}.
 */
@Mapper(componentModel = "spring")
public interface SkillsMapper extends EntityMapper<SkillsDTO, Skills> {
    @Mapping(target = "user", source = "user", qualifiedByName = "userLogin")
    SkillsDTO toDto(Skills s);

    @Named("userLogin")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "login")
    UserDTO toDtoUserLogin(User user);
}
