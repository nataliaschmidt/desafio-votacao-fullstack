export interface IVote {
  voteId: number;
  cpf: string;
  voteOption: VoteOptionEnum;
}

enum VoteOptionEnum {
  SIM = 'SIM',
  NAO = 'NAO',
}
