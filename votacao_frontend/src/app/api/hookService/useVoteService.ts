import { useMutation } from '@tanstack/react-query';

import { TVoteBody } from '../types/vote';
import { voteService } from '../service/voteService';

export const useCreateVote = () => {
  return useMutation({
    mutationFn: (body: TVoteBody) => voteService.create(body),
  });
};
