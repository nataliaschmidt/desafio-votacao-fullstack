import { useQuery } from '@tanstack/react-query';
import { SectionService } from '../hooksService/useSection';
import { ISection } from '../types/section';

const QUERY_KEYS = {
  allOpenSections: 'allOpenSections',
};

export const UseGetAllOpenSections = () => {
  return useQuery<ISection[], Error>({
    queryKey: [QUERY_KEYS.allOpenSections],
    queryFn: SectionService.getAllOpenSection,
  });
};
