import {UserInterface} from "../user/userIntf";

export interface SuccessInterface {
  sessionTokenId: string;
  message: string;
  user: UserInterface;
}
