package cs.lab;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Translate {
	static final Logger logger = Logger.getLogger(Translate.class.getName());
    public Translate() {
	    logger.info("Starting translate...");
	}

    public String translate(String text) throws MaxLengthException, IOException {
        if(text.length() > 500) {
			throw new MaxLengthException("Character Length exceeded");
        }
		String urlEncode;
			urlEncode = URLEncoder.encode(text, "UTF-8");
		
		String urlStr = "https://script.google.com/macros/s/AKfycby7yA-le32mzRHoXZRyUInD_kNgXehqDTVW6OEtCBDbqI2cpA/exec" +
				"?q=" + urlEncode +"&target=en&source=es";
		URL url = new URL(urlStr);

		StringBuilder response = new StringBuilder();

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}
