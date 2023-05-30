package ca.awoo.lillil.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ca.awoo.lillil.Function;
import ca.awoo.lillil.LillilRuntimeException;

/**
 * A function that takes a map of attributes and a list of content and returns the string representation of an html element.
 */
public abstract class ElementFunction implements Function {
    @Override
    public Object apply(Object... args) throws LillilRuntimeException {
        Map<String, String> attrs = new HashMap<String, String>();
        if(args[0] instanceof Map){
            Map<Object,Object> genericMap = (Map<Object,Object>) args[0];
            for(Entry<Object,Object> entry : genericMap.entrySet()){
                if(entry.getKey() instanceof String && entry.getValue() instanceof String){
                    attrs.put(entry.getKey().toString(), entry.getValue().toString());
                } else{
                    throw new LillilRuntimeException("element: attributes values must be strings, got: " + entry.getValue().getClass().getName());
                }
            }
            List<Object> content = new ArrayList<Object>();
            //Sometime we pass a list to elemFunc, so we need to flatten it
            //Passing a list is what lets us use the content param in the element function without using apply
            for(Object o : args){
                if(o instanceof List){
                    for(Object o2 : (List)o){
                        content.add(o2);
                    }
                }else{
                    content.add(o);
                }
            }
            return apply(attrs, content.subList(1, content.size()).toArray());
        } else {
            throw new LillilRuntimeException("element: attributes must be a map, got: " + args[0].getClass().getName());
        }

    }

    /**
     * Build the html element.
     * @param attrs A map of attributes
     * @param content A list of content
     * @return The string representation of the html element
     * @throws LillilRuntimeException
     */
    public abstract Object apply(Map<String, String> attrs, Object... content) throws LillilRuntimeException;
}
