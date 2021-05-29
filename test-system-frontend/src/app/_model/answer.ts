import {Question} from './question';

export class Answer{
id: bigint;
text: string;
correctness: boolean;
question: Question;
}
