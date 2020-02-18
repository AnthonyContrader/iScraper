export class TeamDTO {
	id:number;

	name:string;

	market_value:number;

	team_index:number;

	constructor(id: number, name: string, market_value: number,  team_index: number) {
        this.id = id;
        this.name = name;
        this.market_value = market_value;
        this.team_index = team_index;
}
}
