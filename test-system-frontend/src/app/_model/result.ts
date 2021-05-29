import {Member} from './member';
import {Test} from './test';

export class Result{
id: bigint;
date: Date = new Date();
mark: number;
member: Member;
test: Test;
}
