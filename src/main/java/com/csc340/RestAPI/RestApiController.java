package com.csc340.RestAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author sentini
 */
@RestController
public class RestApiController {

	/**
	 * Retrieve one Runescape user's total level and experience from the runescape API and output to console
	 *
	 * @param name The runescape player name to lookup
	 * @return true
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@GetMapping("/runescape")
	public boolean getRunescape(@RequestParam(value="name") String name) throws IOException, InterruptedException
	{
		String url = String.format("https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player=%s", name);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
		String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
		Map<String, RunescapeSkill> skillMap = Runescape.parse(response);
		System.out.printf("%s\nTotal Level: %d\nTotal Experience: %d%n", name, skillMap.get("overall").level, skillMap.get("overall").experience);
		return true;
	}


}
