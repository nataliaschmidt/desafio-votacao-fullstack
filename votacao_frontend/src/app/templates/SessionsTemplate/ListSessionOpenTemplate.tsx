'use client';

import { UseGetAllOpenSections } from '@/app/api/services/sectionService';
import Button from '@/app/components/Button';
import Container from '@/app/components/Container';
import { useRouter } from 'next/navigation';
import React from 'react';

const MOCKSESSION = [
  {
    name: 'Pauta lalalallalalalalalallalalalalalallalaalalalalal',
    duration: '60',
    start: '2025-04-20T02:23:54.860Z',
    end: '2025-04-20T02:23:54.860Z',
  },
  {
    name: 'Pauta',
    duration: '60',
    start: '2025-04-20T02:23:54.860Z',
    end: '2025-04-20T02:23:54.860Z',
  },
  {
    name: 'Pauta',
    duration: '60',
    start: '2025-04-20T02:23:54.860Z',
    end: '2025-04-20T02:23:54.860Z',
  },
  {
    name: 'Pauta',
    duration: '60',
    start: '2025-04-20T02:23:54.860Z',
    end: '2025-04-20T02:23:54.860Z',
  },
  {
    name: 'Pauta',
    duration: '60',
    start: '2025-04-20T02:23:54.860Z',
    end: '2025-04-20T02:23:54.860Z',
  },
];

export default function ListSessionOpenTemplate() {
  const router = useRouter();

  const { data: allOpenSections, isLoading } = UseGetAllOpenSections();

  return (
    <>
      <div className="my-10">
        <Button onClick={() => router.push('/sessoes/novasessao')}>
          Criar nova seção
        </Button>
      </div>
      <div className="mt-5 grid grid-cols-1 gap-4 md:grid-cols-3 lg:grid-cols-4">
        {
          !allOpenSections ? <p>Não foi possível carregar as sessões</p> : allOpenSections.length > 0 ? (
            allOpenSections?.map((session, index) => (
              <Container key={index}>
                <div className="flex h-full w-full flex-col items-start justify-center gap-2 p-4 text-center shadow-lg">
                  <p className="w-full truncate text-left" title={session?.agendaId?.name}>
                    <strong>Pauta:</strong> {session?.agendaId?.name}
                  </p>
                  <p>
                    <strong>Duração:</strong> {session?.duration} minutos
                  </p>
                  <p>
                    <strong>Início:</strong>{' '}
                    {new Date(session?.start).toLocaleString()}
                  </p>
                  <p>
                    <strong>Fim:</strong> {new Date(session?.end).toLocaleString()}
                  </p>
                  <div className="self-center">
                    <Button>Votar</Button>
                  </div>
                </div>
              </Container>
            ))
          ) : <p>Não há sessões cadastradas</p>
        }
  
      </div>
    </>
  );
}
