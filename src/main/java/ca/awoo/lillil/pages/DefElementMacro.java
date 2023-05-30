package ca.awoo.lillil.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import ca.awoo.lillil.Environment;
import ca.awoo.lillil.Lambda;
import ca.awoo.lillil.LillilRuntimeException;
import ca.awoo.lillil.Macro;
import ca.awoo.lillil.sexpr.Symbol;

/**
 * Defines a macro that creates a new element function.
 * Used in user code to define custom elements similar to React.
 */
public class DefElementMacro implements Macro{

    @Override
    public Object apply(Environment env, Object... args) throws LillilRuntimeException {
        //Ensure arg1 is a symbol
        if(!(args[0] instanceof Symbol)) {
            throw new LillilRuntimeException("def-element: first argument must be a symbol");
        }
        List<Symbol> params = new ArrayList<Symbol>(2);
        params.add(new Symbol("attrs"));
        params.add(new Symbol("content"));
        Lambda lambda = new Lambda(env, params, args[1]);
        ElementFunction elemFunc = new ElementFunction(){
            @Override
            public Object apply(Map<String, String> attrs, Object... content) throws LillilRuntimeException {
                return lambda.apply(attrs, Arrays.asList(content));
            }
        };
        env.bind(((Symbol)args[0]).value, elemFunc);
        return null;
    }
    
}
