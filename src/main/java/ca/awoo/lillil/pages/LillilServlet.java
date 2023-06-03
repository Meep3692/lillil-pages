package ca.awoo.lillil.pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.awoo.lillil.Lillil;
import ca.awoo.lillil.LillilRuntimeException;
import ca.awoo.lillil.sexpr.Parser.ParseException;
import ca.awoo.lillil.sexpr.Tokenizer.TokenizerException;

/**
 * Servlet that evaluates lillil pages.
 */
public class LillilServlet extends HttpServlet {
    protected static final long serialVersionUID = 1L;

    public LillilServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        //Modules directory, don't let them access it
        if(request.getServletPath().startsWith("/modules")){
            response.sendError(403, "Forbidden");
            return;
        }

        PrintWriter out = response.getWriter();

        //Get file contents
        InputStream is = this.getServletContext().getResourceAsStream(request.getServletPath());
        if (is == null) {
            response.sendError(404, "File not found");
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        for(String line = br.readLine(); line != null; line = br.readLine()) {
            sb.append(line);
            sb.append("\n");
        }

        try{
            //Get request headers
            Map<String, String> headers = new HashMap<String, String>();
            for(String header : java.util.Collections.list(request.getHeaderNames())) {
                headers.put(header, request.getHeader(header));
            }
            //Create our lillil instance
            Lillil lillil = new Lillil();
            lillil.useCoreModule();
            lillil.useNativeModule(new HtmlNativeModuleLoader(lillil));
            PagesModuleLoader loader = new PagesModuleLoader(lillil, this);
            System.out.println(loader.loadModule("module"));
            lillil.addModuleLoader(loader);
            lillil.bindPersist("headers", headers);
            lillil.bindPersist("method", request.getMethod());
            //Eval and print results
            List<Object> results = lillil.evalAll(sb.toString());
            for(Object o : results) {
                if(o != null)
                    out.println(o);
            }
        } catch (TokenizerException | ParseException | LillilRuntimeException e) {
            //response.sendError(500, "Internal Server Error");
            response.setStatus(500);
            out.println("<h1>Internal Server Error</h1>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }
    }
}
