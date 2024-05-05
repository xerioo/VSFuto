package GDE.futo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GDE.futo.DatabaseConnection;
import GDE.futo.FutoApplication;
import GDE.futo.Runner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RunnerService {

    @Autowired
    public List<Runner> getRunnersByCompetition(int id) {
            String sql = "SELECT * FROM RUNNERDB INNER JOIN RESULTDB on RUNNERDB.ID=RESULTDB.RUNNER " + 
                                "where RESULTDB.COMPETITION=" + id +
                                " ORDER BY RESULTDB.TIME";       
            DatabaseConnection.getQuery(sql);
            List<Runner> runners = FutoApplication.runners;
        return runners;
    }
}