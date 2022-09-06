package net.northern.verasm.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link net.northern.verasm.domain.Skills} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SkillsDTO implements Serializable {

    private Long id;

    @NotNull
    private String dumptime;

    @NotNull
    private String playername;

    @NotNull
    private String premium;

    @NotNull
    private String server;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double religion;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double prayer;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double channeling;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double preaching;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double exorcism;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double hammers;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double warhammer;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double healing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double firstaid;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double clubs;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double hugeclub;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double archery;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double shortbow;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double mediumbow;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double longbow;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double thievery;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double stealing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double lockpicking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double traps;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double warmachines;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double catapults;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double trebuchets;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double ballistae;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double polearms;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double staff;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double longspear;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double halberd;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double prospecting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double coalmaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double milling;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double tracking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double paving;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double archaeology;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double restoration;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double climbing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double thatching;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double firemaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double pottery;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double mining;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double digging;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double ropemaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double smithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double blacksmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double locksmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double jewelrysmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double metallurgy;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double weaponsmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double bladessmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double weaponheadssmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double armoursmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double shieldsmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double chainarmoursmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double platearmoursmithing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double tailoring;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double clothtailoring;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double leatherworking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double masonry;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double stonecutting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double cooking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double hotfoodcooking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double baking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double dairyfoodmaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double butchering;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double beverages;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double nature;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double fishing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double gardening;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double foraging;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double botanizing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double animaltaming;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double forestry;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double farming;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double milking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double meditating;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double animalhusbandry;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double papyrusmaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double toys;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double yoyo;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double puppeteering;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double fighting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double defensivefighting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double normalfighting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double weaponlessfighting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double aggressivefighting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double shieldbashing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double taunting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double miscellaneousitems;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double shovel;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double rake;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double saw;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double pickaxe;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double repairing;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double sickle;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double scythe;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double hammer;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double stonechisel;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double alchemy;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double naturalsubstances;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double shields;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double mediummetalshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double smallwoodenshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double smallmetalshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double largemetalshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double mediumwoodenshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double largewoodenshield;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double axes;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double hatchet;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double smallaxe;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double largeaxe;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double hugeaxe;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double swords;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double longsword;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double shortsword;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double twohandedsword;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double knives;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double carvingknife;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double butcheringknife;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double woodcutting;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double mauls;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double mediummaul;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double smallmaul;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double largemaul;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double carpentry;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double bowyery;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double fletching;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double finecarpentry;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double toymaking;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double shipbuilding;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double mind;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double mindlogic;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double mindspeed;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double soul;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double souldepth;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double soulstrength;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double body;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double bodystrength;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double bodystamina;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double bodycontrol;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double faith;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double favor;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "100.0")
    private Double alignment;

    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDumptime() {
        return dumptime;
    }

    public void setDumptime(String dumptime) {
        this.dumptime = dumptime;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Double getReligion() {
        return religion;
    }

    public void setReligion(Double religion) {
        this.religion = religion;
    }

    public Double getPrayer() {
        return prayer;
    }

    public void setPrayer(Double prayer) {
        this.prayer = prayer;
    }

    public Double getChanneling() {
        return channeling;
    }

    public void setChanneling(Double channeling) {
        this.channeling = channeling;
    }

    public Double getPreaching() {
        return preaching;
    }

    public void setPreaching(Double preaching) {
        this.preaching = preaching;
    }

    public Double getExorcism() {
        return exorcism;
    }

    public void setExorcism(Double exorcism) {
        this.exorcism = exorcism;
    }

    public Double getHammers() {
        return hammers;
    }

    public void setHammers(Double hammers) {
        this.hammers = hammers;
    }

    public Double getWarhammer() {
        return warhammer;
    }

    public void setWarhammer(Double warhammer) {
        this.warhammer = warhammer;
    }

    public Double getHealing() {
        return healing;
    }

    public void setHealing(Double healing) {
        this.healing = healing;
    }

    public Double getFirstaid() {
        return firstaid;
    }

    public void setFirstaid(Double firstaid) {
        this.firstaid = firstaid;
    }

    public Double getClubs() {
        return clubs;
    }

    public void setClubs(Double clubs) {
        this.clubs = clubs;
    }

    public Double getHugeclub() {
        return hugeclub;
    }

    public void setHugeclub(Double hugeclub) {
        this.hugeclub = hugeclub;
    }

    public Double getArchery() {
        return archery;
    }

    public void setArchery(Double archery) {
        this.archery = archery;
    }

    public Double getShortbow() {
        return shortbow;
    }

    public void setShortbow(Double shortbow) {
        this.shortbow = shortbow;
    }

    public Double getMediumbow() {
        return mediumbow;
    }

    public void setMediumbow(Double mediumbow) {
        this.mediumbow = mediumbow;
    }

    public Double getLongbow() {
        return longbow;
    }

    public void setLongbow(Double longbow) {
        this.longbow = longbow;
    }

    public Double getThievery() {
        return thievery;
    }

    public void setThievery(Double thievery) {
        this.thievery = thievery;
    }

    public Double getStealing() {
        return stealing;
    }

    public void setStealing(Double stealing) {
        this.stealing = stealing;
    }

    public Double getLockpicking() {
        return lockpicking;
    }

    public void setLockpicking(Double lockpicking) {
        this.lockpicking = lockpicking;
    }

    public Double getTraps() {
        return traps;
    }

    public void setTraps(Double traps) {
        this.traps = traps;
    }

    public Double getWarmachines() {
        return warmachines;
    }

    public void setWarmachines(Double warmachines) {
        this.warmachines = warmachines;
    }

    public Double getCatapults() {
        return catapults;
    }

    public void setCatapults(Double catapults) {
        this.catapults = catapults;
    }

    public Double getTrebuchets() {
        return trebuchets;
    }

    public void setTrebuchets(Double trebuchets) {
        this.trebuchets = trebuchets;
    }

    public Double getBallistae() {
        return ballistae;
    }

    public void setBallistae(Double ballistae) {
        this.ballistae = ballistae;
    }

    public Double getPolearms() {
        return polearms;
    }

    public void setPolearms(Double polearms) {
        this.polearms = polearms;
    }

    public Double getStaff() {
        return staff;
    }

    public void setStaff(Double staff) {
        this.staff = staff;
    }

    public Double getLongspear() {
        return longspear;
    }

    public void setLongspear(Double longspear) {
        this.longspear = longspear;
    }

    public Double getHalberd() {
        return halberd;
    }

    public void setHalberd(Double halberd) {
        this.halberd = halberd;
    }

    public Double getProspecting() {
        return prospecting;
    }

    public void setProspecting(Double prospecting) {
        this.prospecting = prospecting;
    }

    public Double getCoalmaking() {
        return coalmaking;
    }

    public void setCoalmaking(Double coalmaking) {
        this.coalmaking = coalmaking;
    }

    public Double getMilling() {
        return milling;
    }

    public void setMilling(Double milling) {
        this.milling = milling;
    }

    public Double getTracking() {
        return tracking;
    }

    public void setTracking(Double tracking) {
        this.tracking = tracking;
    }

    public Double getPaving() {
        return paving;
    }

    public void setPaving(Double paving) {
        this.paving = paving;
    }

    public Double getArchaeology() {
        return archaeology;
    }

    public void setArchaeology(Double archaeology) {
        this.archaeology = archaeology;
    }

    public Double getRestoration() {
        return restoration;
    }

    public void setRestoration(Double restoration) {
        this.restoration = restoration;
    }

    public Double getClimbing() {
        return climbing;
    }

    public void setClimbing(Double climbing) {
        this.climbing = climbing;
    }

    public Double getThatching() {
        return thatching;
    }

    public void setThatching(Double thatching) {
        this.thatching = thatching;
    }

    public Double getFiremaking() {
        return firemaking;
    }

    public void setFiremaking(Double firemaking) {
        this.firemaking = firemaking;
    }

    public Double getPottery() {
        return pottery;
    }

    public void setPottery(Double pottery) {
        this.pottery = pottery;
    }

    public Double getMining() {
        return mining;
    }

    public void setMining(Double mining) {
        this.mining = mining;
    }

    public Double getDigging() {
        return digging;
    }

    public void setDigging(Double digging) {
        this.digging = digging;
    }

    public Double getRopemaking() {
        return ropemaking;
    }

    public void setRopemaking(Double ropemaking) {
        this.ropemaking = ropemaking;
    }

    public Double getSmithing() {
        return smithing;
    }

    public void setSmithing(Double smithing) {
        this.smithing = smithing;
    }

    public Double getBlacksmithing() {
        return blacksmithing;
    }

    public void setBlacksmithing(Double blacksmithing) {
        this.blacksmithing = blacksmithing;
    }

    public Double getLocksmithing() {
        return locksmithing;
    }

    public void setLocksmithing(Double locksmithing) {
        this.locksmithing = locksmithing;
    }

    public Double getJewelrysmithing() {
        return jewelrysmithing;
    }

    public void setJewelrysmithing(Double jewelrysmithing) {
        this.jewelrysmithing = jewelrysmithing;
    }

    public Double getMetallurgy() {
        return metallurgy;
    }

    public void setMetallurgy(Double metallurgy) {
        this.metallurgy = metallurgy;
    }

    public Double getWeaponsmithing() {
        return weaponsmithing;
    }

    public void setWeaponsmithing(Double weaponsmithing) {
        this.weaponsmithing = weaponsmithing;
    }

    public Double getBladessmithing() {
        return bladessmithing;
    }

    public void setBladessmithing(Double bladessmithing) {
        this.bladessmithing = bladessmithing;
    }

    public Double getWeaponheadssmithing() {
        return weaponheadssmithing;
    }

    public void setWeaponheadssmithing(Double weaponheadssmithing) {
        this.weaponheadssmithing = weaponheadssmithing;
    }

    public Double getArmoursmithing() {
        return armoursmithing;
    }

    public void setArmoursmithing(Double armoursmithing) {
        this.armoursmithing = armoursmithing;
    }

    public Double getShieldsmithing() {
        return shieldsmithing;
    }

    public void setShieldsmithing(Double shieldsmithing) {
        this.shieldsmithing = shieldsmithing;
    }

    public Double getChainarmoursmithing() {
        return chainarmoursmithing;
    }

    public void setChainarmoursmithing(Double chainarmoursmithing) {
        this.chainarmoursmithing = chainarmoursmithing;
    }

    public Double getPlatearmoursmithing() {
        return platearmoursmithing;
    }

    public void setPlatearmoursmithing(Double platearmoursmithing) {
        this.platearmoursmithing = platearmoursmithing;
    }

    public Double getTailoring() {
        return tailoring;
    }

    public void setTailoring(Double tailoring) {
        this.tailoring = tailoring;
    }

    public Double getClothtailoring() {
        return clothtailoring;
    }

    public void setClothtailoring(Double clothtailoring) {
        this.clothtailoring = clothtailoring;
    }

    public Double getLeatherworking() {
        return leatherworking;
    }

    public void setLeatherworking(Double leatherworking) {
        this.leatherworking = leatherworking;
    }

    public Double getMasonry() {
        return masonry;
    }

    public void setMasonry(Double masonry) {
        this.masonry = masonry;
    }

    public Double getStonecutting() {
        return stonecutting;
    }

    public void setStonecutting(Double stonecutting) {
        this.stonecutting = stonecutting;
    }

    public Double getCooking() {
        return cooking;
    }

    public void setCooking(Double cooking) {
        this.cooking = cooking;
    }

    public Double getHotfoodcooking() {
        return hotfoodcooking;
    }

    public void setHotfoodcooking(Double hotfoodcooking) {
        this.hotfoodcooking = hotfoodcooking;
    }

    public Double getBaking() {
        return baking;
    }

    public void setBaking(Double baking) {
        this.baking = baking;
    }

    public Double getDairyfoodmaking() {
        return dairyfoodmaking;
    }

    public void setDairyfoodmaking(Double dairyfoodmaking) {
        this.dairyfoodmaking = dairyfoodmaking;
    }

    public Double getButchering() {
        return butchering;
    }

    public void setButchering(Double butchering) {
        this.butchering = butchering;
    }

    public Double getBeverages() {
        return beverages;
    }

    public void setBeverages(Double beverages) {
        this.beverages = beverages;
    }

    public Double getNature() {
        return nature;
    }

    public void setNature(Double nature) {
        this.nature = nature;
    }

    public Double getFishing() {
        return fishing;
    }

    public void setFishing(Double fishing) {
        this.fishing = fishing;
    }

    public Double getGardening() {
        return gardening;
    }

    public void setGardening(Double gardening) {
        this.gardening = gardening;
    }

    public Double getForaging() {
        return foraging;
    }

    public void setForaging(Double foraging) {
        this.foraging = foraging;
    }

    public Double getBotanizing() {
        return botanizing;
    }

    public void setBotanizing(Double botanizing) {
        this.botanizing = botanizing;
    }

    public Double getAnimaltaming() {
        return animaltaming;
    }

    public void setAnimaltaming(Double animaltaming) {
        this.animaltaming = animaltaming;
    }

    public Double getForestry() {
        return forestry;
    }

    public void setForestry(Double forestry) {
        this.forestry = forestry;
    }

    public Double getFarming() {
        return farming;
    }

    public void setFarming(Double farming) {
        this.farming = farming;
    }

    public Double getMilking() {
        return milking;
    }

    public void setMilking(Double milking) {
        this.milking = milking;
    }

    public Double getMeditating() {
        return meditating;
    }

    public void setMeditating(Double meditating) {
        this.meditating = meditating;
    }

    public Double getAnimalhusbandry() {
        return animalhusbandry;
    }

    public void setAnimalhusbandry(Double animalhusbandry) {
        this.animalhusbandry = animalhusbandry;
    }

    public Double getPapyrusmaking() {
        return papyrusmaking;
    }

    public void setPapyrusmaking(Double papyrusmaking) {
        this.papyrusmaking = papyrusmaking;
    }

    public Double getToys() {
        return toys;
    }

    public void setToys(Double toys) {
        this.toys = toys;
    }

    public Double getYoyo() {
        return yoyo;
    }

    public void setYoyo(Double yoyo) {
        this.yoyo = yoyo;
    }

    public Double getPuppeteering() {
        return puppeteering;
    }

    public void setPuppeteering(Double puppeteering) {
        this.puppeteering = puppeteering;
    }

    public Double getFighting() {
        return fighting;
    }

    public void setFighting(Double fighting) {
        this.fighting = fighting;
    }

    public Double getDefensivefighting() {
        return defensivefighting;
    }

    public void setDefensivefighting(Double defensivefighting) {
        this.defensivefighting = defensivefighting;
    }

    public Double getNormalfighting() {
        return normalfighting;
    }

    public void setNormalfighting(Double normalfighting) {
        this.normalfighting = normalfighting;
    }

    public Double getWeaponlessfighting() {
        return weaponlessfighting;
    }

    public void setWeaponlessfighting(Double weaponlessfighting) {
        this.weaponlessfighting = weaponlessfighting;
    }

    public Double getAggressivefighting() {
        return aggressivefighting;
    }

    public void setAggressivefighting(Double aggressivefighting) {
        this.aggressivefighting = aggressivefighting;
    }

    public Double getShieldbashing() {
        return shieldbashing;
    }

    public void setShieldbashing(Double shieldbashing) {
        this.shieldbashing = shieldbashing;
    }

    public Double getTaunting() {
        return taunting;
    }

    public void setTaunting(Double taunting) {
        this.taunting = taunting;
    }

    public Double getMiscellaneousitems() {
        return miscellaneousitems;
    }

    public void setMiscellaneousitems(Double miscellaneousitems) {
        this.miscellaneousitems = miscellaneousitems;
    }

    public Double getShovel() {
        return shovel;
    }

    public void setShovel(Double shovel) {
        this.shovel = shovel;
    }

    public Double getRake() {
        return rake;
    }

    public void setRake(Double rake) {
        this.rake = rake;
    }

    public Double getSaw() {
        return saw;
    }

    public void setSaw(Double saw) {
        this.saw = saw;
    }

    public Double getPickaxe() {
        return pickaxe;
    }

    public void setPickaxe(Double pickaxe) {
        this.pickaxe = pickaxe;
    }

    public Double getRepairing() {
        return repairing;
    }

    public void setRepairing(Double repairing) {
        this.repairing = repairing;
    }

    public Double getSickle() {
        return sickle;
    }

    public void setSickle(Double sickle) {
        this.sickle = sickle;
    }

    public Double getScythe() {
        return scythe;
    }

    public void setScythe(Double scythe) {
        this.scythe = scythe;
    }

    public Double getHammer() {
        return hammer;
    }

    public void setHammer(Double hammer) {
        this.hammer = hammer;
    }

    public Double getStonechisel() {
        return stonechisel;
    }

    public void setStonechisel(Double stonechisel) {
        this.stonechisel = stonechisel;
    }

    public Double getAlchemy() {
        return alchemy;
    }

    public void setAlchemy(Double alchemy) {
        this.alchemy = alchemy;
    }

    public Double getNaturalsubstances() {
        return naturalsubstances;
    }

    public void setNaturalsubstances(Double naturalsubstances) {
        this.naturalsubstances = naturalsubstances;
    }

    public Double getShields() {
        return shields;
    }

    public void setShields(Double shields) {
        this.shields = shields;
    }

    public Double getMediummetalshield() {
        return mediummetalshield;
    }

    public void setMediummetalshield(Double mediummetalshield) {
        this.mediummetalshield = mediummetalshield;
    }

    public Double getSmallwoodenshield() {
        return smallwoodenshield;
    }

    public void setSmallwoodenshield(Double smallwoodenshield) {
        this.smallwoodenshield = smallwoodenshield;
    }

    public Double getSmallmetalshield() {
        return smallmetalshield;
    }

    public void setSmallmetalshield(Double smallmetalshield) {
        this.smallmetalshield = smallmetalshield;
    }

    public Double getLargemetalshield() {
        return largemetalshield;
    }

    public void setLargemetalshield(Double largemetalshield) {
        this.largemetalshield = largemetalshield;
    }

    public Double getMediumwoodenshield() {
        return mediumwoodenshield;
    }

    public void setMediumwoodenshield(Double mediumwoodenshield) {
        this.mediumwoodenshield = mediumwoodenshield;
    }

    public Double getLargewoodenshield() {
        return largewoodenshield;
    }

    public void setLargewoodenshield(Double largewoodenshield) {
        this.largewoodenshield = largewoodenshield;
    }

    public Double getAxes() {
        return axes;
    }

    public void setAxes(Double axes) {
        this.axes = axes;
    }

    public Double getHatchet() {
        return hatchet;
    }

    public void setHatchet(Double hatchet) {
        this.hatchet = hatchet;
    }

    public Double getSmallaxe() {
        return smallaxe;
    }

    public void setSmallaxe(Double smallaxe) {
        this.smallaxe = smallaxe;
    }

    public Double getLargeaxe() {
        return largeaxe;
    }

    public void setLargeaxe(Double largeaxe) {
        this.largeaxe = largeaxe;
    }

    public Double getHugeaxe() {
        return hugeaxe;
    }

    public void setHugeaxe(Double hugeaxe) {
        this.hugeaxe = hugeaxe;
    }

    public Double getSwords() {
        return swords;
    }

    public void setSwords(Double swords) {
        this.swords = swords;
    }

    public Double getLongsword() {
        return longsword;
    }

    public void setLongsword(Double longsword) {
        this.longsword = longsword;
    }

    public Double getShortsword() {
        return shortsword;
    }

    public void setShortsword(Double shortsword) {
        this.shortsword = shortsword;
    }

    public Double getTwohandedsword() {
        return twohandedsword;
    }

    public void setTwohandedsword(Double twohandedsword) {
        this.twohandedsword = twohandedsword;
    }

    public Double getKnives() {
        return knives;
    }

    public void setKnives(Double knives) {
        this.knives = knives;
    }

    public Double getCarvingknife() {
        return carvingknife;
    }

    public void setCarvingknife(Double carvingknife) {
        this.carvingknife = carvingknife;
    }

    public Double getButcheringknife() {
        return butcheringknife;
    }

    public void setButcheringknife(Double butcheringknife) {
        this.butcheringknife = butcheringknife;
    }

    public Double getWoodcutting() {
        return woodcutting;
    }

    public void setWoodcutting(Double woodcutting) {
        this.woodcutting = woodcutting;
    }

    public Double getMauls() {
        return mauls;
    }

    public void setMauls(Double mauls) {
        this.mauls = mauls;
    }

    public Double getMediummaul() {
        return mediummaul;
    }

    public void setMediummaul(Double mediummaul) {
        this.mediummaul = mediummaul;
    }

    public Double getSmallmaul() {
        return smallmaul;
    }

    public void setSmallmaul(Double smallmaul) {
        this.smallmaul = smallmaul;
    }

    public Double getLargemaul() {
        return largemaul;
    }

    public void setLargemaul(Double largemaul) {
        this.largemaul = largemaul;
    }

    public Double getCarpentry() {
        return carpentry;
    }

    public void setCarpentry(Double carpentry) {
        this.carpentry = carpentry;
    }

    public Double getBowyery() {
        return bowyery;
    }

    public void setBowyery(Double bowyery) {
        this.bowyery = bowyery;
    }

    public Double getFletching() {
        return fletching;
    }

    public void setFletching(Double fletching) {
        this.fletching = fletching;
    }

    public Double getFinecarpentry() {
        return finecarpentry;
    }

    public void setFinecarpentry(Double finecarpentry) {
        this.finecarpentry = finecarpentry;
    }

    public Double getToymaking() {
        return toymaking;
    }

    public void setToymaking(Double toymaking) {
        this.toymaking = toymaking;
    }

    public Double getShipbuilding() {
        return shipbuilding;
    }

    public void setShipbuilding(Double shipbuilding) {
        this.shipbuilding = shipbuilding;
    }

    public Double getMind() {
        return mind;
    }

    public void setMind(Double mind) {
        this.mind = mind;
    }

    public Double getMindlogic() {
        return mindlogic;
    }

    public void setMindlogic(Double mindlogic) {
        this.mindlogic = mindlogic;
    }

    public Double getMindspeed() {
        return mindspeed;
    }

    public void setMindspeed(Double mindspeed) {
        this.mindspeed = mindspeed;
    }

    public Double getSoul() {
        return soul;
    }

    public void setSoul(Double soul) {
        this.soul = soul;
    }

    public Double getSouldepth() {
        return souldepth;
    }

    public void setSouldepth(Double souldepth) {
        this.souldepth = souldepth;
    }

    public Double getSoulstrength() {
        return soulstrength;
    }

    public void setSoulstrength(Double soulstrength) {
        this.soulstrength = soulstrength;
    }

    public Double getBody() {
        return body;
    }

    public void setBody(Double body) {
        this.body = body;
    }

    public Double getBodystrength() {
        return bodystrength;
    }

    public void setBodystrength(Double bodystrength) {
        this.bodystrength = bodystrength;
    }

    public Double getBodystamina() {
        return bodystamina;
    }

    public void setBodystamina(Double bodystamina) {
        this.bodystamina = bodystamina;
    }

    public Double getBodycontrol() {
        return bodycontrol;
    }

    public void setBodycontrol(Double bodycontrol) {
        this.bodycontrol = bodycontrol;
    }

    public Double getFaith() {
        return faith;
    }

    public void setFaith(Double faith) {
        this.faith = faith;
    }

    public Double getFavor() {
        return favor;
    }

    public void setFavor(Double favor) {
        this.favor = favor;
    }

    public Double getAlignment() {
        return alignment;
    }

    public void setAlignment(Double alignment) {
        this.alignment = alignment;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SkillsDTO)) {
            return false;
        }

        SkillsDTO skillsDTO = (SkillsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, skillsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SkillsDTO{" +
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
            ", user=" + getUser() +
            "}";
    }
}
