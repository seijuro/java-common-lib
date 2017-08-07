package com.github.seijuro.common.scrap.publicdata.address;

import com.github.seijuro.common.field.value.IBoolFieldValue;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

@ToString
public class LegalDongAddress {
    /**
     * Instance Properties
     */
    @Getter(AccessLevel.PUBLIC)
    public final LegalDongAddressCode code;
    @Getter(AccessLevel.PUBLIC)
    public final String text;
    @Getter(AccessLevel.PUBLIC)
    public final LegalDongAddressStatus status;

    /**
     * C'tor
     *
     * @param $code
     * @param $text
     * @param $status
     */
    public LegalDongAddress(LegalDongAddressCode $code, String $text, LegalDongAddressStatus $status) {
        this.code = $code;
        this.text = $text;
        this.status = $status;
    }


}
