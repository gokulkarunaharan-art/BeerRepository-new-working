package guru.springframework.spring7restmvc.services;

import com.opencsv.bean.CsvToBeanBuilder;
import guru.springframework.spring7restmvc.csv.BeerCSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class BeerCSVServiceImpl implements BeerCSVService {
    @Override
    public List<BeerCSVRecord> convertCSV(File CSVFile) throws FileNotFoundException {
        List<BeerCSVRecord> beerCSVRecords = new CsvToBeanBuilder<BeerCSVRecord>(new FileReader(CSVFile))
                .withType(BeerCSVRecord.class)
                .build().parse();
        return  beerCSVRecords;
    }
}
