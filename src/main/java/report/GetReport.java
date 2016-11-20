package report;

import com.google.gson.Gson;
import dto.Statistic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;


public class GetReport implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Statistic getReport(){
		String url = "http://localhost:8080/tschool/report/";

		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream(), "utf-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			String json = response.toString();

			Gson gson = new Gson();

			Statistic statistic = gson.fromJson(json, Statistic.class);

			return statistic;
		} catch (Exception ex) {
			return null;
		}
	}

}