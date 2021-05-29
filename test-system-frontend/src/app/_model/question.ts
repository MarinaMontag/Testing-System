import {Test} from './test';
import {Answer} from './answer';

export class Question{
id: bigint;
text: string;
points: number;
test: Test;
answers: Answer[] = [];
}
