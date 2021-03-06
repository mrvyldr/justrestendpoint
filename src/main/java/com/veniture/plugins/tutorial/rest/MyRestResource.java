package com.veniture.plugins.tutorial.rest;

import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import com.google.gson.Gson;
import com.veniture.plugins.tutorial.model.MyPojo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A resource of message.
 */
@Path("/message")
public class MyRestResource {

    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getMessage()
    {
        try {
            String url = "http://api.currencylayer.com/live?access_key=4d4b4583bdc3219f215ccda6e9cb5000";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();

            BufferedReader in =new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            } in .close();

            Gson g = new Gson();
            MyPojo p = g.fromJson(response.toString(), MyPojo.class);

            MyRestResourceModel mrr = new MyRestResourceModel(p.getQuotes().getUSDTRY());


            return Response.ok(mrr.getMessage()).build();

        } catch(Exception e) {

            return Response.ok(new MyRestResourceModel(e.toString())).build();
        }
       //return Response.ok(new MyRestResourceModel("Hello venITure")).build();
    }
}