package net.northern.verasm.web.rest.Utils;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import net.northern.verasm.service.dto.SkillsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class SkillDumpParser {

    private final Logger log = LoggerFactory.getLogger(SkillDumpParser.class);
    private MultipartFile file;

    public SkillDumpParser(MultipartFile file) {
        this.file = file;
    }

    public SkillsDTO parseData() {
        SkillsDTO skillsDTO = new SkillsDTO();

        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(file.getBytes());

            String content = new String(stream.readAllBytes());
            List<String> charInfo = new ArrayList<>();
            File convfile = new File(file.getOriginalFilename());
            convfile.createNewFile();
            skillsDTO.setDumptime(convfile.getName());
            charInfo = readFirst(convfile.toPath(), 4); //get first 4 lines for initial 'metadata' / character data
            for (String line : charInfo) {
                if (!line.contains("dumped")) {
                    String[] data = line.split(":");

                    switch (data[0].toLowerCase()) {
                        case "player":
                            skillsDTO.setPlayername(data[1].trim());
                            break;
                        case "premium":
                            skillsDTO.setPremium(data[1].trim());
                            break;
                        case "server":
                            skillsDTO.setServer(data[1].trim());
                    }
                }
            }
            //match to floats
            Pattern pattern = Pattern.compile(": (?:([0-9]+(\\.[0-9]*)?|\\.[0-9]+))", Pattern.CASE_INSENSITIVE);
            //replace first set of useless float
            content = pattern.matcher(content).replaceAll("");
            // now we should have
            // skillNameString skillFloat AffinityInteger
            // now read over each newline to extract data:
            Stream<String> linesFromString = content.lines();
            linesFromString.forEach(l -> {
                //skip metadata
                if (l.contains("dumped") || l.contains("layer") || l.contains("remium") || l.contains("erver") || l.contains("---")) return;
                l = l.trim();
                String[] skill = l.split(" "); // can be size 3 or 4, (if skill is 2 words...)
                Pattern SkillNamePattern = Pattern.compile("([A-Z])\\w+");
                Pattern SkillName2Pattern = Pattern.compile("([a-z])\\w+");

                StringBuilder skillName = new StringBuilder();
                Integer stringPosEnd = -1;

                //find all strings in skill name that were separated by space
                for (int i = 0; i < skill.length; i++) {
                    Matcher matcher = SkillNamePattern.matcher(skill[i]);
                    Matcher matcher1 = SkillName2Pattern.matcher(skill[i]);
                    if (matcher.find() || matcher1.find()) stringPosEnd++;
                }
                //connect them all to one
                for (int i = 0; i <= stringPosEnd; i++) {
                    skillName.append(skill[i]);
                }
                Double SkillNum = Double.parseDouble(skill[stringPosEnd + 1]);
                if (
                    SkillNum == 0.0
                ) return; //skip 0.0 skills, (possible group denoting)
                Integer affinity = Integer.parseInt(skill[stringPosEnd + 2]);
                //make lower skillname
                skillName = new StringBuilder(skillName.toString().toLowerCase());
                log.info("Skill name and number: {}, {}", skillName.toString(), SkillNum);
                if (SkillNum == 0.0) {
                    log.debug("Skip over useless line while parsing, possible denoting a group, {}", skill[0]);
                } else {
                    switch (skillName.toString().toLowerCase(Locale.US)) {
                        case "religion":
                            skillsDTO.setReligion(SkillNum);
                            break;
                        case "prayer":
                            skillsDTO.setPrayer(SkillNum);
                            break;
                        case "channeling":
                            skillsDTO.setChanneling(SkillNum);
                            break;
                        case "preaching":
                            skillsDTO.setPreaching(SkillNum);
                            break;
                        case "exorcism":
                            skillsDTO.setExorcism(SkillNum);
                            break;
                        case "hammers":
                            skillsDTO.setHammers(SkillNum);
                            break;
                        case "warhammer":
                            skillsDTO.setWarhammer(SkillNum);
                            break;
                        case "healing":
                            skillsDTO.setHealing(SkillNum);
                            break;
                        case "firstaid":
                            skillsDTO.setFirstaid(SkillNum);
                            break;
                        case "clubs":
                            skillsDTO.setClubs(SkillNum);
                            break;
                        case "hugeclub":
                            skillsDTO.setHugeclub(SkillNum);
                            break;
                        case "archery":
                            skillsDTO.setArchery(SkillNum);
                            break;
                        case "shortbow":
                            skillsDTO.setShortbow(SkillNum);
                            break;
                        case "mediumbow":
                            skillsDTO.setMediumbow(SkillNum);
                            break;
                        case "longbow":
                            skillsDTO.setLongbow(SkillNum);
                            break;
                        case "thievery":
                            skillsDTO.setThievery(SkillNum);
                            break;
                        case "stealing":
                            skillsDTO.setStealing(SkillNum);
                            break;
                        case "lockpicking":
                            skillsDTO.setLockpicking(SkillNum);
                            break;
                        case "traps":
                            skillsDTO.setTraps(SkillNum);
                            break;
                        case "warmachines":
                            skillsDTO.setWarmachines(SkillNum);
                            break;
                        case "catapults":
                            skillsDTO.setCatapults(SkillNum);
                            break;
                        case "trebuchets":
                            skillsDTO.setTrebuchets(SkillNum);
                            break;
                        case "ballistae":
                            skillsDTO.setBallistae(SkillNum);
                            break;
                        case "polearms":
                            skillsDTO.setPolearms(SkillNum);
                            break;
                        case "staff":
                            skillsDTO.setStaff(SkillNum);
                            break;
                        case "longspear":
                            skillsDTO.setLongspear(SkillNum);
                            break;
                        case "halberd":
                            skillsDTO.setHalberd(SkillNum);
                            break;
                        case "prospecting":
                            skillsDTO.setProspecting(SkillNum);
                            break;
                        case "coal-making":
                            skillsDTO.setCoalmaking(SkillNum);
                            break;
                        case "milling":
                            skillsDTO.setMilling(SkillNum);
                            break;
                        case "tracking":
                            skillsDTO.setTracking(SkillNum);
                            break;
                        case "paving":
                            skillsDTO.setPaving(SkillNum);
                            break;
                        case "archaeology":
                            skillsDTO.setArchaeology(SkillNum);
                            break;
                        case "restoration":
                            skillsDTO.setRestoration(SkillNum);
                            break;
                        case "climbing":
                            skillsDTO.setClimbing(SkillNum);
                            break;
                        case "thatching":
                            skillsDTO.setThatching(SkillNum);
                            break;
                        case "firemaking":
                            skillsDTO.setFiremaking(SkillNum);
                            break;
                        case "pottery":
                            skillsDTO.setPottery(SkillNum);
                            break;
                        case "mining":
                            skillsDTO.setMining(SkillNum);
                            break;
                        case "digging":
                            skillsDTO.setDigging(SkillNum);
                            break;
                        case "ropemaking":
                            skillsDTO.setRopemaking(SkillNum);
                            break;
                        case "smithing":
                            skillsDTO.setSmithing(SkillNum);
                            break;
                        case "blacksmithing":
                            skillsDTO.setBlacksmithing(SkillNum);
                            break;
                        case "locksmithing":
                            skillsDTO.setLocksmithing(SkillNum);
                            break;
                        case "jewelrysmithing":
                            skillsDTO.setJewelrysmithing(SkillNum);
                            break;
                        case "metallurgy":
                            skillsDTO.setMetallurgy(SkillNum);
                            break;
                        case "weaponsmithing":
                            skillsDTO.setWeaponsmithing(SkillNum);
                            break;
                        case "bladessmithing":
                            skillsDTO.setBladessmithing(SkillNum);
                            break;
                        case "weaponheadssmithing":
                            skillsDTO.setWeaponheadssmithing(SkillNum);
                            break;
                        case "armoursmithing":
                            skillsDTO.setArmoursmithing(SkillNum);
                            break;
                        case "shieldsmithing":
                            skillsDTO.setShieldsmithing(SkillNum);
                            break;
                        case "chainarmoursmithing":
                            skillsDTO.setChainarmoursmithing(SkillNum);
                            break;
                        case "platearmoursmithing":
                            skillsDTO.setPlatearmoursmithing(SkillNum);
                            break;
                        case "tailoring":
                            skillsDTO.setTailoring(SkillNum);
                            break;
                        case "clothtailoring":
                            skillsDTO.setClothtailoring(SkillNum);
                            break;
                        case "leatherworking":
                            skillsDTO.setLeatherworking(SkillNum);
                            break;
                        case "masonry":
                            skillsDTO.setMasonry(SkillNum);
                            break;
                        case "stonecutting":
                            skillsDTO.setStonecutting(SkillNum);
                            break;
                        case "cooking":
                            skillsDTO.setCooking(SkillNum);
                            break;
                        case "hotfoodcooking":
                            skillsDTO.setHotfoodcooking(SkillNum);
                            break;
                        case "baking":
                            skillsDTO.setBaking(SkillNum);
                            break;
                        case "dairyfoodmaking":
                            skillsDTO.setDairyfoodmaking(SkillNum);
                            break;
                        case "butchering":
                            skillsDTO.setButchering(SkillNum);
                            break;
                        case "beverages":
                            skillsDTO.setBeverages(SkillNum);
                            break;
                        case "nature":
                            skillsDTO.setNature(SkillNum);
                            break;
                        case "fishing":
                            skillsDTO.setFishing(SkillNum);
                            break;
                        case "gardening":
                            skillsDTO.setGardening(SkillNum);
                            break;
                        case "foraging":
                            skillsDTO.setForaging(SkillNum);
                            break;
                        case "botanizing":
                            skillsDTO.setBotanizing(SkillNum);
                            break;
                        case "animaltaming":
                            skillsDTO.setAnimaltaming(SkillNum);
                            break;
                        case "forestry":
                            skillsDTO.setForestry(SkillNum);
                            break;
                        case "farming":
                            skillsDTO.setFarming(SkillNum);
                            break;
                        case "milking":
                            skillsDTO.setMilking(SkillNum);
                            break;
                        case "meditating":
                            skillsDTO.setMeditating(SkillNum);
                            break;
                        case "animalhusbandry":
                            skillsDTO.setAnimalhusbandry(SkillNum);
                            break;
                        case "papyrusmaking":
                            skillsDTO.setPapyrusmaking(SkillNum);
                            break;
                        case "toys":
                            skillsDTO.setToys(SkillNum);
                            break;
                        case "yoyo":
                            skillsDTO.setYoyo(SkillNum);
                            break;
                        case "puppeteering":
                            skillsDTO.setPuppeteering(SkillNum);
                            break;
                        case "fighting":
                            skillsDTO.setFighting(SkillNum);
                            break;
                        case "defensivefighting":
                            skillsDTO.setDefensivefighting(SkillNum);
                            break;
                        case "normalfighting":
                            skillsDTO.setNormalfighting(SkillNum);
                            break;
                        case "weaponlessfighting":
                            skillsDTO.setWeaponlessfighting(SkillNum);
                            break;
                        case "aggressivefighting":
                            skillsDTO.setAggressivefighting(SkillNum);
                            break;
                        case "shieldbashing":
                            skillsDTO.setShieldbashing(SkillNum);
                            break;
                        case "taunting":
                            skillsDTO.setTaunting(SkillNum);
                            break;
                        case "miscellaneousitems":
                            skillsDTO.setMiscellaneousitems(SkillNum);
                            break;
                        case "shovel":
                            skillsDTO.setShovel(SkillNum);
                            break;
                        case "rake":
                            skillsDTO.setRake(SkillNum);
                            break;
                        case "saw":
                            skillsDTO.setSaw(SkillNum);
                            break;
                        case "pickaxe":
                            skillsDTO.setPickaxe(SkillNum);
                            break;
                        case "repairing":
                            skillsDTO.setRepairing(SkillNum);
                            break;
                        case "sickle":
                            skillsDTO.setSickle(SkillNum);
                            break;
                        case "scythe":
                            skillsDTO.setScythe(SkillNum);
                            break;
                        case "hammer":
                            skillsDTO.setHammer(SkillNum);
                            break;
                        case "stonechisel":
                            skillsDTO.setStonechisel(SkillNum);
                            break;
                        case "alchemy":
                            skillsDTO.setAlchemy(SkillNum);
                            break;
                        case "naturalsubstances":
                            skillsDTO.setNaturalsubstances(SkillNum);
                            break;
                        case "shields":
                            skillsDTO.setShields(SkillNum);
                            break;
                        case "mediummetalshield":
                            skillsDTO.setMediummetalshield(SkillNum);
                            break;
                        case "smallwoodenshield":
                            skillsDTO.setSmallwoodenshield(SkillNum);
                            break;
                        case "smallmetalshield":
                            skillsDTO.setSmallmetalshield(SkillNum);
                            break;
                        case "largemetalshield":
                            skillsDTO.setLargemetalshield(SkillNum);
                            break;
                        case "mediumwoodenshield":
                            skillsDTO.setMediumwoodenshield(SkillNum);
                            break;
                        case "largewoodenshield":
                            skillsDTO.setLargewoodenshield(SkillNum);
                            break;
                        case "axes":
                            skillsDTO.setAxes(SkillNum);
                            break;
                        case "hatchet":
                            skillsDTO.setHatchet(SkillNum);
                            break;
                        case "smallaxe":
                            skillsDTO.setSmallaxe(SkillNum);
                            break;
                        case "largeaxe":
                            skillsDTO.setLargeaxe(SkillNum);
                            break;
                        case "hugeaxe":
                            skillsDTO.setHugeaxe(SkillNum);
                            break;
                        case "swords":
                            skillsDTO.setSwords(SkillNum);
                            break;
                        case "longsword":
                            skillsDTO.setLongsword(SkillNum);
                            break;
                        case "shortsword":
                            skillsDTO.setShortsword(SkillNum);
                            break;
                        case "twohandedsword":
                            skillsDTO.setTwohandedsword(SkillNum);
                            break;
                        case "knives":
                            skillsDTO.setKnives(SkillNum);
                            break;
                        case "carvingknife":
                            skillsDTO.setCarvingknife(SkillNum);
                            break;
                        case "butcheringknife":
                            skillsDTO.setButcheringknife(SkillNum);
                            break;
                        case "woodcutting":
                            skillsDTO.setWoodcutting(SkillNum);
                            break;
                        case "mauls":
                            skillsDTO.setMauls(SkillNum);
                            break;
                        case "mediummaul":
                            skillsDTO.setMediummaul(SkillNum);
                            break;
                        case "smallmaul":
                            skillsDTO.setSmallmaul(SkillNum);
                            break;
                        case "largemaul":
                            skillsDTO.setLargemaul(SkillNum);
                            break;
                        case "carpentry":
                            skillsDTO.setCarpentry(SkillNum);
                            break;
                        case "bowyery":
                            skillsDTO.setBowyery(SkillNum);
                            break;
                        case "fletching":
                            skillsDTO.setFletching(SkillNum);
                            break;
                        case "finecarpentry":
                            skillsDTO.setFinecarpentry(SkillNum);
                            break;
                        case "toymaking":
                            skillsDTO.setToymaking(SkillNum);
                            break;
                        case "shipbuilding":
                            skillsDTO.setShipbuilding(SkillNum);
                            break;
                        case "mind":
                            skillsDTO.setMind(SkillNum);
                            break;
                        case "mindlogic":
                            skillsDTO.setMindlogic(SkillNum);
                            break;
                        case "mindspeed":
                            skillsDTO.setMindspeed(SkillNum);
                            break;
                        case "soul":
                            skillsDTO.setSoul(SkillNum);
                            break;
                        case "souldepth":
                            skillsDTO.setSouldepth(SkillNum);
                            break;
                        case "soulstrength":
                            skillsDTO.setSoulstrength(SkillNum);
                            break;
                        case "body":
                            skillsDTO.setBody(SkillNum);
                            break;
                        case "bodystrength":
                            skillsDTO.setBodystrength(SkillNum);
                            break;
                        case "bodystamina":
                            skillsDTO.setBodystamina(SkillNum);
                            break;
                        case "bodycontrol":
                            skillsDTO.setBodycontrol(SkillNum);
                            break;
                        case "faith":
                            skillsDTO.setFaith(SkillNum);
                            break;
                        case "favor":
                            skillsDTO.setFavor(SkillNum);
                            break;
                        case "alignment":
                            log.debug("alignment:  ---: {}", SkillNum);
                            skillsDTO.setAlignment(SkillNum);
                            break;
                    }
                }
            });
            return skillsDTO;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List<String> readFirst(final Path path, final int numLines) throws IOException {
        try (final Stream<String> lines = Files.lines(path)) {
            return lines.limit(numLines).collect(toList());
        }
    }
}
