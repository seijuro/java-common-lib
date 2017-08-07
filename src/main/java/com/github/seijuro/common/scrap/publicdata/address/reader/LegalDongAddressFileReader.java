package com.github.seijuro.common.scrap.publicdata.address.reader;

import com.github.seijuro.common.scrap.publicdata.address.LegalDongAddress;
import com.github.seijuro.common.scrap.publicdata.address.LegalDongAddressCode;
import com.github.seijuro.common.scrap.publicdata.address.LegalDongAddressStatus;

import java.io.*;

public class LegalDongAddressFileReader {
    /**
     * Instance Properties
     */
    private BufferedReader br;

    /**
     * C'tor
     *
     * @param filepath
     * @throws NullPointerException
     * @throws FileNotFoundException
     */
    public LegalDongAddressFileReader(String filepath) throws NullPointerException, FileNotFoundException {
        this(new File(filepath));
    }

    /**
     * C'tor
     *
     * @param file
     * @throws NullPointerException
     * @throws FileNotFoundException
     */
    public LegalDongAddressFileReader(File file) throws NullPointerException, FileNotFoundException {
        this.br = new BufferedReader(new FileReader(file));
    }


    /**
     * close
     *
     * @throws IOException
     */
    public void close() throws IOException {
        if (br != null) {
            try {
                br.close();
            }
            finally {
                br = null;
            }
        }
    }

    public LegalDongAddress readAddress() throws IOException {
        boolean readNext = true;

        do {
            String line = br.readLine();
            readNext = false;

            if (line == null) {
                return null;
            }


            String[] tokens = line.split("\\s+");
            int length = tokens.length;

            if (length < 3) {
                System.err.println("Illegal address : " + line);
                readNext = true;
            }
            else {
                String _code = tokens[0];
                String _status = tokens[length - 1];
                StringBuffer sb = new StringBuffer(tokens[1]);

                for (int index = 2; index < length - 1; ++index) {
                    sb.append(" ").append(tokens[index]);
                }

                LegalDongAddressCode code = LegalDongAddressCode.parse(_code);
                LegalDongAddressStatus status = LegalDongAddressStatus.parse(_status);

                return new LegalDongAddress(code, sb.toString(), status);
            }
        } while (readNext);

        return null;
    }
}
