import React from 'react';

interface LabelProps extends React.LabelHTMLAttributes<HTMLLabelElement> {
  children: React.ReactNode;
  isRequired?: boolean;
}

export default function Label({ children, isRequired = false }: LabelProps) {
  return (
    <label className="mb-2 block text-sm font-medium text-gray-700">
      Digite seu CPF para entrar{' '}
      {isRequired && <span className="font-bold text-red-700">*</span>}
      {children}
    </label>
  );
}
