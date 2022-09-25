import React, { FunctionComponent } from 'react'; // importing FunctionComponent

type CardProps = {
  grouptitle: string;
  skills: string;
};
export const SkillGroup: FunctionComponent<CardProps> = ({ grouptitle }) => (
  <aside>
    <h2>{grouptitle}</h2>
    <ul></ul>
  </aside>
);
