import { IUser } from 'app/shared/model/user.model';

export interface ISkills {
  id?: number;
  dumptime?: string;
  playername?: string;
  premium?: string;
  server?: string;
  religion?: number;
  prayer?: number;
  channeling?: number;
  preaching?: number;
  exorcism?: number;
  hammers?: number;
  warhammer?: number;
  healing?: number;
  firstaid?: number;
  clubs?: number;
  hugeclub?: number;
  archery?: number;
  shortbow?: number;
  mediumbow?: number;
  longbow?: number;
  thievery?: number;
  stealing?: number;
  lockpicking?: number;
  traps?: number;
  warmachines?: number;
  catapults?: number;
  trebuchets?: number;
  ballistae?: number;
  polearms?: number;
  staff?: number;
  longspear?: number;
  halberd?: number;
  prospecting?: number;
  coalmaking?: number;
  milling?: number;
  tracking?: number;
  paving?: number;
  archaeology?: number;
  restoration?: number;
  climbing?: number;
  thatching?: number;
  firemaking?: number;
  pottery?: number;
  mining?: number;
  digging?: number;
  ropemaking?: number;
  smithing?: number;
  blacksmithing?: number;
  locksmithing?: number;
  jewelrysmithing?: number;
  metallurgy?: number;
  weaponsmithing?: number;
  bladessmithing?: number;
  weaponheadssmithing?: number;
  armoursmithing?: number;
  shieldsmithing?: number;
  chainarmoursmithing?: number;
  platearmoursmithing?: number;
  tailoring?: number;
  clothtailoring?: number;
  leatherworking?: number;
  masonry?: number;
  stonecutting?: number;
  cooking?: number;
  hotfoodcooking?: number;
  baking?: number;
  dairyfoodmaking?: number;
  butchering?: number;
  beverages?: number;
  nature?: number;
  fishing?: number;
  gardening?: number;
  foraging?: number;
  botanizing?: number;
  animaltaming?: number;
  forestry?: number;
  farming?: number;
  milking?: number;
  meditating?: number;
  animalhusbandry?: number;
  papyrusmaking?: number;
  toys?: number;
  yoyo?: number;
  puppeteering?: number;
  fighting?: number;
  defensivefighting?: number;
  normalfighting?: number;
  weaponlessfighting?: number;
  aggressivefighting?: number;
  shieldbashing?: number;
  taunting?: number;
  miscellaneousitems?: number;
  shovel?: number;
  rake?: number;
  saw?: number;
  pickaxe?: number;
  repairing?: number;
  sickle?: number;
  scythe?: number;
  hammer?: number;
  stonechisel?: number;
  alchemy?: number;
  naturalsubstances?: number;
  shields?: number;
  mediummetalshield?: number;
  smallwoodenshield?: number;
  smallmetalshield?: number;
  largemetalshield?: number;
  mediumwoodenshield?: number;
  largewoodenshield?: number;
  axes?: number;
  hatchet?: number;
  smallaxe?: number;
  largeaxe?: number;
  hugeaxe?: number;
  swords?: number;
  longsword?: number;
  shortsword?: number;
  twohandedsword?: number;
  knives?: number;
  carvingknife?: number;
  butcheringknife?: number;
  woodcutting?: number;
  mauls?: number;
  mediummaul?: number;
  smallmaul?: number;
  largemaul?: number;
  carpentry?: number;
  bowyery?: number;
  fletching?: number;
  finecarpentry?: number;
  toymaking?: number;
  shipbuilding?: number;
  mind?: number;
  mindlogic?: number;
  mindspeed?: number;
  soul?: number;
  souldepth?: number;
  soulstrength?: number;
  body?: number;
  bodystrength?: number;
  bodystamina?: number;
  bodycontrol?: number;
  faith?: number;
  favor?: number;
  alignment?: number;
  user?: IUser | null;
}

export const defaultValue: Readonly<ISkills> = {};
