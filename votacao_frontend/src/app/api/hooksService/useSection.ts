import { BASE_URL } from '../config/baseURL';
import { ISection } from '../types/section';

export const SectionService = {
  getAllOpenSection: async (): Promise<ISection[]> => {
    try {
      const res = await fetch(`${BASE_URL}/section/open`);
      if (!res.ok) throw new Error('Erro ao carregar a listagem');

      const data: ISection[] = await res.json();

      data.sort((a, b) => new Date(b.start).getTime() - new Date(a.start).getTime());

      return data;
    } catch (error) {
      console.error('Erro no serviço de listagem:', error);
      throw error;
    }
  },
};
