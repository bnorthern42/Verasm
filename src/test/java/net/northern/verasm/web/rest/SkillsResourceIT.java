package net.northern.verasm.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import net.northern.verasm.IntegrationTest;
import net.northern.verasm.domain.Skills;
import net.northern.verasm.repository.SkillsRepository;
import net.northern.verasm.service.SkillsService;
import net.northern.verasm.service.dto.SkillsDTO;
import net.northern.verasm.service.mapper.SkillsMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link SkillsResource} REST controller.
 */
@IntegrationTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
class SkillsResourceIT {

    private static final String DEFAULT_DUMPTIME = "AAAAAAAAAA";
    private static final String UPDATED_DUMPTIME = "BBBBBBBBBB";

    private static final String DEFAULT_PLAYERNAME = "AAAAAAAAAA";
    private static final String UPDATED_PLAYERNAME = "BBBBBBBBBB";

    private static final String DEFAULT_PREMIUM = "AAAAAAAAAA";
    private static final String UPDATED_PREMIUM = "BBBBBBBBBB";

    private static final String DEFAULT_SERVER = "AAAAAAAAAA";
    private static final String UPDATED_SERVER = "BBBBBBBBBB";

    private static final Double DEFAULT_RELIGION = 1.0D;
    private static final Double UPDATED_RELIGION = 2D;

    private static final Double DEFAULT_PRAYER = 1.0D;
    private static final Double UPDATED_PRAYER = 2D;

    private static final Double DEFAULT_CHANNELING = 1.0D;
    private static final Double UPDATED_CHANNELING = 2D;

    private static final Double DEFAULT_PREACHING = 1.0D;
    private static final Double UPDATED_PREACHING = 2D;

    private static final Double DEFAULT_EXORCISM = 1.0D;
    private static final Double UPDATED_EXORCISM = 2D;

    private static final Double DEFAULT_HAMMERS = 1.0D;
    private static final Double UPDATED_HAMMERS = 2D;

    private static final Double DEFAULT_WARHAMMER = 1.0D;
    private static final Double UPDATED_WARHAMMER = 2D;

    private static final Double DEFAULT_HEALING = 1.0D;
    private static final Double UPDATED_HEALING = 2D;

    private static final Double DEFAULT_FIRSTAID = 1.0D;
    private static final Double UPDATED_FIRSTAID = 2D;

    private static final Double DEFAULT_CLUBS = 1.0D;
    private static final Double UPDATED_CLUBS = 2D;

    private static final Double DEFAULT_HUGECLUB = 1.0D;
    private static final Double UPDATED_HUGECLUB = 2D;

    private static final Double DEFAULT_ARCHERY = 1.0D;
    private static final Double UPDATED_ARCHERY = 2D;

    private static final Double DEFAULT_SHORTBOW = 1.0D;
    private static final Double UPDATED_SHORTBOW = 2D;

    private static final Double DEFAULT_MEDIUMBOW = 1.0D;
    private static final Double UPDATED_MEDIUMBOW = 2D;

    private static final Double DEFAULT_LONGBOW = 1.0D;
    private static final Double UPDATED_LONGBOW = 2D;

    private static final Double DEFAULT_THIEVERY = 1.0D;
    private static final Double UPDATED_THIEVERY = 2D;

    private static final Double DEFAULT_STEALING = 1.0D;
    private static final Double UPDATED_STEALING = 2D;

    private static final Double DEFAULT_LOCKPICKING = 1.0D;
    private static final Double UPDATED_LOCKPICKING = 2D;

    private static final Double DEFAULT_TRAPS = 1.0D;
    private static final Double UPDATED_TRAPS = 2D;

    private static final Double DEFAULT_WARMACHINES = 1.0D;
    private static final Double UPDATED_WARMACHINES = 2D;

    private static final Double DEFAULT_CATAPULTS = 1.0D;
    private static final Double UPDATED_CATAPULTS = 2D;

    private static final Double DEFAULT_TREBUCHETS = 1.0D;
    private static final Double UPDATED_TREBUCHETS = 2D;

    private static final Double DEFAULT_BALLISTAE = 1.0D;
    private static final Double UPDATED_BALLISTAE = 2D;

    private static final Double DEFAULT_POLEARMS = 1.0D;
    private static final Double UPDATED_POLEARMS = 2D;

    private static final Double DEFAULT_STAFF = 1.0D;
    private static final Double UPDATED_STAFF = 2D;

    private static final Double DEFAULT_LONGSPEAR = 1.0D;
    private static final Double UPDATED_LONGSPEAR = 2D;

    private static final Double DEFAULT_HALBERD = 1.0D;
    private static final Double UPDATED_HALBERD = 2D;

    private static final Double DEFAULT_PROSPECTING = 1.0D;
    private static final Double UPDATED_PROSPECTING = 2D;

    private static final Double DEFAULT_COALMAKING = 1.0D;
    private static final Double UPDATED_COALMAKING = 2D;

    private static final Double DEFAULT_MILLING = 1.0D;
    private static final Double UPDATED_MILLING = 2D;

    private static final Double DEFAULT_TRACKING = 1.0D;
    private static final Double UPDATED_TRACKING = 2D;

    private static final Double DEFAULT_PAVING = 1.0D;
    private static final Double UPDATED_PAVING = 2D;

    private static final Double DEFAULT_ARCHAEOLOGY = 1.0D;
    private static final Double UPDATED_ARCHAEOLOGY = 2D;

    private static final Double DEFAULT_RESTORATION = 1.0D;
    private static final Double UPDATED_RESTORATION = 2D;

    private static final Double DEFAULT_CLIMBING = 1.0D;
    private static final Double UPDATED_CLIMBING = 2D;

    private static final Double DEFAULT_THATCHING = 1.0D;
    private static final Double UPDATED_THATCHING = 2D;

    private static final Double DEFAULT_FIREMAKING = 1.0D;
    private static final Double UPDATED_FIREMAKING = 2D;

    private static final Double DEFAULT_POTTERY = 1.0D;
    private static final Double UPDATED_POTTERY = 2D;

    private static final Double DEFAULT_MINING = 1.0D;
    private static final Double UPDATED_MINING = 2D;

    private static final Double DEFAULT_DIGGING = 1.0D;
    private static final Double UPDATED_DIGGING = 2D;

    private static final Double DEFAULT_ROPEMAKING = 1.0D;
    private static final Double UPDATED_ROPEMAKING = 2D;

    private static final Double DEFAULT_SMITHING = 1.0D;
    private static final Double UPDATED_SMITHING = 2D;

    private static final Double DEFAULT_BLACKSMITHING = 1.0D;
    private static final Double UPDATED_BLACKSMITHING = 2D;

    private static final Double DEFAULT_LOCKSMITHING = 1.0D;
    private static final Double UPDATED_LOCKSMITHING = 2D;

    private static final Double DEFAULT_JEWELRYSMITHING = 1.0D;
    private static final Double UPDATED_JEWELRYSMITHING = 2D;

    private static final Double DEFAULT_METALLURGY = 1.0D;
    private static final Double UPDATED_METALLURGY = 2D;

    private static final Double DEFAULT_WEAPONSMITHING = 1.0D;
    private static final Double UPDATED_WEAPONSMITHING = 2D;

    private static final Double DEFAULT_BLADESSMITHING = 1.0D;
    private static final Double UPDATED_BLADESSMITHING = 2D;

    private static final Double DEFAULT_WEAPONHEADSSMITHING = 1.0D;
    private static final Double UPDATED_WEAPONHEADSSMITHING = 2D;

    private static final Double DEFAULT_ARMOURSMITHING = 1.0D;
    private static final Double UPDATED_ARMOURSMITHING = 2D;

    private static final Double DEFAULT_SHIELDSMITHING = 1.0D;
    private static final Double UPDATED_SHIELDSMITHING = 2D;

    private static final Double DEFAULT_CHAINARMOURSMITHING = 1.0D;
    private static final Double UPDATED_CHAINARMOURSMITHING = 2D;

    private static final Double DEFAULT_PLATEARMOURSMITHING = 1.0D;
    private static final Double UPDATED_PLATEARMOURSMITHING = 2D;

    private static final Double DEFAULT_TAILORING = 1.0D;
    private static final Double UPDATED_TAILORING = 2D;

    private static final Double DEFAULT_CLOTHTAILORING = 1.0D;
    private static final Double UPDATED_CLOTHTAILORING = 2D;

    private static final Double DEFAULT_LEATHERWORKING = 1.0D;
    private static final Double UPDATED_LEATHERWORKING = 2D;

    private static final Double DEFAULT_MASONRY = 1.0D;
    private static final Double UPDATED_MASONRY = 2D;

    private static final Double DEFAULT_STONECUTTING = 1.0D;
    private static final Double UPDATED_STONECUTTING = 2D;

    private static final Double DEFAULT_COOKING = 1.0D;
    private static final Double UPDATED_COOKING = 2D;

    private static final Double DEFAULT_HOTFOODCOOKING = 1.0D;
    private static final Double UPDATED_HOTFOODCOOKING = 2D;

    private static final Double DEFAULT_BAKING = 1.0D;
    private static final Double UPDATED_BAKING = 2D;

    private static final Double DEFAULT_DAIRYFOODMAKING = 1.0D;
    private static final Double UPDATED_DAIRYFOODMAKING = 2D;

    private static final Double DEFAULT_BUTCHERING = 1.0D;
    private static final Double UPDATED_BUTCHERING = 2D;

    private static final Double DEFAULT_BEVERAGES = 1.0D;
    private static final Double UPDATED_BEVERAGES = 2D;

    private static final Double DEFAULT_NATURE = 1.0D;
    private static final Double UPDATED_NATURE = 2D;

    private static final Double DEFAULT_FISHING = 1.0D;
    private static final Double UPDATED_FISHING = 2D;

    private static final Double DEFAULT_GARDENING = 1.0D;
    private static final Double UPDATED_GARDENING = 2D;

    private static final Double DEFAULT_FORAGING = 1.0D;
    private static final Double UPDATED_FORAGING = 2D;

    private static final Double DEFAULT_BOTANIZING = 1.0D;
    private static final Double UPDATED_BOTANIZING = 2D;

    private static final Double DEFAULT_ANIMALTAMING = 1.0D;
    private static final Double UPDATED_ANIMALTAMING = 2D;

    private static final Double DEFAULT_FORESTRY = 1.0D;
    private static final Double UPDATED_FORESTRY = 2D;

    private static final Double DEFAULT_FARMING = 1.0D;
    private static final Double UPDATED_FARMING = 2D;

    private static final Double DEFAULT_MILKING = 1.0D;
    private static final Double UPDATED_MILKING = 2D;

    private static final Double DEFAULT_MEDITATING = 1.0D;
    private static final Double UPDATED_MEDITATING = 2D;

    private static final Double DEFAULT_ANIMALHUSBANDRY = 1.0D;
    private static final Double UPDATED_ANIMALHUSBANDRY = 2D;

    private static final Double DEFAULT_PAPYRUSMAKING = 1.0D;
    private static final Double UPDATED_PAPYRUSMAKING = 2D;

    private static final Double DEFAULT_TOYS = 1.0D;
    private static final Double UPDATED_TOYS = 2D;

    private static final Double DEFAULT_YOYO = 1.0D;
    private static final Double UPDATED_YOYO = 2D;

    private static final Double DEFAULT_PUPPETEERING = 1.0D;
    private static final Double UPDATED_PUPPETEERING = 2D;

    private static final Double DEFAULT_FIGHTING = 1.0D;
    private static final Double UPDATED_FIGHTING = 2D;

    private static final Double DEFAULT_DEFENSIVEFIGHTING = 1.0D;
    private static final Double UPDATED_DEFENSIVEFIGHTING = 2D;

    private static final Double DEFAULT_NORMALFIGHTING = 1.0D;
    private static final Double UPDATED_NORMALFIGHTING = 2D;

    private static final Double DEFAULT_WEAPONLESSFIGHTING = 1.0D;
    private static final Double UPDATED_WEAPONLESSFIGHTING = 2D;

    private static final Double DEFAULT_AGGRESSIVEFIGHTING = 1.0D;
    private static final Double UPDATED_AGGRESSIVEFIGHTING = 2D;

    private static final Double DEFAULT_SHIELDBASHING = 1.0D;
    private static final Double UPDATED_SHIELDBASHING = 2D;

    private static final Double DEFAULT_TAUNTING = 1.0D;
    private static final Double UPDATED_TAUNTING = 2D;

    private static final Double DEFAULT_MISCELLANEOUSITEMS = 1.0D;
    private static final Double UPDATED_MISCELLANEOUSITEMS = 2D;

    private static final Double DEFAULT_SHOVEL = 1.0D;
    private static final Double UPDATED_SHOVEL = 2D;

    private static final Double DEFAULT_RAKE = 1.0D;
    private static final Double UPDATED_RAKE = 2D;

    private static final Double DEFAULT_SAW = 1.0D;
    private static final Double UPDATED_SAW = 2D;

    private static final Double DEFAULT_PICKAXE = 1.0D;
    private static final Double UPDATED_PICKAXE = 2D;

    private static final Double DEFAULT_REPAIRING = 1.0D;
    private static final Double UPDATED_REPAIRING = 2D;

    private static final Double DEFAULT_SICKLE = 1.0D;
    private static final Double UPDATED_SICKLE = 2D;

    private static final Double DEFAULT_SCYTHE = 1.0D;
    private static final Double UPDATED_SCYTHE = 2D;

    private static final Double DEFAULT_HAMMER = 1.0D;
    private static final Double UPDATED_HAMMER = 2D;

    private static final Double DEFAULT_STONECHISEL = 1.0D;
    private static final Double UPDATED_STONECHISEL = 2D;

    private static final Double DEFAULT_ALCHEMY = 1.0D;
    private static final Double UPDATED_ALCHEMY = 2D;

    private static final Double DEFAULT_NATURALSUBSTANCES = 1.0D;
    private static final Double UPDATED_NATURALSUBSTANCES = 2D;

    private static final Double DEFAULT_SHIELDS = 1.0D;
    private static final Double UPDATED_SHIELDS = 2D;

    private static final Double DEFAULT_MEDIUMMETALSHIELD = 1.0D;
    private static final Double UPDATED_MEDIUMMETALSHIELD = 2D;

    private static final Double DEFAULT_SMALLWOODENSHIELD = 1.0D;
    private static final Double UPDATED_SMALLWOODENSHIELD = 2D;

    private static final Double DEFAULT_SMALLMETALSHIELD = 1.0D;
    private static final Double UPDATED_SMALLMETALSHIELD = 2D;

    private static final Double DEFAULT_LARGEMETALSHIELD = 1.0D;
    private static final Double UPDATED_LARGEMETALSHIELD = 2D;

    private static final Double DEFAULT_MEDIUMWOODENSHIELD = 1.0D;
    private static final Double UPDATED_MEDIUMWOODENSHIELD = 2D;

    private static final Double DEFAULT_LARGEWOODENSHIELD = 1.0D;
    private static final Double UPDATED_LARGEWOODENSHIELD = 2D;

    private static final Double DEFAULT_AXES = 1.0D;
    private static final Double UPDATED_AXES = 2D;

    private static final Double DEFAULT_HATCHET = 1.0D;
    private static final Double UPDATED_HATCHET = 2D;

    private static final Double DEFAULT_SMALLAXE = 1.0D;
    private static final Double UPDATED_SMALLAXE = 2D;

    private static final Double DEFAULT_LARGEAXE = 1.0D;
    private static final Double UPDATED_LARGEAXE = 2D;

    private static final Double DEFAULT_HUGEAXE = 1.0D;
    private static final Double UPDATED_HUGEAXE = 2D;

    private static final Double DEFAULT_SWORDS = 1.0D;
    private static final Double UPDATED_SWORDS = 2D;

    private static final Double DEFAULT_LONGSWORD = 1.0D;
    private static final Double UPDATED_LONGSWORD = 2D;

    private static final Double DEFAULT_SHORTSWORD = 1.0D;
    private static final Double UPDATED_SHORTSWORD = 2D;

    private static final Double DEFAULT_TWOHANDEDSWORD = 1.0D;
    private static final Double UPDATED_TWOHANDEDSWORD = 2D;

    private static final Double DEFAULT_KNIVES = 1.0D;
    private static final Double UPDATED_KNIVES = 2D;

    private static final Double DEFAULT_CARVINGKNIFE = 1.0D;
    private static final Double UPDATED_CARVINGKNIFE = 2D;

    private static final Double DEFAULT_BUTCHERINGKNIFE = 1.0D;
    private static final Double UPDATED_BUTCHERINGKNIFE = 2D;

    private static final Double DEFAULT_WOODCUTTING = 1.0D;
    private static final Double UPDATED_WOODCUTTING = 2D;

    private static final Double DEFAULT_MAULS = 1.0D;
    private static final Double UPDATED_MAULS = 2D;

    private static final Double DEFAULT_MEDIUMMAUL = 1.0D;
    private static final Double UPDATED_MEDIUMMAUL = 2D;

    private static final Double DEFAULT_SMALLMAUL = 1.0D;
    private static final Double UPDATED_SMALLMAUL = 2D;

    private static final Double DEFAULT_LARGEMAUL = 1.0D;
    private static final Double UPDATED_LARGEMAUL = 2D;

    private static final Double DEFAULT_CARPENTRY = 1.0D;
    private static final Double UPDATED_CARPENTRY = 2D;

    private static final Double DEFAULT_BOWYERY = 1.0D;
    private static final Double UPDATED_BOWYERY = 2D;

    private static final Double DEFAULT_FLETCHING = 1.0D;
    private static final Double UPDATED_FLETCHING = 2D;

    private static final Double DEFAULT_FINECARPENTRY = 1.0D;
    private static final Double UPDATED_FINECARPENTRY = 2D;

    private static final Double DEFAULT_TOYMAKING = 1.0D;
    private static final Double UPDATED_TOYMAKING = 2D;

    private static final Double DEFAULT_SHIPBUILDING = 1.0D;
    private static final Double UPDATED_SHIPBUILDING = 2D;

    private static final Double DEFAULT_MIND = 1.0D;
    private static final Double UPDATED_MIND = 2D;

    private static final Double DEFAULT_MINDLOGIC = 1.0D;
    private static final Double UPDATED_MINDLOGIC = 2D;

    private static final Double DEFAULT_MINDSPEED = 1.0D;
    private static final Double UPDATED_MINDSPEED = 2D;

    private static final Double DEFAULT_SOUL = 1.0D;
    private static final Double UPDATED_SOUL = 2D;

    private static final Double DEFAULT_SOULDEPTH = 1.0D;
    private static final Double UPDATED_SOULDEPTH = 2D;

    private static final Double DEFAULT_SOULSTRENGTH = 1.0D;
    private static final Double UPDATED_SOULSTRENGTH = 2D;

    private static final Double DEFAULT_BODY = 1.0D;
    private static final Double UPDATED_BODY = 2D;

    private static final Double DEFAULT_BODYSTRENGTH = 1.0D;
    private static final Double UPDATED_BODYSTRENGTH = 2D;

    private static final Double DEFAULT_BODYSTAMINA = 1.0D;
    private static final Double UPDATED_BODYSTAMINA = 2D;

    private static final Double DEFAULT_BODYCONTROL = 1.0D;
    private static final Double UPDATED_BODYCONTROL = 2D;

    private static final Double DEFAULT_FAITH = 1.0D;
    private static final Double UPDATED_FAITH = 2D;

    private static final Double DEFAULT_FAVOR = 1.0D;
    private static final Double UPDATED_FAVOR = 2D;

    private static final Double DEFAULT_ALIGNMENT = 1.0D;
    private static final Double UPDATED_ALIGNMENT = 2D;

    private static final String ENTITY_API_URL = "/api/skills";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SkillsRepository skillsRepository;

    @Mock
    private SkillsRepository skillsRepositoryMock;

    @Autowired
    private SkillsMapper skillsMapper;

    @Mock
    private SkillsService skillsServiceMock;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSkillsMockMvc;

