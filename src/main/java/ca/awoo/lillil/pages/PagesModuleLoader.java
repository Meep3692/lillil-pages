package ca.awoo.lillil.pages;

import java.io.InputStream;
import ca.awoo.lillil.Lillil;
import ca.awoo.lillil.module.StreamModuleLoader;

public class PagesModuleLoader extends StreamModuleLoader {

    private LillilServlet servlet;

    public PagesModuleLoader(Lillil lillil, LillilServlet servlet) {
        super(lillil);
        this.servlet = servlet;
    }

    @Override
    protected InputStream openStream(String arg0) {
        return servlet.getServletContext().getResourceAsStream("/modules/" + arg0.replace('.', '/') + ".lil");
    }
    
}
