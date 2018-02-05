package com.github.seijuro.common.xml.parser;

import com.github.seijuro.common.InputType;
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

import static com.github.seijuro.common.InputType.CODE_INPUTTYPE_FILE;
import static com.github.seijuro.common.InputType.CODE_INPUTTYPE_TEXT;
import static com.github.seijuro.common.InputType.CODE_INPUTTYPE_UNKNOWN;

public abstract class XMLSAXParser extends DefaultHandler {
    /**
     * Instance Properties
     */
    @Getter(AccessLevel.PROTECTED)
    private TagStack<String> tagStack = new TagStack<>();
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private String currentValue = null;

    /**
     * C'tor
     */
    public XMLSAXParser() {
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

        currentValue = null;

        handleTagBegin(qName);
    }

    @Override
    public void endElement(String url, String localName, String qName) throws SAXException {
        String top = this.tagStack.top();

        if (this.tagStack.isTop(qName)) {
            this.tagStack.pop();
        }

        handleTagEnd(qName, getCurrentValue());
    }

    public void clear() {
        this.tagStack.clear();
        this.currentValue = null;
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

    public void parse(InputType type, String input) {
        this.clear();

        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

            switch (type.getCode()) {
                case CODE_INPUTTYPE_TEXT: {
                    InputStream is = new ByteArrayInputStream(input.getBytes());

                    parser.parse(is, this);
                }
                    break;

                case CODE_INPUTTYPE_FILE: {
                    File file = new File(input);
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
