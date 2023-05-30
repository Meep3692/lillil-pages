package ca.awoo.lillil.pages;

import java.util.Map;

import ca.awoo.lillil.LillilRuntimeException;

/**
 * Represents a basic html element.
 * Returns &lt;name attrs&gt;content&lt;/name&gt; when evaluated.
 */
public class BasicElementFunction extends ElementFunction {

    private final String name;

    public BasicElementFunction(String name) {
        this.name = name;
    }

    @Override
    public Object apply(Map<String, String> attrs, Object... content) throws LillilRuntimeException {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(name);
        for(Map.Entry<String, String> entry : attrs.entrySet()){
            sb.append(" ");
            sb.append(entry.getKey());
            sb.append("=\"");
            sb.append(entry.getValue());
            sb.append("\"");
        }
        sb.append(">");
        for(Object o : content){
            sb.append(o.toString());
        }
        sb.append("</");
        sb.append(name);
        sb.append(">");
        return sb.toString();
    }
    
}
