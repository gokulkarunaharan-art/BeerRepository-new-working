package guru.springframework.spring7restmvc.services;


import guru.springframework.spring7restmvc.csv.BeerCSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public interface BeerCSVService {
    public List<BeerCSVRecord> convertCSV(File CSVFile) throws FileNotFoundException;
}
