package cz.zk.volumetests.service;

import cz.zk.volumetests.exception.fileNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Calendar;

@Slf4j
@Component
public class MainService {
    /**
     *
     * @param fileName
     * @return
     * @throws fileNotFoundException
     */
    public String readFile(String fileName) throws fileNotFoundException {
        String InputLine, res = "";
        log.info("  Testing file: " + fileName);
        try {
            BufferedReader vstup = new BufferedReader(new FileReader(fileName));
            while((InputLine = vstup.readLine()) != null) {
                res += InputLine;
            }
            vstup.close();
        }
        catch(Exception ex) {
            throw new fileNotFoundException(ex.getMessage());
        }
        return res;
    }

    /**
     *
     * @param fileName
     * @return
     * @throws fileNotFoundException
     */
    public String createFile(String fileName) throws fileNotFoundException {
        log.info("  Creating a file: " + fileName);
        try {
            String fn = "/zk/data/" + fileName;
            log.info("    Complete path: " + fn);
            PrintWriter vystup = new PrintWriter(new FileOutputStream(fn));
            Calendar cal = Calendar.getInstance();
            String msg = String.format("%d.%d. %02d:%02d",
                    cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH)+1, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
            log.info("   current time: " + msg);
            vystup.println(msg);
            vystup.close();
            return msg;
        }
        catch(Exception ex) {
            throw new fileNotFoundException(ex.getMessage());
        }
    }


}
