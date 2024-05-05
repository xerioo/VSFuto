package GDE.futo;

import jakarta.persistence.*;

import java.util.concurrent.TimeUnit;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int runner;
    private int competition;
    private long resultInMillisec;

    public int getRunner() {
        return runner;
    }

    public void setRunner(int runner) {
        this.runner = runner;
    }

    public int getCompetition() {
        return competition;
    }

    public void setCompetition(int competition) {
        this.competition = competition;
    }

    public long getResultInMillisec() {
        return resultInMillisec;
    }

    public void setResultInMillisec(long resultInMillisec) {
        this.resultInMillisec = resultInMillisec;
    }
    
    public long timeToMs (int hr, int min, int sec, int ms) {
        return ((((hr*60+min)*60+sec)*1000)+ms);
    }
    
    public String msToTime (long msTime) {
        long hr = TimeUnit.MILLISECONDS.toHours(msTime);
        long min = TimeUnit.MILLISECONDS.toMinutes(msTime) %60;
        long sec = TimeUnit.MILLISECONDS.toSeconds(msTime) %60;
        long ms = TimeUnit.MILLISECONDS.toMillis(msTime) %1000;
        return String.format("%02d:%02d:%02d.%03d", hr, min, sec, ms);
    }
}
