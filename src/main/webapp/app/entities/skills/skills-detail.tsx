import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './skills.reducer';

export const SkillsDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const skillsEntity = useAppSelector(state => state.skills.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="skillsDetailsHeading">
          <Translate contentKey="verasmApp.skills.detail.title">Skills</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.id}</dd>
          <dt>
            <span id="dumptime">
              <Translate contentKey="verasmApp.skills.dumptime">Dumptime</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.dumptime}</dd>
          <dt>
            <span id="playername">
              <Translate contentKey="verasmApp.skills.playername">Playername</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.playername}</dd>
          <dt>
            <span id="premium">
              <Translate contentKey="verasmApp.skills.premium">Premium</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.premium}</dd>
          <dt>
            <span id="server">
              <Translate contentKey="verasmApp.skills.server">Server</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.server}</dd>
          <dt>
            <span id="religion">
              <Translate contentKey="verasmApp.skills.religion">Religion</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.religion}</dd>
          <dt>
            <span id="prayer">
              <Translate contentKey="verasmApp.skills.prayer">Prayer</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.prayer}</dd>
          <dt>
            <span id="channeling">
              <Translate contentKey="verasmApp.skills.channeling">Channeling</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.channeling}</dd>
          <dt>
            <span id="preaching">
              <Translate contentKey="verasmApp.skills.preaching">Preaching</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.preaching}</dd>
          <dt>
            <span id="exorcism">
              <Translate contentKey="verasmApp.skills.exorcism">Exorcism</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.exorcism}</dd>
          <dt>
            <span id="hammers">
              <Translate contentKey="verasmApp.skills.hammers">Hammers</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.hammers}</dd>
          <dt>
            <span id="warhammer">
              <Translate contentKey="verasmApp.skills.warhammer">Warhammer</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.warhammer}</dd>
          <dt>
            <span id="healing">
              <Translate contentKey="verasmApp.skills.healing">Healing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.healing}</dd>
          <dt>
            <span id="firstaid">
              <Translate contentKey="verasmApp.skills.firstaid">Firstaid</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.firstaid}</dd>
          <dt>
            <span id="clubs">
              <Translate contentKey="verasmApp.skills.clubs">Clubs</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.clubs}</dd>
          <dt>
            <span id="hugeclub">
              <Translate contentKey="verasmApp.skills.hugeclub">Hugeclub</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.hugeclub}</dd>
          <dt>
            <span id="archery">
              <Translate contentKey="verasmApp.skills.archery">Archery</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.archery}</dd>
          <dt>
            <span id="shortbow">
              <Translate contentKey="verasmApp.skills.shortbow">Shortbow</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.shortbow}</dd>
          <dt>
            <span id="mediumbow">
              <Translate contentKey="verasmApp.skills.mediumbow">Mediumbow</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.mediumbow}</dd>
          <dt>
            <span id="longbow">
              <Translate contentKey="verasmApp.skills.longbow">Longbow</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.longbow}</dd>
          <dt>
            <span id="thievery">
              <Translate contentKey="verasmApp.skills.thievery">Thievery</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.thievery}</dd>
          <dt>
            <span id="stealing">
              <Translate contentKey="verasmApp.skills.stealing">Stealing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.stealing}</dd>
          <dt>
            <span id="lockpicking">
              <Translate contentKey="verasmApp.skills.lockpicking">Lockpicking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.lockpicking}</dd>
          <dt>
            <span id="traps">
              <Translate contentKey="verasmApp.skills.traps">Traps</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.traps}</dd>
          <dt>
            <span id="warmachines">
              <Translate contentKey="verasmApp.skills.warmachines">Warmachines</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.warmachines}</dd>
          <dt>
            <span id="catapults">
              <Translate contentKey="verasmApp.skills.catapults">Catapults</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.catapults}</dd>
          <dt>
            <span id="trebuchets">
              <Translate contentKey="verasmApp.skills.trebuchets">Trebuchets</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.trebuchets}</dd>
          <dt>
            <span id="ballistae">
              <Translate contentKey="verasmApp.skills.ballistae">Ballistae</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.ballistae}</dd>
          <dt>
            <span id="polearms">
              <Translate contentKey="verasmApp.skills.polearms">Polearms</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.polearms}</dd>
          <dt>
            <span id="staff">
              <Translate contentKey="verasmApp.skills.staff">Staff</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.staff}</dd>
          <dt>
            <span id="longspear">
              <Translate contentKey="verasmApp.skills.longspear">Longspear</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.longspear}</dd>
          <dt>
            <span id="halberd">
              <Translate contentKey="verasmApp.skills.halberd">Halberd</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.halberd}</dd>
          <dt>
            <span id="prospecting">
              <Translate contentKey="verasmApp.skills.prospecting">Prospecting</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.prospecting}</dd>
          <dt>
            <span id="coalmaking">
              <Translate contentKey="verasmApp.skills.coalmaking">Coalmaking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.coalmaking}</dd>
          <dt>
            <span id="milling">
              <Translate contentKey="verasmApp.skills.milling">Milling</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.milling}</dd>
          <dt>
            <span id="tracking">
              <Translate contentKey="verasmApp.skills.tracking">Tracking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.tracking}</dd>
          <dt>
            <span id="paving">
              <Translate contentKey="verasmApp.skills.paving">Paving</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.paving}</dd>
          <dt>
            <span id="archaeology">
              <Translate contentKey="verasmApp.skills.archaeology">Archaeology</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.archaeology}</dd>
          <dt>
            <span id="restoration">
              <Translate contentKey="verasmApp.skills.restoration">Restoration</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.restoration}</dd>
          <dt>
            <span id="climbing">
              <Translate contentKey="verasmApp.skills.climbing">Climbing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.climbing}</dd>
          <dt>
            <span id="thatching">
              <Translate contentKey="verasmApp.skills.thatching">Thatching</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.thatching}</dd>
          <dt>
            <span id="firemaking">
              <Translate contentKey="verasmApp.skills.firemaking">Firemaking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.firemaking}</dd>
          <dt>
            <span id="pottery">
              <Translate contentKey="verasmApp.skills.pottery">Pottery</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.pottery}</dd>
          <dt>
            <span id="mining">
              <Translate contentKey="verasmApp.skills.mining">Mining</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.mining}</dd>
          <dt>
            <span id="digging">
              <Translate contentKey="verasmApp.skills.digging">Digging</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.digging}</dd>
          <dt>
            <span id="ropemaking">
              <Translate contentKey="verasmApp.skills.ropemaking">Ropemaking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.ropemaking}</dd>
          <dt>
            <span id="smithing">
              <Translate contentKey="verasmApp.skills.smithing">Smithing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.smithing}</dd>
          <dt>
            <span id="blacksmithing">
              <Translate contentKey="verasmApp.skills.blacksmithing">Blacksmithing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.blacksmithing}</dd>
          <dt>
            <span id="locksmithing">
              <Translate contentKey="verasmApp.skills.locksmithing">Locksmithing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.locksmithing}</dd>
          <dt>
            <span id="jewelrysmithing">
              <Translate contentKey="verasmApp.skills.jewelrysmithing">Jewelrysmithing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.jewelrysmithing}</dd>
          <dt>
            <span id="metallurgy">
              <Translate contentKey="verasmApp.skills.metallurgy">Metallurgy</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.metallurgy}</dd>
          <dt>
            <span id="weaponsmithing">
              <Translate contentKey="verasmApp.skills.weaponsmithing">Weaponsmithing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.weaponsmithing}</dd>
          <dt>
            <span id="bladessmithing">
              <Translate contentKey="verasmApp.skills.bladessmithing">Bladessmithing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.bladessmithing}</dd>
          <dt>
            <span id="weaponheadssmithing">
              <Translate contentKey="verasmApp.skills.weaponheadssmithing">Weaponheadssmithing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.weaponheadssmithing}</dd>
          <dt>
            <span id="armoursmithing">
              <Translate contentKey="verasmApp.skills.armoursmithing">Armoursmithing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.armoursmithing}</dd>
          <dt>
            <span id="shieldsmithing">
              <Translate contentKey="verasmApp.skills.shieldsmithing">Shieldsmithing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.shieldsmithing}</dd>
          <dt>
            <span id="chainarmoursmithing">
              <Translate contentKey="verasmApp.skills.chainarmoursmithing">Chainarmoursmithing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.chainarmoursmithing}</dd>
          <dt>
            <span id="platearmoursmithing">
              <Translate contentKey="verasmApp.skills.platearmoursmithing">Platearmoursmithing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.platearmoursmithing}</dd>
          <dt>
            <span id="tailoring">
              <Translate contentKey="verasmApp.skills.tailoring">Tailoring</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.tailoring}</dd>
          <dt>
            <span id="clothtailoring">
              <Translate contentKey="verasmApp.skills.clothtailoring">Clothtailoring</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.clothtailoring}</dd>
          <dt>
            <span id="leatherworking">
              <Translate contentKey="verasmApp.skills.leatherworking">Leatherworking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.leatherworking}</dd>
          <dt>
            <span id="masonry">
              <Translate contentKey="verasmApp.skills.masonry">Masonry</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.masonry}</dd>
          <dt>
            <span id="stonecutting">
              <Translate contentKey="verasmApp.skills.stonecutting">Stonecutting</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.stonecutting}</dd>
          <dt>
            <span id="cooking">
              <Translate contentKey="verasmApp.skills.cooking">Cooking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.cooking}</dd>
          <dt>
            <span id="hotfoodcooking">
              <Translate contentKey="verasmApp.skills.hotfoodcooking">Hotfoodcooking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.hotfoodcooking}</dd>
          <dt>
            <span id="baking">
              <Translate contentKey="verasmApp.skills.baking">Baking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.baking}</dd>
          <dt>
            <span id="dairyfoodmaking">
              <Translate contentKey="verasmApp.skills.dairyfoodmaking">Dairyfoodmaking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.dairyfoodmaking}</dd>
          <dt>
            <span id="butchering">
              <Translate contentKey="verasmApp.skills.butchering">Butchering</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.butchering}</dd>
          <dt>
            <span id="beverages">
              <Translate contentKey="verasmApp.skills.beverages">Beverages</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.beverages}</dd>
          <dt>
            <span id="nature">
              <Translate contentKey="verasmApp.skills.nature">Nature</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.nature}</dd>
          <dt>
            <span id="fishing">
              <Translate contentKey="verasmApp.skills.fishing">Fishing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.fishing}</dd>
          <dt>
            <span id="gardening">
              <Translate contentKey="verasmApp.skills.gardening">Gardening</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.gardening}</dd>
          <dt>
            <span id="foraging">
              <Translate contentKey="verasmApp.skills.foraging">Foraging</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.foraging}</dd>
          <dt>
            <span id="botanizing">
              <Translate contentKey="verasmApp.skills.botanizing">Botanizing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.botanizing}</dd>
          <dt>
            <span id="animaltaming">
              <Translate contentKey="verasmApp.skills.animaltaming">Animaltaming</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.animaltaming}</dd>
          <dt>
            <span id="forestry">
              <Translate contentKey="verasmApp.skills.forestry">Forestry</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.forestry}</dd>
          <dt>
            <span id="farming">
              <Translate contentKey="verasmApp.skills.farming">Farming</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.farming}</dd>
          <dt>
            <span id="milking">
              <Translate contentKey="verasmApp.skills.milking">Milking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.milking}</dd>
          <dt>
            <span id="meditating">
              <Translate contentKey="verasmApp.skills.meditating">Meditating</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.meditating}</dd>
          <dt>
            <span id="animalhusbandry">
              <Translate contentKey="verasmApp.skills.animalhusbandry">Animalhusbandry</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.animalhusbandry}</dd>
          <dt>
            <span id="papyrusmaking">
              <Translate contentKey="verasmApp.skills.papyrusmaking">Papyrusmaking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.papyrusmaking}</dd>
          <dt>
            <span id="toys">
              <Translate contentKey="verasmApp.skills.toys">Toys</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.toys}</dd>
          <dt>
            <span id="yoyo">
              <Translate contentKey="verasmApp.skills.yoyo">Yoyo</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.yoyo}</dd>
          <dt>
            <span id="puppeteering">
              <Translate contentKey="verasmApp.skills.puppeteering">Puppeteering</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.puppeteering}</dd>
          <dt>
            <span id="fighting">
              <Translate contentKey="verasmApp.skills.fighting">Fighting</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.fighting}</dd>
          <dt>
            <span id="defensivefighting">
              <Translate contentKey="verasmApp.skills.defensivefighting">Defensivefighting</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.defensivefighting}</dd>
          <dt>
            <span id="normalfighting">
              <Translate contentKey="verasmApp.skills.normalfighting">Normalfighting</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.normalfighting}</dd>
          <dt>
            <span id="weaponlessfighting">
              <Translate contentKey="verasmApp.skills.weaponlessfighting">Weaponlessfighting</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.weaponlessfighting}</dd>
          <dt>
            <span id="aggressivefighting">
              <Translate contentKey="verasmApp.skills.aggressivefighting">Aggressivefighting</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.aggressivefighting}</dd>
          <dt>
            <span id="shieldbashing">
              <Translate contentKey="verasmApp.skills.shieldbashing">Shieldbashing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.shieldbashing}</dd>
          <dt>
            <span id="taunting">
              <Translate contentKey="verasmApp.skills.taunting">Taunting</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.taunting}</dd>
          <dt>
            <span id="miscellaneousitems">
              <Translate contentKey="verasmApp.skills.miscellaneousitems">Miscellaneousitems</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.miscellaneousitems}</dd>
          <dt>
            <span id="shovel">
              <Translate contentKey="verasmApp.skills.shovel">Shovel</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.shovel}</dd>
          <dt>
            <span id="rake">
              <Translate contentKey="verasmApp.skills.rake">Rake</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.rake}</dd>
          <dt>
            <span id="saw">
              <Translate contentKey="verasmApp.skills.saw">Saw</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.saw}</dd>
          <dt>
            <span id="pickaxe">
              <Translate contentKey="verasmApp.skills.pickaxe">Pickaxe</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.pickaxe}</dd>
          <dt>
            <span id="repairing">
              <Translate contentKey="verasmApp.skills.repairing">Repairing</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.repairing}</dd>
          <dt>
            <span id="sickle">
              <Translate contentKey="verasmApp.skills.sickle">Sickle</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.sickle}</dd>
          <dt>
            <span id="scythe">
              <Translate contentKey="verasmApp.skills.scythe">Scythe</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.scythe}</dd>
          <dt>
            <span id="hammer">
              <Translate contentKey="verasmApp.skills.hammer">Hammer</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.hammer}</dd>
          <dt>
            <span id="stonechisel">
              <Translate contentKey="verasmApp.skills.stonechisel">Stonechisel</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.stonechisel}</dd>
          <dt>
            <span id="alchemy">
              <Translate contentKey="verasmApp.skills.alchemy">Alchemy</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.alchemy}</dd>
          <dt>
            <span id="naturalsubstances">
              <Translate contentKey="verasmApp.skills.naturalsubstances">Naturalsubstances</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.naturalsubstances}</dd>
          <dt>
            <span id="shields">
              <Translate contentKey="verasmApp.skills.shields">Shields</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.shields}</dd>
          <dt>
            <span id="mediummetalshield">
              <Translate contentKey="verasmApp.skills.mediummetalshield">Mediummetalshield</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.mediummetalshield}</dd>
          <dt>
            <span id="smallwoodenshield">
              <Translate contentKey="verasmApp.skills.smallwoodenshield">Smallwoodenshield</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.smallwoodenshield}</dd>
          <dt>
            <span id="smallmetalshield">
              <Translate contentKey="verasmApp.skills.smallmetalshield">Smallmetalshield</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.smallmetalshield}</dd>
          <dt>
            <span id="largemetalshield">
              <Translate contentKey="verasmApp.skills.largemetalshield">Largemetalshield</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.largemetalshield}</dd>
          <dt>
            <span id="mediumwoodenshield">
              <Translate contentKey="verasmApp.skills.mediumwoodenshield">Mediumwoodenshield</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.mediumwoodenshield}</dd>
          <dt>
            <span id="largewoodenshield">
              <Translate contentKey="verasmApp.skills.largewoodenshield">Largewoodenshield</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.largewoodenshield}</dd>
          <dt>
            <span id="axes">
              <Translate contentKey="verasmApp.skills.axes">Axes</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.axes}</dd>
          <dt>
            <span id="hatchet">
              <Translate contentKey="verasmApp.skills.hatchet">Hatchet</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.hatchet}</dd>
          <dt>
            <span id="smallaxe">
              <Translate contentKey="verasmApp.skills.smallaxe">Smallaxe</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.smallaxe}</dd>
          <dt>
            <span id="largeaxe">
              <Translate contentKey="verasmApp.skills.largeaxe">Largeaxe</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.largeaxe}</dd>
          <dt>
            <span id="hugeaxe">
              <Translate contentKey="verasmApp.skills.hugeaxe">Hugeaxe</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.hugeaxe}</dd>
          <dt>
            <span id="swords">
              <Translate contentKey="verasmApp.skills.swords">Swords</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.swords}</dd>
          <dt>
            <span id="longsword">
              <Translate contentKey="verasmApp.skills.longsword">Longsword</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.longsword}</dd>
          <dt>
            <span id="shortsword">
              <Translate contentKey="verasmApp.skills.shortsword">Shortsword</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.shortsword}</dd>
          <dt>
            <span id="twohandedsword">
              <Translate contentKey="verasmApp.skills.twohandedsword">Twohandedsword</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.twohandedsword}</dd>
          <dt>
            <span id="knives">
              <Translate contentKey="verasmApp.skills.knives">Knives</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.knives}</dd>
          <dt>
            <span id="carvingknife">
              <Translate contentKey="verasmApp.skills.carvingknife">Carvingknife</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.carvingknife}</dd>
          <dt>
            <span id="butcheringknife">
              <Translate contentKey="verasmApp.skills.butcheringknife">Butcheringknife</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.butcheringknife}</dd>
          <dt>
            <span id="woodcutting">
              <Translate contentKey="verasmApp.skills.woodcutting">Woodcutting</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.woodcutting}</dd>
          <dt>
            <span id="mauls">
              <Translate contentKey="verasmApp.skills.mauls">Mauls</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.mauls}</dd>
          <dt>
            <span id="mediummaul">
              <Translate contentKey="verasmApp.skills.mediummaul">Mediummaul</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.mediummaul}</dd>
          <dt>
            <span id="smallmaul">
              <Translate contentKey="verasmApp.skills.smallmaul">Smallmaul</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.smallmaul}</dd>
          <dt>
            <span id="largemaul">
              <Translate contentKey="verasmApp.skills.largemaul">Largemaul</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.largemaul}</dd>
          <dt>
            <span id="carpentry">
              <Translate contentKey="verasmApp.skills.carpentry">Carpentry</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.carpentry}</dd>
          <dt>
            <span id="bowyery">
              <Translate contentKey="verasmApp.skills.bowyery">Bowyery</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.bowyery}</dd>
          <dt>
            <span id="fletching">
              <Translate contentKey="verasmApp.skills.fletching">Fletching</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.fletching}</dd>
          <dt>
            <span id="finecarpentry">
              <Translate contentKey="verasmApp.skills.finecarpentry">Finecarpentry</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.finecarpentry}</dd>
          <dt>
            <span id="toymaking">
              <Translate contentKey="verasmApp.skills.toymaking">Toymaking</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.toymaking}</dd>
          <dt>
            <span id="shipbuilding">
              <Translate contentKey="verasmApp.skills.shipbuilding">Shipbuilding</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.shipbuilding}</dd>
          <dt>
            <span id="mind">
              <Translate contentKey="verasmApp.skills.mind">Mind</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.mind}</dd>
          <dt>
            <span id="mindlogic">
              <Translate contentKey="verasmApp.skills.mindlogic">Mindlogic</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.mindlogic}</dd>
          <dt>
            <span id="mindspeed">
              <Translate contentKey="verasmApp.skills.mindspeed">Mindspeed</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.mindspeed}</dd>
          <dt>
            <span id="soul">
              <Translate contentKey="verasmApp.skills.soul">Soul</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.soul}</dd>
          <dt>
            <span id="souldepth">
              <Translate contentKey="verasmApp.skills.souldepth">Souldepth</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.souldepth}</dd>
          <dt>
            <span id="soulstrength">
              <Translate contentKey="verasmApp.skills.soulstrength">Soulstrength</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.soulstrength}</dd>
          <dt>
            <span id="body">
              <Translate contentKey="verasmApp.skills.body">Body</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.body}</dd>
          <dt>
            <span id="bodystrength">
              <Translate contentKey="verasmApp.skills.bodystrength">Bodystrength</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.bodystrength}</dd>
          <dt>
            <span id="bodystamina">
              <Translate contentKey="verasmApp.skills.bodystamina">Bodystamina</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.bodystamina}</dd>
          <dt>
            <span id="bodycontrol">
              <Translate contentKey="verasmApp.skills.bodycontrol">Bodycontrol</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.bodycontrol}</dd>
          <dt>
            <span id="faith">
              <Translate contentKey="verasmApp.skills.faith">Faith</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.faith}</dd>
          <dt>
            <span id="favor">
              <Translate contentKey="verasmApp.skills.favor">Favor</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.favor}</dd>
          <dt>
            <span id="alignment">
              <Translate contentKey="verasmApp.skills.alignment">Alignment</Translate>
            </span>
          </dt>
          <dd>{skillsEntity.alignment}</dd>
          <dt>
            <Translate contentKey="verasmApp.skills.user">User</Translate>
          </dt>
          <dd>{skillsEntity.user ? skillsEntity.user.login : ''}</dd>
        </dl>
        <Button tag={Link} to="/skills" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/skills/${skillsEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default SkillsDetail;
