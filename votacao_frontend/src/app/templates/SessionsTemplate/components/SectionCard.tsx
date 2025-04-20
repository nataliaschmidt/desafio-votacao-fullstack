import { ISection } from '@/app/api/types/section';
import Button from '@/app/components/Button';

import React, { SetStateAction } from 'react';

type TSectionCard = {
  onclick: (id: number) => void;
  section: ISection;
};

export default function SectionCard({ section, onclick }: TSectionCard) {
  return (
    <div className="flex h-full w-full flex-col items-start justify-center gap-2 p-4 text-center shadow-lg">
      <p className="w-full truncate text-left" title={section?.agendaId?.name}>
        <strong>Pauta:</strong> {section?.agendaId?.name}
      </p>
      <p>
        <strong>Duração:</strong> {section?.duration} minutos
      </p>
      <p>
        <strong>Início:</strong> {new Date(section?.start).toLocaleString()}
      </p>
      <p>
        <strong>Fim:</strong> {new Date(section?.end).toLocaleString()}
      </p>
      <div className="self-center">
        <Button onClick={() => onclick(section.id)}>Votar</Button>
      </div>
    </div>
  );
}
