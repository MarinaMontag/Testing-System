import {Result} from './result';
import {Test} from './test';
export class Member{
  id: bigint;
  name: string;
  surname: string;
  email: string;
  password: string;
  role: string;
  token: string;
  results: Result[] = [];
  tests: Test[] = [];
}
