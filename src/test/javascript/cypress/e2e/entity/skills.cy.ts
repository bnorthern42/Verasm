import {
  entityTableSelector,
  entityDetailsButtonSelector,
  entityDetailsBackButtonSelector,
  entityCreateButtonSelector,
  entityCreateSaveButtonSelector,
  entityCreateCancelButtonSelector,
  entityEditButtonSelector,
  entityDeleteButtonSelector,
  entityConfirmDeleteButtonSelector,
} from '../../support/entity';

describe('Skills e2e test', () => {
  const skillsPageUrl = '/skills';
  const skillsPageUrlPattern = new RegExp('/skills(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const skillsSample = {
    dumptime: 'incentivize models',
    playername: 'Industrial e-commerce',
    premium: 'Valleys',
    server: 'Dinar task-force synthesize',
    religion: 76,
    prayer: 44,
    channeling: 66,
    preaching: 100,
    exorcism: 19,
    hammers: 33,
    warhammer: 64,
    healing: 34,
    firstaid: 20,
    clubs: 23,
    hugeclub: 69,
    archery: 78,
    shortbow: 66,
    mediumbow: 72,
    longbow: 25,
    thievery: 2,
    stealing: 12,
    lockpicking: 5,
    traps: 32,
    warmachines: 18,
    catapults: 60,
    trebuchets: 36,
    ballistae: 15,
    polearms: 2,
    staff: 29,
    longspear: 25,
    halberd: 91,
    prospecting: 56,
    coalmaking: 30,
    milling: 4,
    tracking: 56,
    paving: 40,
    archaeology: 25,
    restoration: 91,
    climbing: 48,
    thatching: 45,
    firemaking: 64,
    pottery: 82,
    mining: 76,
    digging: 33,
    ropemaking: 71,
    smithing: 34,
    blacksmithing: 19,
    locksmithing: 84,
    jewelrysmithing: 52,
    metallurgy: 37,
    weaponsmithing: 16,
    bladessmithing: 99,
    weaponheadssmithing: 1,
    armoursmithing: 35,
    shieldsmithing: 33,
    chainarmoursmithing: 21,
    platearmoursmithing: 20,
    tailoring: 2,
    clothtailoring: 82,
    leatherworking: 7,
    masonry: 24,
    stonecutting: 39,
    cooking: 15,
    hotfoodcooking: 8,
    baking: 97,
    dairyfoodmaking: 18,
    butchering: 92,
    beverages: 40,
    nature: 31,
    fishing: 66,
    gardening: 12,
    foraging: 55,
    botanizing: 85,
    animaltaming: 64,
    forestry: 54,
    farming: 57,
    milking: 7,
    meditating: 12,
    animalhusbandry: 91,
    papyrusmaking: 82,
    toys: 76,
    yoyo: 87,
    puppeteering: 70,
    fighting: 35,
    defensivefighting: 16,
    normalfighting: 58,
    weaponlessfighting: 92,
    aggressivefighting: 28,
    shieldbashing: 84,
    taunting: 86,
    miscellaneousitems: 26,
    shovel: 15,
    rake: 73,
    saw: 55,
    pickaxe: 76,
    repairing: 40,
    sickle: 95,
    scythe: 91,
    hammer: 36,
    stonechisel: 17,
    alchemy: 97,
    naturalsubstances: 3,
    shields: 80,
    mediummetalshield: 70,
    smallwoodenshield: 88,
    smallmetalshield: 4,
    largemetalshield: 36,
    mediumwoodenshield: 24,
    largewoodenshield: 99,
    axes: 96,
    hatchet: 55,
    smallaxe: 62,
    largeaxe: 94,
    hugeaxe: 25,
    swords: 42,
    longsword: 8,
    shortsword: 52,
    twohandedsword: 98,
    knives: 44,
    carvingknife: 72,
    butcheringknife: 80,
    woodcutting: 3,
    mauls: 88,
    mediummaul: 87,
    smallmaul: 39,
    largemaul: 7,
    carpentry: 86,
    bowyery: 36,
    fletching: 41,
    finecarpentry: 15,
    toymaking: 54,
    shipbuilding: 85,
    mind: 10,
    mindlogic: 87,
    mindspeed: 86,
    soul: 8,
    souldepth: 34,
    soulstrength: 95,
    body: 25,
    bodystrength: 8,
    bodystamina: 57,
    bodycontrol: 53,
    faith: 55,
    favor: 79,
    alignment: 26,
  };

  let skills;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/skills+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/skills').as('postEntityRequest');
    cy.intercept('DELETE', '/api/skills/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (skills) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/skills/${skills.id}`,
      }).then(() => {
        skills = undefined;
      });
    }
  });

  it('Skills menu should load Skills page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('skills');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('Skills').should('exist');
    cy.url().should('match', skillsPageUrlPattern);
  });

  describe('Skills page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(skillsPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create Skills page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/skills/new$'));
        cy.getEntityCreateUpdateHeading('Skills');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', skillsPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/skills',
          body: skillsSample,
        }).then(({ body }) => {
          skills = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/skills+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/skills?page=0&size=20>; rel="last",<http://localhost/api/skills?page=0&size=20>; rel="first"',
              },
              body: [skills],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(skillsPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details Skills page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('skills');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', skillsPageUrlPattern);
      });

      it('edit button click should load edit Skills page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Skills');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', skillsPageUrlPattern);
      });

      it('edit button click should load edit Skills page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Skills');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', skillsPageUrlPattern);
      });

      it('last delete button click should delete instance of Skills', () => {
        cy.intercept('GET', '/api/skills/*').as('dialogDeleteRequest');
        cy.get(entityDeleteButtonSelector).last().click();
        cy.wait('@dialogDeleteRequest');
        cy.getEntityDeleteDialogHeading('skills').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', skillsPageUrlPattern);

        skills = undefined;
      });
    });
  });

  describe('new Skills page', () => {
    beforeEach(() => {
      cy.visit(`${skillsPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('Skills');
    });

    it('should create an instance of Skills', () => {
      cy.get(`[data-cy="dumptime"]`).type('dot-com Prairie Account').should('have.value', 'dot-com Prairie Account');

      cy.get(`[data-cy="playername"]`).type('concept withdrawal').should('have.value', 'concept withdrawal');

      cy.get(`[data-cy="premium"]`).type('Bacon').should('have.value', 'Bacon');

      cy.get(`[data-cy="server"]`).type('Wisconsin Frozen').should('have.value', 'Wisconsin Frozen');

      cy.get(`[data-cy="religion"]`).type('72').should('have.value', '72');

      cy.get(`[data-cy="prayer"]`).type('77').should('have.value', '77');

      cy.get(`[data-cy="channeling"]`).type('77').should('have.value', '77');

      cy.get(`[data-cy="preaching"]`).type('91').should('have.value', '91');

      cy.get(`[data-cy="exorcism"]`).type('60').should('have.value', '60');

      cy.get(`[data-cy="hammers"]`).type('1').should('have.value', '1');

      cy.get(`[data-cy="warhammer"]`).type('57').should('have.value', '57');

      cy.get(`[data-cy="healing"]`).type('22').should('have.value', '22');

      cy.get(`[data-cy="firstaid"]`).type('23').should('have.value', '23');

      cy.get(`[data-cy="clubs"]`).type('7').should('have.value', '7');

      cy.get(`[data-cy="hugeclub"]`).type('68').should('have.value', '68');

      cy.get(`[data-cy="archery"]`).type('22').should('have.value', '22');

      cy.get(`[data-cy="shortbow"]`).type('92').should('have.value', '92');

      cy.get(`[data-cy="mediumbow"]`).type('1').should('have.value', '1');

      cy.get(`[data-cy="longbow"]`).type('90').should('have.value', '90');

      cy.get(`[data-cy="thievery"]`).type('30').should('have.value', '30');

      cy.get(`[data-cy="stealing"]`).type('71').should('have.value', '71');

      cy.get(`[data-cy="lockpicking"]`).type('47').should('have.value', '47');

      cy.get(`[data-cy="traps"]`).type('97').should('have.value', '97');

      cy.get(`[data-cy="warmachines"]`).type('17').should('have.value', '17');

      cy.get(`[data-cy="catapults"]`).type('30').should('have.value', '30');

      cy.get(`[data-cy="trebuchets"]`).type('82').should('have.value', '82');

      cy.get(`[data-cy="ballistae"]`).type('19').should('have.value', '19');

      cy.get(`[data-cy="polearms"]`).type('50').should('have.value', '50');

      cy.get(`[data-cy="staff"]`).type('90').should('have.value', '90');

      cy.get(`[data-cy="longspear"]`).type('15').should('have.value', '15');

      cy.get(`[data-cy="halberd"]`).type('42').should('have.value', '42');

      cy.get(`[data-cy="prospecting"]`).type('74').should('have.value', '74');

      cy.get(`[data-cy="coalmaking"]`).type('93').should('have.value', '93');

      cy.get(`[data-cy="milling"]`).type('98').should('have.value', '98');

      cy.get(`[data-cy="tracking"]`).type('51').should('have.value', '51');

      cy.get(`[data-cy="paving"]`).type('33').should('have.value', '33');

      cy.get(`[data-cy="archaeology"]`).type('8').should('have.value', '8');

      cy.get(`[data-cy="restoration"]`).type('53').should('have.value', '53');

      cy.get(`[data-cy="climbing"]`).type('59').should('have.value', '59');

      cy.get(`[data-cy="thatching"]`).type('52').should('have.value', '52');

      cy.get(`[data-cy="firemaking"]`).type('72').should('have.value', '72');

      cy.get(`[data-cy="pottery"]`).type('11').should('have.value', '11');

      cy.get(`[data-cy="mining"]`).type('65').should('have.value', '65');

      cy.get(`[data-cy="digging"]`).type('4').should('have.value', '4');

      cy.get(`[data-cy="ropemaking"]`).type('27').should('have.value', '27');

      cy.get(`[data-cy="smithing"]`).type('11').should('have.value', '11');

      cy.get(`[data-cy="blacksmithing"]`).type('79').should('have.value', '79');

      cy.get(`[data-cy="locksmithing"]`).type('85').should('have.value', '85');

      cy.get(`[data-cy="jewelrysmithing"]`).type('55').should('have.value', '55');

      cy.get(`[data-cy="metallurgy"]`).type('99').should('have.value', '99');

      cy.get(`[data-cy="weaponsmithing"]`).type('56').should('have.value', '56');

      cy.get(`[data-cy="bladessmithing"]`).type('3').should('have.value', '3');

      cy.get(`[data-cy="weaponheadssmithing"]`).type('18').should('have.value', '18');

      cy.get(`[data-cy="armoursmithing"]`).type('72').should('have.value', '72');

      cy.get(`[data-cy="shieldsmithing"]`).type('77').should('have.value', '77');

      cy.get(`[data-cy="chainarmoursmithing"]`).type('76').should('have.value', '76');

      cy.get(`[data-cy="platearmoursmithing"]`).type('87').should('have.value', '87');

      cy.get(`[data-cy="tailoring"]`).type('63').should('have.value', '63');

      cy.get(`[data-cy="clothtailoring"]`).type('79').should('have.value', '79');

      cy.get(`[data-cy="leatherworking"]`).type('93').should('have.value', '93');

      cy.get(`[data-cy="masonry"]`).type('26').should('have.value', '26');

      cy.get(`[data-cy="stonecutting"]`).type('35').should('have.value', '35');

      cy.get(`[data-cy="cooking"]`).type('81').should('have.value', '81');

      cy.get(`[data-cy="hotfoodcooking"]`).type('76').should('have.value', '76');

      cy.get(`[data-cy="baking"]`).type('1').should('have.value', '1');

      cy.get(`[data-cy="dairyfoodmaking"]`).type('38').should('have.value', '38');

      cy.get(`[data-cy="butchering"]`).type('1').should('have.value', '1');

      cy.get(`[data-cy="beverages"]`).type('73').should('have.value', '73');

      cy.get(`[data-cy="nature"]`).type('25').should('have.value', '25');

      cy.get(`[data-cy="fishing"]`).type('10').should('have.value', '10');

      cy.get(`[data-cy="gardening"]`).type('87').should('have.value', '87');

      cy.get(`[data-cy="foraging"]`).type('60').should('have.value', '60');

      cy.get(`[data-cy="botanizing"]`).type('60').should('have.value', '60');

      cy.get(`[data-cy="animaltaming"]`).type('49').should('have.value', '49');

      cy.get(`[data-cy="forestry"]`).type('56').should('have.value', '56');

      cy.get(`[data-cy="farming"]`).type('84').should('have.value', '84');

      cy.get(`[data-cy="milking"]`).type('21').should('have.value', '21');

      cy.get(`[data-cy="meditating"]`).type('17').should('have.value', '17');

      cy.get(`[data-cy="animalhusbandry"]`).type('71').should('have.value', '71');

      cy.get(`[data-cy="papyrusmaking"]`).type('79').should('have.value', '79');

      cy.get(`[data-cy="toys"]`).type('32').should('have.value', '32');

      cy.get(`[data-cy="yoyo"]`).type('95').should('have.value', '95');

      cy.get(`[data-cy="puppeteering"]`).type('24').should('have.value', '24');

      cy.get(`[data-cy="fighting"]`).type('39').should('have.value', '39');

      cy.get(`[data-cy="defensivefighting"]`).type('58').should('have.value', '58');

      cy.get(`[data-cy="normalfighting"]`).type('75').should('have.value', '75');

      cy.get(`[data-cy="weaponlessfighting"]`).type('92').should('have.value', '92');

      cy.get(`[data-cy="aggressivefighting"]`).type('93').should('have.value', '93');

      cy.get(`[data-cy="shieldbashing"]`).type('35').should('have.value', '35');

      cy.get(`[data-cy="taunting"]`).type('28').should('have.value', '28');

      cy.get(`[data-cy="miscellaneousitems"]`).type('75').should('have.value', '75');

      cy.get(`[data-cy="shovel"]`).type('81').should('have.value', '81');

      cy.get(`[data-cy="rake"]`).type('5').should('have.value', '5');

      cy.get(`[data-cy="saw"]`).type('47').should('have.value', '47');

      cy.get(`[data-cy="pickaxe"]`).type('60').should('have.value', '60');

      cy.get(`[data-cy="repairing"]`).type('41').should('have.value', '41');

      cy.get(`[data-cy="sickle"]`).type('99').should('have.value', '99');

      cy.get(`[data-cy="scythe"]`).type('4').should('have.value', '4');

      cy.get(`[data-cy="hammer"]`).type('9').should('have.value', '9');

      cy.get(`[data-cy="stonechisel"]`).type('58').should('have.value', '58');

      cy.get(`[data-cy="alchemy"]`).type('18').should('have.value', '18');

      cy.get(`[data-cy="naturalsubstances"]`).type('60').should('have.value', '60');

      cy.get(`[data-cy="shields"]`).type('81').should('have.value', '81');

      cy.get(`[data-cy="mediummetalshield"]`).type('56').should('have.value', '56');

      cy.get(`[data-cy="smallwoodenshield"]`).type('60').should('have.value', '60');

      cy.get(`[data-cy="smallmetalshield"]`).type('25').should('have.value', '25');

      cy.get(`[data-cy="largemetalshield"]`).type('39').should('have.value', '39');

      cy.get(`[data-cy="mediumwoodenshield"]`).type('63').should('have.value', '63');

      cy.get(`[data-cy="largewoodenshield"]`).type('32').should('have.value', '32');

      cy.get(`[data-cy="axes"]`).type('73').should('have.value', '73');

      cy.get(`[data-cy="hatchet"]`).type('16').should('have.value', '16');

      cy.get(`[data-cy="smallaxe"]`).type('46').should('have.value', '46');

      cy.get(`[data-cy="largeaxe"]`).type('38').should('have.value', '38');

      cy.get(`[data-cy="hugeaxe"]`).type('25').should('have.value', '25');

      cy.get(`[data-cy="swords"]`).type('95').should('have.value', '95');

      cy.get(`[data-cy="longsword"]`).type('31').should('have.value', '31');

      cy.get(`[data-cy="shortsword"]`).type('38').should('have.value', '38');

      cy.get(`[data-cy="twohandedsword"]`).type('41').should('have.value', '41');

      cy.get(`[data-cy="knives"]`).type('44').should('have.value', '44');

      cy.get(`[data-cy="carvingknife"]`).type('9').should('have.value', '9');

      cy.get(`[data-cy="butcheringknife"]`).type('30').should('have.value', '30');

      cy.get(`[data-cy="woodcutting"]`).type('84').should('have.value', '84');

      cy.get(`[data-cy="mauls"]`).type('62').should('have.value', '62');

      cy.get(`[data-cy="mediummaul"]`).type('68').should('have.value', '68');

      cy.get(`[data-cy="smallmaul"]`).type('98').should('have.value', '98');

      cy.get(`[data-cy="largemaul"]`).type('44').should('have.value', '44');

      cy.get(`[data-cy="carpentry"]`).type('99').should('have.value', '99');

      cy.get(`[data-cy="bowyery"]`).type('4').should('have.value', '4');

      cy.get(`[data-cy="fletching"]`).type('53').should('have.value', '53');

      cy.get(`[data-cy="finecarpentry"]`).type('86').should('have.value', '86');

      cy.get(`[data-cy="toymaking"]`).type('74').should('have.value', '74');

      cy.get(`[data-cy="shipbuilding"]`).type('11').should('have.value', '11');

      cy.get(`[data-cy="mind"]`).type('92').should('have.value', '92');

      cy.get(`[data-cy="mindlogic"]`).type('8').should('have.value', '8');

      cy.get(`[data-cy="mindspeed"]`).type('67').should('have.value', '67');

      cy.get(`[data-cy="soul"]`).type('57').should('have.value', '57');

      cy.get(`[data-cy="souldepth"]`).type('71').should('have.value', '71');

      cy.get(`[data-cy="soulstrength"]`).type('66').should('have.value', '66');

      cy.get(`[data-cy="body"]`).type('55').should('have.value', '55');

      cy.get(`[data-cy="bodystrength"]`).type('71').should('have.value', '71');

      cy.get(`[data-cy="bodystamina"]`).type('71').should('have.value', '71');

      cy.get(`[data-cy="bodycontrol"]`).type('49').should('have.value', '49');

      cy.get(`[data-cy="faith"]`).type('57').should('have.value', '57');

      cy.get(`[data-cy="favor"]`).type('98').should('have.value', '98');

      cy.get(`[data-cy="alignment"]`).type('66').should('have.value', '66');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(201);
        skills = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(200);
      });
      cy.url().should('match', skillsPageUrlPattern);
    });
  });
});
