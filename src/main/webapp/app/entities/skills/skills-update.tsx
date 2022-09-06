import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IUser } from 'app/shared/model/user.model';
import { getUsers } from 'app/modules/administration/user-management/user-management.reducer';
import { ISkills } from 'app/shared/model/skills.model';
import { getEntity, updateEntity, createEntity, reset } from './skills.reducer';

export const SkillsUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const users = useAppSelector(state => state.userManagement.users);
  const skillsEntity = useAppSelector(state => state.skills.entity);
  const loading = useAppSelector(state => state.skills.loading);
  const updating = useAppSelector(state => state.skills.updating);
  const updateSuccess = useAppSelector(state => state.skills.updateSuccess);

  const handleClose = () => {
    navigate('/skills');
  };

  useEffect(() => {
    if (!isNew) {
      dispatch(getEntity(id));
    }

    dispatch(getUsers({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    const entity = {
      ...skillsEntity,
      ...values,
      user: users.find(it => it.id.toString() === values.user.toString()),
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          ...skillsEntity,
          user: skillsEntity?.user?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="verasmApp.skills.home.createOrEditLabel" data-cy="SkillsCreateUpdateHeading">
            <Translate contentKey="verasmApp.skills.home.createOrEditLabel">Create or edit a Skills</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="skills-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('verasmApp.skills.dumptime')}
                id="skills-dumptime"
                name="dumptime"
                data-cy="dumptime"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.playername')}
                id="skills-playername"
                name="playername"
                data-cy="playername"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.premium')}
                id="skills-premium"
                name="premium"
                data-cy="premium"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.server')}
                id="skills-server"
                name="server"
                data-cy="server"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.religion')}
                id="skills-religion"
                name="religion"
                data-cy="religion"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.prayer')}
                id="skills-prayer"
                name="prayer"
                data-cy="prayer"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.channeling')}
                id="skills-channeling"
                name="channeling"
                data-cy="channeling"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.preaching')}
                id="skills-preaching"
                name="preaching"
                data-cy="preaching"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.exorcism')}
                id="skills-exorcism"
                name="exorcism"
                data-cy="exorcism"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.hammers')}
                id="skills-hammers"
                name="hammers"
                data-cy="hammers"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.warhammer')}
                id="skills-warhammer"
                name="warhammer"
                data-cy="warhammer"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.healing')}
                id="skills-healing"
                name="healing"
                data-cy="healing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.firstaid')}
                id="skills-firstaid"
                name="firstaid"
                data-cy="firstaid"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.clubs')}
                id="skills-clubs"
                name="clubs"
                data-cy="clubs"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.hugeclub')}
                id="skills-hugeclub"
                name="hugeclub"
                data-cy="hugeclub"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.archery')}
                id="skills-archery"
                name="archery"
                data-cy="archery"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.shortbow')}
                id="skills-shortbow"
                name="shortbow"
                data-cy="shortbow"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.mediumbow')}
                id="skills-mediumbow"
                name="mediumbow"
                data-cy="mediumbow"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.longbow')}
                id="skills-longbow"
                name="longbow"
                data-cy="longbow"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.thievery')}
                id="skills-thievery"
                name="thievery"
                data-cy="thievery"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.stealing')}
                id="skills-stealing"
                name="stealing"
                data-cy="stealing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.lockpicking')}
                id="skills-lockpicking"
                name="lockpicking"
                data-cy="lockpicking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.traps')}
                id="skills-traps"
                name="traps"
                data-cy="traps"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.warmachines')}
                id="skills-warmachines"
                name="warmachines"
                data-cy="warmachines"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.catapults')}
                id="skills-catapults"
                name="catapults"
                data-cy="catapults"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.trebuchets')}
                id="skills-trebuchets"
                name="trebuchets"
                data-cy="trebuchets"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.ballistae')}
                id="skills-ballistae"
                name="ballistae"
                data-cy="ballistae"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.polearms')}
                id="skills-polearms"
                name="polearms"
                data-cy="polearms"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.staff')}
                id="skills-staff"
                name="staff"
                data-cy="staff"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.longspear')}
                id="skills-longspear"
                name="longspear"
                data-cy="longspear"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.halberd')}
                id="skills-halberd"
                name="halberd"
                data-cy="halberd"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.prospecting')}
                id="skills-prospecting"
                name="prospecting"
                data-cy="prospecting"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.coalmaking')}
                id="skills-coalmaking"
                name="coalmaking"
                data-cy="coalmaking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.milling')}
                id="skills-milling"
                name="milling"
                data-cy="milling"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.tracking')}
                id="skills-tracking"
                name="tracking"
                data-cy="tracking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.paving')}
                id="skills-paving"
                name="paving"
                data-cy="paving"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.archaeology')}
                id="skills-archaeology"
                name="archaeology"
                data-cy="archaeology"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.restoration')}
                id="skills-restoration"
                name="restoration"
                data-cy="restoration"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.climbing')}
                id="skills-climbing"
                name="climbing"
                data-cy="climbing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.thatching')}
                id="skills-thatching"
                name="thatching"
                data-cy="thatching"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.firemaking')}
                id="skills-firemaking"
                name="firemaking"
                data-cy="firemaking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.pottery')}
                id="skills-pottery"
                name="pottery"
                data-cy="pottery"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.mining')}
                id="skills-mining"
                name="mining"
                data-cy="mining"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.digging')}
                id="skills-digging"
                name="digging"
                data-cy="digging"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.ropemaking')}
                id="skills-ropemaking"
                name="ropemaking"
                data-cy="ropemaking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.smithing')}
                id="skills-smithing"
                name="smithing"
                data-cy="smithing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.blacksmithing')}
                id="skills-blacksmithing"
                name="blacksmithing"
                data-cy="blacksmithing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.locksmithing')}
                id="skills-locksmithing"
                name="locksmithing"
                data-cy="locksmithing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.jewelrysmithing')}
                id="skills-jewelrysmithing"
                name="jewelrysmithing"
                data-cy="jewelrysmithing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.metallurgy')}
                id="skills-metallurgy"
                name="metallurgy"
                data-cy="metallurgy"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.weaponsmithing')}
                id="skills-weaponsmithing"
                name="weaponsmithing"
                data-cy="weaponsmithing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.bladessmithing')}
                id="skills-bladessmithing"
                name="bladessmithing"
                data-cy="bladessmithing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.weaponheadssmithing')}
                id="skills-weaponheadssmithing"
                name="weaponheadssmithing"
                data-cy="weaponheadssmithing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.armoursmithing')}
                id="skills-armoursmithing"
                name="armoursmithing"
                data-cy="armoursmithing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.shieldsmithing')}
                id="skills-shieldsmithing"
                name="shieldsmithing"
                data-cy="shieldsmithing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.chainarmoursmithing')}
                id="skills-chainarmoursmithing"
                name="chainarmoursmithing"
                data-cy="chainarmoursmithing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.platearmoursmithing')}
                id="skills-platearmoursmithing"
                name="platearmoursmithing"
                data-cy="platearmoursmithing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.tailoring')}
                id="skills-tailoring"
                name="tailoring"
                data-cy="tailoring"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.clothtailoring')}
                id="skills-clothtailoring"
                name="clothtailoring"
                data-cy="clothtailoring"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.leatherworking')}
                id="skills-leatherworking"
                name="leatherworking"
                data-cy="leatherworking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.masonry')}
                id="skills-masonry"
                name="masonry"
                data-cy="masonry"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.stonecutting')}
                id="skills-stonecutting"
                name="stonecutting"
                data-cy="stonecutting"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.cooking')}
                id="skills-cooking"
                name="cooking"
                data-cy="cooking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.hotfoodcooking')}
                id="skills-hotfoodcooking"
                name="hotfoodcooking"
                data-cy="hotfoodcooking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.baking')}
                id="skills-baking"
                name="baking"
                data-cy="baking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.dairyfoodmaking')}
                id="skills-dairyfoodmaking"
                name="dairyfoodmaking"
                data-cy="dairyfoodmaking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.butchering')}
                id="skills-butchering"
                name="butchering"
                data-cy="butchering"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.beverages')}
                id="skills-beverages"
                name="beverages"
                data-cy="beverages"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.nature')}
                id="skills-nature"
                name="nature"
                data-cy="nature"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.fishing')}
                id="skills-fishing"
                name="fishing"
                data-cy="fishing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.gardening')}
                id="skills-gardening"
                name="gardening"
                data-cy="gardening"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.foraging')}
                id="skills-foraging"
                name="foraging"
                data-cy="foraging"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.botanizing')}
                id="skills-botanizing"
                name="botanizing"
                data-cy="botanizing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.animaltaming')}
                id="skills-animaltaming"
                name="animaltaming"
                data-cy="animaltaming"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.forestry')}
                id="skills-forestry"
                name="forestry"
                data-cy="forestry"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.farming')}
                id="skills-farming"
                name="farming"
                data-cy="farming"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.milking')}
                id="skills-milking"
                name="milking"
                data-cy="milking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.meditating')}
                id="skills-meditating"
                name="meditating"
                data-cy="meditating"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.animalhusbandry')}
                id="skills-animalhusbandry"
                name="animalhusbandry"
                data-cy="animalhusbandry"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.papyrusmaking')}
                id="skills-papyrusmaking"
                name="papyrusmaking"
                data-cy="papyrusmaking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.toys')}
                id="skills-toys"
                name="toys"
                data-cy="toys"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.yoyo')}
                id="skills-yoyo"
                name="yoyo"
                data-cy="yoyo"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.puppeteering')}
                id="skills-puppeteering"
                name="puppeteering"
                data-cy="puppeteering"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.fighting')}
                id="skills-fighting"
                name="fighting"
                data-cy="fighting"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.defensivefighting')}
                id="skills-defensivefighting"
                name="defensivefighting"
                data-cy="defensivefighting"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.normalfighting')}
                id="skills-normalfighting"
                name="normalfighting"
                data-cy="normalfighting"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.weaponlessfighting')}
                id="skills-weaponlessfighting"
                name="weaponlessfighting"
                data-cy="weaponlessfighting"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.aggressivefighting')}
                id="skills-aggressivefighting"
                name="aggressivefighting"
                data-cy="aggressivefighting"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.shieldbashing')}
                id="skills-shieldbashing"
                name="shieldbashing"
                data-cy="shieldbashing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.taunting')}
                id="skills-taunting"
                name="taunting"
                data-cy="taunting"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.miscellaneousitems')}
                id="skills-miscellaneousitems"
                name="miscellaneousitems"
                data-cy="miscellaneousitems"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.shovel')}
                id="skills-shovel"
                name="shovel"
                data-cy="shovel"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.rake')}
                id="skills-rake"
                name="rake"
                data-cy="rake"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.saw')}
                id="skills-saw"
                name="saw"
                data-cy="saw"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.pickaxe')}
                id="skills-pickaxe"
                name="pickaxe"
                data-cy="pickaxe"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.repairing')}
                id="skills-repairing"
                name="repairing"
                data-cy="repairing"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.sickle')}
                id="skills-sickle"
                name="sickle"
                data-cy="sickle"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.scythe')}
                id="skills-scythe"
                name="scythe"
                data-cy="scythe"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.hammer')}
                id="skills-hammer"
                name="hammer"
                data-cy="hammer"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.stonechisel')}
                id="skills-stonechisel"
                name="stonechisel"
                data-cy="stonechisel"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.alchemy')}
                id="skills-alchemy"
                name="alchemy"
                data-cy="alchemy"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.naturalsubstances')}
                id="skills-naturalsubstances"
                name="naturalsubstances"
                data-cy="naturalsubstances"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.shields')}
                id="skills-shields"
                name="shields"
                data-cy="shields"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.mediummetalshield')}
                id="skills-mediummetalshield"
                name="mediummetalshield"
                data-cy="mediummetalshield"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.smallwoodenshield')}
                id="skills-smallwoodenshield"
                name="smallwoodenshield"
                data-cy="smallwoodenshield"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.smallmetalshield')}
                id="skills-smallmetalshield"
                name="smallmetalshield"
                data-cy="smallmetalshield"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.largemetalshield')}
                id="skills-largemetalshield"
                name="largemetalshield"
                data-cy="largemetalshield"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.mediumwoodenshield')}
                id="skills-mediumwoodenshield"
                name="mediumwoodenshield"
                data-cy="mediumwoodenshield"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.largewoodenshield')}
                id="skills-largewoodenshield"
                name="largewoodenshield"
                data-cy="largewoodenshield"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.axes')}
                id="skills-axes"
                name="axes"
                data-cy="axes"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.hatchet')}
                id="skills-hatchet"
                name="hatchet"
                data-cy="hatchet"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.smallaxe')}
                id="skills-smallaxe"
                name="smallaxe"
                data-cy="smallaxe"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.largeaxe')}
                id="skills-largeaxe"
                name="largeaxe"
                data-cy="largeaxe"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.hugeaxe')}
                id="skills-hugeaxe"
                name="hugeaxe"
                data-cy="hugeaxe"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.swords')}
                id="skills-swords"
                name="swords"
                data-cy="swords"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.longsword')}
                id="skills-longsword"
                name="longsword"
                data-cy="longsword"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.shortsword')}
                id="skills-shortsword"
                name="shortsword"
                data-cy="shortsword"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.twohandedsword')}
                id="skills-twohandedsword"
                name="twohandedsword"
                data-cy="twohandedsword"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.knives')}
                id="skills-knives"
                name="knives"
                data-cy="knives"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.carvingknife')}
                id="skills-carvingknife"
                name="carvingknife"
                data-cy="carvingknife"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.butcheringknife')}
                id="skills-butcheringknife"
                name="butcheringknife"
                data-cy="butcheringknife"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.woodcutting')}
                id="skills-woodcutting"
                name="woodcutting"
                data-cy="woodcutting"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.mauls')}
                id="skills-mauls"
                name="mauls"
                data-cy="mauls"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.mediummaul')}
                id="skills-mediummaul"
                name="mediummaul"
                data-cy="mediummaul"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.smallmaul')}
                id="skills-smallmaul"
                name="smallmaul"
                data-cy="smallmaul"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.largemaul')}
                id="skills-largemaul"
                name="largemaul"
                data-cy="largemaul"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.carpentry')}
                id="skills-carpentry"
                name="carpentry"
                data-cy="carpentry"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.bowyery')}
                id="skills-bowyery"
                name="bowyery"
                data-cy="bowyery"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.fletching')}
                id="skills-fletching"
                name="fletching"
                data-cy="fletching"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.finecarpentry')}
                id="skills-finecarpentry"
                name="finecarpentry"
                data-cy="finecarpentry"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.toymaking')}
                id="skills-toymaking"
                name="toymaking"
                data-cy="toymaking"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.shipbuilding')}
                id="skills-shipbuilding"
                name="shipbuilding"
                data-cy="shipbuilding"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.mind')}
                id="skills-mind"
                name="mind"
                data-cy="mind"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.mindlogic')}
                id="skills-mindlogic"
                name="mindlogic"
                data-cy="mindlogic"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.mindspeed')}
                id="skills-mindspeed"
                name="mindspeed"
                data-cy="mindspeed"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.soul')}
                id="skills-soul"
                name="soul"
                data-cy="soul"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.souldepth')}
                id="skills-souldepth"
                name="souldepth"
                data-cy="souldepth"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.soulstrength')}
                id="skills-soulstrength"
                name="soulstrength"
                data-cy="soulstrength"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.body')}
                id="skills-body"
                name="body"
                data-cy="body"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.bodystrength')}
                id="skills-bodystrength"
                name="bodystrength"
                data-cy="bodystrength"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.bodystamina')}
                id="skills-bodystamina"
                name="bodystamina"
                data-cy="bodystamina"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.bodycontrol')}
                id="skills-bodycontrol"
                name="bodycontrol"
                data-cy="bodycontrol"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.faith')}
                id="skills-faith"
                name="faith"
                data-cy="faith"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.favor')}
                id="skills-favor"
                name="favor"
                data-cy="favor"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('verasmApp.skills.alignment')}
                id="skills-alignment"
                name="alignment"
                data-cy="alignment"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  min: { value: 1.0, message: translate('entity.validation.min', { min: 1.0 }) },
                  max: { value: 100.0, message: translate('entity.validation.max', { max: 100.0 }) },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField id="skills-user" name="user" data-cy="user" label={translate('verasmApp.skills.user')} type="select">
                <option value="" key="0" />
                {users
                  ? users.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.login}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/skills" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default SkillsUpdate;
