package com.csc340.RestAPI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Runescape
{
	static final String[] skills = {
		"overall",
		"attack",
		"defence",
		"strength",
		"hitpoints",
		"ranged",
		"prayer",
		"magic",
		"cooking",
		"woodcutting",
		"fletching",
		"fishing",
		"firemaking",
		"crafting",
		"smithing",
		"mining",
		"herblore",
		"agility",
		"thieving",
		"slayer",
		"farming",
		"runecraft",
		"hunter",
		"construction"
	};
	public static Map<String, RunescapeSkill> parse(String response) {
		String[] lines = response.split("\n");

		List<RunescapeSkill> parsedList = IntStream
			.range(0, lines.length)
			.filter(i -> i < skills.length)
			.mapToObj(index -> Arrays.stream(lines[index].split(","))
				.map(Integer::parseInt)
				.toArray(Integer[]::new))
			.map(RunescapeSkill::new)
			.toList();
		Map<String, RunescapeSkill> parsedValues = new HashMap<>();
		for (int i = 0; i < skills.length; i++) {
			parsedValues.put(skills[i], parsedList.get(i));
		}
		return parsedValues;
	}
}
