package net.northern.verasm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Skills.
 */
@Entity
@Table(name = "skills")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Skills implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "dumptime", nullable = false, unique = true)
    private String dumptime;

    @NotNull
    @Column(name = "playername", nullable = false)
    private String playername;

    @NotNull
    @Column(name = "premium", nullable = false)
    private String premium;

    @NotNull
    @Column(name = "server", nullable = false)
    private String server;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "religion", nullable = false)
    private Double religion;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "prayer", nullable = false)
    private Double prayer;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "channeling", nullable = false)
    private Double channeling;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "preaching", nullable = false)
    private Double preaching;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "exorcism", nullable = false)
    private Double exorcism;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "hammers", nullable = false)
    private Double hammers;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "warhammer", nullable = false)
    private Double warhammer;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "healing", nullable = false)
    private Double healing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "firstaid", nullable = false)
    private Double firstaid;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "clubs", nullable = false)
    private Double clubs;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "hugeclub", nullable = false)
    private Double hugeclub;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "archery", nullable = false)
    private Double archery;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "shortbow", nullable = false)
    private Double shortbow;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "mediumbow", nullable = false)
    private Double mediumbow;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "longbow", nullable = false)
    private Double longbow;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "thievery", nullable = false)
    private Double thievery;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "stealing", nullable = false)
    private Double stealing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "lockpicking", nullable = false)
    private Double lockpicking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "traps", nullable = false)
    private Double traps;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "warmachines", nullable = false)
    private Double warmachines;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "catapults", nullable = false)
    private Double catapults;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "trebuchets", nullable = false)
    private Double trebuchets;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "ballistae", nullable = false)
    private Double ballistae;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "polearms", nullable = false)
    private Double polearms;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "staff", nullable = false)
    private Double staff;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "longspear", nullable = false)
    private Double longspear;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "halberd", nullable = false)
    private Double halberd;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "prospecting", nullable = false)
    private Double prospecting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "coalmaking", nullable = false)
    private Double coalmaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "milling", nullable = false)
    private Double milling;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "tracking", nullable = false)
    private Double tracking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "paving", nullable = false)
    private Double paving;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "archaeology", nullable = false)
    private Double archaeology;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "restoration", nullable = false)
    private Double restoration;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "climbing", nullable = false)
    private Double climbing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "thatching", nullable = false)
    private Double thatching;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "firemaking", nullable = false)
    private Double firemaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "pottery", nullable = false)
    private Double pottery;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "mining", nullable = false)
    private Double mining;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "digging", nullable = false)
    private Double digging;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "ropemaking", nullable = false)
    private Double ropemaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "smithing", nullable = false)
    private Double smithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "blacksmithing", nullable = false)
    private Double blacksmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "locksmithing", nullable = false)
    private Double locksmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "jewelrysmithing", nullable = false)
    private Double jewelrysmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "metallurgy", nullable = false)
    private Double metallurgy;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "weaponsmithing", nullable = false)
    private Double weaponsmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "bladessmithing", nullable = false)
    private Double bladessmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "weaponheadssmithing", nullable = false)
    private Double weaponheadssmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "armoursmithing", nullable = false)
    private Double armoursmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "shieldsmithing", nullable = false)
    private Double shieldsmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "chainarmoursmithing", nullable = false)
    private Double chainarmoursmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "platearmoursmithing", nullable = false)
    private Double platearmoursmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "tailoring", nullable = false)
    private Double tailoring;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "clothtailoring", nullable = false)
    private Double clothtailoring;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "leatherworking", nullable = false)
    private Double leatherworking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "masonry", nullable = false)
    private Double masonry;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "stonecutting", nullable = false)
    private Double stonecutting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "cooking", nullable = false)
    private Double cooking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "hotfoodcooking", nullable = false)
    private Double hotfoodcooking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "baking", nullable = false)
    private Double baking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "dairyfoodmaking", nullable = false)
    private Double dairyfoodmaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "butchering", nullable = false)
    private Double butchering;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "beverages", nullable = false)
    private Double beverages;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "nature", nullable = false)
    private Double nature;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "fishing", nullable = false)
    private Double fishing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "gardening", nullable = false)
    private Double gardening;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "foraging", nullable = false)
    private Double foraging;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "botanizing", nullable = false)
    private Double botanizing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "animaltaming", nullable = false)
    private Double animaltaming;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "forestry", nullable = false)
    private Double forestry;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "farming", nullable = false)
    private Double farming;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "milking", nullable = false)
    private Double milking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "meditating", nullable = false)
    private Double meditating;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "animalhusbandry", nullable = false)
    private Double animalhusbandry;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "papyrusmaking", nullable = false)
    private Double papyrusmaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "toys", nullable = false)
    private Double toys;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "yoyo", nullable = false)
    private Double yoyo;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "puppeteering", nullable = false)
    private Double puppeteering;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "fighting", nullable = false)
    private Double fighting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "defensivefighting", nullable = false)
    private Double defensivefighting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "normalfighting", nullable = false)
    private Double normalfighting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "weaponlessfighting", nullable = false)
    private Double weaponlessfighting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "aggressivefighting", nullable = false)
    private Double aggressivefighting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "shieldbashing", nullable = false)
    private Double shieldbashing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "taunting", nullable = false)
    private Double taunting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "miscellaneousitems", nullable = false)
    private Double miscellaneousitems;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "shovel", nullable = false)
    private Double shovel;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "rake", nullable = false)
    private Double rake;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "saw", nullable = false)
    private Double saw;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "pickaxe", nullable = false)
    private Double pickaxe;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "repairing", nullable = false)
    private Double repairing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "sickle", nullable = false)
    private Double sickle;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "scythe", nullable = false)
    private Double scythe;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "hammer", nullable = false)
    private Double hammer;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "stonechisel", nullable = false)
    private Double stonechisel;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "alchemy", nullable = false)
    private Double alchemy;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "naturalsubstances", nullable = false)
    private Double naturalsubstances;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "shields", nullable = false)
    private Double shields;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "mediummetalshield", nullable = false)
    private Double mediummetalshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "smallwoodenshield", nullable = false)
    private Double smallwoodenshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "smallmetalshield", nullable = false)
    private Double smallmetalshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "largemetalshield", nullable = false)
    private Double largemetalshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "mediumwoodenshield", nullable = false)
    private Double mediumwoodenshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "largewoodenshield", nullable = false)
    private Double largewoodenshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "axes", nullable = false)
    private Double axes;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "hatchet", nullable = false)
    private Double hatchet;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "smallaxe", nullable = false)
    private Double smallaxe;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "largeaxe", nullable = false)
    private Double largeaxe;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "hugeaxe", nullable = false)
    private Double hugeaxe;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "swords", nullable = false)
    private Double swords;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "longsword", nullable = false)
    private Double longsword;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "shortsword", nullable = false)
    private Double shortsword;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "twohandedsword", nullable = false)
    private Double twohandedsword;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "knives", nullable = false)
    private Double knives;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "carvingknife", nullable = false)
    private Double carvingknife;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "butcheringknife", nullable = false)
    private Double butcheringknife;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "woodcutting", nullable = false)
    private Double woodcutting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "mauls", nullable = false)
    private Double mauls;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "mediummaul", nullable = false)
    private Double mediummaul;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "smallmaul", nullable = false)
    private Double smallmaul;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "largemaul", nullable = false)
    private Double largemaul;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "carpentry", nullable = false)
    private Double carpentry;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "bowyery", nullable = false)
    private Double bowyery;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "fletching", nullable = false)
    private Double fletching;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "finecarpentry", nullable = false)
    private Double finecarpentry;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "toymaking", nullable = false)
    private Double toymaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "shipbuilding", nullable = false)
    private Double shipbuilding;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "mind", nullable = false)
    private Double mind;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "mindlogic", nullable = false)
    private Double mindlogic;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "mindspeed", nullable = false)
    private Double mindspeed;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "soul", nullable = false)
    private Double soul;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "souldepth", nullable = false)
    private Double souldepth;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "soulstrength", nullable = false)
    private Double soulstrength;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "body", nullable = false)
    private Double body;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "bodystrength", nullable = false)
    private Double bodystrength;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "bodystamina", nullable = false)
    private Double bodystamina;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "bodycontrol", nullable = false)
    private Double bodycontrol;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "faith", nullable = false)
    private Double faith;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "favor", nullable = false)
    private Double favor;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    @Column(name = "alignment", nullable = false)
    private Double alignment;

    @ManyToOne
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Skills id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDumptime() {
        return this.dumptime;
    }

    public Skills dumptime(String dumptime) {
        this.setDumptime(dumptime);
        return this;
    }

    public void setDumptime(String dumptime) {
        this.dumptime = dumptime;
    }

    public String getPlayername() {
        return this.playername;
    }

    public Skills playername(String playername) {
        this.setPlayername(playername);
        return this;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getPremium() {
        return this.premium;
    }

    public Skills premium(String premium) {
        this.setPremium(premium);
        return this;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getServer() {
        return this.server;
    }

    public Skills server(String server) {
        this.setServer(server);
        return this;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Double getReligion() {
        return this.religion;
    }

    public Skills religion(Double religion) {
        this.setReligion(religion);
        return this;
    }

    public void setReligion(Double religion) {
        this.religion = religion;
    }

    public Double getPrayer() {
        return this.prayer;
    }

    public Skills prayer(Double prayer) {
        this.setPrayer(prayer);
        return this;
    }

    public void setPrayer(Double prayer) {
        this.prayer = prayer;
    }

    public Double getChanneling() {
        return this.channeling;
    }

    public Skills channeling(Double channeling) {
        this.setChanneling(channeling);
        return this;
    }

    public void setChanneling(Double channeling) {
        this.channeling = channeling;
    }

    public Double getPreaching() {
        return this.preaching;
    }

    public Skills preaching(Double preaching) {
        this.setPreaching(preaching);
        return this;
    }

    public void setPreaching(Double preaching) {
        this.preaching = preaching;
    }

    public Double getExorcism() {
        return this.exorcism;
    }

    public Skills exorcism(Double exorcism) {
        this.setExorcism(exorcism);
        return this;
    }

    public void setExorcism(Double exorcism) {
        this.exorcism = exorcism;
    }

    public Double getHammers() {
        return this.hammers;
    }

    public Skills hammers(Double hammers) {
        this.setHammers(hammers);
        return this;
    }

    public void setHammers(Double hammers) {
        this.hammers = hammers;
    }

    public Double getWarhammer() {
        return this.warhammer;
    }

    public Skills warhammer(Double warhammer) {
        this.setWarhammer(warhammer);
        return this;
    }

    public void setWarhammer(Double warhammer) {
        this.warhammer = warhammer;
    }

    public Double getHealing() {
        return this.healing;
    }

    public Skills healing(Double healing) {
        this.setHealing(healing);
        return this;
    }

    public void setHealing(Double healing) {
        this.healing = healing;
    }

    public Double getFirstaid() {
        return this.firstaid;
    }

    public Skills firstaid(Double firstaid) {
        this.setFirstaid(firstaid);
        return this;
    }

    public void setFirstaid(Double firstaid) {
        this.firstaid = firstaid;
    }

    public Double getClubs() {
        return this.clubs;
    }

    public Skills clubs(Double clubs) {
        this.setClubs(clubs);
        return this;
    }

    public void setClubs(Double clubs) {
        this.clubs = clubs;
    }

    public Double getHugeclub() {
        return this.hugeclub;
    }

    public Skills hugeclub(Double hugeclub) {
        this.setHugeclub(hugeclub);
        return this;
    }

    public void setHugeclub(Double hugeclub) {
        this.hugeclub = hugeclub;
    }

    public Double getArchery() {
        return this.archery;
    }

    public Skills archery(Double archery) {
        this.setArchery(archery);
        return this;
    }

    public void setArchery(Double archery) {
        this.archery = archery;
    }

    public Double getShortbow() {
        return this.shortbow;
    }

    public Skills shortbow(Double shortbow) {
        this.setShortbow(shortbow);
        return this;
    }

    public void setShortbow(Double shortbow) {
        this.shortbow = shortbow;
    }

    public Double getMediumbow() {
        return this.mediumbow;
    }

    public Skills mediumbow(Double mediumbow) {
        this.setMediumbow(mediumbow);
        return this;
    }

    public void setMediumbow(Double mediumbow) {
        this.mediumbow = mediumbow;
    }

    public Double getLongbow() {
        return this.longbow;
    }

    public Skills longbow(Double longbow) {
        this.setLongbow(longbow);
        return this;
    }

    public void setLongbow(Double longbow) {
        this.longbow = longbow;
    }

    public Double getThievery() {
        return this.thievery;
    }

    public Skills thievery(Double thievery) {
        this.setThievery(thievery);
        return this;
    }

    public void setThievery(Double thievery) {
        this.thievery = thievery;
    }

    public Double getStealing() {
        return this.stealing;
    }

    public Skills stealing(Double stealing) {
        this.setStealing(stealing);
        return this;
    }

    public void setStealing(Double stealing) {
        this.stealing = stealing;
    }

    public Double getLockpicking() {
        return this.lockpicking;
    }

    public Skills lockpicking(Double lockpicking) {
        this.setLockpicking(lockpicking);
        return this;
    }

    public void setLockpicking(Double lockpicking) {
        this.lockpicking = lockpicking;
    }

    public Double getTraps() {
        return this.traps;
    }

    public Skills traps(Double traps) {
        this.setTraps(traps);
        return this;
    }

    public void setTraps(Double traps) {
        this.traps = traps;
    }

    public Double getWarmachines() {
        return this.warmachines;
    }

    public Skills warmachines(Double warmachines) {
        this.setWarmachines(warmachines);
        return this;
    }

    public void setWarmachines(Double warmachines) {
        this.warmachines = warmachines;
    }

    public Double getCatapults() {
        return this.catapults;
    }

    public Skills catapults(Double catapults) {
        this.setCatapults(catapults);
        return this;
    }

    public void setCatapults(Double catapults) {
        this.catapults = catapults;
    }

    public Double getTrebuchets() {
        return this.trebuchets;
    }

    public Skills trebuchets(Double trebuchets) {
        this.setTrebuchets(trebuchets);
        return this;
    }

    public void setTrebuchets(Double trebuchets) {
        this.trebuchets = trebuchets;
    }

    public Double getBallistae() {
        return this.ballistae;
    }

    public Skills ballistae(Double ballistae) {
        this.setBallistae(ballistae);
        return this;
    }

    public void setBallistae(Double ballistae) {
        this.ballistae = ballistae;
    }

    public Double getPolearms() {
        return this.polearms;
    }

    public Skills polearms(Double polearms) {
        this.setPolearms(polearms);
        return this;
    }

    public void setPolearms(Double polearms) {
        this.polearms = polearms;
    }

    public Double getStaff() {
        return this.staff;
    }

    public Skills staff(Double staff) {
        this.setStaff(staff);
        return this;
    }

    public void setStaff(Double staff) {
        this.staff = staff;
    }

    public Double getLongspear() {
        return this.longspear;
    }

    public Skills longspear(Double longspear) {
        this.setLongspear(longspear);
        return this;
    }

    public void setLongspear(Double longspear) {
        this.longspear = longspear;
    }

    public Double getHalberd() {
        return this.halberd;
    }

    public Skills halberd(Double halberd) {
        this.setHalberd(halberd);
        return this;
    }

    public void setHalberd(Double halberd) {
        this.halberd = halberd;
    }

    public Double getProspecting() {
        return this.prospecting;
    }

    public Skills prospecting(Double prospecting) {
        this.setProspecting(prospecting);
        return this;
    }

    public void setProspecting(Double prospecting) {
        this.prospecting = prospecting;
    }

    public Double getCoalmaking() {
        return this.coalmaking;
    }

    public Skills coalmaking(Double coalmaking) {
        this.setCoalmaking(coalmaking);
        return this;
    }

    public void setCoalmaking(Double coalmaking) {
        this.coalmaking = coalmaking;
    }

    public Double getMilling() {
        return this.milling;
    }

    public Skills milling(Double milling) {
        this.setMilling(milling);
        return this;
    }

    public void setMilling(Double milling) {
        this.milling = milling;
    }

    public Double getTracking() {
        return this.tracking;
    }

    public Skills tracking(Double tracking) {
        this.setTracking(tracking);
        return this;
    }

    public void setTracking(Double tracking) {
        this.tracking = tracking;
    }

    public Double getPaving() {
        return this.paving;
    }

    public Skills paving(Double paving) {
        this.setPaving(paving);
        return this;
    }

    public void setPaving(Double paving) {
        this.paving = paving;
    }

    public Double getArchaeology() {
        return this.archaeology;
    }

    public Skills archaeology(Double archaeology) {
        this.setArchaeology(archaeology);
        return this;
    }

    public void setArchaeology(Double archaeology) {
        this.archaeology = archaeology;
    }

    public Double getRestoration() {
        return this.restoration;
    }

    public Skills restoration(Double restoration) {
        this.setRestoration(restoration);
        return this;
    }

    public void setRestoration(Double restoration) {
        this.restoration = restoration;
    }

    public Double getClimbing() {
        return this.climbing;
    }

    public Skills climbing(Double climbing) {
        this.setClimbing(climbing);
        return this;
    }

    public void setClimbing(Double climbing) {
        this.climbing = climbing;
    }

    public Double getThatching() {
        return this.thatching;
    }

    public Skills thatching(Double thatching) {
        this.setThatching(thatching);
        return this;
    }

    public void setThatching(Double thatching) {
        this.thatching = thatching;
    }

    public Double getFiremaking() {
        return this.firemaking;
    }

    public Skills firemaking(Double firemaking) {
        this.setFiremaking(firemaking);
        return this;
    }

    public void setFiremaking(Double firemaking) {
        this.firemaking = firemaking;
    }

    public Double getPottery() {
        return this.pottery;
    }

    public Skills pottery(Double pottery) {
        this.setPottery(pottery);
        return this;
    }

    public void setPottery(Double pottery) {
        this.pottery = pottery;
    }

    public Double getMining() {
        return this.mining;
    }

    public Skills mining(Double mining) {
        this.setMining(mining);
        return this;
    }

    public void setMining(Double mining) {
        this.mining = mining;
    }

    public Double getDigging() {
        return this.digging;
    }

    public Skills digging(Double digging) {
        this.setDigging(digging);
        return this;
    }

    public void setDigging(Double digging) {
        this.digging = digging;
    }

    public Double getRopemaking() {
        return this.ropemaking;
    }

    public Skills ropemaking(Double ropemaking) {
        this.setRopemaking(ropemaking);
        return this;
    }

    public void setRopemaking(Double ropemaking) {
        this.ropemaking = ropemaking;
    }

    public Double getSmithing() {
        return this.smithing;
    }

    public Skills smithing(Double smithing) {
        this.setSmithing(smithing);
        return this;
    }

    public void setSmithing(Double smithing) {
        this.smithing = smithing;
    }

    public Double getBlacksmithing() {
        return this.blacksmithing;
    }

    public Skills blacksmithing(Double blacksmithing) {
        this.setBlacksmithing(blacksmithing);
        return this;
    }

    public void setBlacksmithing(Double blacksmithing) {
        this.blacksmithing = blacksmithing;
    }

    public Double getLocksmithing() {
        return this.locksmithing;
    }

    public Skills locksmithing(Double locksmithing) {
        this.setLocksmithing(locksmithing);
        return this;
    }

    public void setLocksmithing(Double locksmithing) {
        this.locksmithing = locksmithing;
    }

    public Double getJewelrysmithing() {
        return this.jewelrysmithing;
    }

    public Skills jewelrysmithing(Double jewelrysmithing) {
        this.setJewelrysmithing(jewelrysmithing);
        return this;
    }

    public void setJewelrysmithing(Double jewelrysmithing) {
        this.jewelrysmithing = jewelrysmithing;
    }

    public Double getMetallurgy() {
        return this.metallurgy;
    }

    public Skills metallurgy(Double metallurgy) {
        this.setMetallurgy(metallurgy);
        return this;
    }

    public void setMetallurgy(Double metallurgy) {
        this.metallurgy = metallurgy;
    }

    public Double getWeaponsmithing() {
        return this.weaponsmithing;
    }

    public Skills weaponsmithing(Double weaponsmithing) {
        this.setWeaponsmithing(weaponsmithing);
        return this;
    }

    public void setWeaponsmithing(Double weaponsmithing) {
        this.weaponsmithing = weaponsmithing;
    }

    public Double getBladessmithing() {
        return this.bladessmithing;
    }

    public Skills bladessmithing(Double bladessmithing) {
        this.setBladessmithing(bladessmithing);
        return this;
    }

    public void setBladessmithing(Double bladessmithing) {
        this.bladessmithing = bladessmithing;
    }

    public Double getWeaponheadssmithing() {
        return this.weaponheadssmithing;
    }

    public Skills weaponheadssmithing(Double weaponheadssmithing) {
        this.setWeaponheadssmithing(weaponheadssmithing);
        return this;
    }

    public void setWeaponheadssmithing(Double weaponheadssmithing) {
        this.weaponheadssmithing = weaponheadssmithing;
    }

    public Double getArmoursmithing() {
        return this.armoursmithing;
    }

    public Skills armoursmithing(Double armoursmithing) {
        this.setArmoursmithing(armoursmithing);
        return this;
    }

    public void setArmoursmithing(Double armoursmithing) {
        this.armoursmithing = armoursmithing;
    }

    public Double getShieldsmithing() {
        return this.shieldsmithing;
    }

    public Skills shieldsmithing(Double shieldsmithing) {
        this.setShieldsmithing(shieldsmithing);
        return this;
    }

    public void setShieldsmithing(Double shieldsmithing) {
        this.shieldsmithing = shieldsmithing;
    }

    public Double getChainarmoursmithing() {
        return this.chainarmoursmithing;
    }

    public Skills chainarmoursmithing(Double chainarmoursmithing) {
        this.setChainarmoursmithing(chainarmoursmithing);
        return this;
    }

    public void setChainarmoursmithing(Double chainarmoursmithing) {
        this.chainarmoursmithing = chainarmoursmithing;
    }

    public Double getPlatearmoursmithing() {
        return this.platearmoursmithing;
    }

    public Skills platearmoursmithing(Double platearmoursmithing) {
        this.setPlatearmoursmithing(platearmoursmithing);
        return this;
    }

    public void setPlatearmoursmithing(Double platearmoursmithing) {
        this.platearmoursmithing = platearmoursmithing;
    }

    public Double getTailoring() {
        return this.tailoring;
    }

    public Skills tailoring(Double tailoring) {
        this.setTailoring(tailoring);
        return this;
    }

    public void setTailoring(Double tailoring) {
        this.tailoring = tailoring;
    }

    public Double getClothtailoring() {
        return this.clothtailoring;
    }

    public Skills clothtailoring(Double clothtailoring) {
        this.setClothtailoring(clothtailoring);
        return this;
    }

    public void setClothtailoring(Double clothtailoring) {
        this.clothtailoring = clothtailoring;
    }

    public Double getLeatherworking() {
        return this.leatherworking;
    }

    public Skills leatherworking(Double leatherworking) {
        this.setLeatherworking(leatherworking);
        return this;
    }

    public void setLeatherworking(Double leatherworking) {
        this.leatherworking = leatherworking;
    }

    public Double getMasonry() {
        return this.masonry;
    }

    public Skills masonry(Double masonry) {
        this.setMasonry(masonry);
        return this;
    }

    public void setMasonry(Double masonry) {
        this.masonry = masonry;
    }

    public Double getStonecutting() {
        return this.stonecutting;
    }

    public Skills stonecutting(Double stonecutting) {
        this.setStonecutting(stonecutting);
        return this;
    }

    public void setStonecutting(Double stonecutting) {
        this.stonecutting = stonecutting;
    }

    public Double getCooking() {
        return this.cooking;
    }

    public Skills cooking(Double cooking) {
        this.setCooking(cooking);
        return this;
    }

    public void setCooking(Double cooking) {
        this.cooking = cooking;
    }

    public Double getHotfoodcooking() {
        return this.hotfoodcooking;
    }

    public Skills hotfoodcooking(Double hotfoodcooking) {
        this.setHotfoodcooking(hotfoodcooking);
        return this;
    }

    public void setHotfoodcooking(Double hotfoodcooking) {
        this.hotfoodcooking = hotfoodcooking;
    }

    public Double getBaking() {
        return this.baking;
    }

    public Skills baking(Double baking) {
        this.setBaking(baking);
        return this;
    }

    public void setBaking(Double baking) {
        this.baking = baking;
    }

    public Double getDairyfoodmaking() {
        return this.dairyfoodmaking;
    }

    public Skills dairyfoodmaking(Double dairyfoodmaking) {
        this.setDairyfoodmaking(dairyfoodmaking);
        return this;
    }

    public void setDairyfoodmaking(Double dairyfoodmaking) {
        this.dairyfoodmaking = dairyfoodmaking;
    }

    public Double getButchering() {
        return this.butchering;
    }

    public Skills butchering(Double butchering) {
        this.setButchering(butchering);
        return this;
    }

    public void setButchering(Double butchering) {
        this.butchering = butchering;
    }

    public Double getBeverages() {
        return this.beverages;
    }

    public Skills beverages(Double beverages) {
        this.setBeverages(beverages);
        return this;
    }

    public void setBeverages(Double beverages) {
        this.beverages = beverages;
    }

    public Double getNature() {
        return this.nature;
    }

    public Skills nature(Double nature) {
        this.setNature(nature);
        return this;
    }

    public void setNature(Double nature) {
        this.nature = nature;
    }

    public Double getFishing() {
        return this.fishing;
    }

    public Skills fishing(Double fishing) {
        this.setFishing(fishing);
        return this;
    }

    public void setFishing(Double fishing) {
        this.fishing = fishing;
    }

    public Double getGardening() {
        return this.gardening;
    }

    public Skills gardening(Double gardening) {
        this.setGardening(gardening);
        return this;
    }

    public void setGardening(Double gardening) {
        this.gardening = gardening;
    }

    public Double getForaging() {
        return this.foraging;
    }

    public Skills foraging(Double foraging) {
        this.setForaging(foraging);
        return this;
    }

    public void setForaging(Double foraging) {
        this.foraging = foraging;
    }

    public Double getBotanizing() {
        return this.botanizing;
    }

    public Skills botanizing(Double botanizing) {
        this.setBotanizing(botanizing);
        return this;
    }

    public void setBotanizing(Double botanizing) {
        this.botanizing = botanizing;
    }

    public Double getAnimaltaming() {
        return this.animaltaming;
    }

    public Skills animaltaming(Double animaltaming) {
        this.setAnimaltaming(animaltaming);
        return this;
    }

    public void setAnimaltaming(Double animaltaming) {
        this.animaltaming = animaltaming;
    }

    public Double getForestry() {
        return this.forestry;
    }

    public Skills forestry(Double forestry) {
        this.setForestry(forestry);
        return this;
    }

    public void setForestry(Double forestry) {
        this.forestry = forestry;
    }

    public Double getFarming() {
        return this.farming;
    }

    public Skills farming(Double farming) {
        this.setFarming(farming);
        return this;
    }

    public void setFarming(Double farming) {
        this.farming = farming;
    }

    public Double getMilking() {
        return this.milking;
    }

    public Skills milking(Double milking) {
        this.setMilking(milking);
        return this;
    }

    public void setMilking(Double milking) {
        this.milking = milking;
    }

    public Double getMeditating() {
        return this.meditating;
    }

    public Skills meditating(Double meditating) {
        this.setMeditating(meditating);
        return this;
    }

    public void setMeditating(Double meditating) {
        this.meditating = meditating;
    }

    public Double getAnimalhusbandry() {
        return this.animalhusbandry;
    }

    public Skills animalhusbandry(Double animalhusbandry) {
        this.setAnimalhusbandry(animalhusbandry);
        return this;
    }

    public void setAnimalhusbandry(Double animalhusbandry) {
        this.animalhusbandry = animalhusbandry;
    }

    public Double getPapyrusmaking() {
        return this.papyrusmaking;
    }

    public Skills papyrusmaking(Double papyrusmaking) {
        this.setPapyrusmaking(papyrusmaking);
        return this;
    }

    public void setPapyrusmaking(Double papyrusmaking) {
        this.papyrusmaking = papyrusmaking;
    }

    public Double getToys() {
        return this.toys;
    }

    public Skills toys(Double toys) {
        this.setToys(toys);
        return this;
    }

    public void setToys(Double toys) {
        this.toys = toys;
    }

    public Double getYoyo() {
        return this.yoyo;
    }

    public Skills yoyo(Double yoyo) {
        this.setYoyo(yoyo);
        return this;
    }

    public void setYoyo(Double yoyo) {
        this.yoyo = yoyo;
    }

    public Double getPuppeteering() {
        return this.puppeteering;
    }

    public Skills puppeteering(Double puppeteering) {
        this.setPuppeteering(puppeteering);
        return this;
    }

    public void setPuppeteering(Double puppeteering) {
        this.puppeteering = puppeteering;
    }

    public Double getFighting() {
        return this.fighting;
    }

    public Skills fighting(Double fighting) {
        this.setFighting(fighting);
        return this;
    }

    public void setFighting(Double fighting) {
        this.fighting = fighting;
    }

    public Double getDefensivefighting() {
        return this.defensivefighting;
    }

    public Skills defensivefighting(Double defensivefighting) {
        this.setDefensivefighting(defensivefighting);
        return this;
    }

    public void setDefensivefighting(Double defensivefighting) {
        this.defensivefighting = defensivefighting;
    }

    public Double getNormalfighting() {
        return this.normalfighting;
    }

    public Skills normalfighting(Double normalfighting) {
        this.setNormalfighting(normalfighting);
        return this;
    }

    public void setNormalfighting(Double normalfighting) {
        this.normalfighting = normalfighting;
    }

    public Double getWeaponlessfighting() {
        return this.weaponlessfighting;
    }

    public Skills weaponlessfighting(Double weaponlessfighting) {
        this.setWeaponlessfighting(weaponlessfighting);
        return this;
    }

    public void setWeaponlessfighting(Double weaponlessfighting) {
        this.weaponlessfighting = weaponlessfighting;
    }

    public Double getAggressivefighting() {
        return this.aggressivefighting;
    }

    public Skills aggressivefighting(Double aggressivefighting) {
        this.setAggressivefighting(aggressivefighting);
        return this;
    }

    public void setAggressivefighting(Double aggressivefighting) {
        this.aggressivefighting = aggressivefighting;
    }

    public Double getShieldbashing() {
        return this.shieldbashing;
    }

    public Skills shieldbashing(Double shieldbashing) {
        this.setShieldbashing(shieldbashing);
        return this;
    }

    public void setShieldbashing(Double shieldbashing) {
        this.shieldbashing = shieldbashing;
    }

    public Double getTaunting() {
        return this.taunting;
    }

    public Skills taunting(Double taunting) {
        this.setTaunting(taunting);
        return this;
    }

    public void setTaunting(Double taunting) {
        this.taunting = taunting;
    }

    public Double getMiscellaneousitems() {
        return this.miscellaneousitems;
    }

    public Skills miscellaneousitems(Double miscellaneousitems) {
        this.setMiscellaneousitems(miscellaneousitems);
        return this;
    }

    public void setMiscellaneousitems(Double miscellaneousitems) {
        this.miscellaneousitems = miscellaneousitems;
    }

    public Double getShovel() {
        return this.shovel;
    }

    public Skills shovel(Double shovel) {
        this.setShovel(shovel);
        return this;
    }

    public void setShovel(Double shovel) {
        this.shovel = shovel;
    }

    public Double getRake() {
        return this.rake;
    }

    public Skills rake(Double rake) {
        this.setRake(rake);
        return this;
    }

    public void setRake(Double rake) {
        this.rake = rake;
    }

    public Double getSaw() {
        return this.saw;
    }

    public Skills saw(Double saw) {
        this.setSaw(saw);
        return this;
    }

    public void setSaw(Double saw) {
        this.saw = saw;
    }

    public Double getPickaxe() {
        return this.pickaxe;
    }

    public Skills pickaxe(Double pickaxe) {
        this.setPickaxe(pickaxe);
        return this;
    }

    public void setPickaxe(Double pickaxe) {
        this.pickaxe = pickaxe;
    }

    public Double getRepairing() {
        return this.repairing;
    }

    public Skills repairing(Double repairing) {
        this.setRepairing(repairing);
        return this;
    }

    public void setRepairing(Double repairing) {
        this.repairing = repairing;
    }

    public Double getSickle() {
        return this.sickle;
    }

    public Skills sickle(Double sickle) {
        this.setSickle(sickle);
        return this;
    }

    public void setSickle(Double sickle) {
        this.sickle = sickle;
    }

    public Double getScythe() {
        return this.scythe;
    }

    public Skills scythe(Double scythe) {
        this.setScythe(scythe);
        return this;
    }

    public void setScythe(Double scythe) {
        this.scythe = scythe;
    }

    public Double getHammer() {
        return this.hammer;
    }

    public Skills hammer(Double hammer) {
        this.setHammer(hammer);
        return this;
    }

    public void setHammer(Double hammer) {
        this.hammer = hammer;
    }

    public Double getStonechisel() {
        return this.stonechisel;
    }

    public Skills stonechisel(Double stonechisel) {
        this.setStonechisel(stonechisel);
        return this;
    }

    public void setStonechisel(Double stonechisel) {
        this.stonechisel = stonechisel;
    }

    public Double getAlchemy() {
        return this.alchemy;
    }

    public Skills alchemy(Double alchemy) {
        this.setAlchemy(alchemy);
        return this;
    }

    public void setAlchemy(Double alchemy) {
        this.alchemy = alchemy;
    }

    public Double getNaturalsubstances() {
        return this.naturalsubstances;
    }

    public Skills naturalsubstances(Double naturalsubstances) {
        this.setNaturalsubstances(naturalsubstances);
        return this;
    }

    public void setNaturalsubstances(Double naturalsubstances) {
        this.naturalsubstances = naturalsubstances;
    }

    public Double getShields() {
        return this.shields;
    }

    public Skills shields(Double shields) {
        this.setShields(shields);
        return this;
    }

    public void setShields(Double shields) {
        this.shields = shields;
    }

    public Double getMediummetalshield() {
        return this.mediummetalshield;
    }

    public Skills mediummetalshield(Double mediummetalshield) {
        this.setMediummetalshield(mediummetalshield);
        return this;
    }

    public void setMediummetalshield(Double mediummetalshield) {
        this.mediummetalshield = mediummetalshield;
    }

    public Double getSmallwoodenshield() {
        return this.smallwoodenshield;
    }

    public Skills smallwoodenshield(Double smallwoodenshield) {
        this.setSmallwoodenshield(smallwoodenshield);
        return this;
    }

    public void setSmallwoodenshield(Double smallwoodenshield) {
        this.smallwoodenshield = smallwoodenshield;
    }

    public Double getSmallmetalshield() {
        return this.smallmetalshield;
    }

    public Skills smallmetalshield(Double smallmetalshield) {
        this.setSmallmetalshield(smallmetalshield);
        return this;
    }

    public void setSmallmetalshield(Double smallmetalshield) {
        this.smallmetalshield = smallmetalshield;
    }

    public Double getLargemetalshield() {
        return this.largemetalshield;
    }

    public Skills largemetalshield(Double largemetalshield) {
        this.setLargemetalshield(largemetalshield);
        return this;
    }

    public void setLargemetalshield(Double largemetalshield) {
        this.largemetalshield = largemetalshield;
    }

    public Double getMediumwoodenshield() {
        return this.mediumwoodenshield;
    }

    public Skills mediumwoodenshield(Double mediumwoodenshield) {
        this.setMediumwoodenshield(mediumwoodenshield);
        return this;
    }

    public void setMediumwoodenshield(Double mediumwoodenshield) {
        this.mediumwoodenshield = mediumwoodenshield;
    }

    public Double getLargewoodenshield() {
        return this.largewoodenshield;
    }

    public Skills largewoodenshield(Double largewoodenshield) {
        this.setLargewoodenshield(largewoodenshield);
        return this;
    }

    public void setLargewoodenshield(Double largewoodenshield) {
        this.largewoodenshield = largewoodenshield;
    }

    public Double getAxes() {
        return this.axes;
    }

    public Skills axes(Double axes) {
        this.setAxes(axes);
        return this;
    }

    public void setAxes(Double axes) {
        this.axes = axes;
    }

    public Double getHatchet() {
        return this.hatchet;
    }

    public Skills hatchet(Double hatchet) {
        this.setHatchet(hatchet);
        return this;
    }

    public void setHatchet(Double hatchet) {
        this.hatchet = hatchet;
    }

    public Double getSmallaxe() {
        return this.smallaxe;
    }

    public Skills smallaxe(Double smallaxe) {
        this.setSmallaxe(smallaxe);
        return this;
    }

    public void setSmallaxe(Double smallaxe) {
        this.smallaxe = smallaxe;
    }

    public Double getLargeaxe() {
        return this.largeaxe;
    }

    public Skills largeaxe(Double largeaxe) {
        this.setLargeaxe(largeaxe);
        return this;
    }

    public void setLargeaxe(Double largeaxe) {
        this.largeaxe = largeaxe;
    }

    public Double getHugeaxe() {
        return this.hugeaxe;
    }

    public Skills hugeaxe(Double hugeaxe) {
        this.setHugeaxe(hugeaxe);
        return this;
    }

    public void setHugeaxe(Double hugeaxe) {
        this.hugeaxe = hugeaxe;
    }

    public Double getSwords() {
        return this.swords;
    }

    public Skills swords(Double swords) {
        this.setSwords(swords);
        return this;
    }

    public void setSwords(Double swords) {
        this.swords = swords;
    }

    public Double getLongsword() {
        return this.longsword;
    }

    public Skills longsword(Double longsword) {
        this.setLongsword(longsword);
        return this;
    }

    public void setLongsword(Double longsword) {
        this.longsword = longsword;
    }

    public Double getShortsword() {
        return this.shortsword;
    }

    public Skills shortsword(Double shortsword) {
        this.setShortsword(shortsword);
        return this;
    }

    public void setShortsword(Double shortsword) {
        this.shortsword = shortsword;
    }

    public Double getTwohandedsword() {
        return this.twohandedsword;
    }

    public Skills twohandedsword(Double twohandedsword) {
        this.setTwohandedsword(twohandedsword);
        return this;
    }

    public void setTwohandedsword(Double twohandedsword) {
        this.twohandedsword = twohandedsword;
    }

    public Double getKnives() {
        return this.knives;
    }

    public Skills knives(Double knives) {
        this.setKnives(knives);
        return this;
    }

    public void setKnives(Double knives) {
        this.knives = knives;
    }

    public Double getCarvingknife() {
        return this.carvingknife;
    }

    public Skills carvingknife(Double carvingknife) {
        this.setCarvingknife(carvingknife);
        return this;
    }

    public void setCarvingknife(Double carvingknife) {
        this.carvingknife = carvingknife;
    }

    public Double getButcheringknife() {
        return this.butcheringknife;
    }

    public Skills butcheringknife(Double butcheringknife) {
        this.setButcheringknife(butcheringknife);
        return this;
    }

    public void setButcheringknife(Double butcheringknife) {
        this.butcheringknife = butcheringknife;
    }

    public Double getWoodcutting() {
        return this.woodcutting;
    }

    public Skills woodcutting(Double woodcutting) {
        this.setWoodcutting(woodcutting);
        return this;
    }

    public void setWoodcutting(Double woodcutting) {
        this.woodcutting = woodcutting;
    }

    public Double getMauls() {
        return this.mauls;
    }

    public Skills mauls(Double mauls) {
        this.setMauls(mauls);
        return this;
    }

    public void setMauls(Double mauls) {
        this.mauls = mauls;
    }

    public Double getMediummaul() {
        return this.mediummaul;
    }

    public Skills mediummaul(Double mediummaul) {
        this.setMediummaul(mediummaul);
        return this;
    }

    public void setMediummaul(Double mediummaul) {
        this.mediummaul = mediummaul;
    }

    public Double getSmallmaul() {
        return this.smallmaul;
    }

    public Skills smallmaul(Double smallmaul) {
        this.setSmallmaul(smallmaul);
        return this;
    }

    public void setSmallmaul(Double smallmaul) {
        this.smallmaul = smallmaul;
    }

    public Double getLargemaul() {
        return this.largemaul;
    }

    public Skills largemaul(Double largemaul) {
        this.setLargemaul(largemaul);
        return this;
    }

    public void setLargemaul(Double largemaul) {
        this.largemaul = largemaul;
    }

    public Double getCarpentry() {
        return this.carpentry;
    }

    public Skills carpentry(Double carpentry) {
        this.setCarpentry(carpentry);
        return this;
    }

    public void setCarpentry(Double carpentry) {
        this.carpentry = carpentry;
    }

    public Double getBowyery() {
        return this.bowyery;
    }

    public Skills bowyery(Double bowyery) {
        this.setBowyery(bowyery);
        return this;
    }

    public void setBowyery(Double bowyery) {
        this.bowyery = bowyery;
    }

    public Double getFletching() {
        return this.fletching;
    }

    public Skills fletching(Double fletching) {
        this.setFletching(fletching);
        return this;
    }

    public void setFletching(Double fletching) {
        this.fletching = fletching;
    }

    public Double getFinecarpentry() {
        return this.finecarpentry;
    }

    public Skills finecarpentry(Double finecarpentry) {
        this.setFinecarpentry(finecarpentry);
        return this;
    }

    public void setFinecarpentry(Double finecarpentry) {
        this.finecarpentry = finecarpentry;
    }

    public Double getToymaking() {
        return this.toymaking;
    }

    public Skills toymaking(Double toymaking) {
        this.setToymaking(toymaking);
        return this;
    }

    public void setToymaking(Double toymaking) {
        this.toymaking = toymaking;
    }

    public Double getShipbuilding() {
        return this.shipbuilding;
    }

    public Skills shipbuilding(Double shipbuilding) {
        this.setShipbuilding(shipbuilding);
        return this;
    }

    public void setShipbuilding(Double shipbuilding) {
        this.shipbuilding = shipbuilding;
    }

    public Double getMind() {
        return this.mind;
    }

    public Skills mind(Double mind) {
        this.setMind(mind);
        return this;
    }

    public void setMind(Double mind) {
        this.mind = mind;
    }

    public Double getMindlogic() {
        return this.mindlogic;
    }

    public Skills mindlogic(Double mindlogic) {
        this.setMindlogic(mindlogic);
        return this;
    }

    public void setMindlogic(Double mindlogic) {
        this.mindlogic = mindlogic;
    }

    public Double getMindspeed() {
        return this.mindspeed;
    }

    public Skills mindspeed(Double mindspeed) {
        this.setMindspeed(mindspeed);
        return this;
    }

    public void setMindspeed(Double mindspeed) {
        this.mindspeed = mindspeed;
    }

    public Double getSoul() {
        return this.soul;
    }

    public Skills soul(Double soul) {
        this.setSoul(soul);
        return this;
    }

    public void setSoul(Double soul) {
        this.soul = soul;
    }

    public Double getSouldepth() {
        return this.souldepth;
    }

    public Skills souldepth(Double souldepth) {
        this.setSouldepth(souldepth);
        return this;
    }

    public void setSouldepth(Double souldepth) {
        this.souldepth = souldepth;
    }

    public Double getSoulstrength() {
        return this.soulstrength;
    }

    public Skills soulstrength(Double soulstrength) {
        this.setSoulstrength(soulstrength);
        return this;
    }

    public void setSoulstrength(Double soulstrength) {
        this.soulstrength = soulstrength;
    }

    public Double getBody() {
        return this.body;
    }

    public Skills body(Double body) {
        this.setBody(body);
        return this;
    }

    public void setBody(Double body) {
        this.body = body;
    }

    public Double getBodystrength() {
        return this.bodystrength;
    }

    public Skills bodystrength(Double bodystrength) {
        this.setBodystrength(bodystrength);
        return this;
    }

    public void setBodystrength(Double bodystrength) {
        this.bodystrength = bodystrength;
    }

    public Double getBodystamina() {
        return this.bodystamina;
    }

    public Skills bodystamina(Double bodystamina) {
        this.setBodystamina(bodystamina);
        return this;
    }

    public void setBodystamina(Double bodystamina) {
        this.bodystamina = bodystamina;
    }

    public Double getBodycontrol() {
        return this.bodycontrol;
    }

    public Skills bodycontrol(Double bodycontrol) {
        this.setBodycontrol(bodycontrol);
        return this;
    }

    public void setBodycontrol(Double bodycontrol) {
        this.bodycontrol = bodycontrol;
    }

    public Double getFaith() {
        return this.faith;
    }

    public Skills faith(Double faith) {
        this.setFaith(faith);
        return this;
    }

    public void setFaith(Double faith) {
        this.faith = faith;
    }

    public Double getFavor() {
        return this.favor;
    }

    public Skills favor(Double favor) {
        this.setFavor(favor);
        return this;
    }

    public void setFavor(Double favor) {
        this.favor = favor;
    }

    public Double getAlignment() {
        return this.alignment;
    }

    public Skills alignment(Double alignment) {
        this.setAlignment(alignment);
        return this;
    }

    public void setAlignment(Double alignment) {
        this.alignment = alignment;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skills user(User user) {
        this.setUser(user);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Skills)) {
            return false;
        }
        return id != null && id.equals(((Skills) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Skills{" +
            "id=" + getId() +
            ", dumptime='" + getDumptime() + "'" +
            ", playername='" + getPlayername() + "'" +
            ", premium='" + getPremium() + "'" +
            ", server='" + getServer() + "'" +
            ", religion=" + getReligion() +
            ", prayer=" + getPrayer() +
            ", channeling=" + getChanneling() +
            ", preaching=" + getPreaching() +
            ", exorcism=" + getExorcism() +
            ", hammers=" + getHammers() +
            ", warhammer=" + getWarhammer() +
            ", healing=" + getHealing() +
            ", firstaid=" + getFirstaid() +
            ", clubs=" + getClubs() +
            ", hugeclub=" + getHugeclub() +
            ", archery=" + getArchery() +
            ", shortbow=" + getShortbow() +
            ", mediumbow=" + getMediumbow() +
            ", longbow=" + getLongbow() +
            ", thievery=" + getThievery() +
            ", stealing=" + getStealing() +
            ", lockpicking=" + getLockpicking() +
            ", traps=" + getTraps() +
            ", warmachines=" + getWarmachines() +
            ", catapults=" + getCatapults() +
            ", trebuchets=" + getTrebuchets() +
            ", ballistae=" + getBallistae() +
            ", polearms=" + getPolearms() +
            ", staff=" + getStaff() +
            ", longspear=" + getLongspear() +
            ", halberd=" + getHalberd() +
            ", prospecting=" + getProspecting() +
            ", coalmaking=" + getCoalmaking() +
            ", milling=" + getMilling() +
            ", tracking=" + getTracking() +
            ", paving=" + getPaving() +
            ", archaeology=" + getArchaeology() +
            ", restoration=" + getRestoration() +
            ", climbing=" + getClimbing() +
            ", thatching=" + getThatching() +
            ", firemaking=" + getFiremaking() +
            ", pottery=" + getPottery() +
            ", mining=" + getMining() +
            ", digging=" + getDigging() +
            ", ropemaking=" + getRopemaking() +
            ", smithing=" + getSmithing() +
            ", blacksmithing=" + getBlacksmithing() +
            ", locksmithing=" + getLocksmithing() +
            ", jewelrysmithing=" + getJewelrysmithing() +
            ", metallurgy=" + getMetallurgy() +
            ", weaponsmithing=" + getWeaponsmithing() +
            ", bladessmithing=" + getBladessmithing() +
            ", weaponheadssmithing=" + getWeaponheadssmithing() +
            ", armoursmithing=" + getArmoursmithing() +
            ", shieldsmithing=" + getShieldsmithing() +
            ", chainarmoursmithing=" + getChainarmoursmithing() +
            ", platearmoursmithing=" + getPlatearmoursmithing() +
            ", tailoring=" + getTailoring() +
            ", clothtailoring=" + getClothtailoring() +
            ", leatherworking=" + getLeatherworking() +
            ", masonry=" + getMasonry() +
            ", stonecutting=" + getStonecutting() +
            ", cooking=" + getCooking() +
            ", hotfoodcooking=" + getHotfoodcooking() +
            ", baking=" + getBaking() +
            ", dairyfoodmaking=" + getDairyfoodmaking() +
            ", butchering=" + getButchering() +
            ", beverages=" + getBeverages() +
            ", nature=" + getNature() +
            ", fishing=" + getFishing() +
            ", gardening=" + getGardening() +
            ", foraging=" + getForaging() +
            ", botanizing=" + getBotanizing() +
            ", animaltaming=" + getAnimaltaming() +
            ", forestry=" + getForestry() +
            ", farming=" + getFarming() +
            ", milking=" + getMilking() +
            ", meditating=" + getMeditating() +
            ", animalhusbandry=" + getAnimalhusbandry() +
            ", papyrusmaking=" + getPapyrusmaking() +
            ", toys=" + getToys() +
            ", yoyo=" + getYoyo() +
            ", puppeteering=" + getPuppeteering() +
            ", fighting=" + getFighting() +
            ", defensivefighting=" + getDefensivefighting() +
            ", normalfighting=" + getNormalfighting() +
            ", weaponlessfighting=" + getWeaponlessfighting() +
            ", aggressivefighting=" + getAggressivefighting() +
            ", shieldbashing=" + getShieldbashing() +
            ", taunting=" + getTaunting() +
            ", miscellaneousitems=" + getMiscellaneousitems() +
            ", shovel=" + getShovel() +
            ", rake=" + getRake() +
            ", saw=" + getSaw() +
            ", pickaxe=" + getPickaxe() +
            ", repairing=" + getRepairing() +
            ", sickle=" + getSickle() +
            ", scythe=" + getScythe() +
            ", hammer=" + getHammer() +
            ", stonechisel=" + getStonechisel() +
            ", alchemy=" + getAlchemy() +
            ", naturalsubstances=" + getNaturalsubstances() +
            ", shields=" + getShields() +
            ", mediummetalshield=" + getMediummetalshield() +
            ", smallwoodenshield=" + getSmallwoodenshield() +
            ", smallmetalshield=" + getSmallmetalshield() +
            ", largemetalshield=" + getLargemetalshield() +
            ", mediumwoodenshield=" + getMediumwoodenshield() +
            ", largewoodenshield=" + getLargewoodenshield() +
            ", axes=" + getAxes() +
            ", hatchet=" + getHatchet() +
            ", smallaxe=" + getSmallaxe() +
            ", largeaxe=" + getLargeaxe() +
            ", hugeaxe=" + getHugeaxe() +
            ", swords=" + getSwords() +
            ", longsword=" + getLongsword() +
            ", shortsword=" + getShortsword() +
            ", twohandedsword=" + getTwohandedsword() +
            ", knives=" + getKnives() +
            ", carvingknife=" + getCarvingknife() +
            ", butcheringknife=" + getButcheringknife() +
            ", woodcutting=" + getWoodcutting() +
            ", mauls=" + getMauls() +
            ", mediummaul=" + getMediummaul() +
            ", smallmaul=" + getSmallmaul() +
            ", largemaul=" + getLargemaul() +
            ", carpentry=" + getCarpentry() +
            ", bowyery=" + getBowyery() +
            ", fletching=" + getFletching() +
            ", finecarpentry=" + getFinecarpentry() +
            ", toymaking=" + getToymaking() +
            ", shipbuilding=" + getShipbuilding() +
            ", mind=" + getMind() +
            ", mindlogic=" + getMindlogic() +
            ", mindspeed=" + getMindspeed() +
            ", soul=" + getSoul() +
            ", souldepth=" + getSouldepth() +
            ", soulstrength=" + getSoulstrength() +
            ", body=" + getBody() +
            ", bodystrength=" + getBodystrength() +
            ", bodystamina=" + getBodystamina() +
            ", bodycontrol=" + getBodycontrol() +
            ", faith=" + getFaith() +
            ", favor=" + getFavor() +
            ", alignment=" + getAlignment() +
            "}";
    }
}
