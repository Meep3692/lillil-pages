package ca.awoo.lillil.pages;

import ca.awoo.lillil.Environment;

/**
 * An environment that contains all the html elements.
 */
public class HtmlEnvironment extends Environment{
    public HtmlEnvironment(Environment parent) {
        super(parent);
        bind("def-element", new DefElementMacro());

        //Main root
        bind("html", new BasicElementFunction("html"));

        //Document metadata
        bind("base", new BasicElementFunction("base"));
        bind("head", new BasicElementFunction("head"));
        bind("link", new BasicElementFunction("link"));
        bind("meta", new BasicElementFunction("meta"));
        bind("style", new BasicElementFunction("style"));
        bind("title", new BasicElementFunction("title"));

        //Sectioning root
        bind("body", new BasicElementFunction("body"));

        //Content sectioning
        bind("address", new BasicElementFunction("address"));
        bind("article", new BasicElementFunction("article"));
        bind("aside", new BasicElementFunction("aside"));
        bind("footer", new BasicElementFunction("footer"));
        bind("header", new BasicElementFunction("header"));
        bind("h1", new BasicElementFunction("h1"));
        bind("h2", new BasicElementFunction("h2"));
        bind("h3", new BasicElementFunction("h3"));
        bind("h4", new BasicElementFunction("h4"));
        bind("h5", new BasicElementFunction("h5"));
        bind("h6", new BasicElementFunction("h6"));
        bind("hgroup", new BasicElementFunction("hgroup"));
        bind("nav", new BasicElementFunction("nav"));
        bind("section", new BasicElementFunction("section"));

        //Text content
        bind("blockquote", new BasicElementFunction("blockquote"));
        bind("dd", new BasicElementFunction("dd"));
        bind("div", new BasicElementFunction("div"));
        bind("dl", new BasicElementFunction("dl"));
        bind("dt", new BasicElementFunction("dt"));
        bind("figcaption", new BasicElementFunction("figcaption"));
        bind("figure", new BasicElementFunction("figure"));
        bind("hr", new BasicElementFunction("hr"));
        bind("li", new BasicElementFunction("li"));
        bind("main", new BasicElementFunction("main"));
        bind("ol", new BasicElementFunction("ol"));
        bind("p", new BasicElementFunction("p"));
        bind("pre", new BasicElementFunction("pre"));
        bind("ul", new BasicElementFunction("ul"));

        //Inline text semantics
        bind("a", new BasicElementFunction("a"));
        bind("abbr", new BasicElementFunction("abbr"));
        bind("b", new BasicElementFunction("b"));
        bind("bdi", new BasicElementFunction("bdi"));
        bind("bdo", new BasicElementFunction("bdo"));
        bind("br", new BasicElementFunction("br"));
        bind("cite", new BasicElementFunction("cite"));
        bind("code", new BasicElementFunction("code"));
        bind("data", new BasicElementFunction("data"));
        bind("dfn", new BasicElementFunction("dfn"));
        bind("em", new BasicElementFunction("em"));
        bind("i", new BasicElementFunction("i"));
        bind("kbd", new BasicElementFunction("kbd"));
        bind("mark", new BasicElementFunction("mark"));
        bind("q", new BasicElementFunction("q"));
        bind("rp", new BasicElementFunction("rp"));
        bind("rt", new BasicElementFunction("rt"));
        bind("ruby", new BasicElementFunction("ruby"));
        bind("s", new BasicElementFunction("s"));
        bind("samp", new BasicElementFunction("samp"));
        bind("small", new BasicElementFunction("small"));
        bind("span", new BasicElementFunction("span"));
        bind("strong", new BasicElementFunction("strong"));
        bind("sub", new BasicElementFunction("sub"));
        bind("sup", new BasicElementFunction("sup"));
        bind("time", new BasicElementFunction("time"));
        bind("u", new BasicElementFunction("u"));
        bind("var", new BasicElementFunction("var"));
        bind("wbr", new BasicElementFunction("wbr"));

        //Image and multimedia
        bind("area", new BasicElementFunction("area"));
        bind("audio", new BasicElementFunction("audio"));
        bind("img", new BasicElementFunction("img"));
        bind("html-map", new BasicElementFunction("map"));
        bind("track", new BasicElementFunction("track"));
        bind("video", new BasicElementFunction("video"));

        //Embedded content
        bind("embed", new BasicElementFunction("embed"));
        bind("iframe", new BasicElementFunction("iframe"));
        bind("object", new BasicElementFunction("object"));
        bind("picture", new BasicElementFunction("picture"));
        bind("portal", new BasicElementFunction("portal"));
        bind("source", new BasicElementFunction("source"));

        //SVG and MathML
        bind("svg", new BasicElementFunction("svg"));
        bind("math", new BasicElementFunction("math"));

        //Scripting
        bind("canvas", new BasicElementFunction("canvas"));
        bind("noscript", new BasicElementFunction("noscript"));
        bind("script", new BasicElementFunction("script"));

        //Demarcating edits
        bind("del", new BasicElementFunction("del"));
        bind("ins", new BasicElementFunction("ins"));

        //Table content
        bind("caption", new BasicElementFunction("caption"));
        bind("col", new BasicElementFunction("col"));
        bind("colgroup", new BasicElementFunction("colgroup"));
        bind("table", new BasicElementFunction("table"));
        bind("tbody", new BasicElementFunction("tbody"));
        bind("td", new BasicElementFunction("td"));
        bind("tfoot", new BasicElementFunction("tfoot"));
        bind("th", new BasicElementFunction("th"));
        bind("thead", new BasicElementFunction("thead"));
        bind("tr", new BasicElementFunction("tr"));

        //Forms
        bind("button", new BasicElementFunction("button"));
        bind("datalist", new BasicElementFunction("datalist"));
        bind("fieldset", new BasicElementFunction("fieldset"));
        bind("form", new BasicElementFunction("form"));
        bind("input", new BasicElementFunction("input"));
        bind("label", new BasicElementFunction("label"));
        bind("legend", new BasicElementFunction("legend"));
        bind("meter", new BasicElementFunction("meter"));
        bind("optgroup", new BasicElementFunction("optgroup"));
        bind("option", new BasicElementFunction("option"));
        bind("output", new BasicElementFunction("output"));
        bind("progress", new BasicElementFunction("progress"));
        bind("select", new BasicElementFunction("select"));
        bind("textarea", new BasicElementFunction("textarea"));

        //Interactive elements
        bind("details", new BasicElementFunction("details"));
        bind("dialog", new BasicElementFunction("dialog"));
        bind("menu", new BasicElementFunction("menu"));
        bind("summary", new BasicElementFunction("summary"));

        //Web Components
        bind("slot", new BasicElementFunction("slot"));
        bind("template", new BasicElementFunction("template"));

        //Obsolete and deprecated elements
        bind("acronym", new BasicElementFunction("acronym"));
        bind("big", new BasicElementFunction("big"));
        bind("center", new BasicElementFunction("center"));
        bind("content", new BasicElementFunction("content"));
        bind("dir", new BasicElementFunction("dir"));
        bind("font", new BasicElementFunction("font"));
        bind("frame", new BasicElementFunction("frame"));
        bind("frameset", new BasicElementFunction("frameset"));
        bind("image", new BasicElementFunction("image"));
        bind("marquee", new BasicElementFunction("marquee"));
        bind("menuitem", new BasicElementFunction("menuitem"));
        bind("nobr", new BasicElementFunction("nobr"));
        bind("noembed", new BasicElementFunction("noembed"));
        bind("noframes", new BasicElementFunction("noframes"));
        bind("param", new BasicElementFunction("param"));
        bind("plaintext", new BasicElementFunction("plaintext"));
        bind("rb", new BasicElementFunction("rb"));
        bind("rtc", new BasicElementFunction("rtc"));
        bind("shadow", new BasicElementFunction("shadow"));
        bind("strike", new BasicElementFunction("strike"));
        bind("tt", new BasicElementFunction("tt"));
        bind("xmp", new BasicElementFunction("xmp"));
    }
}
