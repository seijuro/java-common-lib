package com.github.seijuro.common.scrap.publicdata.address;

import org.junit.Test;

import java.io.File;

public class LegalDongAddressReaderTest {
    @Test
    public void testReader() {
        File file = new File(getClass().getClassLoader().getResource("file/legal-dong-addr.txt").getFile());
        int countAvailable = 0;
        int countUnavailable = 0;

        try {
            LegalDongAddressReader reader = new LegalDongAddressReader(file);
            LegalDongAddress address = null;

            while ((address = reader.readAddress()) != null) {
                assert (address instanceof LegalDongAddress);

                LegalDongAddressCode code = address.getCode();
                String text = address.getText();
                LegalDongAddressStatus status = address.getStatus();

                if (status == LegalDongAddressStatus.AVAILABLE) { ++countAvailable; }
                else { ++countUnavailable; }
            }
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        System.out.println("Total count (available) : " + countAvailable);
        System.out.println("Total count (unavailable) : " + countUnavailable);
    }
}
