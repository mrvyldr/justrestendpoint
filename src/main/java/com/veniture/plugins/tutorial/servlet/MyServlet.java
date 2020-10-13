package com.veniture.plugins.tutorial.servlet;

import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.JiraImport;
import com.atlassian.templaterenderer.TemplateRenderer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@Scanned
public class MyServlet extends HttpServlet {
    @JiraImport
    private TemplateRenderer templateRenderer;

    private static final String VELOCITY_TEMPLATE = "/templates/servlet.vm";


    public MyServlet(TemplateRenderer templateRenderer){this.templateRenderer = templateRenderer;}


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String url = "http://localhost:8080/rest/myrestresource/1.0/message";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }



            in.close();

        Map<String, Object> context = new HashMap<String, Object>();
        resp.setContentType("text/html;charset=utf-8");
        context.put("dolar",response.toString());

        templateRenderer.render(VELOCITY_TEMPLATE, context, resp.getWriter());


//        resp.setContentType("text/html;charset=utf-8");
//        resp.getWriter().write();
//        resp.getWriter().close();
    }
}
