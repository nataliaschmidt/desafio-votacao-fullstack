'use client'



import Button from '@/app/components/Button';
import Container from '@/app/components/Container';
import Input from '@/app/components/Input';
import Label from '@/app/components/Label';
import Select from '@/app/components/Select';
import React from 'react'
import { useForm } from 'react-hook-form';


const MOCKPautas = [
  {value: 1, label: "Orçamento"},
  {value: 2, label: "Novos recursos"},
  {value: 3, label: "Honorários"},
  {value: 4, label: "Horário da Daily"},
]

type TDataForm = {
  duration: number | null,
  agendaId: number | null,
}

const defaultValueForm: TDataForm = {
  duration: null,
  agendaId: null,
}

export default function CreateSessionTemplate() {

  const { handleSubmit, register } = useForm<TDataForm>({
    defaultValues: defaultValueForm,
  });

  const onSubmit = (data: TDataForm) => {
    console.log('Form Data:', data);
  };
  return (
    <div className='mt-10 md:w-96 md:mx-auto'>
    <Container>
      <form onSubmit={handleSubmit(onSubmit)} className='p-4 flex flex-col justify-center items-center'>
      <Label text='Selecione uma pauta' isRequired>
       <Select field={register("agendaId")} options={MOCKPautas} required={true}/>
       </Label>
       <Label text='Tempo de duração, em minutos'>
        <Input field={register('duration')} type='number' placeholder='Digite o tempo de duração da sessão'  />
       </Label>
       <Button>Salvar</Button>
      </form>
    </Container>
    </div>
  )
}
