package grailsforbeginner

import grails.converters.JSON


class HttpRequesterService {

    def poster(def domainWithPort, def map) {

        def jsonString = map as JSON;

        try {
            URL url = new URL("http://" + domainWithPort);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(6000); //millisecond
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json")
            httpURLConnection.setRequestProperty("Accept", "application/json")

            OutputStream os = httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(jsonString.toString());
            writer.flush();
            writer.close();
            os.close();
            int httpResponse = httpURLConnection.getResponseCode();
            return httpResponse.toString()
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException From checkHttpResponse");
        } catch (UnknownHostException e) {
            System.out.println("UnKnown Host");
            return "98"
        } catch (SocketTimeoutException e) {
            System.out.println("Timeout");
            return "99"
        } catch (IOException e) {
            System.out.println("IOException From checkHttpResponse");
        }
    }

}