    private Skills skills;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Skills createEntity(EntityManager em) {
        Skills skills = new Skills()
            .dumptime(DEFAULT_DUMPTIME)
            .playername(DEFAULT_PLAYERNAME)
            .premium(DEFAULT_PREMIUM)
            .server(DEFAULT_SERVER)
            .religion(DEFAULT_RELIGION)
            .prayer(DEFAULT_PRAYER)
            .channeling(DEFAULT_CHANNELING)
            .preaching(DEFAULT_PREACHING)
            .exorcism(DEFAULT_EXORCISM)
            .hammers(DEFAULT_HAMMERS)
            .warhammer(DEFAULT_WARHAMMER)
            .healing(DEFAULT_HEALING)
            .firstaid(DEFAULT_FIRSTAID)
            .clubs(DEFAULT_CLUBS)
            .hugeclub(DEFAULT_HUGECLUB)
            .archery(DEFAULT_ARCHERY)
            .shortbow(DEFAULT_SHORTBOW)
            .mediumbow(DEFAULT_MEDIUMBOW)
            .longbow(DEFAULT_LONGBOW)
            .thievery(DEFAULT_THIEVERY)
            .stealing(DEFAULT_STEALING)
            .lockpicking(DEFAULT_LOCKPICKING)
            .traps(DEFAULT_TRAPS)
            .warmachines(DEFAULT_WARMACHINES)
            .catapults(DEFAULT_CATAPULTS)
            .trebuchets(DEFAULT_TREBUCHETS)
            .ballistae(DEFAULT_BALLISTAE)
            .polearms(DEFAULT_POLEARMS)
            .staff(DEFAULT_STAFF)
            .longspear(DEFAULT_LONGSPEAR)
            .halberd(DEFAULT_HALBERD)
            .prospecting(DEFAULT_PROSPECTING)
            .coalmaking(DEFAULT_COALMAKING)
            .milling(DEFAULT_MILLING)
            .tracking(DEFAULT_TRACKING)
            .paving(DEFAULT_PAVING)
            .archaeology(DEFAULT_ARCHAEOLOGY)
            .restoration(DEFAULT_RESTORATION)
            .climbing(DEFAULT_CLIMBING)
            .thatching(DEFAULT_THATCHING)
            .firemaking(DEFAULT_FIREMAKING)
            .pottery(DEFAULT_POTTERY)
            .mining(DEFAULT_MINING)
            .digging(DEFAULT_DIGGING)
            .ropemaking(DEFAULT_ROPEMAKING)
            .smithing(DEFAULT_SMITHING)
            .blacksmithing(DEFAULT_BLACKSMITHING)
            .locksmithing(DEFAULT_LOCKSMITHING)
            .jewelrysmithing(DEFAULT_JEWELRYSMITHING)
            .metallurgy(DEFAULT_METALLURGY)
            .weaponsmithing(DEFAULT_WEAPONSMITHING)
            .bladessmithing(DEFAULT_BLADESSMITHING)
            .weaponheadssmithing(DEFAULT_WEAPONHEADSSMITHING)
            .armoursmithing(DEFAULT_ARMOURSMITHING)
            .shieldsmithing(DEFAULT_SHIELDSMITHING)
            .chainarmoursmithing(DEFAULT_CHAINARMOURSMITHING)
            .platearmoursmithing(DEFAULT_PLATEARMOURSMITHING)
            .tailoring(DEFAULT_TAILORING)
            .clothtailoring(DEFAULT_CLOTHTAILORING)
            .leatherworking(DEFAULT_LEATHERWORKING)
            .masonry(DEFAULT_MASONRY)
            .stonecutting(DEFAULT_STONECUTTING)
            .cooking(DEFAULT_COOKING)
            .hotfoodcooking(DEFAULT_HOTFOODCOOKING)
            .baking(DEFAULT_BAKING)
            .dairyfoodmaking(DEFAULT_DAIRYFOODMAKING)
            .butchering(DEFAULT_BUTCHERING)
            .beverages(DEFAULT_BEVERAGES)
            .nature(DEFAULT_NATURE)
            .fishing(DEFAULT_FISHING)
            .gardening(DEFAULT_GARDENING)
            .foraging(DEFAULT_FORAGING)
            .botanizing(DEFAULT_BOTANIZING)
            .animaltaming(DEFAULT_ANIMALTAMING)
            .forestry(DEFAULT_FORESTRY)
            .farming(DEFAULT_FARMING)
            .milking(DEFAULT_MILKING)
            .meditating(DEFAULT_MEDITATING)
            .animalhusbandry(DEFAULT_ANIMALHUSBANDRY)
            .papyrusmaking(DEFAULT_PAPYRUSMAKING)
            .toys(DEFAULT_TOYS)
            .yoyo(DEFAULT_YOYO)
            .puppeteering(DEFAULT_PUPPETEERING)
            .fighting(DEFAULT_FIGHTING)
            .defensivefighting(DEFAULT_DEFENSIVEFIGHTING)
            .normalfighting(DEFAULT_NORMALFIGHTING)
            .weaponlessfighting(DEFAULT_WEAPONLESSFIGHTING)
            .aggressivefighting(DEFAULT_AGGRESSIVEFIGHTING)
            .shieldbashing(DEFAULT_SHIELDBASHING)
            .taunting(DEFAULT_TAUNTING)
            .miscellaneousitems(DEFAULT_MISCELLANEOUSITEMS)
            .shovel(DEFAULT_SHOVEL)
            .rake(DEFAULT_RAKE)
            .saw(DEFAULT_SAW)
            .pickaxe(DEFAULT_PICKAXE)
            .repairing(DEFAULT_REPAIRING)
            .sickle(DEFAULT_SICKLE)
            .scythe(DEFAULT_SCYTHE)
            .hammer(DEFAULT_HAMMER)
            .stonechisel(DEFAULT_STONECHISEL)
            .alchemy(DEFAULT_ALCHEMY)
            .naturalsubstances(DEFAULT_NATURALSUBSTANCES)
            .shields(DEFAULT_SHIELDS)
            .mediummetalshield(DEFAULT_MEDIUMMETALSHIELD)
            .smallwoodenshield(DEFAULT_SMALLWOODENSHIELD)
            .smallmetalshield(DEFAULT_SMALLMETALSHIELD)
            .largemetalshield(DEFAULT_LARGEMETALSHIELD)
            .mediumwoodenshield(DEFAULT_MEDIUMWOODENSHIELD)
            .largewoodenshield(DEFAULT_LARGEWOODENSHIELD)
            .axes(DEFAULT_AXES)
            .hatchet(DEFAULT_HATCHET)
            .smallaxe(DEFAULT_SMALLAXE)
            .largeaxe(DEFAULT_LARGEAXE)
            .hugeaxe(DEFAULT_HUGEAXE)
            .swords(DEFAULT_SWORDS)
            .longsword(DEFAULT_LONGSWORD)
            .shortsword(DEFAULT_SHORTSWORD)
            .twohandedsword(DEFAULT_TWOHANDEDSWORD)
            .knives(DEFAULT_KNIVES)
            .carvingknife(DEFAULT_CARVINGKNIFE)
            .butcheringknife(DEFAULT_BUTCHERINGKNIFE)
            .woodcutting(DEFAULT_WOODCUTTING)
            .mauls(DEFAULT_MAULS)
            .mediummaul(DEFAULT_MEDIUMMAUL)
            .smallmaul(DEFAULT_SMALLMAUL)
            .largemaul(DEFAULT_LARGEMAUL)
            .carpentry(DEFAULT_CARPENTRY)
            .bowyery(DEFAULT_BOWYERY)
            .fletching(DEFAULT_FLETCHING)
            .finecarpentry(DEFAULT_FINECARPENTRY)
            .toymaking(DEFAULT_TOYMAKING)
            .shipbuilding(DEFAULT_SHIPBUILDING)
            .mind(DEFAULT_MIND)
            .mindlogic(DEFAULT_MINDLOGIC)
            .mindspeed(DEFAULT_MINDSPEED)
            .soul(DEFAULT_SOUL)
            .souldepth(DEFAULT_SOULDEPTH)
            .soulstrength(DEFAULT_SOULSTRENGTH)
            .body(DEFAULT_BODY)
            .bodystrength(DEFAULT_BODYSTRENGTH)
            .bodystamina(DEFAULT_BODYSTAMINA)
            .bodycontrol(DEFAULT_BODYCONTROL)
            .faith(DEFAULT_FAITH)
            .favor(DEFAULT_FAVOR)
            .alignment(DEFAULT_ALIGNMENT);
        return skills;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Skills createUpdatedEntity(EntityManager em) {
        Skills skills = new Skills()
            .dumptime(UPDATED_DUMPTIME)
            .playername(UPDATED_PLAYERNAME)
            .premium(UPDATED_PREMIUM)
            .server(UPDATED_SERVER)
            .religion(UPDATED_RELIGION)
            .prayer(UPDATED_PRAYER)
            .channeling(UPDATED_CHANNELING)
            .preaching(UPDATED_PREACHING)
            .exorcism(UPDATED_EXORCISM)
            .hammers(UPDATED_HAMMERS)
            .warhammer(UPDATED_WARHAMMER)
            .healing(UPDATED_HEALING)
            .firstaid(UPDATED_FIRSTAID)
            .clubs(UPDATED_CLUBS)
            .hugeclub(UPDATED_HUGECLUB)
            .archery(UPDATED_ARCHERY)
            .shortbow(UPDATED_SHORTBOW)
            .mediumbow(UPDATED_MEDIUMBOW)
            .longbow(UPDATED_LONGBOW)
            .thievery(UPDATED_THIEVERY)
            .stealing(UPDATED_STEALING)
            .lockpicking(UPDATED_LOCKPICKING)
            .traps(UPDATED_TRAPS)
            .warmachines(UPDATED_WARMACHINES)
            .catapults(UPDATED_CATAPULTS)
            .trebuchets(UPDATED_TREBUCHETS)
            .ballistae(UPDATED_BALLISTAE)
            .polearms(UPDATED_POLEARMS)
            .staff(UPDATED_STAFF)
            .longspear(UPDATED_LONGSPEAR)
            .halberd(UPDATED_HALBERD)
            .prospecting(UPDATED_PROSPECTING)
            .coalmaking(UPDATED_COALMAKING)
            .milling(UPDATED_MILLING)
            .tracking(UPDATED_TRACKING)
            .paving(UPDATED_PAVING)
            .archaeology(UPDATED_ARCHAEOLOGY)
            .restoration(UPDATED_RESTORATION)
            .climbing(UPDATED_CLIMBING)
            .thatching(UPDATED_THATCHING)
            .firemaking(UPDATED_FIREMAKING)
            .pottery(UPDATED_POTTERY)
            .mining(UPDATED_MINING)
            .digging(UPDATED_DIGGING)
            .ropemaking(UPDATED_ROPEMAKING)
            .smithing(UPDATED_SMITHING)
            .blacksmithing(UPDATED_BLACKSMITHING)
            .locksmithing(UPDATED_LOCKSMITHING)
            .jewelrysmithing(UPDATED_JEWELRYSMITHING)
            .metallurgy(UPDATED_METALLURGY)
            .weaponsmithing(UPDATED_WEAPONSMITHING)
            .bladessmithing(UPDATED_BLADESSMITHING)
            .weaponheadssmithing(UPDATED_WEAPONHEADSSMITHING)
            .armoursmithing(UPDATED_ARMOURSMITHING)
            .shieldsmithing(UPDATED_SHIELDSMITHING)
            .chainarmoursmithing(UPDATED_CHAINARMOURSMITHING)
            .platearmoursmithing(UPDATED_PLATEARMOURSMITHING)
            .tailoring(UPDATED_TAILORING)
            .clothtailoring(UPDATED_CLOTHTAILORING)
            .leatherworking(UPDATED_LEATHERWORKING)
            .masonry(UPDATED_MASONRY)
            .stonecutting(UPDATED_STONECUTTING)
            .cooking(UPDATED_COOKING)
            .hotfoodcooking(UPDATED_HOTFOODCOOKING)
            .baking(UPDATED_BAKING)
            .dairyfoodmaking(UPDATED_DAIRYFOODMAKING)
            .butchering(UPDATED_BUTCHERING)
            .beverages(UPDATED_BEVERAGES)
            .nature(UPDATED_NATURE)
            .fishing(UPDATED_FISHING)
            .gardening(UPDATED_GARDENING)
            .foraging(UPDATED_FORAGING)
            .botanizing(UPDATED_BOTANIZING)
            .animaltaming(UPDATED_ANIMALTAMING)
            .forestry(UPDATED_FORESTRY)
            .farming(UPDATED_FARMING)
            .milking(UPDATED_MILKING)
            .meditating(UPDATED_MEDITATING)
            .animalhusbandry(UPDATED_ANIMALHUSBANDRY)
            .papyrusmaking(UPDATED_PAPYRUSMAKING)
            .toys(UPDATED_TOYS)
            .yoyo(UPDATED_YOYO)
            .puppeteering(UPDATED_PUPPETEERING)
            .fighting(UPDATED_FIGHTING)
            .defensivefighting(UPDATED_DEFENSIVEFIGHTING)
            .normalfighting(UPDATED_NORMALFIGHTING)
            .weaponlessfighting(UPDATED_WEAPONLESSFIGHTING)
            .aggressivefighting(UPDATED_AGGRESSIVEFIGHTING)
            .shieldbashing(UPDATED_SHIELDBASHING)
            .taunting(UPDATED_TAUNTING)
            .miscellaneousitems(UPDATED_MISCELLANEOUSITEMS)
            .shovel(UPDATED_SHOVEL)
            .rake(UPDATED_RAKE)
            .saw(UPDATED_SAW)
            .pickaxe(UPDATED_PICKAXE)
            .repairing(UPDATED_REPAIRING)
            .sickle(UPDATED_SICKLE)
            .scythe(UPDATED_SCYTHE)
            .hammer(UPDATED_HAMMER)
            .stonechisel(UPDATED_STONECHISEL)
            .alchemy(UPDATED_ALCHEMY)
            .naturalsubstances(UPDATED_NATURALSUBSTANCES)
            .shields(UPDATED_SHIELDS)
            .mediummetalshield(UPDATED_MEDIUMMETALSHIELD)
            .smallwoodenshield(UPDATED_SMALLWOODENSHIELD)
            .smallmetalshield(UPDATED_SMALLMETALSHIELD)
            .largemetalshield(UPDATED_LARGEMETALSHIELD)
            .mediumwoodenshield(UPDATED_MEDIUMWOODENSHIELD)
            .largewoodenshield(UPDATED_LARGEWOODENSHIELD)
            .axes(UPDATED_AXES)
            .hatchet(UPDATED_HATCHET)
            .smallaxe(UPDATED_SMALLAXE)
            .largeaxe(UPDATED_LARGEAXE)
            .hugeaxe(UPDATED_HUGEAXE)
            .swords(UPDATED_SWORDS)
            .longsword(UPDATED_LONGSWORD)
            .shortsword(UPDATED_SHORTSWORD)
            .twohandedsword(UPDATED_TWOHANDEDSWORD)
            .knives(UPDATED_KNIVES)
            .carvingknife(UPDATED_CARVINGKNIFE)
            .butcheringknife(UPDATED_BUTCHERINGKNIFE)
            .woodcutting(UPDATED_WOODCUTTING)
            .mauls(UPDATED_MAULS)
            .mediummaul(UPDATED_MEDIUMMAUL)
            .smallmaul(UPDATED_SMALLMAUL)
            .largemaul(UPDATED_LARGEMAUL)
            .carpentry(UPDATED_CARPENTRY)
            .bowyery(UPDATED_BOWYERY)
            .fletching(UPDATED_FLETCHING)
            .finecarpentry(UPDATED_FINECARPENTRY)
            .toymaking(UPDATED_TOYMAKING)
            .shipbuilding(UPDATED_SHIPBUILDING)
            .mind(UPDATED_MIND)
            .mindlogic(UPDATED_MINDLOGIC)
            .mindspeed(UPDATED_MINDSPEED)
            .soul(UPDATED_SOUL)
            .souldepth(UPDATED_SOULDEPTH)
            .soulstrength(UPDATED_SOULSTRENGTH)
            .body(UPDATED_BODY)
            .bodystrength(UPDATED_BODYSTRENGTH)
            .bodystamina(UPDATED_BODYSTAMINA)
            .bodycontrol(UPDATED_BODYCONTROL)
            .faith(UPDATED_FAITH)
            .favor(UPDATED_FAVOR)
            .alignment(UPDATED_ALIGNMENT);
        return skills;
    }

    @BeforeEach
    public void initTest() {
        skills = createEntity(em);
    }

    @Test
    @Transactional
    void createSkills() throws Exception {
        int databaseSizeBeforeCreate = skillsRepository.findAll().size();
        // Create the Skills
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);
        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isCreated());

