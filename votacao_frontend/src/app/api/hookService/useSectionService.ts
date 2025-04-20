import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query';
import { sectionService } from '../service/sectionService';
import { ISection, TSectionBody } from '../types/section';

const QUERY_KEYS = {
  allOpenSections: 'allOpenSections',
};

export const useGetAllOpenSections = () => {
  return useQuery<ISection[], Error>({
    queryKey: [QUERY_KEYS.allOpenSections],
    queryFn: sectionService.getAllOpenSection,
  });
};

export const useCreateSection = () => {
  const queryClient = useQueryClient();

  return useMutation({
    mutationFn: (body: TSectionBody) => sectionService.create(body),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: [QUERY_KEYS.allOpenSections] });
    },
  });
};
