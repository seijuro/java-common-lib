package com.github.seijuro.common.xml.parser;

import com.github.seijuro.common.annotation.AbstractMethod;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;

import static com.github.seijuro.common.xml.parser.XMLSAXParser.InputType.*;

public abstract class XMLSAXParser extends DefaultHandler {
    public enum InputType {
        UNKNOWN(InputType.CODE_INPUTTYPE_UNKNOWN),
        FILE(InputType.CODE_INPUTTYPE_FILE),
        TEXT(InputType.CODE_INPUTTYPE_TEXT);

        static final int CODE_INPUTTYPE_UNKNOWN = -1;
        static final int CODE_INPUTTYPE_TEXT = 1;
        static final int CODE_INPUTTYPE_FILE = 2;

        /**
         * Instance Property
         */
        private final int code;

        InputType(int $code) {
            this.code = $code;
        }
    }

    /**
     * Instance Properties
     */
    private TagStack<String> tagStack = new TagStack<>();
    private String currentValue = null;
    private int responseCode = -1;

    private final InputType inputType;
    private final String input;;

    /**
     * C'tor
     *
     * @param type
     * @param input
     */
    public XMLSAXParser(InputType type, String input) {
        this.inputType = type;
        this.input = input;
    }

    /**
     * startDocuemnt
     */
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    /**
     * endDocument
     */
    public void endDocuemtn() throws SAXException{
        super.endDocument();
    }

    public void startElement(String url, String localName, String qName, Attributes attributes) throws SAXException {
        this.tagStack.push(qName);
    }

    public void endElement(String url, String localName, String qName) throws SAXException {
        String top = this.tagStack.top();

        if (this.tagStack.isTop(qName)) {
            this.tagStack.pop();
        }

        handleTagEnd(top, this.currentValue);
    }

    @AbstractMethod(
            ClassName = "XMLSaxParser",
            MethodName = "handleTagBegin",
            Description = "Abstract Method")
    protected abstract void handleTagBegin(String tag);

    /**
     *
     * @param tag
     * @param value
     */
    @AbstractMethod(
            ClassName = "XMLSaxParser",
            MethodName = "handleTagEnd",
            Description = "Abstract Method")
    protected abstract void handleTagEnd(String tag, String value);

    public void characters(char[] ch, int start, int length) {
        this.currentValue = new String(ch, start, length);
    }

    public void parse() {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

            switch (this.inputType.code) {
                case CODE_INPUTTYPE_TEXT: {
                    InputStream is = new ByteArrayInputStream(this.input.getBytes());

                    parser.parse(is, this);
                }
                    break;

                case CODE_INPUTTYPE_FILE: {
                    File file = new File(this.input);
                    parser.parse(file, this);
                }
                    break;

                case CODE_INPUTTYPE_UNKNOWN:
                default:
                    break;
            }
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }
    }
}
