import {UserInterface} from "../user/user";

export interface UserAuthResponse {
  statusText: string;
  message: string;
  attributes: Record<string, any>;
  user: UserInterface;
}
