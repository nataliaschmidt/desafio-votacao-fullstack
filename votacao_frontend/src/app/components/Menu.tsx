'use client';

import Link from 'next/link';
import React from 'react';

import { useRouter } from 'next/navigation';
import { IoIosLogOut } from 'react-icons/io';
import { logout } from '@/app/utils/auth';
import { IoArrowBack } from 'react-icons/io5';

export default function Menu() {
  const router = useRouter();

  const handleLogout = () => {
    logout();
    router.replace('/');
  };

  return (
    <div className="flex items-center justify-between border-b border-green-700 p-6 text-xs font-medium shadow-[3px_3px_4px_1px_rgb(255_255_255/20%),0_0_5px_2px_rgb(0_0_0/40%)] md:text-sm">
      <h3 className="font-bold text-green-700">Bem-vindo!</h3>
      <nav className="flex items-center justify-center gap-6">
        <Link
          href="/"
          className="text-inherit no-underline transition-colors duration-200 ease-in-out hover:text-green-700"
        >
          Criar Pauta
        </Link>
        <Link
          href="/sessoes"
          className="text-inherit no-underline transition-colors duration-200 ease-in-out hover:text-green-700"
        >
          Sessões
        </Link>
      </nav>
      <div className="flex gap-6">
        <button
          onClick={() => router.back()}
          aria-label="Retornar a página"
          className="cursor-pointer border-none bg-transparent text-inherit"
        >
          <IoArrowBack size={20} />
        </button>
        <button
          onClick={handleLogout}
          aria-label="Realizar logout"
          className="cursor-pointer border-none bg-transparent text-inherit"
        >
          <IoIosLogOut size={20} />
        </button>
      </div>
    </div>
  );
}
