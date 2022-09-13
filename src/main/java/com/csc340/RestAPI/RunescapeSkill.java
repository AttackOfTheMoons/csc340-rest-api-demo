package com.csc340.RestAPI;

import java.util.List;

public class RunescapeSkill
{
	int rank;
	int level;
	int experience;
	RunescapeSkill(int rank, int level, int experience) {
		this.rank = rank;
		this.level = level;
		this.experience = experience;
	}

	public RunescapeSkill(Integer[] skill)
	{
		this(skill[0], skill[1], skill[2]);
	}

	@Override
	public String toString() {
		return String.format("{rank: %d, level: %d, experience: %d}", this.rank, this.level, this.experience);
	}
}
