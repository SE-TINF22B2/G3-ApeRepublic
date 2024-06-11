import {SuccessInterface} from "./success";
import {ErrorInterface} from "./error";

export interface UserAuthResponse {
  successError: SuccessInterface | ErrorInterface;
}


