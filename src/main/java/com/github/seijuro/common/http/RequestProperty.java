package com.github.seijuro.common.http;

import lombok.AccessLevel;
import lombok.Getter;

public class RequestProperty {
    private static final String Unknown = "Unknown";

    public static class UserAgent {
        @Getter(AccessLevel.PUBLIC)
        static final String propertyName = "User-Agent";
    }

    public static class Referer {
        @Getter(AccessLevel.PUBLIC)
        static final String propertyName = "Referer";
    }

    public static class AcceptLanguage {
        @Getter(AccessLevel.PUBLIC)
        static final String propertyName = "Accept-Language";

        public static final String EN_US = "en-US,en;q=0.5";
    }

    public static class ContentType {
        @Getter(AccessLevel.PUBLIC)
        static final String propertyName = "Content-Type";

        public enum Text {
            UNKNOWN(Unknown),
            PLAIN("text/plain"),
            HTML("text/html"),
            CSS("text/css"),
            JS("text/javascript");

            @Getter
            private final String text;

            Text(String text) {
                this.text = text;
            }

            public static Text toText(String text) {
                if (PLAIN.text.equalsIgnoreCase(text)) {
                    return PLAIN;
                }
                else if (HTML.text.equalsIgnoreCase(text)) {
                    return HTML;
                }
                else if (CSS.text.equalsIgnoreCase(text)) {
                    return CSS;
                }
                else if (JS.text.equalsIgnoreCase(text)) {
                    return JS;
                }

                return UNKNOWN;
            }
        }

        public enum Image {
            UNKNOWN(Unknown),
            GIF("image/gif"),
            PNG("image/png"),
            JPEG("image/jpeg"),
            BMP("image/bmp"),
            WEBP("image/webp");

            @Getter
            private final String text;

            Image(String text) {
                this.text = text;
            }

            public static Image toImage(String text) {
                if (GIF.text.equalsIgnoreCase(text)) {
                    return GIF;
                }
                else if (PNG.text.equalsIgnoreCase(text)) {
                    return PNG;
                }
                else if (JPEG.text.equalsIgnoreCase(text)) {
                    return JPEG;
                }
                else if (BMP.text.equalsIgnoreCase(text)) {
                    return BMP;
                }
                else if (WEBP.text.equalsIgnoreCase(text)) {
                    return WEBP;
                }

                return UNKNOWN;
            }
        }

        public enum Audio {
            UNKNOWN(Unknown),
            MIDI("audio/midi"),
            MPEG("audio/mpeg"),
            WEBM("audio/webm"),
            OGG("audio/ogg"),
            WAVE("audio/wave"),
            WAV("audio/wav"),
            X_WAV("audio/x-wav"),
            X_PN_WAV("audio/x-pn-wav");

            @Getter
            private final String text;

            Audio(String text) {
                this.text = text;
            }

            public static Audio toAudio(String text) {
                if (MIDI.text.equalsIgnoreCase(text)) {
                    return MIDI;
                }
                else if (MPEG.text.equalsIgnoreCase(text)) {
                    return MPEG;
                }
                else if (WEBM.text.equalsIgnoreCase(text)) {
                    return WEBM;
                }
                else if (OGG.text.equalsIgnoreCase(text)) {
                    return OGG;
                }
                else if (WAVE.text.equalsIgnoreCase(text)) {
                    return WAVE;
                }
                else if (WAV.text.equalsIgnoreCase(text)) {
                    return WAV;
                }
                else if (X_WAV.text.equalsIgnoreCase(text)) {
                    return X_WAV;
                }
                else if (X_PN_WAV.text.equalsIgnoreCase(text)) {
                    return X_PN_WAV;
                }

                return UNKNOWN;
            }
        }

        public static class Video {
            public static final String WEBM = "video/webm";
            public static final String OGG = "video/ogg";
        }

        public static class Application {
            public static final String OCTET_STREAM = "application/octet-stream";
            public static final String PKCS12 = "application/pkcs12";
            public static final String VND_MSPPT = "application/vnd.mspowerpoint";
            public static final String XHTML_XML = "application/xhtml+xml";
            public static final String XML = "application/xml";
            public static final String JSON = "application/json";
            public static final String PDF = "application/pdf";
        }
    }
}
