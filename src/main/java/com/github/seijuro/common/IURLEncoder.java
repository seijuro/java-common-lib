package com.github.seijuro.common;

import java.io.UnsupportedEncodingException;

public interface IURLEncoder {
    String encode(String url) throws UnsupportedEncodingException;
}
