import React, { useState, useEffect } from 'react';
import InfiniteScroll from 'react-infinite-scroll-component';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate, getSortState } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ASC, DESC, ITEMS_PER_PAGE, SORT } from 'app/shared/util/pagination.constants';
import { overridePaginationStateWithQueryParams } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ISkills } from 'app/shared/model/skills.model';
import { getEntities, reset } from './skills.reducer';
import './skills.css';
export const Skills = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const [paginationState, setPaginationState] = useState(
    overridePaginationStateWithQueryParams(getSortState(location, ITEMS_PER_PAGE, 'id'), location.search)
  );
  const [sorting, setSorting] = useState(false);

  const skillsList = useAppSelector(state => state.skills.entities);
  const loading = useAppSelector(state => state.skills.loading);
  const totalItems = useAppSelector(state => state.skills.totalItems);
  const links = useAppSelector(state => state.skills.links);
  const entity = useAppSelector(state => state.skills.entity);
  const updateSuccess = useAppSelector(state => state.skills.updateSuccess);

  const getAllEntities = () => {
    dispatch(
      getEntities({
        page: paginationState.activePage - 1,
        size: paginationState.itemsPerPage,
        sort: `${paginationState.sort},${paginationState.order}`,
      })
    );
  };

  const resetAll = () => {
    dispatch(reset());
    setPaginationState({
      ...paginationState,
      activePage: 1,
    });
    dispatch(getEntities({}));
  };

  useEffect(() => {
    resetAll();
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      resetAll();
    }
  }, [updateSuccess]);

  useEffect(() => {
    getAllEntities();
  }, [paginationState.activePage]);

  const handleLoadMore = () => {
    if ((window as any).pageYOffset > 0) {
      setPaginationState({
        ...paginationState,
        activePage: paginationState.activePage + 1,
      });
    }
  };

  useEffect(() => {
    if (sorting) {
      getAllEntities();
      setSorting(false);
    }
  }, [sorting]);

  const sort = p => () => {
    dispatch(reset());
    setPaginationState({
      ...paginationState,
      activePage: 1,
      order: paginationState.order === ASC ? DESC : ASC,
      sort: p,
    });
    setSorting(true);
  };

  const handleSyncList = () => {
    resetAll();
  };

  return (
    <div>
      <h2 id="skills-heading" data-cy="SkillsHeading">
        <Translate contentKey="verasmApp.skills.home.title">Skills</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="verasmApp.skills.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/skills/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="verasmApp.skills.home.createLabel">Create new Skills</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        <InfiniteScroll
          dataLength={skillsList ? skillsList.length : 0}
          next={handleLoadMore}
          hasMore={paginationState.activePage - 1 < links.next}
          loader={<div className="loader">Loading ...</div>}
        >
          {skillsList && skillsList.length > 0 ? (
            <Table responsive>
              <thead>
                <tr>
                  <th className="hand" onClick={sort('id')}>
                    <Translate contentKey="verasmApp.skills.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('dumptime')}>
                    <Translate contentKey="verasmApp.skills.dumptime">Dumptime</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('playername')}>
                    <Translate contentKey="verasmApp.skills.playername">Playername</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('premium')}>
                    <Translate contentKey="verasmApp.skills.premium">Premium</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('server')}>
                    <Translate contentKey="verasmApp.skills.server">Server</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('religion')}>
                    <Translate contentKey="verasmApp.skills.religion">Religion</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('prayer')}>
                    <Translate contentKey="verasmApp.skills.prayer">Prayer</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('channeling')}>
                    <Translate contentKey="verasmApp.skills.channeling">Channeling</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('preaching')}>
                    <Translate contentKey="verasmApp.skills.preaching">Preaching</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('exorcism')}>
                    <Translate contentKey="verasmApp.skills.exorcism">Exorcism</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('hammers')}>
                    <Translate contentKey="verasmApp.skills.hammers">Hammers</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('warhammer')}>
                    <Translate contentKey="verasmApp.skills.warhammer">Warhammer</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('healing')}>
                    <Translate contentKey="verasmApp.skills.healing">Healing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('firstaid')}>
                    <Translate contentKey="verasmApp.skills.firstaid">Firstaid</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('clubs')}>
                    <Translate contentKey="verasmApp.skills.clubs">Clubs</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('hugeclub')}>
                    <Translate contentKey="verasmApp.skills.hugeclub">Hugeclub</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('archery')}>
                    <Translate contentKey="verasmApp.skills.archery">Archery</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('shortbow')}>
                    <Translate contentKey="verasmApp.skills.shortbow">Shortbow</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('mediumbow')}>
                    <Translate contentKey="verasmApp.skills.mediumbow">Mediumbow</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('longbow')}>
                    <Translate contentKey="verasmApp.skills.longbow">Longbow</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('thievery')}>
                    <Translate contentKey="verasmApp.skills.thievery">Thievery</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('stealing')}>
                    <Translate contentKey="verasmApp.skills.stealing">Stealing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('lockpicking')}>
                    <Translate contentKey="verasmApp.skills.lockpicking">Lockpicking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('traps')}>
                    <Translate contentKey="verasmApp.skills.traps">Traps</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('warmachines')}>
                    <Translate contentKey="verasmApp.skills.warmachines">Warmachines</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('catapults')}>
                    <Translate contentKey="verasmApp.skills.catapults">Catapults</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('trebuchets')}>
                    <Translate contentKey="verasmApp.skills.trebuchets">Trebuchets</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('ballistae')}>
                    <Translate contentKey="verasmApp.skills.ballistae">Ballistae</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('polearms')}>
                    <Translate contentKey="verasmApp.skills.polearms">Polearms</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('staff')}>
                    <Translate contentKey="verasmApp.skills.staff">Staff</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('longspear')}>
                    <Translate contentKey="verasmApp.skills.longspear">Longspear</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('halberd')}>
                    <Translate contentKey="verasmApp.skills.halberd">Halberd</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('prospecting')}>
                    <Translate contentKey="verasmApp.skills.prospecting">Prospecting</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('coalmaking')}>
                    <Translate contentKey="verasmApp.skills.coalmaking">Coalmaking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('milling')}>
                    <Translate contentKey="verasmApp.skills.milling">Milling</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('tracking')}>
                    <Translate contentKey="verasmApp.skills.tracking">Tracking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('paving')}>
                    <Translate contentKey="verasmApp.skills.paving">Paving</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('archaeology')}>
                    <Translate contentKey="verasmApp.skills.archaeology">Archaeology</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('restoration')}>
                    <Translate contentKey="verasmApp.skills.restoration">Restoration</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('climbing')}>
                    <Translate contentKey="verasmApp.skills.climbing">Climbing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('thatching')}>
                    <Translate contentKey="verasmApp.skills.thatching">Thatching</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('firemaking')}>
                    <Translate contentKey="verasmApp.skills.firemaking">Firemaking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('pottery')}>
                    <Translate contentKey="verasmApp.skills.pottery">Pottery</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('mining')}>
                    <Translate contentKey="verasmApp.skills.mining">Mining</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('digging')}>
                    <Translate contentKey="verasmApp.skills.digging">Digging</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('ropemaking')}>
                    <Translate contentKey="verasmApp.skills.ropemaking">Ropemaking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('smithing')}>
                    <Translate contentKey="verasmApp.skills.smithing">Smithing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('blacksmithing')}>
                    <Translate contentKey="verasmApp.skills.blacksmithing">Blacksmithing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('locksmithing')}>
                    <Translate contentKey="verasmApp.skills.locksmithing">Locksmithing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('jewelrysmithing')}>
                    <Translate contentKey="verasmApp.skills.jewelrysmithing">Jewelrysmithing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('metallurgy')}>
                    <Translate contentKey="verasmApp.skills.metallurgy">Metallurgy</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('weaponsmithing')}>
                    <Translate contentKey="verasmApp.skills.weaponsmithing">Weaponsmithing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('bladessmithing')}>
                    <Translate contentKey="verasmApp.skills.bladessmithing">Bladessmithing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('weaponheadssmithing')}>
                    <Translate contentKey="verasmApp.skills.weaponheadssmithing">Weaponheadssmithing</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('armoursmithing')}>
                    <Translate contentKey="verasmApp.skills.armoursmithing">Armoursmithing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('shieldsmithing')}>
                    <Translate contentKey="verasmApp.skills.shieldsmithing">Shieldsmithing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('chainarmoursmithing')}>
                    <Translate contentKey="verasmApp.skills.chainarmoursmithing">Chainarmoursmithing</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('platearmoursmithing')}>
                    <Translate contentKey="verasmApp.skills.platearmoursmithing">Platearmoursmithing</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('tailoring')}>
                    <Translate contentKey="verasmApp.skills.tailoring">Tailoring</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('clothtailoring')}>
                    <Translate contentKey="verasmApp.skills.clothtailoring">Clothtailoring</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('leatherworking')}>
                    <Translate contentKey="verasmApp.skills.leatherworking">Leatherworking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('masonry')}>
                    <Translate contentKey="verasmApp.skills.masonry">Masonry</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('stonecutting')}>
                    <Translate contentKey="verasmApp.skills.stonecutting">Stonecutting</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('cooking')}>
                    <Translate contentKey="verasmApp.skills.cooking">Cooking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('hotfoodcooking')}>
                    <Translate contentKey="verasmApp.skills.hotfoodcooking">Hotfoodcooking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('baking')}>
                    <Translate contentKey="verasmApp.skills.baking">Baking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('dairyfoodmaking')}>
                    <Translate contentKey="verasmApp.skills.dairyfoodmaking">Dairyfoodmaking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('butchering')}>
                    <Translate contentKey="verasmApp.skills.butchering">Butchering</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('beverages')}>
                    <Translate contentKey="verasmApp.skills.beverages">Beverages</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('nature')}>
                    <Translate contentKey="verasmApp.skills.nature">Nature</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('fishing')}>
                    <Translate contentKey="verasmApp.skills.fishing">Fishing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('gardening')}>
                    <Translate contentKey="verasmApp.skills.gardening">Gardening</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('foraging')}>
                    <Translate contentKey="verasmApp.skills.foraging">Foraging</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('botanizing')}>
                    <Translate contentKey="verasmApp.skills.botanizing">Botanizing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('animaltaming')}>
                    <Translate contentKey="verasmApp.skills.animaltaming">Animaltaming</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('forestry')}>
                    <Translate contentKey="verasmApp.skills.forestry">Forestry</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('farming')}>
                    <Translate contentKey="verasmApp.skills.farming">Farming</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('milking')}>
                    <Translate contentKey="verasmApp.skills.milking">Milking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('meditating')}>
                    <Translate contentKey="verasmApp.skills.meditating">Meditating</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('animalhusbandry')}>
                    <Translate contentKey="verasmApp.skills.animalhusbandry">Animalhusbandry</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('papyrusmaking')}>
                    <Translate contentKey="verasmApp.skills.papyrusmaking">Papyrusmaking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('toys')}>
                    <Translate contentKey="verasmApp.skills.toys">Toys</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('yoyo')}>
                    <Translate contentKey="verasmApp.skills.yoyo">Yoyo</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('puppeteering')}>
                    <Translate contentKey="verasmApp.skills.puppeteering">Puppeteering</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('fighting')}>
                    <Translate contentKey="verasmApp.skills.fighting">Fighting</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('defensivefighting')}>
                    <Translate contentKey="verasmApp.skills.defensivefighting">Defensivefighting</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('normalfighting')}>
                    <Translate contentKey="verasmApp.skills.normalfighting">Normalfighting</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('weaponlessfighting')}>
                    <Translate contentKey="verasmApp.skills.weaponlessfighting">Weaponlessfighting</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('aggressivefighting')}>
                    <Translate contentKey="verasmApp.skills.aggressivefighting">Aggressivefighting</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('shieldbashing')}>
                    <Translate contentKey="verasmApp.skills.shieldbashing">Shieldbashing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('taunting')}>
                    <Translate contentKey="verasmApp.skills.taunting">Taunting</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('miscellaneousitems')}>
                    <Translate contentKey="verasmApp.skills.miscellaneousitems">Miscellaneousitems</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('shovel')}>
                    <Translate contentKey="verasmApp.skills.shovel">Shovel</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('rake')}>
                    <Translate contentKey="verasmApp.skills.rake">Rake</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('saw')}>
                    <Translate contentKey="verasmApp.skills.saw">Saw</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('pickaxe')}>
                    <Translate contentKey="verasmApp.skills.pickaxe">Pickaxe</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('repairing')}>
                    <Translate contentKey="verasmApp.skills.repairing">Repairing</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('sickle')}>
                    <Translate contentKey="verasmApp.skills.sickle">Sickle</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('scythe')}>
                    <Translate contentKey="verasmApp.skills.scythe">Scythe</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('hammer')}>
                    <Translate contentKey="verasmApp.skills.hammer">Hammer</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('stonechisel')}>
                    <Translate contentKey="verasmApp.skills.stonechisel">Stonechisel</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('alchemy')}>
                    <Translate contentKey="verasmApp.skills.alchemy">Alchemy</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('naturalsubstances')}>
                    <Translate contentKey="verasmApp.skills.naturalsubstances">Naturalsubstances</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('shields')}>
                    <Translate contentKey="verasmApp.skills.shields">Shields</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('mediummetalshield')}>
                    <Translate contentKey="verasmApp.skills.mediummetalshield">Mediummetalshield</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('smallwoodenshield')}>
                    <Translate contentKey="verasmApp.skills.smallwoodenshield">Smallwoodenshield</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('smallmetalshield')}>
                    <Translate contentKey="verasmApp.skills.smallmetalshield">Smallmetalshield</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('largemetalshield')}>
                    <Translate contentKey="verasmApp.skills.largemetalshield">Largemetalshield</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('mediumwoodenshield')}>
                    <Translate contentKey="verasmApp.skills.mediumwoodenshield">Mediumwoodenshield</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('largewoodenshield')}>
                    <Translate contentKey="verasmApp.skills.largewoodenshield">Largewoodenshield</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('axes')}>
                    <Translate contentKey="verasmApp.skills.axes">Axes</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('hatchet')}>
                    <Translate contentKey="verasmApp.skills.hatchet">Hatchet</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('smallaxe')}>
                    <Translate contentKey="verasmApp.skills.smallaxe">Smallaxe</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('largeaxe')}>
                    <Translate contentKey="verasmApp.skills.largeaxe">Largeaxe</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('hugeaxe')}>
                    <Translate contentKey="verasmApp.skills.hugeaxe">Hugeaxe</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('swords')}>
                    <Translate contentKey="verasmApp.skills.swords">Swords</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('longsword')}>
                    <Translate contentKey="verasmApp.skills.longsword">Longsword</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('shortsword')}>
                    <Translate contentKey="verasmApp.skills.shortsword">Shortsword</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('twohandedsword')}>
                    <Translate contentKey="verasmApp.skills.twohandedsword">Twohandedsword</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('knives')}>
                    <Translate contentKey="verasmApp.skills.knives">Knives</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('carvingknife')}>
                    <Translate contentKey="verasmApp.skills.carvingknife">Carvingknife</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('butcheringknife')}>
                    <Translate contentKey="verasmApp.skills.butcheringknife">Butcheringknife</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('woodcutting')}>
                    <Translate contentKey="verasmApp.skills.woodcutting">Woodcutting</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('mauls')}>
                    <Translate contentKey="verasmApp.skills.mauls">Mauls</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('mediummaul')}>
                    <Translate contentKey="verasmApp.skills.mediummaul">Mediummaul</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('smallmaul')}>
                    <Translate contentKey="verasmApp.skills.smallmaul">Smallmaul</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('largemaul')}>
                    <Translate contentKey="verasmApp.skills.largemaul">Largemaul</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('carpentry')}>
                    <Translate contentKey="verasmApp.skills.carpentry">Carpentry</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('bowyery')}>
                    <Translate contentKey="verasmApp.skills.bowyery">Bowyery</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('fletching')}>
                    <Translate contentKey="verasmApp.skills.fletching">Fletching</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('finecarpentry')}>
                    <Translate contentKey="verasmApp.skills.finecarpentry">Finecarpentry</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('toymaking')}>
                    <Translate contentKey="verasmApp.skills.toymaking">Toymaking</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('shipbuilding')}>
                    <Translate contentKey="verasmApp.skills.shipbuilding">Shipbuilding</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('mind')}>
                    <Translate contentKey="verasmApp.skills.mind">Mind</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('mindlogic')}>
                    <Translate contentKey="verasmApp.skills.mindlogic">Mindlogic</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('mindspeed')}>
                    <Translate contentKey="verasmApp.skills.mindspeed">Mindspeed</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('soul')}>
                    <Translate contentKey="verasmApp.skills.soul">Soul</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('souldepth')}>
                    <Translate contentKey="verasmApp.skills.souldepth">Souldepth</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('soulstrength')}>
                    <Translate contentKey="verasmApp.skills.soulstrength">Soulstrength</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('body')}>
                    <Translate contentKey="verasmApp.skills.body">Body</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('bodystrength')}>
                    <Translate contentKey="verasmApp.skills.bodystrength">Bodystrength</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('bodystamina')}>
                    <Translate contentKey="verasmApp.skills.bodystamina">Bodystamina</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('bodycontrol')}>
                    <Translate contentKey="verasmApp.skills.bodycontrol">Bodycontrol</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('faith')}>
                    <Translate contentKey="verasmApp.skills.faith">Faith</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('favor')}>
                    <Translate contentKey="verasmApp.skills.favor">Favor</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={sort('alignment')}>
                    <Translate contentKey="verasmApp.skills.alignment">Alignment</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th>
                    <Translate contentKey="verasmApp.skills.user">User</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th />
                </tr>
              </thead>
              <tbody>
                {skillsList.map((skills, i) => (
                  <tr key={`entity-${i}`} data-cy="entityTable">
                    <td>
                      <Button tag={Link} to={`/skills/${skills.id}`} color="link" size="sm">
                        {skills.id}
                      </Button>
                    </td>
                    <td>{skills.dumptime}</td>
                    <td>{skills.playername}</td>
                    <td>{skills.premium}</td>
                    <td>{skills.server}</td>
                    <td>{skills.religion}</td>
                    <td>{skills.prayer}</td>
                    <td>{skills.channeling}</td>
                    <td>{skills.preaching}</td>
                    <td>{skills.exorcism}</td>
                    <td>{skills.hammers}</td>
                    <td>{skills.warhammer}</td>
                    <td>{skills.healing}</td>
                    <td>{skills.firstaid}</td>
                    <td>{skills.clubs}</td>
                    <td>{skills.hugeclub}</td>
                    <td>{skills.archery}</td>
                    <td>{skills.shortbow}</td>
                    <td>{skills.mediumbow}</td>
                    <td>{skills.longbow}</td>
                    <td>{skills.thievery}</td>
                    <td>{skills.stealing}</td>
                    <td>{skills.lockpicking}</td>
                    <td>{skills.traps}</td>
                    <td>{skills.warmachines}</td>
                    <td>{skills.catapults}</td>
                    <td>{skills.trebuchets}</td>
                    <td>{skills.ballistae}</td>
                    <td>{skills.polearms}</td>
                    <td>{skills.staff}</td>
                    <td>{skills.longspear}</td>
                    <td>{skills.halberd}</td>
                    <td>{skills.prospecting}</td>
                    <td>{skills.coalmaking}</td>
                    <td>{skills.milling}</td>
                    <td>{skills.tracking}</td>
                    <td>{skills.paving}</td>
                    <td>{skills.archaeology}</td>
                    <td>{skills.restoration}</td>
                    <td>{skills.climbing}</td>
                    <td>{skills.thatching}</td>
                    <td>{skills.firemaking}</td>
                    <td>{skills.pottery}</td>
                    <td>{skills.mining}</td>
                    <td>{skills.digging}</td>
                    <td>{skills.ropemaking}</td>
                    <td>{skills.smithing}</td>
                    <td>{skills.blacksmithing}</td>
                    <td>{skills.locksmithing}</td>
                    <td>{skills.jewelrysmithing}</td>
                    <td>{skills.metallurgy}</td>
                    <td>{skills.weaponsmithing}</td>
                    <td>{skills.bladessmithing}</td>
                    <td>{skills.weaponheadssmithing}</td>
                    <td>{skills.armoursmithing}</td>
                    <td>{skills.shieldsmithing}</td>
                    <td>{skills.chainarmoursmithing}</td>
                    <td>{skills.platearmoursmithing}</td>
                    <td>{skills.tailoring}</td>
                    <td>{skills.clothtailoring}</td>
                    <td>{skills.leatherworking}</td>
                    <td>{skills.masonry}</td>
                    <td>{skills.stonecutting}</td>
                    <td>{skills.cooking}</td>
                    <td>{skills.hotfoodcooking}</td>
                    <td>{skills.baking}</td>
                    <td>{skills.dairyfoodmaking}</td>
                    <td>{skills.butchering}</td>
                    <td>{skills.beverages}</td>
                    <td>{skills.nature}</td>
                    <td>{skills.fishing}</td>
                    <td>{skills.gardening}</td>
                    <td>{skills.foraging}</td>
                    <td>{skills.botanizing}</td>
                    <td>{skills.animaltaming}</td>
                    <td>{skills.forestry}</td>
                    <td>{skills.farming}</td>
                    <td>{skills.milking}</td>
                    <td>{skills.meditating}</td>
                    <td>{skills.animalhusbandry}</td>
                    <td>{skills.papyrusmaking}</td>
                    <td>{skills.toys}</td>
                    <td>{skills.yoyo}</td>
                    <td>{skills.puppeteering}</td>
                    <td>{skills.fighting}</td>
                    <td>{skills.defensivefighting}</td>
                    <td>{skills.normalfighting}</td>
                    <td>{skills.weaponlessfighting}</td>
                    <td>{skills.aggressivefighting}</td>
                    <td>{skills.shieldbashing}</td>
                    <td>{skills.taunting}</td>
                    <td>{skills.miscellaneousitems}</td>
                    <td>{skills.shovel}</td>
                    <td>{skills.rake}</td>
                    <td>{skills.saw}</td>
                    <td>{skills.pickaxe}</td>
                    <td>{skills.repairing}</td>
                    <td>{skills.sickle}</td>
                    <td>{skills.scythe}</td>
                    <td>{skills.hammer}</td>
                    <td>{skills.stonechisel}</td>
                    <td>{skills.alchemy}</td>
                    <td>{skills.naturalsubstances}</td>
                    <td>{skills.shields}</td>
                    <td>{skills.mediummetalshield}</td>
                    <td>{skills.smallwoodenshield}</td>
                    <td>{skills.smallmetalshield}</td>
                    <td>{skills.largemetalshield}</td>
                    <td>{skills.mediumwoodenshield}</td>
                    <td>{skills.largewoodenshield}</td>
                    <td>{skills.axes}</td>
                    <td>{skills.hatchet}</td>
                    <td>{skills.smallaxe}</td>
                    <td>{skills.largeaxe}</td>
                    <td>{skills.hugeaxe}</td>
                    <td>{skills.swords}</td>
                    <td>{skills.longsword}</td>
                    <td>{skills.shortsword}</td>
                    <td>{skills.twohandedsword}</td>
                    <td>{skills.knives}</td>
                    <td>{skills.carvingknife}</td>
                    <td>{skills.butcheringknife}</td>
                    <td>{skills.woodcutting}</td>
                    <td>{skills.mauls}</td>
                    <td>{skills.mediummaul}</td>
                    <td>{skills.smallmaul}</td>
                    <td>{skills.largemaul}</td>
                    <td>{skills.carpentry}</td>
                    <td>{skills.bowyery}</td>
                    <td>{skills.fletching}</td>
                    <td>{skills.finecarpentry}</td>
                    <td>{skills.toymaking}</td>
                    <td>{skills.shipbuilding}</td>
                    <td>{skills.mind}</td>
                    <td>{skills.mindlogic}</td>
                    <td>{skills.mindspeed}</td>
                    <td>{skills.soul}</td>
                    <td>{skills.souldepth}</td>
                    <td>{skills.soulstrength}</td>
                    <td>{skills.body}</td>
                    <td>{skills.bodystrength}</td>
                    <td>{skills.bodystamina}</td>
                    <td>{skills.bodycontrol}</td>
                    <td>{skills.faith}</td>
                    <td>{skills.favor}</td>
                    <td>{skills.alignment}</td>
                    <td>{skills.user ? skills.user.login : ''}</td>
                    <td className="text-end">
                      <div className="btn-group flex-btn-group-container">
                        <Button tag={Link} to={`/skills/${skills.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                          <FontAwesomeIcon icon="eye" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.view">View</Translate>
                          </span>
                        </Button>
                        <Button tag={Link} to={`/skills/${skills.id}/edit`} color="primary" size="sm" data-cy="entityEditButton">
                          <FontAwesomeIcon icon="pencil-alt" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.edit">Edit</Translate>
                          </span>
                        </Button>
                        <Button tag={Link} to={`/skills/${skills.id}/delete`} color="danger" size="sm" data-cy="entityDeleteButton">
                          <FontAwesomeIcon icon="trash" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.delete">Delete</Translate>
                          </span>
                        </Button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
          ) : (
            !loading && (
              <div className="alert alert-warning">
                <Translate contentKey="verasmApp.skills.home.notFound">No Skills found</Translate>
              </div>
            )
          )}
        </InfiniteScroll>
      </div>

      <div className="main-wrapper">
        <div className="statistics-wrapper">
          <div className="statistics"> quick stats</div>
          <div className="graph"> graph</div>
        </div>

        <div className="skill-section-container">
          <div className="skill-group">
            <b>Body</b>
            <br></br>
            <ul>
              <li className="a-skill">BOdy Strength: 99.999</li>
              <li className="a-skill">BOdy Strength: 99.999</li>
              <li className="a-skill">BOdy Strength: 99.999</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Skills;
