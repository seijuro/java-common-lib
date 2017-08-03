package com.github.seijuro.common.xml.parser;

import com.github.seijuro.common.annotation.MethodDescription;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
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
    @Getter(AccessLevel.PROTECTED)
    private TagStack<String> tagStack = new TagStack<>();
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private String currentValue = null;

    @Getter(AccessLevel.PROTECTED)
    private final InputType inputType;
    @Getter(AccessLevel.PROTECTED)
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
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    /**
     * endDocument
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String url, String localName, String qName, Attributes attributes) throws SAXException {
        this.tagStack.push(qName);

        handleTagBegin(qName);
    }

    @Override
    public void endElement(String url, String localName, String qName) throws SAXException {
        String top = this.tagStack.top();

        if (this.tagStack.isTop(qName)) {
            this.tagStack.pop();
        }

        handleTagEnd(top, getCurrentValue());
    }

    @MethodDescription(
            name = "This interface will be called when the opening tag.",
            description = "This method return 'true', when you got done with tag. Otherwise, false")
    protected abstract boolean handleTagBegin(String tag);

    @MethodDescription(
            name = "This interface will be called when the closing tag",
            description = "This method return 'true', when you got done with tag. Otherwise, false")
    protected abstract boolean handleTagEnd(String tag, String value);

    @Override
    public void characters(char[] ch, int start, int length) {
        setCurrentValue(new String(ch, start, length).trim());
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