        // Validate the Skills in the database
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeCreate + 1);
        Skills testSkills = skillsList.get(skillsList.size() - 1);
        assertThat(testSkills.getDumptime()).isEqualTo(DEFAULT_DUMPTIME);
        assertThat(testSkills.getPlayername()).isEqualTo(DEFAULT_PLAYERNAME);
        assertThat(testSkills.getPremium()).isEqualTo(DEFAULT_PREMIUM);
        assertThat(testSkills.getServer()).isEqualTo(DEFAULT_SERVER);
        assertThat(testSkills.getReligion()).isEqualTo(DEFAULT_RELIGION);
        assertThat(testSkills.getPrayer()).isEqualTo(DEFAULT_PRAYER);
        assertThat(testSkills.getChanneling()).isEqualTo(DEFAULT_CHANNELING);
        assertThat(testSkills.getPreaching()).isEqualTo(DEFAULT_PREACHING);
        assertThat(testSkills.getExorcism()).isEqualTo(DEFAULT_EXORCISM);
        assertThat(testSkills.getHammers()).isEqualTo(DEFAULT_HAMMERS);
        assertThat(testSkills.getWarhammer()).isEqualTo(DEFAULT_WARHAMMER);
        assertThat(testSkills.getHealing()).isEqualTo(DEFAULT_HEALING);
        assertThat(testSkills.getFirstaid()).isEqualTo(DEFAULT_FIRSTAID);
        assertThat(testSkills.getClubs()).isEqualTo(DEFAULT_CLUBS);
        assertThat(testSkills.getHugeclub()).isEqualTo(DEFAULT_HUGECLUB);
        assertThat(testSkills.getArchery()).isEqualTo(DEFAULT_ARCHERY);
        assertThat(testSkills.getShortbow()).isEqualTo(DEFAULT_SHORTBOW);
        assertThat(testSkills.getMediumbow()).isEqualTo(DEFAULT_MEDIUMBOW);
        assertThat(testSkills.getLongbow()).isEqualTo(DEFAULT_LONGBOW);
        assertThat(testSkills.getThievery()).isEqualTo(DEFAULT_THIEVERY);
        assertThat(testSkills.getStealing()).isEqualTo(DEFAULT_STEALING);
        assertThat(testSkills.getLockpicking()).isEqualTo(DEFAULT_LOCKPICKING);
        assertThat(testSkills.getTraps()).isEqualTo(DEFAULT_TRAPS);
        assertThat(testSkills.getWarmachines()).isEqualTo(DEFAULT_WARMACHINES);
        assertThat(testSkills.getCatapults()).isEqualTo(DEFAULT_CATAPULTS);
        assertThat(testSkills.getTrebuchets()).isEqualTo(DEFAULT_TREBUCHETS);
        assertThat(testSkills.getBallistae()).isEqualTo(DEFAULT_BALLISTAE);
        assertThat(testSkills.getPolearms()).isEqualTo(DEFAULT_POLEARMS);
        assertThat(testSkills.getStaff()).isEqualTo(DEFAULT_STAFF);
        assertThat(testSkills.getLongspear()).isEqualTo(DEFAULT_LONGSPEAR);
        assertThat(testSkills.getHalberd()).isEqualTo(DEFAULT_HALBERD);
        assertThat(testSkills.getProspecting()).isEqualTo(DEFAULT_PROSPECTING);
        assertThat(testSkills.getCoalmaking()).isEqualTo(DEFAULT_COALMAKING);
        assertThat(testSkills.getMilling()).isEqualTo(DEFAULT_MILLING);
        assertThat(testSkills.getTracking()).isEqualTo(DEFAULT_TRACKING);
        assertThat(testSkills.getPaving()).isEqualTo(DEFAULT_PAVING);
        assertThat(testSkills.getArchaeology()).isEqualTo(DEFAULT_ARCHAEOLOGY);
        assertThat(testSkills.getRestoration()).isEqualTo(DEFAULT_RESTORATION);
        assertThat(testSkills.getClimbing()).isEqualTo(DEFAULT_CLIMBING);
        assertThat(testSkills.getThatching()).isEqualTo(DEFAULT_THATCHING);
        assertThat(testSkills.getFiremaking()).isEqualTo(DEFAULT_FIREMAKING);
        assertThat(testSkills.getPottery()).isEqualTo(DEFAULT_POTTERY);
        assertThat(testSkills.getMining()).isEqualTo(DEFAULT_MINING);
        assertThat(testSkills.getDigging()).isEqualTo(DEFAULT_DIGGING);
        assertThat(testSkills.getRopemaking()).isEqualTo(DEFAULT_ROPEMAKING);
        assertThat(testSkills.getSmithing()).isEqualTo(DEFAULT_SMITHING);
        assertThat(testSkills.getBlacksmithing()).isEqualTo(DEFAULT_BLACKSMITHING);
        assertThat(testSkills.getLocksmithing()).isEqualTo(DEFAULT_LOCKSMITHING);
        assertThat(testSkills.getJewelrysmithing()).isEqualTo(DEFAULT_JEWELRYSMITHING);
        assertThat(testSkills.getMetallurgy()).isEqualTo(DEFAULT_METALLURGY);
        assertThat(testSkills.getWeaponsmithing()).isEqualTo(DEFAULT_WEAPONSMITHING);
        assertThat(testSkills.getBladessmithing()).isEqualTo(DEFAULT_BLADESSMITHING);
        assertThat(testSkills.getWeaponheadssmithing()).isEqualTo(DEFAULT_WEAPONHEADSSMITHING);
        assertThat(testSkills.getArmoursmithing()).isEqualTo(DEFAULT_ARMOURSMITHING);
        assertThat(testSkills.getShieldsmithing()).isEqualTo(DEFAULT_SHIELDSMITHING);
        assertThat(testSkills.getChainarmoursmithing()).isEqualTo(DEFAULT_CHAINARMOURSMITHING);
        assertThat(testSkills.getPlatearmoursmithing()).isEqualTo(DEFAULT_PLATEARMOURSMITHING);
        assertThat(testSkills.getTailoring()).isEqualTo(DEFAULT_TAILORING);
        assertThat(testSkills.getClothtailoring()).isEqualTo(DEFAULT_CLOTHTAILORING);
        assertThat(testSkills.getLeatherworking()).isEqualTo(DEFAULT_LEATHERWORKING);
        assertThat(testSkills.getMasonry()).isEqualTo(DEFAULT_MASONRY);
        assertThat(testSkills.getStonecutting()).isEqualTo(DEFAULT_STONECUTTING);
        assertThat(testSkills.getCooking()).isEqualTo(DEFAULT_COOKING);
        assertThat(testSkills.getHotfoodcooking()).isEqualTo(DEFAULT_HOTFOODCOOKING);
        assertThat(testSkills.getBaking()).isEqualTo(DEFAULT_BAKING);
        assertThat(testSkills.getDairyfoodmaking()).isEqualTo(DEFAULT_DAIRYFOODMAKING);
        assertThat(testSkills.getButchering()).isEqualTo(DEFAULT_BUTCHERING);
        assertThat(testSkills.getBeverages()).isEqualTo(DEFAULT_BEVERAGES);
        assertThat(testSkills.getNature()).isEqualTo(DEFAULT_NATURE);
        assertThat(testSkills.getFishing()).isEqualTo(DEFAULT_FISHING);
        assertThat(testSkills.getGardening()).isEqualTo(DEFAULT_GARDENING);
        assertThat(testSkills.getForaging()).isEqualTo(DEFAULT_FORAGING);
        assertThat(testSkills.getBotanizing()).isEqualTo(DEFAULT_BOTANIZING);
        assertThat(testSkills.getAnimaltaming()).isEqualTo(DEFAULT_ANIMALTAMING);
        assertThat(testSkills.getForestry()).isEqualTo(DEFAULT_FORESTRY);
        assertThat(testSkills.getFarming()).isEqualTo(DEFAULT_FARMING);
        assertThat(testSkills.getMilking()).isEqualTo(DEFAULT_MILKING);
        assertThat(testSkills.getMeditating()).isEqualTo(DEFAULT_MEDITATING);
        assertThat(testSkills.getAnimalhusbandry()).isEqualTo(DEFAULT_ANIMALHUSBANDRY);
        assertThat(testSkills.getPapyrusmaking()).isEqualTo(DEFAULT_PAPYRUSMAKING);
        assertThat(testSkills.getToys()).isEqualTo(DEFAULT_TOYS);
        assertThat(testSkills.getYoyo()).isEqualTo(DEFAULT_YOYO);
        assertThat(testSkills.getPuppeteering()).isEqualTo(DEFAULT_PUPPETEERING);
        assertThat(testSkills.getFighting()).isEqualTo(DEFAULT_FIGHTING);
        assertThat(testSkills.getDefensivefighting()).isEqualTo(DEFAULT_DEFENSIVEFIGHTING);
        assertThat(testSkills.getNormalfighting()).isEqualTo(DEFAULT_NORMALFIGHTING);
        assertThat(testSkills.getWeaponlessfighting()).isEqualTo(DEFAULT_WEAPONLESSFIGHTING);
        assertThat(testSkills.getAggressivefighting()).isEqualTo(DEFAULT_AGGRESSIVEFIGHTING);
        assertThat(testSkills.getShieldbashing()).isEqualTo(DEFAULT_SHIELDBASHING);
        assertThat(testSkills.getTaunting()).isEqualTo(DEFAULT_TAUNTING);
        assertThat(testSkills.getMiscellaneousitems()).isEqualTo(DEFAULT_MISCELLANEOUSITEMS);
        assertThat(testSkills.getShovel()).isEqualTo(DEFAULT_SHOVEL);
        assertThat(testSkills.getRake()).isEqualTo(DEFAULT_RAKE);
        assertThat(testSkills.getSaw()).isEqualTo(DEFAULT_SAW);
        assertThat(testSkills.getPickaxe()).isEqualTo(DEFAULT_PICKAXE);
        assertThat(testSkills.getRepairing()).isEqualTo(DEFAULT_REPAIRING);
        assertThat(testSkills.getSickle()).isEqualTo(DEFAULT_SICKLE);
        assertThat(testSkills.getScythe()).isEqualTo(DEFAULT_SCYTHE);
        assertThat(testSkills.getHammer()).isEqualTo(DEFAULT_HAMMER);
        assertThat(testSkills.getStonechisel()).isEqualTo(DEFAULT_STONECHISEL);
        assertThat(testSkills.getAlchemy()).isEqualTo(DEFAULT_ALCHEMY);
        assertThat(testSkills.getNaturalsubstances()).isEqualTo(DEFAULT_NATURALSUBSTANCES);
        assertThat(testSkills.getShields()).isEqualTo(DEFAULT_SHIELDS);
        assertThat(testSkills.getMediummetalshield()).isEqualTo(DEFAULT_MEDIUMMETALSHIELD);
        assertThat(testSkills.getSmallwoodenshield()).isEqualTo(DEFAULT_SMALLWOODENSHIELD);
        assertThat(testSkills.getSmallmetalshield()).isEqualTo(DEFAULT_SMALLMETALSHIELD);
        assertThat(testSkills.getLargemetalshield()).isEqualTo(DEFAULT_LARGEMETALSHIELD);
        assertThat(testSkills.getMediumwoodenshield()).isEqualTo(DEFAULT_MEDIUMWOODENSHIELD);
        assertThat(testSkills.getLargewoodenshield()).isEqualTo(DEFAULT_LARGEWOODENSHIELD);
        assertThat(testSkills.getAxes()).isEqualTo(DEFAULT_AXES);
        assertThat(testSkills.getHatchet()).isEqualTo(DEFAULT_HATCHET);
        assertThat(testSkills.getSmallaxe()).isEqualTo(DEFAULT_SMALLAXE);
        assertThat(testSkills.getLargeaxe()).isEqualTo(DEFAULT_LARGEAXE);
        assertThat(testSkills.getHugeaxe()).isEqualTo(DEFAULT_HUGEAXE);
        assertThat(testSkills.getSwords()).isEqualTo(DEFAULT_SWORDS);
        assertThat(testSkills.getLongsword()).isEqualTo(DEFAULT_LONGSWORD);
        assertThat(testSkills.getShortsword()).isEqualTo(DEFAULT_SHORTSWORD);
        assertThat(testSkills.getTwohandedsword()).isEqualTo(DEFAULT_TWOHANDEDSWORD);
        assertThat(testSkills.getKnives()).isEqualTo(DEFAULT_KNIVES);
        assertThat(testSkills.getCarvingknife()).isEqualTo(DEFAULT_CARVINGKNIFE);
        assertThat(testSkills.getButcheringknife()).isEqualTo(DEFAULT_BUTCHERINGKNIFE);
        assertThat(testSkills.getWoodcutting()).isEqualTo(DEFAULT_WOODCUTTING);
        assertThat(testSkills.getMauls()).isEqualTo(DEFAULT_MAULS);
        assertThat(testSkills.getMediummaul()).isEqualTo(DEFAULT_MEDIUMMAUL);
        assertThat(testSkills.getSmallmaul()).isEqualTo(DEFAULT_SMALLMAUL);
        assertThat(testSkills.getLargemaul()).isEqualTo(DEFAULT_LARGEMAUL);
        assertThat(testSkills.getCarpentry()).isEqualTo(DEFAULT_CARPENTRY);
        assertThat(testSkills.getBowyery()).isEqualTo(DEFAULT_BOWYERY);
        assertThat(testSkills.getFletching()).isEqualTo(DEFAULT_FLETCHING);
        assertThat(testSkills.getFinecarpentry()).isEqualTo(DEFAULT_FINECARPENTRY);
        assertThat(testSkills.getToymaking()).isEqualTo(DEFAULT_TOYMAKING);
        assertThat(testSkills.getShipbuilding()).isEqualTo(DEFAULT_SHIPBUILDING);
        assertThat(testSkills.getMind()).isEqualTo(DEFAULT_MIND);
        assertThat(testSkills.getMindlogic()).isEqualTo(DEFAULT_MINDLOGIC);
        assertThat(testSkills.getMindspeed()).isEqualTo(DEFAULT_MINDSPEED);
        assertThat(testSkills.getSoul()).isEqualTo(DEFAULT_SOUL);
        assertThat(testSkills.getSouldepth()).isEqualTo(DEFAULT_SOULDEPTH);
        assertThat(testSkills.getSoulstrength()).isEqualTo(DEFAULT_SOULSTRENGTH);
        assertThat(testSkills.getBody()).isEqualTo(DEFAULT_BODY);
        assertThat(testSkills.getBodystrength()).isEqualTo(DEFAULT_BODYSTRENGTH);
        assertThat(testSkills.getBodystamina()).isEqualTo(DEFAULT_BODYSTAMINA);
        assertThat(testSkills.getBodycontrol()).isEqualTo(DEFAULT_BODYCONTROL);
        assertThat(testSkills.getFaith()).isEqualTo(DEFAULT_FAITH);
        assertThat(testSkills.getFavor()).isEqualTo(DEFAULT_FAVOR);
        assertThat(testSkills.getAlignment()).isEqualTo(DEFAULT_ALIGNMENT);
    }

    @Test
    @Transactional
    void createSkillsWithExistingId() throws Exception {
        // Create the Skills with an existing ID
        skills.setId(1L);
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        int databaseSizeBeforeCreate = skillsRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Skills in the database
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkDumptimeIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setDumptime(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPlayernameIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setPlayername(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPremiumIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setPremium(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkServerIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setServer(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkReligionIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setReligion(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPrayerIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setPrayer(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkChannelingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setChanneling(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPreachingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setPreaching(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkExorcismIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setExorcism(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkHammersIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setHammers(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkWarhammerIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setWarhammer(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkHealingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setHealing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFirstaidIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setFirstaid(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkClubsIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setClubs(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkHugeclubIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setHugeclub(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkArcheryIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setArchery(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkShortbowIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setShortbow(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMediumbowIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMediumbow(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLongbowIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setLongbow(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkThieveryIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setThievery(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkStealingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setStealing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLockpickingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setLockpicking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTrapsIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setTraps(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkWarmachinesIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setWarmachines(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCatapultsIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setCatapults(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTrebuchetsIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setTrebuchets(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBallistaeIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setBallistae(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPolearmsIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setPolearms(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkStaffIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setStaff(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLongspearIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setLongspear(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkHalberdIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setHalberd(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkProspectingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setProspecting(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCoalmakingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setCoalmaking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMillingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMilling(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTrackingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setTracking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPavingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setPaving(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkArchaeologyIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setArchaeology(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRestorationIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setRestoration(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkClimbingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setClimbing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkThatchingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setThatching(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFiremakingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setFiremaking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPotteryIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setPottery(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMiningIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMining(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkDiggingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setDigging(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRopemakingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setRopemaking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSmithingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setSmithing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBlacksmithingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setBlacksmithing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLocksmithingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setLocksmithing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkJewelrysmithingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setJewelrysmithing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMetallurgyIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMetallurgy(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkWeaponsmithingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setWeaponsmithing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBladessmithingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setBladessmithing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkWeaponheadssmithingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setWeaponheadssmithing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkArmoursmithingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setArmoursmithing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkShieldsmithingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setShieldsmithing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkChainarmoursmithingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setChainarmoursmithing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPlatearmoursmithingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setPlatearmoursmithing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTailoringIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setTailoring(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkClothtailoringIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setClothtailoring(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLeatherworkingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setLeatherworking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMasonryIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMasonry(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkStonecuttingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setStonecutting(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCookingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setCooking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkHotfoodcookingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setHotfoodcooking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBakingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setBaking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkDairyfoodmakingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setDairyfoodmaking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkButcheringIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setButchering(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBeveragesIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setBeverages(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setNature(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFishingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setFishing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkGardeningIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setGardening(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkForagingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setForaging(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBotanizingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setBotanizing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAnimaltamingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setAnimaltaming(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkForestryIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setForestry(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFarmingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setFarming(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMilkingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMilking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMeditatingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMeditating(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAnimalhusbandryIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setAnimalhusbandry(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPapyrusmakingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setPapyrusmaking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkToysIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setToys(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkYoyoIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setYoyo(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPuppeteeringIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setPuppeteering(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFightingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setFighting(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkDefensivefightingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setDefensivefighting(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNormalfightingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setNormalfighting(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkWeaponlessfightingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setWeaponlessfighting(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAggressivefightingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setAggressivefighting(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkShieldbashingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setShieldbashing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTauntingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setTaunting(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMiscellaneousitemsIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMiscellaneousitems(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkShovelIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setShovel(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRakeIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setRake(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSawIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setSaw(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPickaxeIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setPickaxe(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRepairingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setRepairing(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSickleIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setSickle(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkScytheIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setScythe(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkHammerIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setHammer(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkStonechiselIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setStonechisel(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAlchemyIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setAlchemy(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNaturalsubstancesIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setNaturalsubstances(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkShieldsIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setShields(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMediummetalshieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMediummetalshield(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSmallwoodenshieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setSmallwoodenshield(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSmallmetalshieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setSmallmetalshield(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLargemetalshieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setLargemetalshield(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMediumwoodenshieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMediumwoodenshield(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLargewoodenshieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setLargewoodenshield(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAxesIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setAxes(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkHatchetIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setHatchet(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSmallaxeIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setSmallaxe(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLargeaxeIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setLargeaxe(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkHugeaxeIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setHugeaxe(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSwordsIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setSwords(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLongswordIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setLongsword(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkShortswordIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setShortsword(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTwohandedswordIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setTwohandedsword(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkKnivesIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setKnives(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCarvingknifeIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setCarvingknife(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkButcheringknifeIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setButcheringknife(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkWoodcuttingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setWoodcutting(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMaulsIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMauls(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMediummaulIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMediummaul(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSmallmaulIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setSmallmaul(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLargemaulIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setLargemaul(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCarpentryIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setCarpentry(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBowyeryIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setBowyery(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFletchingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setFletching(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFinecarpentryIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setFinecarpentry(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkToymakingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setToymaking(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkShipbuildingIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setShipbuilding(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMindIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMind(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMindlogicIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMindlogic(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMindspeedIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setMindspeed(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSoulIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setSoul(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSouldepthIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setSouldepth(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSoulstrengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setSoulstrength(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBodyIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setBody(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBodystrengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setBodystrength(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBodystaminaIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setBodystamina(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBodycontrolIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setBodycontrol(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFaithIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setFaith(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFavorIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setFavor(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAlignmentIsRequired() throws Exception {
        int databaseSizeBeforeTest = skillsRepository.findAll().size();
        // set the field null
        skills.setAlignment(null);

        // Create the Skills, which fails.
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        restSkillsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isBadRequest());

        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllSkills() throws Exception {
        // Initialize the database
        skillsRepository.saveAndFlush(skills);

        // Get all the skillsList
        restSkillsMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(skills.getId().intValue())))
            .andExpect(jsonPath("$.[*].dumptime").value(hasItem(DEFAULT_DUMPTIME)))
            .andExpect(jsonPath("$.[*].playername").value(hasItem(DEFAULT_PLAYERNAME)))
            .andExpect(jsonPath("$.[*].premium").value(hasItem(DEFAULT_PREMIUM)))
            .andExpect(jsonPath("$.[*].server").value(hasItem(DEFAULT_SERVER)))
            .andExpect(jsonPath("$.[*].religion").value(hasItem(DEFAULT_RELIGION.doubleValue())))
            .andExpect(jsonPath("$.[*].prayer").value(hasItem(DEFAULT_PRAYER.doubleValue())))
            .andExpect(jsonPath("$.[*].channeling").value(hasItem(DEFAULT_CHANNELING.doubleValue())))
            .andExpect(jsonPath("$.[*].preaching").value(hasItem(DEFAULT_PREACHING.doubleValue())))
            .andExpect(jsonPath("$.[*].exorcism").value(hasItem(DEFAULT_EXORCISM.doubleValue())))
            .andExpect(jsonPath("$.[*].hammers").value(hasItem(DEFAULT_HAMMERS.doubleValue())))
            .andExpect(jsonPath("$.[*].warhammer").value(hasItem(DEFAULT_WARHAMMER.doubleValue())))
            .andExpect(jsonPath("$.[*].healing").value(hasItem(DEFAULT_HEALING.doubleValue())))
            .andExpect(jsonPath("$.[*].firstaid").value(hasItem(DEFAULT_FIRSTAID.doubleValue())))
            .andExpect(jsonPath("$.[*].clubs").value(hasItem(DEFAULT_CLUBS.doubleValue())))
            .andExpect(jsonPath("$.[*].hugeclub").value(hasItem(DEFAULT_HUGECLUB.doubleValue())))
            .andExpect(jsonPath("$.[*].archery").value(hasItem(DEFAULT_ARCHERY.doubleValue())))
            .andExpect(jsonPath("$.[*].shortbow").value(hasItem(DEFAULT_SHORTBOW.doubleValue())))
            .andExpect(jsonPath("$.[*].mediumbow").value(hasItem(DEFAULT_MEDIUMBOW.doubleValue())))
            .andExpect(jsonPath("$.[*].longbow").value(hasItem(DEFAULT_LONGBOW.doubleValue())))
            .andExpect(jsonPath("$.[*].thievery").value(hasItem(DEFAULT_THIEVERY.doubleValue())))
            .andExpect(jsonPath("$.[*].stealing").value(hasItem(DEFAULT_STEALING.doubleValue())))
            .andExpect(jsonPath("$.[*].lockpicking").value(hasItem(DEFAULT_LOCKPICKING.doubleValue())))
            .andExpect(jsonPath("$.[*].traps").value(hasItem(DEFAULT_TRAPS.doubleValue())))
            .andExpect(jsonPath("$.[*].warmachines").value(hasItem(DEFAULT_WARMACHINES.doubleValue())))
            .andExpect(jsonPath("$.[*].catapults").value(hasItem(DEFAULT_CATAPULTS.doubleValue())))
            .andExpect(jsonPath("$.[*].trebuchets").value(hasItem(DEFAULT_TREBUCHETS.doubleValue())))
            .andExpect(jsonPath("$.[*].ballistae").value(hasItem(DEFAULT_BALLISTAE.doubleValue())))
            .andExpect(jsonPath("$.[*].polearms").value(hasItem(DEFAULT_POLEARMS.doubleValue())))
            .andExpect(jsonPath("$.[*].staff").value(hasItem(DEFAULT_STAFF.doubleValue())))
            .andExpect(jsonPath("$.[*].longspear").value(hasItem(DEFAULT_LONGSPEAR.doubleValue())))
            .andExpect(jsonPath("$.[*].halberd").value(hasItem(DEFAULT_HALBERD.doubleValue())))
            .andExpect(jsonPath("$.[*].prospecting").value(hasItem(DEFAULT_PROSPECTING.doubleValue())))
            .andExpect(jsonPath("$.[*].coalmaking").value(hasItem(DEFAULT_COALMAKING.doubleValue())))
            .andExpect(jsonPath("$.[*].milling").value(hasItem(DEFAULT_MILLING.doubleValue())))
            .andExpect(jsonPath("$.[*].tracking").value(hasItem(DEFAULT_TRACKING.doubleValue())))
            .andExpect(jsonPath("$.[*].paving").value(hasItem(DEFAULT_PAVING.doubleValue())))
            .andExpect(jsonPath("$.[*].archaeology").value(hasItem(DEFAULT_ARCHAEOLOGY.doubleValue())))
            .andExpect(jsonPath("$.[*].restoration").value(hasItem(DEFAULT_RESTORATION.doubleValue())))
            .andExpect(jsonPath("$.[*].climbing").value(hasItem(DEFAULT_CLIMBING.doubleValue())))
            .andExpect(jsonPath("$.[*].thatching").value(hasItem(DEFAULT_THATCHING.doubleValue())))
            .andExpect(jsonPath("$.[*].firemaking").value(hasItem(DEFAULT_FIREMAKING.doubleValue())))
            .andExpect(jsonPath("$.[*].pottery").value(hasItem(DEFAULT_POTTERY.doubleValue())))
            .andExpect(jsonPath("$.[*].mining").value(hasItem(DEFAULT_MINING.doubleValue())))
            .andExpect(jsonPath("$.[*].digging").value(hasItem(DEFAULT_DIGGING.doubleValue())))
            .andExpect(jsonPath("$.[*].ropemaking").value(hasItem(DEFAULT_ROPEMAKING.doubleValue())))
            .andExpect(jsonPath("$.[*].smithing").value(hasItem(DEFAULT_SMITHING.doubleValue())))
            .andExpect(jsonPath("$.[*].blacksmithing").value(hasItem(DEFAULT_BLACKSMITHING.doubleValue())))
            .andExpect(jsonPath("$.[*].locksmithing").value(hasItem(DEFAULT_LOCKSMITHING.doubleValue())))
            .andExpect(jsonPath("$.[*].jewelrysmithing").value(hasItem(DEFAULT_JEWELRYSMITHING.doubleValue())))
            .andExpect(jsonPath("$.[*].metallurgy").value(hasItem(DEFAULT_METALLURGY.doubleValue())))
            .andExpect(jsonPath("$.[*].weaponsmithing").value(hasItem(DEFAULT_WEAPONSMITHING.doubleValue())))
            .andExpect(jsonPath("$.[*].bladessmithing").value(hasItem(DEFAULT_BLADESSMITHING.doubleValue())))
            .andExpect(jsonPath("$.[*].weaponheadssmithing").value(hasItem(DEFAULT_WEAPONHEADSSMITHING.doubleValue())))
            .andExpect(jsonPath("$.[*].armoursmithing").value(hasItem(DEFAULT_ARMOURSMITHING.doubleValue())))
            .andExpect(jsonPath("$.[*].shieldsmithing").value(hasItem(DEFAULT_SHIELDSMITHING.doubleValue())))
            .andExpect(jsonPath("$.[*].chainarmoursmithing").value(hasItem(DEFAULT_CHAINARMOURSMITHING.doubleValue())))
            .andExpect(jsonPath("$.[*].platearmoursmithing").value(hasItem(DEFAULT_PLATEARMOURSMITHING.doubleValue())))
            .andExpect(jsonPath("$.[*].tailoring").value(hasItem(DEFAULT_TAILORING.doubleValue())))
            .andExpect(jsonPath("$.[*].clothtailoring").value(hasItem(DEFAULT_CLOTHTAILORING.doubleValue())))
            .andExpect(jsonPath("$.[*].leatherworking").value(hasItem(DEFAULT_LEATHERWORKING.doubleValue())))
            .andExpect(jsonPath("$.[*].masonry").value(hasItem(DEFAULT_MASONRY.doubleValue())))
            .andExpect(jsonPath("$.[*].stonecutting").value(hasItem(DEFAULT_STONECUTTING.doubleValue())))
            .andExpect(jsonPath("$.[*].cooking").value(hasItem(DEFAULT_COOKING.doubleValue())))
            .andExpect(jsonPath("$.[*].hotfoodcooking").value(hasItem(DEFAULT_HOTFOODCOOKING.doubleValue())))
            .andExpect(jsonPath("$.[*].baking").value(hasItem(DEFAULT_BAKING.doubleValue())))
            .andExpect(jsonPath("$.[*].dairyfoodmaking").value(hasItem(DEFAULT_DAIRYFOODMAKING.doubleValue())))
            .andExpect(jsonPath("$.[*].butchering").value(hasItem(DEFAULT_BUTCHERING.doubleValue())))
            .andExpect(jsonPath("$.[*].beverages").value(hasItem(DEFAULT_BEVERAGES.doubleValue())))
            .andExpect(jsonPath("$.[*].nature").value(hasItem(DEFAULT_NATURE.doubleValue())))
            .andExpect(jsonPath("$.[*].fishing").value(hasItem(DEFAULT_FISHING.doubleValue())))
            .andExpect(jsonPath("$.[*].gardening").value(hasItem(DEFAULT_GARDENING.doubleValue())))
            .andExpect(jsonPath("$.[*].foraging").value(hasItem(DEFAULT_FORAGING.doubleValue())))
            .andExpect(jsonPath("$.[*].botanizing").value(hasItem(DEFAULT_BOTANIZING.doubleValue())))
            .andExpect(jsonPath("$.[*].animaltaming").value(hasItem(DEFAULT_ANIMALTAMING.doubleValue())))
            .andExpect(jsonPath("$.[*].forestry").value(hasItem(DEFAULT_FORESTRY.doubleValue())))
            .andExpect(jsonPath("$.[*].farming").value(hasItem(DEFAULT_FARMING.doubleValue())))
            .andExpect(jsonPath("$.[*].milking").value(hasItem(DEFAULT_MILKING.doubleValue())))
            .andExpect(jsonPath("$.[*].meditating").value(hasItem(DEFAULT_MEDITATING.doubleValue())))
            .andExpect(jsonPath("$.[*].animalhusbandry").value(hasItem(DEFAULT_ANIMALHUSBANDRY.doubleValue())))
            .andExpect(jsonPath("$.[*].papyrusmaking").value(hasItem(DEFAULT_PAPYRUSMAKING.doubleValue())))
            .andExpect(jsonPath("$.[*].toys").value(hasItem(DEFAULT_TOYS.doubleValue())))
            .andExpect(jsonPath("$.[*].yoyo").value(hasItem(DEFAULT_YOYO.doubleValue())))
            .andExpect(jsonPath("$.[*].puppeteering").value(hasItem(DEFAULT_PUPPETEERING.doubleValue())))
            .andExpect(jsonPath("$.[*].fighting").value(hasItem(DEFAULT_FIGHTING.doubleValue())))
            .andExpect(jsonPath("$.[*].defensivefighting").value(hasItem(DEFAULT_DEFENSIVEFIGHTING.doubleValue())))
            .andExpect(jsonPath("$.[*].normalfighting").value(hasItem(DEFAULT_NORMALFIGHTING.doubleValue())))
            .andExpect(jsonPath("$.[*].weaponlessfighting").value(hasItem(DEFAULT_WEAPONLESSFIGHTING.doubleValue())))
            .andExpect(jsonPath("$.[*].aggressivefighting").value(hasItem(DEFAULT_AGGRESSIVEFIGHTING.doubleValue())))
            .andExpect(jsonPath("$.[*].shieldbashing").value(hasItem(DEFAULT_SHIELDBASHING.doubleValue())))
            .andExpect(jsonPath("$.[*].taunting").value(hasItem(DEFAULT_TAUNTING.doubleValue())))
            .andExpect(jsonPath("$.[*].miscellaneousitems").value(hasItem(DEFAULT_MISCELLANEOUSITEMS.doubleValue())))
            .andExpect(jsonPath("$.[*].shovel").value(hasItem(DEFAULT_SHOVEL.doubleValue())))
            .andExpect(jsonPath("$.[*].rake").value(hasItem(DEFAULT_RAKE.doubleValue())))
            .andExpect(jsonPath("$.[*].saw").value(hasItem(DEFAULT_SAW.doubleValue())))
            .andExpect(jsonPath("$.[*].pickaxe").value(hasItem(DEFAULT_PICKAXE.doubleValue())))
            .andExpect(jsonPath("$.[*].repairing").value(hasItem(DEFAULT_REPAIRING.doubleValue())))
            .andExpect(jsonPath("$.[*].sickle").value(hasItem(DEFAULT_SICKLE.doubleValue())))
            .andExpect(jsonPath("$.[*].scythe").value(hasItem(DEFAULT_SCYTHE.doubleValue())))
            .andExpect(jsonPath("$.[*].hammer").value(hasItem(DEFAULT_HAMMER.doubleValue())))
            .andExpect(jsonPath("$.[*].stonechisel").value(hasItem(DEFAULT_STONECHISEL.doubleValue())))
            .andExpect(jsonPath("$.[*].alchemy").value(hasItem(DEFAULT_ALCHEMY.doubleValue())))
            .andExpect(jsonPath("$.[*].naturalsubstances").value(hasItem(DEFAULT_NATURALSUBSTANCES.doubleValue())))
            .andExpect(jsonPath("$.[*].shields").value(hasItem(DEFAULT_SHIELDS.doubleValue())))
            .andExpect(jsonPath("$.[*].mediummetalshield").value(hasItem(DEFAULT_MEDIUMMETALSHIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].smallwoodenshield").value(hasItem(DEFAULT_SMALLWOODENSHIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].smallmetalshield").value(hasItem(DEFAULT_SMALLMETALSHIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].largemetalshield").value(hasItem(DEFAULT_LARGEMETALSHIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].mediumwoodenshield").value(hasItem(DEFAULT_MEDIUMWOODENSHIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].largewoodenshield").value(hasItem(DEFAULT_LARGEWOODENSHIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].axes").value(hasItem(DEFAULT_AXES.doubleValue())))
            .andExpect(jsonPath("$.[*].hatchet").value(hasItem(DEFAULT_HATCHET.doubleValue())))
            .andExpect(jsonPath("$.[*].smallaxe").value(hasItem(DEFAULT_SMALLAXE.doubleValue())))
            .andExpect(jsonPath("$.[*].largeaxe").value(hasItem(DEFAULT_LARGEAXE.doubleValue())))
            .andExpect(jsonPath("$.[*].hugeaxe").value(hasItem(DEFAULT_HUGEAXE.doubleValue())))
            .andExpect(jsonPath("$.[*].swords").value(hasItem(DEFAULT_SWORDS.doubleValue())))
            .andExpect(jsonPath("$.[*].longsword").value(hasItem(DEFAULT_LONGSWORD.doubleValue())))
            .andExpect(jsonPath("$.[*].shortsword").value(hasItem(DEFAULT_SHORTSWORD.doubleValue())))
            .andExpect(jsonPath("$.[*].twohandedsword").value(hasItem(DEFAULT_TWOHANDEDSWORD.doubleValue())))
            .andExpect(jsonPath("$.[*].knives").value(hasItem(DEFAULT_KNIVES.doubleValue())))
            .andExpect(jsonPath("$.[*].carvingknife").value(hasItem(DEFAULT_CARVINGKNIFE.doubleValue())))
            .andExpect(jsonPath("$.[*].butcheringknife").value(hasItem(DEFAULT_BUTCHERINGKNIFE.doubleValue())))
            .andExpect(jsonPath("$.[*].woodcutting").value(hasItem(DEFAULT_WOODCUTTING.doubleValue())))
            .andExpect(jsonPath("$.[*].mauls").value(hasItem(DEFAULT_MAULS.doubleValue())))
            .andExpect(jsonPath("$.[*].mediummaul").value(hasItem(DEFAULT_MEDIUMMAUL.doubleValue())))
            .andExpect(jsonPath("$.[*].smallmaul").value(hasItem(DEFAULT_SMALLMAUL.doubleValue())))
            .andExpect(jsonPath("$.[*].largemaul").value(hasItem(DEFAULT_LARGEMAUL.doubleValue())))
            .andExpect(jsonPath("$.[*].carpentry").value(hasItem(DEFAULT_CARPENTRY.doubleValue())))
            .andExpect(jsonPath("$.[*].bowyery").value(hasItem(DEFAULT_BOWYERY.doubleValue())))
            .andExpect(jsonPath("$.[*].fletching").value(hasItem(DEFAULT_FLETCHING.doubleValue())))
            .andExpect(jsonPath("$.[*].finecarpentry").value(hasItem(DEFAULT_FINECARPENTRY.doubleValue())))
            .andExpect(jsonPath("$.[*].toymaking").value(hasItem(DEFAULT_TOYMAKING.doubleValue())))
            .andExpect(jsonPath("$.[*].shipbuilding").value(hasItem(DEFAULT_SHIPBUILDING.doubleValue())))
            .andExpect(jsonPath("$.[*].mind").value(hasItem(DEFAULT_MIND.doubleValue())))
            .andExpect(jsonPath("$.[*].mindlogic").value(hasItem(DEFAULT_MINDLOGIC.doubleValue())))
            .andExpect(jsonPath("$.[*].mindspeed").value(hasItem(DEFAULT_MINDSPEED.doubleValue())))
            .andExpect(jsonPath("$.[*].soul").value(hasItem(DEFAULT_SOUL.doubleValue())))
            .andExpect(jsonPath("$.[*].souldepth").value(hasItem(DEFAULT_SOULDEPTH.doubleValue())))
            .andExpect(jsonPath("$.[*].soulstrength").value(hasItem(DEFAULT_SOULSTRENGTH.doubleValue())))
            .andExpect(jsonPath("$.[*].body").value(hasItem(DEFAULT_BODY.doubleValue())))
            .andExpect(jsonPath("$.[*].bodystrength").value(hasItem(DEFAULT_BODYSTRENGTH.doubleValue())))
            .andExpect(jsonPath("$.[*].bodystamina").value(hasItem(DEFAULT_BODYSTAMINA.doubleValue())))
            .andExpect(jsonPath("$.[*].bodycontrol").value(hasItem(DEFAULT_BODYCONTROL.doubleValue())))
            .andExpect(jsonPath("$.[*].faith").value(hasItem(DEFAULT_FAITH.doubleValue())))
            .andExpect(jsonPath("$.[*].favor").value(hasItem(DEFAULT_FAVOR.doubleValue())))
            .andExpect(jsonPath("$.[*].alignment").value(hasItem(DEFAULT_ALIGNMENT.doubleValue())));
    }

    @SuppressWarnings({ "unchecked" })
    void getAllSkillsWithEagerRelationshipsIsEnabled() throws Exception {
        when(skillsServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restSkillsMockMvc.perform(get(ENTITY_API_URL + "?eagerload=true")).andExpect(status().isOk());

        verify(skillsServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({ "unchecked" })
    void getAllSkillsWithEagerRelationshipsIsNotEnabled() throws Exception {
        when(skillsServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restSkillsMockMvc.perform(get(ENTITY_API_URL + "?eagerload=false")).andExpect(status().isOk());
        verify(skillsRepositoryMock, times(1)).findAll(any(Pageable.class));
    }

    @Test
    @Transactional
    void getSkills() throws Exception {
        // Initialize the database
        skillsRepository.saveAndFlush(skills);

        // Get the skills
        restSkillsMockMvc
            .perform(get(ENTITY_API_URL_ID, skills.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(skills.getId().intValue()))
            .andExpect(jsonPath("$.dumptime").value(DEFAULT_DUMPTIME))
            .andExpect(jsonPath("$.playername").value(DEFAULT_PLAYERNAME))
            .andExpect(jsonPath("$.premium").value(DEFAULT_PREMIUM))
            .andExpect(jsonPath("$.server").value(DEFAULT_SERVER))
            .andExpect(jsonPath("$.religion").value(DEFAULT_RELIGION.doubleValue()))
            .andExpect(jsonPath("$.prayer").value(DEFAULT_PRAYER.doubleValue()))
            .andExpect(jsonPath("$.channeling").value(DEFAULT_CHANNELING.doubleValue()))
            .andExpect(jsonPath("$.preaching").value(DEFAULT_PREACHING.doubleValue()))
            .andExpect(jsonPath("$.exorcism").value(DEFAULT_EXORCISM.doubleValue()))
            .andExpect(jsonPath("$.hammers").value(DEFAULT_HAMMERS.doubleValue()))
            .andExpect(jsonPath("$.warhammer").value(DEFAULT_WARHAMMER.doubleValue()))
            .andExpect(jsonPath("$.healing").value(DEFAULT_HEALING.doubleValue()))
            .andExpect(jsonPath("$.firstaid").value(DEFAULT_FIRSTAID.doubleValue()))
            .andExpect(jsonPath("$.clubs").value(DEFAULT_CLUBS.doubleValue()))
            .andExpect(jsonPath("$.hugeclub").value(DEFAULT_HUGECLUB.doubleValue()))
            .andExpect(jsonPath("$.archery").value(DEFAULT_ARCHERY.doubleValue()))
            .andExpect(jsonPath("$.shortbow").value(DEFAULT_SHORTBOW.doubleValue()))
            .andExpect(jsonPath("$.mediumbow").value(DEFAULT_MEDIUMBOW.doubleValue()))
            .andExpect(jsonPath("$.longbow").value(DEFAULT_LONGBOW.doubleValue()))
            .andExpect(jsonPath("$.thievery").value(DEFAULT_THIEVERY.doubleValue()))
            .andExpect(jsonPath("$.stealing").value(DEFAULT_STEALING.doubleValue()))
            .andExpect(jsonPath("$.lockpicking").value(DEFAULT_LOCKPICKING.doubleValue()))
            .andExpect(jsonPath("$.traps").value(DEFAULT_TRAPS.doubleValue()))
            .andExpect(jsonPath("$.warmachines").value(DEFAULT_WARMACHINES.doubleValue()))
            .andExpect(jsonPath("$.catapults").value(DEFAULT_CATAPULTS.doubleValue()))
            .andExpect(jsonPath("$.trebuchets").value(DEFAULT_TREBUCHETS.doubleValue()))
            .andExpect(jsonPath("$.ballistae").value(DEFAULT_BALLISTAE.doubleValue()))
            .andExpect(jsonPath("$.polearms").value(DEFAULT_POLEARMS.doubleValue()))
            .andExpect(jsonPath("$.staff").value(DEFAULT_STAFF.doubleValue()))
            .andExpect(jsonPath("$.longspear").value(DEFAULT_LONGSPEAR.doubleValue()))
            .andExpect(jsonPath("$.halberd").value(DEFAULT_HALBERD.doubleValue()))
            .andExpect(jsonPath("$.prospecting").value(DEFAULT_PROSPECTING.doubleValue()))
            .andExpect(jsonPath("$.coalmaking").value(DEFAULT_COALMAKING.doubleValue()))
            .andExpect(jsonPath("$.milling").value(DEFAULT_MILLING.doubleValue()))
            .andExpect(jsonPath("$.tracking").value(DEFAULT_TRACKING.doubleValue()))
            .andExpect(jsonPath("$.paving").value(DEFAULT_PAVING.doubleValue()))
            .andExpect(jsonPath("$.archaeology").value(DEFAULT_ARCHAEOLOGY.doubleValue()))
            .andExpect(jsonPath("$.restoration").value(DEFAULT_RESTORATION.doubleValue()))
            .andExpect(jsonPath("$.climbing").value(DEFAULT_CLIMBING.doubleValue()))
            .andExpect(jsonPath("$.thatching").value(DEFAULT_THATCHING.doubleValue()))
            .andExpect(jsonPath("$.firemaking").value(DEFAULT_FIREMAKING.doubleValue()))
            .andExpect(jsonPath("$.pottery").value(DEFAULT_POTTERY.doubleValue()))
            .andExpect(jsonPath("$.mining").value(DEFAULT_MINING.doubleValue()))
            .andExpect(jsonPath("$.digging").value(DEFAULT_DIGGING.doubleValue()))
            .andExpect(jsonPath("$.ropemaking").value(DEFAULT_ROPEMAKING.doubleValue()))
            .andExpect(jsonPath("$.smithing").value(DEFAULT_SMITHING.doubleValue()))
            .andExpect(jsonPath("$.blacksmithing").value(DEFAULT_BLACKSMITHING.doubleValue()))
            .andExpect(jsonPath("$.locksmithing").value(DEFAULT_LOCKSMITHING.doubleValue()))
            .andExpect(jsonPath("$.jewelrysmithing").value(DEFAULT_JEWELRYSMITHING.doubleValue()))
            .andExpect(jsonPath("$.metallurgy").value(DEFAULT_METALLURGY.doubleValue()))
            .andExpect(jsonPath("$.weaponsmithing").value(DEFAULT_WEAPONSMITHING.doubleValue()))
            .andExpect(jsonPath("$.bladessmithing").value(DEFAULT_BLADESSMITHING.doubleValue()))
            .andExpect(jsonPath("$.weaponheadssmithing").value(DEFAULT_WEAPONHEADSSMITHING.doubleValue()))
            .andExpect(jsonPath("$.armoursmithing").value(DEFAULT_ARMOURSMITHING.doubleValue()))
            .andExpect(jsonPath("$.shieldsmithing").value(DEFAULT_SHIELDSMITHING.doubleValue()))
            .andExpect(jsonPath("$.chainarmoursmithing").value(DEFAULT_CHAINARMOURSMITHING.doubleValue()))
            .andExpect(jsonPath("$.platearmoursmithing").value(DEFAULT_PLATEARMOURSMITHING.doubleValue()))
            .andExpect(jsonPath("$.tailoring").value(DEFAULT_TAILORING.doubleValue()))
            .andExpect(jsonPath("$.clothtailoring").value(DEFAULT_CLOTHTAILORING.doubleValue()))
            .andExpect(jsonPath("$.leatherworking").value(DEFAULT_LEATHERWORKING.doubleValue()))
            .andExpect(jsonPath("$.masonry").value(DEFAULT_MASONRY.doubleValue()))
            .andExpect(jsonPath("$.stonecutting").value(DEFAULT_STONECUTTING.doubleValue()))
            .andExpect(jsonPath("$.cooking").value(DEFAULT_COOKING.doubleValue()))
            .andExpect(jsonPath("$.hotfoodcooking").value(DEFAULT_HOTFOODCOOKING.doubleValue()))
            .andExpect(jsonPath("$.baking").value(DEFAULT_BAKING.doubleValue()))
            .andExpect(jsonPath("$.dairyfoodmaking").value(DEFAULT_DAIRYFOODMAKING.doubleValue()))
            .andExpect(jsonPath("$.butchering").value(DEFAULT_BUTCHERING.doubleValue()))
            .andExpect(jsonPath("$.beverages").value(DEFAULT_BEVERAGES.doubleValue()))
            .andExpect(jsonPath("$.nature").value(DEFAULT_NATURE.doubleValue()))
            .andExpect(jsonPath("$.fishing").value(DEFAULT_FISHING.doubleValue()))
            .andExpect(jsonPath("$.gardening").value(DEFAULT_GARDENING.doubleValue()))
            .andExpect(jsonPath("$.foraging").value(DEFAULT_FORAGING.doubleValue()))
            .andExpect(jsonPath("$.botanizing").value(DEFAULT_BOTANIZING.doubleValue()))
            .andExpect(jsonPath("$.animaltaming").value(DEFAULT_ANIMALTAMING.doubleValue()))
            .andExpect(jsonPath("$.forestry").value(DEFAULT_FORESTRY.doubleValue()))
            .andExpect(jsonPath("$.farming").value(DEFAULT_FARMING.doubleValue()))
            .andExpect(jsonPath("$.milking").value(DEFAULT_MILKING.doubleValue()))
            .andExpect(jsonPath("$.meditating").value(DEFAULT_MEDITATING.doubleValue()))
            .andExpect(jsonPath("$.animalhusbandry").value(DEFAULT_ANIMALHUSBANDRY.doubleValue()))
            .andExpect(jsonPath("$.papyrusmaking").value(DEFAULT_PAPYRUSMAKING.doubleValue()))
            .andExpect(jsonPath("$.toys").value(DEFAULT_TOYS.doubleValue()))
            .andExpect(jsonPath("$.yoyo").value(DEFAULT_YOYO.doubleValue()))
            .andExpect(jsonPath("$.puppeteering").value(DEFAULT_PUPPETEERING.doubleValue()))
            .andExpect(jsonPath("$.fighting").value(DEFAULT_FIGHTING.doubleValue()))
            .andExpect(jsonPath("$.defensivefighting").value(DEFAULT_DEFENSIVEFIGHTING.doubleValue()))
            .andExpect(jsonPath("$.normalfighting").value(DEFAULT_NORMALFIGHTING.doubleValue()))
            .andExpect(jsonPath("$.weaponlessfighting").value(DEFAULT_WEAPONLESSFIGHTING.doubleValue()))
            .andExpect(jsonPath("$.aggressivefighting").value(DEFAULT_AGGRESSIVEFIGHTING.doubleValue()))
            .andExpect(jsonPath("$.shieldbashing").value(DEFAULT_SHIELDBASHING.doubleValue()))
            .andExpect(jsonPath("$.taunting").value(DEFAULT_TAUNTING.doubleValue()))
            .andExpect(jsonPath("$.miscellaneousitems").value(DEFAULT_MISCELLANEOUSITEMS.doubleValue()))
            .andExpect(jsonPath("$.shovel").value(DEFAULT_SHOVEL.doubleValue()))
            .andExpect(jsonPath("$.rake").value(DEFAULT_RAKE.doubleValue()))
            .andExpect(jsonPath("$.saw").value(DEFAULT_SAW.doubleValue()))
            .andExpect(jsonPath("$.pickaxe").value(DEFAULT_PICKAXE.doubleValue()))
            .andExpect(jsonPath("$.repairing").value(DEFAULT_REPAIRING.doubleValue()))
            .andExpect(jsonPath("$.sickle").value(DEFAULT_SICKLE.doubleValue()))
            .andExpect(jsonPath("$.scythe").value(DEFAULT_SCYTHE.doubleValue()))
            .andExpect(jsonPath("$.hammer").value(DEFAULT_HAMMER.doubleValue()))
            .andExpect(jsonPath("$.stonechisel").value(DEFAULT_STONECHISEL.doubleValue()))
            .andExpect(jsonPath("$.alchemy").value(DEFAULT_ALCHEMY.doubleValue()))
            .andExpect(jsonPath("$.naturalsubstances").value(DEFAULT_NATURALSUBSTANCES.doubleValue()))
            .andExpect(jsonPath("$.shields").value(DEFAULT_SHIELDS.doubleValue()))
            .andExpect(jsonPath("$.mediummetalshield").value(DEFAULT_MEDIUMMETALSHIELD.doubleValue()))
            .andExpect(jsonPath("$.smallwoodenshield").value(DEFAULT_SMALLWOODENSHIELD.doubleValue()))
            .andExpect(jsonPath("$.smallmetalshield").value(DEFAULT_SMALLMETALSHIELD.doubleValue()))
            .andExpect(jsonPath("$.largemetalshield").value(DEFAULT_LARGEMETALSHIELD.doubleValue()))
            .andExpect(jsonPath("$.mediumwoodenshield").value(DEFAULT_MEDIUMWOODENSHIELD.doubleValue()))
            .andExpect(jsonPath("$.largewoodenshield").value(DEFAULT_LARGEWOODENSHIELD.doubleValue()))
            .andExpect(jsonPath("$.axes").value(DEFAULT_AXES.doubleValue()))
            .andExpect(jsonPath("$.hatchet").value(DEFAULT_HATCHET.doubleValue()))
            .andExpect(jsonPath("$.smallaxe").value(DEFAULT_SMALLAXE.doubleValue()))
            .andExpect(jsonPath("$.largeaxe").value(DEFAULT_LARGEAXE.doubleValue()))
            .andExpect(jsonPath("$.hugeaxe").value(DEFAULT_HUGEAXE.doubleValue()))
            .andExpect(jsonPath("$.swords").value(DEFAULT_SWORDS.doubleValue()))
            .andExpect(jsonPath("$.longsword").value(DEFAULT_LONGSWORD.doubleValue()))
            .andExpect(jsonPath("$.shortsword").value(DEFAULT_SHORTSWORD.doubleValue()))
            .andExpect(jsonPath("$.twohandedsword").value(DEFAULT_TWOHANDEDSWORD.doubleValue()))
            .andExpect(jsonPath("$.knives").value(DEFAULT_KNIVES.doubleValue()))
            .andExpect(jsonPath("$.carvingknife").value(DEFAULT_CARVINGKNIFE.doubleValue()))
            .andExpect(jsonPath("$.butcheringknife").value(DEFAULT_BUTCHERINGKNIFE.doubleValue()))
            .andExpect(jsonPath("$.woodcutting").value(DEFAULT_WOODCUTTING.doubleValue()))
            .andExpect(jsonPath("$.mauls").value(DEFAULT_MAULS.doubleValue()))
            .andExpect(jsonPath("$.mediummaul").value(DEFAULT_MEDIUMMAUL.doubleValue()))
            .andExpect(jsonPath("$.smallmaul").value(DEFAULT_SMALLMAUL.doubleValue()))
            .andExpect(jsonPath("$.largemaul").value(DEFAULT_LARGEMAUL.doubleValue()))
            .andExpect(jsonPath("$.carpentry").value(DEFAULT_CARPENTRY.doubleValue()))
            .andExpect(jsonPath("$.bowyery").value(DEFAULT_BOWYERY.doubleValue()))
            .andExpect(jsonPath("$.fletching").value(DEFAULT_FLETCHING.doubleValue()))
            .andExpect(jsonPath("$.finecarpentry").value(DEFAULT_FINECARPENTRY.doubleValue()))
            .andExpect(jsonPath("$.toymaking").value(DEFAULT_TOYMAKING.doubleValue()))
            .andExpect(jsonPath("$.shipbuilding").value(DEFAULT_SHIPBUILDING.doubleValue()))
            .andExpect(jsonPath("$.mind").value(DEFAULT_MIND.doubleValue()))
            .andExpect(jsonPath("$.mindlogic").value(DEFAULT_MINDLOGIC.doubleValue()))
            .andExpect(jsonPath("$.mindspeed").value(DEFAULT_MINDSPEED.doubleValue()))
            .andExpect(jsonPath("$.soul").value(DEFAULT_SOUL.doubleValue()))
            .andExpect(jsonPath("$.souldepth").value(DEFAULT_SOULDEPTH.doubleValue()))
            .andExpect(jsonPath("$.soulstrength").value(DEFAULT_SOULSTRENGTH.doubleValue()))
            .andExpect(jsonPath("$.body").value(DEFAULT_BODY.doubleValue()))
            .andExpect(jsonPath("$.bodystrength").value(DEFAULT_BODYSTRENGTH.doubleValue()))
            .andExpect(jsonPath("$.bodystamina").value(DEFAULT_BODYSTAMINA.doubleValue()))
            .andExpect(jsonPath("$.bodycontrol").value(DEFAULT_BODYCONTROL.doubleValue()))
            .andExpect(jsonPath("$.faith").value(DEFAULT_FAITH.doubleValue()))
            .andExpect(jsonPath("$.favor").value(DEFAULT_FAVOR.doubleValue()))
            .andExpect(jsonPath("$.alignment").value(DEFAULT_ALIGNMENT.doubleValue()));
    }

    @Test
    @Transactional
    void getNonExistingSkills() throws Exception {
        // Get the skills
        restSkillsMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingSkills() throws Exception {
        // Initialize the database
        skillsRepository.saveAndFlush(skills);

        int databaseSizeBeforeUpdate = skillsRepository.findAll().size();

        // Update the skills
        Skills updatedSkills = skillsRepository.findById(skills.getId()).get();
        // Disconnect from session so that the updates on updatedSkills are not directly saved in db
        em.detach(updatedSkills);
        updatedSkills
            .dumptime(UPDATED_DUMPTIME)
            .playername(UPDATED_PLAYERNAME)
            .premium(UPDATED_PREMIUM)
            .server(UPDATED_SERVER)
            .religion(UPDATED_RELIGION)
            .prayer(UPDATED_PRAYER)
            .channeling(UPDATED_CHANNELING)
            .preaching(UPDATED_PREACHING)
            .exorcism(UPDATED_EXORCISM)
            .hammers(UPDATED_HAMMERS)
            .warhammer(UPDATED_WARHAMMER)
            .healing(UPDATED_HEALING)
            .firstaid(UPDATED_FIRSTAID)
            .clubs(UPDATED_CLUBS)
            .hugeclub(UPDATED_HUGECLUB)
            .archery(UPDATED_ARCHERY)
            .shortbow(UPDATED_SHORTBOW)
            .mediumbow(UPDATED_MEDIUMBOW)
            .longbow(UPDATED_LONGBOW)
            .thievery(UPDATED_THIEVERY)
            .stealing(UPDATED_STEALING)
            .lockpicking(UPDATED_LOCKPICKING)
            .traps(UPDATED_TRAPS)
            .warmachines(UPDATED_WARMACHINES)
            .catapults(UPDATED_CATAPULTS)
            .trebuchets(UPDATED_TREBUCHETS)
            .ballistae(UPDATED_BALLISTAE)
            .polearms(UPDATED_POLEARMS)
            .staff(UPDATED_STAFF)
            .longspear(UPDATED_LONGSPEAR)
            .halberd(UPDATED_HALBERD)
            .prospecting(UPDATED_PROSPECTING)
            .coalmaking(UPDATED_COALMAKING)
            .milling(UPDATED_MILLING)
            .tracking(UPDATED_TRACKING)
            .paving(UPDATED_PAVING)
            .archaeology(UPDATED_ARCHAEOLOGY)
            .restoration(UPDATED_RESTORATION)
            .climbing(UPDATED_CLIMBING)
            .thatching(UPDATED_THATCHING)
            .firemaking(UPDATED_FIREMAKING)
            .pottery(UPDATED_POTTERY)
            .mining(UPDATED_MINING)
            .digging(UPDATED_DIGGING)
            .ropemaking(UPDATED_ROPEMAKING)
            .smithing(UPDATED_SMITHING)
            .blacksmithing(UPDATED_BLACKSMITHING)
            .locksmithing(UPDATED_LOCKSMITHING)
            .jewelrysmithing(UPDATED_JEWELRYSMITHING)
            .metallurgy(UPDATED_METALLURGY)
            .weaponsmithing(UPDATED_WEAPONSMITHING)
            .bladessmithing(UPDATED_BLADESSMITHING)
            .weaponheadssmithing(UPDATED_WEAPONHEADSSMITHING)
            .armoursmithing(UPDATED_ARMOURSMITHING)
            .shieldsmithing(UPDATED_SHIELDSMITHING)
            .chainarmoursmithing(UPDATED_CHAINARMOURSMITHING)
            .platearmoursmithing(UPDATED_PLATEARMOURSMITHING)
            .tailoring(UPDATED_TAILORING)
            .clothtailoring(UPDATED_CLOTHTAILORING)
            .leatherworking(UPDATED_LEATHERWORKING)
            .masonry(UPDATED_MASONRY)
            .stonecutting(UPDATED_STONECUTTING)
            .cooking(UPDATED_COOKING)
            .hotfoodcooking(UPDATED_HOTFOODCOOKING)
            .baking(UPDATED_BAKING)
            .dairyfoodmaking(UPDATED_DAIRYFOODMAKING)
            .butchering(UPDATED_BUTCHERING)
            .beverages(UPDATED_BEVERAGES)
            .nature(UPDATED_NATURE)
            .fishing(UPDATED_FISHING)
            .gardening(UPDATED_GARDENING)
            .foraging(UPDATED_FORAGING)
            .botanizing(UPDATED_BOTANIZING)
            .animaltaming(UPDATED_ANIMALTAMING)
            .forestry(UPDATED_FORESTRY)
            .farming(UPDATED_FARMING)
            .milking(UPDATED_MILKING)
            .meditating(UPDATED_MEDITATING)
            .animalhusbandry(UPDATED_ANIMALHUSBANDRY)
            .papyrusmaking(UPDATED_PAPYRUSMAKING)
            .toys(UPDATED_TOYS)
            .yoyo(UPDATED_YOYO)
            .puppeteering(UPDATED_PUPPETEERING)
            .fighting(UPDATED_FIGHTING)
            .defensivefighting(UPDATED_DEFENSIVEFIGHTING)
            .normalfighting(UPDATED_NORMALFIGHTING)
            .weaponlessfighting(UPDATED_WEAPONLESSFIGHTING)
            .aggressivefighting(UPDATED_AGGRESSIVEFIGHTING)
            .shieldbashing(UPDATED_SHIELDBASHING)
            .taunting(UPDATED_TAUNTING)
            .miscellaneousitems(UPDATED_MISCELLANEOUSITEMS)
            .shovel(UPDATED_SHOVEL)
            .rake(UPDATED_RAKE)
            .saw(UPDATED_SAW)
            .pickaxe(UPDATED_PICKAXE)
            .repairing(UPDATED_REPAIRING)
            .sickle(UPDATED_SICKLE)
            .scythe(UPDATED_SCYTHE)
            .hammer(UPDATED_HAMMER)
            .stonechisel(UPDATED_STONECHISEL)
            .alchemy(UPDATED_ALCHEMY)
            .naturalsubstances(UPDATED_NATURALSUBSTANCES)
            .shields(UPDATED_SHIELDS)
            .mediummetalshield(UPDATED_MEDIUMMETALSHIELD)
            .smallwoodenshield(UPDATED_SMALLWOODENSHIELD)
            .smallmetalshield(UPDATED_SMALLMETALSHIELD)
            .largemetalshield(UPDATED_LARGEMETALSHIELD)
            .mediumwoodenshield(UPDATED_MEDIUMWOODENSHIELD)
            .largewoodenshield(UPDATED_LARGEWOODENSHIELD)
            .axes(UPDATED_AXES)
            .hatchet(UPDATED_HATCHET)
            .smallaxe(UPDATED_SMALLAXE)
            .largeaxe(UPDATED_LARGEAXE)
            .hugeaxe(UPDATED_HUGEAXE)
            .swords(UPDATED_SWORDS)
            .longsword(UPDATED_LONGSWORD)
            .shortsword(UPDATED_SHORTSWORD)
            .twohandedsword(UPDATED_TWOHANDEDSWORD)
            .knives(UPDATED_KNIVES)
            .carvingknife(UPDATED_CARVINGKNIFE)
            .butcheringknife(UPDATED_BUTCHERINGKNIFE)
            .woodcutting(UPDATED_WOODCUTTING)
            .mauls(UPDATED_MAULS)
            .mediummaul(UPDATED_MEDIUMMAUL)
            .smallmaul(UPDATED_SMALLMAUL)
            .largemaul(UPDATED_LARGEMAUL)
            .carpentry(UPDATED_CARPENTRY)
            .bowyery(UPDATED_BOWYERY)
            .fletching(UPDATED_FLETCHING)
            .finecarpentry(UPDATED_FINECARPENTRY)
            .toymaking(UPDATED_TOYMAKING)
            .shipbuilding(UPDATED_SHIPBUILDING)
            .mind(UPDATED_MIND)
            .mindlogic(UPDATED_MINDLOGIC)
            .mindspeed(UPDATED_MINDSPEED)
            .soul(UPDATED_SOUL)
            .souldepth(UPDATED_SOULDEPTH)
            .soulstrength(UPDATED_SOULSTRENGTH)
            .body(UPDATED_BODY)
            .bodystrength(UPDATED_BODYSTRENGTH)
            .bodystamina(UPDATED_BODYSTAMINA)
            .bodycontrol(UPDATED_BODYCONTROL)
            .faith(UPDATED_FAITH)
            .favor(UPDATED_FAVOR)
            .alignment(UPDATED_ALIGNMENT);
        SkillsDTO skillsDTO = skillsMapper.toDto(updatedSkills);

        restSkillsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, skillsDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(skillsDTO))
            )
            .andExpect(status().isOk());

        // Validate the Skills in the database
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeUpdate);
        Skills testSkills = skillsList.get(skillsList.size() - 1);
        assertThat(testSkills.getDumptime()).isEqualTo(UPDATED_DUMPTIME);
        assertThat(testSkills.getPlayername()).isEqualTo(UPDATED_PLAYERNAME);
        assertThat(testSkills.getPremium()).isEqualTo(UPDATED_PREMIUM);
        assertThat(testSkills.getServer()).isEqualTo(UPDATED_SERVER);
        assertThat(testSkills.getReligion()).isEqualTo(UPDATED_RELIGION);
        assertThat(testSkills.getPrayer()).isEqualTo(UPDATED_PRAYER);
        assertThat(testSkills.getChanneling()).isEqualTo(UPDATED_CHANNELING);
        assertThat(testSkills.getPreaching()).isEqualTo(UPDATED_PREACHING);
        assertThat(testSkills.getExorcism()).isEqualTo(UPDATED_EXORCISM);
        assertThat(testSkills.getHammers()).isEqualTo(UPDATED_HAMMERS);
        assertThat(testSkills.getWarhammer()).isEqualTo(UPDATED_WARHAMMER);
        assertThat(testSkills.getHealing()).isEqualTo(UPDATED_HEALING);
        assertThat(testSkills.getFirstaid()).isEqualTo(UPDATED_FIRSTAID);
        assertThat(testSkills.getClubs()).isEqualTo(UPDATED_CLUBS);
        assertThat(testSkills.getHugeclub()).isEqualTo(UPDATED_HUGECLUB);
        assertThat(testSkills.getArchery()).isEqualTo(UPDATED_ARCHERY);
        assertThat(testSkills.getShortbow()).isEqualTo(UPDATED_SHORTBOW);
        assertThat(testSkills.getMediumbow()).isEqualTo(UPDATED_MEDIUMBOW);
        assertThat(testSkills.getLongbow()).isEqualTo(UPDATED_LONGBOW);
        assertThat(testSkills.getThievery()).isEqualTo(UPDATED_THIEVERY);
        assertThat(testSkills.getStealing()).isEqualTo(UPDATED_STEALING);
        assertThat(testSkills.getLockpicking()).isEqualTo(UPDATED_LOCKPICKING);
        assertThat(testSkills.getTraps()).isEqualTo(UPDATED_TRAPS);
        assertThat(testSkills.getWarmachines()).isEqualTo(UPDATED_WARMACHINES);
        assertThat(testSkills.getCatapults()).isEqualTo(UPDATED_CATAPULTS);
        assertThat(testSkills.getTrebuchets()).isEqualTo(UPDATED_TREBUCHETS);
        assertThat(testSkills.getBallistae()).isEqualTo(UPDATED_BALLISTAE);
        assertThat(testSkills.getPolearms()).isEqualTo(UPDATED_POLEARMS);
        assertThat(testSkills.getStaff()).isEqualTo(UPDATED_STAFF);
        assertThat(testSkills.getLongspear()).isEqualTo(UPDATED_LONGSPEAR);
        assertThat(testSkills.getHalberd()).isEqualTo(UPDATED_HALBERD);
        assertThat(testSkills.getProspecting()).isEqualTo(UPDATED_PROSPECTING);
        assertThat(testSkills.getCoalmaking()).isEqualTo(UPDATED_COALMAKING);
        assertThat(testSkills.getMilling()).isEqualTo(UPDATED_MILLING);
        assertThat(testSkills.getTracking()).isEqualTo(UPDATED_TRACKING);
        assertThat(testSkills.getPaving()).isEqualTo(UPDATED_PAVING);
        assertThat(testSkills.getArchaeology()).isEqualTo(UPDATED_ARCHAEOLOGY);
        assertThat(testSkills.getRestoration()).isEqualTo(UPDATED_RESTORATION);
        assertThat(testSkills.getClimbing()).isEqualTo(UPDATED_CLIMBING);
        assertThat(testSkills.getThatching()).isEqualTo(UPDATED_THATCHING);
        assertThat(testSkills.getFiremaking()).isEqualTo(UPDATED_FIREMAKING);
        assertThat(testSkills.getPottery()).isEqualTo(UPDATED_POTTERY);
        assertThat(testSkills.getMining()).isEqualTo(UPDATED_MINING);
        assertThat(testSkills.getDigging()).isEqualTo(UPDATED_DIGGING);
        assertThat(testSkills.getRopemaking()).isEqualTo(UPDATED_ROPEMAKING);
        assertThat(testSkills.getSmithing()).isEqualTo(UPDATED_SMITHING);
        assertThat(testSkills.getBlacksmithing()).isEqualTo(UPDATED_BLACKSMITHING);
        assertThat(testSkills.getLocksmithing()).isEqualTo(UPDATED_LOCKSMITHING);
        assertThat(testSkills.getJewelrysmithing()).isEqualTo(UPDATED_JEWELRYSMITHING);
        assertThat(testSkills.getMetallurgy()).isEqualTo(UPDATED_METALLURGY);
        assertThat(testSkills.getWeaponsmithing()).isEqualTo(UPDATED_WEAPONSMITHING);
        assertThat(testSkills.getBladessmithing()).isEqualTo(UPDATED_BLADESSMITHING);
        assertThat(testSkills.getWeaponheadssmithing()).isEqualTo(UPDATED_WEAPONHEADSSMITHING);
        assertThat(testSkills.getArmoursmithing()).isEqualTo(UPDATED_ARMOURSMITHING);
        assertThat(testSkills.getShieldsmithing()).isEqualTo(UPDATED_SHIELDSMITHING);
        assertThat(testSkills.getChainarmoursmithing()).isEqualTo(UPDATED_CHAINARMOURSMITHING);
        assertThat(testSkills.getPlatearmoursmithing()).isEqualTo(UPDATED_PLATEARMOURSMITHING);
        assertThat(testSkills.getTailoring()).isEqualTo(UPDATED_TAILORING);
        assertThat(testSkills.getClothtailoring()).isEqualTo(UPDATED_CLOTHTAILORING);
        assertThat(testSkills.getLeatherworking()).isEqualTo(UPDATED_LEATHERWORKING);
        assertThat(testSkills.getMasonry()).isEqualTo(UPDATED_MASONRY);
        assertThat(testSkills.getStonecutting()).isEqualTo(UPDATED_STONECUTTING);
        assertThat(testSkills.getCooking()).isEqualTo(UPDATED_COOKING);
        assertThat(testSkills.getHotfoodcooking()).isEqualTo(UPDATED_HOTFOODCOOKING);
        assertThat(testSkills.getBaking()).isEqualTo(UPDATED_BAKING);
        assertThat(testSkills.getDairyfoodmaking()).isEqualTo(UPDATED_DAIRYFOODMAKING);
        assertThat(testSkills.getButchering()).isEqualTo(UPDATED_BUTCHERING);
        assertThat(testSkills.getBeverages()).isEqualTo(UPDATED_BEVERAGES);
        assertThat(testSkills.getNature()).isEqualTo(UPDATED_NATURE);
        assertThat(testSkills.getFishing()).isEqualTo(UPDATED_FISHING);
        assertThat(testSkills.getGardening()).isEqualTo(UPDATED_GARDENING);
        assertThat(testSkills.getForaging()).isEqualTo(UPDATED_FORAGING);
        assertThat(testSkills.getBotanizing()).isEqualTo(UPDATED_BOTANIZING);
        assertThat(testSkills.getAnimaltaming()).isEqualTo(UPDATED_ANIMALTAMING);
        assertThat(testSkills.getForestry()).isEqualTo(UPDATED_FORESTRY);
        assertThat(testSkills.getFarming()).isEqualTo(UPDATED_FARMING);
        assertThat(testSkills.getMilking()).isEqualTo(UPDATED_MILKING);
        assertThat(testSkills.getMeditating()).isEqualTo(UPDATED_MEDITATING);
        assertThat(testSkills.getAnimalhusbandry()).isEqualTo(UPDATED_ANIMALHUSBANDRY);
        assertThat(testSkills.getPapyrusmaking()).isEqualTo(UPDATED_PAPYRUSMAKING);
        assertThat(testSkills.getToys()).isEqualTo(UPDATED_TOYS);
        assertThat(testSkills.getYoyo()).isEqualTo(UPDATED_YOYO);
        assertThat(testSkills.getPuppeteering()).isEqualTo(UPDATED_PUPPETEERING);
        assertThat(testSkills.getFighting()).isEqualTo(UPDATED_FIGHTING);
        assertThat(testSkills.getDefensivefighting()).isEqualTo(UPDATED_DEFENSIVEFIGHTING);
        assertThat(testSkills.getNormalfighting()).isEqualTo(UPDATED_NORMALFIGHTING);
        assertThat(testSkills.getWeaponlessfighting()).isEqualTo(UPDATED_WEAPONLESSFIGHTING);
        assertThat(testSkills.getAggressivefighting()).isEqualTo(UPDATED_AGGRESSIVEFIGHTING);
        assertThat(testSkills.getShieldbashing()).isEqualTo(UPDATED_SHIELDBASHING);
        assertThat(testSkills.getTaunting()).isEqualTo(UPDATED_TAUNTING);
        assertThat(testSkills.getMiscellaneousitems()).isEqualTo(UPDATED_MISCELLANEOUSITEMS);
        assertThat(testSkills.getShovel()).isEqualTo(UPDATED_SHOVEL);
        assertThat(testSkills.getRake()).isEqualTo(UPDATED_RAKE);
        assertThat(testSkills.getSaw()).isEqualTo(UPDATED_SAW);
        assertThat(testSkills.getPickaxe()).isEqualTo(UPDATED_PICKAXE);
        assertThat(testSkills.getRepairing()).isEqualTo(UPDATED_REPAIRING);
        assertThat(testSkills.getSickle()).isEqualTo(UPDATED_SICKLE);
        assertThat(testSkills.getScythe()).isEqualTo(UPDATED_SCYTHE);
        assertThat(testSkills.getHammer()).isEqualTo(UPDATED_HAMMER);
        assertThat(testSkills.getStonechisel()).isEqualTo(UPDATED_STONECHISEL);
        assertThat(testSkills.getAlchemy()).isEqualTo(UPDATED_ALCHEMY);
        assertThat(testSkills.getNaturalsubstances()).isEqualTo(UPDATED_NATURALSUBSTANCES);
        assertThat(testSkills.getShields()).isEqualTo(UPDATED_SHIELDS);
        assertThat(testSkills.getMediummetalshield()).isEqualTo(UPDATED_MEDIUMMETALSHIELD);
        assertThat(testSkills.getSmallwoodenshield()).isEqualTo(UPDATED_SMALLWOODENSHIELD);
        assertThat(testSkills.getSmallmetalshield()).isEqualTo(UPDATED_SMALLMETALSHIELD);
        assertThat(testSkills.getLargemetalshield()).isEqualTo(UPDATED_LARGEMETALSHIELD);
        assertThat(testSkills.getMediumwoodenshield()).isEqualTo(UPDATED_MEDIUMWOODENSHIELD);
        assertThat(testSkills.getLargewoodenshield()).isEqualTo(UPDATED_LARGEWOODENSHIELD);
        assertThat(testSkills.getAxes()).isEqualTo(UPDATED_AXES);
        assertThat(testSkills.getHatchet()).isEqualTo(UPDATED_HATCHET);
        assertThat(testSkills.getSmallaxe()).isEqualTo(UPDATED_SMALLAXE);
        assertThat(testSkills.getLargeaxe()).isEqualTo(UPDATED_LARGEAXE);
        assertThat(testSkills.getHugeaxe()).isEqualTo(UPDATED_HUGEAXE);
        assertThat(testSkills.getSwords()).isEqualTo(UPDATED_SWORDS);
        assertThat(testSkills.getLongsword()).isEqualTo(UPDATED_LONGSWORD);
        assertThat(testSkills.getShortsword()).isEqualTo(UPDATED_SHORTSWORD);
        assertThat(testSkills.getTwohandedsword()).isEqualTo(UPDATED_TWOHANDEDSWORD);
        assertThat(testSkills.getKnives()).isEqualTo(UPDATED_KNIVES);
        assertThat(testSkills.getCarvingknife()).isEqualTo(UPDATED_CARVINGKNIFE);
        assertThat(testSkills.getButcheringknife()).isEqualTo(UPDATED_BUTCHERINGKNIFE);
        assertThat(testSkills.getWoodcutting()).isEqualTo(UPDATED_WOODCUTTING);
        assertThat(testSkills.getMauls()).isEqualTo(UPDATED_MAULS);
        assertThat(testSkills.getMediummaul()).isEqualTo(UPDATED_MEDIUMMAUL);
        assertThat(testSkills.getSmallmaul()).isEqualTo(UPDATED_SMALLMAUL);
        assertThat(testSkills.getLargemaul()).isEqualTo(UPDATED_LARGEMAUL);
        assertThat(testSkills.getCarpentry()).isEqualTo(UPDATED_CARPENTRY);
        assertThat(testSkills.getBowyery()).isEqualTo(UPDATED_BOWYERY);
        assertThat(testSkills.getFletching()).isEqualTo(UPDATED_FLETCHING);
        assertThat(testSkills.getFinecarpentry()).isEqualTo(UPDATED_FINECARPENTRY);
        assertThat(testSkills.getToymaking()).isEqualTo(UPDATED_TOYMAKING);
        assertThat(testSkills.getShipbuilding()).isEqualTo(UPDATED_SHIPBUILDING);
        assertThat(testSkills.getMind()).isEqualTo(UPDATED_MIND);
        assertThat(testSkills.getMindlogic()).isEqualTo(UPDATED_MINDLOGIC);
        assertThat(testSkills.getMindspeed()).isEqualTo(UPDATED_MINDSPEED);
        assertThat(testSkills.getSoul()).isEqualTo(UPDATED_SOUL);
        assertThat(testSkills.getSouldepth()).isEqualTo(UPDATED_SOULDEPTH);
        assertThat(testSkills.getSoulstrength()).isEqualTo(UPDATED_SOULSTRENGTH);
        assertThat(testSkills.getBody()).isEqualTo(UPDATED_BODY);
        assertThat(testSkills.getBodystrength()).isEqualTo(UPDATED_BODYSTRENGTH);
        assertThat(testSkills.getBodystamina()).isEqualTo(UPDATED_BODYSTAMINA);
        assertThat(testSkills.getBodycontrol()).isEqualTo(UPDATED_BODYCONTROL);
        assertThat(testSkills.getFaith()).isEqualTo(UPDATED_FAITH);
        assertThat(testSkills.getFavor()).isEqualTo(UPDATED_FAVOR);
        assertThat(testSkills.getAlignment()).isEqualTo(UPDATED_ALIGNMENT);
    }

    @Test
    @Transactional
    void putNonExistingSkills() throws Exception {
        int databaseSizeBeforeUpdate = skillsRepository.findAll().size();
        skills.setId(count.incrementAndGet());

        // Create the Skills
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSkillsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, skillsDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(skillsDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Skills in the database
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchSkills() throws Exception {
        int databaseSizeBeforeUpdate = skillsRepository.findAll().size();
        skills.setId(count.incrementAndGet());

        // Create the Skills
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSkillsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(skillsDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Skills in the database
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamSkills() throws Exception {
        int databaseSizeBeforeUpdate = skillsRepository.findAll().size();
        skills.setId(count.incrementAndGet());

        // Create the Skills
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSkillsMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(skillsDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Skills in the database
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateSkillsWithPatch() throws Exception {
        // Initialize the database
        skillsRepository.saveAndFlush(skills);

        int databaseSizeBeforeUpdate = skillsRepository.findAll().size();

        // Update the skills using partial update
        Skills partialUpdatedSkills = new Skills();
        partialUpdatedSkills.setId(skills.getId());

        partialUpdatedSkills
            .dumptime(UPDATED_DUMPTIME)
            .premium(UPDATED_PREMIUM)
            .channeling(UPDATED_CHANNELING)
            .exorcism(UPDATED_EXORCISM)
            .shortbow(UPDATED_SHORTBOW)
            .stealing(UPDATED_STEALING)
            .lockpicking(UPDATED_LOCKPICKING)
            .warmachines(UPDATED_WARMACHINES)
            .catapults(UPDATED_CATAPULTS)
            .trebuchets(UPDATED_TREBUCHETS)
            .ballistae(UPDATED_BALLISTAE)
            .polearms(UPDATED_POLEARMS)
            .staff(UPDATED_STAFF)
            .coalmaking(UPDATED_COALMAKING)
            .milling(UPDATED_MILLING)
            .climbing(UPDATED_CLIMBING)
            .firemaking(UPDATED_FIREMAKING)
            .mining(UPDATED_MINING)
            .digging(UPDATED_DIGGING)
            .smithing(UPDATED_SMITHING)
            .metallurgy(UPDATED_METALLURGY)
            .bladessmithing(UPDATED_BLADESSMITHING)
            .weaponheadssmithing(UPDATED_WEAPONHEADSSMITHING)
            .armoursmithing(UPDATED_ARMOURSMITHING)
            .shieldsmithing(UPDATED_SHIELDSMITHING)
            .chainarmoursmithing(UPDATED_CHAINARMOURSMITHING)
            .leatherworking(UPDATED_LEATHERWORKING)
            .masonry(UPDATED_MASONRY)
            .dairyfoodmaking(UPDATED_DAIRYFOODMAKING)
            .nature(UPDATED_NATURE)
            .fishing(UPDATED_FISHING)
            .gardening(UPDATED_GARDENING)
            .botanizing(UPDATED_BOTANIZING)
            .animaltaming(UPDATED_ANIMALTAMING)
            .forestry(UPDATED_FORESTRY)
            .farming(UPDATED_FARMING)
            .animalhusbandry(UPDATED_ANIMALHUSBANDRY)
            .papyrusmaking(UPDATED_PAPYRUSMAKING)
            .toys(UPDATED_TOYS)
            .puppeteering(UPDATED_PUPPETEERING)
            .saw(UPDATED_SAW)
            .alchemy(UPDATED_ALCHEMY)
            .naturalsubstances(UPDATED_NATURALSUBSTANCES)
            .shields(UPDATED_SHIELDS)
            .smallwoodenshield(UPDATED_SMALLWOODENSHIELD)
            .smallmetalshield(UPDATED_SMALLMETALSHIELD)
            .largemetalshield(UPDATED_LARGEMETALSHIELD)
            .mediumwoodenshield(UPDATED_MEDIUMWOODENSHIELD)
            .axes(UPDATED_AXES)
            .largeaxe(UPDATED_LARGEAXE)
            .hugeaxe(UPDATED_HUGEAXE)
            .swords(UPDATED_SWORDS)
            .longsword(UPDATED_LONGSWORD)
            .shortsword(UPDATED_SHORTSWORD)
            .twohandedsword(UPDATED_TWOHANDEDSWORD)
            .butcheringknife(UPDATED_BUTCHERINGKNIFE)
            .bowyery(UPDATED_BOWYERY)
            .fletching(UPDATED_FLETCHING)
            .toymaking(UPDATED_TOYMAKING)
            .shipbuilding(UPDATED_SHIPBUILDING)
            .mind(UPDATED_MIND)
            .soul(UPDATED_SOUL)
            .souldepth(UPDATED_SOULDEPTH)
            .body(UPDATED_BODY)
            .faith(UPDATED_FAITH)
            .favor(UPDATED_FAVOR);

        restSkillsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSkills.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSkills))
            )
            .andExpect(status().isOk());

        // Validate the Skills in the database
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeUpdate);
        Skills testSkills = skillsList.get(skillsList.size() - 1);
        assertThat(testSkills.getDumptime()).isEqualTo(UPDATED_DUMPTIME);
        assertThat(testSkills.getPlayername()).isEqualTo(DEFAULT_PLAYERNAME);
        assertThat(testSkills.getPremium()).isEqualTo(UPDATED_PREMIUM);
        assertThat(testSkills.getServer()).isEqualTo(DEFAULT_SERVER);
        assertThat(testSkills.getReligion()).isEqualTo(DEFAULT_RELIGION);
        assertThat(testSkills.getPrayer()).isEqualTo(DEFAULT_PRAYER);
        assertThat(testSkills.getChanneling()).isEqualTo(UPDATED_CHANNELING);
        assertThat(testSkills.getPreaching()).isEqualTo(DEFAULT_PREACHING);
        assertThat(testSkills.getExorcism()).isEqualTo(UPDATED_EXORCISM);
        assertThat(testSkills.getHammers()).isEqualTo(DEFAULT_HAMMERS);
        assertThat(testSkills.getWarhammer()).isEqualTo(DEFAULT_WARHAMMER);
        assertThat(testSkills.getHealing()).isEqualTo(DEFAULT_HEALING);
        assertThat(testSkills.getFirstaid()).isEqualTo(DEFAULT_FIRSTAID);
        assertThat(testSkills.getClubs()).isEqualTo(DEFAULT_CLUBS);
        assertThat(testSkills.getHugeclub()).isEqualTo(DEFAULT_HUGECLUB);
        assertThat(testSkills.getArchery()).isEqualTo(DEFAULT_ARCHERY);
        assertThat(testSkills.getShortbow()).isEqualTo(UPDATED_SHORTBOW);
        assertThat(testSkills.getMediumbow()).isEqualTo(DEFAULT_MEDIUMBOW);
        assertThat(testSkills.getLongbow()).isEqualTo(DEFAULT_LONGBOW);
        assertThat(testSkills.getThievery()).isEqualTo(DEFAULT_THIEVERY);
        assertThat(testSkills.getStealing()).isEqualTo(UPDATED_STEALING);
        assertThat(testSkills.getLockpicking()).isEqualTo(UPDATED_LOCKPICKING);
        assertThat(testSkills.getTraps()).isEqualTo(DEFAULT_TRAPS);
        assertThat(testSkills.getWarmachines()).isEqualTo(UPDATED_WARMACHINES);
        assertThat(testSkills.getCatapults()).isEqualTo(UPDATED_CATAPULTS);
        assertThat(testSkills.getTrebuchets()).isEqualTo(UPDATED_TREBUCHETS);
        assertThat(testSkills.getBallistae()).isEqualTo(UPDATED_BALLISTAE);
        assertThat(testSkills.getPolearms()).isEqualTo(UPDATED_POLEARMS);
        assertThat(testSkills.getStaff()).isEqualTo(UPDATED_STAFF);
        assertThat(testSkills.getLongspear()).isEqualTo(DEFAULT_LONGSPEAR);
        assertThat(testSkills.getHalberd()).isEqualTo(DEFAULT_HALBERD);
        assertThat(testSkills.getProspecting()).isEqualTo(DEFAULT_PROSPECTING);
        assertThat(testSkills.getCoalmaking()).isEqualTo(UPDATED_COALMAKING);
        assertThat(testSkills.getMilling()).isEqualTo(UPDATED_MILLING);
        assertThat(testSkills.getTracking()).isEqualTo(DEFAULT_TRACKING);
        assertThat(testSkills.getPaving()).isEqualTo(DEFAULT_PAVING);
        assertThat(testSkills.getArchaeology()).isEqualTo(DEFAULT_ARCHAEOLOGY);
        assertThat(testSkills.getRestoration()).isEqualTo(DEFAULT_RESTORATION);
        assertThat(testSkills.getClimbing()).isEqualTo(UPDATED_CLIMBING);
        assertThat(testSkills.getThatching()).isEqualTo(DEFAULT_THATCHING);
        assertThat(testSkills.getFiremaking()).isEqualTo(UPDATED_FIREMAKING);
        assertThat(testSkills.getPottery()).isEqualTo(DEFAULT_POTTERY);
        assertThat(testSkills.getMining()).isEqualTo(UPDATED_MINING);
        assertThat(testSkills.getDigging()).isEqualTo(UPDATED_DIGGING);
        assertThat(testSkills.getRopemaking()).isEqualTo(DEFAULT_ROPEMAKING);
        assertThat(testSkills.getSmithing()).isEqualTo(UPDATED_SMITHING);
        assertThat(testSkills.getBlacksmithing()).isEqualTo(DEFAULT_BLACKSMITHING);
        assertThat(testSkills.getLocksmithing()).isEqualTo(DEFAULT_LOCKSMITHING);
        assertThat(testSkills.getJewelrysmithing()).isEqualTo(DEFAULT_JEWELRYSMITHING);
        assertThat(testSkills.getMetallurgy()).isEqualTo(UPDATED_METALLURGY);
        assertThat(testSkills.getWeaponsmithing()).isEqualTo(DEFAULT_WEAPONSMITHING);
        assertThat(testSkills.getBladessmithing()).isEqualTo(UPDATED_BLADESSMITHING);
        assertThat(testSkills.getWeaponheadssmithing()).isEqualTo(UPDATED_WEAPONHEADSSMITHING);
        assertThat(testSkills.getArmoursmithing()).isEqualTo(UPDATED_ARMOURSMITHING);
        assertThat(testSkills.getShieldsmithing()).isEqualTo(UPDATED_SHIELDSMITHING);
        assertThat(testSkills.getChainarmoursmithing()).isEqualTo(UPDATED_CHAINARMOURSMITHING);
        assertThat(testSkills.getPlatearmoursmithing()).isEqualTo(DEFAULT_PLATEARMOURSMITHING);
        assertThat(testSkills.getTailoring()).isEqualTo(DEFAULT_TAILORING);
        assertThat(testSkills.getClothtailoring()).isEqualTo(DEFAULT_CLOTHTAILORING);
        assertThat(testSkills.getLeatherworking()).isEqualTo(UPDATED_LEATHERWORKING);
        assertThat(testSkills.getMasonry()).isEqualTo(UPDATED_MASONRY);
        assertThat(testSkills.getStonecutting()).isEqualTo(DEFAULT_STONECUTTING);
        assertThat(testSkills.getCooking()).isEqualTo(DEFAULT_COOKING);
        assertThat(testSkills.getHotfoodcooking()).isEqualTo(DEFAULT_HOTFOODCOOKING);
        assertThat(testSkills.getBaking()).isEqualTo(DEFAULT_BAKING);
        assertThat(testSkills.getDairyfoodmaking()).isEqualTo(UPDATED_DAIRYFOODMAKING);
        assertThat(testSkills.getButchering()).isEqualTo(DEFAULT_BUTCHERING);
        assertThat(testSkills.getBeverages()).isEqualTo(DEFAULT_BEVERAGES);
        assertThat(testSkills.getNature()).isEqualTo(UPDATED_NATURE);
        assertThat(testSkills.getFishing()).isEqualTo(UPDATED_FISHING);
        assertThat(testSkills.getGardening()).isEqualTo(UPDATED_GARDENING);
        assertThat(testSkills.getForaging()).isEqualTo(DEFAULT_FORAGING);
        assertThat(testSkills.getBotanizing()).isEqualTo(UPDATED_BOTANIZING);
        assertThat(testSkills.getAnimaltaming()).isEqualTo(UPDATED_ANIMALTAMING);
        assertThat(testSkills.getForestry()).isEqualTo(UPDATED_FORESTRY);
        assertThat(testSkills.getFarming()).isEqualTo(UPDATED_FARMING);
        assertThat(testSkills.getMilking()).isEqualTo(DEFAULT_MILKING);
        assertThat(testSkills.getMeditating()).isEqualTo(DEFAULT_MEDITATING);
        assertThat(testSkills.getAnimalhusbandry()).isEqualTo(UPDATED_ANIMALHUSBANDRY);
        assertThat(testSkills.getPapyrusmaking()).isEqualTo(UPDATED_PAPYRUSMAKING);
        assertThat(testSkills.getToys()).isEqualTo(UPDATED_TOYS);
        assertThat(testSkills.getYoyo()).isEqualTo(DEFAULT_YOYO);
        assertThat(testSkills.getPuppeteering()).isEqualTo(UPDATED_PUPPETEERING);
        assertThat(testSkills.getFighting()).isEqualTo(DEFAULT_FIGHTING);
        assertThat(testSkills.getDefensivefighting()).isEqualTo(DEFAULT_DEFENSIVEFIGHTING);
        assertThat(testSkills.getNormalfighting()).isEqualTo(DEFAULT_NORMALFIGHTING);
        assertThat(testSkills.getWeaponlessfighting()).isEqualTo(DEFAULT_WEAPONLESSFIGHTING);
        assertThat(testSkills.getAggressivefighting()).isEqualTo(DEFAULT_AGGRESSIVEFIGHTING);
        assertThat(testSkills.getShieldbashing()).isEqualTo(DEFAULT_SHIELDBASHING);
        assertThat(testSkills.getTaunting()).isEqualTo(DEFAULT_TAUNTING);
        assertThat(testSkills.getMiscellaneousitems()).isEqualTo(DEFAULT_MISCELLANEOUSITEMS);
        assertThat(testSkills.getShovel()).isEqualTo(DEFAULT_SHOVEL);
        assertThat(testSkills.getRake()).isEqualTo(DEFAULT_RAKE);
        assertThat(testSkills.getSaw()).isEqualTo(UPDATED_SAW);
        assertThat(testSkills.getPickaxe()).isEqualTo(DEFAULT_PICKAXE);
        assertThat(testSkills.getRepairing()).isEqualTo(DEFAULT_REPAIRING);
        assertThat(testSkills.getSickle()).isEqualTo(DEFAULT_SICKLE);
        assertThat(testSkills.getScythe()).isEqualTo(DEFAULT_SCYTHE);
        assertThat(testSkills.getHammer()).isEqualTo(DEFAULT_HAMMER);
        assertThat(testSkills.getStonechisel()).isEqualTo(DEFAULT_STONECHISEL);
        assertThat(testSkills.getAlchemy()).isEqualTo(UPDATED_ALCHEMY);
        assertThat(testSkills.getNaturalsubstances()).isEqualTo(UPDATED_NATURALSUBSTANCES);
        assertThat(testSkills.getShields()).isEqualTo(UPDATED_SHIELDS);
        assertThat(testSkills.getMediummetalshield()).isEqualTo(DEFAULT_MEDIUMMETALSHIELD);
        assertThat(testSkills.getSmallwoodenshield()).isEqualTo(UPDATED_SMALLWOODENSHIELD);
        assertThat(testSkills.getSmallmetalshield()).isEqualTo(UPDATED_SMALLMETALSHIELD);
        assertThat(testSkills.getLargemetalshield()).isEqualTo(UPDATED_LARGEMETALSHIELD);
        assertThat(testSkills.getMediumwoodenshield()).isEqualTo(UPDATED_MEDIUMWOODENSHIELD);
        assertThat(testSkills.getLargewoodenshield()).isEqualTo(DEFAULT_LARGEWOODENSHIELD);
        assertThat(testSkills.getAxes()).isEqualTo(UPDATED_AXES);
        assertThat(testSkills.getHatchet()).isEqualTo(DEFAULT_HATCHET);
        assertThat(testSkills.getSmallaxe()).isEqualTo(DEFAULT_SMALLAXE);
        assertThat(testSkills.getLargeaxe()).isEqualTo(UPDATED_LARGEAXE);
        assertThat(testSkills.getHugeaxe()).isEqualTo(UPDATED_HUGEAXE);
        assertThat(testSkills.getSwords()).isEqualTo(UPDATED_SWORDS);
        assertThat(testSkills.getLongsword()).isEqualTo(UPDATED_LONGSWORD);
        assertThat(testSkills.getShortsword()).isEqualTo(UPDATED_SHORTSWORD);
        assertThat(testSkills.getTwohandedsword()).isEqualTo(UPDATED_TWOHANDEDSWORD);
        assertThat(testSkills.getKnives()).isEqualTo(DEFAULT_KNIVES);
        assertThat(testSkills.getCarvingknife()).isEqualTo(DEFAULT_CARVINGKNIFE);
        assertThat(testSkills.getButcheringknife()).isEqualTo(UPDATED_BUTCHERINGKNIFE);
        assertThat(testSkills.getWoodcutting()).isEqualTo(DEFAULT_WOODCUTTING);
        assertThat(testSkills.getMauls()).isEqualTo(DEFAULT_MAULS);
        assertThat(testSkills.getMediummaul()).isEqualTo(DEFAULT_MEDIUMMAUL);
        assertThat(testSkills.getSmallmaul()).isEqualTo(DEFAULT_SMALLMAUL);
        assertThat(testSkills.getLargemaul()).isEqualTo(DEFAULT_LARGEMAUL);
        assertThat(testSkills.getCarpentry()).isEqualTo(DEFAULT_CARPENTRY);
        assertThat(testSkills.getBowyery()).isEqualTo(UPDATED_BOWYERY);
        assertThat(testSkills.getFletching()).isEqualTo(UPDATED_FLETCHING);
        assertThat(testSkills.getFinecarpentry()).isEqualTo(DEFAULT_FINECARPENTRY);
        assertThat(testSkills.getToymaking()).isEqualTo(UPDATED_TOYMAKING);
        assertThat(testSkills.getShipbuilding()).isEqualTo(UPDATED_SHIPBUILDING);
        assertThat(testSkills.getMind()).isEqualTo(UPDATED_MIND);
        assertThat(testSkills.getMindlogic()).isEqualTo(DEFAULT_MINDLOGIC);
        assertThat(testSkills.getMindspeed()).isEqualTo(DEFAULT_MINDSPEED);
        assertThat(testSkills.getSoul()).isEqualTo(UPDATED_SOUL);
        assertThat(testSkills.getSouldepth()).isEqualTo(UPDATED_SOULDEPTH);
        assertThat(testSkills.getSoulstrength()).isEqualTo(DEFAULT_SOULSTRENGTH);
        assertThat(testSkills.getBody()).isEqualTo(UPDATED_BODY);
        assertThat(testSkills.getBodystrength()).isEqualTo(DEFAULT_BODYSTRENGTH);
        assertThat(testSkills.getBodystamina()).isEqualTo(DEFAULT_BODYSTAMINA);
        assertThat(testSkills.getBodycontrol()).isEqualTo(DEFAULT_BODYCONTROL);
        assertThat(testSkills.getFaith()).isEqualTo(UPDATED_FAITH);
        assertThat(testSkills.getFavor()).isEqualTo(UPDATED_FAVOR);
        assertThat(testSkills.getAlignment()).isEqualTo(DEFAULT_ALIGNMENT);
    }

    @Test
    @Transactional
    void fullUpdateSkillsWithPatch() throws Exception {
        // Initialize the database
        skillsRepository.saveAndFlush(skills);

        int databaseSizeBeforeUpdate = skillsRepository.findAll().size();

        // Update the skills using partial update
        Skills partialUpdatedSkills = new Skills();
        partialUpdatedSkills.setId(skills.getId());

        partialUpdatedSkills
            .dumptime(UPDATED_DUMPTIME)
            .playername(UPDATED_PLAYERNAME)
            .premium(UPDATED_PREMIUM)
            .server(UPDATED_SERVER)
            .religion(UPDATED_RELIGION)
            .prayer(UPDATED_PRAYER)
            .channeling(UPDATED_CHANNELING)
            .preaching(UPDATED_PREACHING)
            .exorcism(UPDATED_EXORCISM)
            .hammers(UPDATED_HAMMERS)
            .warhammer(UPDATED_WARHAMMER)
            .healing(UPDATED_HEALING)
            .firstaid(UPDATED_FIRSTAID)
            .clubs(UPDATED_CLUBS)
            .hugeclub(UPDATED_HUGECLUB)
            .archery(UPDATED_ARCHERY)
            .shortbow(UPDATED_SHORTBOW)
            .mediumbow(UPDATED_MEDIUMBOW)
            .longbow(UPDATED_LONGBOW)
            .thievery(UPDATED_THIEVERY)
            .stealing(UPDATED_STEALING)
            .lockpicking(UPDATED_LOCKPICKING)
            .traps(UPDATED_TRAPS)
            .warmachines(UPDATED_WARMACHINES)
            .catapults(UPDATED_CATAPULTS)
            .trebuchets(UPDATED_TREBUCHETS)
            .ballistae(UPDATED_BALLISTAE)
            .polearms(UPDATED_POLEARMS)
            .staff(UPDATED_STAFF)
            .longspear(UPDATED_LONGSPEAR)
            .halberd(UPDATED_HALBERD)
            .prospecting(UPDATED_PROSPECTING)
            .coalmaking(UPDATED_COALMAKING)
            .milling(UPDATED_MILLING)
            .tracking(UPDATED_TRACKING)
            .paving(UPDATED_PAVING)
            .archaeology(UPDATED_ARCHAEOLOGY)
            .restoration(UPDATED_RESTORATION)
            .climbing(UPDATED_CLIMBING)
            .thatching(UPDATED_THATCHING)
            .firemaking(UPDATED_FIREMAKING)
            .pottery(UPDATED_POTTERY)
            .mining(UPDATED_MINING)
            .digging(UPDATED_DIGGING)
            .ropemaking(UPDATED_ROPEMAKING)
            .smithing(UPDATED_SMITHING)
            .blacksmithing(UPDATED_BLACKSMITHING)
            .locksmithing(UPDATED_LOCKSMITHING)
            .jewelrysmithing(UPDATED_JEWELRYSMITHING)
            .metallurgy(UPDATED_METALLURGY)
            .weaponsmithing(UPDATED_WEAPONSMITHING)
            .bladessmithing(UPDATED_BLADESSMITHING)
            .weaponheadssmithing(UPDATED_WEAPONHEADSSMITHING)
            .armoursmithing(UPDATED_ARMOURSMITHING)
            .shieldsmithing(UPDATED_SHIELDSMITHING)
            .chainarmoursmithing(UPDATED_CHAINARMOURSMITHING)
            .platearmoursmithing(UPDATED_PLATEARMOURSMITHING)
            .tailoring(UPDATED_TAILORING)
            .clothtailoring(UPDATED_CLOTHTAILORING)
            .leatherworking(UPDATED_LEATHERWORKING)
            .masonry(UPDATED_MASONRY)
            .stonecutting(UPDATED_STONECUTTING)
            .cooking(UPDATED_COOKING)
            .hotfoodcooking(UPDATED_HOTFOODCOOKING)
            .baking(UPDATED_BAKING)
            .dairyfoodmaking(UPDATED_DAIRYFOODMAKING)
            .butchering(UPDATED_BUTCHERING)
            .beverages(UPDATED_BEVERAGES)
            .nature(UPDATED_NATURE)
            .fishing(UPDATED_FISHING)
            .gardening(UPDATED_GARDENING)
            .foraging(UPDATED_FORAGING)
            .botanizing(UPDATED_BOTANIZING)
            .animaltaming(UPDATED_ANIMALTAMING)
            .forestry(UPDATED_FORESTRY)
            .farming(UPDATED_FARMING)
            .milking(UPDATED_MILKING)
            .meditating(UPDATED_MEDITATING)
            .animalhusbandry(UPDATED_ANIMALHUSBANDRY)
            .papyrusmaking(UPDATED_PAPYRUSMAKING)
            .toys(UPDATED_TOYS)
            .yoyo(UPDATED_YOYO)
            .puppeteering(UPDATED_PUPPETEERING)
            .fighting(UPDATED_FIGHTING)
            .defensivefighting(UPDATED_DEFENSIVEFIGHTING)
            .normalfighting(UPDATED_NORMALFIGHTING)
            .weaponlessfighting(UPDATED_WEAPONLESSFIGHTING)
            .aggressivefighting(UPDATED_AGGRESSIVEFIGHTING)
            .shieldbashing(UPDATED_SHIELDBASHING)
            .taunting(UPDATED_TAUNTING)
            .miscellaneousitems(UPDATED_MISCELLANEOUSITEMS)
            .shovel(UPDATED_SHOVEL)
            .rake(UPDATED_RAKE)
            .saw(UPDATED_SAW)
            .pickaxe(UPDATED_PICKAXE)
            .repairing(UPDATED_REPAIRING)
            .sickle(UPDATED_SICKLE)
            .scythe(UPDATED_SCYTHE)
            .hammer(UPDATED_HAMMER)
            .stonechisel(UPDATED_STONECHISEL)
            .alchemy(UPDATED_ALCHEMY)
            .naturalsubstances(UPDATED_NATURALSUBSTANCES)
            .shields(UPDATED_SHIELDS)
            .mediummetalshield(UPDATED_MEDIUMMETALSHIELD)
            .smallwoodenshield(UPDATED_SMALLWOODENSHIELD)
            .smallmetalshield(UPDATED_SMALLMETALSHIELD)
            .largemetalshield(UPDATED_LARGEMETALSHIELD)
            .mediumwoodenshield(UPDATED_MEDIUMWOODENSHIELD)
            .largewoodenshield(UPDATED_LARGEWOODENSHIELD)
            .axes(UPDATED_AXES)
            .hatchet(UPDATED_HATCHET)
            .smallaxe(UPDATED_SMALLAXE)
            .largeaxe(UPDATED_LARGEAXE)
            .hugeaxe(UPDATED_HUGEAXE)
            .swords(UPDATED_SWORDS)
            .longsword(UPDATED_LONGSWORD)
            .shortsword(UPDATED_SHORTSWORD)
            .twohandedsword(UPDATED_TWOHANDEDSWORD)
            .knives(UPDATED_KNIVES)
            .carvingknife(UPDATED_CARVINGKNIFE)
            .butcheringknife(UPDATED_BUTCHERINGKNIFE)
            .woodcutting(UPDATED_WOODCUTTING)
            .mauls(UPDATED_MAULS)
            .mediummaul(UPDATED_MEDIUMMAUL)
            .smallmaul(UPDATED_SMALLMAUL)
            .largemaul(UPDATED_LARGEMAUL)
            .carpentry(UPDATED_CARPENTRY)
            .bowyery(UPDATED_BOWYERY)
            .fletching(UPDATED_FLETCHING)
            .finecarpentry(UPDATED_FINECARPENTRY)
            .toymaking(UPDATED_TOYMAKING)
            .shipbuilding(UPDATED_SHIPBUILDING)
            .mind(UPDATED_MIND)
            .mindlogic(UPDATED_MINDLOGIC)
            .mindspeed(UPDATED_MINDSPEED)
            .soul(UPDATED_SOUL)
            .souldepth(UPDATED_SOULDEPTH)
            .soulstrength(UPDATED_SOULSTRENGTH)
            .body(UPDATED_BODY)
            .bodystrength(UPDATED_BODYSTRENGTH)
            .bodystamina(UPDATED_BODYSTAMINA)
            .bodycontrol(UPDATED_BODYCONTROL)
            .faith(UPDATED_FAITH)
            .favor(UPDATED_FAVOR)
            .alignment(UPDATED_ALIGNMENT);

        restSkillsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSkills.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSkills))
            )
            .andExpect(status().isOk());

        // Validate the Skills in the database
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeUpdate);
        Skills testSkills = skillsList.get(skillsList.size() - 1);
        assertThat(testSkills.getDumptime()).isEqualTo(UPDATED_DUMPTIME);
        assertThat(testSkills.getPlayername()).isEqualTo(UPDATED_PLAYERNAME);
        assertThat(testSkills.getPremium()).isEqualTo(UPDATED_PREMIUM);
        assertThat(testSkills.getServer()).isEqualTo(UPDATED_SERVER);
        assertThat(testSkills.getReligion()).isEqualTo(UPDATED_RELIGION);
        assertThat(testSkills.getPrayer()).isEqualTo(UPDATED_PRAYER);
        assertThat(testSkills.getChanneling()).isEqualTo(UPDATED_CHANNELING);
        assertThat(testSkills.getPreaching()).isEqualTo(UPDATED_PREACHING);
        assertThat(testSkills.getExorcism()).isEqualTo(UPDATED_EXORCISM);
        assertThat(testSkills.getHammers()).isEqualTo(UPDATED_HAMMERS);
        assertThat(testSkills.getWarhammer()).isEqualTo(UPDATED_WARHAMMER);
        assertThat(testSkills.getHealing()).isEqualTo(UPDATED_HEALING);
        assertThat(testSkills.getFirstaid()).isEqualTo(UPDATED_FIRSTAID);
        assertThat(testSkills.getClubs()).isEqualTo(UPDATED_CLUBS);
        assertThat(testSkills.getHugeclub()).isEqualTo(UPDATED_HUGECLUB);
        assertThat(testSkills.getArchery()).isEqualTo(UPDATED_ARCHERY);
        assertThat(testSkills.getShortbow()).isEqualTo(UPDATED_SHORTBOW);
        assertThat(testSkills.getMediumbow()).isEqualTo(UPDATED_MEDIUMBOW);
        assertThat(testSkills.getLongbow()).isEqualTo(UPDATED_LONGBOW);
        assertThat(testSkills.getThievery()).isEqualTo(UPDATED_THIEVERY);
        assertThat(testSkills.getStealing()).isEqualTo(UPDATED_STEALING);
        assertThat(testSkills.getLockpicking()).isEqualTo(UPDATED_LOCKPICKING);
        assertThat(testSkills.getTraps()).isEqualTo(UPDATED_TRAPS);
        assertThat(testSkills.getWarmachines()).isEqualTo(UPDATED_WARMACHINES);
        assertThat(testSkills.getCatapults()).isEqualTo(UPDATED_CATAPULTS);
        assertThat(testSkills.getTrebuchets()).isEqualTo(UPDATED_TREBUCHETS);
        assertThat(testSkills.getBallistae()).isEqualTo(UPDATED_BALLISTAE);
        assertThat(testSkills.getPolearms()).isEqualTo(UPDATED_POLEARMS);
        assertThat(testSkills.getStaff()).isEqualTo(UPDATED_STAFF);
        assertThat(testSkills.getLongspear()).isEqualTo(UPDATED_LONGSPEAR);
        assertThat(testSkills.getHalberd()).isEqualTo(UPDATED_HALBERD);
        assertThat(testSkills.getProspecting()).isEqualTo(UPDATED_PROSPECTING);
        assertThat(testSkills.getCoalmaking()).isEqualTo(UPDATED_COALMAKING);
        assertThat(testSkills.getMilling()).isEqualTo(UPDATED_MILLING);
        assertThat(testSkills.getTracking()).isEqualTo(UPDATED_TRACKING);
        assertThat(testSkills.getPaving()).isEqualTo(UPDATED_PAVING);
        assertThat(testSkills.getArchaeology()).isEqualTo(UPDATED_ARCHAEOLOGY);
        assertThat(testSkills.getRestoration()).isEqualTo(UPDATED_RESTORATION);
        assertThat(testSkills.getClimbing()).isEqualTo(UPDATED_CLIMBING);
        assertThat(testSkills.getThatching()).isEqualTo(UPDATED_THATCHING);
        assertThat(testSkills.getFiremaking()).isEqualTo(UPDATED_FIREMAKING);
        assertThat(testSkills.getPottery()).isEqualTo(UPDATED_POTTERY);
        assertThat(testSkills.getMining()).isEqualTo(UPDATED_MINING);
        assertThat(testSkills.getDigging()).isEqualTo(UPDATED_DIGGING);
        assertThat(testSkills.getRopemaking()).isEqualTo(UPDATED_ROPEMAKING);
        assertThat(testSkills.getSmithing()).isEqualTo(UPDATED_SMITHING);
        assertThat(testSkills.getBlacksmithing()).isEqualTo(UPDATED_BLACKSMITHING);
        assertThat(testSkills.getLocksmithing()).isEqualTo(UPDATED_LOCKSMITHING);
        assertThat(testSkills.getJewelrysmithing()).isEqualTo(UPDATED_JEWELRYSMITHING);
        assertThat(testSkills.getMetallurgy()).isEqualTo(UPDATED_METALLURGY);
        assertThat(testSkills.getWeaponsmithing()).isEqualTo(UPDATED_WEAPONSMITHING);
        assertThat(testSkills.getBladessmithing()).isEqualTo(UPDATED_BLADESSMITHING);
        assertThat(testSkills.getWeaponheadssmithing()).isEqualTo(UPDATED_WEAPONHEADSSMITHING);
        assertThat(testSkills.getArmoursmithing()).isEqualTo(UPDATED_ARMOURSMITHING);
        assertThat(testSkills.getShieldsmithing()).isEqualTo(UPDATED_SHIELDSMITHING);
        assertThat(testSkills.getChainarmoursmithing()).isEqualTo(UPDATED_CHAINARMOURSMITHING);
        assertThat(testSkills.getPlatearmoursmithing()).isEqualTo(UPDATED_PLATEARMOURSMITHING);
        assertThat(testSkills.getTailoring()).isEqualTo(UPDATED_TAILORING);
        assertThat(testSkills.getClothtailoring()).isEqualTo(UPDATED_CLOTHTAILORING);
        assertThat(testSkills.getLeatherworking()).isEqualTo(UPDATED_LEATHERWORKING);
        assertThat(testSkills.getMasonry()).isEqualTo(UPDATED_MASONRY);
        assertThat(testSkills.getStonecutting()).isEqualTo(UPDATED_STONECUTTING);
        assertThat(testSkills.getCooking()).isEqualTo(UPDATED_COOKING);
        assertThat(testSkills.getHotfoodcooking()).isEqualTo(UPDATED_HOTFOODCOOKING);
        assertThat(testSkills.getBaking()).isEqualTo(UPDATED_BAKING);
        assertThat(testSkills.getDairyfoodmaking()).isEqualTo(UPDATED_DAIRYFOODMAKING);
        assertThat(testSkills.getButchering()).isEqualTo(UPDATED_BUTCHERING);
        assertThat(testSkills.getBeverages()).isEqualTo(UPDATED_BEVERAGES);
        assertThat(testSkills.getNature()).isEqualTo(UPDATED_NATURE);
        assertThat(testSkills.getFishing()).isEqualTo(UPDATED_FISHING);
        assertThat(testSkills.getGardening()).isEqualTo(UPDATED_GARDENING);
        assertThat(testSkills.getForaging()).isEqualTo(UPDATED_FORAGING);
        assertThat(testSkills.getBotanizing()).isEqualTo(UPDATED_BOTANIZING);
        assertThat(testSkills.getAnimaltaming()).isEqualTo(UPDATED_ANIMALTAMING);
        assertThat(testSkills.getForestry()).isEqualTo(UPDATED_FORESTRY);
        assertThat(testSkills.getFarming()).isEqualTo(UPDATED_FARMING);
        assertThat(testSkills.getMilking()).isEqualTo(UPDATED_MILKING);
        assertThat(testSkills.getMeditating()).isEqualTo(UPDATED_MEDITATING);
        assertThat(testSkills.getAnimalhusbandry()).isEqualTo(UPDATED_ANIMALHUSBANDRY);
        assertThat(testSkills.getPapyrusmaking()).isEqualTo(UPDATED_PAPYRUSMAKING);
        assertThat(testSkills.getToys()).isEqualTo(UPDATED_TOYS);
        assertThat(testSkills.getYoyo()).isEqualTo(UPDATED_YOYO);
        assertThat(testSkills.getPuppeteering()).isEqualTo(UPDATED_PUPPETEERING);
        assertThat(testSkills.getFighting()).isEqualTo(UPDATED_FIGHTING);
        assertThat(testSkills.getDefensivefighting()).isEqualTo(UPDATED_DEFENSIVEFIGHTING);
        assertThat(testSkills.getNormalfighting()).isEqualTo(UPDATED_NORMALFIGHTING);
        assertThat(testSkills.getWeaponlessfighting()).isEqualTo(UPDATED_WEAPONLESSFIGHTING);
        assertThat(testSkills.getAggressivefighting()).isEqualTo(UPDATED_AGGRESSIVEFIGHTING);
        assertThat(testSkills.getShieldbashing()).isEqualTo(UPDATED_SHIELDBASHING);
        assertThat(testSkills.getTaunting()).isEqualTo(UPDATED_TAUNTING);
        assertThat(testSkills.getMiscellaneousitems()).isEqualTo(UPDATED_MISCELLANEOUSITEMS);
        assertThat(testSkills.getShovel()).isEqualTo(UPDATED_SHOVEL);
        assertThat(testSkills.getRake()).isEqualTo(UPDATED_RAKE);
        assertThat(testSkills.getSaw()).isEqualTo(UPDATED_SAW);
        assertThat(testSkills.getPickaxe()).isEqualTo(UPDATED_PICKAXE);
        assertThat(testSkills.getRepairing()).isEqualTo(UPDATED_REPAIRING);
        assertThat(testSkills.getSickle()).isEqualTo(UPDATED_SICKLE);
        assertThat(testSkills.getScythe()).isEqualTo(UPDATED_SCYTHE);
        assertThat(testSkills.getHammer()).isEqualTo(UPDATED_HAMMER);
        assertThat(testSkills.getStonechisel()).isEqualTo(UPDATED_STONECHISEL);
        assertThat(testSkills.getAlchemy()).isEqualTo(UPDATED_ALCHEMY);
        assertThat(testSkills.getNaturalsubstances()).isEqualTo(UPDATED_NATURALSUBSTANCES);
        assertThat(testSkills.getShields()).isEqualTo(UPDATED_SHIELDS);
        assertThat(testSkills.getMediummetalshield()).isEqualTo(UPDATED_MEDIUMMETALSHIELD);
        assertThat(testSkills.getSmallwoodenshield()).isEqualTo(UPDATED_SMALLWOODENSHIELD);
        assertThat(testSkills.getSmallmetalshield()).isEqualTo(UPDATED_SMALLMETALSHIELD);
        assertThat(testSkills.getLargemetalshield()).isEqualTo(UPDATED_LARGEMETALSHIELD);
        assertThat(testSkills.getMediumwoodenshield()).isEqualTo(UPDATED_MEDIUMWOODENSHIELD);
        assertThat(testSkills.getLargewoodenshield()).isEqualTo(UPDATED_LARGEWOODENSHIELD);
        assertThat(testSkills.getAxes()).isEqualTo(UPDATED_AXES);
        assertThat(testSkills.getHatchet()).isEqualTo(UPDATED_HATCHET);
        assertThat(testSkills.getSmallaxe()).isEqualTo(UPDATED_SMALLAXE);
        assertThat(testSkills.getLargeaxe()).isEqualTo(UPDATED_LARGEAXE);
        assertThat(testSkills.getHugeaxe()).isEqualTo(UPDATED_HUGEAXE);
        assertThat(testSkills.getSwords()).isEqualTo(UPDATED_SWORDS);
        assertThat(testSkills.getLongsword()).isEqualTo(UPDATED_LONGSWORD);
        assertThat(testSkills.getShortsword()).isEqualTo(UPDATED_SHORTSWORD);
        assertThat(testSkills.getTwohandedsword()).isEqualTo(UPDATED_TWOHANDEDSWORD);
        assertThat(testSkills.getKnives()).isEqualTo(UPDATED_KNIVES);
        assertThat(testSkills.getCarvingknife()).isEqualTo(UPDATED_CARVINGKNIFE);
        assertThat(testSkills.getButcheringknife()).isEqualTo(UPDATED_BUTCHERINGKNIFE);
        assertThat(testSkills.getWoodcutting()).isEqualTo(UPDATED_WOODCUTTING);
        assertThat(testSkills.getMauls()).isEqualTo(UPDATED_MAULS);
        assertThat(testSkills.getMediummaul()).isEqualTo(UPDATED_MEDIUMMAUL);
        assertThat(testSkills.getSmallmaul()).isEqualTo(UPDATED_SMALLMAUL);
        assertThat(testSkills.getLargemaul()).isEqualTo(UPDATED_LARGEMAUL);
        assertThat(testSkills.getCarpentry()).isEqualTo(UPDATED_CARPENTRY);
        assertThat(testSkills.getBowyery()).isEqualTo(UPDATED_BOWYERY);
        assertThat(testSkills.getFletching()).isEqualTo(UPDATED_FLETCHING);
        assertThat(testSkills.getFinecarpentry()).isEqualTo(UPDATED_FINECARPENTRY);
        assertThat(testSkills.getToymaking()).isEqualTo(UPDATED_TOYMAKING);
        assertThat(testSkills.getShipbuilding()).isEqualTo(UPDATED_SHIPBUILDING);
        assertThat(testSkills.getMind()).isEqualTo(UPDATED_MIND);
        assertThat(testSkills.getMindlogic()).isEqualTo(UPDATED_MINDLOGIC);
        assertThat(testSkills.getMindspeed()).isEqualTo(UPDATED_MINDSPEED);
        assertThat(testSkills.getSoul()).isEqualTo(UPDATED_SOUL);
        assertThat(testSkills.getSouldepth()).isEqualTo(UPDATED_SOULDEPTH);
        assertThat(testSkills.getSoulstrength()).isEqualTo(UPDATED_SOULSTRENGTH);
        assertThat(testSkills.getBody()).isEqualTo(UPDATED_BODY);
        assertThat(testSkills.getBodystrength()).isEqualTo(UPDATED_BODYSTRENGTH);
        assertThat(testSkills.getBodystamina()).isEqualTo(UPDATED_BODYSTAMINA);
        assertThat(testSkills.getBodycontrol()).isEqualTo(UPDATED_BODYCONTROL);
        assertThat(testSkills.getFaith()).isEqualTo(UPDATED_FAITH);
        assertThat(testSkills.getFavor()).isEqualTo(UPDATED_FAVOR);
        assertThat(testSkills.getAlignment()).isEqualTo(UPDATED_ALIGNMENT);
    }

    @Test
    @Transactional
    void patchNonExistingSkills() throws Exception {
        int databaseSizeBeforeUpdate = skillsRepository.findAll().size();
        skills.setId(count.incrementAndGet());

        // Create the Skills
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSkillsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, skillsDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(skillsDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Skills in the database
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchSkills() throws Exception {
        int databaseSizeBeforeUpdate = skillsRepository.findAll().size();
        skills.setId(count.incrementAndGet());

        // Create the Skills
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSkillsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(skillsDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Skills in the database
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamSkills() throws Exception {
        int databaseSizeBeforeUpdate = skillsRepository.findAll().size();
        skills.setId(count.incrementAndGet());

        // Create the Skills
        SkillsDTO skillsDTO = skillsMapper.toDto(skills);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSkillsMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(skillsDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Skills in the database
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteSkills() throws Exception {
        // Initialize the database
        skillsRepository.saveAndFlush(skills);

        int databaseSizeBeforeDelete = skillsRepository.findAll().size();

        // Delete the skills
        restSkillsMockMvc
            .perform(delete(ENTITY_API_URL_ID, skills.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Skills> skillsList = skillsRepository.findAll();
        assertThat(skillsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
